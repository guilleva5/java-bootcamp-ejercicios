package Bootcamp;

class Producto {
    private String nombre;
    private double precio;
    private int stock;
    private String codigo;

    public Producto(String nombre, double precio, int stock, String codigo) {
        setNombre(nombre);
        setPrecio(precio);
        setStock(stock);
        setCodigo(codigo);
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty() && nombre.length() >= 3) {
            this.nombre = nombre;
        } else {
            System.out.println("Error: Nombre debe tener al menos 3 caracteres");
        }

    }

    public void setPrecio(double precio) {
        if (!(precio <= 0)) {
            this.precio = precio;
        } else {
            System.out.println("Error ,el precio debe ser mayor que 0");
        }
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        } else {
            System.out.println("Error: Stock no puede ser negativo");
        }
    }

    public void setCodigo(String codigo) {
        if (codigo != null && !codigo.trim().isEmpty() && codigo.length() == 7) {
            this.codigo = codigo;
        } else {
            System.out.println("Error: Código debe tener exactamente 7 caracteres");
        }

    }
    public void mostrarInfo(){
        System.out.println("=== PRODUCTO ===");
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: " + precio + "€");
        System.out.println("Stock: " + stock + " unidades");
        System.out.println();
    }

}

public class Dia5_Ejercicio1_Producto {
    public static void main(String[] args) {

        Producto p1 = new Producto("laptop",899.99,10,"PROD001");
        p1.mostrarInfo();

        p1.setPrecio(-50.0);
        p1.setStock(-5);
        p1.setNombre("ab");
        p1.setCodigo("123");
        p1.mostrarInfo();

        p1.setPrecio(799.99);
        p1.setStock(15);
        p1.mostrarInfo();


    }
}
