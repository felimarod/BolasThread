package logica;

import java.awt.Color;

public class Bola implements Runnable{

    private String name;
    
    private int posX, posY;
    private int w, h; //limites del lienzo
    private double dirX, dirY;  // -1 decrementa, 1 incrementa
    private Color color;
    private int diametro = 30;
    
    public static Color colores[] = {Color.BLUE, Color.CYAN, Color.GRAY, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW, Color.LIGHT_GRAY};
    private boolean moviendo = true;
    
    private boolean showingName = false;
    private boolean selected = false;

    public Bola(String n, int w, int h) {
        setName(n);        
        this.w = w;
        this.h = h;
        posX = (int) (Math.random() * w);
        if(posX > w - diametro) posX -= diametro;        
        posY = (int) (Math.random() * h);
        if(posY > h - diametro) posY -= diametro;
        color = colores[(int) (Math.random() * 10)];
        dirX = ((Math.random() * 100) < 50 ? 2 : -2);
        dirY = ((Math.random() * 100) < 50 ? 2 : -2);
    }

    public String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
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

    public void setColor(Color color) {
        this.color = color;
    }
    
    public boolean isMoviendo() {
        return moviendo;
    }

    public void setMoviendo(boolean moviendo) {
        this.moviendo = moviendo;
    }

    public double getDirX() {
        return dirX;
    }

    public double getDirY() {
        return dirY;
    }
    
    public void setDirX(double dirX) {
        this.dirX = dirX;
    }

    public void setDirY(double dirY) {
        this.dirY = dirY;
    }

    public boolean isShowingName() {
        return showingName;
    }

    public void setShowingName(boolean showingName) {
        this.showingName = showingName;
    }
    
    // Funcionalidad
    @Override
    public void run() {
        while (moviendo) {
            posX += dirX;
            posY += dirY;
            if (posX + diametro >= w || posX <= 0) {
                dirX *= -1;
            }
            if (posY + diametro >= h || posY <= 0) {
                dirY *= -1;
            }
            esperar(4);
        }
    }
    
    public void correr(){
        moviendo = true;
        new Thread(this).start();
    }
    
    public void esperar(int tiempoMS) {
        try {
            Thread.sleep(tiempoMS);
        } catch (InterruptedException ex) {
        }
    }

    public boolean isSelected() {
        return selected;
    }
    
    public void setSelected(boolean selected){
        this.selected = selected;
    }

    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }

    public int getDiametro() {
        return diametro;
    }

}
