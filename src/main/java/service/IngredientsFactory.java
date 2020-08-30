package service;
import models.ingredients.ElaichiSyrup;
import models.ingredients.GingerSyrup;
import models.ingredients.GreenMixture;
import models.ingredients.HotMilk;
import models.ingredients.HotWater;
import models.ingredients.Ingredients;
import models.ingredients.SugarSyrup;
import models.ingredients.TeaLeavesSyrup;

public class IngredientsFactory {
	public static Ingredients getIngredient(String name,int value){
		if(name=="hot_milk"){
			return new HotMilk(value);
		}
		else if(name=="hot_water"){
			return new HotWater(value);
		}
		else if(name=="elaichi_syrup"){
			return new ElaichiSyrup(value);
		}
		else if(name=="ginger_syrup"){
			return new GingerSyrup(value);
		}
		else if(name=="sugar_syrup"){
			return new SugarSyrup(value);
		}
		else if(name=="tea_leaves_syrup"){
			return new TeaLeavesSyrup(value);
		}
		else if(name=="green_mixture"){
			return new GreenMixture(value);
		}
		else{
			return null;
		}
	}
}
