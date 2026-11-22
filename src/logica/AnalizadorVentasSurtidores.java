package logica;

class Venta{
    int surtidor;
    double litros;
    double precioLitro;
    int hora;

    public Venta(int surtidor, double litros, double precioLitro, int hora) {
        this.surtidor = surtidor;
        this.litros = litros;
        this.precioLitro = precioLitro;
        this.hora = hora;
    }

    public int getSurtidor() {
        return surtidor;
    }

    public double getLitros() {
        return litros;
    }

    public double getPrecioLitro() {
        return precioLitro;
    }

    public int getHora() {
        return hora;
    }
}
class ResumenSurtidor{
    int numeroVentas=0;
    double litrosTotales=0;
    double importeTotalS=0;
    int numSurtidor;

    public ResumenSurtidor() {
        this.numeroVentas = 0;
        this.litrosTotales = 0;
        this.importeTotalS = 0;
    }

    public int getNumeroVentas() {
        return numeroVentas;
    }

    public double getLitrosTotales() {
        return litrosTotales;
    }

    public double getImporteTotalS() {
        return importeTotalS;
    }


}
class  Venta2{
    String combustible;
    double litros;
    double importe;

    public Venta2(String combustible, double litros, double importe) {
        this.combustible = combustible;
        this.litros = litros;
        this.importe = importe;
    }

    public String getCombustible() {
        return combustible;
    }

    public double getLitros() {
        return litros;
    }

    public double getImporte() {
        return importe;
    }
}
class ResumenCombustible{
    int ventas=0;
    double litrosTotales=0;
    double importeTotal=0;
    String tipoCombustible;



    public int getVentas() {
        return ventas;
    }

    public double getLitrosTotales() {
        return litrosTotales;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }
}


