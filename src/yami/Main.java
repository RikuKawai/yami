package yami;

import hsa_new.*;

public class Main {

	public static boolean alive = true;
	public static boolean win = false;
	public static boolean debug = true; //set this to true to print debug information the system console
	public static String decision;
	
	public static final String VERSION = "1.4.2"; //set version code
	public static Console c = new Console(30,100,11,"yami " + VERSION); //create console
	
	public static void main(String[] args) {
		// TODO [optional] make combat even prettier
		// yami prototype
		// @author Quinlan McNellen
		// version 1.4.2
		// 2016/04/24

		if (debug) {System.out.println("yami prototype version " + VERSION + "\n\nGame start!");}//lines like this print debug info when debug = true
		
		boolean playing = true;
		
		while (playing) {
			//begin game loop environment
			while (alive) {
				if (debug) {System.out.println("\nCAVE");} 
				c.println("You awaken in what appears to be a cave, you are tired, hungry, and it's very dark.\nIn the distance you can see a faint light, behind you the cave heads deeper.");
				c.println();
				s(650);
				c.print("Head [deeper] or follow the [light]? ");
				decision = c.readString(); //read input
				if (decision.equalsIgnoreCase("deeper")) { //die in cave
					c.clear();
					c.println("You head deeper into the cave.");
					s(1000);
					c.println("\nSuddenly there is a loud crashing sound and you hear rocks falling.");
					s(1200);
					c.println("\nThe light is gone.");
					s(1500);
					c.println("\nSuddenly there is fire all around you!");
					s(900);
					c.println("\nYou look up and see a mighty dragon!");
					s(900);
					c.println("\nYou grab a sword laying nearby...");
					s(1200);
					c.println("\n...this is no ordinary sword");
					s(1400);
					c.println("\nInfused with Excalibur's might, you engage the dragon.");
					s(1800);
					//call combat method
					yamiCombat(5, 300000, 90, 30, 45, 5000, 320000, 80, 10, 20, 6000, "Dragon", " and take your rightful place as the legendary hero.");
					break; //break out of main loop
				} else if (decision.equalsIgnoreCase("light")) { //escape cave
					if (debug) {System.out.println("\nCAVE_MOUTH");} 
					c.clear();
					c.println("You head towards the light and come to the mouth of the cave.");
					s(800);
					c.println("Soon after you exit, rocks fall and close the entrance behind you.");
					s(700);
				} else {killPlayer(); break;}
				c.println("\nYou press on after leaving the cave.");
				s(900);
				c.println("Ahead, there is a fork in the path.");
				s(650);
				c.println();
				c.print("Take the [left] path or the [right] path? ");
				decision = c.readString(); 
				if (decision.equalsIgnoreCase("left")) { //risky path
					if (debug) {System.out.println("\nLEFT_PATH_HEAD");} 
					c.clear();
					c.println("As you approach the left path, you see a faded sign.");
					s(850);
					c.println("The sign appears to be a skull and crossbones.");
					c.println();
					s(650);
					c.print("Take the path anyway? [yes/no] ");
					decision = c.readString(); //read input
					if (decision.equalsIgnoreCase("yes")) { //risk death
						int pass = random(1, 10);
						if (pass >= 1 && pass <= 5) { //50% chance of triggering
							c.clear();
							s(1200);
							c.println("You fall into a deep hole, breaking your legs.");
							s(1500);
							c.println("Unable to escape, you die of starvation.");
							yamiLose();
							break; 
						} //continue successfully
					} else if (decision.equalsIgnoreCase("no")) { //take the safe path
						c.clear();
						c.println("You take the right path instead.");
					} else {killPlayer(); break;}
				} else if (decision.equalsIgnoreCase("right")) {} //take the safe path
				if (debug) {System.out.println("\nOPEN_FIELD_POND");} 
				c.clear();
				c.println("After a short walk, you arrive in an open field.");
				s(800);
				c.println("You see a small pond ahead, thirsty, you approach it.");
				c.println();
				s(650);
				c.print("Drink the water? [yes/no] "); //risk death for thirst
				decision = c.readString();
				if (decision.equalsIgnoreCase("yes")) { //die of cholera
					c.clear();
					s(1000);
					c.println("You drink the water and become infected with Cholera.");
					s(1500);
					c.println("Over the next few days, you slowly die of dehydration.");
					yamiLose();
					break; 
				} else if (decision.equalsIgnoreCase("no")) { //don't drink the water
					c.clear();
					c.println("You decide against drinking the water, as it may not be safe.");
				} else {killPlayer(); break;}
				if (debug) {System.out.println("\nOPEN_FIELD_JUNCTION");} 
				c.println();
				s(800);
				c.println("In the distance to the north, you see a blinking light alike to a cellular tower.");
				s(750);
				c.println("You also hear footsteps to the west.");
				s(900);
				c.println("\nTo the east you can see smoke.");
				c.println();
				s(650);
				c.print("Head [north], [east], [west], or [wait]? ");
				decision = c.readString(); //read input
				if (decision.equalsIgnoreCase("north")) { //camp site path
					if (debug) {System.out.println("\nNORTHERN_TRAIL");} 
					c.clear();
					c.println("You head north and find a lightly used trail.");
					s(900);
					c.println("Along the trail you find a wild blueberry bush.");
					c.println();
					s(650);
					c.print("Eat the berries? [yes/no] ");
					decision = c.readString(); //read input
					if (decision.equalsIgnoreCase("yes")) { //survive
						c.clear();
						c.println("You eat some berries.");
						s(700);
						c.println("Your stomach stops aching and you can think more clearly.");
						s(700);
						c.println("The juicy berries also quench your thirst.");
					} else if (decision.equalsIgnoreCase("no")) { //most likely die
						c.clear();
						c.println("You decide against eating the berries.");
						s(800);
						c.println("You press on to the north, thoughts clouded by hunger.");
						s(1200);
						int pass = random(1, 10);
						if (pass >= 1 && pass <= 7) { //70% chance of triggering
							c.clear();
							c.println("You suddenly black out from hunger.");
							c.println();
							s(1500);
							c.println("You die of starvation.");
							yamiLose();
							break; 
						}  //continue successfully
					} else {killPlayer(); break;}
					if (debug) {System.out.println("\nCAMP_SITE_CLEARING");} 
					c.println();
					s(1000);
					c.println("You reach a small clearing in the forest.");
					s(900);
					c.println("You realize you have walked on to an occupied camp site.");
					s(1200);
					c.println("The campers feed and shelter you before they take you back to civilization.");
					yamiWin();
					break; 
				} else if (decision.equalsIgnoreCase("west")) { //bigfoot / rescue chopper path
					if (debug) {System.out.println("\nWEST_TRAIL_HIKER");} 
					c.clear();
					c.println("You head to the west, in the distance you see an upright figure hiking through the forest.");
					s(1000);
					c.println("Your instinct says it's an animal but your reason says it's human.");
					c.println();
					s(650);
					c.print("Approach the hiker? [yes/no] ");
					decision = c.readString(); //read input
					if (decision.equalsIgnoreCase("yes")) { //killed by bigfoot
						c.clear();
						c.println("As you approach the hiker, you realize it is tall and covered in fur.");
						s(1000);
						c.println("The Sasquatch sees you and charges, striking you with a powerful blow.");
						s(1200);
						c.println("Everything fades to black.");
						s(1500);
						c.println("You never wake up again.");
						yamiLose();
						break; 
					} else if (decision.equalsIgnoreCase("no")) { //bigfoot / rescue chopper path
						if (debug) {System.out.println("\nWEST_TRAIL_PHONE");} 
						c.clear();
						c.println("You decide to head away from the figure.");
						s(900);
						c.println("\nSomething shiny catches your eye!");
						c.println();
						s(650);
						c.print("Investigate the object? [yes/no] ");
						decision = c.readString(); //read input
						if (decision.equalsIgnoreCase("yes")) {
							c.clear();
							c.println("You find a cell phone, the battery still has some charge in it.");
							s(800);
							c.println("You call 911 and head back to the field.");
							s(1000);
							c.println("\nSoon later, a rescue chopper picks you up.");
							yamiWin();
							break; 
						} else if (decision.equalsIgnoreCase("no")) {
							if (debug) {System.out.println("\nSHRINE");} 
							c.clear();
							c.println("You walk a little further and discover a shrine.");
							s(800);
							c.println("There is a sword set in stone.");
							s(1200);
							c.println("Bigfoot is looming behind you.");
							c.println();
							s(650);
							c.print("Do you [fight] or [flee]? ");
							decision = c.readString(); //read input
							if (decision.equalsIgnoreCase("fight")) {
								c.clear();
								c.println("You draw the sword.\n");
								s(1800);
								//call combat method
								yamiCombat(2, 100, 80, 80, 12, 10, 150, 65, 15, 8, 5, "Bigfoot", " and reach a small town after a short walk.");
								break; //break out of main loop
							} else if (decision.equalsIgnoreCase("flee")) { //player chooses to flee
								int pass = random(1, 10);
								if (pass >= 1 && pass <= 5) { //50% chance of triggering
									c.clear();
									s(1400);
									c.println("Bigfoot catches up and strikes you down.");
									yamiLose();
									break; 
								} else { //continue successfully
									if (debug) {System.out.println("\nSMALL_TOWN");} 
									c.clear();
									s(1000);
									c.println("You run without looking back and reach a small town.");
									yamiWin();
									break; 
								}
							} else {killPlayer(); break;}
						} else {killPlayer(); break;}
					} else {killPlayer(); break;}
				} else if (decision.equalsIgnoreCase("wait")) { //death
					c.clear();
					c.println("You wait and eventually drift to sleep.");
					s(2000);
					c.println("\nYou never wake up again.");
					yamiLose();
					break; 
				} else if (decision.equalsIgnoreCase("east")) { //ambushed
					c.clear();
					c.println("You head to the east and find a seemingly deserted camp.");
					s(800);
					c.println("\nYou pick up a shiny object that catches your eye, it's a dagger.");
					s(1000);
					c.println("\nSuddenly you are ambushed!");
					s(1500);
					//call combat method
					yamiCombat(2, 100, 70, 25, 20, 8, 120, 95, 15, 10, 4, "Ambusher", " and reach a village after an hour of walking.");
					break; //break out of main loop
				} else {killPlayer(); break;}
			} if (win == false) { //ended game via death
				if (debug) {System.out.println("\nGAME_LOST");} 
				s(800);
				c.println("\nGame Over");
			} else if (win == true) { //ended game via survival
				if (debug) {System.out.println("\nGAME_WON");} 
				s(800);
				c.println("\nYou win!");
			}  //win is always true or false
			c.println();
			c.print("Play again? [yes/no] ");
			decision = c.readString();
			if (decision.equalsIgnoreCase("yes")) {
				alive = true;
				win = false;
				c.clear();
			}
			else if (decision.equalsIgnoreCase("no")) {
				s(1000);
				c.println("Thank you for playing yami");
				playing = false;
				break;
			} else {
				c.clear();
				s(600);
				c.println("You are suddenly resurrected!");
				s(1000);
				c.println("\nThen you spontaneously combust and die again.");
				s(1800);
				c.println("\nSeriously");
				s(900);
				c.println("\nYou died at the game over screen");
				s(1200);
				c.println("\ngit gud and launch the gaem agin skrub");
				playing = false;
				break;
			}
		} if (debug) {System.out.println("\nEnd of program");}  //end of program
	}
	public static void yamiCombat(int criticalMultiplier, int playerHealth, int playerHitRatio, int playerBlockRatio, int playerCritRatio, int playerDamage, int enemyHealth, int enemyHitRatio, int enemyBlockRatio, int enemyCritRatio, int enemyDamage, String enemyName, String winMessage) {
		// yami basic combat engine
		// @author Quinlan McNellen
		// version 2.3
		
		if (debug) {System.out.println("\nyami basic combat engine version 2.3\n\nCombat start!");} 
		//define environment variables for combat engine
		boolean fighting = true;
		boolean defend = false;
				
		if (debug) {System.out.println("\nToday you will be fighting " + enemyName);} 
		
		while (fighting) { //begin combat loop
			if (playerHealth > 0) { //check player health
				if (debug) {System.out.println("\n" + playerHealth + " PLAYER_HP");} 
				if (enemyHealth > 0) { //check enemy health
					if (debug) {System.out.println("\n" + enemyHealth + " ENEMY_HP");} 
					c.clear();
					c.println("Player: " + playerHealth + "HP" + "     " + enemyName + ": " + enemyHealth + "HP"); //print player and enemy health
					c.print("[Attack] or [defend]? ");
					if (debug) {System.out.println("\nWaiting for input...");} 
					decision = c.readString(); //read input
					if (decision.equalsIgnoreCase("attack")) { //attack enemy
						if (debug) {System.out.println("\nPLAYER_ATTACK");} 
						c.clear();
						s(700);
						c.println("You attack " + enemyName + "!");
						int hit = random(1, 100);
						if (debug) {System.out.println("\n" + hit + " PLAYER_ATTACK_CHANCE");} 
						if (hit >= 1 && hit <= playerHitRatio) { //calculate hit
							int block = random(1, 100);
							if (debug) {System.out.println("\n" + block + " ENEMY_BLOCK_CHANCE");} 
							if (block >= 1 && block <= enemyBlockRatio) {
								if (debug) {System.out.println("\nENEMY_BLOCK");} 
								s(800);
								c.println("\nYour attack is blocked!");
								s(1000);
							} else {
								if (debug) {System.out.println("\nATTACK_HIT");} 
								int crit = random(1, 100);
								if (debug) {System.out.println("\n" + crit + " PLAYER_CRIT_CHANCE");} 
								s(800);
								c.println("\nYour attack hits " + enemyName + "!");
								s(200);
								if (crit >= 1 && crit <= playerCritRatio) {
									c.println("\nA critical hit!");
									if (debug) {System.out.println("\nCRITICAL_HIT");} 
									enemyHealth = enemyHealth - (playerDamage * criticalMultiplier);
									s(200);
									c.println("\n" + (playerDamage * criticalMultiplier) + " DMG");
									if (debug) {System.out.println("\n" + (playerDamage * criticalMultiplier) + " DMG");} 
								} else {
									enemyHealth = enemyHealth - playerDamage; //decrease enemy's health by player's attack strength
									s(200);
									c.println("\n" + playerDamage + " DMG");
									if (debug) {System.out.println("\n" + playerDamage + " DMG");} 
								}
								s(600);
								defend = false; //indicate that the player is not defending
							}
						} else { //player attack misses
							if (debug) {System.out.println("\nATTACK_MISS");} 
							s(800);
							c.println("\nYour attack misses " + enemyName + "!");
							s(1000);
							defend = false; //indicate that the player is not defending
						}
					} else if (decision.equalsIgnoreCase("defend")) { //defend from the enemy's attack
						if (debug) {System.out.println("\nPLAYER_DEFEND");} 
						c.clear();
						s(700);
						c.println("You stand in defense.");
						s(1000);
						defend = true; //indicate that the player is defending
					} else {killPlayer(); break;}
					if (enemyHealth > 0) {
						if (debug) {System.out.println("\nCOMBAT_ENEMY_ATTACK");} 
						c.println("\n" + enemyName + " attacks!");
						int hit = random(1, 100);
						if (debug) {System.out.println("\n" + hit + " ENEMY_ATTACK_CHANCE");} 
						if (hit >= 1 && hit <= enemyHitRatio) { //calculate hit
							int block = random(1, 100);
							if (debug) {System.out.println("\n" + block + " PLAYER_BLOCK_CHANCE");} 
							if (block >= 1 && block <= playerBlockRatio && defend == true) {
								if (debug) {System.out.println("\nPLAYER_BLOCK");} 
								s(800);
								c.println("\nYou block the attack!");
								s(1000);
							} else {
								if (debug) {System.out.println("\nENEMY_ATTACK_HIT");} 
								int crit = random(1, 100);
								if (debug) {System.out.println("\n" + crit + " ENEMY_CRIT_CHANCE");} 
								s(800);
								c.println("\n" + enemyName + "'s attack strikes you!");
								s(200);
								if (crit >= 1 && crit <= enemyCritRatio) {
									c.println("\nA critical hit!");
									if (debug) {System.out.println("\nCRITICAL_HIT");} 
									playerHealth = playerHealth - (enemyDamage * criticalMultiplier);
									s(200);
									c.println("\n" + (enemyDamage * criticalMultiplier) + " DMG");
									if (debug) {System.out.println("\n" + (playerDamage * criticalMultiplier) + " DMG");} 
								} else {
									playerHealth = playerHealth - enemyDamage; //decrease enemy's health by player's attack strength
									s(200);
									c.println("\n" + enemyDamage + " DMG");
									if (debug) {System.out.println("\n" + enemyDamage + " DMG");} 
								}
								s(600);
							}
						} else { //enemy attack misses
							if (debug) {System.out.println("\nENEMY_ATTACK_MISS");} 
							s(800);
							c.println("\nThe attack misses!");
							s(1000);
						}
					}
				} else { //triggers when enemy health reaches 0
					if (debug) {System.out.println("\nENEMY_DEFEATED");} 
					s(500);
					c.clear();
					c.println("You defeat " + enemyName + winMessage);
					yamiWin();
					fighting = false; //set fighting to false to exit combat loop
					break; //break out of combat loop
				}
			} else { //triggers if player's health reaches 0
				if (debug) {System.out.println("\nPLAYER_DEFEATED");} 
				s(500);
				c.clear();
				c.println(enemyName + " kills you.");
				yamiLose();
				fighting = false; //set fighting to false to exit combat loop
				break; //break out of combat loop
			}
		}
	}
	public static void killPlayer() { //instantly kills the player
		c.clear();
		c.println("You spontaneously combust and die.");
		alive = false;
	}
	public static int random(int min, int max) { //generates a random number between specified numbers
		int x = (max - min) + 1;
		int random = (int)(Math.random() * x) + min; 
		return random;
	}
	public static void s(int milliseconds) { //shortens sleep statements and localizes error handling
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void yamiWin() { //sets variables for winning the game
		alive = false;
		win = true;
	}
	public static void yamiLose() { //sets variables for losing the game
		alive = false;
		win = false;
	}
}