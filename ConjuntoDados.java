package demo;
import java.util.*;
import pt.iscte.guitoo.*;

public class ConjuntoDados {		//filtro !!!
	private List<Tuplo> dados;
	private ArrayList<FiltroDados> filtro;
	
	public ConjuntoDados (List<Tuplo> t) {
		this.dados = t;
//		this.filtro = new SemFiltro();
	}
	
	public void setFiltro (ArrayList<FiltroDados> filtro) {
		this.filtro = filtro;
		// temos de fazer foreach aqui 
		for(int i =0; i<=dados.size();i++) {
			if (!this.filtro.condicao(this.dados.get(i))) {
				this.dados.remove(i);

			}
			
		}
	}
	
	
	
	public void addTuplo1 (Tuplo tuplo) {
		if (this.filtro.condicao(tuplo)) {
			this.dados.add(tuplo);
		}
	}
	
	public FiltroDados getFiltro() {
		return this.filtro;
	}
	
	public void addTuplo (Tuplo tuplo) { //apagar: so para teste!
			this.dados.add(tuplo);
		}
	
	public int base () {
		int max = 0;
		for (Tuplo i : this.dados) {
			if (Integer.parseInt(i.getY()) >= max) {
				max = Integer.parseInt(i.getY());
			}
		}
		return max;
	}
	
	public int size() {
		return this.dados.size();
	}
	
	public Tuplo getTuplo (int i) {
		return this.dados.get(i);
	}
	
	public Tuplo getTuplo1 (int i) {
		if (this.filtro.condicao(this.dados.get(i))) {
			return this.dados.get(i);
		}
		else {
			return null;
		}
	}
	
	public List<Tuplo> getConjuntoDados() {
		return this.dados;
	}
}