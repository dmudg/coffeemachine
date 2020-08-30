package models.ingredients;

public class TeaLeavesSyrup extends Ingredients{
	public TeaLeavesSyrup(int value){
		super("tea leaves syrup",value);
	}

	@Override
	public void giveLowIndicator() {
		if(!this.isLow){
			this.isLow=true;
			System.out.println("Light 7 for "+this.name+" : red");			
		}		
	}

	@Override
	public void giveOkIndicator() {
		System.out.println("Light 7 for "+this.name+" : green");
		this.isLow=false;
	}
}
