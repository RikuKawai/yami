package yami;

import hsa_new.*;

public class Main {

	public static void main(String[] args) {
		// TODO [non critical] add delays
		// yami prototype
		// @author Quinlan McNellen
		// version 1.0a
		// 2016/04/13
		boolean debug = false; //set this to true to print debug information the system console
		
		Console c = new Console(30,100,11,"yami"); //create console
		if (debug == true) {System.out.println("yami prototype version 1.0\n\nGame start!");} else {}
		//define environment variables
		boolean alive = true; 
		boolean win = false;
		
		//begin game loop environment
		while (alive == true) {
			if (debug == true) {System.out.println("\nCAVE");} else {}
			c.println("You awaken in what appears to be a cave, you are tired, hungry, and it's very dark.\nIn the distance you can see a faint light, behind you the cave heads deeper.");
			c.println();
			//try {Thread.sleep(500);} catch(InterruptedException ie){System.err.println("Sleep interrupted");}
			c.print("Head [deeper] or follow the [light]? ");
			String decision = c.readString(); //read input
			if (decision.equalsIgnoreCase("deeper")) { //die in cave
				c.println();
				//try {Thread.sleep(500);} catch(InterruptedException ie){System.err.println("Sleep interrupted");}
				c.println("You head deeper into the cave.\n");
				//try {Thread.sleep(700);} catch(InterruptedException ie){System.err.println("Sleep interrupted");}
				c.println("Suddenly there is a loud crashing sound and you hear rocks falling.\n");
				//try {Thread.sleep(300);} catch(InterruptedException ie){System.err.println("Sleep interrupted");}
				c.println("The light is gone.\n");
				//try {Thread.sleep(900);} catch(InterruptedException ie){System.err.println("Sleep interrupted");}
				c.println("Trapped in the cave, you slowly die of starvation.");
				alive = false; //set alive to false
				break; //break out of loop
			} else if (decision.equalsIgnoreCase("light")) { //escape cave
				if (debug == true) {System.out.println("\nCAVE_MOUTH");} else {}
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
				if (debug == true) {System.out.println("\nLEFT_PATH_HEAD");} else {}
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
			if (debug == true) {System.out.println("\nOPEN_FIELD_POND");} else {}
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
			if (debug == true) {System.out.println("\nOPEN_FIELD_JUNCTION");} else {}
			c.println();
			c.println("In the distance to the north, you see a blinking light alike to a cellular tower.\nYou also hear footsteps to the west.");
			c.println();
			c.print("Head [north], [west], or [wait]? ");
			decision = c.readString(); //read input
			if (decision.equalsIgnoreCase("north")) { //camp site path
				if (debug == true) {System.out.println("\nNORTHERN_TRAIL");} else {}
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
					alive = false; //set alive to false
					break; //break out of loop
				}
				if (debug == true) {System.out.println("\nCAMP_SITE_CLEARING");} else {}
				c.println();
				c.println("You reach a small clearing in the forest.\nYou realize you have walked on to an occupied camp site.\nThe campers feed and shelter you before they take you back to civilization.");
				alive = false; //in this case alive is used even though you didn't die
				win = true; //indicates that setting alive to false is a win and not a loss
				break; //break out of loop
			} else if (decision.equalsIgnoreCase("west")) { //bigfoot / rescue chopper path
				if (debug == true) {System.out.println("\nWEST_TRAIL_HIKER");} else {}
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
					if (debug == true) {System.out.println("\nWEST_TRAIL_PHONE");} else {}
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
						if (debug == true) {System.out.println("\nSHRINE");} else {}
						c.println();
						c.println("You walk a little further and discover a shrine.\nThere is a sword set in stone, Bigfoot is looming behind you.");
						c.println();
						c.print("Do you [fight] or [flee]? ");
						decision = c.readString(); //read input
						if (decision.equalsIgnoreCase("fight")) {
							c.println();
							c.println("You draw the sword.\n");
							//define environment variables for combat engine
							if (debug == true) {System.out.println("\nyami basic combat engine version 0.3\n\nCombat start!");} else {}
							boolean fighting = true;
							boolean defend = false;
							int playerHits = 0;
							int bigfootHits = 0;
							while (fighting == true) { //begin combat loop
								if (playerHits < 3) { //check player health
									if (debug == true) {System.out.println("\n" + playerHits + " PLAYER_HITS");} else {}
									if (bigfootHits < 4) { //check bigfoot health
										if (debug == true) {System.out.println("\n" + bigfootHits + " BIGFOOT_HITS");} else {}
										c.println("[Attack] or [defend]? ");
										if (debug == true) {System.out.println("\nWaiting for input...");} else {}
										decision = c.readString(); //read input
										if (decision.equalsIgnoreCase("attack")) { //attack bigfoot
											if (debug == true) {System.out.println("\nCOMBAT_ATTACK");} else {}
											c.println();
											c.println("You attack Bigfoot!");
											int hit = (int)(Math.random() * 10) + 1; //generate a random number from 1 to 10
											if (debug == true) {System.out.println("\n" + hit + " PLAYER_ATTACK_VALUE");} else {}
											if (hit >= 1 && hit <= 8) { //80% hit ratio
												if (debug == true) {System.out.println("\nATTACK_HIT");} else {}
												c.println();
												c.println("Your attack hits Bigfoot!");
												bigfootHits++; //increase bigfoot's sustained hits
												defend = false; //indicate that the player is not defending
											} else { //player attack misses
												if (debug == true) {System.out.println("\nATTACK_MISS");} else {}
												c.println();
												c.println("You attack misses Bigfoot!");
												defend = false; //indicate that the player is not defending
											}
										} else if (decision.equalsIgnoreCase("defend")) { //defend from bigfoot's attack
											if (debug == true) {System.out.println("\nCOMBAT_DEFEND");} else {}
											c.println();
											c.println("You stand in defense.");
											defend = true; //indicate that the player is defending
										} else { //kill the player if they input an invalid answer
											c.println();
											c.println("You spontaneously combust and die.");
											alive = false; //set alive to false
											break; //break out of loop
										}
										if (debug == true) {System.out.println("\nCOMBAT_ENEMY_ATTACK");} else {}
										c.println();
										c.println("Bigfoot attacks!");
										int hit = (int)(Math.random() * 10) + 1; //generate a random number between 1 and 10
										if (debug == true) {System.out.println("\n" + hit + " ENEMY_ATTACK_VALUE");} else {}
										if (hit >= 1 && hit <= 4) { //40% chance to miss
											if (debug == true) {System.out.println("\nENEMY_ATTACK_MISS");} else {}
											c.println();
											c.println("Bigfoot's attack misses you!");
										} else { //60% chance to hit
											if (defend == true) { //triggers if the player chose to defend
												if (debug == true) {System.out.println("\nPLAYER_DEFENDING");} else {}
												int block = (int)(Math.random() * 10) + 1; //generate a random number between 1 and 10
												if (debug == true) {System.out.println("\n" + block + " PLAYER_BLOCK_VALUE");} else {}
												if (block >= 1 && block <= 9) { //90% block ratio
													if (debug == true) {System.out.println("\nPLAYER_BLOCK");} else {}
													c.println();
													c.println("Bigfoot's attack is blocked!");
												} else {
													if (debug == true) {System.out.println("\nPLAYER_BLOCK_FAIL");} else {}
												} //continue if block fails
											} else { //bigfoot hits the player
												if (debug == true) {System.out.println("\nENEMY_ATTACK_HIT");} else {}
												c.println();
												c.println("Bigfoot's attack strikes you!");
												playerHits++; //increase player's sustained hits
											}
										}
									} else { //triggers if bigfoot's hits reach 4
										if (debug == true) {System.out.println("\nENEMY_DEFEATED");} else {}
										c.println("You defeat Bigfoot and reach a small town after a short walk.");
										alive = false; //set alive to false to exit main loop
										win = true; //indicate that the player survived
										fighting = false; //set fighting to false to exit combat loop
										break; //break out of combat loop
									}
								} else { //triggers if player's hits reach 3
									if (debug == true) {System.out.println("\nPLAYER_DEFEATED");} else {}
									c.println();
									c.println("Bigfoot kills you.");
									alive = false; //set alive to false to exit main loop
									fighting = false; //set fighting to false to exit combat loop
									break; //break out of combat loop
								}
							} break; //break out of main loop
						} else if (decision.equalsIgnoreCase("flee")) { //player chooses to flee
							int pass = (int)(Math.random() * 10) + 1; //generate a random number from 1 to 10
							if (pass >= 1 && pass <= 5) { //50% chance of triggering
								c.println();
								c.println("You are killed by Bigfoot.");
								alive = false; //set alive to false
								break; //break out of loop
							} else { //continue successfully
								if (debug == true) {System.out.println("\nSMALL_TOWN");} else {}
								c.println();
								c.println("You run without looking back and reach a small town.");
								alive = false; //set alive to false to end the game
								win = true; //indicate that the player survived
								break; //break out of loop
							}
						} else { //kill the player if they input an invalid answer
							c.println();
							c.println("You spontaneously combust and die.");
							alive = false; //set alive to false
							break; //break out of loop
						}
					} else { //kill the player if they input an invalid answer
						c.println();
						c.println("You spontaneously combust and die.");
						alive = false; //set alive to false
						break; //break out of loop
					}
				} else { //kill the player if they input an invalid answer
					c.println();
					c.println("You spontaneously combust and die.");
					alive = false; //set alive to false
					break; //break out of loop
				}
			} else if (decision.equalsIgnoreCase("wait")) { //death
				c.println();
				c.println("You wait and eventually drift to sleep.");
				try {Thread.sleep(2000);} catch(InterruptedException ie){System.err.println("Sleep interrupted");}
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
			if (debug == true) {System.out.println("\nGAME_LOST");} else {}
			c.println();
			c.println("Game Over");
		} else if (win == true) { //ended game via survival
			if (debug == true) {System.out.println("\nGAME_WON");} else {}
			c.println();
			c.println("You win!");
		} else {} //win is always true or false
		c.println();
		c.println("Thank you for playing yami");
		if (debug == true) {System.out.println("\nEnd of program");} else {}
		//end of program
	}

}
