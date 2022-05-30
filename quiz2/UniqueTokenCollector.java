package quiz2;

public interface UniqueTokenCollector<T extends UniqueToken> {
	public void add(T item);
	public void remove(T item);
	public T get(int id);
	public void transfer(int id, Collector<T> peer);
	public void printAllTokens();
}
