/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 7: FICHEROS
 */

package marcombo.lcriadof.capitulo7.fichero.txt

import marcombo.lcriadof.capitulo6.ficheros
import java.io.File

import marcombo.lcriadof.capitulo7.fichero.recurso.Companion.logging

// IMPORTANTE en main() hemos introducido logs en lugar de println() de la primera edición
//   no se ha cambiado la clase fichTexto
fun main(){
    val directorioRaiz:String="./txt/"

    //val url:String= recursos::class.java.getResource(directorioRaiz).path //1  (edición primera)

    // 1
    val url = Thread.currentThread().contextClassLoader.getResource(directorioRaiz)?.path
        ?: run {
            logging.fatal("No se encontró el directorio raíz: $directorioRaiz")
            return  // en este caso el hilo, es el principal, al hacer return interrumpimos la ejecucion completa
        }


    logging.info("url: $url")

    var f=fichTexto(url+"f6.txt") // 2
    f.usar()
    logging.trace("abrimos: "+f.usar())


    logging.trace("Leemos")
    println("leemos: \n"+f.leer())
    println(f.contenido)

    logging.trace("escribimos")
    println("Escribimos: "+f.agregar("101"))
    println("Escribimos: "+f.agregar(102))

    logging.trace("Leemos")
    println("leemos: \n"+f.leer())

    f.borrarTodoElContenido()
    logging.trace("Leemos")
    println("leemos: \n"+f.leer())

    for (x in 1..25){
        f.agregar(x)
    }
    logging.trace("Leemos")
    println("leemos: \n"+f.leer())

    //f.borrarFichero()

}


// clase para gestionar ficheros de texto
class fichTexto(path:String): ficheros {
   var url:String=path
   var contenido:String=""
   var fichero:File=File( url )
   var isUsable:Boolean=false

    override fun usar(){
       try {
          // println("url: $url")
            if (fichero.exists() and fichero.isFile) { // 1
                isUsable=true // 2
            }
        }
        catch (e: Exception) {
            println(e)
        }
     }



    override fun leer():String{
      contenido = ""
      if (isUsable) {
          try {
              File(url).forEachLine { contenido = contenido + it + "\n" }  //  4
          } catch (e: Exception) {
              println(e)
          }
      }
      return contenido
    }

    override fun <T>agregar(vararg cadena:T):Boolean{ //  5
        var bandera:Boolean=false
        var c:String=""
        if (isUsable) {
            try {
                cadena.iterator().forEach { c = c + it.toString() }
                fichero.appendText(c.toString() + "\n") // 6
                bandera = true
            } catch (e: Exception) {
                bandera = false
            }
        }
        return bandera
    }



    override fun borrarFichero():Boolean{
        var bandera:Boolean=false
        if (isUsable) {
            try {
                if (File(url).exists()) {  // 7
                    File(url).delete()  // 8
                    bandera = true
                }
            } catch (e: Exception) {
                bandera = false
            }
        }
        return bandera
    }

    override fun borrarTodoElContenido():Boolean{
        var bandera:Boolean=false
        if (isUsable) {
            try {
                if (fichero.exists() and fichero.isFile) {  // 9
                    fichero.writeText("")  // 10
                    bandera = true
                }

            } catch (e: Exception) {
                println(e)
                bandera = false
            }
        }
        return bandera
    }


}