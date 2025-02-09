/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 7: FICHEROS
 */

package marcombo.lcriadof.capitulo7.fichero.json

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import marcombo.lcriadof.capitulo7.fichero.recurso.Companion.logging
import marcombo.lcriadof.capitulo7.fichero.DirectorioBase
import java.io.File
import java.net.URL

fun main(){

    // limpiamos el fichero que hay en la Web y lo salvamos a disco local
    val ficheroMunicipiosJSON
    ="https://datos.comunidad.madrid/catalogo/dataset/0781c37e-bc64-4143-8029-18865bedbc3d/resource/17feaf92-8749-44e4-a81c-6abee0df52e4/download/municipio_comunidad_madrid.json"



    var fichIn1= URL(ficheroMunicipiosJSON).readText() //[1]
    val fichIn2 = "[\n"+fichIn1.toString().subSequence(14, fichIn1.length-3)+"\n]" // [2]

    // bloque introducido en segunda edicion
    val directorio = DirectorioBase() // Crear una instancia de la clase
    directorio.getDirectoriosAbsoluto("./json/").let { resultado ->
        if (resultado == 0) directorio.directorioAbsolutoBase else return
    }
    logging.info("Recurso encontrado en: ${directorio.directorioAbsolutoBase}") // segunda edicion
    //  fin del nuevo bloque segunda edicion



    File("${directorio.directorioAbsolutoBase}municipios.json").writeText(fichIn2.toString(), Charsets.UTF_8) // [3]

    // leemos el fichero del disco local y lo cargamos en memoria
    var contenido:String=""
    try {
        var lines: List<String> = File("${directorio.directorioAbsolutoBase}municipios.json").readLines() // [4] segunda edicion
        lines.forEach{it -> contenido=contenido+it   } // [5]
    }catch(e:Exception){
        e.printStackTrace()
    }finally {
        println(contenido) // [6]
        println("--------  JSON leido")
    }

    val gson = GsonBuilder().setPrettyPrinting().create() // [7]

    // lectura del fichero JSON que tenemos en memoria en la variable contenido de tipo String
    val listaMunicipiosEntrada: Array<Municipios> =
        gson.fromJson(contenido, object : TypeToken<Array<Municipios>>() {}.getType()) // [8]

    listaMunicipiosEntrada.forEach({ it: Municipios? -> println(it?.municipio_nombre +
            " tiene una densidad por km2 de "+it?.densidad_por_km2) }) // [9]


}


