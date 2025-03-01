/*
Programa que comprueba si el número introducido es primo.
 El valor máximo comprobable es 1.342.177.280
 El valor máximo es el del archivo binario usado como tabla de verificación '0000.pdb'.
 El resultado es instantáneo.
 Se han seguido las pautas especificadas por ChuxMan en el siguiente repositorio:
  https://github.com/pekesoft/PrimesDB

 by @lcriadof
 XX-02-2025
*/

import marcombo.lcriadof.capitulo7.fichero.DirectorioBase
import marcombo.lcriadof.capitulo7.fichero.recurso.Companion.logging

fun esPrimoBaseDatos(numero: Int, baseDatos: ByteArray): Boolean {
    // Los primeros primos conocidos
    if (numero in listOf(2, 3, 5, 7)) return true

    // Los números terminados en 0, 2, 4, 5, 6, 8 no pueden ser primos
    val ultimoDigito = numero % 10
    if (ultimoDigito in listOf(0, 2, 4, 5, 6, 8)) return false

    // Determinar la década del número
    val decada = numero / 10
    val direccion = (decada / 2.0 + 0.5).toInt() - 1

    if (direccion < 0 || direccion >= baseDatos.size) return false // Fuera del rango de la base de datos

    // Mapeo de últimos dígitos posibles a posiciones de bits
    val bits = mapOf(1 to 0, 3 to 1, 7 to 2, 9 to 3)
    val posicionBit = bits[ultimoDigito] ?: return false

    // Si la década es par, el bit está en la parte alta del byte (nibble alto)
    val bitPosicionFinal = if (decada % 2 == 0) posicionBit + 4 else posicionBit

    // Extraer el byte correspondiente y verificar el bit
    val byte = baseDatos[direccion].toInt() and 0xFF
    return (byte shr bitPosicionFinal) and 1 == 1
}


fun main() {

    // 1
    val directorio = DirectorioBase() // Crear una instancia de la clase
    directorio.getDirectoriosAbsoluto("./binario/").let { resultado ->
        if (resultado == 0) directorio.directorioAbsolutoBase else return
    }
    logging.info("Recurso encontrado en: ${directorio.directorioAbsolutoBase}")


    val archivo = java.io.File("${directorio.directorioAbsolutoBase}/0000.pdb")
    if (!archivo.exists()) {
        logging.info("\"No se encontró la base de datos de primos en: ${directorio.directorioAbsolutoBase}")
        return
    }

    val baseDatos = archivo.readBytes()

    val numero = 756101
    if (numero > 1_342_177_280) {
        println("Introduzca un número válido menor o igual a 1342177280")
    }else{
        val resultado = esPrimoBaseDatos(numero, baseDatos)
        println("$numero ${if (resultado) "ES PRIMO" else "no es primo"}")
    }
}

