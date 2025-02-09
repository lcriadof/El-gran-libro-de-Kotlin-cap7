package marcombo.lcriadof.capitulo7.fichero.binario
import marcombo.lcriadof.capitulo7.fichero.DirectorioBase
import marcombo.lcriadof.capitulo7.fichero.recurso.Companion.logging
import java.io.RandomAccessFile


// Modificar un fichero binario
fun modificarTercerDato(nuevoDato: Byte) {
    // 1
    val directorio = DirectorioBase() // Crear una instancia de la clase
    directorio.getDirectoriosAbsoluto("./binario/").let { resultado ->
        if (resultado == 0) directorio.directorioAbsolutoBase else return
    }
    logging.info("Recurso encontrado en: ${directorio.directorioAbsolutoBase}")

    // 2
    // Crear un flujo de salida de fichero
    val fichero = RandomAccessFile("${directorio.directorioAbsolutoBase}datos.bin", "rw")

    // Cada dato ocupa 1 byte, así que la posición del tercer dato es 2 (0-indexed)
    val posicion = 2

    fichero.seek(posicion.toLong())
    fichero.writeByte(nuevoDato.toInt())
    logging.info("Valor modificado: "+nuevoDato.toInt())
    fichero.close()
}

fun main() {
    println("Modificando el tercer dato...")
    logging.info("Modificando el tercer dato...")
    modificarTercerDato(99)

}

