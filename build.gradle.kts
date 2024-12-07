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
    testImplementation(kotlin("test")) // agrega las funcionalidades básicas de prueba para Kotlin, usando frameworks como JUnit.
    implementation("org.jetbrains.kotlin:kotlin-stdlib") // Librería estándar de Kotlin


    // Dependencia para Log4j 2
    implementation("org.apache.logging.log4j:log4j-core:2.20.0") // Núcleo de Log4j
    implementation("org.apache.logging.log4j:log4j-api:2.20.0") // API de Log4j

    // epublib
    implementation("nl.siegmann.epublib:epublib-core:3.1")

    // SLF4J API
    implementation("org.slf4j:slf4j-api:1.7.32")

    // Implementación de SLF4J para Log4j
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:2.17.2")

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


    // Jena
    // https://mvnrepository.com/artifact/org.apache.jena/jena-core
    implementation("org.apache.jena:jena-core:5.2.0")
    // https://mvnrepository.com/artifact/com.hp.hpl.jena/jena
    implementation("com.hp.hpl.jena:jena:2.6.4")




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

