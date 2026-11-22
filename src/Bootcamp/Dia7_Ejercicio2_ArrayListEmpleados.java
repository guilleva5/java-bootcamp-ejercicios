package Bootcamp;

import java.util.ArrayList;

public class Dia7_Ejercicio2_ArrayListEmpleados {
    public static void main(String[] args) {
        ArrayList<Empleado>empleados=new ArrayList<>();
        empleados.add(new Empleado("Juan García", "12345678A", 30, 1500, "IT"));
        empleados.add(new Empleado("María López", "87654321B", 28, 1800,"Ventas"));
        empleados.add(new Empleado("Pedro Martín", "11111111C", 35, 2000, "IT"));
        empleados.add(new Empleado("Ana Ruiz", "22222222D", 26, 1400,"RRHH"));

        System.out.println("---Lista de empleados---");
        for (int i =0;i< empleados.size();i++){
            empleados.get(i).mostrarInfo();
        }
        System.out.println("Numero total de empleados :"+empleados.size());
        System.out.println();

        empleados.add(new Empleado("Carlos Sanz", "33333333E", 40, 2500, "Finanzas"));
        empleados.add(new Empleado("Laura Torres", "44444444F", 32, 1700, "Ventas"));
        System.out.println("Se han contratado 2 nuevos empleados: ");
        System.out.println("Numero total de empleados :"+empleados.size());
        for (int i =0;i< empleados.size();i++){
            empleados.get(i).mostrarInfo();
        }
        System.out.println();
        System.out.println("---Despido---");

        empleados.remove(1);
        System.out.println( "María López ha sido despedida");
        System.out.println("Numero total de empleados :"+empleados.size());
        for (int i =0;i< empleados.size();i++){
            empleados.get(i).mostrarInfo();
        }

        System.out.println("---Aumento de salario---");
        for (int i =0;i< empleados.size();i++){
            if (empleados.get(i).getNombre().equalsIgnoreCase("Juan García")){
                empleados.get(i).aumentarSalario(15);
                empleados.get(i).mostrarInfo();
                break;
            }
        }


    }
}
