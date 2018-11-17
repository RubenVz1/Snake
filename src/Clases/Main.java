
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
        
        Dibujar panel = new Dibujar();
        
        Serpiente snake = new Serpiente();
        snake.getCola().add(new Segmento());
        snake.getCola().get(0).setCoordenada_x(60);
        snake.getCola().get(0).setCoordenada_y(60);
        snake.imprimir();
        
        panel.setSnake(snake);
        while(true)
        {
            aplicacion.add(panel);
            aplicacion.repaint();
            Thread.sleep(500);
        }
    }
}
