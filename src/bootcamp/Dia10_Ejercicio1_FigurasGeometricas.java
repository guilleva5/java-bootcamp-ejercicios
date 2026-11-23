package bootcamp;

import java.util.ArrayList;

abstract class Figura{
    protected String nombre;
    protected String color;

    public Figura(String nombre, String color){
        this.nombre=nombre;
        this.color=color;
    }
    public abstract double calcularArea();
    public abstract double calcularPerimetro();
    public void mostrarInfo() {
        System.out.println("Bootcamp.Figura: " + nombre);
        System.out.println("Color: " + color);
    }
    public String getNombre() {
        return nombre;
    }

}
class  Circulo extends Figura {
    private double radio;

    public Circulo(String nombre, String color, double radio){
        super(nombre, color);
        this.radio=radio;
    }

    @Override
    public double calcularArea() {
        return  Math.PI * radio * radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
    public void mostrarInfoCompleta() {
        mostrarInfo();  // Del padre
        System.out.println("Radio: " + radio);
        System.out.println("Área: " + calcularArea());
        System.out.println("Perímetro: " + calcularPerimetro());
    }
}
class Rectangulo extends Figura {
    private double base;
    private double altura;

    public Rectangulo(String nombre, String color, double base, double altura){
        super(nombre, color);
        this.base=base;
        this.altura=altura;
    }

    @Override
    public double calcularArea() {
        return base*altura;
    }

    @Override
    public double calcularPerimetro() {
        return  2 * (base + altura);
    }
    public void mostrarInfoCompleta() {
        mostrarInfo();
        System.out.println("Base: " + base);
        System.out.println("Altura: " + altura);
        System.out.println("Área: " + calcularArea());
        System.out.println("Perímetro: " + calcularPerimetro());
    }
}
class Triangulo extends Figura {
    private double base;
    private double altura;
    private double lado1;
    private double lado2;
    private double lado3;

    public Triangulo(String nombre, String color, double base, double altura,
                     double lado1, double lado2, double lado3){
    super(nombre,color);
    this.altura=altura;
    this.base=base;
    this.lado1=lado1;
    this.lado2=lado2;
    this.lado3=lado3;
    }

    @Override
    public double calcularPerimetro() {
        return lado1 + lado2 + lado3;
    }

    @Override
    public double calcularArea() {
        return (base * altura) / 2;
    }
    public void mostrarInfoCompleta() {
        mostrarInfo();
        System.out.println("Base: " + base);
        System.out.println("Altura: " + altura);
        System.out.println("Área: " + calcularArea());
        System.out.println("Perímetro: " + calcularPerimetro());
    }
}

public class Dia10_Ejercicio1_FigurasGeometricas {
    public static void main(String[] args) {
        ArrayList<Figura>figuras=new ArrayList<>();
        figuras.add(new Circulo("Circulo1","Rojo",5));
        figuras.add(new Rectangulo("Rectangulo1","Azul",4,6));
        figuras.add(new Triangulo("Triangulo1","verde",3,4,3,4,5));

        for (int i =0;i<figuras.size();i++){
            if (figuras.get(i) instanceof Circulo){
                ((Circulo) figuras.get(i)).mostrarInfoCompleta();
            } else if (figuras.get(i) instanceof Rectangulo) {
                ((Rectangulo) figuras.get(i)).mostrarInfoCompleta();
            }
            else if (figuras.get(i) instanceof Triangulo) {
                ((Triangulo) figuras.get(i)).mostrarInfoCompleta();
            }
            System.out.println();
        }
        double areaTotal =0;
        for (int i =0;i<figuras.size();i++ ){
            areaTotal+=figuras.get(i).calcularArea();
        }
        System.out.println("El area total de todas la figuras son :"+areaTotal);
        Figura mayor= figuras.get(0);
        for (int i =0;i<figuras.size();i++){
            if(figuras.get(i).calcularArea()> mayor.calcularArea()){
                mayor= figuras.get(i);
            }
        }
        System.out.println("=== FIGURA CON MAYOR ÁREA ===");
        System.out.println("La figura con mayor área es: " + mayor.getNombre());
        System.out.println("Área: " + mayor.calcularArea());

    }

}