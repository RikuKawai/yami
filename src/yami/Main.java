package yami;

import hsa_new.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// yami prototype
		Console c = new Console(30,100,11,"yami");
		c.println("You awaken in what appears to be a cave, you are tired, hungry, and it's very dark.");
		c.println("In the distance you can see a faint light, behind you the cave heads deeper.");
		c.println();
		c.print("Head [deeper] or follow the [light]?");
		
	}

}
