/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelviewpresenter.myexceptions;

import javafx.scene.layout.VBox;

/**
 *
 * @author lg
 */
public class BadFormatException extends Throwable {
    VBox causeField;
    public BadFormatException(VBox causeField){
        this.causeField=causeField;
    }
    
    public VBox getCauseField(){
        return causeField;
    }
    
}
