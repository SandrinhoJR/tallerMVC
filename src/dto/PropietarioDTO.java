/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.ArrayList;

/**
 *
 * @author sandro rendon
 */
public class PropietarioDTO extends PersonaDTO{
    
     private String telefono;

    private ArrayList<MascotaDTO> mascotas;

    private ArrayList<PropietarioDTO> propietarios;

    public PropietarioDTO (String telefono, String id, String nombre) {
        super(id, nombre);
        setTelefono(telefono);
        this.mascotas = new ArrayList<>();
        this.propietarios = new ArrayList<>();
    }

    public void setTelefono(String telefono) {
        if (telefono == null || telefono.length() < 7) {
            throw new IllegalArgumentException("Teléfono inválido.");
        }
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public boolean agregarMascota(MascotaDTO mascota) {
        if (mascota != null) {
            mascotas.add(mascota); // Solo se agrega si no es null
            return true;
        }
        return false;
    }

    // Devuelve la lista de mascotas de este propietario
    public ArrayList<MascotaDTO> getMascotas() {
        // return mascotas;
        return new ArrayList<>(mascotas); // Se devuelve una copia para proteger la lista original
    }

    // Muestra toda la información del propietario
    public String mostrarInformacion() {
        String info = "Nombre: " + nombre + "\n";
        info += "Documento: " + id + "\n";
        info += "Telefono: " + telefono + "\n";
        return info;
    }

    public String mostrarMascotas() {
        // Recorre la lista de mascotas y muestra los datos de cada una
        String info = " ";
        for (MascotaDTO mascota : mascotas) {
            info += " \n -- Mascota --\n" + mascota.toString() + "\n";
        }
        return info;
    }
    
}
