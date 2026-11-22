package logica;

class ProductoA {
    String nombreProducto;
    double precio;
    int stock;

    public ProductoA(String nombreProducto, double precio, int stock) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }
}
public class AnalizadorProductos {

    public static void main(String[] args) {
        ProductoA[]productosA= {
                new ProductoA("Camiseta", 15.99, 20),
                new ProductoA("Pantalón", 35.50, 8),
                new ProductoA("Zapatos", 65.00, 0),
                new ProductoA("Gorra", 9.99, 3),
                new ProductoA("Bufanda", 12.50, 0),
                new ProductoA("Chaqueta", 89.90, 15),
                new ProductoA("Calcetines", 4.99, 2)
        };
        ProductoA productoMasCaro= productosA[0];
        ProductoA productoMasBarato=productosA[0];
        double sumaTotal=0;
        int cantidadAgotados=0;
        int cantidadStockBajo=0;

        for(int i=0;i<productosA.length;i++){
            if(productosA[i].getPrecio()>productoMasCaro.getPrecio()){
                productoMasCaro=productosA[i];
            }
            if(productosA[i].getPrecio()<productoMasBarato.getPrecio()){
                productoMasBarato=productosA[i];
            }
            sumaTotal=sumaTotal+productosA[i].getPrecio()*productosA[i].getStock();

            if(productosA[i].getStock()==0){
                cantidadAgotados++;
            }
            if(productosA[i].getStock()<5){
                cantidadStockBajo++;
            }
        }
        System.out.println("-Bootcamp.Producto mas caro:"+productoMasCaro.getNombreProducto()+" por "+productoMasCaro.getPrecio()+" €");
        System.out.println("-Bootcamp.Producto mas barato:"+productoMasBarato.getNombreProducto()+" por "+productoMasBarato.getPrecio()+" €");
        System.out.println("La suma total del inventario es: "+sumaTotal+" €");
        System.out.println("Stock agotados: "+cantidadAgotados+" unidades");
        System.out.println("Cantidad de stock bajos: "+cantidadStockBajo+" unidades");
    }
}
