/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelviewpresenter.myexceptions;

import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 *
 * @author lg
 */
public class EmptyFieldException extends Throwable {
    VBox cause;
    
    public EmptyFieldException(VBox causeField){
        this.cause=causeField;
    }
    
    public EmptyFieldException(TextField causeField){
        
    }
    
    public VBox getCauseField(){
        return cause;
    }
}
