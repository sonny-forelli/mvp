/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelviewpresenter;

import com.sun.prism.impl.Disposer.Record;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.function.Function;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Callback;

/**
 *
 * @author lg
 */
public class CzynnikView extends VBox{
    
    private final ObservableList<Czynnik> czynniki;
    
    
    private final Label labelDaneWejsciowe = new Label("wejściowe");
    
    //
    
    //d
    
    
    final TextField addNazwa = new TextField();
    final TextField addOzn = new TextField();
    final TextField addWmin = new TextField();
    final TextField addWmax = new TextField();
    final TextField addJedn = new TextField();
    
    final List<TextField> addTextFieldList = Arrays.asList(addNazwa,addOzn,
                                                    addWmin,addWmax,addJedn);
    
    
    final Button addButton = new Button("Dodaj");
        
    //errors
    
     VBox nazwaVBox = new VBox(addNazwa);
     VBox oznVBox = new VBox(addOzn);
     VBox wminVBox = new VBox(addWmin);
     VBox wmaxVBox = new VBox(addWmax);
     VBox jednVBox = new VBox(addJedn);
     
     final List<VBox> addVBoxList = Arrays.asList(nazwaVBox,oznVBox,
                                                    wminVBox,wmaxVBox,jednVBox);
    
    
    
    public CzynnikView(ObservableList czynniki){
        this.czynniki = czynniki;
        setLabel();
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
        
        
        addHBox.getChildren().addAll(nazwaVBox,oznVBox,wminVBox,wmaxVBox,jednVBox,addButton);
        
        
        
        this.getChildren().add(addHBox);
        

    }

    private void setTable(ObservableList dane) {
        TableView czynnikiTable = new TableView(dane);
        czynnikiTable.getColumns().addAll(CzynnikTableUtil.getIdColumn(),
                                          CzynnikTableUtil.getNazwaColumn(),
                                          CzynnikTableUtil.getOznaczenieColumn(),
                                          CzynnikTableUtil.getWartoscColumn(),
                                          CzynnikTableUtil.getJednostkaColumn());
        
        
        
        czynnikiTable.setPlaceholder(new Label("dsfdfsffadsfa"));
        
        czynnikiTable.getStyleClass().add("table2");
        
//***************        
        TableColumn tc = new TableColumn();
        
        tc.setCellFactory(
                new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

            @Override
            public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> p) {
                return new ButtonCell();
            }
        
        });
       
        czynnikiTable.getColumns().add(tc);
//  *****************************      
        

        this.getChildren().add(czynnikiTable);
        
    }
    private void setLabel(){
        labelDaneWejsciowe.setTextFill(Color.BLUE);
        labelDaneWejsciowe.setAlignment(Pos.CENTER);
        this.getChildren().add(labelDaneWejsciowe);
    }

    void clearErrors() {
        for(VBox vbox : addVBoxList){
            if(vbox.getChildren().size()>1)vbox.getChildren().remove(1);
            
        }
    }

    private void setStyles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class ButtonCell extends TableCell<Record, Boolean> {
        final Button cellButton = new Button("Usuń");
        
        
        ButtonCell(){
            
        	//Action when the button is pressed
            cellButton.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent t) {
                    // get Selected Item
                	Czynnik currentPerson = (Czynnik) ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
                	//remove selected item from the table list
                	czynniki.remove(currentPerson);
                }
            });
        }

        //Display button if the row is not empty
        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if(!empty){
                setGraphic(cellButton);
            }
            else setGraphic(null);
            
        }
    }
    
    
    


    
    
    
    
    
}
