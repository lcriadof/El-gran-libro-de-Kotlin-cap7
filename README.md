# El gran libro de Kotlin (SEGUNDA EDICION)
## Capítulo 7

Se incluye una pequeña dependencia del capitulo 6, 
simplemente para que funcionen todos los ejemplo

En esta edición se han ajustado algo el código para su 
correcto funcionamiento en Kotlin versión 2.0.21. 

Todas las definiciones de dependencia indicando sus versiones se 
encuentran en Gradle. SI cuando usted lo usa, alguna librería 
se ve afectada por alguna vulnerabilidad pruebe a indicar una 
versión superior

## NOMENCLATURA USADA
Los programas que ya existían en la primera edición se nombran
de esta manera: 

    c[número del capítulo]p[número de programa].kt

Los programas añadido en la segunda edición, 
incluyen el prefijo "**ed2**", 
quedando el nombrado así:

    ed2c[número del capítulo]p[número de programa].kt

## niveles de logs
TRACE:

    El nivel más detallado.
    Usado para el seguimiento detallado del flujo de la aplicación.
    Incluye: TRACE, DEBUG, INFO, WARN, ERROR, FATAL.

DEBUG:

    Información útil durante el desarrollo o depuración.
    Incluye: DEBUG, INFO, WARN, ERROR, FATAL.

INFO:

    Mensajes informativos sobre el estado de la aplicación.
    Incluye: INFO, WARN, ERROR, FATAL.

WARN:

    Advertencias que no son errores, pero pueden ser importantes.
    Incluye: WARN, ERROR, FATAL.

ERROR:

    Indica que ha ocurrido un error, pero no necesariamente un fallo crítico.
    Incluye: ERROR, FATAL.

FATAL:

    Errores críticos que pueden hacer que la aplicación falle.
    Solo incluye FATAL.