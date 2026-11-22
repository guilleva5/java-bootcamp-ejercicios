package Bootcamp;

import java.util.HashMap;

public class Dia12_Ejercicio1_InventarioProductos {
    public static void main(String[] args) {


        HashMap<String, Integer> inventario = new HashMap<>();
        inventario.put("Laptop", 15);
        inventario.put("Mouse",50);
        inventario.put("Teclado",50);
        inventario.put("Monitor", 20);
        inventario.put("Auriculares", 45);

        System.out.println("Mostrar stock de Teclado:");
        Integer stockTeclado = inventario.get("Teclado");
        System.out.println(stockTeclado);

        System.out.println("Actualizar stock de Monitor:");
        inventario.put("Monitor",65);
        System.out.println("Stock actualizado de Monitor : "+inventario .get("Monitor"));
        System.out.println();

        System.out.println("Eliminar producto de auriculares:");
        inventario.remove("Auriculares");
        System.out.println("Bootcamp.Producto eliminado");
        System.out.println();

        System.out.println("Mostrar inventario completo:");
        System.out.println("Total de productos :"+inventario.size());
        for ( String nombreProducto: inventario.keySet()){
            Integer nombres=inventario.get(nombreProducto);
            System.out.println("Nombre del producto : "+nombreProducto + ",Stock: "+nombres);

        }



    }
}