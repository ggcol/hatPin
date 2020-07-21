package it.abupro.LatLng.test;

import java.util.LinkedList;
import java.util.List;

import it.abupro.LatLng.entities.Pin;
import it.abupro.LatLng.function.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PinHelper pH = new PinHelper();
		List<String> param4Marker = new LinkedList<String>();
		
		param4Marker = pH.leggiPin(); 
		
		//cicla e restituisce i singoli elementi del costruttore come singole stringhe
		//al momento le stampa a console ma bisogna integrarle con HTML per refresh!
		for (int i = 0; i < param4Marker.size(); i = i+3) {
			System.out.println(param4Marker.get(i).toString());
			System.out.println(param4Marker.get(i+1).toString());
			System.out.println(param4Marker.get(i+2).toString());
		}
	}

}
