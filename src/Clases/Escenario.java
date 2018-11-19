package Clases;

import java.awt.Color;
import java.awt.Graphics;

public class Escenario extends javax.swing.JPanel
{

    private Serpiente snake;
    private Manzana manzana;
    private int puntuacion;
    private int velocidad;
    
    public Escenario()
    {
        initComponents();
        snake = new Serpiente(150,150,"derecha");
        manzana = new Manzana();
        jLabel_Perder.setVisible(false);
        setPuntuacion(1);
        setVelocidad(500);
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
        jLabel_Velocidad.setText(""+(500-velocidad));
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
        int coordenada_x;
        int coordenada_y;
        g.setColor(Color.RED);
        coordenada_x = manzana.getCoordenada_x();
        coordenada_y = manzana.getCoordenada_y();
        g.fillOval(coordenada_x,coordenada_y,20,20);
        g.setColor(Color.BLACK);
        g.drawOval(coordenada_x,coordenada_y,20,20);
    }
    
    public void colision()
    {
        jLabel_Perder.setVisible(true);
    }
    
    public void colision_manzana()
    {
        int coordenada_x_1 = snake.getCola().get(0).getCoordenada_x();
        int coordenada_y_1 = snake.getCola().get(0).getCoordenada_y();
        int coordenada_x_2 = manzana.getCoordenada_x();
        int coordenada_y_2 = manzana.getCoordenada_y();
        if(coordenada_x_1 == coordenada_x_2 && coordenada_y_1 == coordenada_y_2)
        {
            setPuntuacion(puntuacion+1);
            if(velocidad>=100 && (puntuacion%4)==0)
                setVelocidad(velocidad-50);
            manzana = new Manzana();
            snake.agregar(); 
        }   
    }
    
    public void paintComponent( Graphics g )
    {        
        dibujarContorno(g);
        dibujarManzana(g);
        if(!snake.avanzar())
        {
            colision();
        }
        dibujarSerpiente(g);
        colision_manzana();
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_Perder = new javax.swing.JLabel();
        jLabel_Puntuacion = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel_Velocidad = new javax.swing.JLabel();
        jButton_Arriba = new javax.swing.JButton();
        jButton_Izquierda = new javax.swing.JButton();
        jButton_Derecha = new javax.swing.JButton();
        jButton_Abajo = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setForeground(new java.awt.Color(102, 102, 102));
        setMinimumSize(new java.awt.Dimension(830, 590));
        setPreferredSize(new java.awt.Dimension(800, 590));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Perder.setFont(new java.awt.Font("Britannic Bold", 0, 60)); // NOI18N
        jLabel_Perder.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_Perder.setText("HAS PERDIDO");
        add(jLabel_Perder, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, -1, -1));

        jLabel_Puntuacion.setFont(new java.awt.Font("Britannic Bold", 0, 60)); // NOI18N
        jLabel_Puntuacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Puntuacion.setText("0");
        add(jLabel_Puntuacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(597, 160, 180, -1));

        jLabel2.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Puntuacion");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, 190, -1));

        jLabel3.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Velocidad");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 230, 190, -1));

        jLabel1.setFont(new java.awt.Font("Britannic Bold", 0, 40)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SNAKE");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 30, 200, -1));

        jLabel_Velocidad.setFont(new java.awt.Font("Britannic Bold", 0, 60)); // NOI18N
        jLabel_Velocidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Velocidad.setText("0");
        add(jLabel_Velocidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 270, -1, -1));

        jButton_Arriba.setText("Arriba");
        jButton_Arriba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ArribaActionPerformed(evt);
            }
        });
        add(jButton_Arriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 350, 85, -1));

        jButton_Izquierda.setText("Izquierda");
        jButton_Izquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_IzquierdaActionPerformed(evt);
            }
        });
        add(jButton_Izquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 390, 90, -1));

        jButton_Derecha.setText("Derecha");
        jButton_Derecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DerechaActionPerformed(evt);
            }
        });
        add(jButton_Derecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 390, -1, -1));

        jButton_Abajo.setText("Abajo");
        jButton_Abajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AbajoActionPerformed(evt);
            }
        });
        add(jButton_Abajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 430, 84, -1));

        jButton1.setText("Reiniciar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 480, 108, -1));

        jLabel4.setBackground(new java.awt.Color(153, 153, 153));
        jLabel4.setFocusable(false);
        jLabel4.setOpaque(true);
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 270, 570));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        snake = new Serpiente(150,150,"derecha");
        manzana = new Manzana();
        setPuntuacion(1);
        setVelocidad(500);
        jLabel_Perder.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton_IzquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_IzquierdaActionPerformed
        snake.direccion("izquierda");
    }//GEN-LAST:event_jButton_IzquierdaActionPerformed

    private void jButton_DerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DerechaActionPerformed
        snake.direccion("derecha");
    }//GEN-LAST:event_jButton_DerechaActionPerformed

    private void jButton_AbajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AbajoActionPerformed
        snake.direccion("abajo");
    }//GEN-LAST:event_jButton_AbajoActionPerformed

    private void jButton_ArribaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ArribaActionPerformed
        snake.direccion("arriba");
    }//GEN-LAST:event_jButton_ArribaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_Abajo;
    private javax.swing.JButton jButton_Arriba;
    private javax.swing.JButton jButton_Derecha;
    private javax.swing.JButton jButton_Izquierda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel_Perder;
    private javax.swing.JLabel jLabel_Puntuacion;
    private javax.swing.JLabel jLabel_Velocidad;
    // End of variables declaration//GEN-END:variables

}
