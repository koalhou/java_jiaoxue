package test;

public class Business {
	public static void main(String[] args) {
		new Business().save();
	}

	public void save() {
		FloppyWriter writer = new FloppyWriter();
		writer.write();
	}

}
