package service;
import java.util.List;

import models.beverages.Beverages;

public class mainClass {
	public static void main(String[] args){	
		String inputPath="input.json";
		InputParser parser=new InputParser(inputPath);
		
		List<Beverages> beverages=parser.getBeverages();
		
		IngredientsManager im=parser.getIngredientsManager();
		
		int outlets=parser.getOutlets();

		Manager manager =new Manager(beverages,im,outlets);
		manager.start();
	}
}
