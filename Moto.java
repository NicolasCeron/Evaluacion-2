
package Evaluacion2;

/**
 *
 * @author LENOVO
 */

public class Moto extends Vehiculo{
    private boolean tieneSidecar;

    public Moto(boolean tieneSidecar, String marca, double precio, int cilindraje) {
        super(marca, precio, cilindraje);
        this.tieneSidecar = tieneSidecar;
    }

    public boolean isTieneSidecar() {
        return tieneSidecar;
    }

    public void setTieneSidecar(boolean tieneSidecar) {
        this.tieneSidecar = tieneSidecar;
    }
    
    @Override
    public double calcularImpuestoCirculacion(){
        double impuestoBase = super.calcularImpuestoCirculacion();
        if(tieneSidecar){
             impuestoBase *=1.1;
        }
        return impuestoBase;
    }
    
    @Override
    public void setCuotaMesGaraje(double cuotaMesGaraje){
        if (tieneSidecar){
        super.setCuotaMesGaraje(cuotaMesGaraje*1.5);
        }else{
            super.setCuotaMesGaraje(cuotaMesGaraje);
        }
    }
}
