/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.IP.muziek.db;

/**
 *
 * @author Mariss
 */
public class DBFactory {
    
    public MuziekStukDB createDB(String type){
        
        if(type.equals("SQL")){
            return new MuziekStukDBInSQL();
        }
        else if(type.equals("InMemory")){
            return new MuziekStukDBInMemory();
        } else if (type.equals("JPA")
                ) {
            return new MuziekStukJpaDB();
        }
        
        return null;        
    }
    
}
