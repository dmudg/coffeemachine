package models.beverages;

import java.util.List;

import models.ingredients.Ingredients;

public abstract class Beverages {
	protected String name;
	protected List<Ingredients> ingredients;
	public Beverages(String name,List<Ingredients> ingredients){
		this.name=name;
		this.ingredients=ingredients;
	}
	public void serve(){
		System.out.println(this.name+" is being prepared");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}			
	}
	public void setName(String name){
		this.name=name;
	}
	public void setIngredients(List<Ingredients> ingredients){
		this.ingredients=ingredients;
	}
	public String getName(){
		return this.name;
	}
	public List<Ingredients> getValue(){
		return this.ingredients;
	}
}
