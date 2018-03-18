/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelviewpresenter;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author lg
 */
public class MyData {
    private final ObservableList<Czynnik> czynniki; 
    private final CzynnikWynik czynnikWynik;
    
    private final IntegerBinding liczbaCzynnikow;
    
    private final ObservableList<Plan> plany;
    private final ObservableList<Dosw> doswiadczenia;
    
    
    public MyData(){
        this.czynniki = FXCollections.observableArrayList();
        this.czynnikWynik = new CzynnikWynik("dsaf","sdfadsf","sdfsd");
        this.plany = FXCollections.observableArrayList();
        this.doswiadczenia = FXCollections.observableArrayList();
        
        liczbaCzynnikow = Bindings.size(czynniki);
        
        
    }
    
    public ObservableList<Czynnik> getCzynniki(){
        return czynniki;
    }
    public CzynnikWynik getCzynnikWynik(){
        return czynnikWynik;
    }

    /**
     * @return the plany
     */
    public ObservableList<Plan> getPlany() {
        return plany;
    }

    /**
     * @return the doswiadczenia
     */
    public ObservableList<Dosw> getDoswiadczenia() {
        return doswiadczenia;
    }

    /**
     * @return the liczbaCzynnikow
     */
    public IntegerBinding getLiczbaCzynnikow() {
        return liczbaCzynnikow;
    }
    
    
    
    
}
