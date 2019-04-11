import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ProfileFrameTMP extends CustomPopUp {

    private JButton saveAndExitButton;
    private JLabel name, bio, profilePicture;
    private JTextArea bioField;
    private JTextField nameField;
    private SortOptionFrame sof;

    public ProfileFrameTMP(JButton parent){
        super(400, 400, parent);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        BufferedImage master = null;
        try {
            master = ImageIO.read(new File(System.getProperty("user.home") + "\\Desktop\\download.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int diameter = Math.min(master.getWidth(), master.getHeight());
        BufferedImage mask = new BufferedImage(master.getWidth(), master.getHeight(), BufferedImage.TYPE_INT_ARGB);

        //source: https://stackoverflow.com/questions/31423130/how-to-make-circle-image-label-in-java

        Graphics2D g2d = mask.createGraphics();
        applyQualityRenderingHints(g2d);
        g2d.fillOval(0, 0, diameter - 1, diameter - 1);
        g2d.dispose();

        BufferedImage masked = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
        g2d = masked.createGraphics();
        applyQualityRenderingHints(g2d);
        int x = (diameter - master.getWidth()) / 2;
        int y = (diameter - master.getHeight()) / 2;
        g2d.drawImage(master, x, y, null);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_IN));
        g2d.drawImage(mask, 0, 0, null);
        g2d.dispose();

        profilePicture = new JLabel(new ImageIcon(masked));
        //profilePicture.setAlignmentX(Component.CENTER_ALIGNMENT);
        profilePicture.setBorder(new EmptyBorder(10, 10, 10, 10));
        saveAndExitButton = new JButton("Save & Exit");
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                close_dialog();
            }
        };
        saveAndExitButton.addActionListener(listener);

        name = new JLabel("Name: ");
        bio = new JLabel("Bio: ");
        nameField = new JTextField();
        bioField = new JTextArea(8, 8);
        bioField.setLineWrap(true);
        JScrollPane spBF = new JScrollPane(bioField);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        panel.add(profilePicture);
        panel.add(name);
        panel.add(nameField);
        panel.add(bio);
        panel.add(spBF);
        saveAndExitButton.setMaximumSize(getSize());
        panel.add(saveAndExitButton);


        this.getContentPane().add(panel);
        this.pack();

        this.setSize(new Dimension( 500, 400));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);


    }

    public static void applyQualityRenderingHints(Graphics2D g2d) {

        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

    }
}