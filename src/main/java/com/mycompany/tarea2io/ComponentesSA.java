/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tarea2io;

/**
 *
 * @author adolfojr
 */
public class ComponentesSA {
    
    private double alpha = 0.5;
    double probabilidad;
    
    public ComponentesSA(){
        
    }
    
    public boolean criterioTermino(int i,int maxIteraciones,double tempInicial,double tempMin){
        
        if((i>maxIteraciones) || (tempInicial<=tempMin))
            return true;
        return false;
    }
    
    public double probabilidadAceptacion(double delta, double temp){
        
        double probabilidad = Math.exp(-delta/temp);
        return probabilidad;
    }
    
    public double mejorSolucion(double solucionFinal,double solucionInicial){
        
        if(solucionFinal<solucionInicial)
            return solucionFinal;
        return solucionInicial;
    }
    
    
    public double Enfriamiento(double tempInicial, double alpha){
        
        return tempInicial*alpha;
    }
    
    
}
