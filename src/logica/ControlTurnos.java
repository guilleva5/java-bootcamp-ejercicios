package logica;

import java.util.Arrays;

class Turno{
    int empleado;
    double hora;
    boolean nocturno;

    public Turno(int empleado, double hora, boolean nocturno) {
        this.empleado = empleado;
        this.hora = hora;
        this.nocturno = nocturno;
    }

    public int getEmpleado() {
        return empleado;
    }

    public double getHora() {
        return hora;
    }

    public boolean isNocturno() {
        return nocturno;
    }
}
class EmpleadoT{
    int turnos=0;
    double horasTotales=0;
    int numEmpleado;
}

public class ControlTurnos {
    public static void main(String[] args) {


        Turno[] turnos = {
                new Turno(1, 8.0, false),
                new Turno(2, 6.5, false),
                new Turno(3, 8.0, true),
                new Turno(1, 7.5, false),
                new Turno(4, 8.0, true),
                new Turno(2, 8.0, false),
                new Turno(3, 6.0, true),
                new Turno(1, 8.0, true),
                new Turno(4, 20, false),
                new Turno(2, 8.0, false),
                new Turno(3, 8.0, false),
                new Turno(1, 4.0, false)
        };

        int contadorTurnoNocturno=0;

        EmpleadoT []empleadost= new EmpleadoT[5];
        for (int i=0;i<empleadost.length;i++){
            empleadost[i]=new EmpleadoT();
            empleadost[i].numEmpleado=i;
        }
        for (int i=0;i<turnos.length;i++){
            Turno t=turnos[i];
            int e = t.getEmpleado();

            empleadost[e].turnos++;
            empleadost[e].horasTotales+=t.getHora();

            if(t.isNocturno()){
                contadorTurnoNocturno++;
            }
        }
        EmpleadoT masTrabajador=empleadost[1];

        for (int e=2;e<empleadost.length;e++){
            if(empleadost[e].horasTotales>masTrabajador.horasTotales){
                masTrabajador=empleadost[e];
            }
        }

        EmpleadoT[] soloEmpleados= new EmpleadoT[4];
        int pos=0;
        for (int i=1;i< empleadost.length;i++){
            soloEmpleados[pos] = empleadost[i];
            pos++;
        }
        Arrays.sort(soloEmpleados, (a, b) -> Double.compare(b.horasTotales,a.horasTotales));


        for (int i=1;i<empleadost.length;i++){
            System.out.println("Bootcamp.Empleado "+ i
            + "| Numero de turnos: "+empleadost[i].turnos
            + "| Horas de trabajo: "+String.format("%.2f",empleadost[i].horasTotales) + " horas totales");
        }
        System.out.println("Bootcamp.Empleado con mas horas de trabajo, "+ masTrabajador.numEmpleado + " ,horas de trabajo: "
        + String.format("%.2f",masTrabajador.horasTotales));
        System.out.println("Contador de turno nocturno: "+contadorTurnoNocturno);

        for (int i=0;i< soloEmpleados.length;i++){
            System.out.println((i+1) + "º - Bootcamp.Empleado "+ soloEmpleados[i].numEmpleado +": "+ String.format("%.2f", soloEmpleados[i].horasTotales) +" horas");
        }

    }
}