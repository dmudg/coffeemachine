package models.ingredients;

public class HotWater extends Ingredients{
	
	public HotWater(int value){
		super("hot water",value);
	}

	@Override
	public void giveLowIndicator() {
		if(!this.isLow){
			System.out.println("Light 5 for "+this.name+" : red");
			this.isLow=true;
		}		
	}

	@Override
	public void giveOkIndicator() {
		System.out.println("Light 5 for "+this.name+" : green");
		this.isLow=false;
	}
}
