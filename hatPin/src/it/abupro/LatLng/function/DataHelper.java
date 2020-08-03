package it.abupro.LatLng.function;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class DataHelper {
	
	public DataHelper() {}
	
	
	public boolean corto(String dateToValidate){
		boolean prova;

		if(dateToValidate == null){
			return false;
		}
		DateFormat format1 = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);

		try {
			Date date1 = format1.parse(dateToValidate);
			prova = true;
		} catch (ParseException e) {

			e.printStackTrace();
			prova = false;
		}
		return prova;
	}
	
	public boolean medio(String dateToValidate){
		boolean prova;

		if(dateToValidate == null){
			return false;
		}
		DateFormat format1 = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.ITALY);

		try {
			Date date1 = format1.parse(dateToValidate);
			prova = true;
		} catch (ParseException e) {

			e.printStackTrace();
			prova = false;
		}
		return prova;
	}
	
	public boolean lungo(String dateToValidate){
		boolean prova;

		if(dateToValidate == null){
			return false;
		}
		DateFormat format1 = DateFormat.getDateInstance(DateFormat.LONG, Locale.ITALY);

		try {
			Date date1 = format1.parse(dateToValidate);
			prova = true;
		} catch (ParseException e) {

			e.printStackTrace();
			prova = false;
		}
		return prova;
	}
	
	public boolean dataValida(String dateToValidate)
	{
		boolean check;
		DataHelper dH = new DataHelper();
		boolean corto = dH.corto(dateToValidate);
		boolean medio = dH.medio(dateToValidate);
		boolean lungo = dH.lungo(dateToValidate);
		if(corto==true || medio==true || lungo==true)
		{
			check = true;
		}
		else 
		{
			check = false;
		}
		return check;

	}


}