package it.polito.tdp.regine.model;

public class TestModel {

	public static void main(String[] args) {
		
		RegineModel model = new RegineModel();
		
		int[][] sol = model.ricorsione();
		
		for(int i=0; i<8; i++)
		{
			
			for(int j=0; j<8; j++)
			{
				System.out.print(sol[i][j] + " ");
			}
			
			System.out.print("\n");
			
		}


	}

}
