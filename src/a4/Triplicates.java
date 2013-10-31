package a4;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Triplicates {
	private enum Array { A, B, C};

	public static String find(String[] a, String[] b, String[] c) {
		
		TreeMap<String, EnumSet<Array>> tracking = new TreeMap<String, EnumSet<Array>>();
		for (int i=0; i<a.length; i++) {
			tracking.put(a[i], EnumSet.of(Array.A));
		}
		for (int i=0; i<b.length; i++) {
			try {
				tracking.get(b[i]).add(Array.B);
			} catch (NullPointerException e) {
				continue; //A didn't contain this name, so no need to add it to tracking
			}
		}
		for (int i=0; i<c.length; i++) {
			try {
				tracking.get(c[i]).add(Array.C);
			} catch (NullPointerException e) {
				continue; //A didn't contain this name, so no need to add it to tracking
			}
		}
		
		//TreeMap automatically sorts by keys, which ensures that the first key found 
		//common to all three will also be lexographically first
		EnumSet<Array> allThree = EnumSet.of(Array.A, Array.B, Array.C);
		for (Map.Entry<String, EnumSet<Array>> entry : tracking.entrySet()) {
			if (entry.getValue().containsAll(allThree)) return entry.getKey();
		}
		
		return null;
	}

}
