/*
El gran libro de Kotlin (segunda edición)
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 7: FICHEROS
 */

package marcombo.lcriadof.capitulo7.fichero.json

import java.io.File
import java.net.URL


// Tecnica: Web scraping o raspado web

fun main() {
    // variables para definir el nombre del fichero local y el directorio
    var directorioBase:String="/tmp/kotlin/"
    var nombreFicheroOut:String="ofertaskotlin.html"

    // buscamos trabajos en java
    val fuente = URL("https://www.tecnoempleo.com/ofertas-trabajo/?te=kotlin&pr=263#buscador-ofertas")  // 1
    val destino = File(directorioBase, nombreFicheroOut)  // 2
    destino.writeBytes(fuente.readBytes()) // 3

}// fin de cap4.cap4.cap5.cap6.cap7.cap8.atrevete.conKotlin.capitulo8.bdr.mysql.atrevete.conKotlin.capitulo8.nosql.redis.atrevete.conKotlin.capitulo8.bdr.sqlite.main
