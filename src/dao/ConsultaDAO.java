/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.ConsultaDTO;
import dto.MascotaDTO;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author sandro rendon
 */
public class ConsultaDAO {
    
     private ArrayList<ConsultaDTO> consultas = new ArrayList<>();
     
     private MascotaDAO mascotaDAO;
    
    public ConsultaDAO (MascotaDAO mascotaDAO) {
        this.mascotaDAO = mascotaDAO;
    }
    
    public MascotaDTO buscarMascota (String nombre){
            return mascotaDAO.buscar(nombre);
        }

    public boolean agregarConsulta(ConsultaDTO consulta) {
        if (buscarConsulta(consulta.getId()) == null) {
            consultas.add(consulta);
            return true;
        }
        return false;
    }
    
      public ConsultaDTO buscarConsulta(String id) {
        for (ConsultaDTO consulta : consultas) {
            if (consulta.getId().equalsIgnoreCase(id)) {
                return consulta ;
            }
        }
        return null;
    }
      
            public boolean editarConsulta(String id, LocalDate fecha, String nomMascota ) {
        ConsultaDTO aux = buscarConsulta(id);
        MascotaDTO mascota = buscarMascota(nomMascota);
        if (aux != null && mascota!=null) {
            aux.setFecha(fecha);
            aux.setId(id);
                }
            return true;
        }
}

        
 
    

