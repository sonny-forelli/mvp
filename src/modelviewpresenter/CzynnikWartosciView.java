/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelviewpresenter;

import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.util.Callback;


/**
 *
 * @author lg
 */
public class CzynnikWartosciView extends VBox{
    ObservableList<Czynnik> czynniki;
    
    private final Label wartosciLabel = new Label("wartości centralne i poziomy");
    
    
    public CzynnikWartosciView(ObservableList<Czynnik> czynniki){
        this.czynniki = czynniki;
        
        loadTable();
        
    }

    private void loadTable() {
        TableView wartosciTable = new TableView(CzynnikWartosciTableUtil.wiersze);
        TableColumn tc = new TableColumn("gggf");
        tc.setCellValueFactory((Callback) CzynnikWartosciTableUtil.wiersze);
        wartosciTable.getColumns().add(tc);
        
        this.getChildren().add(wartosciTable);
        
    }
    
    
    
    
}
