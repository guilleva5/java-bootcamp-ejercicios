package Bootcamp;

public class Dia4_Ejercicio1_Persona {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        persona1.nombre = "Juan";
        persona1.edad = 25;
        persona1.ciudad="Madrid";

        persona1.presentarse();
        persona1.cumplirAnios();

        System.out.println();

        Persona persona2 = new Persona();
        persona2.nombre = "María";
        persona2.edad = 30;
        persona2.ciudad= "Barcelona";

        persona2.presentarse();
        persona2.cumplirAnios();

    }
}
class Persona {
    String nombre;
    int edad;
    String ciudad;

    public void presentarse() {
        System.out.println("Hola soy " + nombre + ", tengo " + edad + " años y vivo en " + ciudad);
    }

    public void cumplirAnios() {
        edad++;
        System.out.println("Feliz cumpleaños, ahora tengo "+ edad+ " años");

    }
}