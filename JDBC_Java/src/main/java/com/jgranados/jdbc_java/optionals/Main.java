/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.jdbc_java.optionals;

import com.jgranados.jdbc_java.dbconnection.Autor;
import java.util.Optional;

/**
 *
 * @author jose
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Autor autor = new Autor("abc", "nombre", "guatemalteco");
        Autor autorMayorEdad = main.metodoConPosibleNull(autor, 15);
        
        // mas codigo
        //System.out.println("Autor mayode de edad: " + autorMayorEdad.getNombre());
        
        
        Optional<Autor> autorMayorEdadOpt = main.metodoConOptional(autor, 18);
        
        
        
        
        // mas codigo
        if (autorMayorEdadOpt.isPresent()) {
            Autor autorMAyorDeEdadDeOPtional = autorMayorEdadOpt.get();
            System.out.println("Autor mayor de edad:" + autorMAyorDeEdadDeOPtional.getNombre());
        }
        
    }
    
    public Autor metodoConPosibleNull(Autor autor, int edad) {
        if (edad >= 18) {
            return autor;
        }
        
        return null;
    }
    
    public Optional<Autor> metodoConOptional(Autor autor, int edad) {
        if (edad >= 18) {
            return Optional.of(autor);
        }
        
        return Optional.empty();
    }
}
