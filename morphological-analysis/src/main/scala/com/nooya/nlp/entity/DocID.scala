package com.nooya.nlp.entity

import com.nooya.nlp.util.FileUtils

/**
  * Created by kumagaiy on 2016/08/25.
  */
class DocID(val docIDMap:Map[String,Long],val iDDocMap:Map[Long,String])  {

}
object DocID{
  def apply(path:String): DocID ={
    val lines = FileUtils.readInLines(path)
    val idDocMap:Map[Long,String]= lines.map(line=>line.replaceAll("""^\((.*)\)$""","""$1""").split(",")).map(x=>(x(0).toLong,x(1))).toMap
    val idDocMapx:(Map[Long,String],Map[String,Long])= lines.map(line=>line.replaceAll("""^\((.*)\)$""","""$1""").split(",")).map(x=>(x(0).toLong,x(1))).foldLeft((Map[Long,String](), Map[String,Long]()))((m,d)=>{
      (m._1+(d._1->d._2),m._2+(d._2-> d._1))
    }
    )
    new DocID(idDocMapx._2,idDocMapx._1)
  }
}