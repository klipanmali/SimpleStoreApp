
public class OShirt extends Item {
	
	private String color;
	private int neck;
	private int sleeve;
	private boolean specifiedYet;
	
	public OShirt(){
		super(1950);
		this.specifiedYet = false;
	}
	
	public void display(){
		if(this.specifiedYet){
			System.out.print(this.color);
			System.out.print(" Oxford shirt, size ");
			System.out.print(this.neck);
			System.out.print("/");
			System.out.print(this.sleeve);
			System.out.print(";");
			
		}else{
			System.out.print("Oxford shirt; ");
		}
		super.display();
	}

	@Override
	public void inputSpecifics() {
		System.out.println("What color ?");
		String[] colors ={"plava", "crvena", "zelena"};
		color = CompuDuds.inputSelection(colors);
		System.out.println("Neck size ?");
		neck = CompuDuds.inputIntegerInRange(15,20);
		System.out.println("sleev lenght ?");
		sleeve = CompuDuds.inputIntegerInRange(32,37);
		this.specifiedYet = true;
	}

	
}
