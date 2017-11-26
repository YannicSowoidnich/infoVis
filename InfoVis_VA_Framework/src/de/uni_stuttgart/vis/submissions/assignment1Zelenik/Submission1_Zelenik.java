package de.uni_stuttgart.vis.submissions.assignment1Zelenik;

import java.awt.Font;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import de.uni_stuttgart.vis.data.WeightedString;
import de.uni_stuttgart.vis.data.assignment1.wordcloud.DataProvider;
import de.uni_stuttgart.vis.framework.InfoVisFramework;
import de.uni_stuttgart.vis.geom.AbstractGeometry;
import de.uni_stuttgart.vis.geom.Rectangle;

public class Submission1_Zelenik extends InfoVisFramework{
	
	public Rectangle createGeometry(String text, Font font) {
		Rectangle rect = new Rectangle(20, 20, 20, 20);
		rect.setText(text);
		rect.setFont(font);
		return rect;
	}

	
	public static void main(String[] args) {
		Submission1_Zelenik sub1 = new Submission1_Zelenik();
	}

	@Override
	public List<AbstractGeometry> mapData() {
		List<WeightedString> input;
		List<AbstractGeometry> output;
		AbstractGeometry entry;
		Font defaultFont = new Rectangle(0,0,0,0).getFont();
		Font font;
		input = new DataProvider().getWords();
		output = new LinkedList<AbstractGeometry>();
		Collections.sort(input);
		for (int i = 0; i<input.size(); i++) {		
			font = new Font("Arial", defaultFont.getStyle(), input.get(i).getFrequency());
			output.add(this.createGeometry(input.get(i).getText(), font));
		}
		return output;
	}


}
