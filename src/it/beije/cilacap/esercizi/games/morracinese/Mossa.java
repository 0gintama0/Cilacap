package it.beije.cilacap.esercizi.games.morracinese;

public enum Mossa {

	SASSO, CARTA, FORBICI, UGUALE;

	@SuppressWarnings("incomplete-switch")
	public int comparaMossa(Mossa mossaAvversario) {
		// Caso di parit�
		if (this == mossaAvversario)
			return 0;

		switch (this) {
		case SASSO:
			return (mossaAvversario == FORBICI ? 1 : -1);  
		case CARTA:
			return (mossaAvversario == SASSO ? 1 : -1);
		case FORBICI:
			return (mossaAvversario == CARTA ? 1 : -1);
		}
		return 0;
	}

	public static Mossa prendiMossa(int mossa) {

		Mossa move = null;
		
	
		switch (mossa) {
		case 1: move = Mossa.SASSO;
				break;
		case 2: move = Mossa.CARTA;
				break;
		case 3: move = Mossa.FORBICI;
				break;
		default: System.out.println("mossa non valida, Immetti un mossa consentita");
				
		}	
		return move;
		
	}

}
