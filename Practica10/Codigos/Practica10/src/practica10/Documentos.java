package practica10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Documentos {
    
    public static String obtenerTextoDeArchivo(String ruta) throws IOException{
        String cadenaCompletaArchivo = "";
            File f = new File(ruta);
            FileReader fr = null;
        try {
            fr = new FileReader(f);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Documentos.class.getName()).log(Level.SEVERE, null, ex);
        }
            BufferedReader br = new BufferedReader(fr);
            String linea = null;
            while((linea = br.readLine())!= null){
                cadenaCompletaArchivo += linea+"\n";
            }
        return cadenaCompletaArchivo;
    }
    
    public static int[] obtenerFrecuenciasDeCadena(String cadena){
        int [] frecuencia = new int[255];
        //Inicializamos el arreglo en cero
        for(int i= 0;i<frecuencia.length; i++)
            frecuencia[i]=0;
        for(int i=0;i<cadena.length();i++)
            frecuencia[cadena.codePointAt(i)]++;
        return frecuencia;
    }
}
