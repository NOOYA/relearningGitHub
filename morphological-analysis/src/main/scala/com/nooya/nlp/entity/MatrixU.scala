package com.nooya.nlp.entity

import breeze.linalg.DenseMatrix
import com.nooya.nlp.util.FileUtils

/**
  * Created by kumagaiy on 2016/08/24.
  */
class MatrixU (val coreMatrix:DenseMatrix[Double]) {
  val rowSize = coreMatrix.rows
  val colSize =coreMatrix.cols
}
object MatrixU{
  def apply(path:String)={
    val lines = FileUtils.readInLines(path)
    val splitedLines = lines.map(line => line.split("\t").tail.map(x=>x.toDouble))
    val arrays:Array[Double] = splitedLines.flatten.toArray
    val columnNum = splitedLines(0).size
    // Doubleの配列になったがこれをマトリクスに移す際、列単位で読まれてしまうので、変換が必要
    // 列番号->値の順列のマップを作製
    val colValuesMap = arrays.zipWithIndex.foldLeft( Map[Int,Seq[Double]]())((m,doubles)=>{
      val seq = m.getOrElse(doubles._2%columnNum,Seq[Double]())
      m + (doubles._2%columnNum -> (seq:+  doubles._1))
    }
    )
    val transArray = colValuesMap.keys.toSeq.sortBy(x=>x).foldLeft(Seq[Double]())((seq, col)=>{
      seq++colValuesMap(col)
    }).toArray
    val dMtx:DenseMatrix[Double] = new DenseMatrix(splitedLines.size,columnNum, transArray)
    new MatrixU(dMtx)
  }
}