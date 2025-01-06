/*
El gran libro de Kotlin
EDICION 2
(para programadores de back end y científicos de datos)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 7: FICHEROS
 */

package marcombo.lcriadof.capitulo7.fichero// c7p1.kt   gestion de logs
import org.apache.logging.log4j.LogManager


class pruebaLog {
    companion object {
        val logging = LogManager.getLogger() // 1
    }
    fun mostrar(){ // 2
        logging.error("Hola mundo!")
        logging.warn("Hola mundo!")
        logging.fatal("Hola mundo!")
        logging.debug("Hola mundo!")
        logging.trace("Hola mundo!")
        logging.info("Hola mundo!")
    }
}

fun main() {
    var prueba = pruebaLog()   // 3
    prueba.mostrar()  // 4
}
