package marcombo.lcriadof.capitulo7.fichero.binario


import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import kotlinx.serialization.decodeFromString
import java.io.File


@Serializable
data class Persona(val nombre: String, val edad: Int)

fun escribirObjetosBinario() {
    val personas = listOf(
        Persona("Alice", 30),
        Persona("Bob", 25),
        Persona("Charlie", 35),
        Persona("Diana", 28),
        Persona("Edward", 40)
    )

    // Convertir objetos a JSON
    val json = Json.encodeToString(personas)

    // Guardar JSON en un fichero binario
    val fichero = File("personas.bin")
    fichero.writeBytes(json.toByteArray())
}

fun leerObjetosBinario() {
    // Leer JSON desde un fichero binario
    val fichero = File("personas.bin")
    val json = String(fichero.readBytes())

    // Convertir JSON a objetos
    val personas: List<Persona> = Json.decodeFromString(json)
    println("Personas leídas: $personas")
}

fun modificarPersona(indice: Int, nuevaPersona: Persona) {
    // Leer JSON desde un fichero binario
    val fichero = File("personas.bin")
    val json = String(fichero.readBytes())

    // Convertir JSON a objetos
    val personas = Json.decodeFromString<List<Persona>>(json).toMutableList()

    // Modificar la persona específica
    if (indice in personas.indices) {
        personas[indice] = nuevaPersona
    } else {
        println("Índice fuera de rango")
        return
    }

    // Convertir objetos a JSON
    val nuevoJson = Json.encodeToString(personas)

    // Guardar JSON modificado en un fichero binario
    fichero.writeBytes(nuevoJson.toByteArray())
}

fun main() {
    // Escribir los objetos en el fichero binario
    escribirObjetosBinario()

    // Leer y mostrar los objetos del fichero
    leerObjetosBinario()

    // Modificar la tercera persona (índice 2)
    println("Modificando la tercera persona...")
    modificarPersona(2, Persona("Carlos", 36))

    // Leer y mostrar los objetos después de la modificación
    leerObjetosBinario()
}
