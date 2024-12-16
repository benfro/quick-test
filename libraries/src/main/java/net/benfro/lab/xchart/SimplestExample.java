package net.benfro.lab.xchart;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import javax.swing.*;

public class SimplestExample {
   public SimplestExample() {
      double[] xData = new double[] { 0.0, 1.0, 2.0 };
      double[] yData = new double[] { 2.0, 1.0, 0.0 };

// Create Chart
      XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", xData, yData);

// Show it
      JFrame jFrame = new SwingWrapper(chart).displayChart();

      try {
         Thread.sleep(30000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }

// Save it
      //BitmapEncoder.saveBitmap(chart, "./Sample_Chart", BitmapFormat.PNG);

// or save it in high-res
      //BitmapEncoder.saveBitmapWithDPI(chart, "./Sample_Chart_300_DPI", BitmapFormat.PNG, 300);
   }
}
