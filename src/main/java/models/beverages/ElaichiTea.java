package models.beverages;

import java.util.List;

import models.ingredients.Ingredients;

public class ElaichiTea extends Beverages {
	public ElaichiTea(List<Ingredients> ingredients){
		super("elaichi tea",ingredients);
	}
}
