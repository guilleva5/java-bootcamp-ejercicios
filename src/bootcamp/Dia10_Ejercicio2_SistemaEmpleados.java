package bootcamp;

import java.util.ArrayList;

abstract class EmpleadoAbstracto{
    protected String nombre;
    protected String dni;
    protected String departamento;

    public EmpleadoAbstracto(String nombre,String dni,String departamento){
        this.nombre=nombre;
        this.dni=dni;
        this.departamento=departamento;
    }
    public abstract double calcularSalarioMensual();
    public abstract double calcularSalarioAnual();
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("DNI: " + dni);
        System.out.println("Departamento: " + departamento);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDepartamento() {
        return departamento;
    }
}
class EmpleadoTiempoCompletoAbstracto extends EmpleadoAbstracto{
    private double salarioMensual;
    private double bonificacionAnual;

    public EmpleadoTiempoCompletoAbstracto(String nombre, String dni, String departamento,
                                  double salarioMensual, double bonificacionAnual){
        super(nombre,dni,departamento);
        this.salarioMensual=salarioMensual;
        this.bonificacionAnual=bonificacionAnual;
    }

    @Override
    public double calcularSalarioMensual() {
        return salarioMensual;
    }

    @Override
    public double calcularSalarioAnual() {
        return (salarioMensual*12)+bonificacionAnual;
    }
    public void mostrarInfoCompleta(){
        mostrarInfo();
        System.out.println("Tipo: Tiempo Completo");
        System.out.println("Salario Mensual: " + salarioMensual + "€");
        System.out.println("Bonificación Anual: " + bonificacionAnual + "€");
        System.out.println("Salario Anual Total: " + calcularSalarioAnual() + "€");
    }

}
class EmpleadoMedioTiempoAbstracto extends EmpleadoAbstracto{
    private double tarifaPorHora;
    private int horasTrabajadas;  // Al mes
    public EmpleadoMedioTiempoAbstracto(String nombre, String dni, String departamento,
                                        double tarifaPorHora, int horasTrabajadas){
        super(nombre, dni, departamento);
        this.tarifaPorHora=tarifaPorHora;
        this.horasTrabajadas=horasTrabajadas;
    }

    @Override
    public double calcularSalarioMensual() {
        return tarifaPorHora * horasTrabajadas;
    }

    @Override
    public double calcularSalarioAnual() {
        return calcularSalarioMensual()*12;
    }
    public void mostrarInfoCompleta() {
        mostrarInfo();
        System.out.println("Tipo: Medio Tiempo");
        System.out.println("Tarifa por Hora: " + tarifaPorHora + "€");
        System.out.println("Horas Trabajadas al Mes: " + horasTrabajadas);
        System.out.println("Salario Mensual: " + calcularSalarioMensual() + "€");
        System.out.println("Salario Anual: " + calcularSalarioAnual() + "€");
    }
}
class Freelance extends EmpleadoAbstracto{
    private double tarifaPorProyecto;
    private int proyectosCompletados;  // Al mes

public Freelance (String nombre, String dni, String departamento,
                  double tarifaPorProyecto, int proyectosCompletados){
    super(nombre,dni,departamento);
    this.tarifaPorProyecto=tarifaPorProyecto;
    this.proyectosCompletados=proyectosCompletados;
}

    @Override
    public double calcularSalarioMensual() {
        return tarifaPorProyecto * proyectosCompletados;
    }

    @Override
    public double calcularSalarioAnual() {
        return calcularSalarioMensual() * 12;
    }
    public void mostrarInfoCompleta() {
        mostrarInfo();
        System.out.println("Tipo: Bootcamp.Freelance");
        System.out.println("Tarifa por Proyecto: " + tarifaPorProyecto + "€");
        System.out.println("Proyectos Completados al Mes: " + proyectosCompletados);
        System.out.println("Salario Mensual: " + calcularSalarioMensual() + "€");
        System.out.println("Salario Anual: " + calcularSalarioAnual() + "€");
    }
}


public class Dia10_Ejercicio2_SistemaEmpleados {
    public static void main(String[] args) {
        ArrayList<EmpleadoAbstracto>empleados=new ArrayList<>();
        empleados.add(new EmpleadoTiempoCompletoAbstracto("Juan García", "12345678A", "IT", 2000, 3000));
        empleados.add(new EmpleadoTiempoCompletoAbstracto("María López", "87654321B", "Ventas",1800, 2500));
        empleados.add(new EmpleadoMedioTiempoAbstracto("Pedro Martín", "11111111C","RRHH", 15, 80));
        empleados.add(new EmpleadoMedioTiempoAbstracto("Ana Ruiz", "22222222D","IT", 12, 60 ));
        empleados.add(new Freelance("Carlos Sánchez", "33333333E", "Marketing",500, 4));
        empleados.add(new Freelance("Laura Gómez", "44444444F", "Diseño", 800, 3 ));

        for (int i =0;i<empleados.size();i++){
            if(empleados.get(i) instanceof EmpleadoTiempoCompletoAbstracto){
                ((EmpleadoTiempoCompletoAbstracto) empleados.get(i)).mostrarInfoCompleta();
            } else if (empleados.get(i) instanceof EmpleadoMedioTiempoAbstracto) {
                ((EmpleadoMedioTiempoAbstracto) empleados.get(i)).mostrarInfoCompleta();
            }else if (empleados.get(i) instanceof Freelance){
                ((Freelance) empleados.get(i)).mostrarInfoCompleta();
            }
        }
        System.out.println("---Salario mensual total € ---");
        double salarioMensualTotal =0;
        for (int i =0 ;i<empleados.size();i++){
            salarioMensualTotal+= empleados.get(i).calcularSalarioMensual();
        }
        System.out.println("El salario mensual de todos los empleados es de : "+salarioMensualTotal+"€");
        System.out.println("---Salario anual total € ---");
        double salarioAnualTotal=0;
        for (int i =0 ;i<empleados.size();i++){
            salarioAnualTotal+= empleados.get(i).calcularSalarioAnual();
        }
        System.out.println("El salario anual de todos los empleados es de : "+salarioAnualTotal+"€");

        System.out.println("---Bootcamp.Empleado con salario anual mas elevado---");
        EmpleadoAbstracto salarioAnualAlto=empleados.get(0);
        for (int i =1 ;i<empleados.size();i++){
            if(empleados.get(i).calcularSalarioAnual()> salarioAnualAlto.calcularSalarioAnual()){
                salarioAnualAlto=empleados.get(i);
            }

        }
        System.out.println("Bootcamp.Empleado :"+salarioAnualAlto.getNombre());
        System.out.println("Salario :"+salarioAnualAlto.calcularSalarioAnual()+"€");
        System.out.println("---Empleados departamento IT");
        for (int i =0 ;i<empleados.size();i++){
            if (empleados.get(i).getDepartamento().equalsIgnoreCase("IT")){
                System.out.println("El empleado :"+empleados.get(i).getNombre()+ "esta en el departamento de "+empleados.get(i).getDepartamento());
            }
        }







    }
}
