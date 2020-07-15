package demo;
import java.util.*;
import pt.iscte.guitoo.*;

public class Square implements PolylineFigure {
	private List<Point> points;
	private Color color;
	private Point location;

	public Square(int x, int y) {
		location = Point.ORIGIN;
		points = new ArrayList<>(4);
		points.add(Point.ORIGIN);
		points.add(new Point(x, 0));
		points.add(new Point(x, y ));
		points.add(new Point(0, y));
		color = StandardColor.WHITE;
	}

	@Override
	public Point getLocation() {
		return location;
	}

	@Override
	public List<Point> getPoints() {
		return Collections.unmodifiableList(points);
	}

	@Override
	public Color getFillColor() {
		return color;
	}

	public void move(int x, int y) {
		location = location.sum(x, y);
	}

	public void setColor(Color color) {
		this.color = color;
	}
}