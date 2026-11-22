package Bootcamp;

import java.util.ArrayList;

class Almacen<T>{
    private ArrayList<T>items;
    private String nombre;

    public Almacen (String nombre){
        this.nombre=nombre;
        this.items=new ArrayList<>();
    }
    public void agregar (T item){
        items.add(item);
    }
    public T obtener (int indice){
        return items.get(indice);
    }
    public void eliminar (int indice){
        items.remove(indice);
    }
    public int getTotalItems(){
        return items.size();
    }
    public boolean estaVacio(){
        return items.isEmpty();
    }
    public void mostrarTodo(){
        System.out.println("\n=== ALMACÉN: " + nombre + " ===");
        System.out.println("Total del items:"+getTotalItems());
        if (estaVacio()){
            System.out.println("El almacen esta vacio");
            return;
        }
        for(int i =0;i<items.size();i++){
            System.out.println(i+". "+items.get(i));
        }
    }
}
class LibroPa {
    private String titulo;
    private String autor;

    public LibroPa(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "📚 " + titulo + " - " + autor;
    }
}
public class Dia16_Ejercicio_Generics {
    public static void main(String[] args) {
        Almacen<String> almacenNombres=new Almacen<>("Nombres");
        almacenNombres.agregar("JUAN");
        almacenNombres.agregar("María");
        almacenNombres.agregar("Pedro");
        almacenNombres.mostrarTodo();

        Almacen<Integer> almacenEdades=new Almacen<>("Edades");
        almacenEdades.agregar(25);
        almacenEdades.agregar(30);
        almacenEdades.agregar(28);
        almacenEdades.mostrarTodo();

        Almacen<LibroPa>almacenLibros=new Almacen<>("Biblioteca");
        almacenLibros.agregar(new LibroPa("El Quijote", "Cervantes"));
        almacenLibros.agregar(new LibroPa("Don Juan", "Zorrilla"));
        almacenLibros.mostrarTodo();



    }
}
