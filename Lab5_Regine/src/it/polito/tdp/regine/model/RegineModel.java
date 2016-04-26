package it.polito.tdp.regine.model;

import java.util.ArrayList;
import java.util.List;

public class RegineModel {
	
	int[][] finale = new int[8][8];
	int[] regine = new int[8];
	List<int[][]> soluzioni = new ArrayList<int[][]>();

	public List<int[][]> ricorsione() {
		Scacchiera sc = new Scacchiera();
		soluzioni.clear();
		ricorsione(sc, 0);
		return soluzioni;
		
	}
	
	public void ricorsione(Scacchiera sc, int level) {
		
		if(level==8) {
			finale = sc.getScacchiera();
			soluzioni.add(finale);
			return;
		}
		
		for(int j=0; j<8; j++) {
			
			if(filtro(sc, level, j)) {
				sc.setCasella(level, j);
				regine[level] = j;
				ricorsione(sc, level+1);
				sc.delete(level, j);
			}
		}
		
	}
	
	
	public boolean filtro(Scacchiera sc, int riga, int col) {
		
		for(int i=0; i<8; i++) {
			int num=sc.getCasella(i, col);
			if(num==1) {
				return false;
			}
		}
		
		//controllo sulle diagonali
		for(int i=0; i<riga; i++)
			if( riga-i == Math.abs(col - regine[i]) )
				return false ;
		
		
		
		
		
		return true;
	}

}
