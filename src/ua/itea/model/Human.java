package ua.itea.model;

public class Human {
	private String name;
	private int health;
	
	public Human() {
		
	}
	
	public Human(String name, int health) {
		this.name = name;
		this.health = health;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	
	@Override
	public String toString() {
		return "Human [name=" + name + ", health=" + health + "]";
	}
	
	
}
