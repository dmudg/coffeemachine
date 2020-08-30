package models.beverages;

import java.util.List;

import models.ingredients.Ingredients;

public class HotWater extends Beverages{
	public HotWater(List<Ingredients> ingredients){
		super("hot water",ingredients);
	}
}
