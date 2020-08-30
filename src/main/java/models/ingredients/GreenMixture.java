package models.ingredients;

public class GreenMixture extends Ingredients{
	public GreenMixture(int value){
		super("green mixture",value);
	}

	@Override
	public void giveLowIndicator() {
		if(!this.isLow){
			System.out.println("Light 3 for "+this.name+" : red");
			this.isLow=true;
		}		
	}

	@Override
	public void giveOkIndicator() {
		System.out.println("Light 3 for "+this.name+" : green");
		this.isLow=false;
	}
}
