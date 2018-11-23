package Clases;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class Escenario extends javax.swing.JPanel implements KeyListener
{

    private Serpiente snake;
    private Manzana manzana;
    private int puntuacion;
    private int velocidad;
    
    public Escenario()
    {
        initComponents();
        juegoNuevo();
        addKeyListener(this);
        setFocusable(true);
    }
    
    public Serpiente getSnake() {
        return snake;
    }

    public void setSnake(Serpiente snake) {
        this.snake = snake;
    }
    
    public Manzana getManzana() {
        return manzana;
    }

    public void setManzana(Manzana manzana) {
        this.manzana = manzana;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
        jLabel_Puntuacion.setText(""+(puntuacion-1));
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
        jLabel_Velocidad.setText(""+(90-velocidad));
    }
    
    public void juegoNuevo()
    {
        snake = new Serpiente(150,270,"derecha");
        manzana = new Manzana();
        setPuntuacion(1);
        setVelocidad(90);
        jLabel_Perder.setVisible(false);
        jLabel_ganar.setVisible(false);
        jLabel_Enter.setVisible(false);
    }
    
    public void dibujarContorno(Graphics g)
    {     
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 565, 10);
        g.fillRect(0, 0, 10, 580);
        g.fillRect(551, 0, 10, 565);
        g.fillRect(0, 551, 560, 10);
    }
    
    public void dibujarSerpiente(Graphics g)
    {   
        int coordenada_x;
        int coordenada_y;
        g.setColor(new Color(34, 177, 76));
        for(int i = 0; i < snake.getCola().size();i++)
        {
            coordenada_x = snake.getCola().get(i).getCoordenada_x();
            coordenada_y = snake.getCola().get(i).getCoordenada_y();
            g.fillOval(coordenada_x,coordenada_y,20,20);
            g.setColor(new Color(77, 221, 120));
            g.drawOval(coordenada_x,coordenada_y,20,20);
        }
    }
    
    public void dibujarManzana(Graphics g)
    {   
        int coordenada_x = manzana.getCoordenada_x();
        int coordenada_y = manzana.getCoordenada_y();
        g.setColor(Color.GREEN);
        g.fillOval(coordenada_x+7,coordenada_y-7,13,8);
        g.setColor(Color.RED);
        g.fillOval(coordenada_x,coordenada_y,20,20);
        g.setColor(Color.BLACK);
        g.drawOval(coordenada_x,coordenada_y,20,20);
    }
    
    public void colision()
    {
        jLabel_Perder.setVisible(true);
        jLabel_Enter.setVisible(true);
    }
    
    public void colisionManzana()
    {
        int coordenada_x_1 = snake.getCola().get(0).getCoordenada_x();
        int coordenada_y_1 = snake.getCola().get(0).getCoordenada_y();
        int coordenada_x_2 = manzana.getCoordenada_x();
        int coordenada_y_2 = manzana.getCoordenada_y();
        if(coordenada_x_1 == coordenada_x_2 && coordenada_y_1 == coordenada_y_2)
        {
            snake.agregar();
            setPuntuacion(puntuacion+1);
            if(velocidad>=50 && (puntuacion%11)==0)
                setVelocidad(velocidad-5);
            manzana = new Manzana();
        }
        if(puntuacion > 200)
        {
            jLabel_ganar.setVisible(true);
            snake = new Serpiente(150,270,"derecha");
        } 
    }
    
    public void paintComponent( Graphics g )
    {
        dibujarContorno(g);
        dibujarManzana(g);
        colisionManzana();
        if(!snake.avanzar())
        {
            colision();
        }
        dibujarSerpiente(g);
    } 
    
    @Override
    public void keyTyped(KeyEvent e) {
    
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int tecla = e.getKeyCode();
        if(87 == tecla || 38 == tecla)
        {
            snake.direccion("arriba");
        }
        if(39 == tecla || 68 == tecla)
        {
            snake.direccion("derecha");
        }
        if(65 == tecla || 37 == tecla)
        {
            snake.direccion("izquierda");
        }
        if(83 == tecla || 40 == tecla)
        {
            snake.direccion("abajo");
        }
        if(10 == tecla)
        {
            juegoNuevo();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_ganar = new javax.swing.JLabel();
        jLabel_Perder = new javax.swing.JLabel();
        jLabel_Puntuacion = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel_Velocidad = new javax.swing.JLabel();
        jLabel_Panel = new javax.swing.JLabel();
        jLabel_Enter = new javax.swing.JLabel();

        setForeground(new java.awt.Color(102, 102, 102));
        setMinimumSize(new java.awt.Dimension(800, 590));
        setPreferredSize(new java.awt.Dimension(800, 590));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_ganar.setFont(new java.awt.Font("Britannic Bold", 0, 60)); // NOI18N
        jLabel_ganar.setForeground(new java.awt.Color(102, 102, 255));
        jLabel_ganar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_ganar.setText("JUEGO GANADO");
        add(jLabel_ganar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 560, -1));

        jLabel_Perder.setFont(new java.awt.Font("Britannic Bold", 0, 60)); // NOI18N
        jLabel_Perder.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_Perder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Perder.setText("JUEGO TERMINADO");
        add(jLabel_Perder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 560, -1));

        jLabel_Puntuacion.setFont(new java.awt.Font("Britannic Bold", 0, 80)); // NOI18N
        jLabel_Puntuacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Puntuacion.setText("0");
        add(jLabel_Puntuacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 210, 220, -1));

        jLabel2.setFont(new java.awt.Font("Britannic Bold", 0, 40)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Puntuacion");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 220, -1));

        jLabel3.setFont(new java.awt.Font("Britannic Bold", 0, 40)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Velocidad");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 320, 220, -1));

        jLabel1.setFont(new java.awt.Font("Britannic Bold", 0, 60)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SNAKE");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 220, -1));

        jLabel_Velocidad.setFont(new java.awt.Font("Britannic Bold", 0, 80)); // NOI18N
        jLabel_Velocidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Velocidad.setText("0");
        add(jLabel_Velocidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 370, 220, -1));

        jLabel_Panel.setBackground(new java.awt.Color(153, 153, 153));
        jLabel_Panel.setFocusable(false);
        jLabel_Panel.setOpaque(true);
        add(jLabel_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 270, 600));

        jLabel_Enter.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        jLabel_Enter.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_Enter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Enter.setText("Presione Enter para continuar");
        add(jLabel_Enter, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 550, -1));
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_Enter;
    private javax.swing.JLabel jLabel_Panel;
    private javax.swing.JLabel jLabel_Perder;
    private javax.swing.JLabel jLabel_Puntuacion;
    private javax.swing.JLabel jLabel_Velocidad;
    private javax.swing.JLabel jLabel_ganar;
    // End of variables declaration//GEN-END:variables

}
