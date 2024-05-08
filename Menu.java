
package Evaluacion2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Garaje garaje; // Referencia al objeto Garaje

    public Menu(Garaje garaje) {
        this.garaje = garaje;
    }

    public void mostrarMenu() {
        System.out.println("\n**Menú de gestión del Garaje**");
        System.out.println("1. Alquilar un espacio");
        System.out.println("2. Retirar vehículo");
        System.out.println("3. Consulta de ingresos mensuales");
        System.out.println("4. Consulta proporción autos / motos");
        System.out.println("5. Listado de matrículas, cuota mensual y tipo vehículo");
        System.out.println("0. Salir");

        System.out.print("Ingrese la opción deseada: ");
    }

    public int obtenerOpcionMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        try {
            opcion = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error: Debe ingresar una opción numérica.");
            opcion = -1; // Valor por defecto para indicar error
        }
        scanner.nextLine(); // Consumir el salto de línea
        return opcion;
    }

    public void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                alquilarEspacio();
                break;
            case 2:
                retirarVehiculo();
                break;
            case 3:
                consultarIngresosMensuales();
                break;
            case 4:
                consultarProporcionAutosMotos();
                break;
            case 5:
                listarVehiculos();
                break;
            case 0:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private void alquilarEspacio() {
        System.out.print("Ingrese la marca del vehículo: ");
        String marca = new Scanner(System.in).nextLine();
        System.out.print("Ingrese el precio del vehículo: ");
        double precio = new Scanner(System.in).nextDouble();
        System.out.print("Ingrese la cilindrada del vehículo: ");
        int cilindrada = new Scanner(System.in).nextInt();

        System.out.print("¿Tiene radio? (s/n): ");
        String tieneRadioStr = new Scanner(System.in).nextLine();
        boolean tieneRadio = tieneRadioStr.equalsIgnoreCase("s");

        System.out.print("¿Tiene navegador? (s/n): ");
        String tieneNavegadorStr = new Scanner(System.in).nextLine();
        boolean tieneNavegador = tieneNavegadorStr.equalsIgnoreCase("s");

        Vehiculo vehiculo = new Auto(marca, precio, cilindrada, tieneRadio, tieneNavegador);
        garaje.alquilarEspacio(vehiculo );
    }

    private void retirarVehiculo() {
        System.out.print("Ingrese la matrícula del vehículo a retirar: ");
        String placa = new Scanner(System.in).nextLine();
        garaje.retirarVehiculo(placa);
    }

    private void consultarIngresosMensuales() {
        double ingresos = garaje.calcularIngresos();
        System.out.println("Ingresos mensuales: $" + ingresos);
    }

    private void consultarProporcionAutosMotos() {
        int ocupacionAutos = garaje.calcularOcupacionPorTipoVehiculo(new Auto());
        int ocupacionMotos = garaje.calcularOcupacionPorTipoVehiculo(new Moto());
        double proporcion = (double) ocupacionAutos / ocupacionMotos;
        System.out.println("Proporción autos / motos: " + proporcion);
    }

    private void listarVehiculos() {
        System.out.println("\n**Listado de vehículos**");
        System.out.format("%-20s %-15s %-10s %-8s\n", "Matrícula", "Cuota", "Tipo", "Marca");
        for (Vehiculo vehiculo : garaje.getEspacios()) {
            if (vehiculo != null) {
                System.out.format("%-20s %-15.2f %-10s %-8s\n",
                        vehiculo.getPlaca(), vehiculo.getCuotaMesGaraje(),
                        vehiculo.getClass().getSimpleName(), vehiculo.getMarca());
            }
        }
    }
}
