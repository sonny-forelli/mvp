package modelviewpresenter;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TableColumn;

class MatrycaPlanowUtil {

    private int liczbaCzynnikow;

    public MatrycaPlanowUtil(int n) {
        this.liczbaCzynnikow = n;
    }

    public List<TableColumn<Plan, String>> getColumnsList() {

        List<TableColumn<Plan, String>> columns = new ArrayList();

        TableColumn lpCol = new TableColumn("lp");
        columns.add(lpCol);
        for (int i = 0; i <= liczbaCzynnikow; i++) {
            int k = i;

            TableColumn<Plan, String> tc = new TableColumn<Plan, String>("x" + Integer.toString(k));
            tc.setCellValueFactory((TableColumn.CellDataFeatures<Plan, String> p) -> p.getValue().getX(k));
            columns.add(tc);

        }

        return columns;

    }
}
