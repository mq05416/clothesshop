package com.spring.helper;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class TimeHelper {
	public String getCurrentTime() {
		//method 1
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.toString();
	}
}
