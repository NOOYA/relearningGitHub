package com.nooya.nlp.entity

import breeze.linalg.{DenseVector, diag}
import com.nooya.nlp.util.FileUtils

/**
  * Created by kumagaiy on 2016/08/24.
  */
class VectorD(val coreVector:DenseVector[Double]) {
  def size = this.coreVector.activeSize
  def toDiagMatrix =diag(this.coreVector)
}

object VectorD{
  def apply(path:String) ={
    val dVect = DenseVector (FileUtils.readInLines(path).map(x=>x.toDouble).toArray)
    new VectorD(dVect)
  }
}