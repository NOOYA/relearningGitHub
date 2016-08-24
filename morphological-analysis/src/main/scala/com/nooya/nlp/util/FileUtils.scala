package com.nooya.nlp.util

/**
  * Created by kumagaiy on 2016/08/24.
  */
object FileUtils {
  /**
    *  指定のファイルを読み込んでListで返す
    * @param path
    * @return
    */
  def readInLines(path:String) = {
    io.Source.fromFile(path).getLines.toList
  }
}
