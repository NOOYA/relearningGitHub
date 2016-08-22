package com.kuma.nlp
import org.atilika.kuromoji.{Tokenizer}
import scala.collection.JavaConversions._
import com.typesafe.config.ConfigFactory

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
}
