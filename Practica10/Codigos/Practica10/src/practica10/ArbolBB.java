package practica10;

import java.util.Random;
import java.util.Scanner;

public class ArbolBB {

    public static void main(String[] args){
        ArbolBB a = new ArbolBB();
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        System.out.println("Tam arreglo: ");
        int tam = s.nextInt();
        int [] arr = new int[tam];
        for(int i =0; i<tam;i++){
            System.out.print("Valor["+(i+1)+"]=");
            arr[i] = s.nextInt();
            System.out.println();
            a.insertar(arr[i]);
        }
        
        a.preOrder();
        System.out.println();
        a.inOrder();
        System.out.println();
        a.posOrder();
        
    }
    
    private class Nodo{
        private ArbolBB hd;
        private ArbolBB hi;
        private int dato;
        
        private Nodo(){
            hd = null;
            hi = null;
            dato = 0;
        }
    }

    public Nodo raiz;

    public void abb(){
        Nodo raiz = new Nodo();
    }

    public boolean esVacio(){
        return (raiz == null);
    }

    public void insertar(int a){
        if(esVacio()){
            Nodo nuevo = new Nodo();
            nuevo.dato = a;
            nuevo.hd = new ArbolBB();
            nuevo.hi = new ArbolBB();
            raiz = nuevo;
        }else{
            if(a > raiz.dato) {
                (raiz.hd).insertar(a);
            }
            if(a < raiz.dato){
                (raiz.hi).insertar(a);
            }
        }
    }

    public void preOrder(){
        if (!esVacio()) {
            System.out.print( raiz.dato + ", "  );
            raiz.hi.preOrder();
            raiz.hd.preOrder();
        }
    }

    public void inOrder(){
        if (!esVacio()) {
            raiz.hi.inOrder();
            System.out.print( raiz.dato + ", "  );
            raiz.hd.inOrder();
        }
    }

    public void posOrder(){
        if (!esVacio()) {
            raiz.hd.posOrder();
            raiz.hi.posOrder();
            System.out.print( raiz.dato + ", "  );
        }
    }

    public ArbolBB buscar(int a){
        ArbolBB aux = null;
        if(!esVacio()){
            if(a == raiz.dato){
            return this;
            }else{
                if (a < raiz.dato){
                    aux = raiz.hi.buscar(a);
                }else{
                    aux = raiz.hd.buscar(a);
                }
            }
        }
        return aux;
    }

    public boolean existe(int a){
        if (!esVacio()) {
            if (a == raiz.dato) {
                return true;
            }
            else {
                if (a < raiz.dato) {
                    raiz.hi.existe(a);
                }else {
                    raiz.hd.existe(a);
                }
            }
        }
        return false;
    }

    public int cantidad(){
        if (esVacio()) {
            return 0;
        }else {
            return (1 + raiz.hd.cantidad() + raiz.hi.cantidad());
        }
    }

    public int altura() {
        if (esVacio()) {
            return 0;
        }else {
            return (1 + Math.max(((raiz.hi).altura()), ((raiz.hd).altura())));
        }
    }

    public boolean esHoja() {
        if( (raiz.hi).esVacio() && (raiz.hd).esVacio() )
            return true;
        return false;
    }

}//ArbolBB
