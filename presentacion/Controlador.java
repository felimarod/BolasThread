
package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import logica.Bola;


public class Controlador implements ActionListener, KeyListener{

    private final Modelo modelo;
    private final Vista vista;
    private Caracteristicas ventanaEmergente = null;
    private Bola bolaActual;
    
    public Controlador(Vista vista) {
        modelo = vista.getModelo();
        this.vista = vista;
    }

    public Modelo getModelo(){
        return modelo;
    }

    public Vista getVista(){
        return vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //getVista().getLblMensaje().setText("hola");
        if(e.getSource().equals(getVista().getBtnAnimar()))
            getModelo().simular();
        else if(e.getSource().equals(getVista().getCaja())){
            getModelo().crearVentanaBola(getVista().getCaja().getSelectedIndex());
            ventanaEmergente = getModelo().getVentanaEmergente();
        } else if (e.getSource().equals(ventanaEmergente.getJbMovimiento())){
            modelo.setMovimientoBola();
        }else if (e.getSource().equals(ventanaEmergente.getJcColor())){
            getModelo().setColorBola(ventanaEmergente.getJcColor().getItemAt(ventanaEmergente.getJcColor().getSelectedIndex()));
        }else if(e.getSource().equals(ventanaEmergente.getJcVelocidad())){
            getModelo().setVelocidadBola(ventanaEmergente.getJcVelocidad().getItemAt(ventanaEmergente.getJcVelocidad().getSelectedIndex()));
        }else if(e.getSource().equals(ventanaEmergente.getJbMostrarNombre()))
            getModelo().showName();
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if(ke.getSource().equals(ventanaEmergente.getJtNombre()) && ke.getKeyChar() == '\n'){
            getModelo().setNombreBola();
        } else if(ke.getSource().equals(ventanaEmergente.getJtSize()) && ke.getKeyChar() == '\n'){
            getModelo().setSizeBola();
        }
    }
    
    
}
