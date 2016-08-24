package com.nooya.nlp.proc

import breeze.linalg.{DenseMatrix, DenseVector, Transpose, inv, normalize, pinv}

/**
  * Created by kumagaiy on 2016/08/23.
  */
object Measurement {
  def nearestDocument(docTopicMatrix:DenseMatrix[Double], singularMatirx:DenseMatrix[Double], topicTermMatrix:DenseMatrix[Double], sampleDocTermVector:DenseVector[Double], listNum:Int) ={
    val VdotICig = topicTermMatrix * pinv(singularMatirx)
    val topicVector =( (sampleDocTermVector.asDenseMatrix) * VdotICig).apply(0,::)

     val vecs:Seq[(Int,Transpose[breeze.linalg.DenseVector[Double]])] = (0 to docTopicMatrix.rows-1).map(x => (x ,docTopicMatrix(x,::)))
    vecs.map{case (v1:Int,v2:Transpose[DenseVector[Double]])  => (v1, (v2 dot topicVector))}.take(listNum)
    vecs.map(x=>(x._1,normalize(x._2) dot normalize(topicVector))).sortBy(x => -x._2)
  }
}
