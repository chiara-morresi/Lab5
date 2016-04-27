package it.polito.tdp.regine.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		
		RegineModel model = new RegineModel();
		
		List<int[][]> sol = model.ricorsione();
		
		for(int k=0; k<sol.size(); k++) {
			int[][] soluzione = sol.get(k);
			
			for(int i=0; i<8; i++)
			{
				
				for(int j=0; j<8; j++)
				{
					System.out.print(soluzione[i][j] + " ");
				}
				
				System.out.print("\n");
				
			}
			
			System.out.println("\n");
		}
		
		System.out.println(sol.size());
	}

}
