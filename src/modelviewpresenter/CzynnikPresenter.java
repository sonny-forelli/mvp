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
import modelviewpresenter.myexceptions.BadFormatException;
import modelviewpresenter.myexceptions.EmptyFieldException;
import modelviewpresenter.myexceptions.MinMaxException;

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
                    czynnikView.clearErrors();
                    checkFields();
                    czynnikView.clearErrors();
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
                    
                  
                  
                  
                  
                }catch(MinMaxException e){
                    Label label = new Label("wartość minimalna większa od maksymalnej");
                    label.setTextFill(Color.RED);
                    czynnikView.wminVBox.getChildren().add(label);
                }catch(BadFormatException e){
                    Label label = new Label("zły format");
                    label.setTextFill(Color.RED);
                    e.getCauseField().getChildren().add(label);
                }catch(Throwable e){
                    
                    
                    System.out.println(e);
                    
                }
        
    }

    private void checkFields() throws EmptyFieldException, MinMaxException,
                                    BadFormatException{
       
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
            try{
                Float.parseFloat(czynnikView.addWmin.getText());
               
            }catch(Throwable e){
                throw new BadFormatException(czynnikView.wminVBox);
            }
        
        if(czynnikView.addWmax.getLength()<1){
            throw new EmptyFieldException(czynnikView.wmaxVBox);
        }
            try{
                Float.parseFloat(czynnikView.addWmax.getText());
               
            }catch(Throwable e){
                throw new BadFormatException(czynnikView.wmaxVBox);
            }
        
         if(Float.parseFloat(czynnikView.addWmin.getText())
                >
                Float.parseFloat(czynnikView.addWmax.getText())){
            
            throw new MinMaxException();
            
        }
        
        
        if(czynnikView.addJedn.getLength()<1){
            throw new EmptyFieldException(czynnikView.jednVBox);
        }
        
        
       
        
        
       
        
        
    }

    
    
}
