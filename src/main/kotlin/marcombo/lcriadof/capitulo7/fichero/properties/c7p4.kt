/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 7: FICHEROS
 */

package marcombo.lcriadof.capitulo7.fichero.properties

import marcombo.lcriadof.capitulo7.fichero.recurso.Companion.logging
import java.io.FileOutputStream
import java.util.*

fun main(){


    try {
        val directorioRaiz:String="./properties/"

        // 1
        val url = Thread.currentThread().contextClassLoader.getResource(directorioRaiz)?.path
            ?: run {
                logging.fatal("No se encontró el directorio raíz: $directorioRaiz")
                return  // en este caso el hilo, es el principal, al hacer return interrumpimos la ejecucion completa
            }
        logging.info("url: $url")

        val prop = Properties()
        val f= FileOutputStream(url+"oracleBITver2.properties")

        prop.put("instancia.ip","192.168.1.101")
        prop.put("instancia.puerto","1521 ")
        prop.put("instancia.nombre","prueba")
        prop.put("usuario.nombre","general")
        prop.put("usuario.clave","123456")
        prop.store(f,"config acceso a BBDD")


    }catch (e: Exception) {
        println(e)
    }

}
