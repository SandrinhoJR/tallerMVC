/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.PersonaDTO;
import dto.VeterinarioDTO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sandro rendon
 */
public class VeterinarioDAO {
    
    private ArrayList<VeterinarioDTO> veterinarios = new ArrayList<>();

  public boolean agregarVet (VeterinarioDTO veterinario) {
      if (buscarVet (veterinario.getId()) == null) {
          veterinarios.add(veterinario);
          return true;
      }
      return false;
  }
  
  public VeterinarioDTO buscarVet (String id) {
      for (VeterinarioDTO veterinario : veterinarios) {
          if (veterinario.getId().equalsIgnoreCase(id)) {
              return veterinario;
          }
      }
      return null;
  }
  
      public boolean editarVeterinario(VeterinarioDTO veterinario) {
        VeterinarioDTO aux = buscarVet(veterinario.getId());
        if (aux != null) {
            aux.setId(veterinario.getId());
            aux.setNombre(veterinario.getNombre());
            aux.setEspecialidad(veterinario.getEspecialidad());
            aux.setDisponibilidad(veterinario.getDisponibilidad());
            return true;
        }
        return false;
    }
      
      public boolean eliminarVet (String id) {
          VeterinarioDTO veterinario = buscarVet(id);
          if (veterinario !=null) {
              veterinarios.remove(veterinario);
              return true;
          }
          return false;
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
          
            public ArrayList<VeterinarioDTO> getVeterinarioDTO() {
        return veterinarios;
    }
    
}
