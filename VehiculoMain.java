
package Evaluacion2;

/**
 *
 * @author LENOVO
 */
public class VehiculoMain {
    public static void main(String[] args) {
        Vehiculo vehiculo1 = new Vehiculo ("Ford", 200, 150);
        Vehiculo vehiculo2 = new Vehiculo ("Ford", 200.22, 150);
    
        //vehiculo1
        System.out.println("vehiculo 1: ");
        System.out.println("    Placa: "+vehiculo1.getPlaca());
        System.out.println("    Marca: "+vehiculo1.getMarca());
        System.out.println("    Precio: "+vehiculo1.getPrecio());
        System.out.println("    Cilindraje: "+vehiculo1.getCilindraje());
        System.out.println("    Impuesto Circulacion: "+vehiculo1.getImpuestoCirculacion());
        
        if (vehiculo1.matricular("ABC123")) {
            System.out.println("    Matricula asignada correctamente.");
        } else {
            System.out.println("    Error al asignar matricula.");
        }
         vehiculo1.setCuotaMesGaraje(500);
         System.out.println("    Cuota de garaje: "+vehiculo1.getCuotaMesGaraje());
    }       
}
