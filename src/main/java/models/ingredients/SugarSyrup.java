package models.ingredients;

public class SugarSyrup extends Ingredients{
	public SugarSyrup(int value){
		super("sugar syrup",value);
	}

	@Override
	public void giveLowIndicator() {
		if(!this.isLow){
			System.out.println("Light 6 for "+this.name+" : red");
			this.isLow=true;
		}		
	}

	@Override
	public void giveOkIndicator() {
		System.out.println("Light 6 for "+this.name+" : green");
		this.isLow=false;
	}
}
