package OopJavaHW04;
abstract class Fruit {
	private final int weight;

	public Fruit(int newWeight) {
		this.weight = newWeight;
	}

	public int getWeight() {
		return weight;
	}
}