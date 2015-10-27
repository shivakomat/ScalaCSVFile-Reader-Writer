package com.garner.tool.parser

import java.io.File

trait Writer[T] {
    def writeHeader(header:T)
	def write(data:T)
	def close
}


object CSVFileWriter{
  def apply(filename:String):Writer[List[String]]={
    new CSVWriter(new File(filename))
  }
}