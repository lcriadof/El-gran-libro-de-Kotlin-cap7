/*
El gran libro de Kotlin
EDICION 2
(para programadores de back end y científicos de datos)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 7: FICHEROS
 */

package marcombo.lcriadof.capitulo7.fichero
import marcombo.lcriadof.capitulo7.fichero.recurso.Companion.logging // 1
/* el import nos permite recuperar “logging” de la clase Companion Object definida en ed2c7p26.kt */

fun main() {
    logging.error("¡Hola mundo!")
    logging.warn("Hola mundo!")
    logging.fatal("Hola mundo!")
    logging.debug("Hola mundo!")
    logging.trace("Hola mundo!")
    logging.info("Hola mundo!")
}
