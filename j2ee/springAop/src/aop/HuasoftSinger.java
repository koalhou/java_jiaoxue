package aop;

public class HuasoftSinger implements Singer{

	private String name;
	
	public HuasoftSinger(String name){
		this.name = name;
	}
	
	@Override
	public Object sing(String songName) throws Exception{
		System.out.println("���ǣ�" + name + "�ҿ�ʼ�����˰�������ҳ�һ�ף�" + songName);
//		System.out.println(1/0);
		throw new Exception("��������з����쳣");
//		return null;
	}

	@Override
	public String getName() {
		return name;
	}

}
