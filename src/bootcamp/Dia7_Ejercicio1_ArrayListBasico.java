package bootcamp;

import java.util.ArrayList;

public class Dia7_Ejercicio1_ArrayListBasico {
    public static void main(String[] args) {
        ArrayList<String>ciudades = new ArrayList<>();
        ciudades.add("Madrid");
        ciudades.add("Barcelona");
        ciudades.add("Valencia");
        ciudades.add("Sevilla");
        ciudades.add("Bilbao");

        for ( int i =0;i< ciudades.size();i++){
            System.out.println(ciudades.get(i));
        }
        System.out.println("Total de ciuadades : "+ ciudades.size());
        System.out.println();

        System.out.println("Primera ciudad : "+ciudades.get(0));
        System.out.println("Ultima ciudad :"+ciudades.get(ciudades.size()-1));
        System.out.println();

        ciudades.remove("Valencia");
        for ( int i =0;i< ciudades.size();i++){
            System.out.println(ciudades.get(i));
        }
        System.out.println();
        ciudades.add("Zaragoza");
        for ( int i =0;i< ciudades.size();i++){
            System.out.println(ciudades.get(i));
        }

    }
}
