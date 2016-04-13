package it.polito.tdp.ruzzle.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RuzzleModel {
	
	private final int N= 4;
	
	private char[][] matrice;
	
	public RuzzleModel() {
		matrice = new char[N][N];
	}

	public char[][] generaRandom() {
//		char car = 'c';
//		String st = ""+car;
//		toLowerCase
		
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
	
	public List<String> ottieniParole() {
		List<String> parole = new ArrayList<String>();
		List<String> paroleItaliane = new ArrayList<String>();
		
		
		
//		chiamo DAO che ritorna lista parole italiane
		
		
		return paroleItaliane;
		
	}
	
	public boolean contains(String word) {
        char[] array = word.toCharArray();

        // empty string is trivial
        if (array.length == 0)
            return true;

        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (matrice[i][j] == array[0] && findRecursively(i, j, array, 1))
                    return true;
            }
        }

        return false;
    }

    public boolean isValid(int i, int j) {
        return (0 <= i && i < 4) && (0 <= j && j < 4);
    }

    public boolean findRecursively(int i, int j, char[] array, int index) {
        // reached end of word
        if (index == array.length) {
            return true;
        } else {
            // loop over all neighbors
            for (int di = -1; di <= 1; di++) {
                for (int dj = -1; dj <= 1; dj++) {
                    // skip cell itself and invalid cells
                    if (!(di == 0 && dj == 0) && isValid(i+di, j+dj)) {
                        if (matrice[i+di][j+dj] == array[index] 
                              && findRecursively(i+di, j+dj, array, index+1))
                            return true;
                    }
                }
            }

            return false;
        }           
    }
	
	
	
	
}
