package dog;

public class Owner implements Cloneable {
	private String name;
	
	public Owner(String name) {
		this.name = name;
	}
	
	public Owner(Owner other) throws CloneNotSupportedException {
		this.name = other.name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Owner [name=" + name + "]";
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
