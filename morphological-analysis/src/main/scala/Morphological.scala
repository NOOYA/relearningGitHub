import org.atilika.kuromoji.{Tokenizer,Token};
import scala.collection.JavaConversions._

/**
  * Created by kumagaiyuuya on 8/21/16.
  */
object Morphological {
  val tokenizer = Tokenizer.builder().userDictionary("/Users/kumagaiyuuya/Developments/scala/relearningGitHub/morphological-analysis/src/main/scala/userDictionary.txt1").build()
  def splitInTokens(documents:Seq[String]):Seq[String]={
    documents.map(d=>splitInTokens(d))
  }

  def splitInTokens(document:String):String= {
    val tokens = tokenizer.tokenize(document).foldLeft("")((merged , token:Token) =>{
      merged + ( token.getBaseForm)
    })
    tokens
  }
}
