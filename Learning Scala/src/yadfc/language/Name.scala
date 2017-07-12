package yadfc.language

abstract class Name(first:Word, second:Word) extends Word {
  val root:String = this.first.value().capitalize + this.second.value()
  val translation:String = this.first.translate().capitalize + this.second.translate()
  
  override def toString():String = this.root
  override def value() = this.toString()
  override def translate():String = this.translation
  
  override def equals(that:Any):Boolean = that match {
      case that:Word => this.toString() == that.value()
      case that:String => this.toString() == that
      case _ => false
    }
}
case class GivenName(first:Word, second:Word) extends Name(first, second)
case class FamilyName(first:Verb, second:Noun) extends Name(first, second)