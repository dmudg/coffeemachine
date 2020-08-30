package models.beverages;

import java.util.List;

import models.ingredients.Ingredients;

public class GingerTea extends Beverages{
	public GingerTea(List<Ingredients> ingredients){
		super("ginger tea",ingredients);
	}
}
