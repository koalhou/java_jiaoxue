package depends;

public class TestWriter {
	public static void main(String[] args) {
		Business b = new Business();
		b.setWriter(new FloppyWriter());
		b.save();
	}
}
