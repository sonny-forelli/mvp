/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelviewpresenter;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author lg
 */
public class ModelViewPresenter extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       ObservableList<Czynnik> czynniki = FXCollections.observableArrayList();
       CzynnikView czynnikView = new CzynnikView(czynniki);
       CzynnikPresenter czynnikPresenter = new CzynnikPresenter(czynniki,czynnikView);
       
       
       CzynnikWynikView czynnikWynikView = new CzynnikWynikView(new CzynnikWynik("sd","sdffds","2"));
       
        Group root = new Group();
       
        Button checkButton = new Button("CHECK");
        checkButton.setOnAction(e -> checkButtonClick(czynniki.size()));
        
        checkButton.setDisable(false);
        
        VBox myViews = new VBox();
        
        myViews.getChildren().addAll(checkButton,czynnikView,czynnikWynikView);
        root.getChildren().add(myViews);
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void checkButtonClick(int size) {
        System.out.println(size);
    }
    
}
