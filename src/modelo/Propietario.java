/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sandro rendon
 */
// Clase Propietario para guardar los datos del dueño de las mascotas
public class Propietario extends Persona {

    private String telefono;

    private ArrayList<Mascota> mascotas;

    private ArrayList<Propietario> propietarios;

    public Propietario(String telefono, String id, String nombre) {
        super(id, nombre);
        setTelefono(telefono);
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

    public boolean agregarMascota(Mascota mascota) {
        if (mascota != null) {
            mascotas.add(mascota); // Solo se agrega si no es null
            return true;
        }
        return false;
    }

    // Devuelve la lista de mascotas de este propietario
    public ArrayList<Mascota> getMascotas() {
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
        for (Mascota mascota : mascotas) {
            info += " \n -- Mascota --\n" + mascota.toString() + "\n";
        }
        return info;
    }
}