public class AnalizadorVentasSurtidores {
    public static void main(String[] args) {
        Venta[] ventas = {
                new Venta(1, 35.5, 1.52, 8),
                new Venta(2, 50.0, 1.52, 8),
                new Venta(1, 42.3, 1.55, 10),
                new Venta(3, 90.5, 1.50, 11),   // anomalía
                new Venta(2, 25.8, 1.55, 11),
                new Venta(1, 60.0, 1.55, 13),
                new Venta(3, 48.2, 1.58, 14),
                new Venta(2, 120.0, 1.58, 15),  // anomalía
                new Venta(1, 30.5, 1.60, 18),
                new Venta(3, 55.0, 1.60, 18),
                new Venta(2, 40.0, 1.60, 20),
                new Venta(1, 85.3, 1.60, 22)    // anomalía
        };

        double importeTotal = 0;
        Venta ventaMayor = ventas[0];
        int cantidadSospechosas = 0;
        double[] litrosPorHora = new double[24];
        ResumenSurtidor[] resumen = new ResumenSurtidor[4];


        for (int i = 0; i < resumen.length; i++) {
            resumen[i] = new ResumenSurtidor();
            resumen[i].numSurtidor = i;
        }

        for (int i = 0; i < ventas.length; i++) {
            Venta v = ventas[i];
            double importe = v.getLitros() * v.getPrecioLitro();
            double importeMayor = ventaMayor.getLitros() * ventaMayor.getPrecioLitro();
            importeTotal = importeTotal + importe;

            if (importe > importeMayor) {
                ventaMayor = v;

            }
            //Cantidad sospechosas
            if (ventas[i].getLitros() > 80) {
                cantidadSospechosas++;
                System.out.println("Anomalía :Surtidor " + ventas[i].getSurtidor() + ", hora: " + ventas[i].getHora() + "litros :" + ventas[i].getLitros());
            }

            //Franja horaria con mas ventas
            int hora = v.getHora();
            litrosPorHora[hora] = litrosPorHora[hora] + v.getLitros();

            //Surtidor
            int s = v.getSurtidor();
            resumen[s].numeroVentas++;
            resumen[s].litrosTotales += v.getLitros();
            resumen[s].importeTotalS += importe;

        }

        int horaMaxima = 0;
        double litrosMaximos = litrosPorHora[0];
        for (int h = 1; h < 24; h++) {
            if (litrosPorHora[h] > litrosMaximos) {
                litrosMaximos = litrosPorHora[h];
                horaMaxima = h;
            }
        }
        // después del bucle de ventas, con todos los totales ya completos
        ResumenSurtidor surtidorMayor = resumen[1];
        for (int s = 2; s < resumen.length; s++) {
            if (resumen[s].importeTotalS > surtidorMayor.importeTotalS) {
                surtidorMayor = resumen[s];
            }
        }


        System.out.println("Importe total: " + importeTotal + " €");
        System.out.println("logica.Venta mayor: -Surtidor= "
                + ventaMayor.getSurtidor() + ",-Litros:"
                + ventaMayor.getLitros() +
                ", -Importe:" + (ventaMayor.getLitros() * ventaMayor.getPrecioLitro()) + " €");
        System.out.println("Numero total de ventas:" + ventas.length);
        System.out.println("Hora con mas litros vendidos:" + horaMaxima + " horas con " + litrosMaximos + " vendidos");
        System.out.println("Ventas sospechosas :" + cantidadSospechosas);

        for (int i = 1; i < resumen.length; i++) {
            System.out.println("Surtidor " + i + ": "
                    + resumen[i].numeroVentas + " ventas,"
                    + String.format("%.2f", resumen[i].litrosTotales) + " litros totales, "
                    + String.format("%.2f", resumen[i].importeTotalS) + "€");

            if (resumen[i].numeroVentas > 0) {
                double promedio = resumen[i].litrosTotales / resumen[i].numeroVentas;
                System.out.println("   Promedio: " + String.format("%.2f", promedio) + " litros por venta");
            }
        }
        System.out.println("El surtidor con mas importe ha sido el surtidor : " + surtidorMayor.numSurtidor
                + " con un importe de " + String.format("%.2f", surtidorMayor.importeTotalS) + " €");


        Venta2[] ventas2 = {
                new Venta2("diesel", 40.0, 62.00),
                new Venta2("gasolina95", 30.0, 48.60),
                new Venta2("diesel", 55.0, 85.25),
                new Venta2("gasolina98", 25.0, 44.75),
                new Venta2("gasolina95", 42.0, 68.04),
                new Venta2("diesel", 38.5, 59.68),
                new Venta2("gasolina98", 20.0, 35.80),
                new Venta2("gasolina95", 35.0, 56.70),
                new Venta2("diesel", 60.0, 93.00),
                new Venta2("gasolina95", 28.0, 45.36)
        };

        ResumenCombustible resumenC[] = new ResumenCombustible[3];
        for (int i =0;i<resumenC.length;i++){
            resumenC[i]=new ResumenCombustible();
            resumenC[i].tipoCombustible=resumenC[i].getTipoCombustible();
        }


        for (int i=0;i<ventas2.length;i++){
            Venta2 v2=ventas2[i];
            int p = posicionDe(v2.getCombustible());
            if (p == -1) {
                System.out.println("AVISO: combustible desconocido: " + v2.getCombustible());
                continue;
            }

            resumenC[p].ventas ++;
            resumenC[p].litrosTotales+= v2.getLitros();
            resumenC[p].importeTotal+= v2.getImporte();

        }
        Venta2 combustibleMasVendido=ventas2[0];
        double precioMedioCombustible = 0;
        for (int i=0;i< resumenC.length;i++){
            if(ventas2[i].importe>combustibleMasVendido.importe){
                combustibleMasVendido=ventas2[i];
            }
        }

        for (int i=0;i<resumenC.length;i++){
            System.out.println("Combustible  " + i + ": "
                    + resumenC[i].ventas + " ventas,"
                    + String.format("%.2f", resumenC[i].litrosTotales) + " litros totales, "
                    + String.format("%.2f", resumenC[i].importeTotal) + "€");

            if(resumenC[i].litrosTotales>0){
                precioMedioCombustible=resumenC[i].importeTotal/resumenC[i].litrosTotales;
            }
            System.out.println("Combustible "+ i + "- Precio promedio :"+precioMedioCombustible + "€");
        }
        System.out.println("El combustible mas vendido ha sido "+combustibleMasVendido.combustible + " con un importe de"
                + combustibleMasVendido.importe + "€");


    }
    static int posicionDe(String combustible) {
        if (combustible.equalsIgnoreCase("diesel")) return 0;
        if (combustible.equalsIgnoreCase("gasolina95")) return 1;
        if (combustible.equalsIgnoreCase("gasolina98")) return 2;
        return -1;   // por si llega algo raro
    }
}










