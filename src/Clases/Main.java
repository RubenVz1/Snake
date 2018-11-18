package Clases;

import java.util.Scanner;
import javax.swing.JFrame;

public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        JFrame aplicacion = new JFrame();
        aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        aplicacion.setSize( 800, 600 );
        Escenario panel = new Escenario();
        aplicacion.add(panel);
        aplicacion.setVisible(true);
        while(true)
        {
            int x = (int)(Math.random()*540)+20;
            if(x<=20 || x>=560)
            {
                System.out.println("x: "+x);
            }
            aplicacion.add(panel);
            aplicacion.repaint();
            Thread.sleep(100);
        }
    }
}
