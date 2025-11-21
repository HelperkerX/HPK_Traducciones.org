import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("============================================================================");
            System.out.println("Bienvenido, que deseas hacer?");
            System.out.println("Para elejir una opción escriba su numero correspondiente y presione ENTER");
            System.out.println("============================================================================");
            System.out.println("1. Añadir");
            System.out.println("2. Modificar");
            System.out.println("3. Eliminar");
            System.out.println("4. Organizar");
            System.out.println("============================================================================");
            System.out.println("5. Salir");
            System.out.println("============================================================================");
            System.out.print("Opción: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    AddContent.agregarContenido();
                    break;
                case "2":
                    ModifyContent.modificarContenido();
                    break;
                case "3":
                    DeleteContent.eliminarContenido();
                    break;
                case "4":
                    OrganizeContent.organizarContenido();
                    break;
                case "5":
                    running = false;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        scanner.close();
    }
}
