package ua.nure.kn.dziuba.usermanagement.gui;

<<<<<<< HEAD
import ua.nure.kn.dziuba.usermanagement.User;
import ua.nure.kn.dziuba.usermanagement.util.Messages;

import java.awt.*;
import java.awt.event.ActionListener;

public class DetailsPanel extends AbstractPanel implements ActionListener {
    /**
     * {@inheritDoc}
     * */
    public DetailsPanel(MainFrame frame){
        super(frame);
        this.setName("detailsPanel");
    }

    /**
     * {@inheritDoc}
     * */
    public void initialize() {
=======
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
>>>>>>> agent2
        this.setLayout(new BorderLayout());
        this.add(getLabelPanel(), BorderLayout.CENTER);
        this.add(getButtonPanel(), BorderLayout.SOUTH);
    }

<<<<<<< HEAD
    /**
     * {@inheritDoc}
     * */
    @Override
    public void performAction() {
    }

    /**
     * Shows details panel.
     * */
    public void showDetailsPanel(User user) {
        getLabel().setText(new StringBuilder().append("<html><body><div style=\"text-align: center;\">ID:").append(" ").append(user.getId()).append("<br/>")
                .append(Messages.getString("first_name")).append(": ").append(user.getFirstName()).append("<br/>")
                .append(Messages.getString("last_name")).append(": ").append(user.getLastName()).append("<br/>")
                .append(Messages.getString("date_of_birth") + ": " + user.getDateOfBirth()).append("</div></body></html>").toString());
=======
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
>>>>>>> agent2
    }
}
