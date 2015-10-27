package com.garner.tool.parser

import java.io.File
import java.io.PrintWriter

sealed case class CSVWriter(file:File) extends Writer[List[String]]{
   private val writer = new PrintWriter(file)
   private val seperator = ","     
   
   def writeHeader(header:List[String]) = writer.write(header.mkString(seperator))
   
   def write(data:List[String]) = writer.write("\n"+data.mkString(seperator))
   
   def close = writer.close()
}



object TestCSVFileWriter extends App{
  val rowWriter = CSVFileWriter("/Users/Komatreddy/Documents/workspace/Garner/testData/sample.csv")
  rowWriter.writeHeader(List("id","description","weight(tons)","priority"))
  rowWriter.write(List("1","cement","15","1"))
  rowWriter.close
}