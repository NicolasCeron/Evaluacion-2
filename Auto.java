
package Evaluacion2;

/**
 *
 * @author LENOVO
 */
public class Auto extends Vehiculo{
    private boolean tieneRadio;
    private boolean tieneNavegador;
    
    public Auto(String marca, double precio, int cilindraje, boolean tieneNavegador, boolean tieneRadio) {
        super(marca, precio, cilindraje);
        this.tieneRadio = tieneRadio;
        this.tieneNavegador = tieneNavegador;
    }

    void Auto() {
    }
   
    
    @Override
    public double calcularImpuestoCirculacion(){
        double impuestoBase =super.calcularImpuestoCirculacion();
        double incrementoRadio = 0;
        double incrementoNavegador = 0;

        if(tieneRadio=true){
            incrementoRadio = impuestoBase*1.01;    //precio+1%
        }
        if(tieneNavegador=true){
            incrementoNavegador = impuestoBase*1.02;    //precio +2%
        } 
        return impuestoBase + incrementoNavegador + incrementoRadio;
    }
    
    public boolean isTieneRadio() {
        return tieneRadio;
    }

    public void setTieneRadio(boolean tieneRadio) {
        this.tieneRadio = tieneRadio;
    }

    public boolean isTieneNavegador() {
        return tieneNavegador;
    }

    public void setTieneNavegador(boolean tieneNavegador) {
        this.tieneNavegador = tieneNavegador;
    }
    
    @Override
    public void setCuotaMesGaraje(double cuotaMesGaraje){
         if(getCilindraje()>2499){
            cuotaMesGaraje*=1.2;
        }    
         super.setCuotaMesGaraje(cuotaMesGaraje);
    }    
}
