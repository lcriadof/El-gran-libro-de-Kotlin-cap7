/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 7: FICHEROS
 */

package marcombo.lcriadof.capitulo7.fichero.properties
import marcombo.lcriadof.capitulo7.fichero.recurso.Companion.logging
import java.io.FileInputStream
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
        val f=FileInputStream(url+"oracleBITver2.properties")
        prop.load(f)  // cargamos el fichero de propiedades
       
        val ip:String?=prop.getProperty("instancia.ip")
        val puerto:String?=prop.getProperty("instancia.puerto")
        val nombre:String?=prop.getProperty("instancia.nombre")
        val usuario:String?=prop.getProperty("usuario.nombre")
        val clave:String?=prop.getProperty("usuario.clave")

        println("Instancia a BBDD: $nombre    $ip:$puerto")
        println("  usuariao: $usuario clave:$clave")
    }catch (e: Exception) {
        println(e)
    }

}
