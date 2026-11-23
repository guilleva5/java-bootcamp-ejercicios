package bootcamp;

import java.util.ArrayList;

class ProductoBase {
    protected String nombre;
    protected double precio;
    protected int stock;
    protected String codigo;

    public ProductoBase(String nombre,double precio,int stock,String codigo){
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.codigo = codigo;

    }
    public void mostrarInfo(){
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: " + precio + "€");
        System.out.println("Stock: " + stock + " unidades");
    }
    public double calcularPrecioFinal (){
        return precio;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }
    public String getCodigo() { return codigo; }
}
class ProductoFisico extends ProductoBase{
    private double peso;
    private double dimensiones;
    public ProductoFisico(String nombre, double precio, int stock,
                          String codigo, double peso, double dimensiones){
        super(nombre, precio, stock, codigo);
        this.peso = peso;
        this.dimensiones = dimensiones;

    }
    public double calcularCostoEnvio (){
        return peso*2;
    }

    @Override
    public double calcularPrecioFinal() {
        return precio+calcularCostoEnvio();
    }
        public void mostrarInfoCompleta(){
        mostrarInfo();
            System.out.println("Tipo: Bootcamp.Producto Físico");
            System.out.println("Peso: " + peso + " kg");
            System.out.println("Dimensiones: " + dimensiones + " cm");
            System.out.println("Costo Envío: " + calcularCostoEnvio() + "€");
            System.out.println("Precio Final: " + calcularPrecioFinal() + "€");
        }
    public double getPeso() { return peso; }
}
class ProductoDigital extends ProductoBase{
    private double tamañoArchivo;
    private String enlaceDescarga;
    public ProductoDigital(String nombre,double precio,int stock,String codigo,double tamañoArchivo,String enlaceDescarga){
        super(nombre, precio, stock, codigo);
        this.enlaceDescarga=enlaceDescarga;
        this.tamañoArchivo=tamañoArchivo;
    }

    @Override
    public double calcularPrecioFinal() {
        return precio;
    }
    public void  mostrarInfoCompleta(){
        mostrarInfo();
        System.out.println("Tipo: Bootcamp.Producto Digital");
        System.out.println("Tamaño del archivo : "+tamañoArchivo+" MB");
        System.out.println("Enlace: " + enlaceDescarga);
        System.out.println("Precio Final: " + calcularPrecioFinal() + "€");
    }

}
public class Dia8_Proyecto_Final_SistemaProductos {
    public static void main(String[] args) {
        ArrayList<ProductoBase>productos=new ArrayList<>();
        productos.add(new ProductoFisico("Laptop", 899.99, 10, "PROD001", 2.5, 35));
        productos.add(new ProductoFisico("Mouse", 25.50, 50, "PROD002", 0.1, 10));
        productos.add(new ProductoFisico("Teclado", 45.00, 30, "PROD003", 0.8, 40));

        productos.add(new ProductoDigital("eBook Java", 19.99, 999, "PROD004", 5,"http://download.com/ebook"));
        productos.add(new ProductoDigital("Curso Python", 49.99, 999 , "PROD005", 500, "http://download.com/curso"));
        productos.add(new ProductoDigital("Software Office", 79.99, 999 , "PROD006", 1200, "http://download.com/office"));

        System.out.println("===Todos los productos ===");
        for (int i =0;i< productos.size();i++){
            if(productos.get(i) instanceof ProductoFisico){
                System.out.println("---Bootcamp.Producto fisico---");
                ProductoFisico pf=(ProductoFisico) productos.get(i);
                pf.mostrarInfoCompleta();
                System.out.println();
            } else if (productos.get(i) instanceof ProductoDigital) {
                System.out.println("---Bootcamp.Producto digital---");
                ProductoDigital pg = (ProductoDigital) productos.get(i);
                pg.mostrarInfoCompleta();
                System.out.println();

            }
        }
        System.out.println("---Valor total de inventario---");
        double valorTotal=0;
        for (int i=0;i< productos.size();i++){
            valorTotal += productos.get(i).getPrecio()*productos.get(i).getStock();
        }
        System.out.println("Valor total del inventario: " + valorTotal + "€");

        System.out.println("---Productos fisicos---");
        for (int i =0;i< productos.size();i++){
                if(productos.get(i) instanceof ProductoFisico){
                    ((ProductoFisico) productos.get(i)).mostrarInfoCompleta();
                    System.out.println();
                }
        }
        System.out.println("---Productos digitales---");
        for (int i =0;i< productos.size();i++){
            if(productos.get(i) instanceof ProductoDigital){
                ((ProductoDigital) productos.get(i)).mostrarInfoCompleta();
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("---Bootcamp.Producto mas caro---");
        ProductoBase masCaro= productos.get(0);
        for (int i=1 ;i< productos.size();i++){
            if  (productos.get(i).calcularPrecioFinal()>masCaro.calcularPrecioFinal()){
                masCaro=productos.get(i);
            }
        }
        System.out.println("El producto más caro es:");
        System.out.println("Nombre: " + masCaro.getNombre());
        System.out.println("Precio Final: " + masCaro.calcularPrecioFinal() + "€");

        if(masCaro instanceof ProductoFisico){
            System.out.println("Tipo: Bootcamp.Producto Físico");
            ProductoFisico pf= (ProductoFisico) masCaro;
            System.out.println("Costo envío: "+pf.calcularCostoEnvio()+" €");
        } else if (masCaro instanceof ProductoDigital) {
            System.out.println(("Tipo: Bootcamp.Producto Digital"));

        }

    }
}
