package com.garner.tool.parser

import java.io.File

/** Reader type extends iterator */
trait Reader[T] extends Iterator[T] {
  
  /** returns file header line*/
  def getHeader:Option[T]
  
  /** gets next row in the file*/
  def next:T
  
  /** true or false if next row is available  */
  def hasNext:Boolean
  
  /** closes file handlers */
  def close:Unit
}

/** get CSV file reader  */
object CSVFileReader{
  def apply(filename:String,hasHeaders:Boolean):Reader[List[String]]={
    new CSVReader(new File(filename),hasHeaders)
  }
}


object TestCSVReader extends App{
  
  val rowSource = CSVFileReader("/Users/Komatreddy/Documents/workspace/Garner/testData/materials.csv",true)
  
  while(rowSource.hasNext){
    val row = rowSource.next
    println(row)
  }  
}