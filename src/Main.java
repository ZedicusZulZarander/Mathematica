public class Main {
	public static void main(String[] args) {
	    int a =-1;
	    int b = 100;
	    SimpleFraction d = new SimpleFraction(-1,3);
	    SimpleFraction d1 = new SimpleFraction(1,3);
		d.reduce();
		System.out.print(d.add(d, d1).toInt());
	} 

}