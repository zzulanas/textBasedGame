package textBasedGame;

import java.util.Scanner;

public class PlayGame {

	public static Locations world = new Locations("World", "The Games World");
	static Player player1 = new Player("Name", "Player of the game");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		//Action actionReader = new Action();
		

		//System.out.println("*************************************************");
		/*
		System.out.println(  "\n  ██▀███   ▒█████   ▒█████   ███▄ ▄███▓  ██████ "
							+"\n ▓██ ▒ ██▒▒██▒  ██▒▒██▒  ██▒▓██▒▀█▀ ██▒▒██    ▒" 
							+"\n ▓██ ░▄█ ▒▒██░  ██▒▒██░  ██▒▓██    ▓██░░ ▓██▄  "
							+"\n ▒██▀▀█▄  ▒██   ██░▒██   ██░▒██    ▒██   ▒   ██▒"
							+"\n ░██▓ ▒██▒░ ████▓▒░░ ████▓▒░▒██▒   ░██▒▒██████▒▒"
							+"\n ░ ▒▓ ░▒▓░░ ▒░▒░▒░ ░ ▒░▒░▒░ ░ ▒░   ░  ░▒ ▒▓▒ ▒ ░"
							+"\n   ░▒ ░ ▒░  ░ ▒ ▒░   ░ ▒ ▒░ ░  ░      ░░ ░▒  ░ ░"
							+"\n   ░░   ░ ░ ░ ░ ▒  ░ ░ ░ ▒  ░      ░   ░  ░  ░  "
							+"\n   ░         ░ ░      ░ ░         ░         ░   "
							+"\n                                               ");
		//System.out.println("*************************************************");
		 
		 */
		System.out.println("Rooms");
		System.out.println();
		System.out.println("You wake up lying on the ground in a hallway. The room smells of antiseptic and oil. You don't"
				+ "\nremember anything, except that you don't belong here. To the right of you lies a map. You pick"
				+ "\nit up and realize you need to escape this place. (Type \"help\" for possible moves)");

		boolean end = false;
		String action = "";
		

		while (end != true) {
			System.out.println();
			System.out.print("What do you do?  ");
			readAction(scan.nextLine());
		}

	}

	//Reads in the string and sends it to static methods in the action class
	//where the commands move the game forward
	public static void readAction(String a) {
		if (a.length() > 3 && a.substring(0, 4).equalsIgnoreCase("move")) {
			Action.move(world, a, player1);
		} else if (a.equalsIgnoreCase("help")){
			Action.help(world, a);
		} else if (a.equalsIgnoreCase("open door")){
			Action.openDoor(world, player1, a);
		} else if (a.equalsIgnoreCase("look at map") ||
				a.equalsIgnoreCase("use map") ||
				a.equalsIgnoreCase("show map") ||
				a.equalsIgnoreCase("check map")){
			Action.useMap(world, player1);
		} else if (a.equalsIgnoreCase("look around") ||
				a.equalsIgnoreCase("check room")){
			Action.lookAround(world);
		} else if(a.equalsIgnoreCase("inspect wall")){
			Action.inspectWall(world);
		} else if (a.equalsIgnoreCase("quit game")){
			System.out.println("Thanks for playing!");
			System.exit(0);
		} else {
			System.out.println("You can't do that.");
		}

	}
}
