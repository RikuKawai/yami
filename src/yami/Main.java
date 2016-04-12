package yami;

import hsa_new.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// yami prototype
		Console c = new Console(30,100,11,"yami");
		
		boolean alive = true;
		int area;
		
		while (alive == true) {
			area = 1;
			c.println("You awaken in what appears to be a cave, you are tired, hungry, and it's very dark.\nIn the distance you can see a faint light, behind you the cave heads deeper.");
			c.println();
			c.print("Head [deeper] or follow the [light]? ");
			String decision = c.readString();
			if (decision.equalsIgnoreCase("deeper")) {
				c.println("You head deeper into the cave.\n Suddenly there is a loud crashing sound and you hear rocks falling.\n The light is gone.\n Trapped in the cave, you slowly die of starvation");
				alive = false;
				break;
			} else if (decision.equalsIgnoreCase("light")) {
				c.println("You head towards the light and come to the mouth of the cave.\n Soon after you exit, rocks fall and close the entrance behind you.");
				area = 2;
			}
			c.println("You press on after leaving the cave.\nAhead, there is a fork in the path.");
			c.println();
			c.print("Take the [left] path or the [right] path? ");
			decision = c.readString();
			if (decision.equalsIgnoreCase("left")) {
				c.println("As you approach the left path, you see a faded sign.\nThe sign appears to be a skull and crossbones.");
				c.println();
				c.print("Take the path anyway? [yes/no] ");
				decision = c.readString();
				if (decision.equalsIgnoreCase("yes")) {
					int pass = (int)(Math.random() * 10) + 1;
					if (pass >= 1 && pass <= 5) {
						c.println("You fall into a deep hole, breaking your legs.\n Unable to escape, you die of starvation.");
						alive = false;
						break;
					} else {}
				} else if (decision.equalsIgnoreCase("no")) {
					c.println("You take the right path instead.");
				} else {}
			} else if (decision.equalsIgnoreCase("right")) {}
			area = 3;
			c.println("After a short walk, you arrive in an open field.\n You see a small pond ahead, thirsty, you approach it.");
			c.println();
			c.print("Drink the water? [yes/no] ");
			decision = c.readString();
			if (decision.equalsIgnoreCase("yes")) { 
				c.println("You drink the water and become infected with Cholera.\n Over the next few days, you slowly die of dehydration.");
				alive = false;
				break;
			} else if (decision.equalsIgnoreCase("no")) {
				c.println("You decide against drinking the water, as it may not be safe.");
			} else {}
			area = 4;
			c.println("In the distance to the north, you see a blinking light alike to a cellular tower.\nYou also hear footsteps to the west.");
			c.println();
			c.print("Head [north], [west], or [wait]? ");
			decision = c.readString();
			if (decision.equalsIgnoreCase("north")) {
				
			}
		} c.println("Game Over");
	}

}
