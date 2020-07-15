package demo;

public class FilterNegs implements FiltroDados {
	private final int negativa = 10;

	@Override
	public boolean condicao(Tuplo tuplo) {
		if (isInt(tuplo.getX())) {
			if (Integer.parseInt(tuplo.getX()) >= negativa) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

	public static boolean isInt (String s) {
		for (int i = 0; i < s.length(); i++) {
			if (! Character.isDigit(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}

}
