Sistema de reserva Coworking

## Descripción

Este proyecto es un sistema de reserva de Coworking, el cual permite a los usuarios reservar un espacio de trabajo en un Coworking, además de permitir a los administradores gestionar las reservas y los espacios de trabajo.

## Funcionalidad basicas

- Agregar y eliminar espacios de trabajo.
- Evaluar la disponibilidad de los espacios de trabajo.

## Instalación

1. Clonar el repositorio.
2. Usar Tomcat 8.5.96 [Descargue Aquí](https://archive.apache.org/dist/tomcat/tomcat-8/v8.5.96/bin/)
3. Usar Java 11 [Descargue Aquí](https://www.openlogic.com/openjdk-downloads?field_java_parent_version_target_id=406&field_operating_system_target_id=436&field_architecture_target_id=391&field_java_package_target_id=396)
4. Se usó Intellij IDEA, sin embargo puede usar cualquier IDE de su preferencia.

## Uso

1. Configurar el usuario y contraseña para el servidor Tomcat en el archivo `tomcat-users.xml` ubicado en la carpeta `conf` del servidor Tomcat.
2. Tener en cuenta y como recomendación crear un proyecto Maven en su IDE de preferencia. (Esto para que el proyecto se configure correctamente y al iniciar permita arrancar la pagina)
3. Ejecutar el servidor Tomcat. (Desde un ide o de forma externa)
4. Si todo funcionó ok puede ingresar a la URL: http://localhost:8080/ProyectoReservaCoworking/
5. Ingresar datos y comprobar funcionamiento.

## Autor

- [Jonathan Narvaez Posada](https://github.com/jonakls)

