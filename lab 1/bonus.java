import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bonus {
    public static void main(String[] args) {


        //System.out.print("Introduceti numarul de noduri in graf: ");
        int numarNoduri = 7;

        int[][] matrice = new int[numarNoduri + 1][numarNoduri + 1];

        for(int i=0;i<numarNoduri;i++) {
            matrice[i][i + 1] = 1;
            matrice[i + 1][i] = 1;
            matrice[i][numarNoduri] = 1;
            matrice[numarNoduri][i]=1;
        }
        matrice[0][numarNoduri-1] = 1;
        matrice[numarNoduri-1][0] = 1;


        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                System.out.print(matrice[i][j] + " ");
            }
            System.out.println();
        }
        int[] listaNoduri=new int[2*numarNoduri+2];
        int countCycles=0;
        for(int i=1;i<numarNoduri;i++)
            listaNoduri[i]=listaNoduri[i+numarNoduri-1]=i;
        for(int i=1;i<=numarNoduri-2;i++)
            for(int j=1;j<=numarNoduri-1;j++){
                System.out.println(listaNoduri[j] +" "+ listaNoduri[j+i]+" "+numarNoduri);
                countCycles++;}
        countCycles++;

        System.out.println(countCycles);
        if(numarNoduri*numarNoduri-3*numarNoduri+3==countCycles)
            System.out.println("Succes");
        else
            System.out.println("Fail");







    }

}
