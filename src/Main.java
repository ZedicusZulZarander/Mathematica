public class Main {
	public static void main(String[] args) {
	    int a =-1;
	    int b = 100;
	    SimpleFraction d = new SimpleFraction(4,3);
	    SimpleFraction d1 = new SimpleFraction(100,1);
		d.reduce();
		System.out.print(d.multiply(d, d1));
	} 

}