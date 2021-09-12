package factrories;

//as per abstract factory pattern
public interface BankProductFactory<P> {

	public P create(String name);
}
