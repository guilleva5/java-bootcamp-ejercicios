package logica;

public class AnalizadorNotas {
    public static void main(String[] args) {

        double[] notas = {7.5, 4.0, 8.2, 6.1, 3.5, 9.0, 5.5};
        double notaMasAlta=notas[0];
        double notaMasBaja=notas[0];
        int cantidadprobados=0;
        int cantidadSuspensos=0;
        double sumaNotas=0;
        for (int i=0;i<notas.length;i++){
            if(notas[i]>notaMasAlta){
                notaMasAlta=notas[i];
            }
            if(notas[i]<notaMasBaja){
                notaMasBaja=notas[i];
            }
            sumaNotas=sumaNotas+notas[i];

            if(notas[i]>=5){
                cantidadprobados=cantidadprobados+1;
            }
            else {
                cantidadSuspensos=cantidadSuspensos+1;
            }
        }

        double media=sumaNotas/notas.length;

        System.out.println("La nota mas alta ha sido: "+notaMasAlta+" y la mas baja ha sido:"+notaMasBaja );
        System.out.println("La media de notas: "+media);
        System.out.println("Cantidad aprobados:"+cantidadprobados+" ,cantidad suspensos: "+cantidadSuspensos);


    }
}
