
import java.util.Scanner;

/**
 * realise a console interface to operate with prime numbers
 * 
 * @author rubik
 *
 */
public class CommandInterface {
	private final int COUNTGENS = 1;
	private final int COUNTACTION = 1;
	private PrimeNumber _primeNumGen;
	private Scanner _scan;
	
	public CommandInterface() {
		_scan = new Scanner(System.in);
	}
	
	protected void finalize() {
		_scan.close();
	}
	
	/**
	 * create an instance of an appropriate class implementing PrimeNumber interface
	 * 
	 * @param code
	 * @return an instance PrimeNumber 
	 */
	private PrimeNumber getNumGen(int code) {
		switch (code) {
			case 1:
				return new TrialDivision();
				
			default:
				return null;
		}
	}
	
	/**
	 * checks whether user's answer from number menu is correct 
	 * 
	 * @param ans user's answer
	 * @param max max proper value of the answer
	 * @return    true if the answer is bigger or equal then 0 and 
	 * less or equal than max
	 */
	private boolean correctAns(int ans, int max) {
		return ans >= 0 && ans <= max;
	}
	
	/**
	 * get user's number menu answer form console
	 * 
	 * @return user's inputed integer value or -1 if user typed incorrect value 
	 */
	private int readAns() {
		if (_scan.hasNextInt()) {
			return _scan.nextInt();
		}
		else {
			_scan.nextLine();
			return -1;
		}
	}
	
	/**
	 * starts to generate prime numbers by user inputs
	 */
	private void genarateNumbers() {
		String cancel = "cancel";
		String again = "again";
		NextPrime nextPrime = new NextPrime(_primeNumGen);
		System.out.println("Press enter to get a next prime number");
		System.out.println("Type \"" + cancel + "\" to cancel");
		System.out.println("Type \"" + again + "\" to start from scratch");
		String ans;
		for(;;) {
			//System.out.print("> ");
			ans = _scan.nextLine().toLowerCase();
			if (ans.equals(cancel)) {
				break;
			}
			if (ans.equals(again)) {
				nextPrime.again();
			}
			System.out.print(nextPrime.next() + " ");
		}
	}
	
	/**
	 * starts to interact with user
	 */
	public void start() {
		for (;;) {
			int ans;
			do {
				System.out.println("Choose the algorithm of generating prime numbers");
				System.out.println("1 - Trial division");
				System.out.println("0 - Exit");
				System.out.print("> ");
				ans = readAns();
			} while (!correctAns(ans, COUNTGENS));
			if (ans == 0) break;
			
			_primeNumGen = getNumGen(ans);
			for (;;) {
				do {
					System.out.println("Choose your action");
					System.out.println("1 - Generate prime numbers");
					System.out.println("0 - Cancel");
					ans = readAns();
				} while (!correctAns(ans, COUNTACTION));
				if (ans == 0) break;
				
				if (ans == 1) {
					genarateNumbers();
				}
			}
		}
	}// public void start()
}
