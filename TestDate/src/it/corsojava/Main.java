package it.corsojava;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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
		
		
		//verifica se una data è successiva ad un'altra
		if (d2.isAfter(d1))
			System.out.println("la seconda data è successiva alla prima");
		else if (d2.isBefore(d1))
			System.out.println("la seconda data è precedente alla prima");
		
		
		//calcolo della differenza in giorni tra due date
		long g=ChronoUnit.DAYS.between(d1, d2);
		System.out.println("Sono passati "+g+ " giorni");
		
		
		//intercettare l'eccezione di data non valida		
		try {				
			d1=LocalDate.of(2021, 2, 31);	//creo una LocalDate del 31/2/2021 (NON VALIDA!)
		} catch (DateTimeException e) {
			System.out.println("Data non valida: "+e.getMessage());			
		}
		
		
		//dichiarazione di un'ora generica:
		LocalTime t=LocalTime.of(13,50,20);
		
		//recupero l'ora corrente
		LocalTime t1=LocalTime.now();
		
		//formattazione di un'ora
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("hh:mm:ss");	  
			// hh: ore (formato 12)
			// HH: ore (formato 24)
			// mm: minuti
			// ss: secondi
		System.out.println(t.format(dtf));
	}
}
