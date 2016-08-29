package com.nooya.nlp.entity

import org.scalatest.FlatSpec

/**
  * Created by kumagaiy on 2016/08/23.
  */
class MatrixUTest extends FlatSpec{
  "VectoreD" should "be create from textFile " in{
    val mtV:MatrixU = MatrixU("C:\\Users\\kumagaiy\\Documents\\projects\\adtech\\relearningGitHub\\morphological-analysis\\src\\test\\resources\\MatrixU.txt")
    assert(mtV.colSize == 50)
    assert(mtV.rowSize == 8206)
  }

  "VectoreD" should "has Double values that equal numbers in text" in{
    val mtV:MatrixU = MatrixU("C:\\Users\\kumagaiy\\Documents\\projects\\adtech\\relearningGitHub\\morphological-analysis\\src\\test\\resources\\MatrixU.txt")
     // println(mtV.coreMatrix)
      assert(mtV.coreMatrix( 0,0) ==0.0036065457971923395)
      assert(mtV.coreMatrix( 1,0) ==0.025722233743874928)
      assert(mtV.coreMatrix( 2,0) ==0.004413422489782506)
      assert(mtV.coreMatrix( 3,0) ==0.003863129616359966)
      assert(mtV.coreMatrix( 4,0) ==0.0037218094469017166)
      assert(mtV.coreMatrix( 5,0) ==0.01713625891410083)
      assert(mtV.coreMatrix( 6,0) ==0.004009253922579836)
      assert(mtV.coreMatrix( 76,0) ==0.0034465337178496026)
    assert(mtV.coreMatrix( 8205,0) ==0.004002126454019596)

    assert(mtV.coreMatrix( 8062,6) == - 0.01358336260541582)
    assert(mtV.coreMatrix( 7975,49) ==0.0049454274834883245)
    assert(mtV.coreMatrix( 7751,48) ==0.002457201979071002)

  }
}
