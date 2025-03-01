package marcombo.lcriadof.capitulo7.fichero.binario

/*
programa en kotlin con un ejemplo completo usando números Double en un fichero binario
hemos implementado una función para generar un fichero binario de numeros double ( 100 numeros consecutivos)
otra función para leer todo el fichero
y fianlmente una función para modificar cualquiera de los 100 número que contiene el fichero binario
 */

import java.io.RandomAccessFile
import java.io.FileInputStream
import java.io.DataInputStream
import java.io.FileOutputStream
import java.io.DataOutputStream

fun generarFicheroBinario(fileName:String) {
    val fichero = FileOutputStream(fileName) // para crear o abrir el fichero
    val dataOutput = DataOutputStream(fichero) // DataOutputStream facilita la escritura de datos primitivos en un formato binario adecuado, asegurando que los datos se almacenan de manera eficiente.

    for (i in 1..100) {
        dataOutput.writeDouble(i.toDouble())
    }

    dataOutput.close()
}


fun leerFicheroBinario(fileName:String) {
    val fichero = FileInputStream(fileName) // para abrir el fichero
    val dataInput = DataInputStream(fichero) // DataInputStream proporciona métodos de lectura específicos para tipos de datos primitivos (e.g., readInt(), readDouble())

    val numerosLeidos = mutableListOf<Double>()

    try {
        while (true) {
            numerosLeidos.add(dataInput.readDouble())
        }
    } catch (e: Exception) {
        // Fin del fichero alcanzado
    }

    dataInput.close()

    println("Números leídos: $numerosLeidos")
}


fun modificarNumero(fileName:String,indice: Int, nuevoNumero: Double) {
    val fichero = RandomAccessFile(fileName, "rw")

    val posicion = 8 * indice // [1]
    fichero.seek(posicion.toLong()) // [2]
    fichero.writeDouble(nuevoNumero) // [3]
    fichero.close()
}



fun main() {
    val fileName = "./target/classes/binario/datos3.bin"

    // Generar el fichero binario con 100 números double aleatorios
    generarFicheroBinario(fileName)

    // Leer y mostrar los números del fichero
    leerFicheroBinario(fileName)

    // Modificar el décimo número en el fichero (índice 9)
    println("Modificando el cuarto número...")
    modificarNumero(fileName,3, 99.99)

    // Leer y mostrar los números después de la modificación
    leerFicheroBinario(fileName)
}
