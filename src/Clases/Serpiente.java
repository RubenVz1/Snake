package Clases;

import java.util.ArrayList;

public class Serpiente
{
    private ArrayList<Segmento> cola;

    public Serpiente(int x,int y,String direccion)
    {
        cola = new ArrayList<Segmento>();
        cola.add(new Segmento());
        cola.get(0).setCoordenada_x(x);
        cola.get(0).setCoordenada_y(y);
        cola.get(0).setDireccion(direccion);
        this.agregar();
        this.agregar();
    }
    
    public void agregar()
    {
        int coordenada_x = cola.get(cola.size()-1).getCoordenada_x();
        int coordenada_y = cola.get(cola.size()-1).getCoordenada_y();
        String direccion = cola.get(cola.size()-1).getDireccion();
                
        switch(direccion)
        {
            case "derecha":
                cola.add(new Segmento());
                cola.get(cola.size()-1).setCoordenada_x(coordenada_x-20);
                cola.get(cola.size()-1).setCoordenada_y(coordenada_y);
                cola.get(cola.size()-1).setDireccion(direccion);
            break;
            case "izquierda":
                cola.add(new Segmento());
                cola.get(cola.size()-1).setCoordenada_x(coordenada_x+20);
                cola.get(cola.size()-1).setCoordenada_y(coordenada_y);
                cola.get(cola.size()-1).setDireccion(direccion);
            break;
            case "arriba":
                cola.add(new Segmento());
                cola.get(cola.size()-1).setCoordenada_x(coordenada_x);
                cola.get(cola.size()-1).setCoordenada_y(coordenada_y+20);
                cola.get(cola.size()-1).setDireccion(direccion);
            break;
            case "abajo":
                cola.add(new Segmento());
                cola.get(cola.size()-1).setCoordenada_x(coordenada_x);
                cola.get(cola.size()-1).setCoordenada_y(coordenada_y-20);
                cola.get(cola.size()-1).setDireccion(direccion);
            break;
        }
    }
    
    
    public boolean avanzar()
    {
        int coordenada_x = cola.get(0).getCoordenada_x();
        int coordenada_y = cola.get(0).getCoordenada_y();
        String direccion = cola.get(0).getDireccion();
        
        if(coordenada_x >= 531 || coordenada_x <= 9)
            return false;
        if(coordenada_y >= 531 || coordenada_y <= 9)
            return false;
        
        int coordenada_x_aux;
        int coordenada_y_aux;
        for(int i = 1 ; i < cola.size()-1 ; i++)
        {
            coordenada_x_aux = cola.get(i).getCoordenada_x();
            coordenada_y_aux = cola.get(i).getCoordenada_y();
            if(coordenada_x ==  coordenada_x_aux && coordenada_y == coordenada_y_aux)
                return false;
        }
        
        switch(direccion)
        {
            case "derecha":
                cola.add(0,new Segmento());
                cola.get(0).setCoordenada_x(coordenada_x+20);
                cola.get(0).setCoordenada_y(coordenada_y);
                cola.get(0).setDireccion(direccion);
            break;
            case "izquierda":
                cola.add(0,new Segmento());
                cola.get(0).setCoordenada_x(coordenada_x-20);
                cola.get(0).setCoordenada_y(coordenada_y);
                cola.get(0).setDireccion(direccion);
            break;
            case "arriba":
                cola.add(0,new Segmento());
                cola.get(0).setCoordenada_x(coordenada_x);
                cola.get(0).setCoordenada_y(coordenada_y-20);
                cola.get(0).setDireccion(direccion);
            break;
            case "abajo":
                cola.add(0,new Segmento());
                cola.get(0).setCoordenada_x(coordenada_x);
                cola.get(0).setCoordenada_y(coordenada_y+20);
                cola.get(0).setDireccion(direccion);
            break;
        }
        cola.remove(cola.size()-1);
        return true;
    }
    
    public void direccion(String direccion)
    {
        String direccion_actual = cola.get(0).getDireccion();
        if(direccion_actual == "derecha" && direccion != "izquierda")
            cola.get(0).setDireccion(direccion);
        if(direccion_actual == "izquierda" && direccion != "derecha")
            cola.get(0).setDireccion(direccion);
        if(direccion_actual == "arriba" && direccion != "abajo")
            cola.get(0).setDireccion(direccion);
        if(direccion_actual == "abajo" && direccion != "arriba")
            cola.get(0).setDireccion(direccion);
    }
    
    public ArrayList<Segmento> getCola() {
        return cola;
    }

    public void setCola(ArrayList<Segmento> cola) {
        this.cola = cola;
    }
    
    public void imprimir() {
        for(int i  = 0 ; i < cola.size() ; i++)
        {
            System.out.print("Segmento "+(i+1));
            cola.get(i).imprimir();
        }
        System.out.println();
    }
    
}
