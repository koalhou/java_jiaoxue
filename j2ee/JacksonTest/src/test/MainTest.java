package test;

public class MainTest {
	public static void main(String[] args) {
		Entity e = new Entity();
		e.setStr1("str1");
		e.setStr2("str2");
		e.setStr3("str3");
		System.out.println(JacksonUtils.toJsonRuntimeException(e));
	}
}
