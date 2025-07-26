/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.MascotaDAO;
import dao.PersonaDAO;
import dto.MascotaDTO;
import dto.PropietarioDTO;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sandro rendon
 */
public class ControladorMascota {
    private MascotaDAO mascotaDAO;
    private PersonaDAO personaDAO;

    public ControladorMascota(PersonaDAO personaDAO) {
        this.personaDAO = personaDAO;
        this.mascotaDAO = new MascotaDAO(personaDAO);
    }

    public boolean guardar(String documento, MascotaDTO mascota) {
        if (documento == null || documento.isEmpty()) {
            throw new IllegalArgumentException("El documento no puede estar vacío.");
        }
        if (mascota == null) {
            throw new IllegalArgumentException("La mascota no puede ser nula.");
        }
        if (mascota.getNombre() == null || mascota.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la mascota no puede estar vacío.");
        }

        PropietarioDTO propietario = personaDAO.buscarPropietario(documento);
        if (propietario != null && buscar(mascota.getNombre()) == null) {
            propietario.agregarMascota(mascota);
            return mascotaDAO.guardar(documento, mascota);
        } else {
            throw new IllegalStateException("El propietario no existe o la mascota ya está registrada.");
        }
    }

    public MascotaDTO buscar(String nombre) {
        // Validación
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        return mascotaDAO.buscar(nombre);
    }
    
    
    public boolean eliminar(String nombre, String documento) {
    if (nombre == null || nombre.isEmpty()) {
        throw new IllegalArgumentException("El nombre de la mascota no puede estar vacío.");
    }
    MascotaDTO mascota = buscar(nombre); // Ya valida internamente
    if (mascota != null) {
        return mascotaDAO.eliminar(nombre, documento); 
    } else {
        throw new IllegalStateException("No se encontró la mascota con el nombre proporcionado.");
    }
}
    
     public DefaultTableModel listar() {
    return mascotaDAO.listar();
}
    

}

    

