/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.MascotaDTO;
import dto.PropietarioDTO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sandro rendon
 */
public class MascotaDAO {
    
      private ArrayList<MascotaDTO> mascotasVeterinario = new ArrayList<>();
    private PersonaDAO personaDAO;

    public MascotaDAO(PersonaDAO personaDAO) {
        this.personaDAO = personaDAO;
    }

    public ArrayList<MascotaDTO> getMascotasVeterinario() {
        return mascotasVeterinario;
    }
    
    

    private PropietarioDTO buscarPropietarioPorId(String id) {
        PersonaDAO personaDAO = new PersonaDAO();
        PropietarioDTO propietario =  personaDAO.buscarPropietario(id);
        return propietario;
    }

    public boolean guardar(String documento, MascotaDTO mascota) {
        PropietarioDTO p = buscarPropietarioPorId(documento);
        if (p != null && buscar(mascota.getNombre())==null) {
            p.agregarMascota(mascota);
            
            mascotasVeterinario.add(mascota);
            return true;
        }
        return false;
    }

    public MascotaDTO buscar(String nombre) {
        for (MascotaDTO mascota : mascotasVeterinario) {
            if (mascota.getNombre().equals(nombre)) {
                return mascota;
            }
        }
        return null;
    }

    public boolean eliminar(String nombre, String documento) {
        boolean seElimino = false;
        MascotaDTO mascota =  buscar(nombre);
        PropietarioDTO propietario = buscarPropietarioPorId(documento);
        if (propietario != null) {
            propietario.getMascotas().remove(mascota);
            mascotasVeterinario.remove(mascota);
            seElimino = true;
        }

        return seElimino;
    }

 public DefaultTableModel listar() {
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.setColumnIdentifiers(new String[]{"Nombre", "Especie","Raza","Edad","Peso"});
    for (MascotaDTO mascota : mascotasVeterinario) {
        modelo.addRow(new Object[]{
            mascota.getNombre(),
            mascota.getEspecie(),
            mascota.getRaza(),
            mascota.getEdad(),
            mascota.getPeso()
       
        });
    }

    return modelo;
}

    
}
