package com.utils;

import java.util.UUID;

public class CreateTicketUtils {
	
	public  static String createTicket()
	{
		 UUID uuid = UUID.randomUUID();
		 return uuid.toString();
	}

}
