
package logica;

import java.awt.Dimension;
import java.util.ArrayList;


public class Sistema {
    
    private int numeroBolas;
    private ArrayList<Bola> listaBolas;
    private int ancho, alto;

    public Sistema() {
        numeroBolas = 0;
        listaBolas = null;
        ancho = 100;
        alto = 100;
    }
    
    public void iniciarSimulacion() throws Exception{
        crearBolas();
        for (int i = 0; i < listaBolas.size(); i++) {
            Bola b = listaBolas.get(i);
            b.correr();
        }
    }  
    
    private void crearBolas() throws Exception{
        if (numeroBolas == 0) {
            throw new Exception("No hay bolas!");
        }
        listaBolas = new ArrayList<Bola>();
        
        for (int i = 0; i < numeroBolas; i++) {
            Bola b = new Bola("Bola " + (i+1), ancho, alto);            
            listaBolas.add(b);            
        }        
    }
    
    public void detenerSimulacion() throws Exception{
        if (numeroBolas == 0) {
            throw new Exception("No hay nada que detener");
        }
        for (int i = 0; i < listaBolas.size(); i++) {
            Bola b = listaBolas.get(i);
            b.setMoviendo(false);  // Forzamos la finalización del hilo
        }
        listaBolas = null;
    }
    
    public int getNumeroBolas() {
        return numeroBolas;
    }

    public void setNumeroBolas(int numeroBolas) {
        this.numeroBolas = numeroBolas;
    }

    public ArrayList<Bola> getListaBolas() {
        return listaBolas;
    }

    public void setListaBolas(ArrayList<Bola> listaBolas) {
        this.listaBolas = listaBolas;
    }

    public void setEspacio(Dimension size) {
        ancho = size.width;
        alto = size.height;
    }
 
    
}
