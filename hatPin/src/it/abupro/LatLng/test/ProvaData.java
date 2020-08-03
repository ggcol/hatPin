package it.abupro.LatLng.test;

import it.abupro.LatLng.function.ProvaM;

public class ProvaData {

	public static void main(String[] args) 
	{
		String date1= "11 Novembre 1111";
		ProvaM primo = new ProvaM();
		boolean giovanni= primo.dataValida(date1);
		System.out.println(giovanni);

	}

}
