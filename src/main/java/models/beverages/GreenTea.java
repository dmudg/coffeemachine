package models.beverages;

import java.util.List;

import models.ingredients.Ingredients;

public class GreenTea extends Beverages{
	public GreenTea(List<Ingredients> ingredients){
		super("green tea",ingredients);
	}
}
