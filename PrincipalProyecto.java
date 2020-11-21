import java.util.Scanner;
import java.io.File;
public class PrincipalProyecto{
    public static void main(String [] args){
        PrincipalProyecto.mostrarMenu();
    }

    public static void mostrarMenu(){
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("Ingrese número del 1 al 10:");
            int n = scan.nextInt();
            if(n == 0){
                break;
            }
            else if(n == 1){

                System.out.println("Ingrese modelo:");
                int modelo = scan.nextInt();
                System.out.println("Ingrese marca:");
                String marca = scan.next();
                System.out.println("Ingrese valor comercial:");
                double valorComercial= scan.nextDouble();
                System.out.println("Ingrese color:");
                String color = scan.next();
                Vehiculo v1 = new Vehiculo(modelo, marca, valorComercial, color);
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
            else if (n == 5){
                System.out.println("Ingrese ID de vehiculo: ");
                int id = scan.nextInt();
                boolean v1 = false;
                for(int i=0; i<Vehiculo.vehiculos.size(); i++){
                    if(id == Vehiculo.vehiculos.get(i).getId()){
                        System.out.println(Vehiculo.vehiculos.get(i).toString());
                        v1 = true;
                    }
                }
                if(v1==false){
                    System.out.println("El vehiculo con ID '" + id + "' NO FUE HALLADO");
                }
                } else if (n == 6){
                System.out.println("ID de vehiculo: ");
                int id = scan.nextInt();
                Vehiculo v1 = Vehiculo.idVehiculo(id);
                Vehiculo.vehiculos.remove(Vehiculo.vehiculos.size()-1);
                Vehiculo.idPosicion--;
                if(v1.getColor()==null){
                    System.out.println("Error: El vehiculo con ID '" + id + "' NO FUE HALLADO");
                } else{
                    System.out.println("Ingrese tipo de vehiculo: ");
                    String tipo = scan.next();
                    System.out.println("Ingrese valor de vehiculo: ");
                    double valor = scan.nextDouble();
                    Sensor s = new Sensor(tipo, valor);
                    Vehiculo.vehiculos.get(id).anadirSensor(s);
                }
            } else if (n == 7){
                System.out.println("Ingrese ID de vehiculo: ");
                int id = scan.nextInt();
                Vehiculo v1 = Vehiculo.idVehiculo(id);
                Vehiculo.vehiculos.remove(Vehiculo.vehiculos.size()-1);
                Vehiculo.idPosicion--;
                if(v1.getColor()==null){
                    System.out.println("Error: El vehiculo con ID '" + id + "' NO FUE HALLADO");
                } else{
                    System.out.println(Sensor.toStringSensores(v1));
                }
            } else if (n == 8){
                System.out.println(Sensor.temperaturaSensores());
            } else if (n == 9){
                System.out.println(Vehiculo.unionSensorVehiculo());
            } else if (n == 10){
                File file = new File("vehiculos.txt.txt");
                try{
                    Scanner input = new Scanner(file);
                    String line;
                    while(input.hasNextLine()){
                        line = input.nextLine();
                        String[] parts = line.split(",");
                        Vehiculo v = new Vehiculo(Integer.parseInt(parts[0]), parts[1], Double.parseDouble(parts[2]), parts[3]);
                    }
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }

            } else if (n == 666){
                System.out.println(Sensor.toStringOrdenTemperaturas(Sensor.temperaturaOrden()));
            }

        }
    }
}