/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.jdbc_java.enums;

/**
 *
 * @author jose
 */
public enum PorcentajeSueldo {
    PORCENTAJE_QUINCENA(0.3d),
    PORCENTAJE_FIN_DE_MES(0.7d);
    
    private double porcentaje;
    
    private PorcentajeSueldo(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public double getPorcentaje() {
        return porcentaje;
    }
    
    
}
