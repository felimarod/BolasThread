package presentacion;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import logica.Bola;
import logica.Sistema;

public final class Modelo implements Runnable {
    
    private Thread hiloDibujo;
    private boolean animando;
    private Vista ventana;
    private Sistema tablero;
    
    // Para evitar parpadeo, utilizaremos doble buffer con:
    private Canvas lienzo; // referenciación al lienzo de la ventana
    private BufferedImage dobleBuffer;
    
    public Modelo() {
        animando = false;
        lienzo = getVentana().getLienzo();
        dobleBuffer = new BufferedImage(lienzo.getWidth(), lienzo.getHeight(), BufferedImage.TYPE_INT_ARGB);
    }

    // ------ FUNCIONALIDADES DE MI APP
    public void iniciar() {
        getVentana().getBtnAnimar().setText("Iniciar");        
        getVentana().setSize(280, 430);
        getVentana().setVisible(true);
    }    
    
    private void dibujar() {        
        Graphics g = lienzo.getGraphics();
        Graphics pincel = dobleBuffer.getGraphics(); // Todo el dibujo se trabaja en el dobleBuffer
        
        pincel.setColor(lienzo.getBackground());
        pincel.fillRect(0, 0, lienzo.getWidth(), lienzo.getHeight());
        for (int i = 0; i < getTablero().getListaBolas().size(); i++) {
            Bola b = (Bola)getTablero().getListaBolas().get(i);
            pincel.setColor(b.getColor());
            pincel.fillOval(b.getPosX(), b.getPosY(), Bola.diametro, Bola.diametro);   
            //System.out.println(b.getNombre() + " x: " + b.getPosX() + ", y: " + b.getPosY());
        }
        g.drawImage(dobleBuffer, 0, 0, lienzo); // Por último este dibujo se muestra en el lienzo
    }
    
    public void simular() {
        getVentana().getLblMensaje().setText("");
        try {
            if (animando) {                
                animando = false;                
                hiloDibujo = null;                
                getVentana().getBtnAnimar().setText("Iniciar");
                getVentana().getSliBolitas().setEnabled(true);                
                getVentana().setSize(280, 430);                
                getTablero().detenerSimulacion();
            } else {                
                animando = true;
                getVentana().getBtnAnimar().setText("Detener");                
                getVentana().getSliBolitas().setEnabled(false);
                getVentana().setSize(1090, 610);
                getTablero().setNumeroBolas(getVentana().getSliBolitas().getValue());
                getTablero().setEspacio(getVentana().getLienzo().getSize());
                getTablero().iniciarSimulacion();
                hiloDibujo = new Thread(this);
                hiloDibujo.start();                
            }
        } catch (Exception ex) {            
            getVentana().getLblMensaje().setText(ex.getMessage());
        }
    }

    // ------ para la funcionalidad del dibujo del hilo
    @Override
    public void run() {        
        while (animando) {
            dibujar();
        }
    }
    
    public Vista getVentana() {
        if (ventana == null) {
            ventana = new Vista(this);
        }
        return ventana;
    }
    
    public Sistema getTablero() {
        if (tablero == null) {
            tablero = new Sistema();
        }
        return tablero;
    }
    
}
