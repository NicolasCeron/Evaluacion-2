
package Evaluacion2;

/**
 *
 * @author LENOVO
 */

public class Garaje implements iGarage {
      // Constante que define el número de espacios
    private static final int NUMERO_ESPACIOS = 10; // Ejemplo, se puede cambiar

    // Colección para almacenar los vehículos
    private Vehiculo[] espacios;

    // Constructor para inicializar la colección de espacios
    public Garaje() {
        espacios = new Vehiculo[NUMERO_ESPACIOS];
    }

    // Método para alquilar un espacio
    public void alquilarEspacio(Vehiculo vehiculo) {
        // Verificar si hay espacios disponibles
        if (hayEspacioDisponible()) {
            // Verificar si el vehículo tiene matrícula
            if (vehiculo.getPlaca() != null) {
                // Verificar si hay más del 80% de espacios ocupados por motos
                if (calcularOcupacionPorTipoVehiculo(new Moto()) <= 0.8 * getCantidadOcupados()) {
                    // Buscar un espacio libre y asignar el vehículo
                    for (int i = 0; i < espacios.length; i++) {
                        if (espacios[i] == null) {
                            espacios[i] = vehiculo;
                            System.out.println("Espacio alquilado correctamente.");
                            break;
                        }
                    }
                } else {
                    System.out.println("Error: No se pueden ocupar más del 80% de los espacios con motos.");
                }
            } else {
                System.out.println("Error: El vehículo no tiene matrícula. No se puede alquilar.");
            }
        } else {
            System.out.println("Error: No hay espacios disponibles en el garaje.");
        }
    }

    // Método para verificar si hay espacio disponible
    private boolean hayEspacioDisponible() {
        for (Vehiculo espacio : espacios) {
            if (espacio == null) {
                return true;
            }
        }
        return false;
    }

    // Método para retirar un vehículo
    public void retirarVehiculo(String placa) {
        // Buscar el vehículo por su matrícula
        for (int i = 0; i < espacios.length; i++) {
            if (espacios[i] != null && espacios[i].getPlaca().equals(placa)) {
                espacios[i] = null; // Liberar el espacio
                System.out.println("Vehículo retirado correctamente.");
                break;
            }
        }
    }

    // Método para calcular los ingresos mensuales
    public double calcularIngresos() {
        double ingresosTotales = 0;
        for (Vehiculo vehiculo : espacios) {
            if (vehiculo != null) {
                ingresosTotales += vehiculo.getCuotaMesGaraje();
            }
        }
        return ingresosTotales;
    }

    // Método para calcular la ocupación por tipo de vehículo
    public int calcularOcupacionPorTipoVehiculo(Vehiculo tipoVehiculo) {
        int ocupacion = 0;
        for (Vehiculo vehiculo : espacios) {
            if (vehiculo != null && vehiculo.getClass().equals(tipoVehiculo.getClass())) {
                ocupacion++;
            }
        }
        return ocupacion;
    }

    // Método para obtener la cantidad de espacios ocupados
    public int getCantidadOcupados() {
        int ocupados = 0;
        for (Vehiculo espacio : espacios) {
            if (espacio != null) {
                ocupados++;
            }
        }
        return ocupados;
    }

    // Método para obtener la colección de espacios
    public Vehiculo[] getEspacios() {
        return espacios;
    }

    // Método principal para ejecutar el programa
    public static void main(String[] args) {
        Garaje garaje = new Garaje();
        Menu menu = new Menu(garaje);

        int opcionMenu;
        do {
            menu.mostrarMenu();
            opcionMenu = menu.obtenerOpcionMenu();
            menu.ejecutarOpcion(opcionMenu);
        } while (opcionMenu != 0);
    }
}
