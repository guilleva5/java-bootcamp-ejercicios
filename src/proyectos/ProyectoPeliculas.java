package proyectos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

abstract class Contenido{
    protected String titulo;
    protected int año;
    protected double puntuacion;

    public Contenido (String titulo,int año,double puntuacion){
        this.titulo=titulo;
        this.año=año;
        this.puntuacion=puntuacion;

    }

    public String getTitulo() {
        return titulo;
    }

    public int getAño() {
        return año;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(double p) {
        this.puntuacion = p;
    }
    public abstract void mostrarInfo();
    public abstract String getTipo();
    public abstract String toFileString();
}
class Pelicula extends Contenido{
    private String director;

    public Pelicula (String titulo,int año,double puntuacion,String director){
        super(titulo,año,puntuacion);
        this.director=director;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("proyectos.Pelicula: "+titulo);
        System.out.println("Año: "+año);
        System.out.println("Director: "+director);
        System.out.println("Puntuacion: "+puntuacion);
    }

    @Override
    public String getTipo() {
        return "PELICULA";
    }

    @Override
    public String toFileString() {
        return "PELICULA,"+titulo+","+año+","+puntuacion+","+director;
    }
}
class Serie extends Contenido{
    protected int temporadas;

    public Serie (String titulo,int año,double puntuacion,int temporadas){
        super(titulo,año,puntuacion);
        this.temporadas=temporadas;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("proyectos.Serie : "+titulo);
        System.out.println("Año: "+año);
        System.out.println("Puntuacion: "+puntuacion);
        System.out.println("Temporadas: "+temporadas);
    }

    @Override
    public String getTipo() {
        return "SERIE";
    }

    @Override
    public String toFileString() {
        return "SERIE,"+titulo+","+año+","+puntuacion+","+temporadas;
    }
}

public class ProyectoPeliculas {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Contenido> catalogo = new ArrayList<>();

    static void mostrarMenu() {
        System.out.println("---MI COLECCION DE PELICULAS---");
        System.out.println("================================");
        System.out.println("1. Añadir pelicula");
        System.out.println("2. Añadir serie");
        System.out.println("3. Ver catalogo completo");
        System.out.println("4.Buscar por titulo");
        System.out.println("5. Ver mejor puntuados (>= 8)");
        System.out.println("6. Guardar y salir");
        System.out.println("================================");
    }

    static void añadirPelicula() {
        System.out.println("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.println("Año: ");
        int año = Integer.parseInt(scanner.nextLine());
        System.out.println("Puntuación (0-10): ");
        double puntuacion = Double.parseDouble(scanner.nextLine());
        System.out.println("Director: ");
        String director = scanner.nextLine();

        catalogo.add(new Pelicula(titulo, año, puntuacion, director));
        System.out.println("✅ Película añadida");
    }

    static void añadirSerie() {
        System.out.println("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.println("Año: ");
        int año = Integer.parseInt(scanner.nextLine());
        System.out.println("Puntuación (0-10): ");
        double puntuacion = Double.parseDouble(scanner.nextLine());
        System.out.println("Temporadas: ");
        int temporadas = Integer.parseInt(scanner.nextLine());
        catalogo.add(new Serie(titulo, año, puntuacion, temporadas));
        System.out.println("✅ proyectos.Serie añadida");
    }

    static void verCatalogo() {
        if (catalogo.isEmpty()) {
            System.out.println("❌ Catálogo vacío");
            return;
        }
        System.out.println("---Catalogo completo: ");
        catalogo.forEach(c -> c.mostrarInfo());
    }

    static void buscarPorTitulo() {
        System.out.println("Buscar: ");
        String busquedaTitulo = scanner.nextLine();
        System.out.println("---Resultados---");
        catalogo.stream()
                .filter(c -> c.getTitulo().toLowerCase().contains(busquedaTitulo.toLowerCase()))
                .forEach(c -> c.mostrarInfo());
    }

    static void verMejorPuntuados() {
        System.out.println("\n=== MEJOR PUNTUADOS (>= 8) ===");
        catalogo.stream()
                .filter(c -> c.getPuntuacion() >= 8)
                .forEach(c -> c.mostrarInfo());
    }

    static void guardarEnArchivo() {
        try {
            FileWriter escritor = new FileWriter("peliculas.txt");
            catalogo.forEach(c -> {
                try {
                    escritor.write(c.toFileString() + "\n");
                } catch (IOException e) {
                    System.out.println("Error al guardar");
                }
            });
            escritor.close();
            System.out.println("✅ Catálogo guardado correctamente");
        } catch (IOException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    static void cargarDesdeArchivo() {
        try {
            FileReader archivo = new FileReader("peliculas.txt");
            BufferedReader lector = new BufferedReader(archivo);
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes[0].equalsIgnoreCase("PELICULA")) {
                    catalogo.add(new Pelicula(
                            partes[1],
                            Integer.parseInt(partes[2]),
                            Double.parseDouble(partes[3]),
                            partes[4]
                    ));
                } else if (partes[0].equalsIgnoreCase("SERIE")) {
                    catalogo.add(new Serie(
                            partes[1],
                            Integer.parseInt(partes[2]),
                            Double.parseDouble(partes[3]),
                            Integer.parseInt(partes[4])
                    ));
                }
            }

            lector.close();


            if (!catalogo.isEmpty()) {
                System.out.println("✅ Cargadas: " + catalogo.size() + " entradas");
            }

        } catch (
                IOException e) {
            System.out.println("📂 Catálogo vacío (primera vez)");

        }
    }


        public static void main(String[] args) {
            cargarDesdeArchivo();
            int opcion=0;
            do {
                mostrarMenu();

                try {
                     opcion = Integer.parseInt(scanner.nextLine());
                    switch (opcion) {
                        case 1:
                            añadirPelicula();
                            break;
                        case 2:
                            añadirSerie();
                            break;
                        case 3:
                            verCatalogo();
                            break;
                        case 4:
                            buscarPorTitulo();
                            break;
                        case 5:
                            verMejorPuntuados();
                            break;
                        case 6:
                            guardarEnArchivo();
                            System.out.println("Hasta pronto");
                            break;
                        default:
                            System.out.println("❌ Opcion no válida");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("❌ Introduce un número válido");
                    opcion = 0;
                }
            }while (opcion != 6) ;

                scanner.close();
            }


        }

