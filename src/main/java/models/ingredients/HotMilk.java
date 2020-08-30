package models.ingredients;

public class HotMilk extends Ingredients{
	public HotMilk(int value){
		super("hot milk",value);
	}

	@Override
	public void giveLowIndicator() {
		if(!this.isLow){
			System.out.println("Light 4 for "+this.name+" : red");
			this.isLow=true;
		}		
	}

	@Override
	public void giveOkIndicator() {
		System.out.println("Light 4 for "+this.name+" : green");
		this.isLow=false;
	}
}
