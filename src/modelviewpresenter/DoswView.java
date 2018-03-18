package modelviewpresenter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DoswView extends VBox {

    private final ObservableList<Dosw> doswiadczenia;

    final ChoiceBox liczbaPowtorzenCB = new ChoiceBox(FXCollections.observableArrayList(
            0, 1, 2, 3, 4, 5)
    );

    private TableView<Dosw> doswTable;

    private final DoswTableUtil dtu;

    public DoswView(ObservableList<Dosw> doswiadczenia) {
        
        

        this.doswiadczenia = doswiadczenia;
        this.dtu = new DoswTableUtil();
         this.getChildren().add(liczbaPowtorzenCB);
        createTables();
       
        

    }

    private void createTables() {
        doswTable = new TableView(doswiadczenia);
        doswTable.setEditable(true);
        doswTable.setPlaceholder(new Label("dfskjdfkjskljs"));
        
        TableView wariancjeTable = new TableView(doswiadczenia);
        //                create wariancjeTable

        

        this.getChildren().add(new HBox(doswTable, wariancjeTable));
    }

    public void updateDoswTable(int diff, boolean add) {

        if (add) {
            doswTable.getColumns().addAll(dtu.getNewColumns(diff));

        } else {
            int siz = doswTable.getColumns().size();
            doswTable.getColumns().remove(siz - diff, siz);

            dtu.del(diff);

        }

    }

    void update() {
        
    }
}
	