package OopJavaHW03;

/**
 * Создать класс Контейнер - Container.
 * В контейнере могут быть ящики (класс Box).
 * У каждого ящика есть вес.
 * У каждого контейнера есть метод "получить вес" - это сумма всех весов ящиков,
 * которые находятся в контейнере.
 * Класс Контейнер должен быть Comparable.
 * Сравнивать он должен по весам контейнера (чем меньше вес, тем меньше контейнер).
 * Класс ContainerCountComparator - Comparator,
 * который сравнивает контейнеры по количеству ящиков
 * (чем меньше ящиков, тем меньше контейнер).
 * Класс контейнер должен быть Iterable -
 * итерирование должно происходить по ящикам внутри контейнера.
 * Container c = new Container(...);
 * // ...
 * for (Box box: c) {
 * box - это контейнер
 * }
 */


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		int[] arr1 = {1, 2, 3, 4, 5};
		int[] arr2 = {6, 7, 8};
		Container cont1 = new Container(new ArrayList<>(convertToBoxList(arr1)));
		Container cont2 = new Container(new ArrayList<>(convertToBoxList(arr2)));

		System.out.println("Стандартный вывод: ");
		System.out.println(cont1 + "\n" + cont2);
		System.out.println("Result method Comparable: " + cont1.compareTo(cont2));
		ContainerCountComparator containerComp = new ContainerCountComparator();
		System.out.println("Result method compare ContainerCountComparator: " +
				containerComp.compare(cont1, cont2));

		System.out.println("----------\n" + "Adding elements and output in a loop: ");
		Box b1 = new Box(25);
		Box b2 = new Box(1);
		cont1.addBox(b1);
		cont1.removeBox(0);
		cont1.removeBox(0);
		cont2.addBox(b2);
		cont2.addBox(b2);

		iterOut(cont1);
		iterOut(cont2);
		System.out.println("Result method Comparable: " + cont1.compareTo(cont2));
		System.out.println("Result method compare ContainerCountComparator: " +
				containerComp.compare(cont1, cont2));

	}

	//метод приводит обычный массив int к списку экземпляров Box
	static List<Box> convertToBoxList(int[] userArray) {
		List<Box> list = new ArrayList<>();
		for (int weight : userArray) {
			Box box = new Box(weight);
			list.add(box);
		}
		return list;
	}

	static void iterOut(Container cont) {
		System.out.println("Container" + cont.getId());
		System.out.print("{");
		for (Box i : cont) {
			System.out.print(i + " ");
		}
		System.out.println("}");


	}

	public static class ContainerCountComparator implements Comparator<Container> {
		@Override
		public int compare(Container o1, Container o2) {
			return Integer.compare(o1.getSize(), o2.getSize());
		}
	}


}
