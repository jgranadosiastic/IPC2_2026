/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.jdbc_java.enums;

/**
 *
 * @author jose
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Ocupado: " + EstadoDeMesa.OCUPADO);
        String valorEstado = "DISPONIBLE";
        System.out.println("DEsde valor: " + EstadoDeMesa.valueOf(valorEstado));

        System.out.println("% quincena: " + PorcentajeSueldo.PORCENTAJE_QUINCENA.getPorcentaje());
        String nombrePorcentaje = "PORCENTAJE_FIN_DE_MES";
        System.out.println("% fin de mes: " + PorcentajeSueldo.valueOf(nombrePorcentaje).getPorcentaje());

    }
}
