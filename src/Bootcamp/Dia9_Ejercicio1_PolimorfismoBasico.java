package Bootcamp;

import java.util.ArrayList;

class AnimalBase {
    protected String nombre;

    public AnimalBase(String nombre) {
        this.nombre = nombre;
    }

    public void hacerSonido() {
        System.out.println("Sonido genérico");
    }
}

class PerroBase extends AnimalBase {
    public PerroBase(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: Guau guau");
    }
}

class GatoBase extends AnimalBase {
    public GatoBase(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: Miau miau");
    }
}



public class Dia9_Ejercicio1_PolimorfismoBasico {
    public static void main(String[] args) {
        ArrayList<AnimalBase>animales=new ArrayList<>();
        animales.add(new PerroBase("Rex"));
        animales.add(new PerroBase("Max"));
        animales.add(new PerroBase("Toby"));
        animales.add(new GatoBase("Michi"));
        animales.add(new GatoBase("Luna"));
        animales.add(new GatoBase("Pelusa"));

        for(int i =0;i<animales.size();i++){
            animales.get(i).hacerSonido();
        }



        int perros=0;
        int gatos=0;
        for (int i=0;i<animales.size();i++){
            if(animales.get(i) instanceof PerroBase){
                perros++;
            } else if (animales.get(i) instanceof GatoBase) {
                gatos++;
            }
        }
        System.out.println("\n=== ESTADÍSTICAS ===");
        System.out.println("Total de animales: " + animales.size());
        System.out.println("Perros: " + perros);
        System.out.println("Gatos: " + gatos);

        System.out.println("\n=== USANDO MÉTODO POLIMÓRFICO ===");
        hacerSonidoAnimal(new PerroBase("REX"));
        hacerSonidoAnimal(new GatoBase("Michi"));
    }
    public static void hacerSonidoAnimal(AnimalBase a){
        a.hacerSonido();
    }

}
