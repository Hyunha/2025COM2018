package chapters.ch08.bankaccount;

import java.lang.Record;

public class Database {
	
	private java.lang.Record[] base;
	
	public Database(int n) {
		if (n > 0)
			base = new java.lang.Record[n];
		else
			base = new Record[1];
	}
	
	

}
