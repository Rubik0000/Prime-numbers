/**
 * an interface declares the basic methods to work with prime numbers
 */
public interface PrimeNumber {
	
	/**
	 * checks whether a number is prime 
	 * 
	 * @param number checking number
	 * @return true if number is prime else false
	 * @throws NotNaturalNumberException if number is not natural
	 */
	boolean isPrime(int number) throws NotNaturalNumberException;
}
