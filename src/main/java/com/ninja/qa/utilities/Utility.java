package com.ninja.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

public class Utility {
	

	public static String EmailgeneratedDateTime() {

		Date date = new Date();
		String dateTime = date.toString().replace(" ", "_").replace(":", "_");
		return "Sanket" + dateTime + "@gmail.com";

	}

}
