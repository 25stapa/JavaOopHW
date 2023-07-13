package OopJavaHW02;

public class Building extends Substance implements HasHealth {
	private final int id;
	private final int maxHealthPoint; // максимально количество здоровья
	private int currentHealthPoint; // текущее количество здоровья

	public Building(int maxHealthPoint, int id) {
		this.id = id;
		this.maxHealthPoint = maxHealthPoint;
		this.currentHealthPoint = maxHealthPoint;
	}

	public Building(int maxHealthPoint) {
		this(maxHealthPoint, nextId++);

	}

	public int getId() {
		return id;
	}

	@Override
	public int getCurrentHealth() {
		return this.currentHealthPoint;
	}

	@Override
	public void setCurrentHealth(int healthPoint) {
		this.currentHealthPoint = healthPoint;
	}

	@Override
	public int getMaxHealth() {
		return this.maxHealthPoint;
	}
}