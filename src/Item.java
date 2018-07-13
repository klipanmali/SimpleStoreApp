
public abstract class Item {
	
	private int price;
	
	public Item(){
			
	}
	
	public Item(int initialPrice){
		price = initialPrice;
	}

	public int price(){
		return price;
	}
	
	public void display(){
		CompuDuds.displayPrice(price);
	}
	
	public abstract void inputSpecifics();
	
	public void reviseSpecifics(){
		this.inputSpecifics();
	}
	
	
}
