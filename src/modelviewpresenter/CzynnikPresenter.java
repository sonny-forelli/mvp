/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelviewpresenter;


import java.util.ArrayList;
import java.util.List;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
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
    
    private final CzynnikWynik czynnikWynikowy;
    private final CzynnikWynikView czynnikWynikView;
    
    private  CzynnikWartosciView cwView;
    
    
    
    public CzynnikPresenter(ObservableList czynniki, CzynnikView czynnikView, CzynnikWynik czynnikWynik, CzynnikWynikView czynnikWynikView,
                                CzynnikWartosciView cwView){
        this.czynniki=czynniki;
        this.czynnikView=czynnikView;
        this.czynnikWynikowy = czynnikWynik;
        this.czynnikWynikView = czynnikWynikView;
        this.cwView=cwView;
        
       attachEvents();
    }

    private void attachEvents() {
        
        czynnikView.addButton.setOnAction(e -> addCzynnik());
        czynnikWynikView.zapiszButton.setOnAction(e -> saveCzynnikWynik());
        czynnikWynikView.wyczyscButton.setOnAction(e -> wyczyscButtonClick());
        
    }

    private void addCzynnik() {
        try{
                    czynnikView.clearErrors();
                    checkFields(); ////////THROWS EXCEPTIONS
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

    private void saveCzynnikWynik() {
        czynnikWynikowy.setNazwa(czynnikWynikView.nazwaTextField.getText());
        czynnikWynikowy.setOznaczenie(czynnikWynikView.oznaczenieTextField.getText());
        czynnikWynikowy.setJednostka(czynnikWynikView.jednostkaTextField.getText());
        
       // this.cwView.update(czynniki);
    }

    private void wyczyscButtonClick() {
        czynnikWynikView.nazwaTextField.clear();
        czynnikWynikView.oznaczenieTextField.clear();
        czynnikWynikView.jednostkaTextField.clear();
    }

    
    
}
