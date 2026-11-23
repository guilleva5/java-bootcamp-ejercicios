package bootcamp;

import java.util.ArrayList;

class Estudiant{
    String nombre;
    double nota;

    public Estudiant(String nombre,double nota){
        this.nombre=nombre;
        this.nota=nota;
    }

    public String getNombre() {
        return nombre;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return  nombre + " (" + nota + ")";
    }
}

public class Dia17_Ejercicio_Lambdas {
    public static void main(String[] args) {
        ArrayList<Estudiant>estudiants=new ArrayList<>();
        estudiants.add(new Estudiant("Juan", 8.5));
        estudiants.add(new Estudiant("María", 4.5));
        estudiants.add(new Estudiant("Pedro", 7.0));
        estudiants.add(new Estudiant("Ana", 9.5));
        estudiants.add(new Estudiant("Luis", 3.0));
        estudiants.add(new Estudiant("Sara", 6.5));

        System.out.println("---Todos los estudiantes---");
        estudiants.forEach(e -> System.out.println(e));

        System.out.println("---Estudiantes aprobados---");
        estudiants.stream()
                .filter(e->e.getNota()>=5)
                .forEach(e-> System.out.println(e));

        System.out.println("---Estudiantes supensos---");
        estudiants.stream()
                .filter(e->e.getNota()<5)
                .forEach(e-> System.out.println(e));


        System.out.println("---Nombres en mayuscula---");
        estudiants.stream()
                .map(e->e.getNombre().toUpperCase())
                .forEach(e-> System.out.println(e));

        System.out.println("---Eliminar supensos---");
        estudiants.removeIf(e->e.getNota()<5);
        System.out.println("Quedan: " + estudiants.size() + " estudiantes");

        System.out.println("Mostrar estudiantes con nota mayor que 8---");
        estudiants.stream()
                .filter(e-> e.getNota()>8)
                .forEach(e-> System.out.println(e));
    }
}
