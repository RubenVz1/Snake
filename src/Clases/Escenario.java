package Clases;

import java.awt.Color;
import java.awt.Graphics;

public class Escenario extends javax.swing.JPanel
{

    public Escenario()
    {
        initComponents();
        snake = new Serpiente(150,150,"derecha");
        manzana = new Manzana();
        puntuacion = 1;
        jLabel_Puntuacion.setText(""+(puntuacion-1));
        jLabel_Velocidad.setText(""+2000);
        jLabel_Perder.setVisible(false);
    }

    private Serpiente snake;
    private Manzana manzana;
    private int puntuacion;
    private int velocidad;

    public Serpiente getSnake() {
        return snake;
    }

    public void setSnake(Serpiente snake) {
        this.snake = snake;
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
    
    public boolean colision_pared()
    {
        int coordenada_x = snake.getCola().get(0).getCoordenada_x();
        int coordenada_y = snake.getCola().get(0).getCoordenada_y();
        if(coordenada_x >= 531 || coordenada_x <= 9)
        {
            jLabel_Perder.setVisible(true);
            return true;
        }
        if(coordenada_y >= 531 || coordenada_y <= 9)
        {
            jLabel_Perder.setVisible(true);
            return true;   
        }
        return false;
    }
    
    public void colision_manzana()
    {
        int coordenada_x_1 = snake.getCola().get(0).getCoordenada_x();
        int coordenada_y_1 = snake.getCola().get(0).getCoordenada_y();
        int coordenada_x_2 = manzana.getCoordenada_x();
        int coordenada_y_2 = manzana.getCoordenada_y();
        if(coordenada_x_1 == coordenada_x_2 && coordenada_y_1 == coordenada_y_2)
        {
            puntuacion++;
            jLabel_Puntuacion.setText(""+(puntuacion-1));
            jLabel_Velocidad.setText(""+(2000-velocidad));
            manzana = new Manzana();
            snake.agregar();
        }
            
    }
    
    public void paintComponent( Graphics g )
    {        
        dibujarContorno(g);
        dibujarManzana(g);
        if(!colision_pared())
        {
            snake.avanzar();
        }
        dibujarSerpiente(g);
        colision_manzana();
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton_Arriba = new javax.swing.JButton();
        jButton_Abajo = new javax.swing.JButton();
        jButton_Derecha = new javax.swing.JButton();
        jButton_Izquierda = new javax.swing.JButton();
        jLabel_Puntuacion = new javax.swing.JLabel();
        jLabel_Velocidad = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel_Perder = new javax.swing.JLabel();

        setForeground(new java.awt.Color(102, 102, 102));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Britannic Bold", 0, 40)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SNAKE");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel2.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Puntuacion");

        jLabel3.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Velocidad");

        jButton_Arriba.setText("Arriba");
        jButton_Arriba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ArribaActionPerformed(evt);
            }
        });

        jButton_Abajo.setText("Abajo");
        jButton_Abajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AbajoActionPerformed(evt);
            }
        });

        jButton_Derecha.setText("Derecha");
        jButton_Derecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DerechaActionPerformed(evt);
            }
        });

        jButton_Izquierda.setText("Izquierda");
        jButton_Izquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_IzquierdaActionPerformed(evt);
            }
        });

        jLabel_Puntuacion.setFont(new java.awt.Font("Britannic Bold", 0, 60)); // NOI18N
        jLabel_Puntuacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Puntuacion.setText("0");

        jLabel_Velocidad.setFont(new java.awt.Font("Britannic Bold", 0, 60)); // NOI18N
        jLabel_Velocidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Velocidad.setText("0");

        jButton1.setText("Reiniciar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_Izquierda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton_Derecha))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_Velocidad, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_Puntuacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_Abajo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_Arriba, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(59, 59, 59)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_Puntuacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_Velocidad)
                .addGap(18, 18, 18)
                .addComponent(jButton_Arriba, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Derecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_Izquierda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jButton_Abajo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(98, 98, 98))
        );

        jLabel_Perder.setFont(new java.awt.Font("Britannic Bold", 0, 60)); // NOI18N
        jLabel_Perder.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_Perder.setText("HAZ PERDIDO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jLabel_Perder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(jLabel_Perder)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ArribaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ArribaActionPerformed
        snake.direccion("arriba");
    }//GEN-LAST:event_jButton_ArribaActionPerformed

    private void jButton_AbajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AbajoActionPerformed
        snake.direccion("abajo");
    }//GEN-LAST:event_jButton_AbajoActionPerformed

    private void jButton_DerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DerechaActionPerformed
        snake.direccion("derecha");
    }//GEN-LAST:event_jButton_DerechaActionPerformed

    private void jButton_IzquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_IzquierdaActionPerformed
        snake.direccion("izquierda");
    }//GEN-LAST:event_jButton_IzquierdaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        snake = new Serpiente(150,150,"derecha");
        manzana = new Manzana();
        this.puntuacion = 0;
        jLabel_Puntuacion.setText(""+puntuacion);
        jLabel_Perder.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_Abajo;
    private javax.swing.JButton jButton_Arriba;
    private javax.swing.JButton jButton_Derecha;
    private javax.swing.JButton jButton_Izquierda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_Perder;
    private javax.swing.JLabel jLabel_Puntuacion;
    private javax.swing.JLabel jLabel_Velocidad;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
