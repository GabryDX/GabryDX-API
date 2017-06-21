package it.gabrydx;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.joda.time.LocalDate;
import org.joda.time.Years;

/**
 * Classe per la gestione della data e dell'ora
 * @author Gabriele Nicosanti
 *
 */

public class DataOra {

	public static String getDataOra() {
		SimpleDateFormat sdf = new SimpleDateFormat();
		return sdf.format(new Date());
	}

	public static String getDataIt() {
		Locale.setDefault(Locale.ITALIAN);
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
		return sdf.format(new Date());
	}

	public static int getGiorno() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		return Integer.parseInt(sdf.format(new Date()));
	}

	public static int getMeseNumero() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		return Integer.parseInt(sdf.format(new Date()));
	}

	public static String getMeseNome() {
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM");
		return sdf.format(new Date());
	}

	public static int getAnno() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		return Integer.parseInt(sdf.format(new Date()));
	}

	public static String getMonthName(int month) {
		return new DateFormatSymbols().getMonths()[month-1];
	}

	public static String previousMonth() {
		int nmese = getMeseNumero()-1;
		if (nmese == 0)
			nmese = 12;
		return getMonthName(nmese);
	}
	
	public static String previousMonthNumber(int before) {
		int nmese = getMeseNumero()-before;
		while (nmese <= 0)
			nmese += 12;
		return getMonthName(nmese);
	}

	public static String nextMonth() {
		int nmese = getMeseNumero()+1;
		if (nmese == 13)
			nmese = 1;
		return getMonthName(nmese);
	}
	
	public static String nextMonthYear() {
		String nxtM = nextMonth();
		int anno = getAnno();
		if (nxtM.toLowerCase().equals("gennaio"))
			anno++;
		return nxtM + " " + anno;
	}

	
//	JDK8	
//	public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
//		if ((birthDate != null) && (currentDate != null)) {
//			return Period.between(birthDate, currentDate).getYears();
//		} else {
//			return 0;
//		}
//	}
//	
//	public static int calculateAge(int giorno, int mese, int anno) {
//		LocalDate birthDate = LocalDate.of(anno, mese, giorno);
//		return calculateAge(birthDate,LocalDate.now(ZoneId.of("Europe/Rome")));
//	}
	
	//JODA
	public static int calculateAge(int giorno, int mese, int anno) {
		LocalDate birthdate = new LocalDate (anno, mese, giorno);
		LocalDate now = new LocalDate();
		Years age = Years.yearsBetween(birthdate, now);
		return age.getYears();
	}

	
}
