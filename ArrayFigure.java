package demo;
import java.util.*;
import pt.iscte.guitoo.*;

public class ArrayFigure implements CompositeFigure {
	private Point location;
	private List<Figure> children;
	private ConjuntoDados dados;
	private int escala;
//	private FiltroDados filtro;

	public ArrayFigure(int escala, ConjuntoDados dados) {
		
		this.escala=escala;
		this.dados = dados;
		
		location = new Point(0, (this.dados.base() + 50));
		children = new ArrayList<>();
		//StandardColor[] values = StandardColor.values();
		
//		this.dados = new ConjuntoDados();
//		this.dados = FileReader.getConjuntoDados();
		
		children.add(new Square(1, -120));
		
		for (int i = 0; i < this.dados.size(); i++)
				addPosition(this.dados.getTuplo(i));		
	}
	

	
	
	public void addTuplo (Tuplo tuplo) { //apagar: so para teste!
		this.dados.addTuplo(tuplo);
	}
	
	/*public void setFiltro (FiltroDados filtro) {
		this.filtro = filtro;
	}*/
	
	public ConjuntoDados getDados() {
		return this.dados;
	}
	
//	public void setFiltro (FiltroDados filtro) {
	//	this.dados.setFiltro(filtro);
		
		
//	}

	public void setDados(ConjuntoDados dados) {
		this.dados = dados;
	}

	public void addPosition(Tuplo tuplo) {
		int i = children.size() / 2;
		Square square = new Square(50, - Integer.parseInt(tuplo.getY()));
		//square.setColor(color.WHITE);
		square.move(i * 55 + 15, 0);
		children.add(square);
		children.add(new StaticText(this.dados.getTuplo(i).getX(), i * 50 + 50 - 20 / 2, 50 - 10));
	//	children.add(new StaticText(this.dados.getTuplo(i).getY(),0,this.dados.base()*i));
	}

	@Override
	public Location getLocation() {
		return location;
	}

	@Override
	public List<? extends Figure> getChildFigures() {
		return Collections.unmodifiableList(children);
	}

	public void move(int x, int y) {
		location = location.sum(x, y);
	}

	
}