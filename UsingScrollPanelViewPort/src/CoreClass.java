import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class CoreClass extends JFrame {

    JScrollPane scroller;
    JPanel contentPanel;
    JButton panelAddButt;

    public static void main(String[] args) {
        new CoreClass();
    }

    public CoreClass() {
        createAndShowGUI();


    }

    private void createAndShowGUI() {

        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.PAGE_AXIS));


        scroller = new JScrollPane();
        scroller.setViewportView(contentPanel);
        scroller.setPreferredSize(new Dimension(155, 405));
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        this.add(scroller);

        panelAddButt = new JButton("Add Panel");
        // ew inline actionListener
        panelAddButt.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        addPanel();
                    }
                }
        );

        this.add(panelAddButt);

        // I hate this method so much but I don't see any other way
        // see  end of addPanel() method for
        pack();
        setVisible(true);

    }

    private void addPanel() {

        System.out.println("adding a panel");

        Random rand = new Random();
        Color randomColor = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());

        JPanel tempPanel = new JPanel();

        // other layout managers seemed to ignore setMin/setMax-Layout methods. finally something works.
        tempPanel.setPreferredSize(new Dimension(100, 20));
        tempPanel.setMaximumSize(new Dimension(100, 20));
        tempPanel.setMinimumSize(new Dimension(100, 20));

        tempPanel.setBackground(randomColor);
        tempPanel.add(new Label("Hello?"));

        contentPanel.add(tempPanel);


        /*
        updateUI and revalidate both seem to make sure the newly added panels show up
        but a stackOverflow Post recommended using both revalidate and repaint
        it's so unclear what is needed at what time.
        If there is no scrollbar, these methods make sure stuff shows up, otherwise,
        when a scrollbar is available, dragging it causes the UI to update and show
        otherwise hidden stuff.
         */
        scroller.updateUI();
        scroller.revalidate();
        scroller.repaint();

        // Please help me figure out why this is needed to prevent a weird bend around the text in the JPanel!
        // stumbled across this solution by chance and it pisses me off
        pack();

    }

}
