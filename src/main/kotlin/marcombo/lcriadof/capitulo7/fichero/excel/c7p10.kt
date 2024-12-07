/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 7: FICHEROS
 */

package marcombo.lcriadof.capitulo7.fichero.excel

import com.opencsv.CSVParserBuilder
import com.opencsv.CSVReaderBuilder
import marcombo.lcriadof.capitulo7.fichero.recursos
import java.io.File
import java.io.FileReader

fun main(){

    var url= recursos::class.java.getResource("/excelcsv/").path
    var entrada= File(url+"municipio_comunidad_madrid.csv")
    if (entrada.exists()) { // [1]
        //val reader = CSVReader(FileReader(entrada.getAbsolutePath()), ';') // [2]  antiguo

        /*
        La clase CSVReader existía en versiones anteriores de OpenCSV, pero fue marcada como obsoleta y finalmente eliminada en versiones
        más recientes.
         En las versiones recientes de OpenCSV, el uso de CSVReader fue reemplazado por CSVParser y otras clases mejoradas. Puedes usar la clase CSVParserBuilder junto con un FileReader para leer el archivo CSV

         */
        // Crea un CSVParser con el separador ';'   // [2]
        val csvParser = CSVParserBuilder()
            .withSeparator(';')
            .build()

        // Crea un CSVReader usando el parser
        val reader = CSVReaderBuilder(FileReader(entrada.absolutePath))
            .withCSVParser(csvParser)
            .build()



        val fichcsv: List<Array<String?>> = reader.readAll() // [3]
        reader.close() // [4]



        // puebas
        /*
        println(fichcsv.size)
        println(fichcsv.get(0).size)
        println(fichcsv.get(1).joinToString())
        println(fichcsv.get(1).get(0))
         */

        //[5]
        fichcsv.forEach( { d: Array<String?> -> d.forEach { f: String? -> println(f) }
                      println("----- X ------" ) // nueva linea del CSV
        } )
    }
}