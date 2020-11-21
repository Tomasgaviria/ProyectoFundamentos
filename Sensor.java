import java.util.ArrayList;
public class Sensor {
    private String tipo;
    private double valor;

    public Sensor(){
    }

    public Sensor(String t, double v){
        this.tipo = t;
        this.valor = v;
    }

    public String getTipo(){
        return this.tipo;
    }

    public double getValor(){
        return this.valor;
    }

    public String setTipo(String t){
        return this.tipo = t;
    }

    public double setValor(double v){
        return this.valor = v;
    }

    public String toString(){
        String infoSensor = " *"+this.tipo +", "+this.valor +"*";
        return infoSensor;                
    } 

    public static String toStringSensores(Vehiculo v1){
        String sensoresUnidos= "";
        for(int i=0; i<v1.cantidadSensores(); i++){           
            sensoresUnidos = sensoresUnidos + v1.getSensores().get(i).toString();     
        }
        if(sensoresUnidos.equals("")){
            sensoresUnidos = "En el vehiculo no hay sensores";
        }
        return sensoresUnidos; 
    }

    public static String temperaturaSensores(){
        String infoTemperaturas = "";
        for(int i=0; i<Vehiculo.vehiculos.size(); i++){
            if(Vehiculo.vehiculos.get(i).cantidadSensores()!=0){
                for (int j=0; j<Vehiculo.vehiculos.get(i).cantidadSensores(); j++){
                    if((Vehiculo.vehiculos.get(i).getSensores().get(j).getTipo()).equals("temperatura")){
                        infoTemperaturas = infoTemperaturas + Vehiculo.vehiculos.get(i).getSensores().get(j).toString();
                    }
                }
            } 
        }
        if(infoTemperaturas.equals("")){
            infoTemperaturas = "no hay sensores de tipo temperatura";
        }

        return infoTemperaturas;
    }

    public static ArrayList<Sensor> temperaturaOrden(){
        ArrayList<Sensor>datosTemperatura = new ArrayList();
        for(int i=0; i<Vehiculo.vehiculos.size(); i++){
            if(Vehiculo.vehiculos.get(i).cantidadSensores()!=0){
                for (int j=0; j<Vehiculo.vehiculos.get(i).cantidadSensores(); j++){
                    if((Vehiculo.vehiculos.get(i).getSensores().get(j).getTipo()).equals("temperatura")){
                        datosTemperatura.add(Vehiculo.vehiculos.get(i).getSensores().get(j));
                    }
                }
            } 
        }

        Sensor t1;

        for (int i=1; i<datosTemperatura.size(); i++){
            for (int j=0; j<datosTemperatura.size()-i;j++){
                if (datosTemperatura.get(j).getValor()>datosTemperatura.get(j+1).getValor()){
                    t1 = datosTemperatura.get(j);
                    datosTemperatura.set(j, datosTemperatura.get(j+1));
                    datosTemperatura.set(j+1, t1);
                }
            }
        }

        return datosTemperatura;
    }

    public static String toStringOrdenTemperaturas(ArrayList <Sensor> temperatura){
        String orden= "";
        for(int i=0; i<temperatura.size(); i++){
            orden = orden + (temperatura.get(i).toString());
        }
        if(orden.equals("")){
            orden = "no hay sensores de tipo temperatura";
        }
        return orden;
    }

}