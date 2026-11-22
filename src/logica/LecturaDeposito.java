package logica;

class Lectura {
    int deposito;
    double nivel;
    int horaLectura;

     public Lectura(int deposito, double nivel, int horaLectura) {
         this.deposito = deposito;
         this.nivel = nivel;
         this.horaLectura = horaLectura;
     }

     public int getDeposito() {
         return deposito;
     }

     public double getNivel() {
         return nivel;
     }

     public int getHoraLectura() {
         return horaLectura;
     }

 }
 class ResumenLectura{
    int numeroLecturas=0;
    double nivelMaximo;
    double nivelMinimo;
    int numeroDeposito;
 }


 public class LecturaDeposito{
     public static void main(String[] args) {
         Lectura[] lecturas = {
                 new Lectura(1, 8500.0, 6),
                 new Lectura(2, 4200.0, 6),
                 new Lectura(3, 1800.0, 6),
                 new Lectura(1, 7200.0, 12),
                 new Lectura(2, 3100.0, 12),
                 new Lectura(3, 950.0, 12),
                 new Lectura(1, 5800.0, 18),
                 new Lectura(2, 2400.0, 18),
                 new Lectura(3, 400.0, 18),
                 new Lectura(1, 4100.0, 22),
                 new Lectura(2, 1900.0, 22),
                 new Lectura(3, 150.0, 22)
         };
         ResumenLectura[] resumenLecturas=new ResumenLectura[4];

         for (int i=0;i< resumenLecturas.length;i++){
             resumenLecturas[i]= new ResumenLectura();
             resumenLecturas[i].numeroDeposito=i;
         }

         for (int i =0; i<lecturas.length; i++){
             Lectura l=lecturas[i];
             int d =l.getDeposito();

             if(resumenLecturas[d].numeroLecturas==0){
                 resumenLecturas[d].nivelMaximo=l.getNivel();
                 resumenLecturas[d].nivelMinimo = l.getNivel();
             }else{
                 if(l.getNivel()>resumenLecturas[d].nivelMaximo) resumenLecturas[d].nivelMaximo =l.getNivel();
                 if (l.getNivel()<resumenLecturas[d].nivelMinimo) resumenLecturas[d].nivelMinimo=l.getNivel();
              }
             resumenLecturas[d].numeroLecturas++;

             if(lecturas[i].getNivel()<500){
                 System.out.println("Alerta : "+lecturas[i].getDeposito()+ " hora : "+ lecturas[i].getHoraLectura()
                         + " solo "+lecturas[i].getNivel()+ " litros");
             }
         }
         for (int i=1;i< resumenLecturas.length;i++){
             System.out.println("Deposito "+ resumenLecturas[i].numeroDeposito+ ": Lecturas : "
                     +resumenLecturas[i].numeroLecturas+ ", Nivel mas alto :"+ resumenLecturas[i].nivelMaximo
                     +" litros , Nivel mas bajo :"+resumenLecturas[i].nivelMinimo+" litros");
         }
         ResumenLectura depositoMasBajo=resumenLecturas[1];
         for(int i=1;i<resumenLecturas.length;i++){
             if(resumenLecturas[i].nivelMinimo< depositoMasBajo.nivelMinimo){
                 depositoMasBajo=resumenLecturas[i];
             }
         }
         System.out.println("El deposito mas bajo de la jornada ha sido "+depositoMasBajo.numeroDeposito
         +" con "+depositoMasBajo.nivelMinimo + " litros");


     }

 }
