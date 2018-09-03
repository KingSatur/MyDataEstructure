package TDA;

import exceptions.DenominatorCeroException;
import model.RationalNumber;

public interface IRationalNumber<T> {

	public void addRational(T rationalToBeAdded)throws DenominatorCeroException;
	public void substractRational(T rationalToBeSubstracted)throws DenominatorCeroException;
	public void multiplyRational(T rationalFactor)throws DenominatorCeroException;
	public void divideRational(T rationalQuocient)throws DenominatorCeroException;
	public void simplifyRational();
	public void rationalInverse()throws DenominatorCeroException;
	public void squaredRational()throws DenominatorCeroException;
	public Number getNumerator();
	public Number getDenominator();
	public String toString();
	
}

