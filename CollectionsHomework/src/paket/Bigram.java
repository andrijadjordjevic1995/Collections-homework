package paket;

import java.util.HashMap;
import java.util.Map;
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
				frekvencije.replace(bigram, frekvencije.get(bigram) + 1);// povecaj
																			// frekvenciju
			} else {
				frekvencije.put(bigram, 1);
			}
			bigram = "";
		}
		Bigram.ispisiFrekvencije((HashMap<String, Integer>)frekvencije);
		
	}

	public static void ispisiFrekvencije(HashMap<String, Integer> frekvencije) {
		
		for (Entry<String, Integer> entry : frekvencije.entrySet()) {
			System.out.println(entry.getKey()+": "+entry.getValue());
		}
	}
}
