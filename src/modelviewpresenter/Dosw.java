package modelviewpresenter;


import java.util.ArrayList;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;



public class Dosw {
         ArrayList<Double> yyy; //pomiary , powtórzeń doświadczenia
         DoubleProperty sredniaY;
         DoubleProperty lnSredniaY;

         /*
        pom,iarya powtorzenia
          */
         
         
        Dosw(int i) {
            yyy=new ArrayList();
            sredniaY=new SimpleDoubleProperty(4);
            lnSredniaY=new SimpleDoubleProperty(3);
            
            for(int j=0;j<i;j++){
             //  yyy.add(0.0);
            }
            
        }
        
        void setPomiar(int id, String pomiar){
            
           yyy.set(id, Double.parseDouble(pomiar));
            
        }
        
        
        
        
                
        void printAll(){
            
                System.out.println(yyy);
            
        }

        void addPomiar(int addInt) {
            for(int i=0;i<addInt;i++){
                yyy.add(0.0);
            }
        }
        void deletePomiar(int delInt){
            for(int i=0;i<delInt;i++){
                yyy.remove(yyy.size()-1);
            }
        }

        ObservableValue<String> getPomiar(int k) {
            return new SimpleStringProperty(Double.toString(yyy.get(k)));
        }

        private void srednie() {
            double sumaY=0;
            int liczbaY=0;
            double srednia;
            double ln;
            
            for(double d : yyy){
                sumaY=sumaY+d;
                
            }
            liczbaY=yyy.size();
            
            
            srednia=sumaY/liczbaY;
            
            ln=Math.log(srednia);
            
            sredniaY.set(srednia);
            lnSredniaY.set(ln);
            
            
            
            
           // wariancje.refresh();  ????????????????
            
            
            
            
        }
        
        public double getSredniaY(){
            return this.sredniaY.get();
        }
        public void setSredniaY(double sredniay){
            this.sredniaY.set(sredniay);
        }
        public double getLnSredniaY(){
            return this.lnSredniaY.get();
        }
        public void setLnSredniaY(double lnsredniay){
            this.lnSredniaY.set(lnsredniay);
        }
        
        
        
        
    }