/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.CitaDAO;
import dao.EventoClinicoDAO;
import dao.MascotaDAO;
import dao.PersonaDAO;
import dto.CitaDTO;
import dto.MascotaDTO;
import dto.PropietarioDTO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Cita;
import modelo.Mascota;

/**
 *
 * @author sandro rendon
 */

    public class ControladorCita {
    private CitaDAO citaDAO;
    
    public ControladorCita(CitaDAO citaDAO) {
        this.citaDAO = citaDAO;
    }
    
    

    // █ Método para guardar cita
    public boolean guardarCita(CitaDTO cita) {
        // Validación básica
        if (cita == null) {
            throw new IllegalArgumentException("La cita no puede ser nula");
        }
        
        // Validación de campos obligatorios
        if (cita.getFecha() == null || cita.getHora() == null) {
            throw new IllegalArgumentException("Fecha y hora son obligatorias");
        }
        
        // Llamada directa al DAO
        return citaDAO.agregarCita(cita);
    }

    // █ Método para buscar cita
    public CitaDTO buscarCita(String id) {
        // Validación de ID
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID inválido");
        }
        
        return citaDAO.buscarCita(id);
    }

    // █ Método para actualizar cita
    public boolean actualizarCita(CitaDTO cita) {
        // Validación de objeto
        if (cita == null) {
            throw new IllegalArgumentException("Cita nula");
        }
        
        // Validación de ID
        if (cita.getId() == null || cita.getId().trim().isEmpty()) {
            throw new IllegalArgumentException("ID inválido");
        }
        
        return citaDAO.eliminarCita(cita.getId());
    }

    // █ Método para eliminar cita
    public boolean eliminarCita(String id) {
        // Validación de ID
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID inválido");
        }
        
        return citaDAO.eliminarCita(id);
    }
}


  
