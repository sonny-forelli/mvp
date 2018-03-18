package modelviewpresenter;

import javafx.beans.binding.IntegerBinding;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;









public class PlanView extends VBox {
	
	private final ObservableList<Plan> plany;
	
	private final Label planyLabel = new Label("matryca planów");
	
	private final TableView<Plan> matrycaPlanow;
        
        private final IntegerBinding liczbaCzynnikow;
	
	public PlanView(ObservableList plany, IntegerBinding liczbaCzynnikow) {
		
		this.plany=plany;
		this.liczbaCzynnikow=liczbaCzynnikow;
                
                matrycaPlanow = new TableView(this.plany);
		setMatrycaPlanow();
		
		this.getChildren().add(planyLabel);
		this.getChildren().add(matrycaPlanow);
		
	}
	
	public void update(){
		setMatrycaPlanow();
		
		
		
	}


       
	
	private void setMatrycaPlanow(){
		
		 MatrycaPlanowUtil mpu = new MatrycaPlanowUtil(liczbaCzynnikow.get());
		 
		 matrycaPlanow.getColumns().clear();
		 
		matrycaPlanow.getColumns().addAll(mpu.getColumnsList());
		
        }
		
	}
	/*
	void variation(ArrayList<Character> input, int depth, ArrayList<Character> output) {
        if (depth == 0) {
            System.out.println(output);
            plany.add(new Plan(output));
            
            
        } else {
            for (int i = 0; i < input.size(); i++) {
                output.add(input.get(i));
                variation(input, depth - 1, output);
                output.remove(output.size() - 1);
            }
        }
    }
	*/
	
	