package lab13;

import java.util.ArrayList;

public abstract class NumberGenerator {
	private ArrayList<Observer> observers = new ArrayList<Observer>();

	public abstract int getNumber();		//NumberGenerator class를 extend한 class에서 정의하여야하는 abstract method 
	public abstract void execute();	

	public void addObserver(Observer observer) {		//Observer 객체를 받아서 리스트에 추가하는 method 
		observers.add(observer);
	}

	public void deleteObserver(Observer observer) {		//Observer 객체를 받아서 리스트에서 제거하는 method 
		observers.remove(observer);
	}

	public void notifyObservers() {			//리스트에 있는 Observer들에게 알림을 전달하는 method 
		for(int i = 0; i < observers.size(); i++) {
			observers.get(i).update(this);
		}
	}
}
