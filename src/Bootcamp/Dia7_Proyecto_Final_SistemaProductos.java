package Bootcamp;

import java.util.ArrayList;
import java.util.Scanner;

public class Dia7_Proyecto_Final_SistemaProductos {

    static ArrayList<Producto>productos=new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        productos.add(new Producto("Laptop", 899.99, 10, "PROD001"));
        productos.add(new Producto("Mouse", 25.50, 50, "PROD002"));
        productos.add(new Producto("Teclado", 45.00, 30, "PROD003"));

        int opcion;
        do {
            mostrarMenu();
            opcion=scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1:
                    añadirProducto();
                    break;
                case 2:
                    verTodos();
                    break;
                case 3:
                    buscarProducto();
                    break;
                case 4:
                    actualizarPrecio();
                    break;
                case 5:
                    eliminarProducto();
                    break;
                case 6:
                    productoStockBajo();
                    break;
                case 7:
                    mostrarEstadisticas();
                    break;
                case 8:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida");
            }

        }
        while (opcion!=8);

        }




    public static void mostrarMenu() {
        System.out.println("\n=== SISTEMA DE GESTIÓN DE PRODUCTOS ===");
        System.out.println("1. Añadir producto");
        System.out.println("2. Ver todos los productos");
        System.out.println("3. Buscar producto por nombre");
        System.out.println("4. Actualizar precio");
        System.out.println("5. Eliminar producto");
        System.out.println("6. Productos con stock bajo");
        System.out.println("7. Estadísticas");
        System.out.println("8. Salir");
        System.out.print("Opción: ");
    }

    public static void añadirProducto (){
        System.out.println("Añade del nuevo producto: ");
        String nombreNuevoProducto= scanner.nextLine();

        System.out.println("Introduce su nuevo precio: ");
        double nuevoPrecio =scanner.nextDouble();

        System.out.println("Introduce su stock: ");
        int nuevoStock = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Introduce su codigo: ");
        String nuevoCodigo=scanner.nextLine();

        productos.add(new Producto(nombreNuevoProducto,nuevoPrecio,nuevoStock,nuevoCodigo));
        System.out.println("Bootcamp.Producto añadido con exito.");
    }
    public static void verTodos() {
        if(productos.size()==0){
            System.out.println("No hay productos");
            return;
        }
        System.out.println("---Todos los productos---");
        for (int i = 0; i < productos.size(); i++) {
            productos.get(i).mostrarInfo();
        }
        System.out.println("Numero total :"+ productos.size()+" productos");
    }
    public static void buscarProducto() {
        System.out.println("Introduce el nombre a buscar:");
        String nombreBuscado = scanner.nextLine();
        boolean encontrado = false;
        for (int i = 0; i < productos.size(); i++) {
            if (nombreBuscado.equalsIgnoreCase(productos.get(i).getNombre())) {
                encontrado = true;
                productos.get(i).mostrarInfo();
                break;

            }
            }
        if (!encontrado) {
            System.out.println("Bootcamp.Producto no encontrado");
        }
    }
    public static void actualizarPrecio(){
        System.out.println("Introduce el nombre del producto para actualizar precio: ");
        String nombre= scanner.nextLine();

        for (int i = 0; i < productos.size(); i++){
            if(productos.get(i).getNombre().equalsIgnoreCase(nombre)){
                System.out.println("Introduce el nuevo precio");
                double nuevoPrecio=scanner.nextDouble();

                productos.get(i).setPrecio(nuevoPrecio);
                System.out.println("Precio actualizado");
                return;
            }
        }
        System.out.println("Bootcamp.Producto no encontrado. ");
    }
    public static void eliminarProducto(){
        System.out.println("Introduce el nombre del producto para eliminar: ");
        String nombre= scanner.nextLine();

        for (int i = 0; i < productos.size(); i++){
            if(productos.get(i).getNombre().equalsIgnoreCase(nombre)){
                String nombreEliminado = productos.get(i).getNombre();
                productos.remove(i);
                System.out.println("Eliminado : "+nombreEliminado);
                return;
            }


        }
        System.out.println("Bootcamp.Producto no encontado.");

    }
    public static void productoStockBajo(){
        int numeroStockBajo=25;
        int contador=0;
        for (int i = 0; i < productos.size(); i++){
            if(productos.get(i).getStock()<numeroStockBajo){
                productos.get(i).mostrarInfo();
                contador++;

            }
        }
        if(contador==0){
            System.out.println("No hay productos con un stock menor a "+numeroStockBajo);
        }else {
            System.out.println("Numero total productos stock por debajo de 25 :"+ contador);
        }

    }
    public static void mostrarEstadisticas(){
        if(productos.size()==0){
            System.out.println("No hay productos");
            return;
        }


        System.out.println("---Estadisticas---");
        System.out.println("Numero total de productos : "+productos.size());
        System.out.println();

        System.out.println("---Precio promedio---");
        double suma=0;
        for (int i = 0; i < productos.size(); i++){
            suma+=productos.get(i).getPrecio();
        }
        double precioPromedio =suma/productos.size();
        System.out.println("Precio promedio productos: "+precioPromedio+" $");
        System.out.println();

        System.out.println("---Bootcamp.Producto mas caro---");
        Producto precioCaro=productos.get(0);
        for (int i = 0; i < productos.size(); i++){
            if (precioCaro.getPrecio()<productos.get(i).getPrecio()){
                precioCaro=productos.get(i);
            }
        }
        System.out.println("Bootcamp.Producto más caro: " + precioCaro.getNombre() + " (" +precioCaro.getPrecio() + "€)");
        System.out.println();

        System.out.println("---Valor total de inventario---");
        double valorTotalInventario=0;
        for (int i =0; i< productos.size(); i ++){
            valorTotalInventario=valorTotalInventario+productos.get(i).getPrecio()*productos.get(i).getStock();
        }
        System.out.println("Valor total inventario :"+valorTotalInventario+"$");




    }
}
