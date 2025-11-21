import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class AddContent {

    static Scanner scanner = new Scanner(System.in);
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    static final String CARPETA = "category"; // Carpeta fija para los JSON

    public static void agregarContenido() {
        try {
            System.out.print("Ingrese el nombre del archivo JSON (con extensión): ");
            String fileName = scanner.nextLine();

            // Crear la carpeta category si no existe
            File carpeta = new File(CARPETA);
            if (!carpeta.exists()) {
                carpeta.mkdir();
            }

            File file = new File(CARPETA + File.separator + fileName);

            List<Contenido> contenidos = new ArrayList<>();

            if (!file.exists()) {
                System.out.println("No existe dicho archivo, desea crearlo? (Si/No)");
                String respuesta = scanner.nextLine();
                if (respuesta.equalsIgnoreCase("Si")) {
                    file.createNewFile();
                    System.out.println("Archivo creado exitosamente en " + file.getAbsolutePath());
                } else {
                    System.out.println("Operación cancelada.");
                    return;
                }
            } else {
                // Leer contenido existente
                FileReader reader = new FileReader(file);
                contenidos = gson.fromJson(reader, new TypeToken<List<Contenido>>() {
                }.getType());
                if (contenidos == null)
                    contenidos = new ArrayList<>();
                reader.close();
            }

            boolean continuar = true;
            while (continuar) {
                Contenido nuevo = new Contenido();

                // ID automático
                int maxId = contenidos.stream().mapToInt(c -> c.id).max().orElse(0);
                nuevo.id = maxId + 1;

                System.out.print("Ingrese el slug (será el identificador del contenido): ");
                String slug = scanner.nextLine();

                // Verificar si el slug existe
                Contenido existente = contenidos.stream()
                        .filter(c -> c.slug.equalsIgnoreCase(slug))
                        .findFirst()
                        .orElse(null);
                if (existente != null) {
                    System.out.println("Ya existe un contenido con este slug, ¿desea reemplazarlo? (Si/No)");
                    String resp = scanner.nextLine();
                    if (resp.equalsIgnoreCase("Si")) {
                        nuevo.id = existente.id; // Mantener mismo ID
                        contenidos.remove(existente);
                    } else {
                        System.out.println("Contenido no añadido.");
                        continue;
                    }
                }
                nuevo.slug = slug;

                System.out.print("Ingrese el título del contenido: ");
                nuevo.titulo = scanner.nextLine();

                System.out.print("Ingrese el nombre de la portada: ");
                nuevo.portada = scanner.nextLine();

                System.out.print("Ingrese el texto alternativo (Alt) de la portada: ");
                nuevo.alt = scanner.nextLine();

                // Descripción múltiple
                System.out.println("Ingrese la descripción (múltiples párrafos):");
                nuevo.descripcion = capturarMultiplesParrafos("descripcion");

                // Historia múltiple
                System.out.println("Ingrese la historia (múltiples párrafos):");
                nuevo.historia = capturarMultiplesParrafos("historia");

                // Detalles
                nuevo.detalles = new Detalles();
                System.out.print("Ingrese el Título Original: ");
                nuevo.detalles.tituloOriginal = scanner.nextLine();
                System.out.print("Ingrese la Versión: ");
                nuevo.detalles.version = scanner.nextLine();
                System.out.print("Ingrese el Autor: ");
                nuevo.detalles.autor = scanner.nextLine();
                System.out.print("Ingrese el Motor: ");
                nuevo.detalles.motor = scanner.nextLine();
                System.out.print("Ingrese el Peso: ");
                nuevo.detalles.peso = scanner.nextLine();
                System.out.print("Ingrese la Password: ");
                nuevo.detalles.password = scanner.nextLine();

                // Etiquetas múltiples
                System.out.println("Ingrese las etiquetas (múltiples líneas):");
                nuevo.etiquetas = capturarMultiplesParrafos("etiquetas");

                // Guía de instalación
                nuevo.guia_instalacion = new GuiaInstalacion();
                System.out.print("Ingrese la Guía principal: ");
                nuevo.guia_instalacion.principal = scanner.nextLine();
                System.out.println("Ingrese la Guía secundaria (múltiples líneas):");
                nuevo.guia_instalacion.secundario = capturarMultiplesParrafos("guia secundaria");

                System.out.print("Ingrese la Fecha de publicación (YYYY-MM-DD): ");
                nuevo.fecha_publicacion = scanner.nextLine();

                System.out.print("Ingrese el Traductor: ");
                nuevo.traductor = scanner.nextLine();

                System.out.print("Ingrese el Estado: ");
                nuevo.estado = scanner.nextLine();

                contenidos.add(nuevo);

                // Guardar en JSON
                FileWriter writer = new FileWriter(file);
                gson.toJson(contenidos, writer);
                writer.flush();
                writer.close();

                System.out.println("Contenido añadido exitosamente.");
                System.out.println("¿Desea continuar añadiendo contenido? (Si/No)");
                String cont = scanner.nextLine();
                if (!cont.equalsIgnoreCase("Si")) {
                    continuar = false;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<String> capturarMultiplesParrafos(String nombreCampo) {
        List<String> lista = new ArrayList<>();
        System.out.println("Para continuar un párrafo simplemente escriba y presione ENTER. " +
                "Para no añadir más, presione ENTER sin escribir nada. [" + nombreCampo + "]");
        while (true) {
            String linea = scanner.nextLine();
            if (linea.isEmpty())
                break;
            lista.add(linea);
        }
        return lista;
    }

    // Clases internas para modelar JSON
    static class Contenido {
        int id;
        String slug;
        String titulo;
        String portada;
        String alt;
        List<String> descripcion;
        List<String> historia;
        Detalles detalles;
        List<String> etiquetas;
        GuiaInstalacion guia_instalacion;
        String fecha_publicacion;
        String traductor;
        String estado;
    }

    static class Detalles {
        String tituloOriginal;
        String version;
        String autor;
        String motor;
        String peso;
        String password;
    }

    static class GuiaInstalacion {
        String principal;
        List<String> secundario;
    }
}