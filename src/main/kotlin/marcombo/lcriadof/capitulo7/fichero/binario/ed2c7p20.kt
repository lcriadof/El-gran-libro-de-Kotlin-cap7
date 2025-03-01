package marcombo.lcriadof.capitulo7.fichero.binario

import marcombo.lcriadof.capitulo7.fichero.DirectorioBase
import marcombo.lcriadof.capitulo7.fichero.recurso.Companion.logging


import java.io.FileOutputStream
import java.io.FileNotFoundException
import java.io.IOException

// PROPOSITO DEL PROGRAMA: escribir datos en un fichero binario
fun main() {

        // 1
        val directorio = DirectorioBase() // Crear una instancia de la clase
        directorio.getDirectoriosAbsoluto("./binario/").let { resultado ->
                if (resultado == 0) directorio.directorioAbsolutoBase else return
        }
        logging.info("Recurso encontrado en: ${directorio.directorioAbsolutoBase}")


        // 2
        try {
                logging.info("Escribiendo datos en fichero binario")
                logging.trace("Crear un flujo de salida de fichero")
                val fichero = FileOutputStream("${directorio.directorioAbsolutoBase}datos.bin") // [2.1]

                logging.trace("Datos a escribir en el fichero (array de bytes)")
                val datos = byteArrayOf(1, 2, 3, 4, 5) // [2.2]

                logging.trace("Escribir los datos en el fichero")
                fichero.write(datos) // [2.3]

                logging.trace("Cerrar el flujo de salida")
                fichero.close() // [2.4]

        } catch (e: FileNotFoundException) {
                logging.fatal("El fichero no pudo ser creado o no se encontró el path: ${e.message}")
        } catch (e: IOException) {
                logging.fatal("Ocurrió un error al trabajar con el fichero: ${e.message}")
        } finally {
                logging.info("Finalizando operación de escritura.")
        }
}