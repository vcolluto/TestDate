package it.corsojava;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

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
		
		
		
		
		
		
		
		
		//esempio di errori di approssimazione usando il double 
		System.out.println("\n\n\nDOUBLE:");
		double ndouble=0.1d;		
		for (int i=0;i<100;i++)
		{
			System.out.println(ndouble);
			ndouble+=0.1d;	//aggiungo sempre 0.1, quindi mi aspetto 0.2,0.3,0.4 ...
		}
		
		
		//con il BigDecimal non ho problemi di approssimazione:
		System.out.println("\n\n\nBIGDECIMAL:");
		BigDecimal nbd=new BigDecimal("0.1");
		for (int i=0;i<100;i++)
		{
			System.out.println(nbd.toString());
			nbd=nbd.add(new BigDecimal("0.1"));
		}
		
		System.out.println("\n\n\nFormattazione:");
		//BigDecimal per i prezzi
		DecimalFormat df1=new DecimalFormat("#,###.00 €");
		BigDecimal nd=new BigDecimal("3212.30");
		System.out.println(df1.format(nd));
		
	}
	
}
