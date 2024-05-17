
package view;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
import org.jfree.data.general.*;
import org.jfree.chart.*;

public class TourismEmploymentInnerPanel extends JPanel{

	JFreeChart[] fc = new JFreeChart[7];
	PieDataset[] das = new PieDataset[7]; //= //createDataset();
	ChartPanel[] cPanel = new ChartPanel[7];
	//JScrollBar bar = new JScrollBar();
	
	public TourismEmploymentInnerPanel() {
		setLayout(null);
		setBackground(Color.lightGray);
		//setBounds(70, 100, 320, 500);
        setPreferredSize(new Dimension(300,500));
	//	bar.setBounds(300, 0, 20, 500);
		//bar.setOrientation(1);
		//add(bar);
		
		for(int i = 0; i < 7; i ++) {
			das[i] = createDataset(i);
			fc[i] = ChartFactory.createPieChart(String.valueOf(2017+i), das[i], true, true, true);
			cPanel[i] = new ChartPanel(fc[i]);
			cPanel[i].setBounds(0, i*300, 300, 300);
			add(cPanel[i]);

		}
		setPreferredSize(new Dimension(300,2150));
		
	}

	private PieDataset createDataset(int index) {
		DefaultPieDataset ds = new DefaultPieDataset();
		ds.setValue("0", 100);
		ds.setValue("1-4", 100);
		ds.setValue("5-9", 100);
		ds.setValue("10-19", 100);
		ds.setValue("10-19", 100);
		ds.setValue("20-49", 100);
		ds.setValue("50-99", 100);
		ds.setValue("100-199", 100);
		ds.setValue("200+", 100);
		return ds;
	}

	
}