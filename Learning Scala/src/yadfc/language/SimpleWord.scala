package yadfc.language

trait SimpleWord extends Word {
  val root:String
  val translation:String
  
  override def value() = this.root
  override def translate() = this.translation
}
