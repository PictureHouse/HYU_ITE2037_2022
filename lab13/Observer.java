package lab13;

public interface Observer {
	public abstract void update(NumberGenerator generator);		//Observer interface를 implement한 class에서 정의해야하는 method
}
