/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author sandro rendon
 */
public class IDGenerator {

    private static int contadorConsulta = 0;
// Variable para contar cuántas consultas se han creado (es estática porque es compartida por todos)

    private static int contadorMascota = 0;
// Variable para contar cuántas mascotas se han creado (también es compartida por todos)

// Método para generar un código único para cada consulta
    public static String generarCodigoConsulta() {
        return "C" + (++contadorConsulta); // Se aumenta el contador y se le pone una "C" al inicio
    }

// Método para generar un código único para cada mascota
    public static String generarCodigoMascota() {
        return "M" + (++contadorMascota); // Se aumenta el contador y se le pone una "M" al inicio
    }
}
