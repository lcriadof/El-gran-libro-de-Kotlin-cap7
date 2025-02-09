package marcombo.lcriadof.capitulo7.fichero

import org.apache.logging.log4j.LogManager

// clases reutilizadas en este paquete

class recurso {
    companion object {
        val logging = LogManager.getLogger() // 1
    }
} // fin de clase



class DirectorioBase {
    var directorioAbsolutoBase: String = ""
        private set // Solo se puede modificar desde dentro de la clase

    fun getDirectoriosAbsoluto(directorio: String): Int {
        val path = Thread.currentThread().contextClassLoader.getResource(directorio)?.path

        if (path == null) {
            recurso.Companion.logging.fatal("No se encontró el directorio relativo en el recurso: $directorio")
            return -1
        }
        directorioAbsolutoBase = path
        recurso.Companion.logging.info("Recurso encontrado en: $directorioAbsolutoBase")
        return 0
    }
} // fin de clase
