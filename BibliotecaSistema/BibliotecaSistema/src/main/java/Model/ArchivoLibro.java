/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ArchivoLibro {
      
    // --- C (CREATE) - AGREGAR AL FINAL DEL ARCHIVO ---
    public static void registrarLibro(Libro libro) {
        try {
            File archivo = new File(Libro.RUTA_ARCHIVO);
            ObjectOutputStream salida; 

            // Si ya existe y tiene datos, usamos appendable para no dañar la estructura
            if (archivo.exists() && archivo.length() > 0) {
                salida = new AppendableObjectOutputStream(new FileOutputStream(archivo, true));
            } else {
                salida = new ObjectOutputStream(new FileOutputStream(archivo));
            }
            
            salida.writeObject(libro);
            salida.close();
            System.out.println("Libro registrado exitosamente en el archivo.");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    // --- R (READ) - MOSTRAR TODOS ---
    public static void consultarTodos() {
        File archivo = new File(Libro.RUTA_ARCHIVO);
        if (!archivo.exists() || archivo.length() == 0) {
            System.out.println("La biblioteca está vacía.");
            return;
        }

        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivo))) {
            System.out.println("\n=== LISTADO COMPLETO DE LIBROS ===");
            while (true) {
                Libro libro = (Libro) entrada.readObject();
                System.out.println(libro.mostrarDetalles());
                System.out.println("----------------------------------------------------------------");
            }
        } catch (EOFException e) {
            // Fin esperado del archivo
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer: " + e.getMessage()); 
        }
    }

    // --- R (READ) - BUSCAR POR CÓDIGO ---
    public static void buscarPorCodigo(String codigo) {
        File archivo = new File(Libro.RUTA_ARCHIVO);
        if (!archivo.exists() || archivo.length() == 0) {
            System.out.println("El archivo no existe.");
            return;
        }

        boolean encontrado = false;
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivo))) {
            while (true) {
                Libro libro = (Libro) entrada.readObject();
                if (libro.getCodigo().equalsIgnoreCase(codigo)) {
                    System.out.println("\n¡Libro Encontrado!");
                    System.out.println(libro.mostrarDetalles());
                    encontrado = true;
                    break; 
                }
            }
        } catch (EOFException e) {
            if (!encontrado) {
                System.out.println("No se encontró ningún libro con el código: " + codigo);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } 
    }

    // --- U (UPDATE) - MODIFICAR DIRECTO EN ARCHIVO ---
    public static void modificarTituloLibro(String codigo, String nuevoTitulo) {
        File archivoOriginal = new File(Libro.RUTA_ARCHIVO);
        File archivoTemp = new File("temp.dat");
        boolean encontrado = false;

        if (!archivoOriginal.exists()) {
            System.out.println("El archivo no existe.");
            return;
        }

        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivoOriginal));
             ObjectOutputStream salidaTemp = new ObjectOutputStream(new FileOutputStream(archivoTemp))) {
             
            while (true) {
                try {
                    Libro libro = (Libro) entrada.readObject();
                    
                    if (libro.getCodigo().equalsIgnoreCase(codigo)) {
                        libro.setTitulo(nuevoTitulo); // Modificamos el dato
                        encontrado = true;
                    }
                    // Escribimos el libro (modificado o no) en el temporal
                    salidaTemp.writeObject(libro);
                    
                } catch (EOFException e) {
                    break; // Fin del archivo original
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error durante la modificación: " + e.getMessage());
        }

        // Intercambio de archivos
        archivoOriginal.delete();
        archivoTemp.renameTo(archivoOriginal);

        if (encontrado) {
            System.out.println("Libro actualizado exitosamente.");
        } else {
            System.out.println("No se encontró el código. No se hicieron cambios.");
        }
    }

    // --- D (DELETE) - ELIMINAR DIRECTO EN ARCHIVO ---
    public static void eliminarLibro(String codigo) {
        File archivoOriginal = new File(Libro.RUTA_ARCHIVO);
        File archivoTemp = new File("temp.dat");
        boolean eliminado = false;

        if (!archivoOriginal.exists()) {
            System.out.println("El archivo no existe.");
            return;
        }

        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivoOriginal));
             ObjectOutputStream salidaTemp = new ObjectOutputStream(new FileOutputStream(archivoTemp))) {
             
            while (true) {
                try {
                    Libro libro = (Libro) entrada.readObject();
                    
                    if (libro.getCodigo().equalsIgnoreCase(codigo)) {
                        eliminado = true;
                        // NO escribimos este libro en el archivo temporal (lo estamos borrando)
                    } else {
                        // Si no es el que queremos borrar, lo conservamos pasándolo al temporal
                        salidaTemp.writeObject(libro);
                    }
                    
                } catch (EOFException e) {
                    break; 
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error durante la eliminación: " + e.getMessage());
        }

        // Intercambio de archivos
        archivoOriginal.delete();
        archivoTemp.renameTo(archivoOriginal);

        if (eliminado) {
            System.out.println("Libro eliminado del registro.");
        } else {
            System.out.println("No se encontró el código. No se eliminó nada.");
        }
    }
}