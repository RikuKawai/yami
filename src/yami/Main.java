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
			}
		} c.println("Game Over");
	}

}
