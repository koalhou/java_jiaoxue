package aop;

public class Bank implements IBank{
	public int getMoney(int howmany) {
		System.out.println("ȡ��" + howmany);
		return howmany;
	}
	public void setMoney(int howmany) {
		System.out.println(1/0);
		System.out.println("����" + howmany);
	}	
}
