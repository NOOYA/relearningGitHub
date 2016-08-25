package com.nooya.nlp.entity

import org.scalatest.FlatSpec

/**
  * Created by kumagaiy on 2016/08/25.
  */
class TermIDTest extends FlatSpec{
  "TermID" should "has a ID to Term map" in{
    val tmid = TermID("C:\\Users\\kumagaiy\\Documents\\projects\\adtech\\relearningGitHub\\morphological-analysis\\src\\test\\resources\\termIdsRdd.txt")
    assert(tmid.iDTermMap(1) == "メディア")
    assert(tmid.iDTermMap(529) == "事項")
    assert(tmid.iDTermMap(645) == "client")
    assert(tmid.iDTermMap(266) == "進める")
    assert(tmid.iDTermMap(577) == "そこで")
    assert(tmid.iDTermMap(972) == "席")
  }

  "TermID" should "has a Term to ID map" in{
    val tmid = TermID("C:\\Users\\kumagaiy\\Documents\\projects\\adtech\\relearningGitHub\\morphological-analysis\\src\\test\\resources\\termIdsRdd.txt")
    assert(tmid.termIDMap("題") ==562)
    assert(tmid.termIDMap("ログイン") ==694)
    assert(tmid.termIDMap("client") ==645)
    assert(tmid.termIDMap("席") ==972)
    assert(tmid.termIDMap("考える") ==100)

  }
}
