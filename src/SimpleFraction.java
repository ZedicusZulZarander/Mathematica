public class SimpleFraction{
	private int numerator;
	private int denominator;
	private int indicator;
	
	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}

	public int getIndicator() {
		return indicator;
	}

	public void setIndicator(int indicator) {
		this.indicator = indicator;
	}

	SimpleFraction(int numerator, int denominator) {
		this.numerator = Math.abs(numerator);
		this.denominator = Math.abs(denominator);
		if((numerator<0 || denominator<0) & ((numerator*denominator)<0)){
			indicator = -1;
		} else {
			indicator = 1;
		}

	}

	SimpleFraction(int numerator, int denominator, int indicator) {
		this.numerator = numerator;
		this.denominator = denominator;
		this.indicator = indicator;

	}

	public SimpleFraction add(SimpleFraction f1, SimpleFraction f2){
		int f1numerator = f1.getNumerator() * f1.getIndicator(), 
			f2numerator = f2.getNumerator() * f2.getIndicator();
		int f1denominator = f1.getDenominator(), f2denominator = f2.getDenominator();
	
		int resNumerator = f1numerator * f2denominator + f2numerator * f1denominator;
		int resDenominator = f1denominator * f2denominator;
	
		SimpleFraction resF = new SimpleFraction(resNumerator, resDenominator);
		resF.reduce();
		return resF;
	
	}
	
	public static SimpleFraction multiplyFraction(SimpleFraction f1, SimpleFraction f2){
		SimpleFraction f = new SimpleFraction(f1.getNumerator() * f2.getNumerator(), 
								  f1.getDenominator() * f2.getDenominator(), 
								  f1.getIndicator() * f2.getIndicator());
		f.reduce();
		return f;
	
	}
	
	public void multiplyFraction(SimpleFraction f1){
		setNumerator(f1.getNumerator() * getNumerator());
		setDenominator(f1.getDenominator() * getDenominator());
		setIndicator(f1.getIndicator() * getIndicator());
		reduce();
	
	}
	
	public static SimpleFraction multiplyInt(SimpleFraction f1, int x){
		SimpleFraction f = new SimpleFraction(f1.getNumerator() * f1.getIndicator() * x, f1.getDenominator());
		f.reduce();
		return f;
	
	}
	
	public void multiplyInt( int x){
		setNumerator(getNumerator()*x);
		reduce();
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

	public SimpleFraction reduceDublicate(){
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
		SimpleFraction f = new SimpleFraction(numerator/r,denominator/r);
		return f;
	}

	public boolean equals(SimpleFraction f){
		SimpleFraction f1 = this.reduceDublicate();
		SimpleFraction f2 = f.reduceDublicate();
		if((f1.getNumerator() == f2.getNumerator()) & (f1.getDenominator() == f2.getDenominator())){
			return true;
		} else {
			return false;
		}
	}
	
	//пересмотреть назначение
	public void dublicate(SimpleFraction f){
		this.numerator = f.getNumerator();
		this.denominator = f.getDenominator();	
	}

	public SimpleFraction reverse(){
		return new SimpleFraction(denominator, numerator);
	}

	@Override
	public String toString() {
		return Integer.toString(numerator * indicator)+"/"+Integer.toString(denominator);
	}

	public double toDouble(){
		int num = (numerator*indicator);
		return (double)num/denominator; 
	}
	
	public int toInt() {
		return (numerator*indicator)/denominator;
	}

} 