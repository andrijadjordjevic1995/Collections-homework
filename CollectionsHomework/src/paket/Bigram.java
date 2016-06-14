package paket;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map.Entry;

public class Bigram {

	public static void main(String[] args) {
		
		Map<String, Integer> frekvencije = new HashMap<String, Integer>();
		String ulazni = "abbcceeeeeeabcc";
		String bigram = "";
		int maxFrek = 0;
		for (int i = 0; i < ulazni.length() - 1; i++) {
			bigram = bigram + ulazni.charAt(i) + ulazni.charAt(i + 1);
			if (frekvencije.containsKey(bigram)) {
				frekvencije.replace(bigram, frekvencije.get(bigram) + 1);// povecaj frekvenciju
			} else {
				frekvencije.put(bigram, 1);
			}
			bigram = "";
		}
		Bigram.ispisiFrekvencije((HashMap<String, Integer>) frekvencije);
		Bigram.predvidiNarednihNKaraktera((HashMap<String, Integer>) frekvencije, 3);
		
		
	}

	public static void ispisiFrekvencije(HashMap<String, Integer> frekvencije) {
		
		for (Entry<String, Integer> entry : frekvencije.entrySet()) {
			System.out.println(entry.getKey()+": "+entry.getValue());
		}
	}
	
	public static void predvidiNarednihNKaraktera(HashMap<String, Integer> frekvencije, int n){
		Scanner scanner = new Scanner(System.in);
		Pattern regex;
//		Matcher matcher;
		
		System.out.println("Unesite string: ");
		String ulazIzlaz = scanner.nextLine();
		int maxFrek;//nema potrebe izracunavati verovatnoce,
					//dovoljno je uporediti frekvencije pojavljivanja 
					//svih bigrama koji pocinju karakterom kojim se zavrsava string ulazIzlaz
		char c;
		
		while(n-- != 0){
			regex = Pattern.compile(ulazIzlaz.charAt(ulazIzlaz.length()-1)+"[A-Za-z]");
			maxFrek = 0;
			c = ' ';
			for (Entry<String, Integer> entry : frekvencije.entrySet()) {
				if(regex.matcher(entry.getKey()).matches() && entry.getValue() > maxFrek){
					maxFrek = entry.getValue();
					c = entry.getKey().charAt(1);
				}
			}
			ulazIzlaz += c;
		}
		System.out.println(ulazIzlaz);
	}
}
