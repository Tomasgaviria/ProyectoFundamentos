import java.util.Scanner;
public class PrincipalProyecto{
    Scanner scan = new Scanner(System.in);
    public static void main(String [] args){
        PrincipalProyecto.mostrarMenu();
    }
    
    public static void mostrarMenu(){
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("Ingrese número:");
            int n = scan.nextInt();
             if(n == 0){
                break;
            }
             else if(n == 1){
                   if (Vehiculo.posAnadir<Vehiculo.TAMANO){
                  System.out.println("Ingrese modelo:");
                  int modelo = scan.nextInt();
                  System.out.println("Ingrese marca:");
                  String marca = scan.next();
                  System.out.println("Ingrese valor comercial:");
                  double valorComercial= scan.nextDouble();
                  System.out.println("Ingrese color:");
                  String color = scan.next();
                  Vehiculo v1 = new Vehiculo(modelo, marca, valorComercial, color);
              }else {System.out.println("Error base de datos llena");
               }
            }
             else if(n == 2){
                 System.out.println(Vehiculo.toStringVehiculos());
             }
             else if(n == 3){
                 System.out.println(Vehiculo.cantidadVehiculos());
             }
             else if(n == 4){
                System.out.println(Vehiculo.soloVerdes());
             }
             else if(n == 5){
                if(Sensor.posAñadir<Sensor.TAMAÑO){
                   System.out.println("Ingrese tipo:");
                   String tipo = scan.next();
                   System.out.println("Ingrese valor comercial:");
                   double valorComercial = scan.nextDouble();
                   Sensor s1 = new Sensor (tipo, valorComercial);
                }else{
                    System.out.println("Error base de datos llena");
                }
             } 
             else if(n == 6){
                System.out.println(Sensor.toStringSensores());
             }
             else if(n == 7){
                System.out.println(Sensor.cantidadSensores());
                }
             else if(n == 8){
                 System.out.println(Sensor.temperaturaSensores());
                }
             else if(n == 666){
               System.out.println(Sensor.toStringOrden(Sensor.listaTemperaturas()));
               }else{
               break;
             }
            }
    }
}
