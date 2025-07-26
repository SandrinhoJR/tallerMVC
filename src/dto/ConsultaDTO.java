/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDate;
import modelo.Veterinario;

/**
 *
 * @author sandro rendon
 */
public class ConsultaDTO extends EventoClinicoDTO {

    // Atributo para guardar el veterinario que atiende la consulta
    private Veterinario veterinario;

    public ConsultaDTO(Veterinario veterinario, String id, LocalDate fecha) {
        super(id, fecha);
        this.veterinario = veterinario;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
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
    // Método para obtener la fecha de la consulta (ahora como LocalDate)
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
        info += "Veterinario: " + veterinario.getNombre() + "\n";
        return info;
    }

}
