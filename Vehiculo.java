import java.util.ArrayList;

public class Vehiculo 
{
    private int modelo;
    private String marca;
    private double valorComercial;
    private String color;
    public final static int TAMANO = 10;
    public static ArrayList <Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    private int id;
    public static int idPosicion = 1;
    private ArrayList <Sensor> sensores = new ArrayList<Sensor>();
    
    public Vehiculo() {
        this.id = Vehiculo.idPosicion - 1;
        Vehiculo.vehiculos.add(this);
        Vehiculo.idPosicion++;
     }

    public Vehiculo(int modelo, String marca, double valorComercial) {
        this(modelo,marca,valorComercial,"verde");
     }

    public Vehiculo(int modelo, String marca, double valorComercial, String color) {
        this.modelo = modelo;
        this.marca = marca;
        this.valorComercial = valorComercial;
        this.color = color;
        this.id = Vehiculo.idPosicion - 1;
        Vehiculo.vehiculos.add(this);
        Vehiculo.idPosicion++;
    }
    
    public static Vehiculo idVehiculo(int id){
       Vehiculo v1 = new Vehiculo();
       for(int i=0; i<Vehiculo.vehiculos.size(); i++){
        if(id == Vehiculo.vehiculos.get(i).getId()){
            return Vehiculo.vehiculos.get(i);
        }
       }
        return v1;
    }
    
    public String toString() {
        String infoVehiculo = "* " + this.id + ", " + this.modelo + ", " + this.marca + ", " + this.valorComercial + ", " + this.color + " *";
        for(int i =0; i<this.sensores.size(); i++){
            infoVehiculo = infoVehiculo + this.sensores.get(i).toString();
        
        }
        return infoVehiculo;
    }

    public static String toStringVehiculos() {
        String totalVehiculos="";
        for(int i=0;i<Vehiculo.vehiculos.size();i++){
           totalVehiculos = totalVehiculos + Vehiculo.vehiculos.get(i).toString();
        }
        if(totalVehiculos.equals("")){
            totalVehiculos = "no hay vehiculos";
        }
        return totalVehiculos;
    }

    public static int cantidadVehiculos()
    {
        return Vehiculo.vehiculos.size();
    }
    
    public int cantidadSensores(){
        return this.sensores.size();
    }
  
    public int getModelo() {
        return this.modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getValorComercial() {
        return this.valorComercial;
    }

    public void setValorComercial(double valorComercial) {
        this.valorComercial = valorComercial;
     }

    public String getColor() {
        return this.color;
     }

    public void setColor(String color) {
        this.color = color;
     }
     
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public ArrayList<Sensor> getSensores(){
        return this.sensores;
    }
    
    public void setSensores(ArrayList<Sensor> s){
        this.sensores = s;
    }
    
    public static String soloVerdes(){
        String losVerdes="";
        if(Vehiculo.vehiculos.size()!=0){
            for(int i=0; i<Vehiculo.vehiculos.size(); i++){
                if((Vehiculo.vehiculos.get(i).getColor()).equals("verde")){
                    losVerdes = losVerdes + Vehiculo.vehiculos.get(i).toString();
                }
            }
        }
        if(losVerdes.equals("")){
          losVerdes= "no hay vehiculos verdes";
        }
        return losVerdes;
    }
     
    public void anadirSensor(Sensor s){
        this.sensores.add(s); 
    }
    
    public static String unionSensorVehiculo(){
        int j = 0;
        for(int i=1; i<Vehiculo.vehiculos.size(); i++){
            if ((Vehiculo.vehiculos.get(j).sensores.size())<(Vehiculo.vehiculos.get(i).sensores.size())){
                j = i;
            }
        }
        return Vehiculo.vehiculos.get(j).toString();
    }
}