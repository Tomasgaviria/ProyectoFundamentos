import java.util.ArrayList;
public class Sensor {
      public static Sensor[] sensores = new Sensor[8];
      public static final int TAMAÑO = 8;
      public static int posAñadir = 0;
      private String tipo;
      private double valor;
      public static Sensor [] teOrden;
 
   public Sensor(){
          sensores[posAñadir] = this;
          posAñadir = posAñadir++;
   }
   
   public Sensor(String t, double v){
        this.tipo = t;
        this.valor = v;
        sensores[posAñadir] = this;
        posAñadir = posAñadir++;
   }
   
   public int getPosAñadir(){
        return this.posAñadir;
   }
   
   public String getTipo(){
        return this.tipo;
   }
    
   public double getValor(){
        return this.valor;
   }
   
   public int setPosAñadir(int pos){
        return this.posAñadir = pos;
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
    
   public static String toStringSensores(){
        String sensoresUnidos= "";
         for(int i=0; i<Sensor.posAñadir; i++){           
        sensoresUnidos = sensoresUnidos + sensores[i].toString();     
       }
       if(sensoresUnidos.equals("")){
           sensoresUnidos = "no hay sensores";
        }
       return sensoresUnidos; 
   }
      
   public static int cantidadSensores(){
          return posAñadir;
   }
      
   public static String temperaturaSensores(){
          String temperatura = "";
          if(posAñadir !=0){
              for(int i = 0; i<posAñadir; i++){
                  if((sensores[i].getTipo()).equals("temperatura")){
                      temperatura = temperatura + sensores[i].toString();
                }
            }  
        }
         if(temperatura.equals("")){
            temperatura = "no hay sensores de tipo temperatura";
        }
         return temperatura;
   }
      
      public static Sensor[] listaTemperaturas(){
          ArrayList<Sensor>cantidadTemperaturas = new ArrayList();
          for(int i=0; i<posAñadir;i++){
          int j=0;
          if((sensores[i].getTipo()).equals("temperatura")){
              cantidadTemperaturas.add(sensores[i]);
              j++;
            }
        }
        int ocupado = cantidadTemperaturas.size();
        Sensor te;
        Sensor[] teOrden  = new Sensor [ocupado];
        for(int i=0; i<ocupado;i++){
            teOrden[i] = cantidadTemperaturas.get(i);
        }
        for(int j=1; j<teOrden.length-j;j++){
            for(int k=0; k<teOrden.length-j;k++){
                if(teOrden[k].getValor()>teOrden[k+1].getValor()){
                    te = teOrden[k];
                    teOrden[k] = teOrden[k+1];
                    teOrden[k+1] = te;
        }
        }
        }
        return teOrden;
   }
   public static String toStringOrden(Sensor[]temperatura){
       String orden = "";
       for(int i = 0; i<temperatura.length; i++){
           orden = orden + (temperatura[i].toString());
        }
        return orden;
    }
}