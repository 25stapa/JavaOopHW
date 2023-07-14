package OopJavaHW04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FruitBox<T extends Fruit> implements Iterable <T> {
	protected List <T> fruits;

	public FruitBox() {
		this.fruits = new ArrayList<>();
	}

	public int getWeight() {
		return fruits.stream().mapToInt(Fruit::getWeight).sum();
	}


	public void add(T newFruit ) {
		this.fruits.add((T)newFruit);
	}

	public void moveTo(FruitBox<? super T> targetBox ) {
		this.fruits.forEach(fruit -> targetBox.add((T)fruit));
		this.fruits.clear();

	}



	@Override
	public Iterator<T> iterator() {
		return fruits.iterator();
	}
}