public class Fraction{
	int numerator;
	int denominator;
	int indicator;

	Fraction(int numerator, int denominator) {
		this.numerator = Math.abs(numerator);
		this.denominator = Math.abs(denominator);
		if((numerator<0 || denominator<0) & ((numerator*denominator)<0)){
			indicator = -1;
		} else {
			indicator = 1;
		}

	}

	Fraction(int numerator, int denominator, int indicator) {
		this.numerator = numerator;
		this.denominator = denominator;
		this.indicator = indicator;

	}

	public Fraction add(Fraction f1, Fraction f2){
		int f1numerator = f1.numerator * f1.indicator, 
			f2numerator = f2.numerator * f2.indicator;
		int f1denominator = f1.denominator, f2denominator = f2.denominator;
	
		int resNumerator = f1numerator * f2denominator + f2numerator * f1denominator;
		int resDenominator = f1denominator * f2denominator;
	
		Fraction resF = new Fraction(resNumerator, resDenominator);
		resF.reduce();
		return resF;
	
	}

	public Fraction multiply(Fraction f1, Fraction f2){
		Fraction f = new Fraction(f1.numerator * f2.numerator, 
								  f1.denominator * f2.denominator, 
								  f1.indicator * f2.indicator);
		f.reduce();
		return f;
	
	}

	public void reduce(){
		int numerator1 = numerator;
		int denominator1 = denominator;
		int r = 0;
		while(numerator1!=0 & denominator1!=0 ){
			if(numerator1>denominator1){
				numerator1 = numerator1 % denominator1;
			} else {
				denominator1 = denominator1 % numerator1;
			}
		}
	
		r = numerator1+denominator1;
		numerator = numerator/r;
		denominator = denominator/r;
	}

	public Fraction reduce(){
		int numerator1 = numerator;
		int denominator1 = denominator;
		int r = 0;
		while(numerator1!=0 & denominator1!=0 ){
			if(numerator1>denominator1){
				numerator1 = numerator1 % denominator1;
			} else {
				denominator1 = denominator1 % numerator1;
	
			}
		}

		r = numerator1+denominator1;
		Fraction f = new Fraction(numerator/r,denominator/r);
		return f;
	}

	public boolean equals(Fraction f){
		Fraction f1 = this.reduce();
		Fraction f2 = f.reduce();
		if((f1.numerator == f2.numerator) & (f1.denominator == f2.denominator)){
			return true;
		} else {
			return false;
		}
	}

	public void dublicate(Fraction f){
		this.numerator = f.numerator;
		this.denominator = f.denominator;	
	}

	public Fraction reverse(){
		return new Fraction(this.denominator, this.numerator);
	}

	@Override
	public String toString() {

		return Integer.toString(numerator * indicator)+"/"+Integer.toString(denominator);
	}

	public double toDouble(){
		int num = (numerator*indicator);
		return (double)num/denominator; 
	}

} 