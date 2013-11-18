package a7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.TrieST;
import edu.princeton.cs.introcs.In;

public class Index {
	TrieST<List<Integer>> indices;

	public Index(String file) {
		indices = new TrieST<List<Integer>>();
		BufferedReader br;
		try {
			In f = new In(new File(file));
			int lineno = 0;
			String[] words;
			for (String line : f.readAll().split("\\n")) {
				words = line.split("\\s");
				for (String word : words) {
					record(word, lineno);
				}
				lineno++;
			}
		} catch (Exception e) {
			System.out.println("https://www.youtube.com/watch?v=oHg5SJYRHA0"); //lol
		}
		
	}

	private void record(String word, int lineno) {
		List<Integer> entry = indices.get(word);
		if (entry == null) {
			entry = new ArrayList<Integer>();
			indices.put(word, entry);
		}
		entry.add(lineno);
	}

	public String get(String string) {
		if (indices.get(string) == null) return null;
		StringBuilder sb = new StringBuilder();
		for (int line : indices.get(string)) {
			sb.append(line+" ");
		}
		return sb.toString();
	}

}
