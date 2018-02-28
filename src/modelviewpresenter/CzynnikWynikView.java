/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelviewpresenter;

import javafx.beans.Observable;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author lg
 */
public class CzynnikWynikView extends VBox{
    private final CzynnikWynik czynnikWynik;
    
    private final Label czynnikWynikowyLabel = new Label("czynnik wynikowy");
    
    private final Label nazwaLabel = new Label ("Nazwa");
    private final Label oznaczenieLabel = new Label("Oznaczenie");
    private final Label jednostkaLabel = new Label("Jednostka");
    
    private final TextField nazwaTextField = new TextField();
    private final TextField oznaczenieTextField = new TextField();
    private final TextField jednostkaTextField = new TextField();
    
    private final Button zapiszButton = new Button("Zapisz");
    private final Button wyczyscButton = new Button("Wyczyść");
    
    private final HBox czynnikWynikowyHBox = new HBox(czynnikWynikowyLabel);
    
    private final VBox nazwaVBox = new VBox(nazwaLabel,nazwaTextField);
    private final VBox oznaczenieVBox = new VBox(oznaczenieLabel,oznaczenieTextField);
    private final VBox jednostkaVBox = new VBox(jednostkaLabel,jednostkaTextField);
    
    private final HBox addHBox = new HBox(zapiszButton,wyczyscButton);
    
    

    private final HBox czynnikWynikHBox = new HBox(nazwaVBox,oznaczenieVBox,jednostkaVBox,addHBox);
    
    
    
    
    
    
    
    public CzynnikWynikView(CzynnikWynik czynnikWynik){
        this.czynnikWynik = czynnikWynik;
        setLabel();
        setLabels();
        setTextFields();
        addHBox.alignmentProperty().set(Pos.BOTTOM_CENTER);
        
        
        this.getChildren().add(czynnikWynikHBox);
        
    }

    private void setLabel() {
        czynnikWynikowyLabel.setTextFill(Color.BLUE);
        czynnikWynikowyLabel.setAlignment(Pos.CENTER);
        czynnikWynikowyHBox.setAlignment(Pos.CENTER);
        this.getChildren().add(czynnikWynikowyHBox);
    }

    private void setLabels() {
        oznaczenieLabel.alignmentProperty().set(Pos.CENTER);
        oznaczenieVBox.setAlignment(Pos.CENTER);
    }

    private void setTextFields() {
        czynnikWynikHBox.setAlignment(Pos.CENTER);
        
    }

    
    
    
}
