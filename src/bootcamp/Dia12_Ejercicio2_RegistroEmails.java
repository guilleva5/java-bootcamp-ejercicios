package bootcamp;

import java.util.HashSet;

public class Dia12_Ejercicio2_RegistroEmails {
    public static void main(String[] args) {
        HashSet<String>emails=new HashSet<>();
        emails.add("juanhernandez@gmail.com");
        emails.add("anadominguez@mail.com");
        emails.add("antonio5@mail.com");
        emails.add("pedro7@gmail.com");
        emails.add("juanhernandez@gmail.com");

        System.out.println("---Registros de emails");
        System.out.println("Numero total de emails: "+emails.size());

        System.out.println("Verificar email:" );
        if(emails.contains("antonio5@gmail.com")){
            System.out.println("Email ya registrado");
        }
        System.out.println("---Eliminar email---");
        emails.remove("pedro7@gmail.com");

        System.out.println("Emails registrados");
        System.out.println("Total de emails registrados :" +emails.size());
        for (String email :emails){
            System.out.println("-"+email);
        }
    }
}