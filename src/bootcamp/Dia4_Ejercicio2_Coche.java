package bootcamp;

class Coche{
    String marca;
    String modelo;
    int velocidad;
    String color;

    public void arrancar(){
        System.out.println("El "+marca+" "+modelo+" ha arrancado. Brrrum");
    }
    public void acelerar(){
        velocidad+=20;
        System.out.println("Acelerando... Velocidad actual: "+velocidad+" km/h");
    }
    public void frenar(){
        velocidad=velocidad-20;
        if (velocidad < 0){
            velocidad=0;
        }
        System.out.println("Frenando... Velocidad actual: " + velocidad + " km/h");


    }
    public void mostrarInfo(){
        System.out.println("["+marca+"] ["+modelo+"] de color ["+color+"] - Velocidad :"+velocidad+"Km/h" );
    }


}
public class Dia4_Ejercicio2_Coche {

public static void main(String[] args) {
    Coche coche1 = new Coche();
    coche1.marca = "Audi";
    coche1.modelo="a6";
    coche1.velocidad =0;
    coche1.color="Negro";

    coche1.arrancar();
    coche1.acelerar();
    coche1.acelerar();
    coche1.frenar();
    coche1.mostrarInfo();

    System.out.println();

    Coche coche2 = new Coche();
    coche2.marca = "Bmw";
    coche2.modelo="m6";
    coche2.velocidad =0;
    coche2.color="Azul";

    coche2.arrancar();
    coche2.acelerar();
    coche2.acelerar();

    coche2.frenar();
    coche2.mostrarInfo();

}
}













