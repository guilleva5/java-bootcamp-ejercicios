package bootcamp;

class EmpleadoBase {
    protected  String nombre;
    protected String dni;
    protected  int edad;
    protected String departamento;

    public EmpleadoBase(String nombre, String dni, int edad, String departamento) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.departamento = departamento;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("DNI: " + dni);
        System.out.println("Edad: " + edad);
        System.out.println("Departamento: " + departamento);
    }
    public double calcularSalarioMensual(){
        return 0;
    }


}
class EmpleadoTiempoCompleto extends EmpleadoBase{
    private double salarioMensual;
    private double bonificacionAnual;

    public EmpleadoTiempoCompleto(String nombre, String dni, int edad,String departamento,double salarioMensual,double bonificacionAnual){
        super(nombre,dni,edad,departamento);
        this.salarioMensual=salarioMensual;
        this.bonificacionAnual=bonificacionAnual;
    }

    @Override
    public double calcularSalarioMensual() {
        return salarioMensual;
    }
    public double calcularSalarioAnual (){
        return salarioMensual*12+bonificacionAnual;
    }
    public void mostrarInfoCompleta() {
        mostrarInfo();  // ← Método heredado
        System.out.println("Salario Mensual: " + salarioMensual + "€");
        System.out.println("Bonificación Anual: " + bonificacionAnual + "€");
    }
}
class EmpleadoMedioTiempo extends EmpleadoBase {
    private double tarifaPorHoras;
    private int horasTrabajadas;

    public EmpleadoMedioTiempo(String nombre, String dni, int edad,String departamento,double tarifaPorHoras,int horasTrabajadas){
        super(nombre, dni, edad, departamento);
        this.tarifaPorHoras=tarifaPorHoras;
        this.horasTrabajadas=horasTrabajadas;
    }
    public double calcularSalarioMensual (){
        return tarifaPorHoras*horasTrabajadas;
    }
    public double calcularSalarioAnual(){
        return calcularSalarioMensual()*12;
    }


    public void mostrarInfoCompleta() {
        mostrarInfo();
        System.out.println("Salario mensual :"+ calcularSalarioMensual()+" €");
        System.out.println("Salario anual :"+ calcularSalarioAnual()+"€");
    }
}


public class Dia8_Ejercicio2_HerenciaEmpleados {
    public static void main(String[] args) {
        EmpleadoTiempoCompleto emp1 = new EmpleadoTiempoCompleto("Juan García", "12345678A", 30, "IT", 2000, 1500);
        EmpleadoTiempoCompleto emp2 = new EmpleadoTiempoCompleto("María López", "87654321B", 28, "Ventas", 1800, 1200);
        EmpleadoMedioTiempo emp3 = new EmpleadoMedioTiempo("Pedro Martín", "11111111C", 35, "RRHH", 15, 80);
        EmpleadoMedioTiempo emp4 = new EmpleadoMedioTiempo("Ana Ruiz", "22222222D", 26, "IT", 12, 60);

        // Mostrar info completa
        System.out.println("=== EMPLEADO TIEMPO COMPLETO 1 ===");
        emp1.mostrarInfoCompleta();
        System.out.println();

        System.out.println("=== EMPLEADO TIEMPO COMPLETO 2 ===");
        emp2.mostrarInfoCompleta();
        System.out.println();

        System.out.println("=== EMPLEADO MEDIO TIEMPO 1 ===");
        emp3.mostrarInfoCompleta();
        System.out.println();

        System.out.println("=== EMPLEADO MEDIO TIEMPO 2 ===");
        emp4.mostrarInfoCompleta();
        System.out.println();

        // Salarios mensuales
        System.out.println("=== SALARIOS MENSUALES ===");
        System.out.println("Juan: " + emp1.calcularSalarioMensual() + "€");
        System.out.println("María: " + emp2.calcularSalarioMensual() + "€");
        System.out.println("Pedro: " + emp3.calcularSalarioMensual() + "€");
        System.out.println("Ana: " + emp4.calcularSalarioMensual() + "€");
        System.out.println();

        // Salarios anuales
        System.out.println("=== SALARIOS ANUALES ===");
        System.out.println("Juan: " + emp1.calcularSalarioAnual() + "€");
        System.out.println("María: " + emp2.calcularSalarioAnual() + "€");
        System.out.println("Pedro: " + emp3.calcularSalarioAnual() + "€");
        System.out.println("Ana: " + emp4.calcularSalarioAnual() + "€");
    }
}
