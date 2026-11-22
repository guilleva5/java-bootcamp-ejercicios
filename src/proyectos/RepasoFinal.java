package proyectos;

import java.util.ArrayList;

class Contenedor<T>{
    private ArrayList<T>elementos;

    public Contenedor(){
        this.elementos=new ArrayList<>();
    }
    public void agregar(T elemento){
        elementos.add (elemento);
    }
    public void mostrarTodo(){
        elementos.forEach(c-> System.out.println(c));
    }
    public int contarMayoresQue(double numero){
        return (int) elementos.stream()
                .filter(c->(Double) c>numero)
                .count();
    }

}

public class RepasoFinal {
    public static void main(String[] args) {
        Contenedor<Double>notas=new Contenedor<>();
        notas.agregar(8.5);
        notas.agregar(4.0);
        notas.agregar(9.0);
        notas.agregar(6.5);
        notas.agregar(3.0);

        notas.mostrarTodo();

        int aprobados= notas.contarMayoresQue(5);
        System.out.println("Aprobados: " + aprobados);
    }

}
