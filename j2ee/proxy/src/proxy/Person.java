package proxy;

public class Person implements IPerson {

	@Override
	public void sleep() {
		System.out.println("开始睡觉。。。");
	}

	@Override
	public void eating() {
		System.out.println("开始吃饭。。。");
	}

}
