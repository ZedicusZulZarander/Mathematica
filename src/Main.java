public class Main {
	public static void main(String[] args) {
	    int a =-1;
	    int b = 100;
		Fraction d = new Fraction(4,3);
		Fraction d1 = new Fraction(100,1);
		d.reduce();
		System.out.print(d.multiply(d, d1));
	} 

}