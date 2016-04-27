package it.polito.tdp.ruzzle.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import it.polito.tdp.ruzzle.db.RuzzleDAO;

public class RuzzleModel {
	
	private final int N= 4;
	RuzzleDAO dao;
	
	private char[][] matrice;
	private List<Character> parola;
	private List<String> soluzioni;
	private boolean[][] utilizzo;
	
	public RuzzleModel() {
		matrice = new char[N][N];
		parola = new ArrayList<Character>();
		soluzioni = new ArrayList<String>();
		dao = new RuzzleDAO();
		utilizzo = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				utilizzo[i][j] = false;
			}
		}
	}

	public char[][] generaRandom() {		
		char alfabeto[]={'A','B','C','D','E','F','G','H','I','L','M','N','O', 'P', 'Q','R','S','T','U','V','Z'};
		int casuale;
		for(int i=0; i<matrice.length; i++)
		{
			for(int j=0; j<matrice.length; j++)
			{
				casuale=(int) (Math.random()*alfabeto.length);
		
				matrice[i][j]=alfabeto[casuale];
			}
		}
		
		return matrice;
		
	}
	

	
	public List<String> getParole(char[][] matrice, int level) {
		soluzioni.clear();
		ricorsione(matrice, level);
		return soluzioni;
	}
	
	public void ricorsione(char[][] matrice, int level) {
		int riga= level/4;
		int col = level%4;
		
		//doAlways
		if(level>1) {
			String st = this.fromListToString(parola);
			if(dao.dizionarioContiene(st)) {
				soluzioni.add(st);	
			}
		}
		
		
		if(level==16) {
			return;		
	
		}
		
		
		if(filtro(matrice, parola, riga-1, col)) {
			Character c= matrice[riga-1][col];
			parola.add(c);
			utilizzo[riga-1][col] = true;
			ricorsione(matrice, level+1);
			parola.remove(c);
			
		}
		
		if(filtro(matrice, parola, riga-1, col+1)) {
			parola.add(matrice[riga-1][col+1]);
			utilizzo[riga-1][col+1] = true;
			ricorsione(matrice, level+1);
			parola.remove(matrice[riga-1][col+1]);
			
		}
		
		if(filtro(matrice, parola, riga, col+1)) {
			Character c= matrice[riga][col+1];
			parola.add(c);
			utilizzo[riga][col+1] = true;
			ricorsione(matrice, level+1);
			parola.remove(c);
			
		}
		
		if(filtro(matrice, parola, riga+1, col+1)) {
			parola.add(matrice[riga+1][col+1]);
			utilizzo[riga+1][col+1] = true;
			ricorsione(matrice, level+1);
			parola.remove(matrice[riga+1][col+1]);
			
		}
		
		if(filtro(matrice, parola, riga+1, col)) {
			parola.add(matrice[riga+1][col]);
			utilizzo[riga+1][col] = true;
			ricorsione(matrice, level+1);
			parola.remove(matrice[riga+1][col]);
			
		}
		
		if(filtro(matrice, parola, riga+1, col-1)) {
			parola.add(matrice[riga+1][col-1]);
			utilizzo[riga+1][col-1] = true;
			ricorsione(matrice, level+1);
			parola.remove(matrice[riga+1][col-1]);
			
		}
		
		if(filtro(matrice, parola, riga, col-1)) {
			parola.add(matrice[riga][col-1]);
			utilizzo[riga][col-1] = true;
			ricorsione(matrice, level+1);
			parola.remove(matrice[riga][col-1]);
			
		}
		
		if(filtro(matrice, parola, riga-1, col-1)) {
			parola.add(matrice[riga-1][col-1]);
			utilizzo[riga-1][col-1] = true;
			ricorsione(matrice, level+1);
			parola.remove(matrice[riga-1][col-1]);
			
		}
		
		
		
	}
	
	public boolean filtro(char[][] matrice, List<Character> parola, int riga, int col) {
		
		if(direzioneIsValid(riga, col)) 
		{
			parola.add(matrice[riga][col]);
			String s = this.fromListToString(parola);
			if(dao.parolaIniza(s))
			{
				return true;
			}
			
		} 
		
		
		return false;
	}
	
	public String fromListToString(List<Character> parola) {
		String s ="";
		for(Character c: parola) {
			s += c;
		}
		return s;
	}
	
	public boolean direzioneIsValid(int riga, int col) {
		
		if(riga>=0 && riga<4 && col>=0 && col<4) {
			if(!Used(riga, col)) {
				return true;
			}
		}
			
		
		return false;
	}
	
	public boolean Used(int riga, int col) {
		boolean b = utilizzo[riga][col];
		return b;
	}
	
	
	
	
}
