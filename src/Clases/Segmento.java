package Clases;

public class Segmento
{
    private int coordenada_x;
    private int coordenada_y;
    private String direccion;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
    
    public void imprimir() {
        System.out.print(" X: "+this.coordenada_x+" Y: "+this.coordenada_y+" ");
    }
     
}
