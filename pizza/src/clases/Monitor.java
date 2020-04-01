/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Monitor {
    static final int ordenesMax = 10;
    static int inventPizza= 0, pizzaReserv = 0, orden = 0, control = 0; //modficar si se quieren menos o mas pizzas en esprea 
    static boolean esperaOrden = false; 
    static controladorMonitor contMon = new controladorMonitor();
    static controladorConsumidor contCon = new controladorConsumidor();
    static controladorProductor contProd = new controladorProductor();
    
    public static void main(String args[]){
        contProd.start(); // inicia el hilo productor
        contCon.start();
        
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
        public synchronized void crearPizza(){
            if(inventPizza == ordenesMax) desactivar();
            else{
                inventPizza++;
                System.out.println("invantario + 1= " + inventPizza);
                notify();
            }
            if(inventPizza ==1) notify();
        }
        public synchronized void consumirPizza(){
            if(!esperaOrden){
                orden =  ThreadLocalRandom.current().nextInt(1, 15);
                System.out.println("Nueva Orden: " + orden);
                if(orden>=inventPizza){
                    int ordenTemp = orden;
                    orden = orden - inventPizza;
                    inventPizza = 0;
                    System.out.println("Inventario = " + inventPizza);
                    System.out.println("La orden es mayor al inventario, esperara a completar la orden");
                    System.out.println("Pendiente de completar: " + orden);
                    esperaOrden = true;
                    //desactivar();
                    notify();
                }else{
                    inventPizza = inventPizza - orden;
                    System.out.println("Inventario - " + orden + " = " + inventPizza);
                }
            }else{
                if(orden > inventPizza){
                    System.out.println("Esperando Orden");
                    desactivar();
                    notify();
                }else{
                    System.out.println("Orden compreta");
                    inventPizza = inventPizza - orden;
                    System.out.println("Inventario = " + inventPizza);
                    esperaOrden = false;
                }
            }
            
        }
        private void desactivar(){
            try{
                Thread.sleep(100);
                wait(); // Duerme al proceso en turno
            }
            catch(InterruptedException exc){};
        }
        
    }
}
