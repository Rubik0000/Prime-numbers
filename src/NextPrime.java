
/**
 * moves through sequence of prime numbers starting from 1
 *  
 * @author rubik
 */
public class NextPrime {
	
	/**
	 * the current prime number
	 */
	private int _currentNum = 1;
	private PrimeNumber _checker;
	
	public NextPrime(PrimeNumber cl) {
		_checker = cl;
	}
	
	/**
	 * generates a prime number followed by the previous one
	 * 
	 * @return prime number
	 */
	public int next() {
		try {
			while (!_checker.isPrime(_currentNum)) ++_currentNum;
		} 
		catch (NotNaturalNumberException e) {
			
		}
		//++_currentNum;
		return _currentNum++;
	}
	
	/**
	 * starts a sequence of prime numbers from scratch
	 */
	public void again() {
		_currentNum = 1;
	}
}
