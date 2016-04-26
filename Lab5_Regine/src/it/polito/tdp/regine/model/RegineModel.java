package it.polito.tdp.regine.model;

import java.util.ArrayList;
import java.util.List;

public class RegineModel {
	
	int[] regine = new int[8];
	List<int[][]> soluzioni = new ArrayList<int[][]>();

	public int[][] ricorsione() {
		Scacchiera sc = new Scacchiera();
		return ricorsione(sc, 0);
		
	}
	
	public int[][] ricorsione(Scacchiera sc, int level) {
		
		
		if(level==8) {
			return sc.getScacchiera();
		}
		
		for(int j=0; j<8; j++) {
			
			if(filtro(sc, level, j)) {
				sc.setCasella(level, j);
				regine[level] = j;
				int[][] temp = ricorsione(sc, level+1);
				if(temp!=null)
					return temp;
				sc.delete(level, j);
			}
		}
		
		return null;
		
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
