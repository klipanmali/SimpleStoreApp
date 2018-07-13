public class ItemList {
	
	private Item[] itemList;
	private int numItem;
	
	public ItemList(){
		itemList = new Item[10];
	}
	
	public boolean isEmpty(){
		return numItem == 0;
	}
	
	public void display(){
		for (int index = 0; index < numItem; index++){
			System.out.println((index+1)+") ");
			itemList[index].display();
			System.out.println();
		}
		System.out.println("Total price: ");
			CompuDuds.displayPrice(totalPrice());
		System.out.println();
	}

	public int totalPrice(){
		int sum = 0;
		for (int i = 0;i<numItem;i++){
			sum += itemList[i].price();
		}
		return sum;
	}
	
	public void add(Item item){
		if( numItem == itemList.length){
			grow();
			add(item);
		}else{
			itemList[numItem]= item;
			numItem += 1;
		}
		
	}
	
	public void delete(Item item){
		for(int i =0;i<numItem;i++){
			if(itemList[i] == item){
				for(int j=i+1;j<numItem;j++){
					itemList[j-1]=itemList[j];
				}
			}
			itemList[numItem-1] = null;
			numItem --;
			return;
		}
		System.err.println("Error:Item delete, item not in the List");
		System.exit(1);
	}
	
	public Item choose(){
		if(isEmpty()){
			System.err.println("Error: Choose, List is empty");
			System.exit(1);
		}
		System.out.println("Which Item ");
		display();
		return itemList[CompuDuds.inputIntegerInRange(1,numItem)-1];
	}
	
	private void grow(){
		Item[] newItemList = new Item[itemList.length*2];
		for(int i = 0;i<itemList.length;i++){
			newItemList[i] = itemList[i];
		}
		itemList = newItemList;
	}
}
