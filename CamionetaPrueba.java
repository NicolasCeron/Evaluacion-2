
package Evaluacion2;

/**
 *
 * @author LENOVO
 */
public class CamionetaPrueba {
    public static void main(String[] args) {
        Camioneta camioneta1 = new Camioneta("Pickup",2,"Ford",3500,1300);
        Camioneta camioneta2 = new Camioneta("SUV",8,"Chevrolet",12400,3150);
        Camioneta camioneta3 = new Camioneta("Carga",4,"renoult",4800,1850);
            
        
            System.out.println("Camioneta 1: ");
            System.out.println("    Marca: "+camioneta1.getMarca());
            System.out.println("    Precio: "+camioneta1.getPrecio());
            System.out.println("    Cilindraje: "+camioneta1.getCilindraje());
            System.out.println("    Impuesto Circulacion: "+camioneta1.getImpuestoCirculacion());

            camioneta1.setCuotaMesGaraje(800);
         System.out.println("    Cuota de garaje: "+camioneta1.getCuotaMesGaraje());

        System.out.println("-------");
         
            System.out.println("Camioneta 2: ");
            System.out.println("    Marca: "+camioneta2.getMarca());
            System.out.println("    Precio: "+camioneta2.getPrecio());
            System.out.println("    Cilindraje: "+camioneta2.getCilindraje());
            System.out.println("    Impuesto Circulacion: "+camioneta2.getImpuestoCirculacion());
        
            camioneta2.setCuotaMesGaraje(2100);
         System.out.println("    Cuota de garaje: "+camioneta2.getCuotaMesGaraje());
         
         System.out.println("------");
         
          System.out.println("Camioneta 3: ");
            System.out.println("    Marca: "+camioneta3.getMarca());
            System.out.println("    Precio: "+camioneta3.getPrecio());
            System.out.println("    Cilindraje: "+camioneta3.getCilindraje());
            System.out.println("    Impuesto Circulacion: "+camioneta3.getImpuestoCirculacion());

            camioneta3.setCuotaMesGaraje(900);
         System.out.println("    Cuota de garaje: "+camioneta3.getCuotaMesGaraje());
    }
    
}
