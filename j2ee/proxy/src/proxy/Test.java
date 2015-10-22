package proxy;

public class Test {
	public static void main(String[] args) {
		IPerson proxy = new PersonProxy(new Person());
		proxy.eating();
		proxy.sleep();
	}
}
