package models.ingredients;

public class ElaichiSyrup extends Ingredients{
	public ElaichiSyrup(int value){
		super("elaichi syrup",value);
	}

	@Override
	public void giveLowIndicator() {
		if(!this.isLow){
			System.out.println("Light 1 for "+this.name+" : red");
			this.isLow=true;
		}		
	}

	@Override
	public void giveOkIndicator() {
		System.out.println("Light 1 for "+this.name+" : green");
		this.isLow=false;
	}
}
