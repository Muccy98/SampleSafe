import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Date;


public class ResultPanel extends JPanel {
    private SampleSafe ss;
    private SampleListItem preItem;

    /* Demo samples */
    private Sample samples[] = {
            new Sample("SNARE(10).wav",     3, new String[]{"Snare", "Clap", "Blam!", "Ahhhhh!!!", "Boop", "etc"}, "Jack", new Date(), "Just a demo", "Nowhere", false, false, true),
            new Sample("SMD_Snare_10.wav",  4, new String[]{"Sexy", "Drum"}, "Ross",new Date(), "Just a demo", "Nowhere", false, true, true),
            new Sample("Kick Puncher",      5, new String[]{"Kick", "Something", "Nice"}, "Jie", new Date(), "Just a demo", "Nowhere", false, true, true),
            new Sample("Kick Agile Shot",   2, new String[]{"Kick", "Something", "Nice"}, "Ross",new Date(), "Just a demo", "Nowhere", true, true, true),
            new Sample("Kick 1.wav",        5, new String[]{"Deep", "Something", "Nice"}, "Jie", new Date(), "Just a demo", "Nowhere", false, true, true),
            new Sample("Hihat Quick Watcher",4, new String[]{"Something", "Nice"}, "Ross",new Date(), "Just a demo", "Nowhere", true, true, true),
            new Sample("Hihat Closed Corner", 2, new String[]{"Something", "Nice"}, "Jie", new Date(), "Just a demo", "Nowhere", false, false, true),
            new Sample("bcg kick.wav", 2, new String[]{"Something", "Nice"}, "Ross",new Date(), "Just a demo", "Nowhere", false, true, false),
            new Sample("A-Conga Low Slap 2", 4, new String[]{"Lowkey", "Slap", "Something", "Nice"}, "Jie", new Date(), "Just a demo", "Nowhere", false, true, true),
            new Sample("A-Conga Low Slap 1", 3, new String[]{"Slap","Something", "Nice"}, "Ross",new Date(), "Just a demo", "Nowhere", true, true, false)
    };

    private SampleListItem sli;
    private JPanel resultView;
    private JScrollPane scrollResultView;

    public ResultPanel(SampleSafe ss){
        this.ss = ss;
        setLayout(new BorderLayout());

        // This is the panel containing the list items
        resultView = new JPanel();
        resultView.setLayout(new BoxLayout(resultView, BoxLayout.Y_AXIS));

        // Make scroll pane from result view
        scrollResultView = new JScrollPane(resultView,  JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                                        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollResultView.getVerticalScrollBar().setUnitIncrement(0x0A);
        scrollResultView.setBorder(new EmptyBorder( 0x19,0x19,0x19,0x19));

        // Add scroll pane
        add(scrollResultView, BorderLayout.CENTER);

        // demostration of displaying samples
        displayResult(samples);
   }

    /**
     * Method for displaying samples, Use this
     * @param result what samples to display
     */
   public void displayResult(Sample[] result)
   {
       // Remove all components
       resultView.removeAll();
       preItem = null;
       // Instantiate new sample list item components
       for(int i = 0; i < result.length; i++){
           // Pass display sample
           sli = new SampleListItem(result[i], ss, this);
           //sli.setPreferredSize(new Dimension(220, 100));
           sli.setBorder(new EmptyBorder(10, 10, 10, 10));
           // Add to view
           resultView.add(sli);
       }
       revalidate();
   }

   public void changeSelectionStatus(SampleListItem sli){
        if(preItem!= null && !preItem.equals(sli)){
            preItem.changeSelectionStatus(false);
        }
        preItem = sli;
   }

}
