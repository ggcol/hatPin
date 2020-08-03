package it.abupro.LatLng.test;

import java.util.LinkedList;
import java.util.List;

import it.abupro.LatLng.entities.Pin;
import it.abupro.LatLng.function.WallHelper;

public class WallHelperTest {
	
	

	public static void main(String[] args) {

		/*-----------PROVA DASH ----------------------
		WallHelper wh = new WallHelper();
		LinkedList<String> read = wh.importPin4Wall();
		
		int flag = 0;
		for (int i = 0; i < read.size(); i = i+5) {
			String latlng = "LatLng indice: "+flag+" "+read.get(i);
			String title = "Titolo indice: "+flag+" "+read.get(i+1);
			String body = "Body indice: "+flag+" "+read.get(i+2);
			String ref_img = "ref_img indice: "+flag+" "+read.get(i+3);
			String username = "username indice: "+flag+" "+read.get(i+4);
			flag++;
			
			
			System.out.println(latlng);
			System.out.println(title);
			System.out.println(body);
			System.out.println(ref_img);
			System.out.println(username);
			System.out.println("==================================");
		}
		
	
	-------------------------OK--------------------------*/ 
	
	/*--------------DASH PERSONAL ----------------------
	 
	WallHelper wH = new WallHelper();
	String usrProva = "red";
	LinkedList<String> read = wH.importPin4Personal(usrProva);
	
	int flag = 0;
	for (int i = 0; i < read.size(); i = i+4) {
		String latlng = "LatLng indice: "+flag+" "+read.get(i);
		String title = "Titolo indice: "+flag+" "+read.get(i+1);
		String body = "Body indice: "+flag+" "+read.get(i+2);
		String ref_img = "ref_img indice: "+flag+" "+read.get(i+3);
		flag++;
		
		System.out.println(latlng);
		System.out.println(title);
		System.out.println(body);
		System.out.println(ref_img);
		}
		
	----------------------------------------------------*/

	
	}
}
