package bootcamp;

public class Dia4_Ejercicio3_Estudiante {
    public static void main(String[] args) {
        Estudiante estudiante1 = new Estudiante("Guille", 26, "Desarrollo Android", 7.5);
        estudiante1.mostrarInfo();  // ← PRIMERO mostrar
        estudiante1.estudiar();     // ← Estudiar 1
        estudiante1.estudiar();     // ← Estudiar 2
        estudiante1.mostrarInfo();  // ← DESPUÉS mostrar

        System.out.println();

        // Bootcamp.Estudiante 2
        Estudiante estudiante2 = new Estudiante("Manolo", 25, "Ingeniería", 8.0);
        estudiante2.mostrarInfo();  // ← PRIMERO mostrar
        estudiante2.estudiar();     // ← Estudiar 1
        estudiante2.estudiar();     // ← Estudiar 2
        estudiante2.mostrarInfo();  // ← DESPUÉS mostrar

        System.out.println();

        // Bootcamp.Estudiante 3 (este SÍ lo tienes bien)
        Estudiante estudiante3 = new Estudiante("Ana", 23, "Medicina", 9.0);
        estudiante3.mostrarInfo();
        estudiante3.estudiar();
        estudiante3.estudiar();
        estudiante3.mostrarInfo();

    }

}
class Estudiante{
    String nombre;
    int edad;
    String carrera;
    double promedio;

    public Estudiante (String nombre, int edad, String carrera, double promedio){
        this.nombre=nombre;
        this.edad=edad;
        this.carrera=carrera;
        this.promedio=promedio;
    }
    public void estudiar(){
        promedio=promedio + 0.5;
        if (promedio >10){
            promedio=10;
        }
        System.out.println(nombre+" está estudiando. Promedio actual: "+promedio
        );
    }
    public void mostrarInfo(){
        System.out.println("Bootcamp.Estudiante :"+ nombre + ", "+edad+" años , Carrera: "+carrera+" Promedio :"+promedio);
    }
}
