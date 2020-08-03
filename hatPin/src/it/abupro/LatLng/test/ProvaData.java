package it.abupro.LatLng.test;

import it.abupro.LatLng.function.DataHelper;

public class ProvaData {

	public static void main(String[] args) 
	{
		String date1= "11 Novembre 1111";
		DataHelper dH = new DataHelper();
		boolean giovanni= dH.dataValida(date1);
		System.out.println(giovanni);

	}

}
