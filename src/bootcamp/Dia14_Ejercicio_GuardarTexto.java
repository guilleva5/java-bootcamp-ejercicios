package bootcamp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Dia14_Ejercicio_GuardarTexto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            FileWriter escritor = new FileWriter("mensajes.txt");

            for (int i=1;i<=3;i++){
                System.out.println("Mensaje "+i+": ");
                String mensaje = scanner.nextLine();
                escritor.write(mensaje+"\n");
            }
            escritor.close();
            System.out.println("\nMensajes guardados");


        }catch (IOException e){
            System.out.println("Error: "+e.getMessage());
        }

        System.out.println("\n ---Mensajes guardados---");
        try {
            FileReader archivo= new FileReader("mensajes.txt");
            BufferedReader lector = new BufferedReader(archivo);
            String linea;
            while ((linea = lector.readLine()) !=null){
                System.out.println(linea);
            }
            lector.close();


        }catch (IOException e){
            System.out.println("Error : "+e.getMessage());
        }
        scanner.close();
    }
}
