public class Vehiculo 
{
    public static Vehiculo[] vehiculos  = new Vehiculo[10];
    public static int posAnadir = 0;
    private int modelo;
    private String marca;
    private double valorComercial;
    private String color;
    public final static int TAMANO = 10;

    public Vehiculo() {
        Vehiculo.vehiculos[Vehiculo.posAnadir] = this;
        Vehiculo.posAnadir++;
    }

    public Vehiculo(int modelo, String marca, double valorComercial) {
        this(modelo,marca,valorComercial,"verde");
    }

    public Vehiculo(int modelo, String marca, double valorComercial, String color) {
        this.modelo = modelo;
        this.marca = marca;
        this.valorComercial = valorComercial;
        this.color = color;
        Vehiculo.vehiculos[Vehiculo.posAnadir] = this;
        Vehiculo.posAnadir++;
    }

    public String toString() {
        String infoVehiculo = "* " + this.modelo + ", " + this.marca + ", " + this.valorComercial + ", " + this.color + " *";;
        return infoVehiculo;
    }

    public static String toStringVehiculos() {
        String totalVehiculos="";
        for(int i=0;i<posAnadir;i++){
            totalVehiculos = totalVehiculos+vehiculos[i].toString();
        }
        if(totalVehiculos.equals("")){
            totalVehiculos = "no hay vehiculos";
        }
        return totalVehiculos;
    }

    public static int cantidadVehiculos()
    {
        return posAnadir;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getValorComercial() {
        return valorComercial;
    }

    public void setValorComercial(double valorComercial) {
        this.valorComercial = valorComercial;
     }

    public String getColor() {
        return color;
     }

    public void setColor(String color) {
        this.color = color;
     }

    public static String soloVerdes(){
        String losVerdes="";
        if(Vehiculo.posAnadir!=0){
            for(int i=0; i<posAnadir; i++){
                if((vehiculos[i].getColor()).equals("verde")){
                    losVerdes = losVerdes + vehiculos[i].toString();
                }
            }
        }
        if(losVerdes.equals("")){
            losVerdes= "no hay vehiculos verdes";
        }
        return losVerdes;
    }
}