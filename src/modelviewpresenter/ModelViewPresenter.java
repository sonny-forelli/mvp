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
import javafx.scene.layout.HBox;
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
       
       
       final MyData myData = new MyData();
       Group root = new Group();
       //Group root = GUI(myData);//returns Group
       //22 Group root = new Group(); GUI(root,myData);
        GUI(myData, root);
        
        Scene scene = new Scene(root);       
        
        
        
        scene.getStylesheets().add("mystyle.css");
        
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void GUI(final MyData myData, Group root) {
        CzynnikView czynnikView = new CzynnikView(myData.getCzynniki());
        CzynnikWynikView czynnikWynikView = new CzynnikWynikView(myData.getCzynnikWynik());
        CzynnikWartosciView cwView = new CzynnikWartosciView(myData.getCzynniki());
        
        CzynnikPresenter czynnikPresenter = new CzynnikPresenter(myData.getCzynniki(),czynnikView,myData.getCzynnikWynik(),czynnikWynikView,cwView);
        
        
        //////////////////////
        
        PlanView planView = new PlanView(myData.getPlany(),myData.getLiczbaCzynnikow());
        DoswView doswView = new DoswView(myData.getDoswiadczenia());
        
        DoswPresenter doswPresenter = new DoswPresenter(myData.getPlany(),planView,myData.getDoswiadczenia(),doswView,myData.getLiczbaCzynnikow());
        
        
        MasterP mp = new MasterP(czynnikPresenter,doswPresenter);
        
        czynnikPresenter.setMP(mp);
        doswPresenter.setMP(mp);
        
        HBox tab3views = new HBox(planView,doswView);
        
        //////////////////////
        
        
        
        
        
        Button checkButton = new Button("CHECK");
        checkButton.setOnAction(e -> checkButtonClick(myData.getCzynniki().size(),myData.getDoswiadczenia()));
        
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
        
        Tab tab3 = new Tab("333");
        
        
        
        tab3.setContent(tab3views);
        tab3.setClosable(false);
        
        tabPane.getTabs().addAll(tab1,tab2,tab3);
        
        tab3.setOnSelectionChanged(e-> doswView.refresh());
        
        
        //CSS
        
        checkButton.getStyleClass().add("my-button");
        
        /////
        
        root.getChildren().add(tabPane);
        root.getStyleClass().add("root");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void checkButtonClick(int size, ObservableList<Dosw> doswiadczenia) {
        System.out.println(size);
        System.out.print(doswiadczenia);
       
        
    }
    
}
