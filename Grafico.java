package demo;

public abstract class Grafico {
	private int escala;
	private ConjuntoDados dados;
	
	protected Grafico(int escala, ConjuntoDados dados) {
		this.escala=escala;
		this.dados=dados;
	}

	public int getEscala() {
		return escala;
	}

	public ConjuntoDados getDados() {
		return dados;
	}
	
	
}
