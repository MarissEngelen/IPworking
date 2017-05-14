package com.IP.muziek.db;


import com.IP.muziek.domain.MuziekStuk;

import java.util.HashMap;


public interface MuziekStukDB {
    
    public MuziekStuk getMuziekStuk(String id);
    public void setMuziekStuk(MuziekStuk muziekStuk);
    public MuziekStuk getLangsteStuk();
    public void verwijderMuziekStuk(MuziekStuk stuk);
    public void updateMuziekStuk(MuziekStuk muziekStuk);
    public HashMap<String, MuziekStuk> getAllStukken();
    public double gemiddeldeDuur();
    public void verwijderMuziekStuk(String id);
    
}
