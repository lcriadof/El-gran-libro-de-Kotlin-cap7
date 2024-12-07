package marcombo.lcriadof.capitulo7.fichero.binario
import java.io.FileInputStream

// Leer un fichero binario

fun main() {
    // Crear un flujo de entrada de fichero
    val fichero = FileInputStream("./target/classes/binario/datos.bin")

    // Buffer para leer los datos del fichero (tamaño del array debe coincidir con el tamaño de los datos)
    val buffer = ByteArray(5)

    // Leer los datos del fichero en el buffer
    fichero.read(buffer)

    // Cerrar el flujo de entrada
    fichero.close()

    // Imprimir los datos leídos
    println(buffer.contentToString())
}
