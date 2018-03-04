/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelviewpresenter;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

/**
 *
 * @author lg
 */
public class CzynnikWartosciTableUtil {
    public final static ObservableList<String> wiersze = 
            FXCollections.observableArrayList("a","b","c","d");
            
    public TableView<String> getTable(ObservableList<Czynnik> czynniki){
        TableView tabela = new TableView(wiersze);
        tabela.getColumns().addAll(loadColumns(czynniki));
        
        return tabela;
    }
    public void asd(){
        
    }

    private List<TableColumn> loadColumns(ObservableList<Czynnik> czynniki) {
        List<TableColumn> kolumny = new ArrayList();
        
       
            
        kolumny.add(tc);
        
        
        return kolumny;
    }
    
    private class Row {
        List<String> cellsInRow = new ArrayList();
        
        private Row(ObservableList<Czynnik> czynniki, int rowId){
            switch(rowId){
                case 1:
                    for(Czynnik cz: czynniki){
                        String wartoscCentr;
                        double wC = (cz.getWartoscMax() - cz.getWartoscMin())/2;
                        wartoscCentr=Double.toString(wC);
                        cellsInRow.add(wartoscCentr);
                    }
                    break;
                case 2:
                    for(Czynnik cz: czynniki){
                        String jednostkaZm;
                        double jZ = cz.getWartoscMax() -(cz.getWartoscMax()-cz.getWartoscMin()/2);
                        jednostkaZm=Double.toString(jZ);
                        cellsInRow.add(jednostkaZm);
                    }break;
                case 3:
                    for(Czynnik cz: czynniki){
                        String poziomW;
                        double pW = cz.getWartoscMax();
                        poziomW=Double.toString(pW);
                        cellsInRow.add(poziomW);
                        
                    }break;
                case 4:
                    for(Czynnik cz: czynniki){
                        String poziomN;
                        double pW = cz.getWartoscMin()
                    }
            }
                        
            
            
        }
        
        
    
}
    
}
