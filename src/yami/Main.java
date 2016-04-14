package yami;

import hsa_new.*;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO [optional] make combat even prettier
		// yami prototype
		// @author Quinlan McNellen
		// version 1.2
		// 2016/04/14
		boolean debug = false; //set this to true to print debug information the system console
		final String VERSION = "1.2"; //set version code
		
		Console c = new Console(30,100,11,"yami"); //create console
		if (debug == true) {System.out.println("yami prototype version " + VERSION + "\n\nGame start!");} else {} //lines like this print debug info when debug = true
		//define environment variables
		boolean alive = true; 
		boolean win = false;
		
		//begin game loop environment
		while (alive == true) {
			if (debug == true) {System.out.println("\nCAVE");} else {}
			c.println("You awaken in what appears to be a cave, you are tired, hungry, and it's very dark.\nIn the distance you can see a faint light, behind you the cave heads deeper.");
			c.println();
			Thread.sleep(650);
			c.print("Head [deeper] or follow the [light]? ");
			String decision = c.readString(); //read input
			if (decision.equalsIgnoreCase("deeper")) { //die in cave
				c.clear();
				c.println("You head deeper into the cave.");
				Thread.sleep(1000);
				c.println("Suddenly there is a loud crashing sound and you hear rocks falling.");
				Thread.sleep(1200);
				c.println("The light is gone.");
				Thread.sleep(1500);
				c.println("Trapped in the cave, you slowly die of starvation.");
				alive = false; 
				break; 
			} else if (decision.equalsIgnoreCase("light")) { //escape cave
				if (debug == true) {System.out.println("\nCAVE_MOUTH");} else {}
				c.clear();
				c.println("You head towards the light and come to the mouth of the cave.");
				Thread.sleep(800);
				c.println("Soon after you exit, rocks fall and close the entrance behind you.");
				Thread.sleep(700);
			} else { //kill the player if they input an invalid answer
				c.clear();
				c.println("You spontaneously combust and die.");
				alive = false; 
				break; 
			}
			c.println("\nYou press on after leaving the cave.");
			Thread.sleep(900);
			c.println("Ahead, there is a fork in the path.");
			Thread.sleep(650);
			c.println();
			c.print("Take the [left] path or the [right] path? ");
			decision = c.readString(); 
			if (decision.equalsIgnoreCase("left")) { //risky path
				if (debug == true) {System.out.println("\nLEFT_PATH_HEAD");} else {}
				c.clear();
				c.println("As you approach the left path, you see a faded sign.");
				Thread.sleep(850);
				c.println("The sign appears to be a skull and crossbones.");
				c.println();
				Thread.sleep(650);
				c.print("Take the path anyway? [yes/no] ");
				decision = c.readString(); //read input
				if (decision.equalsIgnoreCase("yes")) { //risk death
					int pass = (int)(Math.random() * 10) + 1; //random number from 1 to 10
					if (pass >= 1 && pass <= 5) { //50% chance of triggering
						c.clear();
						Thread.sleep(1200);
						c.println("You fall into a deep hole, breaking your legs.");
						Thread.sleep(1500);
						c.println("Unable to escape, you die of starvation.");
						alive = false; 
						break; 
					} else {} //continue successfully
				} else if (decision.equalsIgnoreCase("no")) { //take the safe path
					c.clear();
					c.println("You take the right path instead.");
				} else { //kill the player if they input an invalid answer
					c.clear();
					c.println("You spontaneously combust and die.");
					alive = false; 
					break; 
				}
			} else if (decision.equalsIgnoreCase("right")) {} //take the safe path
			if (debug == true) {System.out.println("\nOPEN_FIELD_POND");} else {}
			c.clear();
			c.println("After a short walk, you arrive in an open field.");
			Thread.sleep(800);
			c.println("You see a small pond ahead, thirsty, you approach it.");
			c.println();
			Thread.sleep(650);
			c.print("Drink the water? [yes/no] "); //risk death for thirst
			decision = c.readString();
			if (decision.equalsIgnoreCase("yes")) {  //die of cholera
				c.clear();
				Thread.sleep(1000);
				c.println("You drink the water and become infected with Cholera.");
				Thread.sleep(1500);
				c.println("Over the next few days, you slowly die of dehydration.");
				alive = false; 
				break; 
			} else if (decision.equalsIgnoreCase("no")) { //don't drink the water
				c.clear();
				c.println("You decide against drinking the water, as it may not be safe.");
			} else { //kill the player if they input an invalid answer
				c.clear();
				c.println("You spontaneously combust and die.");
				alive = false; 
				break; 
			}
			if (debug == true) {System.out.println("\nOPEN_FIELD_JUNCTION");} else {}
			c.println();
			Thread.sleep(800);
			c.println("In the distance to the north, you see a blinking light alike to a cellular tower.");
			Thread.sleep(750);
			c.println("You also hear footsteps to the west.");
			c.println();
			Thread.sleep(650);
			c.print("Head [north], [west], or [wait]? ");
			decision = c.readString(); //read input
			if (decision.equalsIgnoreCase("north")) { //camp site path
				if (debug == true) {System.out.println("\nNORTHERN_TRAIL");} else {}
				c.clear();
				c.println("You head north and find a lightly used trail.");
				Thread.sleep(900);
				c.println("Along the trail you find a wild blueberry bush.");
				c.println();
				Thread.sleep(650);
				c.print("Eat the berries? [yes/no] ");
				decision = c.readString(); //read input
				if (decision.equalsIgnoreCase("yes")) { //survive
					c.clear();
					c.println("You eat some berries.");
					Thread.sleep(700);
					c.println("Your stomach stops aching and you can think more clearly.");
					Thread.sleep(700);
					c.println("The juicy berries also quench your thirst.");
				} else if (decision.equalsIgnoreCase("no")) { //most likely die
					c.clear();
					c.println("You decide against eating the berries.");
					Thread.sleep(800);
					c.println("You press on to the north, thoughts clouded by hunger.");
					Thread.sleep(1200);
					int pass = (int)(Math.random() * 10) + 1; //generate a random number from 1 to 10
					if (pass >= 1 && pass <= 7) { //70% chance of triggering
						c.clear();
						c.println("You suddenly black out from hunger.");
						c.println();
						Thread.sleep(1500);
						c.println("You die of starvation.");
						alive = false; 
						break; 
					} else {} //continue successfully
				} else { //kill the player if they input an invalid answer
					c.clear();
					c.println("You spontaneously combust and die.");
					alive = false; 
					break; 
				}
				if (debug == true) {System.out.println("\nCAMP_SITE_CLEARING");} else {}
				c.println();
				Thread.sleep(1000);
				c.println("You reach a small clearing in the forest.");
				Thread.sleep(900);
				c.println("You realize you have walked on to an occupied camp site.");
				Thread.sleep(1200);
				c.println("The campers feed and shelter you before they take you back to civilization.");
				alive = false; //in this case alive is used even though you didn't die
				win = true; //indicates that setting alive to false is a win and not a loss
				break; 
			} else if (decision.equalsIgnoreCase("west")) { //bigfoot / rescue chopper path
				if (debug == true) {System.out.println("\nWEST_TRAIL_HIKER");} else {}
				c.clear();
				c.println("You head to the west, in the distance you see an upright figure hiking through the forest.");
				Thread.sleep(1000);
				c.println("Your instinct says it's an animal but your reason says it's human.");
				c.println();
				Thread.sleep(650);
				c.print("Approach the hiker? [yes/no] ");
				decision = c.readString(); //read input
				if (decision.equalsIgnoreCase("yes")) { //killed by bigfoot
					c.clear();
					c.println("As you approach the hiker, you realize it is tall and covered in fur.");
					Thread.sleep(1000);
					c.println("The Sasquatch sees you and charges, striking you with a powerful blow.");
					Thread.sleep(1200);
					c.println("Everything fades to black.");
					Thread.sleep(1500);
					c.println("You never wake up again.");
					alive = false; 
					break; 
				} else if (decision.equalsIgnoreCase("no")) { //bigfoot / rescue chopper path
					if (debug == true) {System.out.println("\nWEST_TRAIL_PHONE");} else {}
					c.clear();
					c.println("You decide to head away from the figure.");
					Thread.sleep(900);
					c.println("\nSomething shiny catches your eye!");
					c.println();
					Thread.sleep(650);
					c.print("Investigate the object? [yes/no] ");
					decision = c.readString(); //read input
					if (decision.equalsIgnoreCase("yes")) {
						c.clear();
						c.println("You find a cell phone, the battery still has some charge in it.");
						Thread.sleep(800);
						c.println("You call 911 and head back to the field.");
						Thread.sleep(1000);
						c.println("\nSoon later, a rescue chopper picks you up.");
						alive = false; //alive is used to end the game
						win = true; //win indicates that the game ended in survival and not death
						break; 
					} else if (decision.equalsIgnoreCase("no")) {
						if (debug == true) {System.out.println("\nSHRINE");} else {}
						c.clear();
						c.println("You walk a little further and discover a shrine.");
						Thread.sleep(800);
						c.println("There is a sword set in stone.");
						Thread.sleep(1200);
						c.println("Bigfoot is looming behind you.");
						c.println();
						Thread.sleep(650);
						c.print("Do you [fight] or [flee]? ");
						decision = c.readString(); //read input
						if (decision.equalsIgnoreCase("fight")) {
							c.clear();
							c.println("You draw the sword.\n");
							Thread.sleep(1800);
							
							// yami basic combat engine
							// @author Quinlan McNellen
							// version 1.0
							
							//uncomment the next line if using the combat engine outside of yami
							//boolean debug = false;
							if (debug == true) {System.out.println("\nyami basic combat engine version 1.0\n\nCombat start!");} else {}
							//define environment variables for combat engine
							boolean fighting = true;
							boolean defend = false;
							//player variables
							int playerHealth = 100;
							int playerHitRatio = 80;
							int playerBlockRatio = 90;
							int playerCritRatio = 10;
							int playerDamage = 10;
							//enemy variables
							int enemyHealth = 150;
							int enemyHitRatio = 60;
							int enemyDamage = 5;
							//configurable strings
							String enemyName = "Bigfoot";
							String winMessage = " and reach a small town after a short walk.";
							
							while (fighting == true) { //begin combat loop
								if (playerHealth > 0) { //check player health
									if (debug == true) {System.out.println("\n" + playerHealth + " PLAYER_HITS");} else {}
									if (enemyHealth > 0) { //check enemy health
										if (debug == true) {System.out.println("\n" + enemyHealth + " ENEMY_HITS");} else {}
										c.clear();
										c.println("Player: " + playerHealth + "HP" + "     " + enemyName + ": " + enemyHealth + "HP"); //print player and enemy health
										c.print("[Attack] or [defend]? ");
										if (debug == true) {System.out.println("\nWaiting for input...");} else {}
										decision = c.readString(); //read input
										if (decision.equalsIgnoreCase("attack")) { //attack enemy
											if (debug == true) {System.out.println("\nCOMBAT_ATTACK");} else {}
											c.clear();
											Thread.sleep(700);
											c.println("You attack " + enemyName + "!");
											int hit = (int)(Math.random() * 100) + 1; //generate a random number from 1 to 100
											if (debug == true) {System.out.println("\n" + hit + " PLAYER_ATTACK_CHANCE");} else {}
											if (hit >= 1 && hit <= playerHitRatio) { //calculate hit
												if (debug == true) {System.out.println("\nATTACK_HIT");} else {}
												c.println();
												int crit = (int)(Math.random() * 100) + 1;
												Thread.sleep(800);
												c.println("Your attack hits " + enemyName + "!");
												Thread.sleep(200);
												if (crit >= 1 && crit <= playerCritRatio) {
													c.println("\nA critical hit!");
													enemyHealth = enemyHealth - (playerDamage * 2);
													Thread.sleep(200);
													c.println("\n" + (playerDamage * 2) + " DMG");
												} else {
													enemyHealth = enemyHealth - playerDamage; //decrease enemy's health by player's attack strength
													Thread.sleep(200);
													c.println("\n" + playerDamage + " DMG");
												}
												Thread.sleep(600);
												defend = false; //indicate that the player is not defending
											} else { //player attack misses
												if (debug == true) {System.out.println("\nATTACK_MISS");} else {}
												c.println();
												Thread.sleep(800);
												c.println("You attack misses " + enemyName + "!");
												Thread.sleep(1000);
												defend = false; //indicate that the player is not defending
											}
										} else if (decision.equalsIgnoreCase("defend")) { //defend from the enemy's attack
											if (debug == true) {System.out.println("\nCOMBAT_DEFEND");} else {}
											c.clear();
											Thread.sleep(700);
											c.println("You stand in defense.");
											Thread.sleep(1000);
											defend = true; //indicate that the player is defending
										} else { //kill the player if they input an invalid answer
											c.clear();
											c.println("You spontaneously combust and die.");
											alive = false; 
											break; 
										}
										if (enemyHealth > 0) {
											if (debug == true) {System.out.println("\nCOMBAT_ENEMY_ATTACK");} else {}
											c.clear();
											Thread.sleep(700);
											c.println(enemyName + " attacks!");
											int hit = (int)(Math.random() * 100) + 1; //generate a random number between 1 and 100
											if (debug == true) {System.out.println("\n" + hit + " ENEMY_ATTACK_VALUE");} else {}
											if (hit >= 1 && hit <= enemyHitRatio) { //calculate hit
												if (defend == true) { //triggers if the player chose to defend
													if (debug == true) {System.out.println("\nPLAYER_DEFENDING");} else {}
													int block = (int)(Math.random() * 100) + 1; //generate a random number between 1 and 100
													if (debug == true) {System.out.println("\n" + block + " PLAYER_BLOCK_VALUE");} else {}
														if (block >= 1 && block <= playerBlockRatio) { //calculate block
															if (debug == true) {System.out.println("\nPLAYER_BLOCK");} else {}
															c.println();
															Thread.sleep(800);
															c.println(enemyName + "'s attack is blocked!");
															Thread.sleep(1000);
														} else {
															if (debug == true) {System.out.println("\nPLAYER_BLOCK_FAIL");} else {}
														} //continue if block fails
												} else { //enemy hits the player
													if (debug == true) {System.out.println("\nENEMY_ATTACK_HIT");} else {}
													c.println();
													Thread.sleep(800);
													c.println(enemyName + "'s attack strikes you!");
													Thread.sleep(200);
													c.println("\n" + enemyDamage + " DMG");
													Thread.sleep(800);
													playerHealth = playerHealth - enemyDamage; //decreases player health by enemy's attack strength
												}
											} else { //attack misses
												if (debug == true) {System.out.println("\nENEMY_ATTACK_MISS");} else {}
												c.println();
												Thread.sleep(800);
												c.println(enemyName + "'s attack misses you!");
												Thread.sleep(1000);
											}
										} else {}
									} else { //triggers when enemy health reaches 0
										if (debug == true) {System.out.println("\nENEMY_DEFEATED");} else {}
										Thread.sleep(500);
										c.clear();
										c.println("You defeat " + enemyName + winMessage);
										alive = false; //set alive to false to exit main loop
										win = true; //indicate that the player survived
										fighting = false; //set fighting to false to exit combat loop
										break; //break out of combat loop
									}
								} else { //triggers if player's health reaches 0
									if (debug == true) {System.out.println("\nPLAYER_DEFEATED");} else {}
									Thread.sleep(500);
									c.clear();
									c.println(enemyName + " kills you.");
									alive = false; //set alive to false to exit main loop
									fighting = false; //set fighting to false to exit combat loop
									break; //break out of combat loop
								}
							} break; //break out of main loop
						} else if (decision.equalsIgnoreCase("flee")) { //player chooses to flee
							int pass = (int)(Math.random() * 10) + 1; //generate a random number from 1 to 10
							if (pass >= 1 && pass <= 5) { //50% chance of triggering
								c.clear();
								Thread.sleep(1400);
								c.println("Bigfoot catches up and strikes you down.");
								alive = false; 
								break; 
							} else { //continue successfully
								if (debug == true) {System.out.println("\nSMALL_TOWN");} else {}
								c.clear();
								Thread.sleep(1000);
								c.println("You run without looking back and reach a small town.");
								alive = false; //set alive to false to end the game
								win = true; //indicate that the player survived
								break; 
							}
						} else { //kill the player if they input an invalid answer
							c.clear();
							c.println("You spontaneously combust and die.");
							alive = false; 
							break; 
						}
					} else { //kill the player if they input an invalid answer
						c.clear();
						c.println("You spontaneously combust and die.");
						alive = false; 
						break; 
					}
				} else { //kill the player if they input an invalid answer
					c.clear();
					c.println("You spontaneously combust and die.");
					alive = false; 
					break; 
				}
			} else if (decision.equalsIgnoreCase("wait")) { //death
				c.clear();
				c.println("You wait and eventually drift to sleep.");
				Thread.sleep(2000);
				c.println();
				c.println("You never wake up again.");
				alive = false; 
				break; 
			} else { //kill the player if they input an invalid answer
				c.clear();
				c.println("You spontaneously combust and die.");
				alive = false; 
				break; 
			}
		} if (win == false) { //ended game via death
			if (debug == true) {System.out.println("\nGAME_LOST");} else {}
			c.println();
			Thread.sleep(800);
			c.println("Game Over");
		} else if (win == true) { //ended game via survival
			if (debug == true) {System.out.println("\nGAME_WON");} else {}
			c.println();
			Thread.sleep(800);
			c.println("You win!");
		} else {} //win is always true or false
		c.println();
		Thread.sleep(1000);
		c.println("Thank you for playing yami");
		if (debug == true) {System.out.println("\nEnd of program");} else {}
		//end of program
	}

}
