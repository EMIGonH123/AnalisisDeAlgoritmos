package practica10;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;
import static practica10.Documentos.*;
public class Practica10 {

    public static void main(String[] args) throws IOException{
        System.out.println("<-------------------------->");
        System.out.println("<-- ALGORITMO DE HUFFMAN -->");
        System.out.println("<-------------------------->");
        System.out.println("<- Bienvenidos al sistema ->");
        System.out.println("<-------------------------->");
        Scanner scan = new Scanner(System.in);
        System.out.println("Dame La Ruta Del Archivo: ");
        String ruta =  (String)scan.nextLine();
        String contenidoArchivo = obtenerTextoDeArchivo(ruta);
        int [] frecuencia = obtenerFrecuenciasDeCadena(contenidoArchivo);
        Hashtable<String,Integer> ht = new Hashtable<String, Integer>();
        for(int i=0; i<frecuencia.length;i++){
            if(frecuencia[i] != 0){
                String letra = Character.toString((char)i);
                ht.put(letra, (Integer)frecuencia[i]);
            }
        }
        Enumeration<String> k = ht.keys();
        Enumeration<Integer> v = ht.elements();
        //C:\Users\Alumno\Desktop\texto.txt
        //C:\Users\metal\OneDrive\Desktop\Practica10\texto.txt
        
        while( k.hasMoreElements() ){
            char c[] = k.nextElement().toCharArray();
            System.out.println(c[0]+" : "+v.nextElement());
        }
        
    }
}
