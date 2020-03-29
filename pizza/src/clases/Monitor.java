/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

public class Monitor {
    static final int ordenesMax = 10;
    static int inventPizza= 0; //modficar si se quieren menos o mas pizzas en esprea 
    static controladorMonitor contMon = new controladorMonitor();
    static controladorProductor contProd = new controladorProductor();
    
    public static void main(String args[]){
        contProd.start(); // inicia el hilo productor
    }
    static class controladorProductor extends Thread{
        public void run(){
            while(true){
                contMon.crearPizza();
            }
        }
    }
    static class controladorMonitor extends Thread{
        public synchronized void crearPizza(){
            if(inventPizza == ordenesMax) desactivar();
            inventPizza++;
            System.out.println("invantario + 1= " + inventPizza);
            if(inventPizza == 1) notify();
        }
        private void desactivar(){
            try{
                wait(); // Duerme al proceso en turno
            }
            catch(InterruptedException exc){};
        }
    }
}
