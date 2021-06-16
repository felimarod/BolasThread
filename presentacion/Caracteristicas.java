package presentacion;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import logica.Bola;

/**
 *
 * @author felipe
 * 
 */
public class Caracteristicas extends javax.swing.JFrame {
    
    private final Controlador controlador;
    private final Bola bola;
    
    public Caracteristicas(Bola bola, Controlador control) {
        this.bola = bola;
        controlador = control;
        
        setTitle(bola.getName());
        bola.setSelected(true);
        
        initComponents();
        
        try {
            addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosing(WindowEvent e){
                    bola.setSelected(false);
                    dispose();
                }
            });
        } catch (Exception e) {
        }
        
        agregarControlador();
    }
    
    
    public Bola getBola() {
        return bola;
    }

    public JButton getJbMostrarNombre() {
        return jbMostrarNombre;
    }

    public JButton getJbMovimiento() {
        return jbMovimiento;
    }

    public JComboBox<String> getJcColor() {
        return jcColor;
    }

    public JComboBox<String> getJcVelocidad() {
        return jcVelocidad;
    }

    public JTextField getJtNombre() {
        return jtNombre;
    }

    public JTextField getJtSize() {
        return jtSize;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jcColor = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jcVelocidad = new javax.swing.JComboBox<>();
        jbMovimiento = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jtNombre = new javax.swing.JTextField();
        jbMostrarNombre = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jtSize = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(50, 50));
        setSize(new java.awt.Dimension(200, 200));

        jLabel1.setText("Color");

        jcColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Azul", "Azul claro", "Gris", "Magenta", "Verde", "Naranja", "Rosado", "Rojo", "Amarillo", "Gris claro" }));

        jLabel2.setText("Velocidad");

        jcVelocidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lento", "Normal", "Rapido", "Muy rapido" }));

        jbMovimiento.setText("Detener");

        jLabel3.setText("Nombre");

        jbMostrarNombre.setText("Mostrar nombre");

        jLabel4.setText("Tamaño");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcVelocidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtSize, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbMovimiento, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbMostrarNombre, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcVelocidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbMovimiento)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbMostrarNombre)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jbMostrarNombre;
    private javax.swing.JButton jbMovimiento;
    private javax.swing.JComboBox<String> jcColor;
    private javax.swing.JComboBox<String> jcVelocidad;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtSize;
    // End of variables declaration//GEN-END:variables

    private void agregarControlador() {
        getJbMostrarNombre().addActionListener(controlador);
        getJbMovimiento().addActionListener(controlador);
        
        getJcColor().addActionListener(controlador);
        getJcVelocidad().addActionListener(controlador);
        
        getJtNombre().addKeyListener(controlador);
        getJtSize().addKeyListener(controlador);
    }
}
