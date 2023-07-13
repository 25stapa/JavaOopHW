package OopJavaHW03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Container implements Iterable<Box>, Comparable<Container> {

	private int id;
	static int nextId = 0;
	protected ArrayList<Box> boxesIn;


	protected Container(List<Box> boxes, int id) {
		this.boxesIn = new ArrayList<>(boxes);
		this.id = id;
	}

	protected Container(List<Box> boxes) {
		this(boxes, nextId++);
	}

	public Container() {
		this.boxesIn = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void addBox(Box newBox) {
		boxesIn.add(newBox);
	}

	public void removeBox(int position) {
		boxesIn.remove(position);
	}

	public int getWeight() {
		return boxesIn.stream().mapToInt(Box::getWeight).sum();
	}

	public int getSize() {
		return boxesIn.size();
	}


	@Override
	public Iterator<Box> iterator() {
		return boxesIn.iterator();
	}

	@Override
	public int compareTo(Container o) {
		return Integer.compare(this.getWeight(), o.getWeight());
	}

	@Override
	public String toString() {
		return "Container" + this.id +
				" {weight:" + this.getWeight() +
				", size:" + this.getSize() +
				", Boxes" + boxesIn + '}';
	}
}