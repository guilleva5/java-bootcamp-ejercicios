package bootcamp;

class Empleado {
    private String nombre;
    private String dni;
    private int edad;
    private double salario;
    private String departamento;

    public Empleado(String nombre, String dni, int edad, double salario, String departamento) {
        setNombre(nombre);
        setDni(dni);
        setEdad(edad);
        setSalario(salario);
        setDepartamento(departamento);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public int getEdad() {
        return edad;
    }

    public double getSalario() {
        return salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty() && nombre.length() >= 5) {
            this.nombre = nombre;
        } else {
            System.out.println("Error, el nombre debe tener minimo 5 caracteres");
        }
    }

    public void setDni(String dni) {
        if (dni != null && !dni.isEmpty() && dni.length() == 9) {
            this.dni = dni;
        } else {
            System.out.println("Error : DNI debe tener exactamente 9 caracteres");
        }
    }

    public void setEdad(int edad) {
        if (edad >= 18 && edad <= 65) {
            this.edad = edad;
        } else {
            System.out.println("Error : Edad debe estar entre 18 y 65 años");
        }
    }

    public void setSalario(double salario) {
        if (salario >= 1000 && salario <= 10000) {
            this.salario = salario;
        } else {
            System.out.println("Error: Salario debe estar entre 1000 y 10000 euros");
        }
    }

    public void setDepartamento(String departamento) {
        if (departamento.equalsIgnoreCase("Ventas") || departamento.equalsIgnoreCase("IT") || departamento.equalsIgnoreCase("RRHH") || departamento.equalsIgnoreCase("Finanzas")) {
            this.departamento = departamento;
        } else {
            System.out.println("Error: Departamento inválido. Debe ser: Ventas, IT, RRHH o Finanzas");
        }
    }

    public void aumentarSalario(double porcentaje ) {
        double nuevoSalario;

        if (porcentaje > 0 && porcentaje <= 50) {
            nuevoSalario = salario + (salario * porcentaje/100);
            if (nuevoSalario <= 10000) {
                this.salario=nuevoSalario;
                System.out.println("Salario aumentado en " + porcentaje + "% Nuevo salario: " + nuevoSalario);
            } else {
                nuevoSalario = 10000;
                System.out.println("Error ,el salario no puede ser mayor de 10000 euros");
            }
        } else {
            System.out.println("Error : El porcentaje debe estar entre 0 y 50%");
        }
    }
    public void cambiarDepartamento(String nuevoDepartamento){
        setDepartamento(nuevoDepartamento);

    }
    public void mostrarInfo(){
        System.out.println("Nombre del empleado: "+nombre);
        System.out.println("Dni : "+dni);
        System.out.println("Edad :"+ edad+ " años");
        System.out.println("Salario :"+ salario + " euros");
        System.out.println("Departamento :"+ departamento);
        System.out.println();
    }

}

public class Dia5_Proyecto_Final_Empleados {
    public static void main(String[] args) {
        Empleado empleado1=new Empleado("Juan García", "12345678A", 30, 1500, "IT");
        Empleado empleado2=new Empleado( "María López", "87654321B", 28, 1800, "Ventas");

        empleado1.mostrarInfo();
        empleado2.mostrarInfo();

        empleado1.aumentarSalario(60);
        empleado1.aumentarSalario(15);
        empleado2.cambiarDepartamento("marketing");
        empleado2.cambiarDepartamento("RRHH");
        empleado1.setEdad(70);
        empleado1.setSalario(500);
        empleado1.setDni("123");
        empleado1.mostrarInfo();
        empleado2.mostrarInfo();
    }
}
