package com.nooya.nlp

import org.scalatest.FlatSpec

import scala.com.nooya.nlp.Morphological

class MorphologicalTest extends FlatSpec {

  "Tokenizer" should "tokenize document" in {
    val document = "こんにちは、聞くところによるとすもももももももものうちらしいですよ。"
    val tokenized = Morphological.splitInTokens(document)
    assert(tokenized.size > 0)
  }
}