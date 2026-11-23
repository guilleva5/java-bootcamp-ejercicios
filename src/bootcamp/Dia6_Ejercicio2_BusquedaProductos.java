package bootcamp;

public class Dia6_Ejercicio2_BusquedaProductos {
    public static void main(String[] args) {
        Producto[] productos = new Producto[5];
        productos[0] = new Producto("Laptop", 899.99, 10, "PROD001");
        productos[1] = new Producto("Teclado", 45.00, 30, "PROD003");
        productos[2] = new Producto("Mouse", 25.50, 50, "PROD002");
        productos[3] = new Producto("Monitor", 199.99, 15, "PROD004");
        productos[4] = new Producto("Webcam", 75.00, 20, "PROD005");

        System.out.println("---Busqueda por nombre---");
        String nombreBuscado="Mouse";
        boolean encontrado =false;
        for (int i=0; i< productos.length; i++){

            if(productos[i].getNombre().equalsIgnoreCase(nombreBuscado)){
                productos[i].mostrarInfo();
                encontrado = true;
                break;
            }
        }
        if(!encontrado){
            System.out.println("Bootcamp.Producto no encontrado");
        }
        System.out.println("\n=== PRODUCTOS ENTRE 20€ Y 100€ ===");
        double precioMinimo =20;
        double precioMaximo=100;
        for (int i =0; i< productos.length; i ++){
            double precio=productos[i].getPrecio();
            if(precio>precioMinimo && precio<precioMaximo){
                productos[i].mostrarInfo();
            }
        }

        System.out.println("\n=== PRODUCTOS CON STOCK BAJO (<25) ===");
        int stockBajo= 25;
        for (int i =0; i< productos.length; i ++){
            if (productos[i].getStock()<25){
                System.out.println("- " + productos[i].getNombre() + " (Stock: " + productos[i].getStock() + ")");
            }
        }

        System.out.println("\n=== ESTADÍSTICAS ===");
        double suma=0;
        for (int i =0; i< productos.length; i ++){
            suma=suma +productos[i].getPrecio();
        }
        double precioPromedio=suma/ productos.length;

        System.out.println("El precio promedio de los productos es : "+precioPromedio + "$");
        System.out.println();

        double valorTotal =0;
        for (int i =0; i< productos.length; i ++){
            valorTotal=valorTotal+productos[i].getStock();
        }
        System.out.println("El numero total de stocks: "+valorTotal);
        System.out.println();

        double precioTotal =0;
        for (int i =0; i< productos.length; i ++){
            precioTotal=precioTotal+(productos[i].getPrecio()*productos[i].getStock());
        }


    }
}
