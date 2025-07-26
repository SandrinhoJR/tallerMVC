/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.MascotaDTO;
import dto.PersonaDTO;
import dto.PropietarioDTO;
import dto.VeterinarioDTO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sandro rendon
 */
public class PersonaDAO {

    ArrayList<PersonaDTO> personas;

    private ArrayList<PropietarioDTO> propietarios = new ArrayList<>();
    private ArrayList<VeterinarioDTO> veterinarios = new ArrayList<>();

    public PersonaDAO() {
        personas = new ArrayList<>();
    }

    public PersonaDTO buscarPersona(String id) {
        for (PersonaDTO persona : personas) {
            if (persona.getId() == id) {
                return persona;
            }
        }
        return null;
    }

    public VeterinarioDTO buscarVeterinario(String id) {
        PersonaDTO aux = buscarPersona(id);
        if (aux instanceof VeterinarioDTO) {
            VeterinarioDTO veterinario = (VeterinarioDTO) aux;
            return veterinario;
        }
        return null;
    }

    public PropietarioDTO buscarPropietario(String id) {
        PersonaDTO aux = buscarPersona(id);
        if (aux instanceof PropietarioDTO) {
            PropietarioDTO propietario = (PropietarioDTO) aux;
            return propietario;
        }
        return null;
    }

    public boolean agregarPersona(PersonaDTO persona) {
        PersonaDTO aux = buscarPersona(persona.getId());
        if (aux == null) {
            personas.add(persona);
            return true;
        }
        return false;
    }

    public boolean editarPersona(PersonaDTO persona) {
        PersonaDTO aux = buscarPersona(persona.getId());
        if (aux != null) {
            aux.setId(persona.getId());
            aux.setNombre(persona.getNombre());
            return true;
        }
        return false;
    }

    public boolean editarVeterinario(VeterinarioDTO veterinario) {
        VeterinarioDTO aux = buscarVeterinario(veterinario.getId());
        if (aux != null) {
            aux.setId(veterinario.getId());
            aux.setNombre(veterinario.getNombre());
            aux.setEspecialidad(veterinario.getEspecialidad());
            aux.setDisponibilidad(veterinario.getDisponibilidad());
            return true;
        }
        return false;
    }

    public boolean editarPropietario(PropietarioDTO propietario) {
        PropietarioDTO aux = buscarPropietario(propietario.getId());
        if (aux != null) {
            aux.setNombre(propietario.getNombre());
            aux.setTelefono(propietario.getTelefono());
            return true;
        }
        return false;
    }

    public boolean eliminarPersona(int id) {
        for (PersonaDTO persona : personas) {
            if (persona != null) {
                personas.remove(persona);
                return true;
            }
        }
        return false;
    }

    public DefaultTableModel listarPropietario() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new String[]{"Id", "Nombre", "Telefono", "MascotaDTOs"});

        for (PropietarioDTO propietario : propietarios) {
            String id = propietario.getId();
            String nombre = propietario.getNombre();
            String telefono = propietario.getTelefono();
            // Concatenar nombres de mascotas en un solo String
            String mascotasStr = "";
            for (MascotaDTO mascota : propietario.getMascotas()) {
                mascotasStr += mascota.getNombre() + ", ";
            }
            // Quitar la última coma si hay mascotas
            if (!mascotasStr.equals("")) {
                mascotasStr = mascotasStr.substring(0, mascotasStr.length() - 2);
            } else {
                mascotasStr = "Sin mascotas";
            }

            modelo.addRow(new Object[]{id, nombre, telefono, mascotasStr});
        }

        return modelo;

    }
    
      public DefaultTableModel listarVeterinario() {
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.setColumnIdentifiers(new String[]{"id","Nombre", "Especialidad", "Disponibilidad"});
    for (VeterinarioDTO veterinario : veterinarios) {
        modelo.addRow(new Object[]{
            veterinario.getId(),
            veterinario.getNombre(),
            veterinario.getEspecialidad(),
            veterinario.getDisponibilidad()
        });
    }

    return modelo;
}
    

    public ArrayList<PersonaDTO> getPersonas() {
        return personas;
    }

}