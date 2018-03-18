//private void GUI(final MyData myData, Group root) {
//        CzynnikView czynnikView = new CzynnikView(myData.getCzynniki());
//        CzynnikWynikView czynnikWynikView = new CzynnikWynikView(myData.getCzynnikWynik());
//        CzynnikWartosciView cwView = new CzynnikWartosciView(myData.getCzynniki());
//        
//        CzynnikPresenter czynnikPresenter = new CzynnikPresenter(myData.getCzynniki(),czynnikView,myData.getCzynnikWynik(),czynnikWynikView,cwView);
//        
//        
//        
//        
//        
//        
//        Button checkButton = new Button("CHECK");
//        checkButton.setOnAction(e -> checkButtonClick(myData.getCzynniki().size()));
//        
//        checkButton.setDisable(false);
//        
//        VBox myViews = new VBox();
//        
//        
//        myViews.getChildren().addAll(checkButton,czynnikView,czynnikWynikView,cwView);
//        
//        TabPane tabPane = new TabPane();
//        tabPane.getStyleClass().add("table1");
//        
//        Tab tab1 = new Tab("11111111");
//        tab1.setContent(myViews);
//        tab1.setClosable(false);
//        
//        Tab tab2 = new Tab("22222");
//        tab2.setClosable(false);
//        
//        tabPane.getTabs().addAll(tab1,tab2);
//        
//        
//        
//        //CSS
//        
//        checkButton.getStyleClass().add("my-button");
//        
//        /////
//        
//        root.getChildren().add(tabPane);
//        root.getStyleClass().add("root");
//    }