package test;

public class TestAction {
	
	TestBo testBo;

	public void sayHello(){
		System.out.println("Hello , World..");
		testBo.doSth();
	}

	public TestBo getTestBo() {
		return testBo;
	}

	public void setTestBo(TestBo testBo) {
		this.testBo = testBo;
	}
	
}


