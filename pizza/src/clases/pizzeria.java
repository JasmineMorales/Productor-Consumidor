package clases;

import clases.Monitor;
import static clases.Monitor.contMon;
import clases.Monitor.controladorMonitor;
import static clases.Monitor.inventPizza;
import java.awt.Image;
import java.awt.Toolkit;
import static java.lang.Thread.sleep;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import jdk.tools.jlink.resources.jlink_ja;


public class Pizzeria extends javax.swing.JFrame {

  
    
    @Override
public Image getIconImage() {
   Image retValue = Toolkit.getDefaultToolkit().
         getImage(ClassLoader.getSystemResource("imagenes/ico.png"));
  return retValue;
}   
    
    public Pizzeria() 
    {
        initComponents();
        this.setLocationRelativeTo(null);
        ImageIcon entregado = new ImageIcon(getClass().getResource("/imagenes/entregado.png"));
        ImageIcon icon = new ImageIcon(entregado.getImage().getScaledInstance(lbl_entregado.getWidth(), lbl_entregado.getHeight(), Image.SCALE_DEFAULT));
        lbl_entregado.setIcon(icon);
              
    }
    //----------------------------------VARIABLES EN INTERFAZ
    public static boolean mostrador = false; 
    Monitor monitor = new Monitor();
    int inven = 0;
    int OrdenesAte=0;
    
    
    
    
    //----------------------------------VARIABLES DE MONITOR
    
   
   

   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gruporbt = new javax.swing.ButtonGroup();
        lbl_pizza = new javax.swing.JLabel();
        lbl_cliente = new javax.swing.JLabel();
        lbl_cliente_irse = new javax.swing.JLabel();
        lbl_contador = new javax.swing.JLabel();
        start = new javax.swing.JButton();
        lbl_entregado = new javax.swing.JLabel();
        lbl_contador1 = new javax.swing.JLabel();
        rbtConsumidor = new javax.swing.JRadioButton();
        rbtproductor = new javax.swing.JRadioButton();
        rbtIgual = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pizzeria");
        setFocusable(false);
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(lbl_pizza, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 120, 80));
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

        lbl_contador1.setBackground(new java.awt.Color(255, 153, 153));
        lbl_contador1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        lbl_contador1.setForeground(new java.awt.Color(51, 51, 0));
        lbl_contador1.setText("Lentitud");
        getContentPane().add(lbl_contador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 140, 30));

        gruporbt.add(rbtConsumidor);
        rbtConsumidor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbtConsumidor.setForeground(new java.awt.Color(153, 153, 0));
        rbtConsumidor.setText("Consumidor");
        rbtConsumidor.setBorder(null);
        rbtConsumidor.setContentAreaFilled(false);
        getContentPane().add(rbtConsumidor, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, -1));

        gruporbt.add(rbtproductor);
        rbtproductor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbtproductor.setForeground(new java.awt.Color(153, 153, 0));
        rbtproductor.setText("Productor");
        rbtproductor.setBorder(null);
        rbtproductor.setContentAreaFilled(false);
        getContentPane().add(rbtproductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, -1, -1));

        gruporbt.add(rbtIgual);
        rbtIgual.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbtIgual.setForeground(new java.awt.Color(153, 153, 0));
        rbtIgual.setText("Normal");
        rbtIgual.setBorder(null);
        rbtIgual.setContentAreaFilled(false);
        getContentPane().add(rbtIgual, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("Ink Free", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 180, 20));

        jLabel3.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 4, 0));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 90, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        
    HiloEntrada hiloEntrada = new HiloEntrada();    //Instansiacion de los hilos
    HiloAtender Hiloaten = new HiloAtender();  
    
              try {
               
               if ((rbtConsumidor.isSelected())||(rbtIgual.isSelected())||(rbtproductor.isSelected()))
                  {
                      OrdenesAte++; //Se suma una nueva orden al panel
                      lbl_contador.setText(String.valueOf(OrdenesAte)); // Se actualiza 
                      hiloEntrada.start();  //Inicio del hilo de entrada del personaje
                      Hiloaten.start();   //Inicio del hilo para atender la orden                   
                      sleep(0000);

                  }
              
              else
                  {
                    JOptionPane.showMessageDialog(null, "SELECCIONAR VELOCIDAD ");
                  }// FIN ELSE RadioB.
               
               
               
              } // FIN TRY
          catch (InterruptedException ex){
                  System.out.println("ERROR + "+ ex);
                }
          
     
        
        
    }//GEN-LAST:event_startActionPerformed

    
    //----------------------------------------------------------------------------------- INICIO INTERFAZ
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
    
    
    //-----------------------------------------------------Entrada
    public class HiloEntrada extends Thread{
        int x= lbl_cliente.getX();
        int y= lbl_cliente.getY();
        ImageIcon cliente = new ImageIcon(getClass().getResource("/imagenes/personaje1.png"));
        ImageIcon icon = new ImageIcon(cliente.getImage().getScaledInstance(lbl_cliente.getWidth(), lbl_cliente.getHeight(), Image.SCALE_DEFAULT));
        
        public void run()
        {
            lbl_cliente.setIcon(icon);
                for(int i=x; i>=150; i=i-90)
                {
                    try {
                        lbl_cliente.setLocation(i, y);
                        sleep(500);
                        } 
                    catch(InterruptedException ex) 
                    {
                    System.out.println("ERROR + "+ ex);
                    }
                    
               }
            lbl_cliente.setIcon(null);
            x=420;
            mostrador=true;
        }
    }
    //----------------------------------------------------SALIDA
    public class HiloIrse extends Thread{
        int x= lbl_cliente_irse.getX();
        int y= lbl_cliente_irse.getY();
        ImageIcon cliente_irse = new ImageIcon(getClass().getResource("/imagenes/personaje1_volteado.png"));
        ImageIcon icon = new ImageIcon(cliente_irse.getImage().getScaledInstance(lbl_cliente_irse.getWidth(), lbl_cliente_irse.getHeight(), Image.SCALE_DEFAULT));
        
        
        public void run()
        {
            try {
                    quitarPizza(); 
                    lbl_cliente_irse.setIcon(icon);
                    sleep(500);
                    quitarPizza();                   
                    for(int i=x; i<=640; i=i+90)
                    {
                     lbl_cliente_irse.setLocation(i, y);
                     sleep(500);                 
                    }
                    sleep(500);
                    lbl_cliente_irse.setIcon(null);
                    x=330;
                     
                    
                } //Fin TRY
            catch (InterruptedException ex) 
            {
                System.out.println("ERROR + "+ ex);
            }
          
          }// Fin del RUN
       
    }
    
    //----------------------------------------------------Atender
    public class HiloAtender extends Thread{
        //Icono del personaje recibiendo pizza 
        ImageIcon cliente = new ImageIcon(getClass().getResource("/imagenes/personaje1.png"));
        ImageIcon icon = new ImageIcon(cliente.getImage().getScaledInstance(lbl_cliente.getWidth(), lbl_cliente.getHeight(), Image.SCALE_DEFAULT));
        
        
        HiloIrse hiloSalida = new HiloIrse(); // Instansiacion del hilo para el personaje de salida
        controladorMonitor icontmon = new controladorMonitor(); // Instancia del controlador del monitor
                      
      public void run()
      {
                
        try {
            
            while((lbl_cliente.getAlignmentX()!=420) &&(mostrador!=true)) //Con esta condicion se evalua si el personaje
                {                                                       //Aun no ha llegado al mostrador para ser atendido
                 //System.out.println("variable: "+mostrador);
                    System.out.print("");
                }
//-------------------------------------------
    
            if (rbtConsumidor.isSelected())  //Si el boton de consumidor lento es seleccionado 
            {
                    Monitor.tiempoconsu=0000; // Se envia un tiempo para
                    icontmon.crearPizza();
                    mostrador=false;
              
                    if(monitor.noInventario() <= 9)
                    {                    
                        while(monitor.noInventario() != 10)
                        {
                            icontmon.crearPizza(); 
                            jLabel2.setText("Cocinando pizza: " + String.valueOf(monitor.noInventario()));
                        }
                    }
                    jLabel2.setText("PIZZA LISTA");
                    colocarPizza();
                    if(monitor.noInventario() != 0)
                    {
                         icontmon.consumirPizza();
                    }
                   jLabel3.setText( "Orden de: "+Monitor.orden);
                   sleep(5000); 
                   hiloSalida.start();                  
                   jLabel2.setText(null);
                   jLabel3.setText(null);
                   gruporbt.clearSelection();
                  
            }// FIN IF CONSUMIDOR LENTO
            
//------------------------------------------------            
            if (rbtproductor.isSelected()) 
            {
                 lbl_cliente_irse.setIcon(icon);
                 Monitor.tiempro=1000;
                 icontmon.crearPizza();

                 mostrador=false;
   
                    if(monitor.noInventario() <= 9)
                    {                    
                        while(monitor.noInventario() != 10)
                        {
                            icontmon.crearPizza();
                             jLabel2.setText("Cocinando pizza: " + String.valueOf(monitor.noInventario()));
                        }
                    }
                    jLabel2.setText("PIZZA LISTA");
                    colocarPizza();
                    if(monitor.noInventario() != 0)
                    {
                        icontmon.consumirPizza();
                    }
                jLabel3.setText( "Orden de: "+Monitor.orden);
                lbl_cliente_irse.setIcon(icon);
                sleep(2000); 
                hiloSalida.start();
                jLabel2.setText(null);
                jLabel3.setText(null);
                gruporbt.clearSelection();

            }
//-----------------------------------------------------            
            if (rbtIgual.isSelected()) 
            {   
                sleep(00);                    
                 Monitor.tiempro=0000;  
                 Monitor.tiempoconsu=0000;
                 
                 icontmon.crearPizza();
                 mostrador=false;
                  
                    if(monitor.noInventario() <= 9)
                    {                    
                        while(monitor.noInventario() != 10)
                        {
                            icontmon.crearPizza();
                             jLabel2.setText("Cocinando pizza: " + String.valueOf(monitor.noInventario()));
                        }
                        
                    }
                    jLabel2.setText("Pizza Lista");
                    colocarPizza();
                    if(monitor.noInventario() != 0)
                    {
                     icontmon.consumirPizza();
                    }
                 jLabel3.setText( "Orden de: "+Monitor.orden);
                 lbl_cliente_irse.setIcon(icon);
                 sleep(1000); 
                 hiloSalida.start();
                 jLabel2.setText(null);
                 jLabel3.setText(null);
                 gruporbt.clearSelection();

                    }



                
            } // FIN TRY
        
        catch (InterruptedException ex) 
            {
             System.out.println("ERROR + "+ ex);
            }
        
      
      }
    
  }
    
    //************************************************************************************ FIN INTERFAZ
    
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pizzeria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup gruporbt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbl_cliente;
    private javax.swing.JLabel lbl_cliente_irse;
    private javax.swing.JLabel lbl_contador;
    private javax.swing.JLabel lbl_contador1;
    private javax.swing.JLabel lbl_entregado;
    private javax.swing.JLabel lbl_pizza;
    private javax.swing.JRadioButton rbtConsumidor;
    private javax.swing.JRadioButton rbtIgual;
    private javax.swing.JRadioButton rbtproductor;
    private javax.swing.JButton start;
    // End of variables declaration//GEN-END:variables
}
