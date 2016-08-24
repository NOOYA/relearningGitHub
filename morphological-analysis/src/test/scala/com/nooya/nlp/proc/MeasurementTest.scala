package com.nooya.nlp.proc

import breeze.linalg.{DenseMatrix, DenseVector, diag}
import org.scalatest.FlatSpec


/**
  * Created by kumagaiy on 2016/08/23.
  */
class MeasurementTest extends FlatSpec{
  "nearestDocument" should "return index and score" in{
//    行列
//    ((2,  -2,  1, 1),
//    (5,  1,  4, 4))
    //を特異値分解した行列群
    // 新規に持ってきたベクトル(5,1,4,4)がどれに近いかを返す二行目と全く同じなので、最上位のスコアはほぼ1になるはず。
    val docTopicMatrix = DenseMatrix((-0.2898, -0.9571, 0.0),(-0.9571, 0.2898, 0.0))
    val singularMatirx =diag(DenseVector(7.9274,2.2706,0.0))
    val topicTermMatrix = DenseMatrix((-0.6768,-0.2049,-0.7071),(-0.0476,0.9707,-0.2357),(-0.5195,0.0890,0.4714),(-0.5195,0.0890,0.4714))
    val sampleDocTermVector = DenseVector(5.0,1.0,4.0,4.0)
    val tops = Measurement.nearestDocument(docTopicMatrix,singularMatirx,topicTermMatrix,sampleDocTermVector,2)
    assert((1 - (tops(0)._2)  < 0.1)&& (tops(0)._1 == 1))
  }
}
