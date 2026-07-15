/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS
 */
public class LibroFisico extends Libro{
    
    // Atributos específicos encapsulados
    private String pasillo;
    private String estante;
    private String estado; // Ejemplo: "Nuevo", "Bueno", "Deteriorado"

    // Constructor que usa super() para enviar los datos comunes al padre
    public LibroFisico(String codigo, String titulo, String autor, int anioPublicacion, String pasillo, String estante, String estado) {
        super(codigo, titulo, autor, anioPublicacion); 
        this.pasillo = pasillo;
        this.estante = estante;
        this.estado = estado;
    }

    // Sobreescritura del método abstracto (Polimorfismo)
    @Override
    public String mostrarDetalles() {
        return "[FÍSICO] Código: " + getCodigo() + 
               " | Título: " + getTitulo() + 
               " | Ubicación: Pasillo " + pasillo + ", Estante " + estante + 
               " | Estado: " + estado;
    }

    // Getters y Setters específicos
    public String getPasillo() {
        return pasillo;
    }

    public void setPasillo(String pasillo) {
        this.pasillo = pasillo;
    }

    public String getEstante() {
        return estante;
    }

    public void setEstante(String estante) {
        this.estante = estante;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
