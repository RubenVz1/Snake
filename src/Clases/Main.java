
package Clases;

import javax.swing.JFrame;

public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        JFrame aplicacion = new JFrame();
        aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        aplicacion.setSize( 350, 350 );
        aplicacion.setVisible(true);
        
        //Serpiente snake = new Serpiente(150,150,"derecha");
        //Serpiente snake = new Serpiente(150,150,"izquierda");
        //Serpiente snake = new Serpiente(150,150,"arriba");
        Serpiente snake = new Serpiente(150,150,"abajo");
 
        Dibujar panel = new Dibujar();
        while(true)
        {
            snake.avanzar();
            //snake.agregar();
            panel.setSnake(snake);
            aplicacion.add(panel);
            aplicacion.repaint();
            Thread.sleep(1000);
        }
    }
}
