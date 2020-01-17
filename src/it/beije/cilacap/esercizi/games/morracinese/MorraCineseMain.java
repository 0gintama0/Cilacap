package it.beije.cilacap.esercizi.games.morracinese;

public class MorraCineseMain {

	public static void main(String[] args) {
		
		MorraCineseImpl game = new MorraCineseImpl();
		do {
			game.onMainMenu();
		}while(!game.exitGame());
		
		
	}
	
	

}
