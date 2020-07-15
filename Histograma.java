package demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pt.iscte.guitoo.CompositeFigure;
import pt.iscte.guitoo.Figure;
import pt.iscte.guitoo.Location;
import pt.iscte.guitoo.Point;
import pt.iscte.guitoo.StaticText;

public class Histograma extends Grafico implements CompositeFigure{
	private Point location;
	
	private List<Figure> children;
	public Histograma(int escala, ConjuntoDados dados) {
			
			super(escala, dados);
			
			location = new Point(0, (this.getDados().base() + 50));
			children = new ArrayList<>();
			children.add(new Square(1, -120));
			for (int i = 0; i < this.getDados().size(); i++)
				addPosition(this.getDados().getTuplo(i));
		
	}
	
	public void addPosition(Tuplo tuplo) {
		int i = children.size() / 2;
		Square square = new Square(50, - Integer.parseInt(tuplo.getY()));
		square.move(i * 55 + 15, 0);
		children.add(square);
		children.add(new StaticText(this.getDados().getTuplo(i).getX(), i * 50 + 50 - 20 / 2, 50 - 10));
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