# IMC-App

## Introducción

Este proyecto se trata de una App que permite __calcular el IMC__ de una persona para saber si se encuentra en __*bajo peso, peso normal, sobrepeso u obesidad*__.

Es una de las prácticas propuestas en el curso de [ANDROID CON KOTLIN de AristiDevs](https://youtu.be/vJapzH_46a8) el cual es gratis y si prefieres consumir más de su contenido, puedes visitar su [canal de YouTube:](https://www.youtube.com/@AristiDevs)

## Tecnologías Utilizadas

- Kotlin
- Diseño basado en XML
  - CardView
  - Constraint Layout
  - Linear Layout

## Funcionalidad

La app está compuesta por dos vistas:

1. __Vista principal:__ Muestra los controles para seleccionar el __*SEXO (HOMBRE o MUJER), ALTURA, PESO Y EDAD*__, de lo cual dependerá nuestro resultado.<br>
  <p align="center">
      <img width="20%" src="https://i.postimg.cc/mg1YTjRL/Screenshot-1.png">
  </p>

2. __Vista resultado de IMC:__ Muestra el resultado del cálculo del __IMC__.<br><br>
   - **Resultados Hombre:**<br><br>
      <p align="center">
        <img width="18%" src="https://i.postimg.cc/CMvkDXxM/Screenshot-2.png">
        <img width="18%" src="https://i.postimg.cc/R0rchtVc/Screenshot-4.png">
        <img width="18%" src="https://i.postimg.cc/d16d5SRB/Screenshot-6.png">
        <img width="18%" src="https://i.postimg.cc/B64HcGFb/Screenshot-8.png">
        <img width="18%" src="https://i.postimg.cc/Sx9MBK7j/Screenshot-10.png">
      </p>
   - **Resultados Mujer:**<br><br>
      <p align="center">
        <img width="18%" src="https://i.postimg.cc/6q1ZX2m4/Screenshot-3.png">
        <img width="18%" src="https://i.postimg.cc/43zp93mj/Screenshot-5.png">
        <img width="18%" src="https://i.postimg.cc/zvfh6S01/Screenshot-7.png">
        <img width="18%" src="https://i.postimg.cc/Fs8SCSS2/Screenshot-9.png">
        <img width="18%" src="https://i.postimg.cc/Xv0C40QL/Screenshot-11.png">
      </p>
### El Resultado
La aplicación está diseñada para mostrar uno de cinco posibles resultados de **IMC** (***Bajo Peso, Saludable, Sobrepeso, Obesidad y Obesidad Severa***), dependiendo del peso y altura ingresados. 

Este resultado estará acompañado de una ***imagen representativa*** del tipo de cuerpo según el rango del **IMC** obtenido. Dicha imagen actúa simplemente como ***alusión*** y ***NO REPRESENTA FORZOSAMENTE QUE EL CUERPO DEL USUARIO SEA IDÉNTICO A ESTA.***

La ***imagen representativa*** del tipo de cuerpo cambia entre **HOMBRE** y **MUJER**, dependiendo de la elección en la vista principal, mostrando una pequeña diferencia entre ambos sexos.

Tanto el texto del resultado como la ***imagen representativa*** se mostrarán de un color relacionado al resultado del **IMC**, este resultado se interpreta por rangos, los cuales, *para fines prácticos en este proyecto*, se tomaron de la siguiente imagen obtenida de internet.

<div align="center">
        <img width="60%" src="https://i.postimg.cc/VNx2tn8m/imc-bodies.jpg"> <br>
        <p>
          Fuente: <a href="https://drcormillot.com.ar/que-es-el-imc-y-como-calcularlo/"><i>¿Qué es el IMC y cómo calcularlo?</i></a>
        </p>
</div>

## Acerca del IMC

El índice de masa corporal (__IMC__) sirve para medir la relación entre el peso y la talla, lo que  permite identificar el sobrepeso y la obesidad en adultos.

La forma para calcularlo es la siguiente:

<div align="center"> 
  <strong> Kilogramos ÷ Metros<sup>2</sup> = IMC </strong>
</div>

Ejemplo:

Si el peso de una persona es de **75 kilos** y su talla es de **1.68 metros**. El __IMC__ de esta persona es de __26.57__

Una vez que se obtiene el cálculo del **IMC**, con la siguiente tabla se puede interpretar la condición en la que se encuentra la persona.

<div align="center">
  <table>
    <tr>
      <td>Menor a 18.9 </td>
      <td>Peso Bajo</td>
    </tr>
    <tr>
      <td>18.50 a 24.99</td>
      <td>Peso Normal</td>
    </tr>
    <tr>
      <td>25.00 a 29.99</td>
      <td>Sobrepeso</td>
    </tr>
    <tr>
      <td>30.00 a 34.99</td>
      <td>Obesidad Leve</td>
    </tr>
    <tr>
      <td>35.00 a 39.99</td>
      <td>Obesidad Media</td>
    </tr>
    <tr>
      <td>Mayor a 40.0 </td>
      <td>Obesidad Mórbida</td>
    </tr>
  </table>
</div>

Con el cálculo anterior del __IMC = 26.57__, identificamos que se encuentra en un rango de __25.00 a 29.99__, lo que significa que esta persona tiene __sobrepeso__.

<br>

Fuente: [_ISSSTE - ¿Qué es el índice de masa corporal?_](https://www.gob.mx/issste/articulos/que-es-el-indice-de-masa-corporal)

## Enlaces

- [ANDROID CON KOTLIN de AristiDevs](https://youtu.be/vJapzH_46a8)
- [Canal de YouTube de AristiDevs](https://www.youtube.com/@AristiDevs)
- [_ISSSTE - ¿Qué es el índice de masa corporal?_](https://www.gob.mx/issste/articulos/que-es-el-indice-de-masa-corporal)
- [_¿Qué es el IMC y cómo calcularlo?_](https://drcormillot.com.ar/que-es-el-imc-y-como-calcularlo/)
