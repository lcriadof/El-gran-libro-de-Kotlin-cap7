package marcombo.lcriadof.capitulo7.fichero.binario
import marcombo.lcriadof.capitulo7.fichero.DirectorioBase
import marcombo.lcriadof.capitulo7.fichero.recurso.Companion.logging
import java.io.RandomAccessFile


// Modificar un fichero binario
fun modificarTercerDato(nuevoDato: Byte) {
    // bloque 1
    val directorio = DirectorioBase() // Crear una instancia de la clase
    directorio.getDirectoriosAbsoluto("./binario/").let { resultado ->
        if (resultado == 0) directorio.directorioAbsolutoBase else return
    }
    logging.info("Recurso encontrado en: ${directorio.directorioAbsolutoBase}")

    // bloque 2

    // 2.1
    val fichero = RandomAccessFile("${directorio.directorioAbsolutoBase}datos.bin", "rw")

    val posicion = 2 // 2.2
    fichero.seek(posicion.toLong()) // 2.3
    fichero.writeByte(nuevoDato.toInt()) // 2.4
    logging.info("Valor modificado: "+nuevoDato.toInt())
    fichero.close() // 2.5
}

fun main() {
    println("Modificando el tercer dato...")
    logging.info("Modificando el tercer dato...")
    modificarTercerDato(99)

}

