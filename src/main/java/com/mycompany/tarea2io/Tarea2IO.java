/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.tarea2io;

import java.util.Arrays;

/**
 *
 * @author famil
 */
public class Tarea2IO {

    public static void main(String[] args) {
        
        SRFLP instancia = new SRFLP("/Users/adolfojr/Downloads/QAP_sko100_04_n.txt");
        ComponentesSA comp = new ComponentesSA();
        
        int maxIteraciones = 1000;
        int i=0;
        double solucionInicial,solucionAux,solucionVecino;
        double delta;
        double tempInicial = 1000.0;
        double tempMin = 0.5;
        double alpha = 0.5;
        double probabilidad;
        
        
        solucionInicial=instancia.getTotalDistance(instancia.getFsize());
        solucionAux=solucionInicial;
        
        while(comp.criterioTermino(i,maxIteraciones,tempInicial,tempMin)){
            instancia.vectorSwap(instancia.getFsize());
            solucionVecino = instancia.getTotalDistance(instancia.getFsize());
            delta = solucionVecino-solucionInicial;
            if(delta<0){
                solucionInicial = solucionVecino;
            }
            else{
                double random = Math.random();
                if(random<comp.probabilidadAceptacion(delta, tempInicial)){
                    solucionInicial = solucionVecino;
                }
                    
            }
            solucionAux = comp.mejorSolucion(solucionInicial, solucionAux);
            tempInicial = comp.Enfriamiento(tempInicial, alpha);
            i+=1;
        }
        System.out.println(" Costo: "+solucionAux+" ");
        //instancia.mostrarVector();

    }
}
