package OopJavaHW04;

/**
 * Есть класс Фрукта. У фрукта есть вес.
 * Есть 3 наследника: апельсин, яблоко и золотое яблоко.
 * Нужно создать класс "Коробка с фруктами", в которую можно класть фрукты какого-то типа.
 * После создания коробка пустая. В нее можно добавлять фрукты с помощью метода add().
 * У коробки можно узнать сумарный вес с помощью метода getWeight().
 * Содержимое коробки можно пересыпать в другую коробку. При этом исходная коробка очищается,
 * а вторая наполняется.
 */
public class Main {
	public static void main(String[] args) {
		//Box<String> stringBox = new Box<>(); // не должно компилироваться

		FruitBox<Orange> orangeBox = new FruitBox<>();
		System.out.println("Box weight: "+ orangeBox.getWeight());
		orangeBox.add(new Orange(1));
		orangeBox.add(new Orange(2));
		//orangeBox.add(new Apple(2));       // не должно компилироваться
		//orangeBox.add(new GoldenApple(2)); // не должно компилироваться

		System.out.println("Box weight: "+ orangeBox.getWeight()); // 3

		FruitBox<Apple> appleBox = new FruitBox<>();
		appleBox.add(new Apple(1));
		appleBox.add(new GoldenApple(2)); // допустимый вариант
		System.out.println("Box weight: "+ appleBox.getWeight()); // 3

		FruitBox<GoldenApple> goldenAppleBox = new FruitBox<>();
		goldenAppleBox.add(new GoldenApple(5)); // допустимый вариант
		//goldenAppleBox.add(new Apple(5));       // не должно компилироваться
		System.out.println("Box weight: "+ goldenAppleBox.getWeight()); // 5

		goldenAppleBox.moveTo(appleBox);    // допустимый вариант
		/*
		  appleBox.moveTo(goldenAppleBox); // не должно компилироваться
		 orangeBox.moveTo(appleBox);      // не должно компилироваться
		*/


		FruitBox<Orange> orangeBox2 = new FruitBox<>();
		orangeBox.moveTo(orangeBox2);
		System.out.println("Box weight: "+ orangeBox.getWeight()); // 0
		System.out.println("Box weight: "+ orangeBox2.getWeight()); // 3
	}
}