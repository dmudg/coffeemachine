package models.ingredients;

public class GingerSyrup extends Ingredients{
	public GingerSyrup(int value){
		super("ginger syrup",value);
	}

	@Override
	public void giveLowIndicator() {
		if(!this.isLow){
			System.out.println("Light 2 for "+this.name+" : red");
			this.isLow=true;
		}		
	}

	@Override
	public void giveOkIndicator() {
		System.out.println("Light 2 for "+this.name+" : green");
		this.isLow=false;
	}
}
