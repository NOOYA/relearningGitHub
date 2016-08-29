package com.nooya.nlp.proc

import breeze.linalg.{DenseMatrix, DenseVector, Transpose, inv, normalize, pinv}
import com.nooya.nlp.entity.{MatrixU, MatrixV, VectorD}
import com.nooya.nlp.util.FileUtils

/**
  * Created by kumagaiy on 2016/08/23.
  */
object Measurement {
  def nearestDocument(docTopicMatrix:DenseMatrix[Double], singularMatirx:DenseMatrix[Double], topicTermMatrix:DenseMatrix[Double], sampleDocTermVector:DenseVector[Double], listNum:Int):Seq[(Int,Double)] ={
    val VdotICig = topicTermMatrix * pinv(singularMatirx)
    val topicVector =( (sampleDocTermVector.asDenseMatrix) * VdotICig).apply(0,::)

    val vecs:Seq[(Int,Transpose[breeze.linalg.DenseVector[Double]])] = (0 to docTopicMatrix.rows-1).map(x => (x ,docTopicMatrix(x,::)))
    // vecs.map{case (v1:Int,v2:Transpose[DenseVector[Double]])  => (v1, (v2 dot topicVector))}.take(listNum)
    vecs.map(x=>(x._1,normalize(x._2) dot normalize(topicVector))).sortBy(x => -x._2).take(listNum)
  }

  def nearestDocument(docTopicMatrixPath:String, singularMatirxPath:String, topicTermMatrixPath:String, idfPath:String, sampleTxt:String, topCount:Int):Seq[(Int,Double)] ={
    val docTopicMatrix = MatrixU(docTopicMatrixPath).coreMatrix
    val singularMatirx = VectorD(singularMatirxPath).toDiagMatrix
    val topicTermMatrix= MatrixV(topicTermMatrixPath).coreMatrix
    val idf =FileUtils.readInLines(idfPath).map(x=>x.replaceAll("""^\((.*)\)$""","""$1""").split(",")(1).toDouble).toArray
    val sampleVect = Morphological.createDocumentVector(sampleTxt)
    val dfidf=(0 until sampleVect.activeSize).foldLeft(Seq[Double]())((seq,index)=>{
        seq :+ sampleVect(index)*idf(index)
    }).toArray
    nearestDocument(docTopicMatrix,singularMatirx,topicTermMatrix, DenseVector(dfidf) ,topCount)
  }
}
