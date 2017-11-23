package de.uni_stuttgart.vis.submissions;

import java.util.Collections;
import java.util.List;

import de.uni_stuttgart.vis.data.WeightedString;
import de.uni_stuttgart.vis.data.wordcloud.DataProvider;
import de.uni_stuttgart.vis.framework.InfoVisFramework;
import de.uni_stuttgart.vis.geom.AbstractGeometry;

public class Submission1_LastNameOfTheGroupLeader extends InfoVisFramework{
	List<WeightedString> input = new DataProvider().getWords();
	
	public Submission1_LastNameOfTheGroupLeader() {
		Collections.sort(input);
		for (int i = 0; i<input.size(); i++) {
			System.out.println("Word: " + input.get(i).getText() + "Frequenz: " + input.get(i).getFrequency() );
		}
		this.mapData();
	}


	@Override
	public List<AbstractGeometry> mapData() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		Submission1_LastNameOfTheGroupLeader sub1 = new Submission1_LastNameOfTheGroupLeader();
	}


}
