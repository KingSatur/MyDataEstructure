package model;

import TDA.IRationalNumber;
import exceptions.DenominatorCeroException;

public class RationalNumber<T extends Number> implements IRationalNumber<RationalNumber<T>> {

	private T numerator;
	private T denominator;
	
	public RationalNumber(T numerator, T denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
		
	public void setNumerator(T numerator) {
		this.numerator = numerator;
	}

	public void setDenominator(T denominator) {
		this.denominator = denominator;
	}

	@Override
	public void addRational(RationalNumber<T> rationalToBeAdded) {
		
		if(isDenominatorCero() != true && rationalToBeAdded.isDenominatorCero() != true) {
			if(denominator.equals(rationalToBeAdded.getDenominator())){
				numerator = this.addition(numerator, (T)rationalToBeAdded.numerator);
				this.simplifyRational();
			}
			else {
				numerator = this.addition(this.multiply(numerator, (T)rationalToBeAdded.denominator), this.multiply(denominator, (T)rationalToBeAdded.numerator));
				denominator = this.multiply(denominator, (T)rationalToBeAdded.denominator);
				this.simplifyRational();
			}
		}
	}
	
	private T addition(T n1, T n2) {
		
		T numberToReturn = null;
		
		if(n1 instanceof Integer && n2 instanceof Integer) {
			numberToReturn = (T) Integer.valueOf(n1.intValue() + n2.intValue());
		}
		if(n1 instanceof Long && n2 instanceof Long) {
			numberToReturn = (T) Long.valueOf(n1.longValue() + n2.longValue()); 
		}
		if(n1 instanceof Short && n2 instanceof Short) {
			numberToReturn = (T) Short.valueOf((short) (n1.shortValue() + n2.shortValue()));
		}
		
		
		return numberToReturn;
		
		
	}
	
	private T multiply(T n1, T n2) {
		
		T numberToReturn = null;
		
		if(n1 instanceof Integer && n2 instanceof Integer) {
			numberToReturn = (T) Integer.valueOf(n1.intValue() * n2.intValue());
		}
		if(n1 instanceof Long && n2 instanceof Long) {
			numberToReturn = (T) Long.valueOf(n1.longValue() * n2.longValue()); 
		}
		if(n1 instanceof Short && n2 instanceof Short) {
			numberToReturn = (T) Short.valueOf((short) (n1.shortValue() * n2.shortValue()));
		}
		
		
		return numberToReturn;
	}
	
	public Double isInteger(RationalNumber<T> rationalToBeAdded) {
		return (Double)rationalToBeAdded.getNumerator().doubleValue();
	}
		
	public boolean isDenominatorCero() {
		return denominator.equals(0);
	}
	
	@Override
	public void substractRational(RationalNumber<T> rationalToBeSubstracted){
		
		if(isDenominatorCero() != true && rationalToBeSubstracted.isDenominatorCero() != true) {
			if(denominator.equals(rationalToBeSubstracted.getDenominator())){
				numerator = this.substract(numerator, (T)rationalToBeSubstracted.numerator);
				this.simplifyRational();
			}
			else {
				numerator = this.substract(this.multiply(numerator, (T)rationalToBeSubstracted.denominator), this.multiply(denominator, (T)rationalToBeSubstracted.numerator));
				denominator = this.multiply(denominator, (T)rationalToBeSubstracted.denominator);
				this.simplifyRational();
			}
		}
	}

	private T substract(T n1, T n2) {
		
		T numberToReturn = null;
		
		if(n1 instanceof Integer && n2 instanceof Integer) {
			numberToReturn = (T) Integer.valueOf(n1.intValue() - n2.intValue());
		}
		if(n1 instanceof Long && n2 instanceof Long) {
			numberToReturn = (T) Long.valueOf(n1.longValue() - n2.longValue()); 
		}
		if(n1 instanceof Short && n2 instanceof Short) {
			numberToReturn = (T) Short.valueOf((short) (n1.shortValue() - n2.shortValue()));
		}
		
		
		return numberToReturn;
		
		
	}
	
	@Override
	public void multiplyRational(RationalNumber<T> rationalFactor) {
		
		if(isDenominatorCero() != true || rationalFactor.isDenominatorCero() != true) {
			numerator = this.multiply(numerator, (T)rationalFactor.numerator);
			denominator = this.multiply(denominator, (T)rationalFactor.denominator);
			simplifyRational();
		}

	}
	
	private T squared(T n1) {
		
		T squared = null;
	
		if(n1 instanceof Integer) {
			squared = (T) Integer.valueOf(n1.intValue() * n1.intValue()) ;
		}
		if(n1 instanceof Long) {
			squared = (T) Long.valueOf(n1.longValue() * n1.longValue());
		}
		if(n1 instanceof Short) {
			squared = (T) Short.valueOf((short)((short)n1.shortValue() * n1.shortValue()));
		}
		
		return squared;
	}
	
	private void simpleDivision(T mcd) {
		
		if(numerator instanceof Integer && denominator instanceof Integer && mcd instanceof Integer ) {
			numerator = (T)Integer.valueOf(numerator.intValue() / mcd.intValue());
			denominator = (T)Integer.valueOf(denominator.intValue() / mcd.intValue());
		}
		if(numerator instanceof Long && denominator instanceof Long && mcd instanceof Long) {
			numerator = (T)Long.valueOf(numerator.longValue() / mcd.longValue());
			denominator = (T)Long.valueOf(denominator.longValue() / mcd.longValue());
		}
		if(numerator instanceof Short && denominator instanceof Short && mcd instanceof Short) {
			numerator = (T)Short.valueOf((short) (numerator.shortValue() / mcd.shortValue()));
			denominator = (T)Short.valueOf((short) (denominator.shortValue() / mcd.shortValue()));
		}
		
		
	}
		
	@Override
	public void divideRational(RationalNumber<T> rationalQuocient) {
		
		rationalQuocient.rationalInverse();
		if((isDenominatorCero() != true && rationalQuocient.isDenominatorCero() != true)) {
			numerator = this.multiply(numerator, (T)rationalQuocient.numerator);
			denominator = this.multiply(denominator, (T)rationalQuocient.denominator);
			this.simplifyRational();
		}
		
	}

	@Override
	public void simplifyRational() {
		if(this.isDenominatorCero() != true) {
			this.simpleDivision(maximumComunDivisor(numerator, denominator));
		}
		
	}
	
	@Override
	public void rationalInverse(){
		
		if(this.isDenominatorCero() != true && !(this.numerator.equals(0))) {
			T num = numerator;
			numerator = denominator;
			denominator = num;
			this.simplifyRational();
		}
	}

	@Override
	public void squaredRational() {
		
		if(this.isDenominatorCero() != true) {
			numerator = this.squared(numerator);
			denominator = this.squared(denominator);
			this.simplifyRational();
		}
		
	}

	@Override
	public Number getNumerator() {
		return numerator;
	}

	@Override
	public Number getDenominator() {
		return denominator;
	}
	
	private T maximumComunDivisor(T numeratorA, T denominatorB) {
	
		T mcd = null;
		
		if(!module(numeratorA, denominatorB).equals(0)) {
			return maximumComunDivisor(denominatorB, module(numeratorA, denominatorB));
		}
		else {
			mcd = denominatorB;
		}
		
		return mcd;
	}
	
	private T module(T n1, T n2) {
		
		T numberToReturn = null;
		
		if(n1 instanceof Integer && n2 instanceof Integer) {
			numberToReturn = (T) Integer.valueOf(n1.intValue() % n2.intValue());
		}
		if(n1 instanceof Long && n2 instanceof Long) {
			numberToReturn = (T) Long.valueOf(n1.longValue() % n2.longValue()); 
		}
		if(n1 instanceof Short && n2 instanceof Short) {
			numberToReturn = (T) Short.valueOf((short) (n1.shortValue() % n2.shortValue()));
		}
		
		return numberToReturn;
		
	}
		
	
}
