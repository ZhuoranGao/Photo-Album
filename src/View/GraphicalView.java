package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.List;

import javax.swing.*;

import Model.IShape;
import Model.Snapshot;

/**
 * Build the class: GraphicalView.
 */
public class GraphicalView extends JPanel{

  /**
   * Build the class: GraphicalView.
   */
  public void updateText(String[] curSnapShot, JPanel panel, LinkedHashMap<String, Snapshot> map){
    JLabel label = new JLabel();
    String text = "<html>Snapshot id: "+map.get(curSnapShot[0]).getId()+"<br/>Description: "+map.get(curSnapShot[0]).getDescription() +"<html>";
    panel.setLayout(new FlowLayout(FlowLayout.LEFT));
    label.setText(text);
    panel.removeAll();
    panel.add(label);
    panel.revalidate();
  }

  /**
   * Build the class: graphicalView.
   * @param frameWidth width of frame.
   * @param frameHeight height of frame.
   * @param map map that store data from model.
   * @param snapshotId the id list of shape.
   */
  public void graphicalView(int frameWidth, int frameHeight, LinkedHashMap<String, Snapshot> map, List<String>snapshotId){
    //Set the id of curSnapShot.
    final String[] curSnapShot = {snapshotId.get(snapshotId.size() - 1)};

    //Set frame.
    JFrame frame = new JFrame("CS5004 Shapes Photo Album Viewer");
    frame.setSize(frameWidth,frameHeight);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

    //Set panel.
    JPanel topPanel = new JPanel();
    JPanel midPanel = new DrawingCanvas(map.get(curSnapShot[0]));
    JPanel bottomPanel = new JPanel();

    //Set top panel and add text.
    topPanel.setBackground(Color.pink);
    updateText(curSnapShot,topPanel,map);

    //Set middle panel and bottom panel.
    midPanel.setBackground(Color.gray);
    bottomPanel.setBackground(Color.yellow);

    //Set button.
    JButton buttonPrev = new JButton("<< Prev <<");
    JButton buttonSelect = new JButton("^^ Select ^^");
    JButton buttonNext = new JButton(">> Next >>");
    JButton buttonQuit = new JButton("xx Quit xx");

    //Set location of button.
    buttonPrev.setBounds(100, 180,  80, 20);
    buttonSelect.setBounds(200, 180, 80, 20);
    buttonNext.setBounds(300, 180, 80, 20);
    buttonQuit.setBounds(400, 180, 80, 20);

    //Add button to panel.
    bottomPanel.add(buttonPrev);
    bottomPanel.add(buttonSelect);
    bottomPanel.add(buttonNext);
    bottomPanel.add(buttonQuit);

    //Add panel to frame.
    frame.add(topPanel,BorderLayout.NORTH);
    frame.add(midPanel);
    frame.add(bottomPanel, BorderLayout.SOUTH);

    //set the select button.
    buttonSelect.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String[] choices = new String[snapshotId.size()];
        snapshotId.toArray(choices);
        String input = (String) JOptionPane.showInputDialog(null,
                "Choose", "menu",
                JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
        GraphicalView g = new GraphicalView();
        midPanel.revalidate();
        DrawingCanvas dc2 = new DrawingCanvas(map.get(input));
        frame.add(dc2);
        curSnapShot[0] = input;
        updateText(curSnapShot,topPanel,map);
      }
    });

//Set prev button.
buttonPrev.addActionListener(new ActionListener() {
  @Override
  public void actionPerformed(ActionEvent e) {
    int index = snapshotId.indexOf(curSnapShot[0]);
    if(index<=0){
      JOptionPane.showMessageDialog(null, "There is no snapshot!");
      throw new IndexOutOfBoundsException();
    }else{
      midPanel.revalidate();
      DrawingCanvas dc3 = new DrawingCanvas(map.get(snapshotId.get(index-1)));
      frame.add(dc3);
    }
    curSnapShot[0] = snapshotId.get(index-1);
    updateText(curSnapShot,topPanel,map);
  }
});

    //Set next button.
    buttonNext.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int index = snapshotId.indexOf(curSnapShot[0]);
        System.out.println(index);
        if(index>=snapshotId.size()-1){
          JOptionPane.showMessageDialog(null, "There is no snapshot!");
          throw new IndexOutOfBoundsException();
        }else{
          midPanel.revalidate();
          DrawingCanvas dc3 = new DrawingCanvas(map.get(snapshotId.get(index+1)));
          frame.add(dc3);
        }
        curSnapShot[0] = snapshotId.get(index+1);
        updateText(curSnapShot,topPanel,map);
      }
    });

//Set quit button.
    buttonQuit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "You quit!");
        System.exit(1);
      }
    });
  }
}
