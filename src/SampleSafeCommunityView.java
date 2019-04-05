import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class SampleSafeCommunityView extends JFrame {

    private SampleSafe ss;
    private SearchBarPanel searchBarPanel;
    private ResultPanel resultPanel;
    private OtherButtonsPanelCommunity communityPanel;
    private GroupsPanel groupsPanel;
    private InfoPanel infoPanel;
    private ProfilePanel profilePanel;
    public ArrayList<Sample> result;


    public SampleSafeCommunityView(SampleSafe ss){
        this.ss = ss;
    }

    public void Setup(){

        this.setTitle("Community");
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        result = new ArrayList<Sample>();

        resultPanel = new ResultPanel(ss);
        infoPanel = new InfoPanel(ss);
        searchBarPanel = new SearchBarPanel(ss);
        profilePanel = new ProfilePanel(ss);
        communityPanel = new OtherButtonsPanelCommunity(ss);
        add(resultPanel, BorderLayout.LINE_START);
        add(infoPanel, BorderLayout.LINE_END);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        add(topPanel, BorderLayout.PAGE_START);
        topPanel.add(searchBarPanel, BorderLayout.CENTER);
        topPanel.add(profilePanel, BorderLayout.LINE_END);

        Box box = Box.createHorizontalBox();
        box.add(Box.createRigidArea(new Dimension(1,0)));
        box.add(Box.createHorizontalGlue());
        box.add(communityPanel);
        add(box, BorderLayout.PAGE_END);

        result.add(new Sample("Demo.wav",3, new String[]{"Snare", "Clap", "Blam!", "Boop"}, "Jack", new Date(), "Demo", System.getProperty("user.home") + "\\Documents\\SampleSafe\\Demo.wav", false, false, true));
        displayResult(result);

        this.setSize(new Dimension(900, 800));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        revalidate();
    }

    public void displaySample(Sample sample){
        infoPanel.displaySample(sample);
    }
    public void displayResult(ArrayList<Sample> samples){
        resultPanel.displayResult(samples);
    }
    public SampleSafe getSS() {
        return ss;
    }
}
