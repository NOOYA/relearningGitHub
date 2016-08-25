package com.nooya.nlp.proc

import org.scalatest.FlatSpec


class MorphologicalTest extends FlatSpec {

  "Tokenizer" should "tokenize document" in {
    val document = "こんにちは、聞くところによるとすもももももももものうちらしいですよ。"
    val tokenized = Morphological.splitInTokens(document)
    assert(tokenized.size > 0)
  }

  "createVector" should "createVector from string" in{
    val vect = Morphological.createDocumentVector("usbの書き込み権限付与の申請方法について知りたい。")
    vect.foreach(println)
    assert(vect.activeSize == 1000)
  }
}