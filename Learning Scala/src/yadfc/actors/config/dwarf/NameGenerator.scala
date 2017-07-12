package yadfc.actors.config.dwarf

import yadfc.language._

object NameGenerator {
   def genGivenName(parts:Array[Word]):GivenName = {
     val random = scala.util.Random
     var first:Word = null
     do {
       first = parts(random.nextInt(parts.length))
     } while (!isLegalStart(first))
       
     var second:Word = null
     do {
       second = parts(random.nextInt(parts.length))
     } while (!isLegalPair(first,second))
     
     val name = GivenName(first,second)
     return name
   }
   
   def genSurName(verbs:Array[Verb],nouns:Array[Noun]):FamilyName = {
     val random = scala.util.Random
     val first = verbs(random.nextInt(verbs.length))
     val second = nouns(random.nextInt(nouns.length))
     
     val name = FamilyName(first,second)
     return name
   }
   
   def isLegalStart(first:Word):Boolean = {
    first match {
      case x @ (_:Adjective | _:Conjunction | _:Determiner | _:Preposition | _:Verb | _:Adverb | _:Pronoun) => true
      case _ => false
    }
   }
   
   def isLegalPair(first:Word, second:Word):Boolean = {
    first match {
      case x @ (_:Adjective | _:Conjunction | _:Determiner | _:Preposition) => second.isInstanceOf[Noun]
      case x:Verb => second.isInstanceOf[Adjective] || second.isInstanceOf[Noun]
      case x:Adverb => second.isInstanceOf[Adjective] || second.isInstanceOf[Verb] || second.isInstanceOf[Adverb]
      case x:Pronoun => second.isInstanceOf[Verb]
      case _ => false
    }
  }

}