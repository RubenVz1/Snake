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
    }

    private Serpiente snake;
    private Manzana manzana;
    private int puntuacion;

    public Serpiente getSnake() {
        return snake;
    }

    public void setSnake(Serpiente snake) {
        this.snake = snake;
    }
    
    public void dibujarContorno(Graphics g)
    {     
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 20, 560);
        g.fillRect(0, 0, 560, 20);
        g.fillRect(543, 0, 20, 560);
        g.fillRect(0, 542, 560, 20);
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
    
    public boolean choque()
    {
        int coordenada_x = snake.getCola().get(0).getCoordenada_x();
        int coordenada_y = snake.getCola().get(0).getCoordenada_y();
        if(coordenada_x > 515 || coordenada_x < 20)
        {
            return true;
        }
        if(coordenada_y < 20 || coordenada_y > 520)
        {
            return true;   
        }
        return false;
    }
    
    public void comida()
    {
        int coordenada_x_1 = snake.getCola().get(0).getCoordenada_x();
        int coordenada_y_1 = snake.getCola().get(0).getCoordenada_y();
        int coordenada_x_2 = manzana.getCoordenada_x();
        int coordenada_y_2 = manzana.getCoordenada_y();
        if(coordenada_x_1 == coordenada_x_2 && coordenada_y_1 == coordenada_y_2)
        {
            puntuacion++;
            jLabel_Puntuacion.setText(""+puntuacion);
            manzana = new Manzana();
            snake.agregar();
        }
            
    }
    
    public void paintComponent( Graphics g )
    {        
        dibujarContorno(g);
        dibujarManzana(g);

        snake.avanzar();
        choque();
        comida();
        
        dibujarSerpiente(g);
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

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Britannic Bold", 0, 40)); // NOI18N
        jLabel1.setText("SNAKE");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel2.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        jLabel2.setText("Puntuacion");

        jLabel3.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
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

        jLabel_Puntuacion.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        jLabel_Puntuacion.setText("00000");

        jLabel_Velocidad.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        jLabel_Velocidad.setText("00000");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton_Izquierda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jButton_Derecha))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButton_Arriba)
                                            .addComponent(jLabel_Velocidad)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jLabel_Puntuacion))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(jButton_Abajo))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addGap(64, 64, 64)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_Puntuacion)
                .addGap(53, 53, 53)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_Velocidad)
                .addGap(59, 59, 59)
                .addComponent(jButton_Arriba)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Izquierda)
                    .addComponent(jButton_Derecha))
                .addGap(18, 18, 18)
                .addComponent(jButton_Abajo)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 601, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Abajo;
    private javax.swing.JButton jButton_Arriba;
    private javax.swing.JButton jButton_Derecha;
    private javax.swing.JButton jButton_Izquierda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_Puntuacion;
    private javax.swing.JLabel jLabel_Velocidad;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
