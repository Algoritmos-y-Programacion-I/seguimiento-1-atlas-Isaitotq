package ui;

import java.util.Scanner;

public class Atlas {

    private Scanner escaner;

    // Declaración de constantes
    final double COSTO_POR_NOCHE = 150000;
    final double COSTO_TRAYECTO_AVION = 250000;
    final double COSTO_TRAYECTO_BUS = 80000;
    final double PORCENTAJE_SERVICIO = 0.10;

    private Atlas() {
        escaner = new Scanner(System.in);
    }

    public void run() {
        // Declaración de info a pedir del usuario
        String nombre;
        int edad;
        String documento;
        String ciudad;
        int numeroNoches;
        String tipoTransporte;

        // Saludo y recolección de información
        System.out.println("Bienvenido al programa de viajes EVENTOS ATLAS.");
        
        System.out.print("¿Cual es tu nombre? ");
        nombre = escaner.nextLine();
        
        System.out.print("¿Cual es tu edad? ");
        edad = escaner.nextInt();
        escaner.nextLine(); // Limpiar el buffer
        
        System.out.print("¿Cual es tu numero de documento de identidad? ");
        documento = escaner.nextLine();
        
        System.out.print("¿Desde que ciudad estas cotizando el viaje? ");
        ciudad = escaner.nextLine();
        
        System.out.print("¿Cuantas noches te quedaras? (1 a 4 noches) ");
        numeroNoches = escaner.nextInt();
        escaner.nextLine(); // Limpiar el buffer
        
        // Validar el número de noches
        while (numeroNoches < 1 || numeroNoches > 4) {
            System.out.print("Por favor, ingresa un número de noches valido (1 a 4): ");
            numeroNoches = escaner.nextInt();
            escaner.nextLine(); // Limpiar el buffer
        }

        // Elegir tipo de transporte
        System.out.print("¿Que tipo de transporte prefieres? (Avion/Bus): ");
        tipoTransporte = escaner.nextLine().toLowerCase();

        // Calcular el costo total
        double totalCosto = calcularTotalCosto(numeroNoches, tipoTransporte);
        
        // Mensaje final
        String tipoIdentificacion = (edad < 18) ? "T.I." : "C.C.";
        System.out.println("\n--- Factura de Viaje ---");
        System.out.println(" Nombre: " + nombre);
        System.out.println(" Edad: " + edad);
        System.out.println(" Documento de Identidad: " + tipoIdentificacion + " " + documento);
        System.out.println(" Ciudad: " + ciudad);
        System.out.println(" Numero de Noches: " + numeroNoches);
        System.out.println(" Tipo de Transporte: " + (tipoTransporte.equals("Avion") ? "Avion" : "Bus"));
        System.out.println(" Costo Total: $ " + totalCosto);
    }

    public static void main(String[] args) {
        Atlas mainApp = new Atlas();
        mainApp.run();
    }

    // Método para calcular el costo total
    public double calcularTotalCosto(int numeroNoches, String tipoTransporte) {
        double costoNoches = numeroNoches * COSTO_POR_NOCHE;
        double costoTransporte = 0;

        // Calcular costo de transporte
        if (tipoTransporte.equals("Avion")) {
            costoTransporte = 2 * COSTO_TRAYECTO_AVION; // Ida y vuelta
        } else if (tipoTransporte.equals("Bus")) {
            costoTransporte = 2 * COSTO_TRAYECTO_BUS; // Ida y vuelta
        }

        // Cálculo del costo total
        double costoTotal = costoNoches + costoTransporte;
        double costoConServicio = costoTotal + (costoTotal * PORCENTAJE_SERVICIO);
        
        return costoConServicio;
    }
}
