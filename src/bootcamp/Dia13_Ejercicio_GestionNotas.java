package bootcamp;

import java.util.ArrayList;
import java.util.Scanner;

public class Dia13_Ejercicio_GestionNotas {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        ArrayList<Double>notas=new ArrayList<>();

        int opcion=0;
        do {
            System.out.println("---Gestion de notas---");
            System.out.println("1. Añadir nota");
            System.out.println("2. Ver nota de un alumno");
            System.out.println("3. Calcular promedio");
            System.out.println("4. Ver todas las notas");
            System.out.println("5. Salir");
            System.out.print("Elige opción: ");

            try {
                opcion=Integer.parseInt(scanner.nextLine());
                switch (opcion){
                    case 1:
                        System.out.println("Introduce una nota (0-10): ");
                        try {
                            double nota= Double.parseDouble(scanner.nextLine());
                            if(nota <0 || nota >10){
                                System.out.println("Error: La nota debe estar entre 0 y 10");
                            }else {
                                notas.add(nota);
                                System.out.println("Nota añadidad correctamente");
                            }
                        }catch (NumberFormatException e){
                            System.out.println("Debes introducir un numero");
                        }
                        break;
                    case 2:
                        System.out.println("Introduce la posicion del alumno:");
                        try {
                            int posicion = Integer.parseInt(scanner.nextLine());
                            double nota= notas.get(posicion);
                            System.out.println("Alumno :"+ posicion +" :"+nota);
                        }catch (NumberFormatException e){
                            System.out.println("Debes introducir un numero");
                        }catch (IndexOutOfBoundsException e){
                            System.out.println("Total alumnos: " + notas.size());
                        }
                        break;
                    case 3:
                        System.out.println("---Calcular promedio:---");
                            if(notas.isEmpty()){
                                System.out.println("Error : No hay notas para calcular promedio");
                            }
                            else {
                                double notaTotal=0;
                                for (int i=0;i<notas.size();i++){
                                    notaTotal+=notas.get(i);
                                }
                                double promedio=notaTotal/notas.size();
                                System.out.println("La nota promedio de la clase es de :"+promedio);
                            }
                            break;
                    case 4:
                        if(notas.isEmpty()){
                            System.out.println("No hay notas registradas");
                        }else {
                            System.out.println("---Notas registradas---");
                            for (int i =0; i<notas.size(); i++){
                                System.out.println("Alumno "+i+": "+notas.get(i));
                            }
                        }
                        break;
                    case 5:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opcion invalida");
                }
            }catch (NumberFormatException e){
                System.out.println("Error:Debes introducir un numero");
                opcion=0;
            }
        }while(opcion!=5);
        scanner.close();
        }
    }

