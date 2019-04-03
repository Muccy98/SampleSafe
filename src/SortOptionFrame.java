// A borderless window for selecting sort option

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SortOptionFrame extends CustomPopUp{

    public SortOptionFrame(ActionListener al, JButton parent){
      super(100, 90, parent);

      // add sort optionsW
        this.getContentPane().setLayout(new BoxLayout( getContentPane(), BoxLayout.Y_AXIS));
        this.getContentPane().add(new JLabel("Sort by:"));
        String names[] = {"Rating", "Sample Name", "Creation Date"};
        for (String n : names){
            JButton nb = new JButton(n);
            nb.setSize(new Dimension(100, 30));
            nb.setOpaque(false);
            //nb.setContentAreaFilled(false);
            nb.setBorderPainted(false);
            nb.setMaximumSize(getSize());
            nb.addActionListener(al);
            this.getContentPane().add(nb);
        }
    }
}