package com.nooya.nlp.proc

import breeze.linalg.DenseVector
import com.nooya.nlp.entity.TermID
import com.typesafe.config.ConfigFactory
import org.atilika.kuromoji.Tokenizer

import scala.collection.JavaConversions._

/**
  * Created by kumagaiyuuya on 8/21/16.
  */
object Morphological {
  val configs = ConfigFactory.load()
  val tokenizer = Tokenizer.builder().userDictionary(configs.getString("morphological.userDictionaryPath")).build()
  val stopWords = configs.getStringList("morphological.stopwords")
  def splitInTokens(documents:Seq[String]):Seq[String]={
    documents.map(d=>splitInTokens(d))
  }

  def splitInTokens(document:String):String= {
    tokenizer.tokenize(document).foldLeft("")((t,term)=>{
      if(term.getAllFeaturesArray.apply(1)=="カスタム名詞"){
        t + term.getSurfaceForm + "\t"
      }
      else if(term.getAllFeaturesArray.apply(0)=="名詞"&&((term.getAllFeaturesArray.apply(2)=="人名")|| (term.getAllFeaturesArray.apply(2)=="地名"))){
        println("skip 人名地名:"+term.getSurfaceForm)
        t
      }
      else if( term.getBaseForm!=null  && (term.getAllFeaturesArray.apply(0)!= "非自立" )
        && !stopWords.contains(term.getBaseForm)) {
        t + term.getBaseForm + "\t"
      }
      else{
        println("skip:"+term.getSurfaceForm)
        t
      }
    })
  }

  def createDocumentVector(docString:String): DenseVector[Double] ={

    val terms= splitInTokens(docString).split("\t")
    val temFreq = terms.foldLeft(Map[String,Double]())((m,t) =>{
      (m + (t -> (m.getOrElse(t,0.0) +1.0) / terms.size.toDouble ))
    })
    val termId = TermID("C:\\Users\\kumagaiy\\Downloads\\spark_downloads\\termIdsRdd.txt\\part-00000")
    val df = DenseVector(
      termId.iDTermMap.toSeq.sortBy(x=>x._1).foldLeft(Seq[Double]())((s,tm)=>{
       val score = temFreq.getOrElse(tm._2, 0.0)
        if(score!=0.0){
          println("keyword found!:" + tm + score)
        }
      s :+ (score)
    }).toArray)
    df
  }
}
