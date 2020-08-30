package models.ingredients;

public abstract class Ingredients {
	protected String name;
	protected int value;
	protected int maxValue;
	protected boolean isLow;
	protected Ingredients(String name,int value){
		this.name=name;
		this.value=value;
		this.maxValue=value;
		this.isLow=false;
	}
	public  String getName(){
		return this.name;
	}
	public  void setName(String name){
		this.name=name;
	}
	public  int getValue(){
		return this.value;
	}
	public  void setValue(int value){
		this.value=value;
	}
	public  int getMaxValue(){
		return this.maxValue;
	}
	public  void setMaxValue(int value){
		this.maxValue=value;
	}
	public abstract void giveLowIndicator();
	public abstract void giveOkIndicator();	
	
}
