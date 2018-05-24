package practica10;

public class ArbolBB {
    
    /*Elementos del arbol(pueden ser de cualquier tipo)
    para nuestro ejemplo los pondremos Integer.*/
    private class Elemento{
        private Integer i;
        //Constructores
        public Elemento(){}
        public Elemento(Integer i){
            this.i = i;
        }
    }//Elemento
    
    //Nodos del arbol
    private class Nodo{
        //Estructura de un Nodo
        /**************************/
        /* Nodo * Elemento * Nodo */
        /**************************/
        
        /*Los nodos son de tipo ArbolBB porque
        vamos a hacer operaciones con ellos por
        lo tanto necesitamos que sea asi.*/
        private ArbolBB hder;
        private ArbolBB hizq;
        private Elemento e;
        
        private Nodo(){
            e = null;
            hder = hizq = null;
        }
        private Nodo(Elemento e){
            this.e = e;
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
    
    public void insertar(Elemento e){
        if(esVacio()){
            Nodo aux = new Nodo(e);
            aux.hizq = new ArbolBB();
            aux.hder = new ArbolBB();
            raiz = aux;
        }else{
            if(e.i < raiz.e.i){
                raiz.hizq.insertar(e); 
            }else{
                raiz.hder.insertar(e);
            }
        }
    }
    
    public ArbolBB buscar(Elemento e){
        ArbolBB aux = null;
        if(!esVacio()){
            if(e.i == raiz.e.i){
            return this;
            }else{
                if(e.i < raiz.e.i){
                    aux = raiz.hizq.buscar(e);
                }else{
                    aux = raiz.hder.buscar(e);
                }
            }
        }
        return aux;
    } 
    
    public boolean existe(Elemento e){
        if(!esVacio()){
            if(e.i == raiz.e.i){
            return true;
            }else{
                if(e.i < raiz.e.i){
                    raiz.hizq.existe(e);
                }else{
                    raiz.hder.existe(e);
                }
            }
        }
        return false;
    }
}//ArbolBB
