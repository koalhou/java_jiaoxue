package aop;

public class Fans implements Listener {

	private Singer singer;
	
	@Override
	public void setSinger(Singer singer) {
		this.singer = singer;
	}

	@Override
	public void offPhone() {
		System.out.println("����"+singer.getName()+"��˿���ҿ�ʼҡ���ֻ���");

	}

	@Override
	public void takeSeat() {
		System.out.println("����"+singer.getName()+"��˿���ҿ�ʼ����λ");
	}

	@Override
	public void guzhang() {
		System.out.println("����"+singer.getName()+"��˿���ҿ�ʼ����");
	}

	@Override
	public void getMoney() {
		System.out.println("����"+singer.getName()+"��˿���㳪��̫���ˣ���Ǯ��");
	}

}
