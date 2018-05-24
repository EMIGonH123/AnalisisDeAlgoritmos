package practica9;

import java.util.Random;
import java.util.Scanner;
import static practica9.CountingSort.*;
import static practica9.RadixSort.*;
import static practica9.HeapSort.*;


public class Practica9{
    
    public static int[] GenerarArreglo(int tam){
        Random r = new Random();
        int A[] = new int[tam];
        for(int i=0; i<tam; i++){
            A[i] = r.nextInt(tam);
        }
        return A;
    }
    
    public static int[] GenerarArregloCS(int tam){
        Random r = new Random();
        int A[] = new int[tam+1];
        for(int i=0; i<=tam; i++){
            A[i] = r.nextInt(tam);
        }
        return A;
    }
    
    public static void printCS(int arr[], int n){
        for (int i=1; i<=n; i++)
            System.out.print(arr[i]+" ");
    }
    
    public static void print(int arr[], int n){
        for (int i=0; i<n; i++)
            System.out.print(arr[i]+" ");
    }
    
    public static void menu(){
        Scanner scan = new Scanner(System.in);
        int valor;
        int tam;
        do {
            System.out.println("<----------------------------->");
            System.out.println("<--- BIENVENIDO AL SISTEMA --->");
            System.out.println("<----------------------------->");            
            System.out.println("<------Elija El Algoritmo----->");
            System.out.println("<----------------------------->");
            System.out.println("Counting sort---------------(1)");
            System.out.println("Radix sort------------------(2)");
            System.out.println("Heap sort-----------------(3)");
            valor = scan.nextInt();
        } while (valor <1 || valor > 3);
        switch(valor){
            case 1:
                System.out.println("<--------------------->");
                System.out.println("<--- Counting Sort --->");
                System.out.println("<--------------------->");
                System.out.println("Tamaño Del Arreglo: ");
                tam = scan.nextInt();
                int A[] = GenerarArregloCS(tam);
                int B[] = new int[tam+1];
                int mayor = BuscaMayorCountingSort(A);
                System.out.println("Arreglo Desordenado");
                printCS(A, tam);
                System.out.println("\nValor mas grande del arreglo es: "+mayor);
                CountingSort(A, B, mayor);
            break;
            case 2:
                System.out.println("<------------------>");
                System.out.println("<--- Radix Sort --->");
                System.out.println("<------------------>");
                System.out.println("Tamaño Del Arreglo: ");
                tam = scan.nextInt();
                int C[] = GenerarArreglo(tam);
                System.out.println("Arreglo Desordenado");
                print(C, tam);
                radixsort(C, tam);
                System.out.println("\nArreglo Ordenado");
                print(C, tam);
            break;
            case 3:
                System.out.println("<----------------->");
                System.out.println("<--- Heap Sort --->");
                System.out.println("<----------------->");
                System.out.println("Tamaño Del Arreglo: ");
                tam = scan.nextInt();
                int D[] = GenerarArreglo(tam);
                System.out.println("Arreglo Desordenado");
                print(D, tam);
                sort(D);
                System.out.println("Arreglo Ordenado");
                print(D, tam);
            break;
        }
    }
    
    public static void main(String[] args){
        menu();
    }
    
}
