package Clases;

public class Manzana
{
    private int coordenada_x;
    private int coordenada_y;

    public Manzana()
    {
        coordenada_x = (int)(Math.random()*500)+20;
        coordenada_y = (int)(Math.random()*500)+20;
    }
    
    public int getCoordenada_x() {
        return coordenada_x;
    }

    public void setCoordenada_x(int coordenada_x) {
        this.coordenada_x = coordenada_x;
    }

    public int getCoordenada_y() {
        return coordenada_y;
    }

    public void setCoordenada_y(int coordenada_y) {
        this.coordenada_y = coordenada_y;
    }
    
    
}
