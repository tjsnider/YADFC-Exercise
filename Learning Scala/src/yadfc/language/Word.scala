package yadfc.language

abstract class Word extends Ordered[Word] {
  def value():String
  def translate():String

  def compare(that: Word):Int = this.value.compare(that.value())
}

case class Noun(root:String, prefix:Option[String], suffix:Option[String], translation:String) extends Word with ComplexWord
case class Adjective(root:String, prefix:Option[String], suffix:Option[String], translation:String) extends Word with ComplexWord
case class Adverb(root:String, prefix:Option[String], suffix:Option[String], translation:String) extends Word with ComplexWord
case class Verb(root:String, prefix:Option[String], suffix:Option[String], translation:String) extends Word with ComplexWord
case class Pronoun(root:String, translation:String) extends Word with SimpleWord
case class Preposition(root:String, translation:String) extends Word with SimpleWord
case class Conjunction(root:String, translation:String) extends Word with SimpleWord
case class Determiner(root:String, translation:String) extends Word with SimpleWord
case class Interjection(root:String, translation:String) extends Word with SimpleWord
