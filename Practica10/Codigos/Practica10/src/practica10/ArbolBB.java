package practica10;

import java.util.Random;
import java.util.Scanner;

public class ArbolBB {
    
    /*Elementos del arbol(pueden ser de cualquier tipo)
    para nuestro ejemplo los pondremos Integer.*/
    /*public class Elemento{
        private Integer i;
        //Constructores
        public Elemento(){}
        public Elemento(Integer i){
            this.i = i;
        }
    }*///Elemento
    
    //Nodos del arbol
    public class Nodo{
        //Estructura de un Nodo
        /**************************/
        /* Nodo * Elemento * Nodo */
        /**************************/
        
        /*Los nodos son de tipo ArbolBB porque
        vamos a hacer operaciones con ellos por
        lo tanto necesitamos que sea asi.*/
        private ArbolBB hder;
        private ArbolBB hizq;
        //private Elemento e;
        private int e;
        private Nodo(){
            //e = null;
            e=0;
            hder = hizq = null;
        }
        public Nodo(int e){
            e=0;
            hder = hizq = null;
        }
        
    }//Nodo
    
    public Nodo raiz;
    
    //Constructor del ABB
    public ArbolBB(){
        raiz = new Nodo();
    }
    
    public boolean esVacio(){
        return (raiz == null);
    }
    
    public void insertar(int e){
        if(esVacio()){
            Nodo aux = new Nodo();
            aux.e = e;
            aux.hizq = new ArbolBB();
            aux.hder = new ArbolBB();
            raiz = aux;
        }else{
            if(e < raiz.e){
                (raiz.hizq).insertar(e); 
            }else if(e > raiz.e){
                (raiz.hder).insertar(e);
            }
        }
    }
    
    public ArbolBB buscar(int e){
        ArbolBB aux = null;
        if(!esVacio()){
            if(e == raiz.e){
            return this;
            }else{
                if(e < raiz.e){
                    aux = raiz.hizq.buscar(e);
                }else{
                    aux = raiz.hder.buscar(e);
                }
            }
        }
        return aux;
    } 
    
    public boolean existe(int e){
        if(!esVacio()){
            if(e == raiz.e){
            return true;
            }else{
                if(e < raiz.e){
                    raiz.hizq.existe(e);
                }else{
                    raiz.hder.existe(e);
                }
            }
        }
        return false;
    }
    public boolean esHoja(){
        if(raiz.hizq.esVacio() && raiz.hder.esVacio())
            return true;
        return false;
    }
    
    public void preOrden(){
        if(!esVacio()){
            System.out.println(raiz.e+", ");
            raiz.hizq.preOrden();
            raiz.hder.preOrden();
        }
    }
    
    public void inOrden(){
        if(!esVacio()){
            raiz.hizq.inOrden();
            System.out.println(raiz.e+", ");
            raiz.hder.inOrden();
        }
    }
    public void postOrden(){
        if(!esVacio()){
            raiz.hizq.postOrden();
            raiz.hder.postOrden();
            System.out.println(raiz.e+", ");
        }
    }
    
    public void eliminar(int e){}
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
        
        a.preOrden();
        a.inOrden();
        a.postOrden();
        
    }
}//ArbolBB
