
package Evaluacion2;

/**
 *
 * @author LENOVO
 */
public class Camioneta extends Vehiculo {
    private String tipo; //(SUV, Pickup, Carga, Otro)
    private  int numPasajeros;

    //constructor
    public Camioneta(String tipo, int numPasajeros, String marca, double precio, int cilindraje) {
        super(marca, precio, cilindraje);
        this.tipo = tipo;
        this.numPasajeros = numPasajeros;
    }
//agrego getters de los nuevos atributos
    public String getTipo() {
        return tipo;
    }

    public int getNumPasajeros() {
        return numPasajeros;
    }
    
    @Override
    public double calcularImpuestoCirculacion(){
        double impuestoBase = super.calcularImpuestoCirculacion();
        impuestoBase*=0.5;
        return impuestoBase;
    }
  //Cuota de garaje con los nuevos parametros
    @Override
    public void setCuotaMesGaraje(double cuotaMesGaraje){
        if (numEjes()==2){
        super.setCuotaMesGaraje(cuotaMesGaraje*1.75);//si tiene 2 ejes se aumenta un 75%
        }else if(numEjes()>2){
            super.setCuotaMesGaraje(cuotaMesGaraje*2);//si tiene mas se aumenta un 100%
        }
    }
    
    //metodo para dar numero de ejes a las diferentes camionetas
    private int numEjes() {
        if (tipo.equalsIgnoreCase("pickup") || tipo.equalsIgnoreCase("carga")) {
            return 2; // Camionetas Pickup y Carga tendran dos ejes
        } else {
            return 3; // Las demas camionetas tendran tres ejes
        }
    }
   
    // Método para validar el número de pasajeros (Pickup y Carga)
    private boolean validarNumeroPasajeros() {
        if (tipo.equalsIgnoreCase("pickup") || tipo.equalsIgnoreCase("carga")) {
            return numPasajeros <= 2;
        } else {
            return true;
        }
    }    
}
