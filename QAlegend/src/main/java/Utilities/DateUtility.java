package Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {
public static String getCurrentData() {
	Date date=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("mm/dd/yyyy");
	String formatDate = sdf.format(date);  //format date create chyth. date classinte obj paranju koduthu 
	return formatDate;
}
}
