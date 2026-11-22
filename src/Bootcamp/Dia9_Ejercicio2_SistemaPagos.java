package Bootcamp;

import java.util.ArrayList;

class MetodoPago{
    protected String titular;
    protected double monto;

    public MetodoPago(String titular,double monto){
        this.titular=titular;
        this.monto=monto;
    }
    public void procesarPago(){
        System.out.println("Procesando el pago de "+monto+"€ para "+titular);
    }
    public double calcularComision(){
        return 0;
    }
    public void mostrarInfo(){
        System.out.println("Titular: " + titular);
        System.out.println("Monto: " + monto + "€");
    }
}
class TarjetaCredito extends MetodoPago{
    private String numeroTarjeta;
    public TarjetaCredito(String titular,double monto,String numeroTarjeta){
        super(titular,monto);
        this.numeroTarjeta=numeroTarjeta;
    }

    @Override
    public double calcularComision() {
        return monto*0.02;
    }

    @Override
    public void procesarPago() {
        System.out.println("💳 PAGO CON TARJETA");
        mostrarInfo();
        System.out.println("Número Tarjeta: " + numeroTarjeta);
        System.out.println("comision (2%):"+calcularComision());
        System.out.println("Total a pagar : "+(calcularComision()+monto)+"€");
    }
}
class Paypal extends MetodoPago{
    private String email ;

    public Paypal(String titular,double monto,String emailCuenta){
        super(titular,monto);
        this.email=emailCuenta;
    }

    @Override
    public double calcularComision() {
        return monto*0.03;
    }

    @Override
    public void procesarPago() {
            System.out.println("🅿️ PAGO CON PAYPAL");
            mostrarInfo();
            System.out.println("Email: " + email);
            System.out.println("Comisión (3%): " + calcularComision() + "€");
            System.out.println("Total a pagar: " + (monto + calcularComision()) + "€");
    }
}
class TransferenciaBancaria extends MetodoPago{
    private String numeroCuenta;
    public TransferenciaBancaria (String titular,double monto,String numeroCuenta){
        super(titular,monto);
        this.numeroCuenta=numeroCuenta;
    }

    @Override
    public double calcularComision() {
        return 0;
    }

    @Override
    public void procesarPago() {
        System.out.println("🏦 PAGO CON TRANSFERENCIA");
        mostrarInfo();
        System.out.println("Número Cuenta: " + numeroCuenta);
        System.out.println("Sin comisión");
        System.out.println("Total a pagar: " + monto + "€");
    }
    }




public class Dia9_Ejercicio2_SistemaPagos {
    public static void main(String[] args) {
        ArrayList<MetodoPago>pagos=new ArrayList<>();
        pagos.add(new TarjetaCredito("Juan García", 100, "1234-5678-9012-3456"));
        pagos.add(new Paypal( "María López", 50, "maria@email.com"));
        pagos.add(new TransferenciaBancaria( "Pedro Martín", 200, "ES12-3456-7890-1234"));

        for (int i=0;i< pagos.size();i++){
            pagos.get(i).procesarPago();
        }

        double comisionTotal=0;
        for (int i=0;i< pagos.size();i++){
            comisionTotal+= pagos.get(i).calcularComision();
        }
        System.out.println("\n=== ESTADÍSTICAS ===");
        System.out.println("Total de pagos: " + pagos.size());
        System.out.println("Comisión total cobrada: " + comisionTotal + "€");

        System.out.println("---Metodo polimorfico---");

        realizarPago(new TarjetaCredito("Ana Ruiz",75,"9999-8888-7777-6666"));



    }
    public static void realizarPago(MetodoPago p){
        p.procesarPago();
        System.out.println();
    }
}
