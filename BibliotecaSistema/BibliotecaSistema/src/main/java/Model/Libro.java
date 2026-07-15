/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.io.Serializable;
/**
 *
 * @author ASUS
 */
public abstract class Libro implements Serializable {
    
// Cumpliendo la rúbrica: Atributo static y final (Constante)
    public static final String RUTA_ARCHIVO = "biblioteca.dat";

    // Atributos encapsulados (private)
    private String codigo;
    private String titulo;
    private String autor;
    private int anioPublicacion;

    // Constructor completo
    public Libro(String codigo, String titulo, String autor, int anioPublicacion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }

    // Método abstracto para aplicar Polimorfismo. 
    // Las clases hijas estarán obligadas a definir cómo muestran sus detalles.
    public abstract String mostrarDetalles();

    // Métodos Getters y Setters para cumplir con el Encapsulamiento
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }
    
}
