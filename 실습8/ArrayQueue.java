import java.util.ArrayList;

public class ArrayQueue implements Queue {

	ArrayList<Object> aQueue = new ArrayList<Object>();

	@Override
	public void add(Object object) {
		aQueue.add(object);
	}

	@Override
	public Object first() {
		if (aQueue.isEmpty())
			return null;
		return aQueue.get(0);
	}

	@Override
	public Object remove() {
		if (aQueue.isEmpty())
			return null;
		return aQueue.remove(0);
	}

	@Override
	public int size() {
		return aQueue.size() -1;
	}

}
