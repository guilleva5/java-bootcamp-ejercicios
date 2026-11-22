package logica;

class Repostaje{
    int cliente;
    double litros;
    double importe;
    String tipoCombustible;

    public Repostaje(int cliente, double litros, double importe, String tipoCombustible) {
        this.cliente = cliente;
        this.litros = litros;
        this.importe = importe;
        this.tipoCombustible = tipoCombustible;
    }

    public int getCliente() {
        return cliente;
    }

    public double getLitros() {
        return litros;
    }

    public double getImporte() {
        return importe;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }
}
class ResumenCliente{
    int numeroRepostajeC=0;
    double litrosTotalesC=0;
    double importeTotalC=0;
    int numCliente;
}

public class RespostajesClientes {
    public static void main(String[] args) {
        Repostaje[] repostajes = {
                new Repostaje(1, 40.0, 62.00, "diesel"),
                new Repostaje(3, 25.5, 41.30, "gasolina"),
                new Repostaje(1, 35.0, 54.25, "diesel"),
                new Repostaje(2, 50.0, 81.00, "gasolina"),
                new Repostaje(5, 20.0, 31.00, "diesel"),
                new Repostaje(3, 45.0, 72.90, "gasolina"),
                new Repostaje(1, 30.0, 46.50, "diesel"),
                new Repostaje(4, 55.0, 89.10, "gasolina"),
                new Repostaje(2, 28.0, 45.36, "diesel"),
                new Repostaje(5, 60.0, 93.00, "diesel"),
                new Repostaje(3, 15.0, 24.30, "gasolina"),
                new Repostaje(1, 48.0, 74.40, "diesel")
        };

        int contadorDiesel=0;
        int contadorGasolina=0;
        ResumenCliente[] resumenClientes=new ResumenCliente[6];

        for (int i=0;i<resumenClientes.length;i++){
            resumenClientes[i]=new ResumenCliente();
            resumenClientes[i].numCliente=i;
        }

        for (int i=0;i<repostajes.length;i++){
            Repostaje r=repostajes[i];

            int c =r.getCliente();

            resumenClientes[c].numeroRepostajeC++;
            resumenClientes[c].litrosTotalesC+=r.getLitros();
            resumenClientes[c].importeTotalC+=r.getImporte();

            if(r.getTipoCombustible().equalsIgnoreCase("diesel")){
                contadorDiesel++;
            }
            if (r.getTipoCombustible().equalsIgnoreCase("gasolina")){
                contadorGasolina++;
            }
        }

        ResumenCliente clienteMasGasto =resumenClientes[1];

        for (int i=2;i<resumenClientes.length;i++){
            if (resumenClientes[i].importeTotalC>clienteMasGasto.importeTotalC){
                clienteMasGasto=resumenClientes[i];
            }
        }

        for (int i=1;i<resumenClientes.length;i++){
            System.out.println("Cliente " + i
                    + " | Repostajes: " + resumenClientes[i].numeroRepostajeC
                    + " | Litros: " + String.format("%.2f", resumenClientes[i].litrosTotalesC)
                    + " | Importe: " + String.format("%.2f", resumenClientes[i].importeTotalC) + " €");


        }
        System.out.println("El cliente con mayor importe ha sido el: "+clienteMasGasto.numCliente+" teniendo un importe de:"+
                String.format("%.2f",clienteMasGasto.importeTotalC)+" €"
                );
        System.out.println("Numero de repostajes con diesel :"+contadorDiesel);
        System.out.println("Numero de repostajes con gasolina: "+contadorGasolina);
    }

}
