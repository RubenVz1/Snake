package Clases;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Dibujar extends JPanel
{
    private Serpiente snake;

    public Serpiente getSnake() {
        return snake;
    }

    public void setSnake(Serpiente snake) {
        this.snake = snake;
    }
    
    public void paintComponent( Graphics g )
    { 
        int coordenada_x,coordenada_y;
        super.paintComponent( g );
        g.setColor(new Color(.9f, .5f, .5f));
        for(int i = 0; i < snake.getCola().size();i++)
        {
            coordenada_x = snake.getCola().get(i).getCoordenada_x();
            coordenada_y = snake.getCola().get(i).getCoordenada_y();
            g.fillOval(coordenada_x,coordenada_y,20,20);
            g.setColor(Color.black);
            g.drawOval(coordenada_x,coordenada_y,20,20);
        }
    } 
} 

