package Clases;

import java.util.Scanner;
import javax.swing.JFrame;

public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        JFrame aplicacion = new JFrame();
        aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        aplicacion.setSize(798,600);
        Escenario panel = new Escenario();
        aplicacion.add(panel);
        aplicacion.setVisible(true);
        int velocidad = 0;
        int puntuacion = 1;
        while(true)
        {
            aplicacion.add(panel);
            if(velocidad>=100 && (puntuacion%4)==0)
            {
                System.out.println("cambio velocidad: " +velocidad);
                panel.setVelocidad(velocidad);
                velocidad-=100;
            }
            puntuacion = panel.getPuntuacion();
            panel.setVelocidad(velocidad);
            aplicacion.repaint();
            Thread.sleep(velocidad+300);
        }
    }
}
