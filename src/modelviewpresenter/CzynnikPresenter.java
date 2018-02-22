/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelviewpresenter;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import modelviewpresenter.myexceptions.EmptyFieldException;

/**
 *
 * @author lg
 */
public class CzynnikPresenter {
    private final ObservableList<Czynnik> czynniki;
    private final CzynnikView czynnikView;
    
    public CzynnikPresenter(ObservableList czynniki, CzynnikView czynnikView){
        this.czynniki=czynniki;
        this.czynnikView=czynnikView;
        
        
        attachEvents();
    }

    private void attachEvents() {
        
        czynnikView.addButton.setOnAction(e -> addCzynnik());
        
    }

    private void addCzynnik() {
        try{
                    checkFields();
                    clearErrors();
                    czynniki.add(new Czynnik(
                        //czynniki.size()+1,
                        czynnikView.addNazwa.getText(),
                        czynnikView.addOzn.getText(),
                        Float.parseFloat(czynnikView.addWmin.getText()),
                        Float.parseFloat(czynnikView.addWmax.getText()),
                        czynnikView.addJedn.getText()));
                    
                    czynnikView.addNazwa.clear();
                    czynnikView.addOzn.clear();
                    czynnikView.addWmin.clear();
                    czynnikView.addWmax.clear();
                    czynnikView.addJedn.clear();
                    
                    
                    
                                  
                }catch(EmptyFieldException e){
                    Label emptyFieldLabel = new Label("empty field");
                    emptyFieldLabel.setTextFill(Color.RED);
                    e.getCauseField().getChildren().add(emptyFieldLabel);
                    
                  
                  
                  
                  
                }catch(Throwable e){
                    
                    alert.setContentText("asdfdsf");
                    
                    alert.showAndWait();
                    System.out.println(e);
                    
                }
        
    }

    private void checkFields() throws EmptyFieldException {
       
        /*
        for(TextField textField : czynnikView.addTextFieldList){
            if(textField.getLength()<1){
                
                throw new EmptyFieldException(textField));
                
            }
        }
        */
        if(czynnikView.addNazwa.getLength()<1){
            throw new EmptyFieldException(czynnikView.nazwaVBox);
        }
        if(czynnikView.addOzn.getLength()<1){
            throw new EmptyFieldException(czynnikView.oznVBox);
        }
        if(czynnikView.addWmin.getLength()<1){
            throw new EmptyFieldException(czynnikView.wminVBox);
        }
        if(czynnikView.addWmax.getLength()<1){
            throw new EmptyFieldException(czynnikView.wmaxVBox);
        }
        if(czynnikView.addJedn.getLength()<1){
            throw new EmptyFieldException(czynnikView.jednVBox);
        }
        
        
        
        
        
       
        
        
    }

    private void clearErrors() {
        
    }
    
}
