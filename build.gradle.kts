plugins {
    kotlin("jvm") version "2.0.21" // Plugin para usar Kotlin con JVM
    kotlin("plugin.serialization") version "2.0.21" // Plugin de serialización compatible
     }

group = "marcombo.lcriadof.anexo"
version = "1.0"

repositories {
    mavenCentral() // para buscar dependencias

    // Repositorio adicional de psiegman
    maven {
        url = uri("https://github.com/psiegman/mvn-repo/raw/master/releases")
    }
}

dependencies {
    // para buscar dependencias transitivas usar:  ./gradlew dependencies
    // para limpia y reconstruir el proyecto: ./gradlew clean build

    testImplementation(kotlin("test")) // agrega las funcionalidades básicas de prueba para Kotlin, usando frameworks como JUnit.
    implementation("org.jetbrains.kotlin:kotlin-stdlib") // Librería estándar de Kotlin

    // epublib
    // Excluir slf4j-simple para el resto, esta versión solo funciona para epublib-core
    implementation("nl.siegmann.epublib:epublib-core:3.1") {
        exclude(group = "org.slf4j", module = "slf4j-simple")
    }

    // Jena Core
      // https://mvnrepository.com/artifact/org.apache.jena/jena-core
      // https://mvnrepository.com/artifact/com.hp.hpl.jena/jena
    // si usamos versiones superiores de Jena probablemente hay que elevar la versión de Java
    // Excluir slf4j-simple para el resto, esta versión solo funciona para jena
    implementation("org.apache.jena:jena-core:4.8.0") {
        exclude(group = "org.slf4j", module = "slf4j-simple")
    }

    // Log4j2 y SLF4J
    implementation("org.apache.logging.log4j:log4j-core:2.20.0") // Implementación de Log4j2
    implementation("org.apache.logging.log4j:log4j-api:2.20.0") // API de Log4j2
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:2.20.0") // Si usas SLF4J para logging
    // Forzar la versión de SLF4J
    implementation("org.slf4j:slf4j-api:1.7.36")


    // JSON con Kotlinx Serialization
    //implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0") // Librería de serialización JSON
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
    implementation("org.json:json:20220320") // Biblioteca JSON que incluye XML.toJSONObject

    // GSON
    implementation("com.google.code.gson:gson:2.10.1")

    // EXCEL
    implementation("com.opencsv:opencsv:5.7.1")
    // https://mvnrepository.com/artifact/org.apache.poi/poi
    implementation("org.apache.poi:poi:5.3.0")


}

tasks.test {
    useJUnitPlatform()
}
/*
tasks.test: Configura cómo se ejecutan las pruebas del proyecto.
useJUnitPlatform(): Configura Gradle para usar JUnit 5 como framework de pruebas. Esto permite ejecutar pruebas con anotaciones y características de JUnit 5, que es la versión más reciente y potente de JUnit.
 */

kotlin {
    jvmToolchain(11)
}

