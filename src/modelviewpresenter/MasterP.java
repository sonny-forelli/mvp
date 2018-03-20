/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelviewpresenter;

/**
 *
 * @author lg
 */
public class MasterP {
//    
//    BES SĘSU
//    
//  
    private final CzynnikPresenter cp;
    private final DoswPresenter dp;
    
     MasterP(CzynnikPresenter cp, DoswPresenter dp){
        
        this.cp=cp;
        this.dp=dp;
        
    }
    
    void lcChange(){
        dp.update();
    }
    
}
