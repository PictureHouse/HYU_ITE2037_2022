package lab11;

import java.util.ArrayList;

public class ServiceManagement {
	public static <T extends Hub> T moveArea(T t, String area) {		//택배 도착 area를 변경하는 method
		t.setArea(area);
		return t;
	}
	
	public static <T extends Hub> T raisePerBox(T t, double rate) {			//택배 개당 요금을 변경하는 method 
		t.setPricePerBox(t.getPricePerBox() * rate);
		return t;
	}
	
	public static <T extends Hub> int findIndexByNum(ArrayList<T> tList, int num) {			//번호로 택배를 찾는 method
		for (T t : tList) {
			if (t.getNumber() == num)
				return tList.indexOf(t);			//찾으면 해당 인덱스를 반환 
		}
		return -1;			//찾지 못하면 -1 반환 
	}
	
	public static <T extends Hub> ArrayList<T> raiseAll(ArrayList<T> tList, double rate) {			//한 지역의 모든 택배 요금을 변경하는 method
		for (T t : tList) {
			t.setPricePerBox(t.getPricePerBox() * rate);
		}
		return tList;
	}
}
