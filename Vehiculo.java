
package Evaluacion2;

/**
 *
 * @author NicolasCeronCastaño
 */
public class Vehiculo {
    private String placa;
    private String marca;
    private double precio;
    private int cilindraje;
    private double impuestoCirculacion;
    private double cuotaMesGaraje;

        public Vehiculo(String marca, double precio, int cilindraje) {
            this.cuotaMesGaraje = 100;
            this.placa = null;
            this.marca = marca;
            this.precio = precio;
            this.cilindraje = cilindraje;
            this.impuestoCirculacion = calcularImpuestoCirculacion();
        }
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public double getImpuestoCirculacion() {
        return impuestoCirculacion;
    }

    public double getCuotaMesGaraje() {
        return cuotaMesGaraje;
    }

    public void setCuotaMesGaraje(double cuotaMesGaraje){
        if(cuotaMesGaraje<0){
            System.out.println("    Error: la cuota del garaje no puede ser negativa");
        }else{
            this.cuotaMesGaraje=cuotaMesGaraje;
        }
    }
    
     public double calcularImpuestoCirculacion(){
        return precio * 0.02;
    }
     
    public boolean matricular(String matricula){
        if(matricula.length()==6){
            this.placa = matricula;
            return true;
        }else{
            System.out.println("Error: La matricula debe tener 6 caracteres");
            return false;
        }
    }
}
   
    

