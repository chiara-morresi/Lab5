package application;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.ruzzle.model.RuzzleModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class RuzzleController {
	
	private RuzzleModel model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lbl00;

    @FXML
    private Label lbl10;

    @FXML
    private Label lbl20;

    @FXML
    private Label lbl30;

    @FXML
    private Label lbl01;

    @FXML
    private Label lbl11;

    @FXML
    private Label lbl21;

    @FXML
    private Label lbl31;

    @FXML
    private Label lbl02;

    @FXML
    private Label lbl12;

    @FXML
    private Label lbl22;

    @FXML
    private Label lbl32;

    @FXML
    private Label lbl03;

    @FXML
    private Label lbl13;

    @FXML
    private Label lbl23;

    @FXML
    private Label lbl33;

    @FXML
    private ListView<String> listParole;
    
    public void setModel(RuzzleModel model) {
    	this.model=model;
    }

    @FXML
    void doFind(MouseEvent event) {
//    	String elemento = listParole.getSelectionModel().getSelectedItem();
//    	lbl10.setText(elemento);
    	

    }

    @FXML
    void doGenera(ActionEvent event) {
//    	lbl00.setText("prova");
//    	String prova = lbl00.getText();
//    	listParole.getItems().add(prova);
//    	listParole.getItems().add("ciao");
//    	listParole.getItems().add("poli");

    	//metodo per inserire caratteri
    	char[][] ruzzle = model.generaRandom();
    	lbl00.setText("" +ruzzle[0][0]);
    	lbl10.setText("" +ruzzle[0][1]);
    	lbl20.setText("" +ruzzle[0][2]);
    	lbl30.setText("" +ruzzle[0][3]);
    	lbl01.setText("" +ruzzle[1][0]);
    	lbl02.setText("" +ruzzle[2][0]);
    	lbl03.setText("" +ruzzle[3][0]);
    	lbl11.setText("" +ruzzle[1][1]);
    	lbl12.setText("" +ruzzle[2][1]);
    	lbl13.setText("" +ruzzle[3][1]);
    	lbl21.setText("" +ruzzle[1][2]);
    	lbl22.setText("" +ruzzle[2][2]);
    	lbl23.setText("" +ruzzle[3][2]);
    	lbl31.setText("" +ruzzle[1][3]);
    	lbl32.setText("" +ruzzle[2][3]);
    	lbl33.setText("" +ruzzle[3][3]);
    	
    }

    @FXML
    void initialize() {
        assert lbl00 != null : "fx:id=\"lbl00\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert lbl10 != null : "fx:id=\"lbl10\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert lbl20 != null : "fx:id=\"lbl20\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert lbl30 != null : "fx:id=\"lbl30\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert lbl01 != null : "fx:id=\"lbl01\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert lbl11 != null : "fx:id=\"lbl11\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert lbl21 != null : "fx:id=\"lbl21\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert lbl31 != null : "fx:id=\"lbl31\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert lbl02 != null : "fx:id=\"lbl02\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert lbl12 != null : "fx:id=\"lbl12\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert lbl22 != null : "fx:id=\"lbl22\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert lbl32 != null : "fx:id=\"lbl32\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert lbl03 != null : "fx:id=\"lbl03\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert lbl13 != null : "fx:id=\"lbl13\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert lbl23 != null : "fx:id=\"lbl23\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert lbl33 != null : "fx:id=\"lbl33\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert listParole != null : "fx:id=\"listParole\" was not injected: check your FXML file 'Ruzzle.fxml'.";

        model= new RuzzleModel();
    }
}
