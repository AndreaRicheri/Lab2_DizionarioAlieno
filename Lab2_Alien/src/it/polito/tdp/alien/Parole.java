package it.polito.tdp.alien;

public class Parole {

	private String alienWord;
	private String translation;
	
	public Parole(String alienWord, String translation) {
		super();
		this.alienWord = alienWord;
		this.translation = translation;
	}
	
	public String getAlienWord() {
		return alienWord;
	}
	
	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}
	
	public String getTranslation() {
		return translation;
	}
	
	public void setTranslation(String translation) {
		this.translation = translation;
	}
	
	
}
