
package Evaluacion2;

/**
 *
 * @author LENOVO
 */
public class MotoMain {
    public static void main(String[] args) {
     Moto moto1 = new Moto(true, "Honda", 280,210);
        System.out.println("Moto 1: ");
        System.out.println("    Placa: "+moto1.getPlaca());
        System.out.println("    Marca: "+moto1.getMarca());
        System.out.println("    Precio: "+moto1.getPrecio());
        System.out.println("    Cilindraje: "+moto1.getCilindraje());
        System.out.println("    Impuesto Circulacion: "+moto1.getImpuestoCirculacion());
       //mostrar si tiene sidecar 
        if(moto1.isTieneSidecar()){
            System.out.println("    Tiene Sidecar?: Si");
        }else{
            System.out.println("    Tiene Sidecar?: No");
        }
        //Matricular moto
        if (moto1.matricular("ABC123")) {
            System.out.println("    Matricula asignada correctamente: ");
            System.out.println("        -Nueva placa: "+moto1.getPlaca());
        } else {
            System.out.println("    Error al asignar matricula.");
        }
         moto1.setCuotaMesGaraje(500);
         System.out.println("    Cuota de garaje: "+moto1.getCuotaMesGaraje());
         
                 System.out.println("------------");
         
         Moto moto2 = new Moto(false, "Yamaha", 344,410);
        System.out.println("Moto 2: ");
        System.out.println("    Placa: "+moto2.getPlaca());
        System.out.println("    Marca: "+moto2.getMarca());
        System.out.println("    Precio: "+moto2.getPrecio());
        System.out.println("    Cilindraje: "+moto2.getCilindraje());
        System.out.println("    Impuesto Circulacion: "+moto2.getImpuestoCirculacion());
        //mostrar si tiene sidecar 
        if(moto2.isTieneSidecar()){
            System.out.println("    Tiene Sidecar?: Si");
        }else{
            System.out.println("    Tiene Sidecar?: No");
        }
        if (moto2.matricular("CDE32")) {
            System.out.println("    Matricula asignada correctamente: ");
            System.out.println("        -Nueva placa: "+moto2.getPlaca());
        } else {
            System.out.println("    Error al asignar matricula.");
        }
         moto2.setCuotaMesGaraje(800);
         System.out.println("    Cuota de garaje: "+moto2.getCuotaMesGaraje());
    
    }
}

