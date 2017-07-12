package yadfc.actors.config.dwarf

import yadfc.language.{Name,GivenName,FamilyName}

object NameGeneratorTest {
  def main(args:Array[String]):Unit = {
    val names:List[Name] = List.fill[Name](50){
      if (scala.util.Random.nextBoolean()) {
        NameGenerator.genGivenName(Lexicon.vocabulary)
      } else {
        NameGenerator.genSurName(Lexicon.verbs, Lexicon.nouns)
      }
    }
    
    names.map(n => {
      println(n.toString() + " (" + n.getClass.getSimpleName() + ") - " + n.translate())
      
      if (n.isInstanceOf[GivenName]) {
        val dc = n.asInstanceOf[GivenName] 
        
        println("\tFirst Name Part: " + dc.first.value() + ", " + dc.first.getClass.getSimpleName() + ": " + dc.first.translate())
        println("\tSecond Name Part: " + dc.second.value() + ", " + dc.second.getClass.getSimpleName() + ": " + dc.second.translate())
      } else {
        val dc = n.asInstanceOf[FamilyName]
        
        println("\tFirst Name Part: " + dc.first.value() + ", " + dc.first.getClass.getSimpleName() + ": " + dc.first.translate())
        println("\tSecond Name Part: " + dc.second.value() + ", " + dc.second.getClass.getSimpleName() + ": " + dc.second.translate())
      }
    })
  }
}