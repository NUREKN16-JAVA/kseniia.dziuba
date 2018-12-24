package ua.nure.kn.dziuba.usermanagement.gui;

import ua.nure.kn.dziuba.usermanagement.db.DatabaseException;
import ua.nure.kn.dziuba.usermanagement.util.Messages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetailsPanel extends JPanel implements ActionListener {
    private MainFrame parent;
    private JPanel buttonPanel;
    private JPanel infoPanel;
    private JButton okButton;
    private JLabel infoLabel;

    public DetailsPanel(MainFrame frame){
        parent = frame;
        initialize();
    }

    private void initialize() {
        this.setName("detailsPanel");
        this.setLayout(new BorderLayout());
        this.add(getLabelPanel(), BorderLayout.CENTER);
        this.add(getButtonPanel(), BorderLayout.SOUTH);
    }

    private JPanel getLabelPanel() {
        if(infoPanel == null){
            infoPanel = new JPanel();
            infoPanel.add(getLabel(), null);
        }
        return infoPanel;
    }

    private JPanel getButtonPanel() {
        if(buttonPanel == null){
            buttonPanel = new JPanel();
            buttonPanel.add(getOkButton(), null);
        }
        return buttonPanel;
    }

    private JButton getOkButton() {
        if(okButton == null){
            okButton = new JButton();
            okButton.setText(Messages.getString("ok"));
            okButton.setName("okButton");
            okButton.setActionCommand("ok");
            okButton.addActionListener(this);
        }
        return okButton;
    }

    private JLabel getLabel() {
        if(infoLabel == null){
            infoLabel = new JLabel();
        }
        infoLabel.setText(new StringBuilder().append("<html><body><div style=\"text-align: center;\">ID:").append(" ").append(parent.getUser().getId()).append("<br/>")
                .append(Messages.getString("first_name")).append(": ").append(parent.getUser().getFirstName()).append("<br/>")
                .append(Messages.getString("last_name")).append(": ").append(parent.getUser().getLastName()).append("<br/>")
                .append(Messages.getString("date_of_birth") + ": " + parent.getUser().getDateOfBirth()).append("</div></body></html>").toString());
        return infoLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
        parent.showBrowsePanel();
    }
}
