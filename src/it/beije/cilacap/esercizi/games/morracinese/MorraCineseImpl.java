package it.beije.cilacap.esercizi.games.morracinese;

import java.util.Random;
import java.util.Scanner;

public class MorraCineseImpl implements MorraInterface {

	private boolean exitGameControlVariable = false;
	private String[] playersName = { "", "Computer" };
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
		System.out.println("1 -- Player vs Computer");
		System.out.println("2 -- Player vs Player -- attualmente non disponibile");
		System.out.println("3 -- Esci Dal Gioco");
		System.out.println("#################################################");
		System.out.println();
		int choiceMenu = scan.nextInt();
		scan.close();
		gameEngine(choiceMenu);

	}

	private String askName() {
		@SuppressWarnings("resource")
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
		System.out.println("Iniziamo, è il turno di " + playersName[0] + ".");
		System.out.println();
		int playerChoice = choiceScenarioPlayerVsCPU();
		int CPUChoice = (int) (Math.random() * 3);
		Mossa mossaVincente = vinceLaMossa(playerChoice, CPUChoice);
		System.out.println("vince " + mossaVincente.toString());

	}

	public int choiceScenarioPlayerVsCPU() {

		int choicePlayer1 = onMoveMenu(playersName[0]);

		return 0;
	}

	public int[] choiceScenarioPlayervsPlayer() {

	}

	public Mossa vinceLaMossa(int valueP1, int valueP2) {

		Mossa mossa1 = null;
		Mossa mossa2 = null;
		mossa1 = Mossa.prendiMossa(valueP1);
		mossa2 = Mossa.prendiMossa(valueP2);
		int move1 = mossa1.comparaMossa(mossa2); // se diverso da - 1 vince mossa1 altrimenti vince mossa2
		return Mossa.prendiMossa(move1);

	}

	public int onMoveMenu(String nameP) {
		Scanner scan = new Scanner(System.in);
		System.out.println(nameP + " scegli fra questi:");
		System.out.println("1 -- Sasso   --");
		System.out.println("2 -- Carta   --");
		System.out.println("3 -- Forbici --");
		int choice = scan.nextInt();
		scan.close();
		return choice;

	}

	@Override
	public void gameEngine(int choiceMenu) {

		switch (choiceMenu) {
		case 1:
			choiceOneFlow();
			break;
		case 3:
			exitGameControlVariable = true;
			break;
		case 2:
			// choiceTwoFlow();
			break;
		default:
			System.out.println("immetti un valore valido per il momento sono valide le seguenti opzioni: 2 - 3");
		}
	}

	@Override
	public void choiceTwoFlow() {

	}

}
