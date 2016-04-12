package yami;

import hsa_new.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// yami prototype
		Console c = new Console(30,100,11,"yami");
		
		boolean alive = true;
		boolean win = false;
		
		while (alive == true) {
			c.println("You awaken in what appears to be a cave, you are tired, hungry, and it's very dark.\nIn the distance you can see a faint light, behind you the cave heads deeper.");
			c.println();
			c.print("Head [deeper] or follow the [light]? ");
			String decision = c.readString();
			if (decision.equalsIgnoreCase("deeper")) { //die in cave
				c.println();
				c.println("You head deeper into the cave.\nSuddenly there is a loud crashing sound and you hear rocks falling.\nThe light is gone.\nTrapped in the cave, you slowly die of starvation.");
				alive = false;
				break;
			} else if (decision.equalsIgnoreCase("light")) { //escape cave
				c.println();
				c.println("You head towards the light and come to the mouth of the cave.\nSoon after you exit, rocks fall and close the entrance behind you.");
			}
			c.println("You press on after leaving the cave.\nAhead, there is a fork in the path.");
			c.println();
			c.print("Take the [left] path or the [right] path? ");
			decision = c.readString();
			if (decision.equalsIgnoreCase("left")) { //risky path
				c.println();
				c.println(" As you approach the left path, you see a faded sign.\n The sign appears to be a skull and crossbones.");
				c.println();
				c.print("Take the path anyway? [yes/no] ");
				decision = c.readString();
				if (decision.equalsIgnoreCase("yes")) { //risk death
					int pass = (int)(Math.random() * 10) + 1;
					if (pass >= 1 && pass <= 5) {
						c.println();
						c.println("You fall into a deep hole, breaking your legs.\nUnable to escape, you die of starvation.");
						alive = false;
						break;
					} else {}
				} else if (decision.equalsIgnoreCase("no")) { //take the safe path
					c.println();
					c.println("You take the right path instead.");
				} else {}
			} else if (decision.equalsIgnoreCase("right")) {} //take the safe path
			c.println();
			c.println("After a short walk, you arrive in an open field.\nYou see a small pond ahead, thirsty, you approach it.");
			c.println();
			c.print("Drink the water? [yes/no] "); //risk death for thirst
			decision = c.readString();
			if (decision.equalsIgnoreCase("yes")) {  //die of cholera
				c.println();
				c.println("You drink the water and become infected with Cholera.\nOver the next few days, you slowly die of dehydration.");
				alive = false;
				break;
			} else if (decision.equalsIgnoreCase("no")) { //don't drink the water
				c.println();
				c.println("You decide against drinking the water, as it may not be safe.");
			} else {}
			c.println();
			c.println("In the distance to the north, you see a blinking light alike to a cellular tower.\nYou also hear footsteps to the west.");
			c.println();
			c.print("Head [north], [west], or [wait]? ");
			decision = c.readString();
			if (decision.equalsIgnoreCase("north")) { //camp site path
				c.println();
				c.println("You head north and find a lightly used trail.\nAlong the trail you find a wild blueberry bush.");
				c.println();
				c.print("Eat the berries? [yes/no] ");
				decision = c.readString();
				if (decision.equalsIgnoreCase("yes")) { //survive
					c.println();
					c.println("You eat some berries.\nYour stomach stops aching and you can think more clearly.\nThe juicy berries also quench your thirst.");
				} else if (decision.equalsIgnoreCase("no")) { //most likely die
					c.println();
					c.println("You decide against eating the berries.\nYou press on to the north, thoughts clouded by hunger.");
					int pass = (int)(Math.random() * 10) + 1;
					if (pass >= 1 && pass <= 7) {
						c.println();
						c.println("You suddenly black out from hunger.");
						c.println();
						c.println("You die of starvation.");
						alive = false;
						break;
					} else {}
				}
				c.println();
				c.println("You reach a small clearing in the forest.\nYou realize you have walked on to an occupied camp site.\nThe campers feed and shelter you before they take you back to civilization.");
				alive = false; //in this case alive is used even though you didn't die
				win = true; //indicates that setting alive to false is a win and not a loss
				break;
			} else if (decision.equalsIgnoreCase("west")) { //bigfoot / rescue chopper path
				
			} else if (decision.equalsIgnoreCase("wait")) { //death
				c.println();
				c.println("You wait and eventually drift to sleep.");
				try {
					Thread.sleep(2000);
				} catch(InterruptedException ie){System.err.println("Sleep interrupted");}
				c.println();
				c.println("You never wake up again.");
				alive = false;
				break;
			} else {}
		} if (win == false) { //ended game via death
			c.println("Game Over");
		} else if (win == true) { //ended game via survival
			c.println("You win!");
		} else {}
		c.println();
		c.println("Thank you for playing yami");
	}

}
