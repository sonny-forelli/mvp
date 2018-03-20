package modelviewpresenter;

import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;






public class ObliczeniaView extends VBox {
	
	private final Label labels1Header = new Label("1. Kodowanie czynników:");
	private final Label labels2Header = new Label("2. Obliczenie współczynników regresji:");
	private final Label labels3Header = new Label("3. Uzyskano model matematyczny w postaci zakodowanej:");
	private final Label labels4Header = new Label("4. Po odkodowaniu");
	
	private VBox labels1 = new VBox(); // kodowanie czynników
	private VBox labels2 = new VBox();//współczynniki regresji
	private VBox labels3 = new VBox(); // model zakodowany
        private VBox labels4 = new VBox();
	
	private final ObservableList<CzynnikKod> kody;
        private final ObservableList<WspRegr> wspolczynnikiRegr;
        private final ObservableList<Czynnik> czynniki;
	
	
	public ObliczeniaView (ObservableList<CzynnikKod> kody, ObservableList<WspRegr> wsp, ObservableList<Czynnik> czynniki) {
		
		this.kody=kody;
		this.wspolczynnikiRegr=wsp;
		this.czynniki=czynniki;
		
		setLabels();
		
                this.getStyleClass().add("tab4");
		
		this.getChildren().addAll(labels1Header,labels1,labels2Header,labels2,labels3Header,labels3,labels4Header,labels4);
	}
	
	private void setLabels(){
		labels1.getChildren().clear();
		labels2.getChildren().clear();
		labels3.getChildren().clear();
                labels4.getChildren().clear();
		
		
		for(CzynnikKod kod : kody){
			labels1.getChildren().add(new Label(kod.getFullString()));
		}
		for(WspRegr wspRegr : wspolczynnikiRegr){
			labels2.getChildren().add(new Label(wspRegr.getFullString()));
			
		}
                
                labels3.getChildren().add(new Label(getModel()));
                labels4.getChildren().add(new Label(getModelOdkod()));
                
		
	}
	
	public void update(){
		setLabels();
		
		
	}

    private String getModel() {
        String model="y=";
        if(wspolczynnikiRegr.size()<1)return model;
        model+=Double.toString(wspolczynnikiRegr.get(0).getWspRegr());
        for(int i=1;i<wspolczynnikiRegr.size();i++){
            model+=Double.toString(wspolczynnikiRegr.get(i).getWspRegr());
            model+=" x"+i;
        }
        return model;
        
    }

    private String getModelOdkod() {
        
        String model="y=";
        if(wspolczynnikiRegr.size()<1)return model;
        model+=Double.toString(wspolczynnikiRegr.get(0).getWspRegr());
        for(int i=1;i<wspolczynnikiRegr.size();i++){
            model+=Double.toString(wspolczynnikiRegr.get(i).getWspRegr());
            model+=kody.get(i-1).getKod();
        }
        return model;
    }
	
	
	
	
	
	
	
	
}