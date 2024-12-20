/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 7: FICHEROS
 */

package marcombo.lcriadof.capitulo7.fichero.excel

import com.opencsv.CSVParserBuilder
import com.opencsv.CSVReader
import com.opencsv.CSVReaderBuilder
import marcombo.lcriadof.capitulo7.fichero.recursos
import java.io.File
import java.io.FileReader

fun main(){
    var url= recursos::class.java.getResource("/excelcsv/").path
    var entrada= File(url+"municipio_comunidad_madrid.csv")
    // este fichero ha sido descargado de
    //   https://datos.comunidad.madrid/catalogo/dataset/municipio_comunidad_madrid


    if (entrada.exists()){ // [1]
       // val reader = CSVReader(FileReader(entrada.getAbsolutePath()),  ';') // [2]

        // Crea un CSVParser con el separador ';'   // [2]
        val csvParser = CSVParserBuilder()
            .withSeparator(';')
            .build()

        // Crea un CSVReader usando el parser
        val reader = CSVReaderBuilder(FileReader(entrada.absolutePath))
            .withCSVParser(csvParser)
            .build()



        var filas= reader.iterator(); // [3]
        var fichcsv: MutableList<String> = mutableListOf() // [4]
        for (i in filas){ // [5]
            fichcsv.clear() // [6] borramos todo lo anterior cargado en la lista mutable
            fichcsv.addAll(i) // [7]  cargamos una linea del CSV en la lista
            for (j in fichcsv){
                println(  j )  // [8] visualizamos cada elemento por fila  (por registro) CSV
            }
            println("----- X ------" ) // nueva linea del CSV
            // println(  fichcsv.joinToString() ) // esto es una linea completa junta, sin separar
        }
        reader.close() // [9]
    }

}