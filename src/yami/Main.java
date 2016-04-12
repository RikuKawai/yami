package yami;

import hsa_new.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// yami prototype
		// @author Quinlan McNellen
		// version 0.8a
		// 2016/04/12
		Console c = new Console(30,100,11,"yami"); //create console
		
		//define environment variables
		boolean alive = true; 
		boolean win = false;
		
		//begin game loop environment
		while (alive == true) {
			c.println("You awaken in what appears to be a cave, you are tired, hungry, and it's very dark.\nIn the distance you can see a faint light, behind you the cave heads deeper.");
			c.println();
			c.print("Head [deeper] or follow the [light]? ");
			String decision = c.readString(); //read input
			if (decision.equalsIgnoreCase("deeper")) { //die in cave
				c.println();
				c.println("You head deeper into the cave.\nSuddenly there is a loud crashing sound and you hear rocks falling.\nThe light is gone.\nTrapped in the cave, you slowly die of starvation.");
				alive = false; //set alive to false
				break; //break out of loop
			} else if (decision.equalsIgnoreCase("light")) { //escape cave
				c.println();
				c.println("You head towards the light and come to the mouth of the cave.\nSoon after you exit, rocks fall and close the entrance behind you.");
			} else { //kill the player if they input an invalid answer
				c.println();
				c.println("You spontaneously combust and die.");
				alive = false; //set alive to false
				break; //break out of loop
			}
			c.println("You press on after leaving the cave.\nAhead, there is a fork in the path.");
			c.println();
			c.print("Take the [left] path or the [right] path? ");
			decision = c.readString(); 
			if (decision.equalsIgnoreCase("left")) { //risky path
				c.println();
				c.println("As you approach the left path, you see a faded sign.\nThe sign appears to be a skull and crossbones.");
				c.println();
				c.print("Take the path anyway? [yes/no] ");
				decision = c.readString(); //read input
				if (decision.equalsIgnoreCase("yes")) { //risk death
					int pass = (int)(Math.random() * 10) + 1; //random number from 1 to 10
					if (pass >= 1 && pass <= 5) { //50% chance of triggering
						c.println();
						c.println("You fall into a deep hole, breaking your legs.\nUnable to escape, you die of starvation.");
						alive = false; //set alive to false
						break; //break out of loop
					} else {} //continue successfully
				} else if (decision.equalsIgnoreCase("no")) { //take the safe path
					c.println();
					c.println("You take the right path instead.");
				} else { //kill the player if they input an invalid answer
					c.println();
					c.println("You spontaneously combust and die.");
					alive = false; //set alive to false
					break; //break out of loop
				}
			} else if (decision.equalsIgnoreCase("right")) {} //take the safe path
			c.println();
			c.println("After a short walk, you arrive in an open field.\nYou see a small pond ahead, thirsty, you approach it.");
			c.println();
			c.print("Drink the water? [yes/no] "); //risk death for thirst
			decision = c.readString();
			if (decision.equalsIgnoreCase("yes")) {  //die of cholera
				c.println();
				c.println("You drink the water and become infected with Cholera.\nOver the next few days, you slowly die of dehydration.");
				alive = false; //set alive to false
				break; //break out of loop
			} else if (decision.equalsIgnoreCase("no")) { //don't drink the water
				c.println();
				c.println("You decide against drinking the water, as it may not be safe.");
			} else { //kill the player if they input an invalid answer
				c.println();
				c.println("You spontaneously combust and die.");
				alive = false; //set alive to false
				break; //break out of loop
			}
			c.println();
			c.println("In the distance to the north, you see a blinking light alike to a cellular tower.\nYou also hear footsteps to the west.");
			c.println();
			c.print("Head [north], [west], or [wait]? ");
			decision = c.readString(); //read input
			if (decision.equalsIgnoreCase("north")) { //camp site path
				c.println();
				c.println("You head north and find a lightly used trail.\nAlong the trail you find a wild blueberry bush.");
				c.println();
				c.print("Eat the berries? [yes/no] ");
				decision = c.readString(); //read input
				if (decision.equalsIgnoreCase("yes")) { //survive
					c.println();
					c.println("You eat some berries.\nYour stomach stops aching and you can think more clearly.\nThe juicy berries also quench your thirst.");
				} else if (decision.equalsIgnoreCase("no")) { //most likely die
					c.println();
					c.println("You decide against eating the berries.\nYou press on to the north, thoughts clouded by hunger.");
					int pass = (int)(Math.random() * 10) + 1; //generate a random number from 1 to 10
					if (pass >= 1 && pass <= 7) { //70% chance of triggering
						c.println();
						c.println("You suddenly black out from hunger.");
						c.println();
						c.println("You die of starvation.");
						alive = false; //set alive to false
						break; //break out of loop
					} else {} //continue successfully
				} else { //kill the player if they input an invalid answer
					c.println();
					c.println("You spontaneously combust and die.");
					alive = false;
					break;
				}
				c.println();
				c.println("You reach a small clearing in the forest.\nYou realize you have walked on to an occupied camp site.\nThe campers feed and shelter you before they take you back to civilization.");
				alive = false; //in this case alive is used even though you didn't die
				win = true; //indicates that setting alive to false is a win and not a loss
				break; //break out of loop
			} else if (decision.equalsIgnoreCase("west")) { //bigfoot / rescue chopper path
				c.println();
				c.println("You head to the west, in the distance you see an upright figure hiking through the forest.\nYour instinct says it's an animal but your reason says it's human.");
				c.println();
				c.print("Approach the hiker? [yes/no] ");
				decision = c.readString(); //read input
				if (decision.equalsIgnoreCase("yes")) { //killed by bigfoot
					c.println();
					c.println("As you approach the hiker, you realize it is tall and covered in fur.\n");
					c.println("The Sasquatch sees you and charges, striking you with a powerful blow.\nEverything fades to black.\n");
					c.println("You never wake up again.");
					alive = false; //set alive to false
					break; //break out of loop
				} else if (decision.equalsIgnoreCase("no")) { //bigfoot / rescue chopper path
					c.println();
					c.println("You decide to head away from the figure.\n\nSomething shiny catches your eye");
					c.println();
					c.print("Investigate the object? [yes/no] ");
					decision = c.readString(); //read input
					if (decision.equalsIgnoreCase("yes")) {
						c.println();
						c.println("You find a cell phone, the battery still has some charge in it.\nYou call 911 and head back to the field.\n\nSoon later, a rescue chopper picks you up.");
						alive = false; //alive is used to end the game
						win = true; //win indicates that the game ended in survival and not death
						break; //break out of loop
					} else if (decision.equalsIgnoreCase("no")) {
						c.println();
						c.println("You walk a little further and discover a shrine.\nThere is a sword set in stone, Bigfoot is looming behind you.");
						c.println();
						c.print("Do you [fight] or [flee]? ");
						decision = c.readString(); //read input
						if (decision.equalsIgnoreCase("fight")) {
							c.println();
							c.println("You draw the sword.\n");
							c.println("Coming soon lol ;)");
							alive = false; //set alive to false
							break; //break out of loop
						} else if (decision.equalsIgnoreCase("flee")) {
							int pass = (int)(Math.random() * 10) + 1; //generate a random number from 1 to 10
							if (pass >= 1 && pass <= 5) { //50% chance of triggering
								c.println();
								c.println("You are killed by Bigfoot.");
								alive = false; //set alive to false
								break; //break out of loop
							} else { //continue successfully
								c.println();
								c.println("You run without looking back and reach a small town.");
								alive = false; //set alive to false to end the game
								win = true; //indicate that the player survived
								break; //break out of loop
							}
						} else { //kill the player if they input an invalid answer
							c.println();
							c.println("You spontaneously combust and die.");
							alive = false;
							break;
						}
					} else { //kill the player if they input an invalid answer
						c.println();
						c.println("You spontaneously combust and die.");
						alive = false;
						break;
					}
				} else { //kill the player if they input an invalid answer
					c.println();
					c.println("You spontaneously combust and die.");
					alive = false;
					break;
				}
			} else if (decision.equalsIgnoreCase("wait")) { //death
				c.println();
				c.println("You wait and eventually drift to sleep.");
				try {
					Thread.sleep(2000);
				} catch(InterruptedException ie){System.err.println("Sleep interrupted");}
				c.println();
				c.println("You never wake up again.");
				alive = false; //set alive to false
				break; //break out of loop
			} else { //kill the player if they input an invalid answer
				c.println();
				c.println("You spontaneously combust and die.");
				alive = false; //set alive to false
				break; //break out of loop
			}
		} if (win == false) { //ended game via death
			c.println();
			c.println("Game Over");
		} else if (win == true) { //ended game via survival
			c.println();
			c.println("You win!");
		} else {}
		c.println();
		c.println("Thank you for playing yami");
		//end of program
	}

}
