/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.IP.muziek.db;

import com.IP.muziek.domain.MuziekStuk;

import java.util.HashMap;

/**
 *
 * @author Mariss
 */
public class MuziekStukDBInSQL implements MuziekStukDB{
    
    @Override
    public MuziekStuk getMuziekStuk(String id) {
     return null;
    }

    @Override
    public void setMuziekStuk(MuziekStuk muziekStuk) {
    }

    @Override
    public MuziekStuk getLangsteStuk() {
         return null;
    }

    @Override
    public void verwijderMuziekStuk(MuziekStuk stuk) {
    }

    @Override
    public void updateMuziekStuk(MuziekStuk muziekStuk) {
    }

    @Override
    public HashMap<String, MuziekStuk> getAllStukken() {
        return null;
    }

    @Override
    public double gemiddeldeDuur() {
        return 0;
    }

    @Override
    public void verwijderMuziekStuk(String id) {

    }


}
