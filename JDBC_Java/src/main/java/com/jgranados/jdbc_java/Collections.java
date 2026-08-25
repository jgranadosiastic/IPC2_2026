/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.jdbc_java;

import com.jgranados.jdbc_java.dbconnection.Autor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author jose
 */
public class Collections {
    public static void main(String[] args) {
        Autor[] autorArr = new Autor[100_000];
        // ArrayList
        List<Autor> autores = new ArrayList<>(autorArr.length);
        
        List<String> nombres = new ArrayList<>();
        for (Autor autor : autorArr) {
            nombres.add(autor.getNombre());
        }
        
        List<String> linkedString = new LinkedList<>();
        // Set
        Set<String> setString = new HashSet();
        setString.add("HOla");
        setString.add("HOla");
    }
}
