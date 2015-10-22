package aop;

public class Bank implements IBank{
	public int getMoney(int howmany) {
		System.out.println("»°¡À" + howmany);
		return howmany;
	}
	public void setMoney(int howmany) {
		System.out.println(1/0);
		System.out.println("¥Ê¡À" + howmany);
	}	
}
