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
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
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
       
       
       MyData myData = new MyData();
       
       CzynnikView czynnikView = new CzynnikView(myData.getCzynniki());
       
       CzynnikWynik czynnikWynik = new CzynnikWynik("dsaf","sdfadsf","sdfsd");
       CzynnikWynikView czynnikWynikView = new CzynnikWynikView(czynnikWynik);
       
       CzynnikWartosciView cwView = new CzynnikWartosciView(myData.getCzynniki(),"mvp");
       
       CzynnikPresenter czynnikPresenter = new CzynnikPresenter(myData.getCzynniki(),czynnikView,czynnikWynik,czynnikWynikView,cwView);
       
       
      
       
        Group root = new Group();
       
        Button checkButton = new Button("CHECK");
        checkButton.setOnAction(e -> checkButtonClick(myData.getCzynniki().size()));
        
        checkButton.setDisable(false);
        
        VBox myViews = new VBox();
        
        
        myViews.getChildren().addAll(checkButton,czynnikView,czynnikWynikView,cwView);
        
        TabPane tabPane = new TabPane();
        tabPane.getStyleClass().add("table1");
        
        Tab tab1 = new Tab("11111111");
        tab1.setContent(myViews);
        tab1.setClosable(false);
        
        Tab tab2 = new Tab("22222");
        tab2.setClosable(false);
        
        tabPane.getTabs().addAll(tab1,tab2);
        
        
        
        //CSS
        
        checkButton.getStyleClass().add("my-button");
        
        /////
        
        root.getChildren().add(tabPane);
        root.getStyleClass().add("root");
        
        Scene scene = new Scene(root);
        
        
        
        scene.getStylesheets().add("mystyle.css");
        
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
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
