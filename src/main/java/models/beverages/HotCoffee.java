package models.beverages;

import java.util.List;

import models.ingredients.Ingredients;

public class HotCoffee extends Beverages {
	public HotCoffee(List<Ingredients> ingredients){
		super("hot coffee",ingredients);
	}
}
