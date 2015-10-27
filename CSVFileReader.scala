package com.garner.tool.parser

import scala.io.Source
import java.io.File

sealed case class CSVReader(file:File,hasHeaders:Boolean) extends Reader[List[String]]{
   private val seperator = ","  
   private val src = Source.fromFile(file)
   private val lines = src.getLines
   private val headers = if(hasHeaders) Some(this.next) else None
   
   def getHeader:Option[List[String]] = headers
   
   override def hasNext:Boolean = lines.hasNext
   
   override def next:List[String] = lines.next.split(seperator).toList 
   
   def close:Unit = src.close
   
   
}







