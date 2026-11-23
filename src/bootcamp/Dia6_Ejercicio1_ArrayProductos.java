package bootcamp;

public class Dia6_Ejercicio1_ArrayProductos {
    public static void main(String[] args) {
        Producto[] productos =new Producto[5];
        productos[0]=new Producto("Laptop", 899.99, 10, "PROD001");
        productos[1]=new Producto("Teclado", 45.00, 30, "PROD003");
        productos[2]=new Producto( "Mouse", 25.50, 50, "PROD002");
        productos[3]=new Producto( "Monitor", 199.99, 15, "PROD004");
        productos[4]=new Producto("Webcam", 75.00, 20, "PROD005");

        for (int i=0 ; i<productos.length;i++){
            productos[i].mostrarInfo();
        }
        Producto masCaro=productos[0];
        for (int i=0 ; i<productos.length;i++){
            if (productos[i].getPrecio()>masCaro.getPrecio()){
                masCaro=productos[i];
            }
        }
        System.out.println("---Bootcamp.Producto mas caro---");
        System.out.println("Nombre : "+masCaro.getNombre());
        System.out.println("Precio :"+masCaro.getPrecio()+" $");

        int contador=0;
        for (int i=0 ; i<productos.length;i++){
            if (productos[i].getStock()>20){
                contador++;
            }
        }
        System.out.println("---Productos con stock > 20---");
        System.out.println("Total :"+contador+" productos");

    }
}
