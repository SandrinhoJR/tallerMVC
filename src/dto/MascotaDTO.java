/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author sandro rendon
 */
public class MascotaDTO {
    
      private String nombre;

    // Tipo de animal, por ejemplo: perro, gato, etc.
    private String especie;

  private String raza;
    
    // Edad en años
    private int edad;
    
      private Double peso;

    // private ArrayList<Consulta> consultas;
    // Antes se usaba una lista directamente en esta clase para guardar las consultas
    // ✅ Refactor: delegar a clase Historial
   // private HistorialDTO historial; // Antes usabamos una clase aparte para manejar las consultas
      //Refactor: ahora utilizamos un arraylist único
      private ArrayList <EventoClinicoDTO> historial;

    // Constructor para crear una mascota con su nombre, especie y edad
    public MascotaDTO(String nombre, String especie, String raza, int edad, Double peso) {
  /*      this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
         */
        // ✅ Refactor: usar setters + historial
        setNombre(nombre); // Se valida y asigna el nombre
        setEspecie(especie); // Se valida y asigna la especie
        setRaza(raza);
        setEdad(edad); // Se valida y asigna la edad
        setPeso(peso);
        //this.historial = new HistorialDTO(); // Se crea el historial vacío
        this.historial = new ArrayList <>();
    }

   /* public void agregarConsulta(ConsultaDTO consulta) {
        // consultas.add(consulta);
        historial.agregarConsulta(consulta); // ✅ delegar: ahora se agrega al historial
    }
    
    public void agregarVacuna (VacunaDTO vacuna){
        historial.agregarVacuna(vacuna);
    }
    */
    
    public void agregarEvento(EventoClinicoDTO evento){
        historial.add(evento);
    }

    // Devuelve el nombre de la mascota
    public String getNombre() {
        return nombre;
    }

    /*
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
     */
   public void setNombre(String nombre) {
//        if (nombre == null || nombre.isBlank()) {
//            throw new IllegalArgumentException("Nombre inválido."); // Validación básica
//        }
     this.nombre = nombre;
   }

    public void setEspecie(String especie) {
        if (especie == null || especie.isBlank()) {
            throw new IllegalArgumentException("Especie inválida."); // Validación básica
        }
        this.especie = especie;
    }

    public void setEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("Edad no puede ser negativa."); // Validación básica
        }
        this.edad = edad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
    
    

    // Devuelve la especie de la mascota
    public String getEspecie() {
        return especie;
    }

    /*
    public void setEspecie(String especie) {
        this.especie = especie;
    }
     */
    // Devuelve la edad actual
    public int getEdad() {
        return edad;
    }

    /*
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
     */   
    /*public HistorialDTO getHistorial() {
    return historial;
    }
    */

    public ArrayList<EventoClinicoDTO> getHistorial() {
        return historial;
    }

    public void setHistorial(ArrayList<EventoClinicoDTO> historial) {
        this.historial = historial;
    }


    // Método para mostrar el historial de la mascota
   /* public void mostrarHistorial() {
        JOptionPane.showMessageDialog(null, "📋 Mascota: " + nombre + " | Especie: " + especie + " | Edad: " + edad + " años" +"\n"+   historial.mostrarConsultas()+
                historial.mostrarVacunas());
    }
*/
     public void mostrarHistorial() {
        String historialClinico= "";
        for (EventoClinicoDTO e : historial){
            historialClinico+=e.mostrarDetalles()+"\n";
        }
        JOptionPane.showMessageDialog(null, "📋 Mascota: " + nombre + " | Especie: " + especie + " | Edad: " + edad + " años" +"\n"+historialClinico);
    }

    // Devuelve toda la info de la mascota como un texto ordenado
    @Override
    public String toString() {
        String info = "Nombre: " + nombre + "\n";
        info += "Especie: " + especie + "\n";
        info += "Edad: " + edad + " anios\n";
        info += "\n";

        return info;
    }
    
}

