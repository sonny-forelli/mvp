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
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

/**
 *
 * @author lg
 */
public class CzynnikWartosciTableUtil {
    
    
            
    public HBox getTable(ObservableList<Czynnik> czynniki){
        
        /*
     czynniki wejsciowe - ozn
        wartosci cent
        jednostki zmiennosci
                poziom wyzszy
                        poziom nizszy
        
        
        
        
        for(Czynnik c : czynniki){
            
            pC.add(c.getJednostka());
            pZ.add(c.getNazwa());
            pW.add(c.getOznaczenie());
            pN.add(Integer.toString(c.getCzynnikId()));
            
        }*/
        
        ListView<String> rowNames = new ListView<>();
        
        ObservableList<String> wiersze = FXCollections.observableArrayList(
                "Czynnik wejściowy", "wartość Centralna", 
                "jednostka zmienności", "poziom wyższy(+)","Poziom Niższy(-)");
        rowNames.setItems(wiersze);
      
        rowNames.fixedCellSizeProperty().set(50); //!!!!!!!!!!!!!!!!!!!!
        
        rowNames.setPrefHeight(252);
        
        
        
        //  System.out.print(rowNames.getStyle());
        
        
       // String style="-fx-font-size:25px";
        
       //  rowNames.setStyle(style);
        
       
        
        
       
      //  rowNames.setStyle("-fx-font-size: 24px; -fx-font-family: 'SketchFlow Print';");
        
                
        ListView<Czynnik> oznListView = getOznRow(); // "czynniki wejściowe" - oznaczenia
        ListView<Czynnik> wCListView = getWCRow();  // wartości centralne
        ListView<Czynnik> jZListView = getJZRow(); // jednostki zmienności
        ListView<Czynnik> pWListView = getPWRow();  // poziom wyzszy
        ListView<Czynnik> pNListView = getPNRow();   // poziom nizszy
        
       
        
        oznListView.setItems(czynniki);
        wCListView.setItems(czynniki);
        jZListView.setItems(czynniki);
        pWListView.setItems(czynniki);
        pNListView.setItems(czynniki);
        
        VBox rowsVBox = new VBox(oznListView,wCListView,jZListView,pWListView,pNListView);
        
        return new HBox(new VBox(rowNames),rowsVBox);
        
       // ListView<Czynnik> listView5 = getNazwaRow();
        
     //   listView5.setItems(czynniki);
        
        
        
        
     /*   
        listView5.setCellFactory((ListView<Czynnik> listView) -> {
            return new ListCell<Czynnik>() {
                @Override
                public void updateItem(Czynnik c, boolean empty) {
                    // Must call super
                   // super.updateItem(item, empty);
                   // int index = this.getIndex();
                    String txt = null;
                    // Format name
                    if (c == null || empty) {
                        // No action to perform
                    } else {
                        txt=c.getNazwa();
                    }
                    
                    this.setText(txt);
                    setGraphic(null);
                }
            };
        });
        */
       // VBox vbox = new VBox(listView5);
        
       
       
        
        
        
    }
    
    
    /*
    // Add a custom cell factory to display formatted names of persons
    persons.setCellFactory (
             
        new Callback<ListView<Person>,ListCell<Person>>() {
 @Override
        public ListCell<Person> call
        (ListView<Person> listView
        
            ) {
 return new ListCell<Person>() {
                @Override
                public void updateItem(Person item, boolean empty) {
                    // Must call super
                    super.updateItem(item, empty);
                    int index = this.getIndex();
                    String name = null;
                    // Format name
                    if (item == null || empty) {
                        // No action to perform
                    } else {
                        name = (index + 1) + ". "
                                + item.getLastName() + ", "
                                + item.getFirstName();
                    }

                    this.setText(name);
                    setGraphic(null);
                }
            };
        }
    }

    );
    */
    
    
    private ListView<Czynnik> getNazwaRow(){
        ListView<Czynnik> row =newRow();
        
        
        row.setCellFactory((ListView<Czynnik> listView) -> {
            return new ListCell<Czynnik>() {
                
                
                public void updateItem(Czynnik c,boolean empty) {
                    super.updateItem(c, empty);
                    String txt = null;
                    if(c==null || empty){
                        
                    }
                    else{
                        txt=c.getNazwa();
                        
                    }
                    this.setText(txt);
                }
            };
        });
        
        
        return row;
    }
   
    
    
    
    
    private ListView<Czynnik> newRow(){
        ListView row = new ListView();
        row.setOrientation(Orientation.HORIZONTAL);
      //  row.fixedCellSizeProperty().set(25);
       
        row.setPrefSize(200,50);
        return row;
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

    private ListView<Czynnik> getOznRow() {
        ListView<Czynnik> row =newRow();
        
        
        row.setCellFactory((ListView<Czynnik> listView) -> {
            return new ListCell<Czynnik>() {
                
                public void updateItem(Czynnik c,boolean empty) {
                    super.updateItem(c, empty);
                    String txt = null;
                    if(c==null || empty){
                        
                    }
                    else{
                        txt=c.getOznaczenie();
                         
                         this.setPrefWidth(30);
                    }
                    this.setText(txt);
                }
            };
        });
        
        
        return row;
    }

    private ListView<Czynnik> getWCRow() {
        ListView<Czynnik> row =newRow();
        
        
        row.setCellFactory((ListView<Czynnik> listView) -> {
            return new ListCell<Czynnik>() {
                
                public void updateItem(Czynnik c,boolean empty) {
                    super.updateItem(c, empty);
                    String txt = null;
                    if(c==null || empty){
                        
                    }
                    else{
                        txt=Double.toString(c.getWartoscCentralna());
                        
                        
                    }
                    this.setText(txt);
                }
            };
        });
        
        
        return row;
    }

    private ListView<Czynnik> getJZRow() {
        ListView<Czynnik> row =newRow();
        
        
        row.setCellFactory((ListView<Czynnik> listView) -> {
            return new ListCell<Czynnik>() {
                
                

                

                
                
                public void updateItem(Czynnik c,boolean empty) {
                    super.updateItem(c, empty);
                    String txt = null;
                    if(c==null || empty){
                        
                    }
                    else{
                        txt=c.getJednostkaZmiennosci();
                        
                    }
                    
                    this.setText(txt);
                }
            };
        });
        
        
        return row;
    }

    private ListView<Czynnik> getPWRow() {
        ListView<Czynnik> row =newRow();
        
        
        row.setCellFactory((ListView<Czynnik> listView) -> {
            return new ListCell<Czynnik>() {
                
                public void updateItem(Czynnik c,boolean empty) {
                    super.updateItem(c, empty);
                    String txt = null;
                    if(c==null || empty){
                        
                    }
                    else{
                        txt=Double.toString(c.getWartoscMax());
                        
                    }
                    this.setText(txt);
                }
            };
        });
        
        
        return row;
    }

    private ListView<Czynnik> getPNRow() {
        ListView<Czynnik> row =newRow();
        
        
        row.setCellFactory((ListView<Czynnik> listView) -> {
            return new ListCell<Czynnik>() {
                
                public void updateItem(Czynnik c,boolean empty) {
                    super.updateItem(c, empty);
                    String txt = null;
                    if(c==null || empty){
                        
                    }
                    else{
                        txt=Double.toString(c.getWartoscMin());
                        
                    }
                    this.setText(txt);
                }
            };
        });
        
        
        return row;
        
    }
    
}
