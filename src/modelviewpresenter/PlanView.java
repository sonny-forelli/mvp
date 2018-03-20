package modelviewpresenter;

import javafx.beans.binding.IntegerBinding;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;









public class PlanView extends VBox {
	
	private final ObservableList<Plan> plany;
	
	private final Label planyLabel = new Label("matryca planów");
	
	private final TableView<Plan> matrycaPlanow;
        
        private final IntegerBinding liczbaCzynnikow;
        
        final Button hideColButton = new Button("zwiń");
        
        private boolean colVis = true;
	
	public PlanView(ObservableList plany, IntegerBinding liczbaCzynnikow) {
		
		this.plany=plany;
		this.liczbaCzynnikow=liczbaCzynnikow;
                
                matrycaPlanow = new TableView(this.plany);
                
		setMatrycaPlanow();
		
		
                this.getChildren().add(hideColButton);
		this.getChildren().add(matrycaPlanow);
                this.getChildren().add(planyLabel);
		
	}
	
	public void update(){
		setMatrycaPlanow();
		
		
		
	}


       
	
	private void setMatrycaPlanow(){
		
		 MatrycaPlanowUtil mpu = new MatrycaPlanowUtil(liczbaCzynnikow.get());
		 
		 matrycaPlanow.getColumns().clear();
		 
		matrycaPlanow.getColumns().addAll(mpu.getColumnsList());
//                matrycaPlanow.autosize();
		
        }
        
        void showColumns(){
            
            if(colVis){
                
                colVis=false;
                hideColButton.setText("rozwiń");
                matrycaPlanow.setMaxWidth(35);
                
                
                
            }
            
            
            else{
                colVis=true;
                
                hideColButton.setText("zwiń");
                matrycaPlanow.setMaxWidth(500);
                
                
                
                
            }
            for(int i=1;i<matrycaPlanow.getColumns().size();i++){
                matrycaPlanow.getColumns().get(i).setVisible(colVis);
            }
            
            
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
	
	