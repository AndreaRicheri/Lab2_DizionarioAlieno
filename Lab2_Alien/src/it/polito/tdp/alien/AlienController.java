package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	Map <String, Parole> mappaDizionario = new TreeMap<String, Parole>();
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextField txtTraduzione;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
    @FXML
    private Button btnAdd;
        
    

    
    @FXML
    void doInsert(ActionEvent event) { //Bottone aggiungi
    // TODO    
    	
    	String parolaAliena;
    	String traduzione;
    	    	
    	parolaAliena=txtWord.getText();
    	traduzione=txtTraduzione.getText();
    	
    	parolaAliena = parolaAliena.trim();
    	parolaAliena = parolaAliena.toLowerCase();
    	
    	traduzione = traduzione.trim();
    	traduzione = traduzione.toLowerCase();
    	
    
    	
    	if (!parolaAliena.chars().allMatch(Character::isLetter)){
    		
        	txtResult.appendText("\nLa parola "+parolaAliena+" contiene caratteri non alfabetici e dunque non consentiti. Riprova.");	
        	return;
        	}
    	
    	
    	if (!parolaAliena.chars().allMatch(Character::isLetter)){
    		
    	txtResult.appendText("\nLa parola "+parolaAliena+" contiene caratteri non alfabetici e dunque non consentiti. Riprova.");	
    	return;
    	}
    	if (!traduzione.chars().allMatch(Character::isLetter)){
    		
    	txtResult.appendText("\nLa parola "+traduzione+" contiene caratteri non alfabetici e dunque non consentiti. Riprova.");    		
    	return;
    	} else {
    		
    	
    	
    	Parole ptemp = new Parole(parolaAliena, traduzione);
    	
    	
    	Parole mtemp = this.mappaDizionario.get(parolaAliena);
    	
    	
    	if (mtemp==null)
        {
    		mappaDizionario.put(parolaAliena, ptemp);
    		txtWord.clear();
            txtTraduzione.clear();
            
            txtResult.appendText("\nE' stata aggiunta la traduzione di "+parolaAliena+" al dizionario.");
        	
        } else {
        	
        	/* Singola traduzione con sostituzione
            mappaDizionario.remove(parolaAliena);
            mappaDizionario.put(parolaAliena, ptemp);
        	 
        	txtWord.clear();
            txtTraduzione.clear();
            
            txtResult.appendText("\nE' stata cambiata la traduzione di "+parolaAliena+" al dizionario.");
            */
        	
        	//Piu traduzioni:
        	
        	
        	Parole ttemp = this.mappaDizionario.get(parolaAliena);
        	
        	String vecchiaTraduzione = ttemp.getTranslation();
        	
        	mappaDizionario.remove(parolaAliena);
        	
        	Parole utemp = new Parole(parolaAliena, vecchiaTraduzione+", "+traduzione);
        	
            mappaDizionario.put(parolaAliena, utemp);
         	 
         	txtWord.clear();
            txtTraduzione.clear();
             
            txtResult.appendText("\nE' stata aggiunta una ulteriore traduzione per "+parolaAliena+" al dizionario.");
        	
        	
        	
        }
    	}
    	
    	
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) { //bottone traduci
    
         
         String parolaDaTradurre=txtWord.getText();
         
        parolaDaTradurre = parolaDaTradurre.trim();
     	parolaDaTradurre = parolaDaTradurre.toLowerCase();
     	
     	if (!parolaDaTradurre.chars().allMatch(Character::isLetter)){
     		
     	txtResult.appendText("\nLa parola "+parolaDaTradurre+" contiene caratteri non alfabetici e dunque non consentiti. Riprova.");
     		
     	} else {
     		
     	
         Parole mtemp = this.mappaDizionario.get(parolaDaTradurre);
         
         txtTraduzione.clear();  
         txtWord.clear();
         
        if (mtemp==null)
        {
        	txtResult.appendText("\nLa parola "+parolaDaTradurre+" non e' ancora nel dizionario!");
        	
        }
        else
        {
        	txtResult.appendText("\n"+parolaDaTradurre+" = "+mtemp.getTranslation());
        	
        
        }
          
         
         
          /*
          String[] parti = testo.split(" ");
          String parolaAliena = parti[0]; // Parola Aliena
          String traduzione = parti[1]; // Traduzione
          
          parolaDaTradurre.addParola(parolaAliena, Traduzione);
          */
          
     	}   	
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    txtResult.clear();
    txtWord.clear();
    txtTraduzione.clear();
    mappaDizionario.clear();
    
    }
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    }
}
