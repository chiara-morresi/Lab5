package it.polito.tdp.regine.model;

public class Scacchiera {
	
	private int[][] scacchiera;
	
	public Scacchiera() {
		scacchiera = new int[8][8];
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				scacchiera[i][j]=0;
			}
		}
	}

	
	
	public void setCasella(int riga, int col) {
		scacchiera[riga][col] = 1;
	}
	
	public void delete(int riga, int col) {
		scacchiera[riga][col] = 0;
	}
	
	public int getCasella(int riga, int col) {
		return scacchiera[riga][col];
	}
	
	public int[][] getScacchiera() {
		return scacchiera;
	}
	
	

}
