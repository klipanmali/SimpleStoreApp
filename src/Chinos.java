
public class Chinos extends Item {
	
	private String color;
	private int size;
	private int inseam;
	private boolean cuffed;
	private boolean specifiedYet;
	
	public Chinos(){
		super(3300);
		this.cuffed = false;
		this.specifiedYet = false;
	}
	public void display(){
		if(this.specifiedYet){
			System.out.print(this.color);
			System.out.print(" Chinos, size ");
			System.out.print(this.size);
			System.out.print(", ");
			System.out.print(cuffed ? "cuffed" : "hammed");
			System.out.print(" to ");
			System.out.print(this.inseam);
			
		}else{
			System.out.print("Chinos; ");
		}
		super.display();
	}

	@Override
	public void inputSpecifics() {
		System.out.println("What color ?");
		String[] colors ={"ugljena", "kaki", "zelena"};
		color = CompuDuds.inputSelection(colors);
		System.out.println("Waist size ?");
		size = CompuDuds.inputIntegerInRange(34,40);
		System.out.println("1) Hammed"+"\n"+"2) Cuffed");
		cuffed = CompuDuds.inputIntegerInRange(1,2) == 2;
		System.out.println("Inseam lenght?");
		inseam = CompuDuds.inputIntegerInRange(1, cuffed ? 34: 36);
		this.specifiedYet = true;
	}

	
}
