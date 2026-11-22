package proyectos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

abstract class MaterialBiblioteca{
    protected  String id;
    protected String titulo;
    protected String estado;
    public MaterialBiblioteca(String id,String  titulo){
        this.id=id;
        this.titulo=titulo;
        this.estado="disponible";
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEstado() {
        return estado;
    }
    public void prestar (){
        this.estado="prestado";
    }
    public void devolver (){
        this.estado="disponible";
    }
    public abstract void mostrarInfo();
    public abstract String getTipo();
    public abstract String toFileString();
}
class LibroP extends MaterialBiblioteca{
    private String autor;
    public LibroP(String id,String titulo,String autor){
        super(id,titulo);
        this.autor=autor;
    }
    public String getAutor() {
        return autor;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("📚 LIBRO - ID: " + id);
        System.out.println("   Título: " + titulo);
        System.out.println("   Autor: " + autor);
        System.out.println("   Estado: " + estado);
    }

    @Override
    public String getTipo() {
        return "Bootcamp.Libro";
    }

    @Override
    public String toFileString() {
        return  "LIBRO," + id + "," + titulo + "," + autor + "," + estado;
    }
}
class Revista extends MaterialBiblioteca{
    private String editorial;
    public Revista(String id,String titulo,String editorial){
        super(id,titulo);
        this.editorial=editorial;
    }

    public String getEditorial() {
        return editorial;
    }

    @Override
    public void mostrarInfo() {
        System.out.println(" REVISTA - ID : "+id);
        System.out.println("Titulo :"+titulo);
        System.out.println("Editorial :"+editorial);
        System.out.println("Estado :"+ estado);
    }

    @Override
    public String getTipo() {
        return "proyectos.Revista";
    }

    @Override
    public String toFileString() {
        return "proyectos.Revista, "+ id+","+titulo +","+ editorial +","+ estado;
    }
}

class DVD extends MaterialBiblioteca{
    private String director;
    public DVD (String id,String titulo,String director){
        super(id,titulo);
        this.director=director;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("proyectos.DVD ID-"+id);
        System.out.println("Titulo: "+titulo);
        System.out.println("Director "+director);
        System.out.println("Estado: " + estado);
    }

    @Override
    public String getTipo() {
        return "proyectos.DVD";
    }

