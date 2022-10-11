package it.corsojava;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
	public static void main(String[] args) {
		LocalDate d1,d2;
		
		// dichiarazione di una data generica	
		d1=LocalDate.of(2022, 10, 10);	//creo una LocalDate del 10/10/2022
		
		// dichiarazione di una data impostata al giorno corrente
		d2=LocalDate.now();		//creo una LocalDate del giorno corrente
		
		
		//formattazione di una data
		// 	dd: giorno con due cifre
		// 	MM: mese con due cifre
		//  yyyy: anno con due cifre
		DateTimeFormatter df=DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		System.out.println("La data di oggi è: "+d2.format(df));
		
	}
}
