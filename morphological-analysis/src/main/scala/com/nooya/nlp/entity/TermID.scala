package com.nooya.nlp.entity

import com.nooya.nlp.util.FileUtils

/**
  * Created by kumagaiy on 2016/08/25.
  */
class TermID(val termIDMap:Map[String,Long],val iDTermMap:Map[Long,String]) {

}

object TermID{
  def apply(path:String): TermID ={
    val lines = FileUtils.readInLines(path)
    val idTermMap:Map[Long,String]= lines.map(line=>line.replaceAll("""^\((.*)\)$""","""$1""").split(",")).map(x=>(x(0).toLong,x(1))).toMap
    val idTermMapx:(Map[Long,String],Map[String,Long])= lines.map(line=>line.replaceAll("""^\((.*)\)$""","""$1""").split(",")).map(x=>(x(0).toLong,x(1))).foldLeft((Map[Long,String](), Map[String,Long]()))((m,d)=>{
      (m._1+(d._1->d._2),m._2+(d._2-> d._1))
    }
    )
    new TermID(idTermMapx._2,idTermMapx._1)
  }
}