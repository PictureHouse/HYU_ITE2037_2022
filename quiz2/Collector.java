package quiz2;

import java.util.ArrayList;

public class Collector< T extends UniqueToken> {
	private ArrayList<T> arr = new ArrayList<T>();; // 본인이 가진 토큰의 목록
	private String name; // 본인 이름
	private int uid; // 본인 ID

	public Collector(String name, int uid) {
		this.name = name;
		this.uid = uid;
	}

	public void add(T item) {
		arr.add(item);
	}
	
	public void remove(T item) {
		arr.remove(arr.indexOf(item));
	}
	
	public T get(int id) {
		for (T item : arr) {
			if (item.getTokenId() == id)
				return item;
		}
		return null;
	}
	
	public void transfer(int id, Collector<T> peer) {
		T item = get(id);
		if (item != null) {
			System.out.println("This token is " + item.getName());
			this.remove(item);
			peer.add(item);
			System.out.println("----- Successfully Transfered! -----");
		}		
	}
	
	public void printAllTokens() {
		System.out.printf("%s(%s):\n", this.name,this.uid);
		if (arr.size() == 0)
			System.out.println("no pokemon");
		for (T item : arr)
			System.out.println("name: "+item.getName()+", id: "+item.getTokenId()+", description: "+item.getDescription());
	}
}
