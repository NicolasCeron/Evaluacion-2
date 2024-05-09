
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
           
                // Verificar si hay más del 80% de espacios ocupados por motos
                if (calcularOcupacionPorTipoVehiculo(new Moto(true, "Suzuki", 8000, 125)) <= 0.8 * getCantidadOcupados()) {
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
            System.out.println("Error: No hay espacios disponibles en el garaje.");
        }
        //Asignar espacios para las camionetas
        if (vehiculo instanceof Camioneta) {
        Camioneta camioneta = (Camioneta) vehiculo;
        if (camioneta.getTipo().equalsIgnoreCase("carga") || camioneta.getTipo().equalsIgnoreCase("otro")) {
            int espaciosOcupadosPorCamionetasCargaOtro = 0;
            for (Vehiculo espacio : espacios) {
                if (espacio instanceof Camioneta && 
                        (espacio.getTipo.equalsIgnoreCase("carga") || espacio.getTipo().equalsIgnoreCase("otro"))) {
                    espaciosOcupadosPorCamionetasCargaOtro++;
                }
            }
            if (espaciosOcupadosPorCamionetasCargaOtro >= espacios.length * 0.1) {
                System.out.println("Error: No se pueden alquilar más espacios para camionetas de tipo 'Carga' u 'Otro'.");
                return;
            }
        }
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
    
    //Metodo Nuevo para consultar la proporcion de los autos
    public double consultarProporcionAutosMotos() {
    int totalVehiculos = 0;
    int autos = 0;
    int motos = 0;
    int camionetas = 0;

    for (Vehiculo vehiculo : espacios) {
        if (vehiculo != null) {
            totalVehiculos++;
            if (vehiculo instanceof Auto) {
                autos++;
            } else if (vehiculo instanceof Moto) {
                motos++;
            } else if (vehiculo instanceof Camioneta) {
                camionetas++;
            }
        }
    }

    if (totalVehiculos == 0) {
        System.out.println("No hay vehículos en el garaje para calcular la proporción.");
        return 0;
    }

    double proporcionAutos = (double) autos / totalVehiculos * 100;
    double proporcionMotos = (double) motos / totalVehiculos * 100;
    double proporcionCamionetas = (double) camionetas / totalVehiculos * 100;

    System.out.println("Proporción Autos: " + String.format("2f", proporcionAutos) + "%");
    System.out.println("Proporción Motos: " + String.format("2f", proporcionMotos) + "%");
    System.out.println("Proporción Camionetas: " + String.format("2f", proporcionCamionetas) + "%");

    return proporcionAutos; // Puede devolver la proporción que desee
}
}
