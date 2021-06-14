package logica;

import java.awt.Color;

public class Bola extends Thread {

    private int posX, posY;
    private String nombre;
    private int w, h; //limites del lienzo
    private int dirX, dirY;  // -1 decrementa, 1 incrementa
    private Color color;

    public static int diametro = 30;
    public static Color colores[] = {Color.BLUE, Color.CYAN, Color.GRAY, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW, Color.LIGHT_GRAY};
    private boolean moviendo = false;

    public Bola(String n, int w, int h) {
        nombre = n;        
        this.w = w;
        this.h = h;
        posX = (int) (Math.random() * w);
        if(posX > w - diametro) posX -= diametro;        
        posY = (int) (Math.random() * h);
        if(posY > h - diametro) posY -= diametro;
        color = colores[(int) (Math.random() * 10)];
        dirX = ((Math.random() * 100) < 50 ? 1 : -1);
        dirY = ((Math.random() * 100) < 50 ? 1 : -1);
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public Color getColor() {
        return color;
    }

    public boolean isMoviendo() {
        return moviendo;
    }

    public void setMoviendo(boolean moviendo) {
        this.moviendo = moviendo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // Funcionalidad
    public void mover() {
        while (moviendo) {
            posX += dirX;
            posY += dirY;
            if (posX + diametro >= w || posX <= 0) {
                dirX *= -1;
            }
            if (posY + diametro >= h || posY <= 0) {
                dirY *= -1;
            }
            esperar(2);
        }
    }

    @Override
    public void run() {
        moviendo = true;
        mover();
    }

    public void esperar(int tiempoMS) {
        try {
            Thread.sleep(tiempoMS);
        } catch (InterruptedException ex) {
        }
    }

}
