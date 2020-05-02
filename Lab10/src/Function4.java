
public class Function4 extends Function {
	
	@Override
	public double fnValue(double x) {
		double fun3 = (Math.pow(x, 3)) - (7*Math.pow(x, 2)) + (15*x - 9);
		if(fun3<=0) {
			return x;
		} else {
			return fun3;
		}
	}
	
	public String toString() {
		return "x^3 - 7*x^2 + 15*x - 9";
	}

}