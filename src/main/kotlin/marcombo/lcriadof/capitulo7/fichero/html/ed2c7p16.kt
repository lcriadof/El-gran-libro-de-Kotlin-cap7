/*
El gran libro de Kotlin (segunda edición)
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 7: FICHEROS
 */

package marcombo.lcriadof.capitulo7.fichero.html

import marcombo.lcriadof.capitulo7.fichero.DirectorioBase
import marcombo.lcriadof.capitulo7.fichero.recurso.Companion.logging
import java.io.File
import java.net.URL


// Tecnica: Web scraping o raspado web

fun main() {
    // variables para definir el nombre del fichero local y el directorio

    var nombreFicheroOut:String="ofertaskotlin.html"

    // bloque introducido en segunda edicion
    val directorio = DirectorioBase() // Crear una instancia de la clase
    directorio.getDirectoriosAbsoluto("./json/").let { resultado ->
        if (resultado == 0) directorio.directorioAbsolutoBase else return
    }
    logging.info("Recurso encontrado en: ${directorio.directorioAbsolutoBase}") // segunda edicion
    //  fin del nuevo bloque segunda edicion



    // buscamos trabajos en java
    val fuente = URL("https://www.tecnoempleo.com/ofertas-trabajo/?te=kotlin&pr=263#buscador-ofertas")  // 1
    val destino = File(directorio.directorioAbsolutoBase, nombreFicheroOut)  // 2
    destino.writeBytes(fuente.readBytes()) // 3

}//