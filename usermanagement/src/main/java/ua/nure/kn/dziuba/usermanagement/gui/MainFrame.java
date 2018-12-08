package ua.nure.kn.dziuba.usermanagement.gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JPanel contentPanel;
    private BrowsePanel browsePanel;
    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 800;

    public MainFrame(){
        super();
        initialize();
    }

    private void initialize(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle("User management");
        this.setContentPane(getContentPanel());
    }

    private JPanel getContentPanel(){
        if(contentPanel == null){
            contentPanel = new JPanel();
            contentPanel.setLayout(new BorderLayout());
            contentPanel.add(getBrowsePanel(), BorderLayout.CENTER);
        }

        return contentPanel;
    }

    private BrowsePanel getBrowsePanel(){
        if(browsePanel == null){
            browsePanel = new BrowsePanel(this);
        }
        return browsePanel;
    }

    public static void main(String args[]){
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
    }
}
