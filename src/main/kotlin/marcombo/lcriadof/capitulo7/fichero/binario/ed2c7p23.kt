package marcombo.lcriadof.capitulo7.fichero.binario
import marcombo.lcriadof.capitulo7.fichero.DirectorioBase
import marcombo.lcriadof.capitulo7.fichero.recurso.Companion.logging
import java.io.RandomAccessFile
// ejemplo completo con la clase RandomAccessFile para leer, escribir y modificar



fun main() {

    // bloque 1
    val directorio = DirectorioBase() // Crear una instancia de la clase
    directorio.getDirectoriosAbsoluto("./binario/").let { resultado ->
        if (resultado == 0) directorio.directorioAbsolutoBase else return
    }
    logging.info("Recurso encontrado en: ${directorio.directorioAbsolutoBase}")
    // fin de bloque 1

    // Nombre y path del fichero binario
    val fileName = "${directorio.directorioAbsolutoBase}datos.bin"


    // Escritura inicial
    escribirDatos(fileName, 100, 3.14, "Hola")
    println("Datos iniciales escritos.")
    println()

    // Lectura de datos
    var datos = leerDatos(fileName)
    println("Datos leídos del archivo:")
    println("Entero: ${datos.first}, Double: ${datos.second}, Texto: ${datos.third}")
    println()

    // Modificación directa
    modificarDouble(fileName, 6.28)
    println("Double modificado con valor 6.28.")
    println()

    // Lectura de datos
    datos = leerDatos(fileName)
    println("Datos leídos del archivo modificado:")
    println("Entero: ${datos.first}, Double: ${datos.second}, Texto: ${datos.third}")
    println()
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
        raf.seek(0)   // Posiciona el puntero al inicio
        val entero = raf.readInt()   // Lee un entero
        val decimal = raf.readDouble() // Lee un double
        val texto = raf.readUTF()      // Lee una cadena
        Triple(entero, decimal, texto) // Devuelve los datos como un Triple
    }
}

// Función para modificar el double en el archivo
fun modificarDouble(fileName: String, nuevoValor: Double) {
    RandomAccessFile(fileName, "rw").use { raf ->
        raf.seek(4)    // Mueve el puntero al inicio del double
        raf.writeDouble(nuevoValor) // Sobrescribe el double
    }
}
