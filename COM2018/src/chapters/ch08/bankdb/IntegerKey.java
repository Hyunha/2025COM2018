package chapters.ch08.bankdb;

public class IntegerKey implements Key {
	
	private int key;
	
	public IntegerKey(int i) {
		key = i;
	}
	
	public boolean equals(Key k) {
		return key == ((IntegerKey)k).getInt();
	}
	
	public int getInt() {
		return key;
	}

}


