package modelviewpresenter;


import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

public class Plan{

        private final List<Character> x;
        private int size=0;
       
        Plan(List<Character> line){
            x=new ArrayList();
            this.x.add('+');
            for(char c: line){
                x.add(c);
            }
            this.size=x.size();
            
            
            
            
        }
        
        
        
        public int getSize(){
            return size;
        }

        ObservableValue<String> getX(int k) {
            return new SimpleStringProperty(Character.toString(x.get(k)));
            
               
        }
        
        public int getMnoznik(int id){
            int mnoznik=1;
            
            if(x.get(id)=='-')mnoznik=-1;
            else if(x.get(id)=='+')mnoznik=+1;
            
            return mnoznik;
        }
       
    }