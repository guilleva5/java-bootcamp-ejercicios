package Bootcamp;

import java.util.ArrayList;

interface Llamable{
    void hacerLlamada(String numero);
    void recibirLlamada(String numero);
}
interface Navegable{
    void navegarInternet (String url);
    void descargarArchivo(String archivo);
}
interface Fotografiable{
    void tomarFoto();
    void verGaleria();
}
class Smartphone implements Llamable,Navegable,Fotografiable {
    private String marca;
    private String modelo;

    public Smartphone(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public void hacerLlamada(String numero) {
        System.out.println(marca + " " + modelo + " llamando al " + numero);
    }

    @Override
    public void recibirLlamada(String numero) {
        System.out.println("Llamada recibida del numero: " + numero);
    }

    @Override
    public void navegarInternet(String url) {
        System.out.println(marca + " " + modelo + " navegando por " + url);
    }

    @Override
    public void descargarArchivo(String archivo) {
        System.out.println("Descargando: " + archivo);
    }

    @Override
    public void tomarFoto() {
        System.out.println(marca + " " + modelo + " tomando foto");
    }

    @Override
    public void verGaleria() {
        System.out.println("Viendo galeria");
    }
}
    class Tablet implements Navegable,Fotografiable{
        private String marca;
        private String modelo;
        public Tablet(String marca, String modelo){
            this.marca=marca;
            this.modelo=modelo;
        }

        @Override
        public void navegarInternet(String url) {
            System.out.println(marca+" " + modelo +" navegando por "+url);
        }

        @Override
        public void descargarArchivo(String archivo) {
            System.out.println("Descargando archivo : "+archivo);
        }

        @Override
        public void tomarFoto() {
            System.out.println(marca +" "+modelo+" tomando foto");
        }

        @Override
        public void verGaleria() {
            System.out.println("Viendo galeria del "+marca +" "+modelo);
        }
    }
    class TelefonoFijo implements Llamable{
        private String marca;
        public TelefonoFijo(String marca){
            this.marca=marca;
        }

        @Override
        public void hacerLlamada(String numero) {
            System.out.println(marca+" llamando a "+numero);
        }

        @Override
        public void recibirLlamada(String numero) {
            System.out.println(marca+" recibiendo llamada del "+numero);
        }
    }

public class Dia11_Ejercicio1_DispositivosElectronicos {
    public static void main(String[] args) {
        Smartphone phone = new Smartphone("Samsung", "Galaxy S21");
        Tablet tablet = new Tablet("Apple", "iPad Pro");
        TelefonoFijo fijo = new TelefonoFijo("Panasonic");

        System.out.println("---Probando llamadas---");
        phone.hacerLlamada("666555444");
        phone.recibirLlamada("777888999");

        fijo.hacerLlamada("1234567892");
        fijo.recibirLlamada("987654321");

        System.out.println("---Probando navegacion---");
        phone.navegarInternet("www.google.com");
        tablet.navegarInternet("www.youtube.com");

        System.out.println("---Probando fotos---");
        phone.tomarFoto();
        tablet.tomarFoto();

        System.out.println("---Polimorfismo---");
        ArrayList<Llamable>dispositivosLlamables=new ArrayList<>();
        dispositivosLlamables.add(phone);
        dispositivosLlamables.add(fijo);

        for(int i =0;i<dispositivosLlamables.size();i++){
            dispositivosLlamables.get(i).hacerLlamada("112");
        }


    }
}
