package com.nooya.nlp.entity

import org.scalatest.FlatSpec

/**
  * Created by kumagaiy on 2016/08/23.
  */
class MatrixVTest extends FlatSpec{
  "VectoreD" should "be create from textFile " in{
    val mtV:MatrixV = MatrixV("C:\\Users\\kumagaiy\\Documents\\projects\\adtech\\relearningGitHub\\morphological-analysis\\src\\test\\resources\\MatrixV.txt")
    assert(mtV.colSize == 5)
    assert(mtV.rowSize == 10)
  }

  "VectoreD" should "has Double values that equal numbers in text" in{
    val mtV:MatrixV = MatrixV("C:\\Users\\kumagaiy\\Documents\\projects\\adtech\\relearningGitHub\\morphological-analysis\\src\\test\\resources\\MatrixV.txt")
     // println(mtV.coreMatrix)
    assert(mtV.coreMatrix(0,0) == -0.3355140729618006)
    assert(mtV.coreMatrix(1,0) == -0.3269386873508099)
    assert(mtV.coreMatrix(2,0) == -0.29412763225355043)
    assert(mtV.coreMatrix(3,0) == -0.43823957890755283)
    assert(mtV.coreMatrix(4,0) == -0.2688491869569223)
    assert(mtV.coreMatrix(5,0) == -0.2778093454067395)
    assert(mtV.coreMatrix(6,0) == -0.30466260409276913)
    assert(mtV.coreMatrix(7,0) == -0.29126291594285914)
    assert(mtV.coreMatrix(8,0) == -0.2548018288662588)
    assert(mtV.coreMatrix(9,0) == -0.3315737183935575)


    assert(mtV.coreMatrix(0,3) == 0.15563071248589888)
    assert(mtV.coreMatrix(1,3) == 0.1844409277961912)
    assert(mtV.coreMatrix(2,3) == 0.6233637830252561)
    assert(mtV.coreMatrix(3,3) == -0.006765577053302149)
    assert(mtV.coreMatrix(4,3) == -0.6244692023510393)
    assert(mtV.coreMatrix(5,3) == -0.1526625242860951)
    assert(mtV.coreMatrix(6,3) == 0.08521335240938394)
    assert(mtV.coreMatrix(7,3) == 0.11805730758247594	)
    assert(mtV.coreMatrix(8,3) == -0.1745767025731599)
    assert(mtV.coreMatrix(9,3) == -0.2969662389468817)
  }
}
