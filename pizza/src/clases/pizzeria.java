package clases;

import java.awt.Image;
import java.awt.Toolkit;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;


public class pizzeria extends javax.swing.JFrame {

    public boolean es1 = true;
    
    @Override
public Image getIconImage() {
   Image retValue = Toolkit.getDefaultToolkit().
         getImage(ClassLoader.getSystemResource("imagenes/ico.png"));
  return retValue;
}   
    
    public pizzeria() {
        initComponents();
        this.setLocationRelativeTo(null);
        ImageIcon entregado = new ImageIcon(getClass().getResource("/imagenes/entregado.png"));
        ImageIcon icon = new ImageIcon(entregado.getImage().getScaledInstance(lbl_entregado.getWidth(), lbl_entregado.getHeight(), Image.SCALE_DEFAULT));
        lbl_entregado.setIcon(icon);
              
    }
    
    public class HiloAvanza extends Thread{
        int x= lbl_cliente.getX();
        int y= lbl_cliente.getY();
        ImageIcon cliente = new ImageIcon(getClass().getResource("/imagenes/personaje1.png"));
        ImageIcon icon = new ImageIcon(cliente.getImage().getScaledInstance(lbl_cliente.getWidth(), lbl_cliente.getHeight(), Image.SCALE_DEFAULT));
        
        public void run()
        {
//            while(es1 == true)
//            {
            lbl_cliente.setIcon(icon);
                for(int i=x; i>=150; i=i-50)
                {
                    System.out.println(i);
                    try {
                        sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(pizzeria.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    lbl_cliente.setLocation(i, y);
                } 
////                es1==false;
////            }
        }
    }

   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_pizza = new javax.swing.JLabel();
        lbl_cliente = new javax.swing.JLabel();
        lbl_cliente_irse = new javax.swing.JLabel();
        lbl_contador = new javax.swing.JLabel();
        start = new javax.swing.JButton();
        lbl_entregado = new javax.swing.JLabel();
        lbl_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pizzeria");
        setFocusable(false);
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(lbl_pizza, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 120, 80));
        getContentPane().add(lbl_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 140, 270));
        getContentPane().add(lbl_cliente_irse, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 140, 270));

        lbl_contador.setBackground(new java.awt.Color(255, 153, 153));
        lbl_contador.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        lbl_contador.setForeground(new java.awt.Color(255, 153, 153));
        lbl_contador.setText("000");
        getContentPane().add(lbl_contador, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, 80, 30));

        start.setBackground(new java.awt.Color(15, 117, 15));
        start.setForeground(new java.awt.Color(255, 255, 255));
        start.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(96, 53, 10), 5, true));
        start.setBorderPainted(false);
        start.setContentAreaFilled(false);
        start.setFocusPainted(false);
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });
        getContentPane().add(start, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 460, 140, 70));

        lbl_entregado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        lbl_entregado.setIconTextGap(3);
        getContentPane().add(lbl_entregado, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 3, 170, 70));

        lbl_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.png"))); // NOI18N
        getContentPane().add(lbl_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed

        colocarPizza();
        HiloAvanza h1 = new HiloAvanza();
        h1.start();        
        HiloIrse h2 = new HiloIrse();
        h2.start();
//        quitarPizza();
        
    }//GEN-LAST:event_startActionPerformed

    public void colocarPizza()
    {
        ImageIcon cajasPizza = new ImageIcon(getClass().getResource("/imagenes/pizza.png"));
        ImageIcon icon = new ImageIcon(cajasPizza.getImage().getScaledInstance(lbl_pizza.getWidth(), lbl_pizza.getHeight(), Image.SCALE_DEFAULT));
        lbl_pizza.setIcon(icon);
    }
    
    public void quitarPizza()
    {
        lbl_pizza.setIcon(null);
    }
    
    
    
    public class HiloIrse extends Thread{
        int x= lbl_cliente_irse.getX();
        int y= lbl_cliente_irse.getY();
        ImageIcon cliente_irse = new ImageIcon(getClass().getResource("/imagenes/personaje1_volteado.png"));
        ImageIcon icon = new ImageIcon(cliente_irse.getImage().getScaledInstance(lbl_cliente_irse.getWidth(), lbl_cliente_irse.getHeight(), Image.SCALE_DEFAULT));
        
        public void run()
        {
//            while(es1 == true)
//            {
            System.out.println(x);
            lbl_cliente_irse.setIcon(icon);
                for(int i=x; i<=640; i=i+50)
                {
                    System.out.println(i);
                    try {
                        sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(pizzeria.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    lbl_cliente_irse.setLocation(i, y);
                } 
                lbl_cliente_irse.setIcon(null);
////                es1==false;
////            }
        }
    }
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pizzeria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbl_cliente;
    private javax.swing.JLabel lbl_cliente_irse;
    private javax.swing.JLabel lbl_contador;
    private javax.swing.JLabel lbl_entregado;
    private javax.swing.JLabel lbl_fondo;
    private javax.swing.JLabel lbl_pizza;
    private javax.swing.JButton start;
    // End of variables declaration//GEN-END:variables
}
