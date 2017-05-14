package com.IP.muziek.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Mariss
 */

@Entity
public class MuziekStuk {

    @Id
    private String stukId;
    private String naam;
    private String artiest;
    private int duur;

    public MuziekStuk(String stukId, String naam, String artiest, int duur){
        setStukId(stukId);
        setNaam(naam);
        setArtiest(artiest);
        setDuur(duur);
    }

    public MuziekStuk(){

    }
    
    
    public String getStukId() {
        return stukId;
    }

    public void setStukId(String stukId) {

        if(stukId == null || stukId.isEmpty())throw new DomainException("id kan niet leeg zijn");

        this.stukId = stukId;
    }
    
    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {

        if(naam == null || naam.isEmpty())throw new DomainException("titel kan niet leeg zijn");

        this.naam = naam;
    }

    public String getArtiest() {
        return artiest;
    }

    public void setArtiest(String artiest) {

        if(naam == null || naam.isEmpty())throw new DomainException("artiest kan niet leeg zijn");

        this.artiest = artiest;
    }



    public int getDuur() {
        return duur;
    }

    public void setDuur(int duur) {
        this.duur = duur;
    }





}
