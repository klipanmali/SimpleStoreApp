/*
 * Simple store application from Concrete Abstraction
 * with line interface.
 * Good example how to read text input from keyboard
 */

public class CompuDuds {

	public static void main(String[] args) {
		ItemList itemList = new ItemList();
		while (true) {
			System.out.println("Choose: ");
			System.out.println("1) Exit");
			System.out.println("2) Add Item");
			System.out.println("3) List selected Items");
			System.out.println("4) Total price of selected Items");
			int option;
			if (itemList.isEmpty()) {
				option = inputIntegerInRange(1, 4);
			} else {
				System.out.println("5) Delete one of items");
				System.out.println("6) Revise specifics of selected Item");
				option = inputIntegerInRange(1, 6);
			}

			if (option == 1) {
				System.out.println("Bye bye");
				System.exit(0);
			} else if (option == 2) {
				Item item = inputItem();
				itemList.add(item);
				item.inputSpecifics();
			} else if (option == 3) {
				itemList.display();
			} else if (option == 4) {
				displayPrice(itemList.totalPrice());
				System.out.println();
			} else if (option == 5) {
				itemList.delete(itemList.choose());
			} else if (option == 6) {
				itemList.choose().reviseSpecifics();
			}
		}
	}

	private static Item inputItem() {
		System.out.println("Wah do you like?");
		System.out.println("1) Chinos");
		System.out.println("2) Oxford Shirt");

		if (inputIntegerInRange(1, 2) == 1) {
			return new Chinos();
		} else {
			return new OShirt();
		}
	}

	public static void displayPrice(int totalCents) {
		int dollars = 0;
		int cents = 0;
		if (totalCents > 0) {
			dollars = totalCents / 100;
			cents = totalCents % 100;
		}
		System.out.print(" $" + dollars + ".");
		if (cents < 10)
			System.out.print("0");
		System.out.println(cents);

	}

	private static java.io.BufferedReader reader = new java.io.BufferedReader(
			new java.io.InputStreamReader(System.in));

	public static int inputIntegerInRange(int min, int max) {
		System.out.print("(enter ");
		System.out.print(min);
		System.out.print("-");
		System.out.print(max);
		System.out.println(")");
		String inputAsString = null;
		try {
			inputAsString = reader.readLine();
		} catch (java.io.IOException e) {
			System.err.print("Problem reading input: ");
			System.err.println(e);
			System.exit(1);
		}
		if (inputAsString == null) { // this means end of file on input
			System.exit(0); // handle as a normal program termination
		}
		int inputAsInt;
		try {
			inputAsInt = Integer.parseInt(inputAsString);
		} catch (NumberFormatException e) {
			System.err.println("input must be an integer and wasn't");
			return inputIntegerInRange(min, max);
		}
		if (inputAsInt < min || inputAsInt > max) {
			System.err.println("input out of range");
			return inputIntegerInRange(min, max);
		} else {
			return inputAsInt;
		}
	}

	public static String inputSelection(String[] choices) {
		for (int number = 1; number <= choices.length; number = number + 1) {
			System.out.print(" ");
			System.out.print(number);
			System.out.print(") ");
			System.out.println(choices[number - 1]);
		}
		return choices[inputIntegerInRange(1, choices.length) - 1];
	}

}
