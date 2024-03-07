package com.fdmgroup.Ood_Corwin.Yip;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFileReader {
	public static List<String> readFileToArrayList(String fileName) throws IOException {
		String line;
		List<String> lines = new ArrayList<>();
		
		// Creates a FileReader
		FileReader file = new FileReader(fileName);
		
		// Creates a BufferedReader based on a FileReader
		BufferedReader input = new BufferedReader(file);
		
		while ((line = input.readLine()) != null) {
            lines.add(line);
        }
		
		input.close();
		
		return lines;
					
	}
}

