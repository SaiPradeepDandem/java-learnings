package com.sai.java.swings;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloWorldSwing {
  public static void main(String[] args) {
    JFrame frame = new JFrame("HelloWorldSwing");
    final JLabel label = new JLabel("Sai Hello World");
    final JLabel label1 = new JLabel("xcvcv");
    frame.getContentPane().add(label1);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}
