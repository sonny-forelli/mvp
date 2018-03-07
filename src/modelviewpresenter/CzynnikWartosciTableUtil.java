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
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;

/**
 *
 * @author lg
 */
public class CzynnikWartosciTableUtil {
    
    ObservableList<String> wartosci;
            
    public TableView<String> getTable(ObservableList<Czynnik> czynniki){
        ObservableList<String> pC = FXCollections.observableArrayList();
        
        
        return tabela;
    }
    public void asd(){
        
    }
// 4 HORIZONTAL LISTVIEWS
   ////////
    
    
    
    
    
    
    
    ///////
    ///
    
    private List<TableColumn> loadColumns(ObservableList<Czynnik> czynniki) {
        List<TableColumn> kolumny = new ArrayList();
        
        for(Czynnik c : czynniki){
    //       List<String>  = new ArrayList();
           
           TableColumn col = new TableColumn(c.getNazwa());
        /*   
           col.setCellValueFactory(new Callback<CellDataFeatures<rzeczy, String>, ObservableValue<String>>() {
 
     public ObservableValue<String> call(CellDataFeatures<Person, String> p) {
          // p.getValue() returns the Person instance for a particular TableView row
          return p.getValue().firstNameProperty();
      }
   });
           */
        }
        
       
            
    //    kolumny.add(tc);
        
        
        return kolumny;
    }
    
    
    
  /*
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
        
        
    
}*/
    
}
