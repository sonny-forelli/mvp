package modelviewpresenter;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;

public class WspRegr {

    private double wspRegr;

    private int N;
    private final int id;

    private String fullString;

    private final List<Double> logarytmy;
    private final List<Integer> mnozniki;

    public WspRegr(int id, int N, List<Double> logarytmy, List<Integer> mnozniki) {

        if (logarytmy.size() != N || mnozniki.size() != N) {
            System.out.println("wsp regr error");
        }

        this.N = N;
        this.id = id;
        this.logarytmy = logarytmy;
        this.mnozniki = mnozniki;

        licz();
    }

    public WspRegr(int id, int N, ObservableList<Plan> plany, ObservableList<Dosw> doswiadczenia) {

        this.N = N;
        this.id = id;

        mnozniki = new ArrayList();
        logarytmy = new ArrayList();

        for (Plan p : plany) {

            mnozniki.add(p.getMnoznik(id));

        }

        for (Dosw d : doswiadczenia) {

            logarytmy.add(d.getLnSredniaY());

        }
        
        licz();

    }

    private void licz() {
        N=mnozniki.size();

        fullString = "";
        double wynik = 0;
        double sumaWsp = 0;
        fullString += "b" + Integer.toString(id) + "=1/" + Integer.toString(N) + "*(";

        for (int j = 0; j < logarytmy.size(); j++) {
            double wsp = logarytmy.get(j) * mnozniki.get(j);
            String znak = "";
            if (wsp >= 0 && j != 0) {
                znak = "+";
            }
            fullString += znak + " " + Double.toString(wsp) + " ";
            sumaWsp += wsp;

        }
        double doubleN = N;

        fullString += ") = ";
        wynik = (1 / doubleN) * sumaWsp;

        wspRegr = wynik;
        fullString += Double.toString(wynik);

    }

    /**
     * @return the wspRegr
     */
    public double getWspRegr() {
        return wspRegr;
    }

    /**
     * @return the fullString
     */
    public String getFullString() {
        return fullString;
    }
}

    /* String finalString="";
        double wynik=0;
        double sumaWsp=0;
        finalString+="b"+Integer.toString(i)+"=1/"+Integer.toString(N)+"*(";
        
        for(int j=0;j<pomiary.size();j++){
            double wsp = pomiary.get(j).getLnSredniaY()*plany.get(j).getMnoznik(i);
            String znak="";
            if(wsp>=0&&j!=0)znak="+";
            finalString+=znak+" "+Double.toString(wsp)+" ";
            sumaWsp+=wsp;
            
            
            
        }
        double doubleN=N;
        
        finalString+=") = ";
        wynik=(1/doubleN)*sumaWsp;
        
        System.out.println(wynik);
        
        wspolczynnikiRegresji.add(wynik);
        finalString+=Double.toString(wynik); */
