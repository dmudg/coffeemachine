package models.beverages;

import java.util.List;

import models.ingredients.Ingredients;

public class BlackTea extends Beverages{
	public BlackTea(List<Ingredients> ingredients){
		super("black tea",ingredients);
	}
}
