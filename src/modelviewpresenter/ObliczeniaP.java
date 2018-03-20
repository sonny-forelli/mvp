/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelviewpresenter;

import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author lg
 */
public class ObliczeniaP {
    private final ObliczeniaView obliczeniaView;
    
    
    
    private final ObservableList<Czynnik> czynniki;
    private final ObservableList<CzynnikKod> kody;
    private final ObservableList<WspRegr> wspolczynnikiRegr;
    private final ObservableList<Plan> plany;
    private final ObservableList<Dosw> doswiadczenia;
    
    public ObliczeniaP( ObliczeniaView obliczeniaView, 
                        ObservableList<Czynnik> czynniki, 
                        ObservableList<CzynnikKod> kody, 
                        ObservableList<WspRegr> wspolczynnikiRegr,
                        ObservableList<Plan> plany,
                        ObservableList<Dosw> doswiadczenia){
        
        
        this.obliczeniaView=obliczeniaView;
        this.czynniki=czynniki;
        this.kody=kody;
        this.wspolczynnikiRegr=wspolczynnikiRegr;
        this.plany=plany;
        this.doswiadczenia=doswiadczenia;
        
    }
    
    void update(){
        oblicz();
        obliczeniaView.update();
    }

    void oblicz() {
        kody.clear();
        wspolczynnikiRegr.clear();
        
        wspolczynnikiRegr.add(new WspRegr(0,(int)Math.pow(2, czynniki.size()),plany,doswiadczenia));

        
        for(Czynnik c : czynniki){
            kody.add(new CzynnikKod(c));
            wspolczynnikiRegr.add(new WspRegr(c.getCzynnikId(),(int)Math.pow(2, czynniki.size()),plany,doswiadczenia));
            
            
            
        }
        
        
    }
    
    
    
    
}
