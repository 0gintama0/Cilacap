package it.beije.cilacap.esercizi.games.morracinese;

import java.util.Scanner;

public class MorraCineseImpl implements MorraInterface {

	private boolean exitGameControlVariable = false;
	private String[] playersName = {"", ""};	
	private int timesMenuCalled = 0;

	@SuppressWarnings("resource")
	@Override
	public void onMainMenu() {

		Scanner scan = new Scanner(System.in);
		timesMenuCalled++;
		if (timesMenuCalled <= 1)
			playersName[0] = askName();
		System.out.println();
		System.out.println(playersName[0] + " Iniziamo Subito a Giocare:");
		System.out.println("#################################################");
		System.out.println("Scegli La Modalità di Gioco Che Fa Per Te:");
		System.out.println("1 -- Player vs Player");
		System.out.println("2 -- Player vs Computer");
		System.out.println("3 -- Esci Dal Gioco");
		System.out.println("#################################################");
		System.out.println();
		int choiceMenu = scan.nextInt();
		gameEngine(choiceMenu);

	}

	private String askName() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Ciao, Dimmi il tuo nome: ");
		playersName[0] = scan.next();

		return playersName[0];

	}

	@Override
	public boolean exitGame() {
		return exitGameControlVariable;
	}

	@Override
	public void choiceOneFlow() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Ciao " + playersName[0] + " lascia la tastiera al tuo amico");
		System.out.println("Ciao Amico Mi Diresti Il Tuo Nome ?");
		playersName[1] = scan.nextLine();
		System.out.println("Ciao " + playersName[1] + " lascia la tastiera a " + playersName[0] + ".");
		System.out.println();
		int choicesToCompare[] = choiceScenario();
		compara(choicesToCompare[0], choicesToCompare[1]);
		
		
	}
	
	public int[] choiceScenario() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);		
		scenario(playersName[0]);
		int valueP1 = scan.nextInt();
		scenario(playersName[1]);
		int valueP2 = scan.nextInt();
		int[] values = new int[2];
		values[0] = valueP1;
		values[1] = valueP2;
		return values;
	}
	
	
	public void compara(int valueP1, int valueP2) {
		
	}
	
	public void scenario(String nameP) {
		System.out.println(nameP + " senza farti vedere dall'altro giocatore scegli fra questi:");
		System.out.println("1 -- Sasso   --");
		System.out.println("2 -- Carta   --");
		System.out.println("3 -- Forbici --");
	}

	@Override
	public void gameEngine(int choiceMenu) {

		switch (choiceMenu) {
		case 1:
			choiceOneFlow();
			break;
		case 2:
			choiceTwoFlow();
			break;
		case 3:
			exitGameControlVariable = true;
			break;
		default:
			System.out.println("immetti un valote valido: 1 - 2");
			onMainMenu();
		}
	}

	@Override
	public void choiceTwoFlow() {

	}

}
