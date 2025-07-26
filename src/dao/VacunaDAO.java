/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.MascotaDTO;
import dto.VacunaDTO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import dao.MascotaDAO;

/**
 *
 * @author sandro rendon
 */
public class VacunaDAO {
    
        private ArrayList<VacunaDTO > vacunas = new ArrayList<>();
        private ArrayList<MascotaDTO> mascotasVeterinario = new ArrayList<>();

    private MascotaDAO mascotaDAO;
    
    public VacunaDAO (MascotaDAO mascotaDAO) {
        this.mascotaDAO = mascotaDAO;
    }
    
    public MascotaDTO buscarMascota (String nombre){
            return mascotaDAO.buscar(nombre);
        }
        
        

    public boolean agregarVacuna(VacunaDTO vacuna) {
        if (buscarVacuna(vacuna.getId()) == null) {
            vacunas.add(vacuna  );
            return true;
        }
        return false;
    }
    
        public VacunaDTO buscarVacuna (String id) {
        for (VacunaDTO vacuna : vacunas) {
            if (vacuna.getId().equalsIgnoreCase(id)) {
                return vacuna;
            }
        }
        return null;
    }
        
           public boolean editarVacuna (VacunaDTO vacuna, String nomMascota) {
        VacunaDTO aux = buscarVacuna(vacuna.getId());
         MascotaDTO mascota = buscarMascota(nomMascota) ;
        if (aux != null && mascota !=null) {
            aux.setFecha(vacuna.getFecha());
            aux.setNombre(vacuna.getNombre());
            aux.setLote(vacuna.getLote());
            aux.setTipo(vacuna.getLote());
            aux.setProxDosis(vacuna.getProxDosis());
            }
            return true;
        }
           
            public DefaultTableModel listarVacuna() {
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.setColumnIdentifiers(new String[]{"Nombre", "Lote","Tipo","ProxDosis"});
     for (VacunaDTO vacuna : vacunas) { 
              modelo.addRow(new Object[]{
              vacuna.getNombre(),
              vacuna.getLote(),
              vacuna.getTipo(),
              vacuna.getProxDosis()
             });
         }
     
    return modelo;
}
}