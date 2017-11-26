package de.uni_stuttgart.vis.submissions;

import java.awt.Font;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import de.uni_stuttgart.vis.data.WeightedString;
import de.uni_stuttgart.vis.data.wordcloud.DataProvider;
import de.uni_stuttgart.vis.framework.InfoVisFramework;
import de.uni_stuttgart.vis.geom.AbstractGeometry;
import de.uni_stuttgart.vis.geom.Rectangle;

public class Submission1_LastNameOfTheGroupLeader extends InfoVisFramework{
	List<WeightedString> input;
	List<AbstractGeometry> output;
	AbstractGeometry entry;
	Font defaultFont = new Rectangle(0,0,0,0).getFont();
	Font font;
	
	public Submission1_LastNameOfTheGroupLeader() {
		this.mapData();
	}
	
	public Rectangle createGeometry(String text, Font font) {
		Rectangle rect = new Rectangle(20, 20, 20, 20);
		rect.setText(text);
		rect.setFont(font);
		return rect;
	}

	
	public static void main(String[] args) {
		Submission1_LastNameOfTheGroupLeader sub1 = new Submission1_LastNameOfTheGroupLeader();
	}

	@Override
	public List<AbstractGeometry> mapData() {
		this.input = new DataProvider().getWords();
		output = new LinkedList<AbstractGeometry>();
		Collections.sort(this.input);
		for (int i = 0; i<this.input.size(); i++) {		
			font = new Font("Arial", defaultFont.getStyle(), input.get(i).getFrequency());
			output.add(this.createGeometry(input.get(i).getText(), font));
		}
		return output;
	}


}
