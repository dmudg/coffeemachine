package models.beverages;

import java.util.List;

import models.ingredients.Ingredients;

public class HotTea extends Beverages{
	public HotTea(List<Ingredients> ingredients){
		super("hot tea",ingredients);
	}
}
