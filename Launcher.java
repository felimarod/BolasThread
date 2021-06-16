import presentacion.Modelo;

/*
Del ejemplo subido a este portal con respecto a los hilos (Bolitas), modificarlo para que incluya:

Un panel que contendrá un listado de las Bolitas creadas
De ese listado, al seleccionar una Bolita aparecerá una ventana donde se podrá:
Cambiar de tamaño
Cambiar de color
Modificar la velocidad
Detener o reanudar el movimiento de ella
Modificar el nombre
Mostrar u ocultar en nombre en el lienzo
Mostrar en el lienzo si la seleccionamos (ej. un borde más grueso o de otro color...)
*/


public class Launcher{

    private Modelo miApp;

    public Launcher(){
        miApp = new Modelo();
        miApp.iniciar();
    }
    
    
    public static void main(String[] args){
        Launcher mi = new Launcher();
    }
    
}

