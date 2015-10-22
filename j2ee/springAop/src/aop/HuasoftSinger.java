package aop;

public class HuasoftSinger implements Singer{

	private String name;
	
	public HuasoftSinger(String name){
		this.name = name;
	}
	
	@Override
	public Object sing(String songName) throws Exception{
		System.out.println("我是：" + name + "我开始唱歌了啊，给大家唱一首：" + songName);
//		System.out.println(1/0);
		throw new Exception("唱歌过程中发生异常");
//		return null;
	}

	@Override
	public String getName() {
		return name;
	}

}
