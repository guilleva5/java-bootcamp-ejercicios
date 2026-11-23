package bootcamp;

import java.util.Scanner;

public class Dia15_Ejercicio_ValidadorDatos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el nombre de usuario:");
        String nombre= scanner.nextLine();

        System.out.println("Introduce tu email:");
        String email=scanner.nextLine();

        System.out.println("Introduce tu telefono:");
        String numeroTelefono=scanner.nextLine();

        System.out.println("Introduce la contraseña:");
        String contraseña= scanner.nextLine();

        boolean nombreValido=false;
        boolean emailValido=false;
        boolean telefonoValido=false;
        boolean contraseñaValido=false;

        System.out.println("\n=== VALIDANDO DATOS ===");

        if(nombre.isEmpty()){
            System.out.println("Nombre obligatorio");
            nombreValido=false;
        } else if (nombre.length()<3) {
            System.out.println("Nombre muy corto");
            nombreValido=false;
        }else{
            boolean tieneNumero=false;
            for (int i =0;i<nombre.length();i++){
                if(Character.isDigit(nombre.charAt(i))){
                    tieneNumero=true;
                    break;
                }
            }
            if(tieneNumero){
                System.out.println("❌ El nombre no puede contener números");
                nombreValido=false;
            }else{
                System.out.println("✅ Nombre: " + nombre.toUpperCase());
                nombreValido=true;
            }
        }

        if(email.isEmpty()){
            System.out.println("❌ Email obligatorio");;
        } else if (!email.contains("@") || !email.contains(".")) {
            System.out.println("❌ Email no válido");
        } else if (email.endsWith(".es") && email.endsWith(".com")) {
            System.out.println("❌ Email no válido");
        } else {
            System.out.println("✅ Email: " + email.toLowerCase());
            emailValido =true;
        }

        if(numeroTelefono.isEmpty()){
            System.out.println("❌ Teléfono obligatorio");
        } else if (numeroTelefono.length() !=9) {
            System.out.println("❌ Teléfono debe tener 9 dígitos");
        } else if (!numeroTelefono.startsWith("6") && !numeroTelefono.startsWith("7") & !numeroTelefono.startsWith("9")){
            System.out.println("❌ El teléfono debe empezar por 6, 7 o 9");
        }else{
            System.out.println("✅ Teléfono: " + numeroTelefono);
            telefonoValido=true;
        }

        if(contraseña.isEmpty()){
            System.out.println("❌ Contraseña obligatorio");
        }else if (contraseña.length()<8){
            System.out.println("❌ Teléfono debe tener minimo 8 caracteres");
        }else {
            System.out.println("✅ Contraseña aceptada : " + contraseña);
            contraseñaValido=true;
        }


        System.out.println("Resumen final añadido:");
        System.out.println("Nombre :" + (nombreValido ? "✅" : "❌"));
        System.out.println("Email: "+ (emailValido ? "✅" : " ❌"));
        System.out.println("Teléfono: " + (telefonoValido ? "✅" : "❌"));
        System.out.println("Contraseña: " + (contraseñaValido ? "✅" : "❌"));

        boolean todoValido=nombreValido && emailValido && telefonoValido && contraseñaValido;
        System.out.println("Registro :"+ (todoValido ? "✅ COMPLETO": "❌ INCOMPLETO"));

        scanner.close();


    }
}
