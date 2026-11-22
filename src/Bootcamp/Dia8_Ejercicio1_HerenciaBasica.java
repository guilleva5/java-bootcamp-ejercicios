package Bootcamp;

class Animal {
    protected String nombre;
    protected int edad;

    public Animal (String nombre,int edad){
        this.nombre=nombre;
        this.edad=edad;
    }

    public void hacerSonido(){
        System.out.println("El animal hace un sonido");
    }

    public void mostrarInfo(){
        System.out.println("Nombre: "+ nombre );
        System.out.println("Edad: "+edad);
    }

}
class Perro extends Animal{
    private String raza;

    public Perro (String nombre , int edad , String raza){
        super(nombre, edad);
        this.raza=raza;
    }

    @Override
    public void hacerSonido() {
        System.out.println("Guau guau");
    }
    public void mostrarInfoPerro(){
        mostrarInfo();
        System.out.println("Raza: "+raza);
    }
}
class Gato extends Animal{
    private String color;

    public Gato(String nombre , int edad , String color){
        super(nombre, edad);
        this.color=color;
    }

    @Override
    public void hacerSonido() {
        System.out.println("Miua miau");
    }

    public void mostrarInfoGato(){
        mostrarInfo();
        System.out.println("Color: "+color);
    }
}
public class Dia8_Ejercicio1_HerenciaBasica {
    public static void main(String[] args) {
        Perro perro1= new Perro("Rex",5,"Labrador");
        Gato gato1 = new Gato("Michi",3,"naranja");

        perro1.mostrarInfo();
        gato1.mostrarInfo();

        perro1.hacerSonido();
        gato1.hacerSonido();
    }
}
