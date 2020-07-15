package demo;
import java.util.ArrayList;
import java.util.List;

import pt.iscte.guitoo.*;

public class Demo {
	private Window app;
	private StaticText text;
	private String leitor;
	private int escala;

	public Demo() {
		app = new Window("JGrafas", 1400, 300, true);
		text = new StaticText("hello", 100, 20);
		//app.addFigure(text);
		app.addLabel(() -> app.getCanvasWidth() + " x " + app.getCanvasHeight());
		app.addAction("histograma", new SetText());
		
		//app.addFigure(new Square(50));
//		ArrayFigure array = new ArrayFigure(50, 50);
//		app.addFigure(array);
		
//		Flag negativas = app.addFlag("negativas", false);
//		Flag c = app.addFlag("c", false);
//		Option<StandardColor> colorOption = app.addOption("color", StandardColor.WHITE, StandardColor.RED,
//				StandardColor.GREEN);
		
		
					
//				square.move(app.getCanvasWidth() / 2, app.getCanvasHeight() / 2);
				//StandardColor color = colorOption.getSelected();
				//square.setColor(color);
				//app.addFigure(square);
		
	}

	public void run() {
		app.open();
	}

	class SetText extends Action {
		Flag negativas = app.addFlag("negativas", false);
		Flag c = app.addFlag("c", false);
		
		
		
		
		public SetText() {
			addParameter("Ficheiro", () -> text.getText(), (a) -> !a.isEmpty());
			addParameter("escala", () -> text.getText(), (a) -> !a.isEmpty());
		}

		public void execute(String[] args) {
			app.clear();
			leitor=args[0];
		
			escala=Integer.parseInt(args[1]);
			
			
			ConjuntoDados dados =RebuildFigure(FileReader.getConjuntoDados(leitor));
			ArrayFigure array=new ArrayFigure(escala, dados);
			//Grafico array=new Histograma(escala, dados);
			app.addFigure(array);
			
			
		
		}
		public ConjuntoDados RebuildFigure(List<Tuplo> t) {
//			ArrayFigure array= new ArrayFigure(e,t);
			ConjuntoDados dados= new ConjuntoDados(t);
			ArrayList<FiltroDados> filtros= new ArrayList<>();
			int next=0;
			if(negativas.isSelected()) {
				filtros.add(new FilterNegs());
				next++;
	//			dados.setFiltro(filtros)
				
	//			array.getDados().setFiltro(new FilterNegs());
			
					
	//				ArrayFigure array1 = new ArrayFigure(e,array.getDados());
					
	//				app.removeFigure(array);
					
	//				app.addFigure(array1);
					
				
			}
			dados.setFiltro(filtros);
			return dados;
			
			
			
		}
	}

	public static void main(String[] args) {
		Demo demo = new Demo();
		demo.run();
	}
}