package aop;

public class Fans implements Listener {

	private Singer singer;
	
	@Override
	public void setSinger(Singer singer) {
		this.singer = singer;
	}

	@Override
	public void offPhone() {
		System.out.println("我是"+singer.getName()+"粉丝，我开始摇晃手机了");

	}

	@Override
	public void takeSeat() {
		System.out.println("我是"+singer.getName()+"粉丝，我开始找座位");
	}

	@Override
	public void guzhang() {
		System.out.println("我是"+singer.getName()+"粉丝，我开始鼓掌");
	}

	@Override
	public void getMoney() {
		System.out.println("我是"+singer.getName()+"粉丝，你唱的太差了，退钱！");
	}

}
