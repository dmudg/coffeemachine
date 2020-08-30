package models.beverages;

import java.util.List;

import models.ingredients.Ingredients;

public class HotMilk extends Beverages{
	public HotMilk(List<Ingredients> ingredients){
		super("hot milk",ingredients);
	}
}
