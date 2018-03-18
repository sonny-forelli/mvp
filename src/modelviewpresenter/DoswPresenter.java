package modelviewpresenter;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;

public final class DoswPresenter {

    

    private final ObservableList<Plan> plany;
    private final PlanView planView;

    private final ObservableList<Dosw> doswiadczenia;
    private final DoswView doswView;
    private final IntegerBinding liczbaCzynnikow;
    private int liczbaPowtorzen=0;

//    private final ObservableList<Czynnik> czynniki;

    public DoswPresenter(ObservableList<Plan> plany, PlanView planView,
            ObservableList<Dosw> doswiadczenia, DoswView doswView,
            IntegerBinding liczbaCzynnikow) {
        this.plany = plany;
        this.planView = planView;

        this.doswiadczenia = doswiadczenia;
        this.doswView = doswView;
        
        this.liczbaCzynnikow=liczbaCzynnikow;

//        this.czynniki = czynniki;

        setPlany();

        attachActions();

    }

    private void attachActions() {

        doswView.liczbaPowtorzenCB.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            //   --->    liczbaPowtorzen=newValue.intValue();
            lpcbUpdate(oldValue.intValue(), newValue.intValue());
            //   doswView.updateDoswTable
        });
    }

    void lpcbUpdate(int oldV, int newV) {
        liczbaPowtorzen=newV;
        if (oldV < 0) {
            oldV = 0;
        }
        if (newV < 0) {
            newV = 0;
        }
        if (newV > oldV) {
            int addInt = newV - oldV;
            doswiadczenia.forEach((d) -> {
                d.addPomiar(addInt);
            });

            doswView.updateDoswTable(addInt, true);

        } else if (newV < oldV) {

            int delInt = oldV - newV;
            doswiadczenia.forEach((d) -> {
                d.deletePomiar(delInt);
            });

            doswView.updateDoswTable(delInt, false);

        }

    } // lpcbUpdate

    private void setPlany() {
        plany.clear();

          ArrayList<Character> znaki = new ArrayList();
          znaki.add('+');
          znaki.add('-');
          
        variation(znaki, liczbaCzynnikow.get(), new ArrayList<Character>());

    }

    private void variation(ArrayList<Character> input, int depth, ArrayList<Character> output) {
        if (depth == 0) {
            System.out.println(output);
            plany.add(new Plan(output));

        } else {
            for (int i = 0; i < input.size(); i++) {
                output.add(input.get(i));
                variation(input, depth - 1, output);
                output.remove(output.size() - 1);
            }
        }
    }

    void update() {
        System.out.print(plany);
        setPlany();
        planView.update();
        
        doswiadczenia.clear();
        
        
        doswView.update();
        
        
    }

    
    
}
