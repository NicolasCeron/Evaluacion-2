
package Evaluacion2;

/**
 *
 * @author LENOVO
 */
public class GarajePrueba {

    public static void main(String[] args) {
        // Crear un objeto Garaje
        Garaje garaje = new Garaje();

        // Crear algunos vehículos de prueba
        Vehiculo auto1 = new Auto("Toyota", 25000, 1800, true, false);
        Vehiculo moto1 = new Moto(true, "Suzuki", 8000, 125);
        Vehiculo auto2 = new Auto("Mazda", 30000, 2000, false, true);

        // Alquilar los vehículos en el garaje
        garaje.alquilarEspacio(auto1);
        garaje.alquilarEspacio(moto1);
        garaje.alquilarEspacio(auto2);
        
        // Mostrar información del garaje
        System.out.println("Informacion del Garaje: ");
        System.out.println("Número de espacios: " + garaje.getEspacios().length);
        System.out.println("Espacios ocupados: " + garaje.getCantidadOcupados());
        System.out.println("Ingresos mensuales: $" + garaje.calcularIngresos());
        
        // Listar vehículos
        System.out.println("Listado de vehiculos");
        listarVehiculos(garaje.getEspacios());
    }

    private static void listarVehiculos(Vehiculo[] espacios) {
        System.out.format("%-20s %-15s %-10s %-8s", "Matrícula", "Cuota", "Tipo", "Marca");
        for (Vehiculo vehiculo : espacios) {
            if (vehiculo != null) {
                System.out.format("%-20s %-15.2f %-10s %-8s",
                        vehiculo.getPlaca(), vehiculo.getCuotaMesGaraje(),
                        vehiculo.getClass().getSimpleName(), vehiculo.getMarca());
            }
        }
    }
}   

