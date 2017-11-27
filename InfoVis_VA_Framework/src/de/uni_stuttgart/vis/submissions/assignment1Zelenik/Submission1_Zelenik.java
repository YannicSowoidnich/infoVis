package de.uni_stuttgart.vis.submissions.assignment1Zelenik;

import java.awt.Color;
import java.awt.Font;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import de.uni_stuttgart.vis.data.WeightedString;
import de.uni_stuttgart.vis.data.assignment1.wordcloud.DataProvider;
import de.uni_stuttgart.vis.framework.InfoVisFramework;
import de.uni_stuttgart.vis.geom.AbstractGeometry;
import de.uni_stuttgart.vis.geom.Rectangle;
import de.uni_stuttgart.vis.helper.StringHelper;

public class Submission1_Zelenik extends InfoVisFramework {

    public Rectangle createGeometry(String text, Font font, int x, int y) {
        java.awt.Rectangle helperRect = StringHelper.getStringSize(text, font);
        int rx = (int) helperRect.getWidth();
        int ry = (int) helperRect.getHeight();

        Rectangle rect = new Rectangle(x, y, rx, ry);
        // transparent rect background
        rect.setColor(new Color(0f, 0f, 0f, .0f));
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
        Font defaultFont = new Rectangle(0, 0, 0, 0).getFont();
        Font font;
        input = new DataProvider().getWords();
        output = new LinkedList<AbstractGeometry>();
        Collections.sort(input);
        double radius = 31;
        double dRadius = 6.3;
        int dDeg = 4;
        Random rand = new Random();
        int startDeg = rand.nextInt(360);
        int prev_x = -1;
        int prev_y = -1;
        int deg = startDeg;
        for (int i = 0; i < input.size(); i++) {
            font = new Font("Arial", defaultFont.getStyle(), input.get(i).getFrequency()/2);
            double rad = ((double) deg / Math.PI) * 180.0;
            int cx = (int) (1280 / 2 + radius * Math.cos(rad));
            int cy = (int) (720 / 2 + radius * Math.sin(rad));
            if (prev_x == cx && prev_y == cy) continue;
            prev_x = cx;
            prev_y = cy;
            Rectangle getRekt = this.createGeometry(input.get(i).getText(), font, cx, cy);
            output.add(getRekt);
            if (deg < startDeg + 360) {
                deg += dDeg;
                radius += dRadius;
            }
        }
        return output;
    }
}
