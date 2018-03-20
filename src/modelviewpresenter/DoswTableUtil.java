package modelviewpresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;


public class DoswTableUtil {

    private int lastColId = -1;

//	private List<TableColumn> getColumns(){
//		List l = null;
//                return l;
//	}
    public List<TableColumn<Dosw,String>> getNewColumns(int nr) {
        List<TableColumn<Dosw,String>> newColumns = new ArrayList();
        for (int i = 0; i < nr; i++) {

            newColumns.add(getColumn(++lastColId));

        }
        return newColumns;
    }

    private TableColumn getColumn(int id) {

        // CELL FACTORY ; EDITABLE TEXT FIELD
        // CELL FACTORY ; EDITABLE TEXT FIELD
        // CELL FACTORY ; EDITABLE TEXT FIELD
        TableColumn<Dosw, String> tc = new TableColumn<>();

        tc.setText("pomiar " + Integer.toString(id+1));
      //  tc.setEditable(true);

        tc.setCellValueFactory((TableColumn.CellDataFeatures<Dosw, String> param) -> param.getValue().getPomiar(id));

        tc.setCellFactory(TextFieldTableCell.forTableColumn());
        
        tc.setOnEditCommit((CellEditEvent<Dosw, String> event) -> {
            ((Dosw) event.getTableView().getItems().get(
                    event.getTablePosition().getRow())).setPomiar(event.getTablePosition().getColumn(), event.getNewValue());
            
        });

//        tc.setOnEditCancel((CellEditEvent<Dosw, String> event) -> {
//            ((Dosw) event.getTableView().getItems().get(
//                    event.getTablePosition().getRow())).setPomiar(event.getTablePosition().getColumn(), event.getNewValue());
//        });
        

        //lastColId++;
        return tc;
    }

    public void del(int diff) {
        lastColId = lastColId - diff;
    }

    List<TableColumn<Dosw,String>> getWarColumns() {
        List<TableColumn<Dosw,String>> warColList = new ArrayList();
        TableColumn sredniaYCol = new TableColumn("Średnia y");
        TableColumn lnSredniaYCol = new TableColumn("ln z śr Y)");
        
        sredniaYCol.setCellValueFactory(new PropertyValueFactory<>("sredniaY"));
        lnSredniaYCol.setCellValueFactory(new PropertyValueFactory<>("lnSredniaY"));
        
        warColList.add(sredniaYCol);
        warColList.add(lnSredniaYCol);
        
        return warColList;
        
    }
    
    
    
    
    
    
}


