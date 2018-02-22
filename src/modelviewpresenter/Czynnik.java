/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelviewpresenter;

import java.util.concurrent.atomic.AtomicInteger;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author lg
 */
public class Czynnik {
    
    // ID, AtomicInteger
    
    private final ReadOnlyIntegerWrapper czynnikId =
            new ReadOnlyIntegerWrapper(this, "czynnikId", czynnikSequence.incrementAndGet());
    
    private final StringProperty nazwa = new SimpleStringProperty(this, "nazwa", null); 
    private final StringProperty oznaczenie = new SimpleStringProperty(this, "oznaczenie", null);
    private final DoubleProperty wartoscMin = new SimpleDoubleProperty(this, "wartoscMin", 0);
    private final DoubleProperty wartoscMax = new SimpleDoubleProperty(this, "wartoscMax", 0);
    private final StringProperty jednostka = new SimpleStringProperty(this, "jednostka", null);
    
    private static AtomicInteger czynnikSequence = new AtomicInteger(0);
    
    /*
    
    public Czynnik(){
        
        this(null,null,null,null,null);
    
    */
    
    
    public Czynnik(String naz, String ozn,
                    double wmin, double wmax, String jedn){
        
        
        
        
        
        this.nazwa.set(naz);
        this.oznaczenie.set(ozn);
        this.wartoscMin.set(wmin);
        this.wartoscMax.set(wmax);
        this.jednostka.set(jedn);
        
    }
    
    
    
    
    /*
                ID
    
    */
    public final int getCzynnikId() {
        return czynnikId.get();
    }
    public final ReadOnlyIntegerProperty czynnikIdProperty(){
        return czynnikId.getReadOnlyProperty();
    }
    
    /* nazwa */
    public final String getNazwa(){
        return nazwa.get();
    }
    
    public final void setNazwa(String nazwa){
        nazwaProperty().set(nazwa);
    }
    
    public final StringProperty nazwaProperty(){
        return nazwa;
    }
    
    /* oznaczenie */
    public final String getOznaczenie(){
        return oznaczenie.get();
    }
    
    public final void setOznaczenie(String oznaczenie){
        oznaczenieProperty().set(oznaczenie);
    }
    
    public final StringProperty oznaczenieProperty(){
        return oznaczenie;
    }
    
    /* wartosc minimalna */
    public final double getWartoscMin(){
        return wartoscMin.get();
    }
    public final void setWartoscMin(double wartoscMin){
        wartoscMinProperty().set(wartoscMin);
    }
    
    public final DoubleProperty wartoscMinProperty(){
        return wartoscMin;
    }
    
    /* wartość maksymalna */
    public final double getWartoscMax(){
        return wartoscMax.get();
    }
    
    public final void setWartoscMax(double wartoscMax){
        wartoscMaxProperty().set(wartoscMax);
    }
    
    public final DoubleProperty wartoscMaxProperty(){
        return wartoscMax;
    }
    
    /* jednostka */
    public final String getJednostka(){
        return jednostka.get();
    }
    
    public final void setJednostka(String jednostka){
        jednostkaProperty().set(jednostka);
    }
    
    public final StringProperty jednostkaProperty(){
        return jednostka;
    }
    
    /*
        ...
    */
    
    @Override
    public String toString(){
        return czynnikId.get() +
               ", nazwa: " + nazwa.get() +
               ", oznaczenie: " + oznaczenie.get() +
               ", wartosc minimalna: " + wartoscMin.get() +
               ", wartosc maksymalna: " + wartoscMax.get() +
               ", jednostka: " + jednostka.get() + ")";
    }
    
}
