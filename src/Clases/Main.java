package Clases;

import java.util.Scanner;
import javax.swing.JFrame;

public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        JFrame aplicacion = new JFrame("Snake");
        aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        aplicacion.setSize(800,590);
        aplicacion.setResizable(false);
        aplicacion.setLocationRelativeTo(null);
        
        Escenario panel = new Escenario();
        aplicacion.add(panel);
        aplicacion.setVisible(true);
        
        while(true)
        {
            aplicacion.add(panel);
            aplicacion.repaint();
            Thread.sleep(panel.getVelocidad());
        }
    }
}
