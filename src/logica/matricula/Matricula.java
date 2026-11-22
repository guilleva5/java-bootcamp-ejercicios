package logica.matricula;
import java.util.HashMap;

class Repostaje{
    String matricula;
    String combustible;
    double litros;

    public Repostaje(String matricula, String combustible, double litros) {
        this.matricula = matricula;
        this.combustible = combustible;
        this.litros = litros;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getCombustible() {
        return combustible;
    }

    public double getLitros() {
        return litros;
    }
}

class ResumenRepostaje{
    String matricula;
    int numeroRepostajes;
    double litrosTotales;
    double repostajeMayor;

    public ResumenRepostaje(Repostaje primero) {
        this.matricula=primero.getMatricula();
        this.numeroRepostajes = 1;
        this.litrosTotales = primero.getLitros();
        this.repostajeMayor = primero.getLitros();
    }
}
public class Matricula {
    public static void main(String[] args) {

        Repostaje[] repostajes = {
                new Repostaje("1234ABC", "Diesel", 45.0),
                new Repostaje("5678DEF", "Gasolina95", 30.5),
                new Repostaje("1234ABC", "Diesel", 60.0),
                new Repostaje("9012GHI", "Diesel", 85.0),
                new Repostaje("5678DEF", "Gasolina95", 25.0),
                new Repostaje("1234ABC", "Diesel", 20.0),
                new Repostaje("9012GHI", "Diesel", 90.5),
                new Repostaje("3456JKL", "Gasolina98", 40.0),
                new Repostaje("5678DEF", "Gasolina95", 35.0),
                new Repostaje("3456JKL", "Gasolina98", 15.5)
        };

        HashMap<String,ResumenRepostaje> mapa =new HashMap<>();
        for (Repostaje r :repostajes){
            String m=r.getMatricula();

            if(!mapa.containsKey(m)){
                mapa.put(m,new ResumenRepostaje(r));
            }else{
                ResumenRepostaje res=mapa.get(m);
                res.numeroRepostajes++;
                res.litrosTotales+= r.getLitros();
                if (r.getLitros()>res.repostajeMayor){
                    res.repostajeMayor=r.getLitros();
                }

            }
            if(r.getLitros()>80){
                System.out.println("Aviso : "+m + " ha echado "+r.getLitros()+" litros");
            }
        }

        for(ResumenRepostaje res :mapa.values()){
            System.out.println(res.matricula+ " ->" + res.numeroRepostajes
                    +" repostajes , "+ res.litrosTotales+ " Litros , maximo: "+res.repostajeMayor);
        }

        ResumenRepostaje mejor= null;
        for (ResumenRepostaje res: mapa.values()){
            if (mejor==null || mejor.litrosTotales<res.litrosTotales){
                mejor=res;
            }
        }
        System.out.println("Más litros: " + mejor.matricula + " con " + mejor.litrosTotales + " L");




    }
}

