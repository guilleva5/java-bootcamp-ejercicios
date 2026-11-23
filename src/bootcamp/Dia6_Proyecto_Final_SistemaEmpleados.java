package bootcamp;

public class Dia6_Proyecto_Final_SistemaEmpleados {
    public static void main(String[] args) {
        Empleado[] empleados= new Empleado[6];
        empleados[0]= new Empleado("Juan García" ,"12345678A",30,1500,"IT");
        empleados[1]= new Empleado("María López","87654321B",28,1800,"Ventas");
        empleados[2]=new Empleado("Pedro Martín","11111111C",35,2000,"IT");
        empleados[3]=new Empleado("Ana Ruiz","22222222D",26,1400,"RRHH");
        empleados[4]= new Empleado("Carlos Sanz","33333333E",40,2500,"Finanzas");
        empleados[5]=new Empleado("Laura Torres","44444444F",32,1700,"Ventas");

        for ( int i= 0;i< empleados.length;i ++){
            empleados[i].mostrarInfo();
        }
        System.out.println();
        System.out.println("---Busqueda por nombre---");
        String nombreBuscado= "María López";
        boolean encontrado= false;

        for ( int i= 0;i< empleados.length;i ++){
            if(nombreBuscado.equalsIgnoreCase(empleados[i].getNombre())){
                empleados[i].mostrarInfo();
                encontrado=true;
                break;
            }
        }
        if(!encontrado){
            System.out.println(nombreBuscado+" Bootcamp.Empleado no encontrado.");
        }

        System.out.println();
        System.out.println("---Listar empleados de un departamento  IT ---");
        int contador=0;
        for ( int i= 0;i< empleados.length;i ++){
            if (empleados[i].getDepartamento().equalsIgnoreCase("IT")){
                contador ++;
                empleados[i].mostrarInfo();
            }
        }
        System.out.println("Numero total de empleados en el departamento IT :"+ contador);

        System.out.println();
        System.out.println("Empleados con un salario de 2000 $ o mas");
        int contadorSalario = 0;
        for ( int i= 0;i< empleados.length;i ++){
            if(empleados[i].getSalario()>=2000){
                contadorSalario++;
                empleados[i].mostrarInfo();
            }
        }
        System.out.println("Numero de empleados con un salario de 2000$ o superior: "+contadorSalario);

        System.out.println();
        System.out.println(" AUMENTO 10% PARA DEPARTAMENTO IT");
        for ( int i= 0;i< empleados.length;i ++){
            if (empleados[i].getDepartamento().equalsIgnoreCase("IT")){
                empleados[i].aumentarSalario(10);
                empleados[i].mostrarInfo();
            }
        }
        System.out.println("AUMENTO DE SALARIO confirmado,para los del departamento IT");

        System.out.println();
        System.out.println("---Estadisticas generales---");
        System.out.println("Numero total de empleados :"+empleados.length);

        double salariototal=0;
        double salarioPromedio=0;
        for ( int i= 0;i< empleados.length;i ++){
            salariototal=salariototal+empleados[i].getSalario();
            salarioPromedio = salariototal/ empleados.length;
        }

        Empleado salarioMasAlto = empleados[0];
        for ( int i= 0;i< empleados.length;i ++){
            if (empleados[i].getSalario()> salarioMasAlto.getSalario()){
                salarioMasAlto = empleados[i];
            }
        }
        System.out.println("Salario más alto: " + salarioMasAlto.getNombre() +
                " (" + salarioMasAlto.getSalario() + "€)");

        Empleado salarioMasBajo=empleados[0];
        for ( int i= 0;i< empleados.length;i ++){
            if (empleados[i].getSalario()< salarioMasBajo.getSalario()){
                salarioMasBajo = empleados[i];
            }
        }
        System.out.println("Salario más bajo: " + salarioMasBajo.getNombre() +
                " (" + salarioMasBajo.getSalario() + "€)");


        System.out.println("Salario total de la empresa :"+salariototal+" $ ,y el salario promedio :"+salarioPromedio);

    }
}
