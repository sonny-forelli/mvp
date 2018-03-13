/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelviewpresenter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author lg
 */
public class MyData {
    private final ObservableList<Czynnik> czynniki; 
    private final CzynnikWynik czynnikWynik;
    
    
    public MyData(){
        this.czynniki = FXCollections.observableArrayList();
        this.czynnikWynik = new CzynnikWynik("dsaf","sdfadsf","sdfsd");
        
    }
    
    public ObservableList<Czynnik> getCzynniki(){
        return czynniki;
    }
    public CzynnikWynik getCzynnikWynik(){
        return czynnikWynik;
    }
    
}
