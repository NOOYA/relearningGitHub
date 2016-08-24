package com.nooya.nlp.entity


import breeze.linalg.{DenseMatrix, DenseVector, diag}
import org.scalatest.FlatSpec

/**
  * Created by kumagaiy on 2016/08/23.
  */
class VectorDTest extends FlatSpec{
  "VectoreD" should "be create from textFile " in{
    val vecD:VectorD = VectorD("C:\\Users\\kumagaiy\\Documents\\projects\\adtech\\relearningGitHub\\morphological-analysis\\src\\test\\resources\\singulartVect.txt")
    assert(vecD.size == 5)
  }

  "VectoreD" should "has Double values that equal numbers in text" in{
    val vecD:VectorD = VectorD("C:\\Users\\kumagaiy\\Documents\\projects\\adtech\\relearningGitHub\\morphological-analysis\\src\\test\\resources\\singulartVect.txt")
    assert(vecD.coreVector(0) == 4.698693124472849)
    assert(vecD.coreVector(1) == 2.7589783658744356)
    assert(vecD.coreVector(2) == 2.421583936315817)
    assert(vecD.coreVector(3) == 2.3552739528169635)
    assert(vecD.coreVector(4) == 2.1127452742528745)
  }
}
