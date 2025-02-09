package marcombo.lcriadof.capitulo7.fichero.json
// ejemplo recogido de https://github.com/Kotlin/kotlinx.serialization

// [1]
import kotlinx.serialization.*
import kotlinx.serialization.json.*
// fin [1]

@Serializable // [2]
data class Project(val name: String, val language: String)

fun main() {
    // [3] Serialización
    val data = Project("kotlinx.serialization", "Kotlin")
    val string = Json.encodeToString(data)
    println(string)

    // [4] Deserialización
    val obj = Json.decodeFromString<Project>(string)
    println(obj)
}