    @Override
    public String toFileString() {
        return "proyectos.DVD,"+id+","+titulo+","+director+"," + estado;
    }
}
public class ProyectoBiblioteca {
    static ArrayList<MaterialBiblioteca>catalogo=new ArrayList<>();
    static Scanner scanner =new Scanner(System.in);
    static void mostrarMenu(){
        System.out.println("1. Añadir material");
        System.out.println("2. Prestar material");
        System.out.println("3. Devolver material");
        System.out.println("4. Buscar material por título");
        System.out.println("5. Ver materiales disponibles");
        System.out.println("6. Ver todos los materiales");
        System.out.println("7. Guardar y salir");
    }
    static void añadirMaterial(){
        System.out.println("\n¿Qué tipo de material quieres añadir?");
        System.out.println("1. Bootcamp.Libro");
        System.out.println("2. proyectos.Revista");
        System.out.println("3. proyectos.DVD");
        System.out.print("Elige opción: ");
        try {
            int tipo =Integer.parseInt(scanner.nextLine());
            switch (tipo){
                case 1:
                    System.out.println("Introduce el id de libro:");
                    String idLibro= scanner.nextLine();
                    System.out.println("Introduce el titulo");
                    String tituloLibro= scanner.nextLine();
                    System.out.println("Introduce el autor");
                    String autorLibro=scanner.nextLine();
                    LibroP libro =new LibroP(idLibro,tituloLibro,autorLibro);
                    catalogo.add(libro);

                    System.out.println("✅ Bootcamp.Libro añadido correctamente");
                    break;
                case 2:
                    System.out.println("Introduce el id de la revista:");
                    String idRevista= scanner.nextLine();
                    System.out.println("Introduce el titulo de la revista:");
                    String tituloRevista = scanner.nextLine();
                    System.out.println("Introduce el editorial de la revista");
                    String editorialRevista = scanner.nextLine();

                    Revista revista = new Revista(idRevista,tituloRevista,editorialRevista);
                    catalogo.add(revista);

                    System.out.println("proyectos.Revista añadida correctamente");
                    break;

                case 3:
                    System.out.println("Introduce el id del dvd");
                    String idDvd = scanner.nextLine();
                    System.out.println("Introduce el titulo del dvd");
                    String tituloDvd =scanner.nextLine();
                    System.out.println("Introduce el director del dvd");
                    String directorDvd= scanner.nextLine();

                    DVD dvd =new DVD(idDvd,tituloDvd,directorDvd);
                    catalogo.add(dvd);
                    System.out.println("Dvd añadido correctamente");
                    break;
                default:
                    System.out.println("❌ Error: Introduce un número válido");
            }
        }catch (NumberFormatException e){
            System.out.println("Error :introduce un numero incorrecto");
        }
    }
    static void prestarMaterial(){
        System.out.println("\n=== MATERIALES DISPONIBLES ===");
        boolean hayDisponibles =false;
        for (int i=0;i<catalogo.size();i++){
            if(catalogo.get(i).getEstado().equalsIgnoreCase("disponible")){
                MaterialBiblioteca m = catalogo.get(i);
                System.out.println("ID :"+ m.getId() +
                        " | "+m.getTitulo()+
                        " | "+m.getTipo());
                hayDisponibles = true;
            }
        }
        if (!hayDisponibles){
            System.out.println("No hay materiales disponibles");
            return;
        }
        System.out.println("Introduce el id del material a prestar");
        String idBuscado=scanner.nextLine();

        boolean encontrado= false;
        for (int i =0;i<catalogo.size();i++){
            MaterialBiblioteca material= catalogo.get(i);
            if(material.getId().equalsIgnoreCase(idBuscado)){
                encontrado=true;
                if(material.getEstado().equalsIgnoreCase("disponible")){
                    material.prestar();
                    System.out.println("✅ Material prestado correctamente");
                }else {
                    System.out.println("❌ Este material ya está prestado");
                }
                break;
            }
        }
        if(!encontrado){
            System.out.println("❌ No existe material con ese ID");
        }
    }
    static void devolverMaterial() {
        System.out.println("\n=== MATERIALES PRESTADOS ===");
        boolean hayPrestados = false;
        for (int i = 0; i < catalogo.size(); i++) {
            if (catalogo.get(i).getEstado().equalsIgnoreCase("prestado")) {
                MaterialBiblioteca p = catalogo.get(i);
                System.out.println("ID : " + p.getId() +
                        " | " + p.getTitulo() +
                        " | " + p.getTipo());
                hayPrestados = true;
            }
        }
        if (!hayPrestados) {
            System.out.println("No hay materiales prestados");
            return;
        }
        System.out.println("Introduce el id del material a devolver");
        String idBuscado = scanner.nextLine();
        boolean encontrado=false;
        for (int i = 0; i < catalogo.size(); i++) {
            MaterialBiblioteca material = catalogo.get(i);
            if (material.getId().equalsIgnoreCase(idBuscado)) {
                encontrado = true;
                if (material.getEstado().equalsIgnoreCase("prestado")) {
                    material.devolver();
                    System.out.println("Este material ha sido devuelto correctamente");
                } else {
                    System.out.println("Este material no esta prestado");
                }
                break;
            }
        }

        if(!encontrado){
            System.out.println("ID buscado incorrecto");
        }
    }
    static void buscarMaterial(){
        System.out.println("Introduce el titulo a buscar:");
        String tituloBuscado=scanner.nextLine();

        System.out.println("El resultaddo de busqueda:");
        boolean hayResultados=false;


        for (int i= 0;i<catalogo.size();i++) {
            MaterialBiblioteca m = catalogo.get(i);
            if (m.getTitulo().toLowerCase().contains(tituloBuscado.toLowerCase())) {
                m.mostrarInfo();
                System.out.println();
                hayResultados = true;
            }
        }
        if (!hayResultados){
            System.out.println("❌ No se encontraron materiales con ese título");
        }
    }
    static void verDisponibles(){
        System.out.println("---Materiales Disponibles");
        boolean hayDisponibles= false;
        for (int i =0;i<catalogo.size();i++) {
            MaterialBiblioteca mdisponibles = catalogo.get(i);
            if (mdisponibles.getEstado().equalsIgnoreCase("disponible")) {
                mdisponibles.mostrarInfo();
                hayDisponibles = true;
            }
        }
        if(!hayDisponibles){
            System.out.println("No hay materiales disponibles");
            return;
        }
    }
    static void verTodoCatalogo(){
        System.out.println("---Ver catalogo completo---");
        if(catalogo.isEmpty()){
            System.out.println("El catalogo esta vacio");
            return;
        }
        System.out.println("Total del catalogo :"+catalogo.size());
        System.out.println();
        for(int i=0;i<catalogo.size();i++){
            MaterialBiblioteca mcatalogo =catalogo.get(i);
            mcatalogo.mostrarInfo();
        }
    }
    static void guardarEnArchivo(){
        try {
            FileWriter escritor = new FileWriter("biblioteca.txt");

            for (int i = 0; i < catalogo.size(); i++) {
                escritor.write(catalogo.get(i).toFileString()+"\n");
            }
            escritor.close();
            System.out.println("✅ Catálogo guardado correctamente");
        }catch (IOException e) {
            System.out.println("❌ Error al guardar: " + e.getMessage());
        }
    }
    static void cargarDesdeArchivo(){
        try{
            FileReader archivo=new FileReader("biblioteca.txt");
            BufferedReader lector=new BufferedReader(archivo);
            String linea;
            while ((linea = lector.readLine())!=null){
                String []partes=linea.split(",");

                if(partes[0].equalsIgnoreCase("LIBRO")){
                    LibroP libro= new LibroP(partes[1],partes[2],partes[3]);
                    if (partes[4].equals("prestado")){
                        libro.prestar();
                    }
                    catalogo.add(libro);
                } else if (partes[0].equalsIgnoreCase("proyectos.Revista")) {
                    Revista revista=new Revista(partes[1],partes[2],partes[3]);
                    if (partes[4].equalsIgnoreCase("prestado")){
                        revista.prestar();
                    }
                    catalogo.add(revista);
                } else if (partes[0].equalsIgnoreCase("proyectos.DVD")) {
                    DVD dvd =new DVD(partes[1],partes[2],partes[3]);
                    if(partes[4].equalsIgnoreCase("prestado")){
                        dvd.prestar();
                    }
                    catalogo.add(dvd);
                }
            }
            lector.close();
            System.out.println("✅ Catálogo cargado: " + catalogo.size() + " materiales");

        }catch (IOException e){
            System.out.println("📂 Catálogo vacío (primera vez)");


        }
    }

    public static void main(String[] args) {
        cargarDesdeArchivo();

        int opcion=0;
        do {
            mostrarMenu();
                try {
                    opcion=Integer.parseInt(scanner.nextLine());
                    switch (opcion){
                        case 1:
                            añadirMaterial();
                            break;
                        case 2:
                            prestarMaterial();
                            break;
                        case 3:
                            devolverMaterial();
                            break;
                        case 4:
                            buscarMaterial();
                            break;
                        case 5:
                            verDisponibles();
                            break;
                        case 6:
                            verTodoCatalogo();
                            break;
                        case 7:
                            guardarEnArchivo();
                            System.out.println("¡Hasta pronto!");
                            break;
                        default:
                            System.out.println("❌ Opción no válida");

                    }

                }catch (NumberFormatException e){
                    System.out.println("❌ Error: Introduce un número válido");
                    opcion =0;
                }


            }while (opcion !=7);
                scanner.close();
    }
    }

