/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelviewpresenter;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author lg
 */
public class CzynnikView extends VBox{
    
    private final ObservableList<Czynnik> czynniki;
    
    
    //
    
    //d
    
    
    final TextField addNazwa = new TextField();
    final TextField addOzn = new TextField();
    final TextField addWmin = new TextField();
    final TextField addWmax = new TextField();
    final TextField addJedn = new TextField();
    
    
    
    final Button addButton = new Button("Dodaj");
        
    //errors
    
    final VBox nazwaVBox = new VBox(addNazwa);
    final VBox oznVBox = new VBox(addOzn);
    final VBox wminVBox = new VBox(addWmin);
    final VBox wmaxVBox = new VBox(addWmax);
    final VBox jednVBox = new VBox(addJedn);
    
    
    
    public CzynnikView(ObservableList czynniki){
        this.czynniki = czynniki;
        setTable(this.czynniki);
        setAddBox();
        
    }

    private void setAddBox() {
        
        HBox addHBox = new HBox();
        
        
        addNazwa.setPromptText("Nazwa");
       // addNazwa.setMaxWidth(nazwaCol.getPrefWidth());
        
        addOzn.setPromptText("oznaczenie");
      //  addOzn.setMaxWidth(oznCol.getPrefWidth());
        
        addWmin.setPromptText("wart Min");
      //  addWmin.setMaxWidth(wminCol.getPrefWidth());
        
        addWmax.setPromptText("Wart max");
     //   addWmax.setMaxWidth(wmaxCol.getPrefWidth());
       
        addJedn.setPromptText("jednostka");
      //  addJedn.setMaxWidth(jednCol.getPrefWidth());
        
        
        
        
        
        
        // BUTTON SET ON ACTIOn
        /*
        
        nie tu
        w presetner
        
        
        */
        
        
        addHBox.getChildren().addAll(nazwaVBox,oznVBox,wminVBox,wmaxVBox,jednVBox);
        
        this.getChildren().add(addHBox);
        

    }

    private void setTable(ObservableList dane) {
        TableView czynnikiTable = new TableView(dane);
        czynnikiTable.getColumns().addAll(CzynnikTableUtil.getIdColumn(),
                                          CzynnikTableUtil.getNazwaColumn(),
                                          CzynnikTableUtil.getWartoscColumn(),
                                          CzynnikTableUtil.getJednostkaColumn());
        
        this.getChildren().add(czynnikiTable);
        
    }
    
    
    
    
}
