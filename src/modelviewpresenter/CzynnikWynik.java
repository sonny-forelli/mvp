/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelviewpresenter;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author ADMIN
 */
public class CzynnikWynik {
    private final StringProperty nazwa = new SimpleStringProperty(null,"nazwa",null);
    private final StringProperty oznaczenie = new SimpleStringProperty(null,"oznaczenie", null);
    private final StringProperty jednostka = new SimpleStringProperty(null,"jednostka",null);
    
    public CzynnikWynik(String nazwa, String oznaczenie, String jednostka){
        this.nazwa.set(nazwa);
        this.oznaczenie.set(oznaczenie);
        this.jednostka.set(jednostka);
    }
    
    public final String getNazwa(){
        return nazwa.get();
    }
    public final void setNazwa(String nazwa){
        this.nazwa.set(nazwa);
    }
    
    
    public final String getOznaczenie(){
        return oznaczenie.get();
    }
    public final void setOznaczenie(String oznaczenie){
        this.oznaczenie.set(oznaczenie);
    }
    
    public final String getJednostka(){
        return jednostka.get();
    }
    public final void setJednostka(String jednostka){
        this.jednostka.set(jednostka);
    }
    
    public final StringProperty nazwaProperty(){
        return nazwa;
    }
    public final StringProperty oznaczenieProperty(){
        return oznaczenie;
    }
    public final StringProperty jednostkaProperty(){
        return jednostka;
    }
    
    
}
