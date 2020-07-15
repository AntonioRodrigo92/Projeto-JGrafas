package demo;
//import java.util.*;

public class Tuplo {
	private String x;		//nota
	private String y;		//quantidade
	
	public Tuplo (String a) {
		String[] b = a.split(",");
		this.x = b[0];
		this.y = b[1];
	}
	
	public String getX() {
		return this.x;
	}
	
	public String getY() {
		return this.y;
	}
}
