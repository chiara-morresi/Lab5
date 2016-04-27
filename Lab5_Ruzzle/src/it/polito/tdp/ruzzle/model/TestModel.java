package it.polito.tdp.ruzzle.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		RuzzleModel model = new RuzzleModel();
		
		List<String> sol = model.getParole(model.generaRandom(), 0);
		
		for(String s: sol) {
			System.out.println(s);
		}

	}

}
