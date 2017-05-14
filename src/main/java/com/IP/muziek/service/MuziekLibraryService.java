/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.IP.muziek.service;


import com.IP.muziek.db.DBFactory;
import com.IP.muziek.db.MuziekStukDB;
import com.IP.muziek.domain.MuziekStuk;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Mariss
 */
public class MuziekLibraryService {
    
    private MuziekStukDB muziekStukDB;
    private DBFactory factory;
    
    public MuziekLibraryService(String database){
        DBFactory factory = new DBFactory();
        muziekStukDB = factory.createDB(database);
    }
    

    public MuziekStuk getMuziekStuk(String id){
        return muziekStukDB.getMuziekStuk(id);
       }
    
    public void setMuziekStuk(MuziekStuk muziekStuk){
        muziekStukDB.setMuziekStuk(muziekStuk);
    }
    
    
    public MuziekStuk getLangsteStuk(){
        return muziekStukDB.getLangsteStuk();
    }
    
    public void verwijderMuziekStuk(MuziekStuk stuk){
        muziekStukDB.verwijderMuziekStuk(stuk);
    }
    
    public void updateMuziekStuk(MuziekStuk muziekStuk){
        muziekStukDB.updateMuziekStuk(muziekStuk);
    }
    
    public HashMap<String, MuziekStuk> getAllStukken(){
        return muziekStukDB.getAllStukken();
    }

    public double gemiddelde(){
        return muziekStukDB.gemiddeldeDuur();
    }

    public void verwijderMuziekStuk(String id){
        this.muziekStukDB.verwijderMuziekStuk(id);
    }
    
}
