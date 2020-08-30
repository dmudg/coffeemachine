package service;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.beverages.Beverages;
import models.ingredients.Ingredients;

public class InputParser {
	String filePath;
	Map<String, Object> obj;
	public InputParser(String filePath){
		this.filePath=filePath;
		readJson();
	}
	public void readJson(){
		ObjectMapper mapper = new ObjectMapper();
        try {
             obj = mapper.readValue(new File(
                    System.getProperty("user.dir") + "/src/main/resources/"+filePath), new TypeReference<Map<String, Object>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	public List<Beverages> getBeverages(){
		List<Beverages> beverages =new ArrayList<>();
		LinkedHashMap<String, Object> machine = (LinkedHashMap<String, Object>) obj.get("machine");
		LinkedHashMap<String, Object> beverageMap = (LinkedHashMap<String, Object>) machine.get("beverages");
		for (Map.Entry<String, Object> entry : beverageMap.entrySet()) {
            LinkedHashMap<String, Object> ingredients = (LinkedHashMap<String, Object>) entry.getValue();
            List<Ingredients> ingredientsList = new ArrayList<>();
            for (Map.Entry<String, Object> entry1 : ingredients.entrySet()) {
            	ingredientsList.add(IngredientsFactory.getIngredient(entry1.getKey(), (Integer) entry1.getValue()));
            }
            Beverages beverage = BeveragesFactory.getBeverage(entry.getKey(), ingredientsList);
            beverages.add(beverage);
        }
		return beverages;
	}
	public IngredientsManager getIngredientsManager(){
		IngredientsManager ingredientsManager=new IngredientsManager();
        LinkedHashMap<String, Object> machine = (LinkedHashMap<String, Object>) obj.get("machine");
        LinkedHashMap<String, Object> outlets = (LinkedHashMap<String, Object>) machine.get("outlets");
        LinkedHashMap<String, Object> total_items_quantity = (LinkedHashMap<String, Object>) machine.get("total_items_quantity");
        for (Map.Entry<String, Object> entry : total_items_quantity.entrySet()) {
            Ingredients ingredient = IngredientsFactory.getIngredient(entry.getKey(), (Integer) entry.getValue());
            ingredientsManager.addIngredient(ingredient);
        }
        return ingredientsManager;
	}
	public int getOutlets(){
		LinkedHashMap<String, Object> machine = (LinkedHashMap<String, Object>) obj.get("machine");
        LinkedHashMap<String, Object> outlets = (LinkedHashMap<String, Object>) machine.get("outlets");
        return (Integer) outlets.get("count_n");
	}
}
