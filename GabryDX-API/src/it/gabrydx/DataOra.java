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
	
	public static String getOrario() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		return sdf.format(new Date());
	}
	
	public static int getOre() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH");
		return Integer.parseInt(sdf.format(new Date()));
	}
	
	public static int getMinuti() {
		SimpleDateFormat sdf = new SimpleDateFormat("mm");
		return Integer.parseInt(sdf.format(new Date()));
	}
	
	public static int getSecondi() {
		SimpleDateFormat sdf = new SimpleDateFormat("ss");
		return Integer.parseInt(sdf.format(new Date()));
	}

	public static int getGiorno() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		return Integer.parseInt(sdf.format(new Date()));
	}
	
	public static String getGiornoDellaSettimanaBreve() {
		SimpleDateFormat sdf = new SimpleDateFormat("E");
		return sdf.format(new Date());
	}
	
	public static String getGiornoDellaSettimanaLungo() {
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
		return sdf.format(new Date());
	}

	public static int getMeseNumero() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		return Integer.parseInt(sdf.format(new Date()));
	}

	public static String getMeseNome() {
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM");
		return sdf.format(new Date()).toLowerCase();
	}

	public static int getAnno() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		return Integer.parseInt(sdf.format(new Date()));
	}
	
	public static String getMeseNumeroAnno() {
		return getMeseNumero()+" "+getAnno();
	}
	
	public static String getMeseNomeAnno() {
		return getMeseNome()+" "+getAnno();
	}

	public static String getMonthName(int month) {
		return new DateFormatSymbols().getMonths()[month-1];
	}
	
	public static String previousMonthNumber(int before) {
		int nmese = getMeseNumero()-before;
		while (nmese <= 0)
			nmese += 12;
		return getMonthName(nmese);
	}
	
	public static String previousMonth() {
		return previousMonthNumber(1);
	}
	
	public static String nextMonthNumber(int after) {
		int nmese = getMeseNumero()+after;
		while (nmese >= 13)
			nmese -= 12;
		return getMonthName(nmese);
	}

	public static String nextMonth() {
		return nextMonthNumber(1);
	}
	
	public static String nextMonthYear() {
		String nxtM = nextMonth();
		int anno = getAnno();
		if (nxtM.toLowerCase().equals("gennaio"))
			anno++;
		return nxtM + " " + anno;
	}
	
	public static String previousMonthYear() {
		String prvM = previousMonth();
		int anno = getAnno();
		if (prvM.toLowerCase().equals("dicembre"))
			anno--;
		return prvM + " " + anno;
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
