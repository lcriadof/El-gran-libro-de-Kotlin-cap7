package marcombo.lcriadof.capitulo7.fichero.json

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import java.io.File
import java.net.URL
import marcombo.lcriadof.capitulo7.fichero.DirectorioBase
import marcombo.lcriadof.capitulo7.fichero.recurso.Companion.logging


// Definición de clases de datos para serialización
// bloque [1]
@Serializable
data class Municipios2(
    val municipio_nombre: String,
    val densidad_por_km2: Double
)

@Serializable
data class MunicipiosResponse(
    val data: List<Municipios2>
)
// fin de la definición de clases de datos para serialización


fun main() {

  // [2] <<<<<<< bloque para descargar el archivo JSON

    // variable para definir la URL de donde se descarga el JSON
    // con los datos de municipios.
    val ficheroMunicipiosJSON =
        "https://datos.comunidad.madrid/catalogo/dataset/0781c37e-bc64-4143-8029-18865bedbc3d/resource/17feaf92-8749-44e4-a81c-6abee0df52e4/download/municipio_comunidad_madrid.json"

    // Descarga y limpieza del JSON con manejo de errores
    val fichIn1 = try {
        URL(ficheroMunicipiosJSON).readText()
    } catch (e: Exception) {
        println("Error al descargar el JSON: ${e.message}")
        return
    }

    // Verificar si la estructura del JSON ha cambiado antes de manipularlo
    if (fichIn1.length < 20) { // Se hace una verificación rápida para evitar procesar un JSON vacío.
        println("Error: El JSON descargado parece estar vacío o es demasiado corto.")
        return
    }

    // Se limpia el JSON eliminando espacios en blanco innecesarios
    val fichIn2 = fichIn1.trim()

    // Bloque de segunda edición: gestión de directorios
    val directorio = DirectorioBase()
    val resultado = directorio.getDirectoriosAbsoluto("./json/")
    if (resultado != 0) return
    logging.info("Recurso encontrado en: ${directorio.directorioAbsolutoBase}")

    // Asegurar que el directorio exista antes de escribir el archivo
    val directorioJson = File(directorio.directorioAbsolutoBase)
    if (!directorioJson.exists()) directorioJson.mkdirs() // Si el directorio no existe, se crea.
// fin de [2]

  // [3]
    // Deserializamos
    val response: MunicipiosResponse = try {
        Json { ignoreUnknownKeys = true }.decodeFromString(fichIn2)
    } catch (e: Exception) {
        println("Error al deserializar el JSON: ${e.message}")
        return
    }
  // fin de [3]

  // [4]
    // Serializamos
    val jsonString = try {
        Json.encodeToString(response)
    } catch (e: Exception) {
        println("Error al serializar el objeto: ${e.message}")
        return
    }
    val filePath = "${directorio.directorioAbsolutoBase}municipios_serializados.json"
    File(filePath).writeText(jsonString, Charsets.UTF_8)
// fin de [4]


  // [5]
    // Leemos el archivo JSON
    val contenido = try {
        File(filePath).readText()
    } catch (e: Exception) {
        println("Error al leer el archivo JSON: ${e.message}")
        return
    }
    logging.info(contenido)
    logging.info("--------  JSON leído")
// fin de [5]

// [6]
    // Deserialización
    val response2: MunicipiosResponse = try {
        Json { ignoreUnknownKeys = true }.decodeFromString(contenido)
    } catch (e: Exception) {
        println("Error al deserializar el JSON: ${e.message}")
        return
    }
    /*

     */
// fin de [6]

// [7]
    val listaMunicipiosEntrada = response2.data
    // Mostramos los datos en consola
    listaMunicipiosEntrada.forEach {
        println("${it.municipio_nombre} tiene una densidad por km2 de ${it.densidad_por_km2}")
        logging.info("${it.municipio_nombre} tiene una densidad por km2 de ${it.densidad_por_km2}")
    }
// fin de [7]
}
