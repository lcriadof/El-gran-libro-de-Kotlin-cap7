package marcombo.lcriadof.capitulo7.fichero.binario
import java.io.RandomAccessFile


// Modificar un fichero binario
fun modificarTercerDato(nuevoDato: Byte) {
    // Crear un flujo de salida de fichero
    val fichero = RandomAccessFile("./target/classes/binario/datos.bin", "rw")

    // Cada dato ocupa 1 byte, así que la posición del tercer dato es 2 (0-indexed)
    val posicion = 2

    fichero.seek(posicion.toLong())
    fichero.writeByte(nuevoDato.toInt())

    fichero.close()
}

fun main() {
    println("Modificando el tercer dato...")
    modificarTercerDato(99)

}

