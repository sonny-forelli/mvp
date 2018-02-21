/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelviewpresenter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author lg
 */
public class CzynnikTableUtil {
    
    /*
    
    public static ObservableList<Person> getPersonList() {
        Person p1 = new Person(...,...);
        Person p2 = new Person(...);
        ...
        return FXCollections.<Person>observableArrayList(p1,p2,...);
    
    
    */
    
    /////////////
    
    
    /*
    
    public static ObservableList<Czynnik> getCzynnikList() {
        
        Czynnik c1 = new Czynnik("nazwa1", "ozn1", 1, 11, "jedn1");
        Czynnik c2 = new Czynnik("nazwa2", "ozn2", 2, 22, "jedn2");
        return FXCollections.<Czynnik>observableArrayList(c1, c2);
       
    }
    */
    /////////////
    
    public static TableColumn<Czynnik,Integer> getIdColumn(){
        TableColumn<Czynnik, Integer> czynnikIdCol = new TableColumn<>("Nr");
        czynnikIdCol.setCellValueFactory(new PropertyValueFactory<>("czynnikId"));
        return czynnikIdCol;
    }
    public static TableColumn<Czynnik, String> getNazwaColumn(){
        TableColumn<Czynnik, String> nazwaCol = new TableColumn<>("Nazwa");
        nazwaCol.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        return nazwaCol;
    }
    
    public static TableColumn<Czynnik, String> getOznaczenieColumn(){
        TableColumn<Czynnik, String> oznaczenieCol = new TableColumn<>("Oznaczenie");
        oznaczenieCol.setCellValueFactory(new PropertyValueFactory<>("oznaczenie"));
        return oznaczenieCol;
    }
    
    
    public static TableColumn getWartoscColumn(){
        TableColumn wartoscCol = new TableColumn("Wartosc");
        wartoscCol.getColumns().addAll(getWartoscMinColumn(),getWartoscMaxColumn());
        return wartoscCol;
    }
    
    private static TableColumn<Czynnik, Double> getWartoscMinColumn(){
        TableColumn<Czynnik, Double> wartoscMinCol = new TableColumn<>("minimalna");
        wartoscMinCol.setCellValueFactory(new PropertyValueFactory<>("wartoscMin"));
        return wartoscMinCol;
    }
        
    private static TableColumn<Czynnik, Double> getWartoscMaxColumn(){
        TableColumn<Czynnik, Double> wartoscMaxCol = new TableColumn<>("maksymalna");
        wartoscMaxCol.setCellValueFactory(new PropertyValueFactory<>("wartoscMax"));
        return wartoscMaxCol;
    }
    
    public static TableColumn<Czynnik, Double> getJednostkaColumn(){
        TableColumn<Czynnik, Double> jednostkaCol = new TableColumn<>("Jednostka");
        jednostkaCol.setCellValueFactory(new PropertyValueFactory<>("jednostka"));
        return jednostkaCol;
    }
    
}
