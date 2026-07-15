/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Main;

import java.util.Scanner;
import Model.LibroFisico;
import Model.LibroDigital;
import Model.ArchivoLibro;

public class BibliotecaSistema {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== SISTEMA BIBLIOTECARIO (GESTIÓN DIRECTA .DAT) =====");
            System.out.println("1.- Registrar Libro Físico");
            System.out.println("2.- Registrar Libro Digital");
            System.out.println("3.- Mostrar todos los libros");
            System.out.println("4.- Buscar libro por Código");
            System.out.println("5.- Modificar Título de un libro");
            System.out.println("6.- Eliminar libro");
            System.out.println("0.- Salir");
            System.out.print("Escoja la opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Código: ");
                    String codF = sc.next();
                    sc.nextLine(); // Limpiar buffer
                    System.out.print("Título: ");
                    String titF = sc.nextLine();
                    System.out.print("Autor: ");
                    String autF = sc.nextLine();
                    System.out.print("Año: ");
                    int anioF = sc.nextInt();
                    System.out.println("Pasillo: ");
                    String pasF = sc.nextLine();
                    System.out.println("Estante: ");
                    String estanF = sc.nextLine();
                    System.out.println("Estado: ");
                    String estadoF = sc.nextLine();
                    
                    LibroFisico libroF = new LibroFisico(codF, titF, autF, anioF, pasF, estanF, estadoF);
                    ArchivoLibro.registrarLibro(libroF);
                    break;
                    
                case 2:
                    System.out.print("Código: ");
                    String codD = sc.next();
                    sc.nextLine(); 
                    System.out.print("Título: ");
                    String titD = sc.nextLine();
                    System.out.print("Autor: ");
                    String autD = sc.nextLine();
                    System.out.print("Año: ");
                    int anioD = sc.nextInt();
                    System.out.println("Formato Archivo: ");
                    String formD = sc.nextLine();
                    System.out.println("Tamano MB: ");
                    double tamanoD = sc.nextDouble();
                    
                    LibroDigital libroD = new LibroDigital(codD, titD, autD, anioD, formD, tamanoD);
                    ArchivoLibro.registrarLibro(libroD);
                    break;

                case 3:
                    ArchivoLibro.consultarTodos();
                    break;

                case 4:
                    System.out.print("Ingrese el código a buscar: ");
                    String buscarCod = sc.next();
                    ArchivoLibro.buscarPorCodigo(buscarCod);
                    break;

                case 5:
                    System.out.print("Ingrese el código del libro a modificar: ");
                    String modCod = sc.next();
                    sc.nextLine();
                    System.out.print("Ingrese el nuevo título: ");
                    String nuevoTit = sc.nextLine();
                    ArchivoLibro.modificarTituloLibro(modCod, nuevoTit);
                    break;

                case 6:
                    System.out.print("Ingrese el código del libro a eliminar: ");
                    String elimCod = sc.next();
                    ArchivoLibro.eliminarLibro(elimCod);
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;
                    
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
            
        } while (opcion != 0);
        
        sc.close();
    }
}