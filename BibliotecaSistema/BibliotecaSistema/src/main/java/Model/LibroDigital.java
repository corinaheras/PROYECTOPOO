/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS
 */
public class LibroDigital extends Libro {
    
    // Atributos específicos encapsulados
    private String formatoArchivo; // Ejemplo: "PDF", "EPUB"
    private double tamanoMB;

    // Constructor que usa super() para inicializar los datos del padre
    public LibroDigital(String codigo, String titulo, String autor, int anioPublicacion, 
                        String formatoArchivo, double tamanoMB) {
        super(codigo, titulo, autor, anioPublicacion);
        this.formatoArchivo = formatoArchivo;
        this.tamanoMB = tamanoMB;
    }

    // Sobreescritura del método abstracto (Polimorfismo)
    @Override
    public String mostrarDetalles() {
        return "[DIGITAL] Código: " + getCodigo() + 
               " | Título: " + getTitulo() + 
               " | Formato: " + formatoArchivo + 
               " | Tamaño: " + tamanoMB + " MB";
    }

    // Getters y Setters específicos
    public String getFormatoArchivo() {
        return formatoArchivo;
    }

    public void setFormatoArchivo(String formatoArchivo) {
        this.formatoArchivo = formatoArchivo;
    }

    public double getTamanoMB() {
        return tamanoMB;
    }

    public void setTamanoMB(double tamanoMB) {
        this.tamanoMB = tamanoMB;
    }  
}
