/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelviewpresenter;

import javafx.collections.ObservableList;

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
    }
    
}
