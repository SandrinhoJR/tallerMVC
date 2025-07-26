/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.CitaDTO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sandro rendon
 */
public class CitaDAO {

    private ArrayList<CitaDTO> citas = new ArrayList<>();

    public boolean agregarCita(CitaDTO cita) {
        if (buscarCita(cita.getId()) == null) {
            citas.add(cita);
            return true;
        } 
        return false;
    }
    
        public CitaDTO buscarCita(String id) {
        for (CitaDTO cita : citas) {
            if (cita.getId().equalsIgnoreCase(id)) {
                return cita ;
            }
        }
        return null;
    }

 

    public boolean editarCita(CitaDTO cita) {
        CitaDTO aux = buscarCita(cita.getId());
        if (aux != null) {
            aux.setId(cita.getId());
            aux.setFecha(cita.getFecha());
            aux.setHora(cita.getHora());
            aux.setMascota(cita.getMascota());
            aux.setPropietario(cita.getPropietario());
            aux.setVeterinario(cita.getVeterinario());
            return true;
        }
        return false;
    }

    public boolean eliminarCita(String id) {
        CitaDTO cita = buscarCita(id);
        if (cita != null) {
            citas.remove(citas);
            return true;
        }
        return false;
    }

    public DefaultTableModel listarCita() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new String[]{"Id", "Fecha", "Hora", "Mascota", "Propietario", "Veterinario"});
        for (CitaDTO cita : citas) {
            modelo.addRow(new Object[]{
                cita.getId(),
                cita.getFecha(),
                cita.getHora(),
                cita.getMascota().getNombre(),
                cita.getPropietario().getNombre(),
                cita.getVeterinario().getNombre()
            });

        }

        return modelo;
    }

}
