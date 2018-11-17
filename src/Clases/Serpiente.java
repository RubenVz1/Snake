
package Clases;

import java.util.ArrayList;


public class Serpiente
{
    private Segmento cabeza;
    private ArrayList<Segmento> cola;

    public Serpiente() {
        cola = new ArrayList<Segmento>();
        cabeza = new Segmento();
        cabeza.setCoordenada_x(50);
        cabeza.setCoordenada_y(50);
        cabeza.setDireccion("derecha");
    }
    
    public Segmento getCabeza() {
        return cabeza;
    }

    public void setCabeza(Segmento cabeza) {
        this.cabeza = cabeza;
    }

    public ArrayList<Segmento> getCola() {
        return cola;
    }

    public void setCola(ArrayList<Segmento> cola) {
        this.cola = cola;
    }
    
    public void imprimir() {
        System.out.print("Cabeza: ");
        cabeza.imprimir();
        for(int i  = 0 ; i < cola.size() ; i++)
        {
            System.out.print("Segmento "+(i+1));
            cola.get(i).imprimir();
        }
        System.out.println();
    }
   
}
