package service;
import java.util.List;

import models.beverages.Beverages;
import models.beverages.BlackTea;
import models.beverages.ElaichiTea;
import models.beverages.GingerTea;
import models.beverages.GreenTea;
import models.beverages.HotCoffee;
import models.beverages.HotMilk;
import models.beverages.HotTea;
import models.beverages.HotWater;
import models.ingredients.Ingredients;

public class BeveragesFactory {
	public static Beverages getBeverage(String name,List<Ingredients> ingredients){
		if(name=="black_tea"){
			return new BlackTea(ingredients);
		}
		else if(name=="hot_coffee"){
			return new HotCoffee(ingredients);
		}
		else if(name=="elaichi_tea"){
			return new ElaichiTea(ingredients);
		}
		else if(name=="ginger_tea"){
			return new GingerTea(ingredients);
		}
		else if(name=="green_tea"){
			return new GreenTea(ingredients);
		}
		else if(name=="hot_tea"){
			return new HotTea(ingredients);
		}
		else if(name=="hot_water"){
			return new HotWater(ingredients);
		}
		else if(name=="hot milk"){
			return new HotMilk(ingredients);
		}
		else{
			return null;
		}
	}
}
