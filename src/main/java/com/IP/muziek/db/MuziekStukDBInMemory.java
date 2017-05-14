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
public class MuziekStukDBInMemory implements MuziekStukDB{
    
    private HashMap<String, MuziekStuk> muziekStukken;
    
    public MuziekStukDBInMemory(){
        MuziekStuk stuk1 = new MuziekStuk("1", "Sky High", "Jigsaw",  166);
        MuziekStuk stuk2 = new MuziekStuk("2", "Mercy, mercy, mercy", "Joe Zawinul", 250);
        muziekStukken = new HashMap<>();
        muziekStukken.put(stuk1.getStukId(), stuk1);
        muziekStukken.put(stuk2.getStukId(), stuk2);
    }

    @Override
    public MuziekStuk getMuziekStuk(String id) {

        return this.muziekStukken.get(id);
    }

    @Override
    public void setMuziekStuk(MuziekStuk muziekStuk) {
        this.muziekStukken.put(muziekStuk.getStukId(), muziekStuk);
    }

    @Override
    public MuziekStuk getLangsteStuk() {

        MuziekStuk antwoord = muziekStukken.get(0);

        for(MuziekStuk stuk : muziekStukken.values()){

            if(stuk.getDuur() > antwoord.getDuur()) antwoord = stuk;

        }
         return antwoord;
    }

    @Override
    public void verwijderMuziekStuk(MuziekStuk stuk) {
        this.muziekStukken.remove(stuk);
    }

    @Override
    public void updateMuziekStuk(MuziekStuk muziekStuk) {
        verwijderMuziekStuk(muziekStuk);
        setMuziekStuk(muziekStuk);
    }

    @Override
    public HashMap<String, MuziekStuk> getAllStukken() {
        return this.muziekStukken;
    }

    @Override
    public double gemiddeldeDuur() {
        double antwoord = 0;

        for(MuziekStuk stuk : muziekStukken.values()){
            antwoord = antwoord + stuk.getDuur();
        }

        return (antwoord / muziekStukken.size());

    }

    @Override
    public void verwijderMuziekStuk(String id) {
        this.muziekStukken.remove(id);
    }

}
