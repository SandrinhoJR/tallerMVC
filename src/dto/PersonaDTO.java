/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author sandro rendon
 */
public class PersonaDTO {
    
        protected String id;
    protected String nombre;

    public PersonaDTO (String id, String nombre) {
        setId (id);
        setNombre(nombre);
    }

    public String getId() {
        return id;
    }

     public void setId(String id) {
        if (id == null || id.length() < 5) {
            throw new IllegalArgumentException("Documento inválido.");
        }
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }
    
    
    
    
    

    
}

