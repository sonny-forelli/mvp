package modelviewpresenter;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
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

        tc.setText("pomiar " + Integer.toString(id));

        tc.setCellValueFactory((TableColumn.CellDataFeatures<Dosw, String> param) -> param.getValue().getPomiar(id));

        tc.setCellFactory(TextFieldTableCell.forTableColumn());
        tc.setOnEditCommit((CellEditEvent<Dosw, String> event) -> {
            ((Dosw) event.getTableView().getItems().get(
                    event.getTablePosition().getRow())).setPomiar(event.getTablePosition().getColumn(), event.getNewValue());
        });

        //lastColId++;
        return tc;
    }

    public void del(int diff) {
        lastColId = lastColId - diff;
    }
}
