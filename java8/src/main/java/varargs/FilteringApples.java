package varargs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

public class FilteringApples {

	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));
		List<Banana> inventoryb = Arrays.asList(new Banana(80, "green"), new Banana(155, "green"),
				new Banana(120, "red"));

		List<Apple> heavyApples = filterApples(inventory, new AppleHeavyWeightPredicate());
		List<Apple> greenApples = filterApples(inventory, new AppleGreenColorPredicate());

		// 5 익명 클래스 사용
		List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
			public boolean test(Apple apple) {
				return "red".equals(apple.getColor());
			}
		});

		// 6 람다 표현식 사용
		List<Apple> result = filterApples(inventory, (Apple apple) -> "red".equals(apple.getColor()));

		// 7 리스트 형식 추상화: 다양한 물건 필터링
		List<Banana> yellowBananas = filter(inventoryb, (Banana banana) -> "yellow".equals(banana.getColor()));

		// 8 Comparator 이용하여 정렬하기 (무게가 적은순으로 정렬)
		inventory.sort(new Comparator<Apple>() {
			public int compare(Apple a1, Apple a2) {
				//System.out.println(Integer.compare(a1.getWeight(), a2.getWeight()));
				return Integer.compare(a1.getWeight(), a2.getWeight());
			}
		});
		
		// 8-1 람다 표현식 사용
		inventory.sort((Apple a1, Apple a2)-> Integer.compare(a1.getWeight(), a2.getWeight()));
	}

	// 1 녹색 사과 필터링
	public static List<Apple> filterGreenApples(List<Apple> inventory) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if ("green".equals(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}

	// 2 색을 파라미터화: 다른 색상의 사과를 필터링하고 싶다
	public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (apple.getColor().equals(color)) {
				result.add(apple);
			}

		}
		return result;
	}

	// 2 무게를 기준으로 필터링하고 싶다 (xx그램 이상인 사과는 무거운 사과이다)
	public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (apple.getWeight() > weight) {
				result.add(apple);
			}
		}
		return result;
	}

	// 3 추상적 조건으로 필터링
	public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}

	// 7 제네릭 메서드
	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> result = new ArrayList<>();
		for (T e : list) {
			if (p.test(e)) {
				result.add(e);
			}
		}
		return result;
	}

}
