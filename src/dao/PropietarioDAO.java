/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.MascotaDTO;
import dto.PropietarioDTO;
import dto.VeterinarioDTO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sandro rendon
 */
public class PropietarioDAO {
    
    
    private ArrayList<PropietarioDTO> propietarios = new ArrayList<>();

  public boolean agregarPro (PropietarioDTO propietario) {
      if (buscarPro (propietario.getId()) == null) {
          propietarios.add(propietario);
          return true;
      }
      return false;
  }
  
  public PropietarioDTO buscarPro (String id) {
      for (PropietarioDTO propietario : propietarios) {
          if (propietario.getId().equalsIgnoreCase(id)) {
              return propietario;
          }
      }
      return null;
  }
  
      public boolean editarPropietario(PropietarioDTO propietario) {
        PropietarioDTO aux = buscarPro(propietario.getId());
        if (aux != null) {
            aux.setNombre(propietario.getNombre());
            aux.setTelefono(propietario.getTelefono());
            return true;
        }
        return false;
    }
      
           public boolean eliminarPro(String id) {
          PropietarioDTO propietario = buscarPro(id);
          if (propietario !=null) {
              propietarios.remove(propietario);
              return true;
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
    
}
