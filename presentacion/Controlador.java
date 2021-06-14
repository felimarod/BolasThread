
package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controlador implements ActionListener{

    private Modelo modelo;
    
    public Controlador(Vista aThis) {
        modelo = aThis.getModelo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        modelo.simular();
    }
    
    
}
