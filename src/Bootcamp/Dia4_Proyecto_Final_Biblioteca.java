package Bootcamp;

class Libro{
    private String titulo;
    private  String autor;
    private int anioPublicacion;
    private boolean prestado=false;

    public Libro(String titulo, String autor, int anioPublicacion){
        this.titulo=titulo;
        this.autor=autor;
        this.anioPublicacion=anioPublicacion;
        this.prestado = false;
    }
    // GETTERS (para leer los valores)
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void prestar(){
        if (!prestado){
            prestado=true;
            System.out.println("El libro  "+ titulo +" ha sido prestado");
        }
        else{
            System.out.println("El libro "+ titulo +" ya esta prestado");
        }
    }
    public void devolver (){
        if (prestado){
            prestado=false;
            System.out.println("El libro "+ titulo + " ha sido devuelto,gracias");

        }
        else{
            System.out.println("El libro"+ titulo + " no estaba prestado");
        }
    }
    public void mostrarInfo(){
        System.out.println("Titulo : "+getTitulo());
        System.out.println("Autor: " + getAutor());
        System.out.println("Año: " + getAnioPublicacion());

        if (prestado) {
            System.out.println("Estado: Prestado");
        } else {
            System.out.println("Estado: Disponible");
        }
        System.out.println();

    }


}
public class Dia4_Proyecto_Final_Biblioteca {
    public static void main(String[] args) {
        Libro libro1= new Libro("El Quijote","Cervantes",1906);
        Libro libro2= new Libro("Cien años de soledad"," Garcia Marquez",1967);
        Libro libro3= new Libro("1984","Geoger Owell",1949);

        libro1.mostrarInfo();
        libro2.mostrarInfo();
        libro3.mostrarInfo();
        System.out.println();

        libro1.prestar();
        libro1.prestar();

        libro2.prestar();
        libro1.devolver();
        libro1.mostrarInfo();
        libro2.mostrarInfo();
        libro3.mostrarInfo();

    }

}