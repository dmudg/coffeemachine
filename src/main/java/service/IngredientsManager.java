package service;
import java.util.HashMap;

import models.ingredients.Ingredients;

public class IngredientsManager {
	private HashMap<String,Ingredients> totalIngredients;
	public IngredientsManager(){
		totalIngredients=new HashMap<>();
	}
	public int compareIngredient(Ingredients a){
		if(!totalIngredients.containsKey(a.getName())){
			return -1;
		}
		else if(a.getValue()<=totalIngredients.get(a.getName()).getValue()){
			return 1;
		}
		else{
			totalIngredients.get(a.getName()).giveLowIndicator();
			return 0;
		}
	}
	public HashMap<String,Ingredients> getTotalIngredients(){
		return this.totalIngredients;
	}
	public void setTotalIngredients(HashMap<String,Ingredients> totalIngredients){
		this.totalIngredients=totalIngredients;
	}
	public void addIngredient(Ingredients a){
		totalIngredients.put(a.getName(), a);
	}
	public void subtractIngredient(Ingredients a){
		Ingredients totalIngredient=totalIngredients.get(a.getName());
		if(totalIngredient!=null){
			totalIngredient.setValue(totalIngredient.getValue()-a.getValue());
			totalIngredients.put(totalIngredient.getName(), totalIngredient);
		}
	}
	public void refillAll(){
		for(int i=0;i<totalIngredients.size();i++){
			Ingredients totalIngredient=totalIngredients.get(i);
			totalIngredient.setValue(totalIngredient.getMaxValue());
			totalIngredient.giveOkIndicator();
			addIngredient(totalIngredient);
		}
	}
}
