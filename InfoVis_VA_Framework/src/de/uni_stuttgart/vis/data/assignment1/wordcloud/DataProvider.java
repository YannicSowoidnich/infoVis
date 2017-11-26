package de.uni_stuttgart.vis.data.assignment1.wordcloud;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import de.uni_stuttgart.vis.data.WeightedString;

public class DataProvider {
	public List<WeightedString> getWords() {
	//	File csvFile = new File(Data.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "de\\uni_stuttgart\\vis\\data\\WordListA.csv");
	//	File csvFile = new File(".\\Data\\WordListA.csv");
		InputStream configStream = getClass().getResourceAsStream("WordListA.csv");
	//	try {
	//		BufferedReader configReader = new BufferedReader(new InputStreamReader(configStream, "UTF-8"));
	//	} catch (UnsupportedEncodingException e1) {
	//		// TODO Auto-generated catch block
	//		e1.printStackTrace();
	//	}
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";
	
		List<WeightedString> result = new LinkedList<WeightedString>();
		try {
			br = new BufferedReader(new InputStreamReader(configStream, "UTF-8"));
			while ((line = br.readLine()) != null) {
	
				// use comma as separator
				String[] splitLine = line.split(cvsSplitBy);
				result.add(new WeightedString(splitLine[0], Integer.parseInt(splitLine[1])));
			}
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
