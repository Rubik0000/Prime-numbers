
/**
 * implements a PrimeNumber with trial division algorithm 
 * 
 * @author rubik
 */
public class TrialDivision implements PrimeNumber {

	@Override
	public boolean isPrime(int number) throws NotNaturalNumberException {
		if (number <= 0) {
			throw new NotNaturalNumberException();
		}
		if (number == 1) return true;
		int i = 2;
		while (i * i <= number) {
			if (number % i == 0) {
				return false;
			}
			++i;
		}
		return true;
	}
}
