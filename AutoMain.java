
package Evaluacion2;

/**
 *
 * @author LENOVO
 */
public class AutoMain {
    public static void main(String[] args) {
        Auto auto1 = new Auto ("Ford", 4540, 2650, true, true );
        System.out.println("Auto 1: ");
        System.out.println("    Placa: "+auto1.getPlaca());
        System.out.println("    Marca: "+auto1.getMarca());
        System.out.println("    Precio: "+auto1.getPrecio());
        System.out.println("    Cilindraje: "+auto1.getCilindraje());
        System.out.println("    Impuesto Circulacion: "+auto1.getImpuestoCirculacion());
        System.out.println("    Tiene radio?: "+auto1.isTieneRadio());
        System.out.println("    Tiene navegador?: "+auto1.isTieneNavegador());

        if (auto1.matricular("ABC123")) {
            System.out.println("    Matricula asignada correctamente.");
            System.out.println("        -Nueva placa: "+auto1.getPlaca());

        } else {
            System.out.println("    Error al asignar matricula.");
        }
         auto1.setCuotaMesGaraje(2400);
         System.out.println("    Cuota de garaje: "+auto1.getCuotaMesGaraje());
        
         System.out.println("-----------");
    }       
}
   

