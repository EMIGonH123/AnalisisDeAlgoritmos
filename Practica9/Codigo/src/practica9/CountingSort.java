package practica9;

import java.util.Random;
import java.util.Scanner;

public class CountingSort {
    /*****************/
    /* Counting Sort */
    /*****************/
    
    public static int BuscaMayorCountingSort(int A[]){
        int mayor = 0;
        for( int i=0; i<A.length ;i++){
            if(A[i] > mayor){
                mayor = A[i];
            }else{continue;}
        }
        return mayor;
    }
    
    public static void CountingSort(int A[], int B[], int k){
        int C[] = new int[k+1];
        for(int i =0; i<= k ; i++){
            C[i] =0;
        }
        for(int j = 1; j< A.length; j++){
            C[A[j]] = (C[A[j]]) +1;
        }
        for(int i = 1; i <= k ; i++){
            C[i] = C[i] + C[i-1];
        }
        for(int j = (A.length)-1 ; j>=1 ; j--){
            B[C[A[j]]] = A[j];
            C[A[j]] = (C[A[j]])-1; 
        }
        
        System.out.println("Arreglo Ordenado");
        for(int l = 1; l<B.length; l++){
            System.out.print(B[l]+" ");
        }    
    }
    

    
}
