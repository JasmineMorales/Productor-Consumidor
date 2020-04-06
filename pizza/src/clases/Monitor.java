/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Monitor {
     static final int ordenesMax = 10;
    public static int inventPizza= 0, pizzaReserv = 0, orden = 0, control = 0; //modficar si se quieren menos o mas pizzas en esprea 
    static boolean esperaOrden = false; 
    static controladorMonitor contMon = new controladorMonitor();
    static controladorConsumidor contCon = new controladorConsumidor();
    static controladorProductor contProd = new controladorProductor();
    
    public static int tiempoconsu=0;
    public static int tiempro=0;
     static int op=0;
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String args[]){
     
        
    }
    
    
    static class controladorProductor extends Thread{
        public void run(){
            while(true){
                contMon.crearPizza();
            }
        }
    }
    static class controladorConsumidor extends Thread{
        public void run(){
            while(true){
                contMon.consumirPizza();
            }
        }
    }
    static class controladorMonitor extends Thread{
        
        
        public synchronized void crearPizza()        
        {
         try {
            if(inventPizza == ordenesMax) desactivar();
            else{             
                    Thread.sleep(tiempro);
                    inventPizza++;
                   // System.out.println("Produciendo: " + inventPizza);
                    notify();               
                }
                if(inventPizza ==1) notify();            
             } 
            catch (InterruptedException ex) 
            {
             JOptionPane.showMessageDialog(null, "error " + ex);
            }
         
        }
   //--------------------------------------------------     
        
        public synchronized void consumirPizza()
        {
              try 
                {
         
                   if(!esperaOrden)
                     {
                        Thread.sleep(tiempoconsu);
                         orden =  ThreadLocalRandom.current().nextInt(1, ordenesMax);
                        // System.out.println("Nueva Orden: " + orden);
                         if(orden>=inventPizza)
                         {
                           //  System.out.println("Entregadas: " + inventPizza);
                             orden = orden - inventPizza;
                             inventPizza = 0;                             
                           //  System.out.println("Pendientes: " + orden);
                             esperaOrden = true;
                             //desactivar();
                             notify();
                         }else{
                             // Thread.sleep(tiempoconsu);
                             inventPizza = inventPizza - orden;
                           //  System.out.println("Orden de: " + orden + " Completa ");
                          //   System.out.println("Inventario: " + inventPizza);
                         }
                     }else{
                         if(orden > inventPizza){
                           //  System.out.println("Esperando Orden");
                             //Thread.sleep(tiempoconsu);
                             desactivar();
                             notify();
                         }else{
                              //Thread.sleep(tiempoconsu);
                            // System.out.println("Orden completa");
                             inventPizza = inventPizza - orden;
                           //  System.out.println("Inventario = " + inventPizza);
                             esperaOrden = false;
                         }
                     }

             } catch (InterruptedException ex) 
                {
                    JOptionPane.showMessageDialog(null, "error " + ex);
                }
            
        }
        
        
        private void desactivar()
        {
            try{
                Thread.sleep(100);
                wait(); // Duerme al proceso en turno
            }
            catch(InterruptedException exc){};
        }
        
    }


    public int noOrden(){
        return orden;
    }
    public int noInventario(){
        return inventPizza;
    }

}

