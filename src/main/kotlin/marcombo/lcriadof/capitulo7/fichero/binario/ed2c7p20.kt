package marcombo.lcriadof.capitulo7.fichero.binario

import java.io.FileOutputStream
// escribir datos en un fichero binario
fun main() {
         // Crear un flujo de salida de fichero
        val fichero = FileOutputStream("./target/classes/binario/datos.bin")

        // Datos a escribir en el fichero (array de bytes)
        val datos = byteArrayOf(1, 2, 3, 4, 5)

        // Escribir los datos en el fichero
        fichero.write(datos)

        // Cerrar el flujo de salida
        fichero.close()

}
