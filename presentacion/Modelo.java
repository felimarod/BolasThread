package presentacion;

import java.awt.Canvas;
import java.awt.Color;
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
    private final Canvas lienzo; // referenciación al lienzo de la ventana
    private final BufferedImage dobleBuffer;
    
    //Para trabajar la bola actual
    private Caracteristicas ventanaEmergente;
    
    public Modelo() {
        animando = false;
        lienzo = getVentana().getLienzo();
        dobleBuffer = new BufferedImage(lienzo.getWidth(), lienzo.getHeight(), BufferedImage.TYPE_INT_ARGB);
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

    public Caracteristicas getVentanaEmergente() {
        return ventanaEmergente;
    }
    
    // ------ FUNCIONALIDADES DE MI APP
    public void iniciar() {
        getVentana().getBtnAnimar().setText("Iniciar");        
        getVentana().setSize(270, 430);
        getVentana().setVisible(true);
        //getVentana().getBtnAnimar().doClick();
        //getVentana().getCaja().showPopup();
    }   
    
    // ------ para la funcionalidad del dibujo del hilo
    @Override
    public void run() {        
        while (animando) {
            dibujar();
        }
    }
    
    private void dibujar() {        
        Graphics g = lienzo.getGraphics();
        Graphics pincel = dobleBuffer.getGraphics(); // Todo el dibujo se trabaja en el dobleBuffer
        
        pincel.setColor(lienzo.getBackground());
        pincel.fillRect(0, 0, lienzo.getWidth(), lienzo.getHeight());
        for (int i = 0; i < getTablero().getListaBolas().size(); i++) {
            Bola b = (Bola)getTablero().getListaBolas().get(i);
            pincel.setColor(b.getColor());
            pincel.fillOval(b.getPosX(), b.getPosY(), b.getDiametro(), b.getDiametro());
            
            pincel.setColor(Color.white);
            
            if(b.isShowingName())
                pincel.drawString(b.getName(), b.getPosX(), b.getPosY()+b.getDiametro()+20);
            
            if(b.isSelected()) 
                pincel.drawRect(b.getPosX(), b.getPosY(), (b.getDiametro()), (b.getDiametro()));
            
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
                getVentana().setSize(270, 430);                
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
    
    public void crearVentanaBola(int selectedIndex) {
        if(selectedIndex >= getTablero().getNumeroBolas())
            getVentana().getLblMensaje().setText("NO existe la bola");
        else{
            if(ventanaEmergente != null) {
                ventanaEmergente.getBola().setSelected(false);
                ventanaEmergente.dispose();
            }
            
            ventanaEmergente = new Caracteristicas(
                    (Bola)getTablero().getListaBolas().get(selectedIndex), 
                    getVentana().getControl()
            );
            ventanaEmergente.setVisible(true);
            ventanaEmergente.setSize(220,240);
            ventanaEmergente.setLocationRelativeTo(null);
            
            if(ventanaEmergente.getBola().isShowingName())
                ventanaEmergente.getJbMostrarNombre().setText("Ocultar nombre");
            else
                ventanaEmergente.getJbMostrarNombre().setText("Mostrar nombre");  
            
            if(ventanaEmergente.getBola().isMoviendo())
                ventanaEmergente.getJbMovimiento().setText("Detener");
            else
                ventanaEmergente.getJbMovimiento().setText("Simular"); 
        }
    }
    
    public void setMovimientoBola(){
        if(getVentanaEmergente().getBola().isMoviendo()){
            getVentanaEmergente().getBola().setMoviendo(false);
            getVentanaEmergente().getJbMovimiento().setText("Simular");
        }else{
            getVentanaEmergente().getBola().setMoviendo(true);
            getVentanaEmergente().getBola().correr();
            getVentanaEmergente().getJbMovimiento().setText("Detener");
        }
    }

    void setColorBola(String itemAt) {
        switch(itemAt){
            case "Azul":
                getVentanaEmergente().getBola().setColor(Color.BLUE);
                break;
            case "Azul claro":
                getVentanaEmergente().getBola().setColor(Color.CYAN);
                break;
            case "Gris":
                getVentanaEmergente().getBola().setColor(Color.GRAY);
                break;
            case "Verde":
                getVentanaEmergente().getBola().setColor(Color.GREEN);
                break;
            case "Naranja":
                getVentanaEmergente().getBola().setColor(Color.ORANGE);
                break;
            case "Rosado":
                getVentanaEmergente().getBola().setColor(Color.PINK);
                break;   
            case "Rojo":
                getVentanaEmergente().getBola().setColor(Color.RED);
                break;
            case "Amarillo":
                getVentanaEmergente().getBola().setColor(Color.YELLOW);
                break;
            case "Gris claro":
                getVentanaEmergente().getBola().setColor(Color.LIGHT_GRAY);
                break;
            case "Magenta":
                getVentanaEmergente().getBola().setColor(Color.magenta);
                break;
        }
    }

    void setVelocidadBola(String itemAt) {
        int velocidad = 1;
        switch(itemAt){
            case "Lento":
                velocidad = 1;
                break;
            case "Normal":
                velocidad = 2;
                break;
            case "Rapido":
                velocidad = 3;
                break;
            case "Muy rapido":
                velocidad = 4;
                break;
        }
        
        if(getVentanaEmergente().getBola().getDirX() < 0)
            getVentanaEmergente().getBola().setDirX((int)(-1*velocidad));
        else
            getVentanaEmergente().getBola().setDirX(velocidad);
        
        if(getVentanaEmergente().getBola().getDirY() < 0)
            getVentanaEmergente().getBola().setDirY((int)(-1*velocidad));
        else
            getVentanaEmergente().getBola().setDirY(velocidad);
    }

    void setNombreBola() {
        getVentanaEmergente().setTitle(getVentanaEmergente().getJtNombre().getText());
        getVentanaEmergente().getBola().setName(getVentanaEmergente().getJtNombre().getText());
        getVentanaEmergente().getJtNombre().setText("");
    }
    
    void showName(){
        if(!getVentanaEmergente().getBola().isShowingName()){
            getVentanaEmergente().getBola().setShowingName(true);
            getVentanaEmergente().getJbMostrarNombre().setText("Ocultar nombre");
        }else{
            getVentanaEmergente().getBola().setShowingName(false);
            getVentanaEmergente().getJbMostrarNombre().setText("Mostrar nombre");
        }
    }

    void setSizeBola() {
        try {
            int size = Integer.parseInt(getVentanaEmergente().getJtSize().getText());
            getVentanaEmergente().getBola().setDiametro(size);
        } catch (Exception e) {
        }
        
    }
}
