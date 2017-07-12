package yadfc.language

trait ComplexWord extends SimpleWord {
  val prefix:Option[String]
  val suffix:Option[String]
  
  override def value() = this.prefix.getOrElse("") + this.root + this.suffix.getOrElse("")
}
