package com.univ.alma.mw;

import java.io.File;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Map;
import org.mapdb.*;

public class Storage {
	
	private static final String MAP_TOKENS = "tokens";
	
	private DB db;
	private Map<String,TimeoutString> tokens;
	
	public Storage() {
		this.db = DBMaker.fileDB(new File("storage.db"))
			.closeOnJvmShutdown()
			.transactionDisable()// no need to commit to save
			.make();
		
		
		if(this.db.exists(MAP_TOKENS)) {
			this.tokens = this.db.treeMap(MAP_TOKENS);
		} else {
			this.tokens = this.db.treeMapCreate(MAP_TOKENS)
				.keySerializer(Serializer.STRING)
				.makeOrGet();
		}
	}
	
	public void close() {
		this.db.close();
	}
	
	private static class TimeoutString implements Serializable {
		String value;
		long timeoutDate;
		
		public TimeoutString(String value, long timeoutDate) {
			this.value = value;
			this.timeoutDate = timeoutDate;
		}
	}
}
