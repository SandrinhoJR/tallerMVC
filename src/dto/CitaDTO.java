/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDate;
import java.time.LocalTime;
import modelo.Mascota;
import modelo.Propietario;
import modelo.Veterinario;

/**
 *
 * @author sandro rendon
 */
public class CitaDTO extends EventoClinicoDTO{
    
    
    private LocalTime hora;
    private Mascota mascota;
    private Propietario propietario;
    private Veterinario veterinario;

    public CitaDTO(LocalTime hora, Mascota mascota, Propietario propietario, Veterinario veterinario, String id, LocalDate fecha) {
        super(id, fecha);
        this.hora = hora;
        this.mascota = mascota;
        this.propietario = propietario;
        this.veterinario = veterinario;
    }


    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

     @Override
    public String mostrarDetalles() {
        String info = "ID   : " + id + "\n";
        info += "Fecha: " + fecha + "\n";
        info += "Hora: " + hora + "\n";
        info += "Mascota: " + mascota.getNombre() + "\n";
          info += "Propietario: " + propietario.getNombre()+ "\n";
        info += "Veterinario: " + veterinario.getNombre()+ "\n";
        return info;
    } 
}
