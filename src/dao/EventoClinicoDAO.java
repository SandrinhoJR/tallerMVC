/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.CitaDTO;
import dto.ConsultaDTO;
import dto.EventoClinicoDTO;
import dto.MascotaDTO;
import dto.VacunaDTO;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sandro rendon
 */
public class EventoClinicoDAO {
    
      ArrayList<EventoClinicoDTO> eClinicos;
      
   /* private ArrayList<CitaDTO> citas = new ArrayList<>();
    private ArrayList<ConsultaDTO> consultas = new ArrayList<>();
    private ArrayList<VacunaDTO> vacunas = new ArrayList<>();
*/
    private MascotaDAO mascotaDAO;
    
        public EventoClinicoDAO(MascotaDAO mascotaDAO) {
        eClinicos = new ArrayList<>();
        this.mascotaDAO = mascotaDAO;
    }
        public ArrayList <MascotaDTO> getMascotas (){
            return mascotaDAO.getMascotasVeterinario();
        }
        
        public MascotaDTO buscarMascota (String nombre){
            return mascotaDAO.buscar(nombre);
        }

    public EventoClinicoDTO buscarEvento(String id) {
        for (EventoClinicoDTO evento : eClinicos) {
            if (evento.getId() == id) {
                return evento;
            }
        }
        return null;
    }

    public CitaDTO buscarCita(String id) {
        EventoClinicoDTO aux = buscarEvento(id);
        if (aux instanceof CitaDTO) {
            CitaDTO cita = (CitaDTO) aux;
            return cita;
        }
        return null;
    }

    public ConsultaDTO buscarConsulta(String id) {
        EventoClinicoDTO aux = buscarEvento(id);
        if (aux instanceof ConsultaDTO) {
            ConsultaDTO consulta = (ConsultaDTO) aux;
            return consulta;
        }
        return null;
    }
    
      public VacunaDTO buscarVacuna(String id) {
        EventoClinicoDTO aux = buscarEvento(id);
        if (aux instanceof VacunaDTO) {
            VacunaDTO vacuna = (VacunaDTO) aux;
            return vacuna;
        }
        return null;
    }
      
      public boolean agregarEvento(EventoClinicoDTO evento, String nomMascota) {
        EventoClinicoDTO aux = buscarEvento(evento.getId());
        if (aux == null) {
            if (aux instanceof CitaDTO){
            eClinicos.add(evento);
            } else{
             eClinicos.add(evento);
             MascotaDTO mas = buscarMascota(nomMascota);
             mas.agregarEvento(evento);
            }
         
            return true;
        }
        return false;
    }
      
       public boolean editarEvento( EventoClinicoDTO evento) {
        EventoClinicoDTO aux = buscarEvento(evento.getId());
        if (aux != null) {
            aux.setId(evento.getId());
            aux.setFecha(evento.getFecha());
            return true;
        }
        return false;
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
         
        public boolean editarConsulta(String id, LocalDate fecha, String nomMascota ) {
        ConsultaDTO aux = buscarConsulta(id);
        MascotaDTO mascota = buscarMascota(nomMascota);
        if (aux != null && mascota!=null) {
            aux.setFecha(fecha);
            for (EventoClinicoDTO c : mascota.getHistorial()){
                if (c.getId().equalsIgnoreCase(id)){
                c.setFecha(fecha);
                break;
           }
        }
            return true;
    }
        return false;
 }
        
           
        public boolean editarVacuna (VacunaDTO vacuna, String nomMascota) {
        VacunaDTO aux = buscarVacuna(vacuna.getId());
        MascotaDTO mascota = buscarMascota(nomMascota);
        if (aux != null && mascota !=null) {
            aux.setFecha(vacuna.getFecha());
            aux.setNombre(vacuna.getNombre());
            aux.setLote(vacuna.getLote());
            aux.setTipo(vacuna.getLote());
            aux.setProxDosis(vacuna.getProxDosis());
            
              for (EventoClinicoDTO v : mascota.getHistorial()){
               if (v instanceof VacunaDTO && v.getId().equalsIgnoreCase(vacuna.getId())){
                   VacunaDTO vac = (VacunaDTO) v;
                vac.setFecha(vacuna.getFecha());
                vac.setNombre(vacuna.getNombre());
                vac.setLote(vacuna.getLote());
                vac.setTipo(vacuna.getTipo());
                vac.setProxDosis(vacuna.getProxDosis());
                break;
                 }
              }
            return true;
        }
        return false;
    }
            
    public DefaultTableModel listarCita() {
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.setColumnIdentifiers(new String[]{"Id", "Fecha", "Hora","Mascota","Propietario","Veterinario"});
    for (EventoClinicoDTO evento : eClinicos) {
            if (evento instanceof CitaDTO){
                CitaDTO cita = (CitaDTO) evento;
            modelo.addRow(new Object[]{
            cita.getId(),
            cita.getFecha(),
            cita.getHora(),
            cita.getMascota().getNombre(),
            cita.getPropietario().getNombre(),
            cita.getVeterinario().getNombre()
            });
        }
    }

    return modelo;
}

    public DefaultTableModel listarConsulta() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new String[]{"Veterinario"});
        for (EventoClinicoDTO evento : eClinicos) {
            if (evento instanceof ConsultaDTO){
                ConsultaDTO consulta = (ConsultaDTO) evento;
                modelo.addRow(new Object[]{
                    consulta.getId(),
                    consulta.getFecha(),
                    consulta.getVeterinario().getNombre()
            });
            }
      }

      return modelo;
 }
    
    public DefaultTableModel listarVacuna() {
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.setColumnIdentifiers(new String[]{"Nombre", "Lote","Tipo","ProxDosis"});
     for (EventoClinicoDTO evento : eClinicos) { 
          if (evento instanceof VacunaDTO){
              VacunaDTO vacuna = (VacunaDTO) evento;
              modelo.addRow(new Object[]{
              vacuna.getNombre(),
              vacuna.getLote(),
              vacuna.getTipo(),
              vacuna.getProxDosis()
             });
         }
     }
    return modelo;
  }
}

