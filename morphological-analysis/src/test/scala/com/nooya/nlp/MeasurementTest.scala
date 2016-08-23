package com.nooya.nlp

import breeze.linalg.{DenseMatrix, DenseVector, diag}
import org.scalatest.FlatSpec

import scala.com.nooya.nlp.Measurement

/**
  * Created by kumagaiy on 2016/08/23.
  */
class MeasurementTest extends FlatSpec{
  "nearestDocument" should "return index and score" in{
    val docTopicMatrix = DenseMatrix((-0.9571, -0.2898, 0.0),(-0.2898, 0.9571, 0.0))
    val singularMatirx =diag(DenseVector(4.1486,1.6700,0.0))
    val topicTermMatrix = DenseMatrix((-0.5313,0.2261,-0.8165),(0.5313,-0.2261,-0.4082),(-0.5313,0.2261,0.4082),(-0.3916,-0.9202,-0.0))
    val sampleDocTermVector = DenseVector(1.0,-1.0,1.0,-1.0)
    val tops = Measurement.nearestDocument(docTopicMatrix,singularMatirx,topicTermMatrix,sampleDocTermVector,2)
    tops
  }

}
