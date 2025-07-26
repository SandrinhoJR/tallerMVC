/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 *
 * @author sandro rendon
 */
// Creamos la clase Consulta que representa una cita con el veterinario
public class Consulta extends EventoClinico{
    
     // Atributo para guardar el código único de la consulta

    // Atributo para guardar la fecha en la que se hace la consulta
    // private String fecha;
    // ✅ Refactor: ahora usamos LocalDate en vez de String para manejar mejor las fechas
   
    // Atributo para guardar el veterinario que atiende la consulta
    private Veterinario veterinario;

    public Consulta(Veterinario veterinario, String id, LocalDate fecha) {
        super(id, fecha);
        this.veterinario = veterinario;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }
    
    

    // Devuelve el código de la consulta

    /*
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
     */
    // Método para asignar el código, con validación para que no esté vacío o nulo


    /*
    public String getFecha() {
        return fecha;
    }
     */
        
    /*
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
     */
    // Este método devuelve todos los datos de la consulta en forma de texto
    @Override
    public String mostrarDetalles() {
        String info = "ID   : " + id + "\n";
        info += "Fecha: " + fecha + "\n";
        info += "Veterinario: " + veterinario.getNombre()+ "\n";
        return info;
    }
    
}
