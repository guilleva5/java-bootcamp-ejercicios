package bootcamp;

import java.util.ArrayList;

interface Pagable{
    void procesarPago(double monto);
    String obtenerTipoPago();
}
interface Reembolsable{
    void procesarReembolso(double monto);
    String obtenerEstadoReembolso();
}
interface Verificable {
    boolean verificarSeguridad();
    String obtenerCodigoVerificacion();
}
class TarjetaCredito1 implements Pagable,Reembolsable,Verificable {
    private String numeroTarjeta;
    private String nombreTitular;
    public TarjetaCredito1(String numeroTarjeta,String nombreTitular){
        this.numeroTarjeta=numeroTarjeta;
        this.nombreTitular=nombreTitular;
    }

    @Override
    public void procesarPago(double monto) {
        System.out.println("Procesando pago de :"+monto+"€ con tarjeta:"+numeroTarjeta);
    }

    @Override
    public String obtenerTipoPago() {
        return "Tarjeta de credito";
    }

    @Override
    public void procesarReembolso(double monto) {
        System.out.println("Procesando reembolso de :"+monto+"€ a tarjeta "+numeroTarjeta);
    }

    @Override
    public String obtenerEstadoReembolso() {
        return "Reembolso procesado en 3-5 días";
    }

    @Override
    public boolean verificarSeguridad() {
        return true;
    }

    @Override
    public String obtenerCodigoVerificacion() {
        return "CVV-"+numeroTarjeta.substring(0,4);
    }
}
class Paypal1 implements Pagable,Reembolsable {
    private String emailCuenta;
    public Paypal1(String emailCuenta){
        this.emailCuenta=emailCuenta;
    }

    @Override
    public void procesarPago(double monto) {
        System.out.println("Procesando pago de :"+monto+"€ del paypal :"+emailCuenta);
    }

    @Override
    public String obtenerTipoPago() {
        return "Bootcamp.Paypal";
    }

    @Override
    public void procesarReembolso(double monto) {
        System.out.println("Procesando el reembolso de :"+monto+" a paypal: "+emailCuenta);
    }

    @Override
    public String obtenerEstadoReembolso() {
        return "Procesando reembolso de 5 a 7 dias.";
    }
}
class TransferenciaBancaria1 implements Pagable,Verificable{
    private String numeroCuentaBancaria;
    public TransferenciaBancaria1(String numeroCuentaBancaria){
        this.numeroCuentaBancaria=numeroCuentaBancaria;
    }

    @Override
    public void procesarPago(double monto) {
        System.out.println("Procesando pago de :"+monto+"€ de "+numeroCuentaBancaria);
    }

    @Override
    public String obtenerTipoPago() {
        return "Transferencia bancaria";
    }

    @Override
    public boolean verificarSeguridad() {
        return true;
    }

    @Override
    public String obtenerCodigoVerificacion() {
        return "Cuenta-"+numeroCuentaBancaria.substring(0,4);
    }
}
class Efectivo implements Pagable{
    @Override
    public void procesarPago(double monto) {
        System.out.println("Procesando pago en efectivo de :"+monto+"€");
    }

    @Override
    public String obtenerTipoPago() {
        return "Bootcamp.Efectivo";
    }
}
public class Dia11_Ejercicio2_SistemaFormasPago {
    public static void main(String[] args) {
        TarjetaCredito1 tarjeta = new TarjetaCredito1("1234-5678-9012-3456", "Juan García");
        Paypal1 paypal = new Paypal1("juan@email.com");
        TransferenciaBancaria1 transferencia = new TransferenciaBancaria1("ES12-3456-7890");
        Efectivo efectivo = new Efectivo();
        System.out.println("---Procesando pagos---");
        tarjeta.procesarPago(100.50);
        paypal.procesarPago(50.00);
        transferencia.procesarPago(200.00);
        efectivo.procesarPago(25.00);

        ArrayList<Pagable>pagables=new ArrayList<>();
        pagables.add(tarjeta);
        pagables.add(paypal);
        pagables.add(transferencia);
        pagables.add(efectivo);
        System.out.println("---Procesando pagos---");
        for (int i=0;i<pagables.size();i++){
            pagables.get(i).procesarPago(10);
        }
        ArrayList<Reembolsable>reembolsables=new ArrayList<>();
        reembolsables.add(tarjeta);
        reembolsables.add(paypal);
        System.out.println("---Procesando reembolsos");
        for (int i=0;i<reembolsables.size();i++){
            reembolsables.get(i).procesarReembolso(5);
        }
        ArrayList<Verificable>verificables=new ArrayList<>();
        verificables.add(tarjeta);
        verificables.add(transferencia);
        System.out.println("---Verificando seguridad---");
        for (int i=0;i<verificables.size();i++){
            if(verificables.get(i).verificarSeguridad()){
                System.out.println("Verificacion exitosa: "+verificables.get(i).obtenerCodigoVerificacion());
            }
        }
    }
}
