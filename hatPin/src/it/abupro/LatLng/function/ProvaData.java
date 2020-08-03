package it.abupro.LatLng.function;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class ProvaM 
{
	public void DataGiusta(String birthdate) throws ParseException
	{
	DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.ITALY);
	System.out.println(df.format(new Date()));
	System.out.println(df.parse(birthdate));
	}
}
