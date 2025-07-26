/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.EventoClinicoDAO;
import dao.MascotaDAO;
import dao.PersonaDAO;
import dto.ConsultaDTO;
import dto.MascotaDTO;
import dto.PropietarioDTO;

/**
 *
 * @author sandro rendon
 */

public class ControladorConsulta {
    private EventoClinicoDAO eventoClinicoDAO; // DAO para manejar eventos clínicos
    private PersonaDAO personaDAO; // DAO para manejar propietarios

    public ControladorConsulta(EventoClinicoDAO eventoClinicoDAO, PersonaDAO personaDAO) {
        this.eventoClinicoDAO = eventoClinicoDAO;
        this.personaDAO = personaDAO; // Usar PersonaDAO para manejar propietarios
    }

    public boolean guardar(ConsultaDTO consulta) {
        // Validaciones
        if (consulta == null) {
            throw new IllegalArgumentException("La consulta no puede ser nula.");
        }
        if (consulta.getFecha() == null) {
            throw new IllegalArgumentException("La fecha de la consulta no puede estar vacía.");
        }

        // Obtener el ID del propietario
        String idPropietario = consulta
        PropietarioDTO propietario = (PropietarioDTO) personaDAO.buscarPersona(idPropietario);
        
        // Verifica que el propietario exista
        if (propietario == null) {
            throw new IllegalStateException("El propietario no existe.");
        }

        // Guardar la consulta en el DAO de eventos clínicos
        return eventoClinicoDAO.agregarEvento(consulta, null); // Guardar la consulta en el DAO de eventos clínicos
    }

    public ConsultaDTO buscar(String id) {
        // Validación
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("El ID de la consulta no puede estar vacío.");
        }
        return (ConsultaDTO) eventoClinicoDAO.buscarEvento(id);
    }

    public boolean editar(ConsultaDTO consulta) {
        // Validaciones
        if (consulta == null) {
            throw new IllegalArgumentException("La consulta no puede ser nula.");
        }
        if (consulta.getId() == null || consulta.getId().isEmpty()) {
            throw new IllegalArgumentException("El ID de la consulta no puede estar vacío.");
        }

        // Lógica de negocio
        return eventoClinicoDAO.editarEvento(consulta); 
    }

    
}


