package marcombo.lcriadof.capitulo7.fichero.binario
import java.io.RandomAccessFile
// ejemplo completo con la clase RandomAccessFile para leer, escribir y modificar



fun main() {
    val fileName = "./target/classes/binario/datos2.bin"

    // Escritura inicial
    escribirDatos(fileName, 100, 3.14, "Hola")
    println("Datos iniciales escritos.")

    // Lectura de datos
    var datos = leerDatos(fileName)
    println("Datos leídos del archivo:")
    println("Entero: ${datos.first}, Double: ${datos.second}, Texto: ${datos.third}")


    // Modificación directa
    modificarDouble(fileName, 6.28)
    println("Double modificado.")

    // Lectura de datos
    datos = leerDatos(fileName)
    println("Datos leídos del archivo modificado:")
    println("Entero: ${datos.first}, Double: ${datos.second}, Texto: ${datos.third}")
}

// Función para escribir datos iniciales en el archivo
fun escribirDatos(fileName: String, entero: Int, decimal: Double, texto: String) {
    RandomAccessFile(fileName, "rw").use { raf ->
        raf.writeInt(entero)    // Escribe un entero
        raf.writeDouble(decimal) // Escribe un double
        raf.writeUTF(texto)      // Escribe una cadena
    }
}

// Función para leer datos del archivo
fun leerDatos(fileName: String): Triple<Int, Double, String> {
    return RandomAccessFile(fileName, "r").use { raf ->
        raf.seek(0)               // Posiciona el puntero al inicio
        val entero = raf.readInt()   // Lee un entero
        val decimal = raf.readDouble() // Lee un double
        val texto = raf.readUTF()      // Lee una cadena
        Triple(entero, decimal, texto) // Devuelve los datos como un Triple
    }
}

// Función para modificar el double en el archivo
fun modificarDouble(fileName: String, nuevoValor: Double) {
    RandomAccessFile(fileName, "rw").use { raf ->
        raf.seek(4)    // Mueve el puntero al inicio del double (entero ocupa 4 bytes)
        raf.writeDouble(nuevoValor) // Sobrescribe el double
    }
}
