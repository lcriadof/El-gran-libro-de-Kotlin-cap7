package marcombo.lcriadof.capitulo7.fichero.binario
import marcombo.lcriadof.capitulo7.fichero.DirectorioBase
import marcombo.lcriadof.capitulo7.fichero.recurso.Companion.logging
import java.io.FileInputStream

// Leer un fichero binario

fun main() {
    // 1
    val directorio = DirectorioBase() // Crear una instancia de la clase
    directorio.getDirectoriosAbsoluto("./binario/").let { resultado ->
        if (resultado == 0) directorio.directorioAbsolutoBase else return
    }
    logging.info("Recurso encontrado en: ${directorio.directorioAbsolutoBase}")

    // 2
    // Crear un flujo de entrada de fichero
    val fichero = FileInputStream("${directorio.directorioAbsolutoBase}datos.bin")

    // Buffer para leer los datos del fichero (tamaño del array debe coincidir con el tamaño de los datos)
    val buffer = ByteArray(5)

    // Leer los datos del fichero en el buffer
    fichero.read(buffer)

    // Cerrar el flujo de entrada
    fichero.close()

    // Imprimir los datos leídos
    println(buffer.contentToString())
    logging.info("datos leidos del fichero binario "+buffer.contentToString())
}
