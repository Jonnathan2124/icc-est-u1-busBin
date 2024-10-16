
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de Personas: ");
        int cantidadPersonas = scanner.nextInt();
        scanner.nextLine();

        Persona[] personas = new Persona[cantidadPersonas];
        int[] personasInt = new int[cantidadPersonas];

        ///PEDIR AL USUARIO QUE INGRESE LOS DATOS DE LAS PERSONAS

        for(int i = 0; i < cantidadPersonas; i++){
            System.out.println("Ingrese el nombre de la Persona " + (i+1) + ":");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese la edad de la persona " + nombre + ":");

            int edad = scanner.nextInt();

            scanner.nextLine();

            personas[i] = new Persona(nombre, edad);
        }

        sortByEdad(personas);

        System.out.println("Ingrese el nombre de la Persona que desea Buscar: ");
        //int posicion = scanner.nextLine();

        scanner.close();

        for(Persona persona :personas){
            System.out.println(persona);
        } 
    }

    public static void sortByEdad(Persona[] personas){
        for(int i=0; i < personas.length; i++){
            for (int j = i+1; j < personas.length; j++) {
                if(personas[i].getEdad()>personas[j].getEdad()){
                    Persona aux=personas[i];
                    personas[i]=personas[j];
                    personas[j]=aux;
                }
            }
        }
    }

    public int busquedaBinaria(int[] arr, int value){
        int inicio = 0;
        int fin = arr.length -1;

        while(inicio <= fin){
            int medio = inicio + (fin - inicio) / 2;
            
            if(arr[medio] == value){
                //Elemento econtrado
                return medio;
            }

            if(arr[medio] < value){

                inicio = medio+1;//Buscar en la mitad de la derecha
            }else{
                fin = medio -1;//Buscar en la mitad de la izquierda
            }
        }
        return -1;
    }
}
