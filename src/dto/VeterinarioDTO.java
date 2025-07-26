/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author sandro rendon
 */
public class VeterinarioDTO extends PersonaDTO {
    
     private String especialidad;
    private String disponibilidad;

    public VeterinarioDTO (String especialidad, String disponibilidad, String id, String nombre) {
        super(id, nombre);
        this.especialidad = especialidad;
        this.disponibilidad = disponibilidad;
    }

    public void mostrarInfo() {
        System.out.println("Veterinario: " + nombre);
        System.out.println("Especialidad: " + especialidad);
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        if (especialidad == null || especialidad.isBlank()) {
            throw new IllegalArgumentException("La especialidad no puede estar vacía.");
        }
        this.especialidad = especialidad;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }


    
}
