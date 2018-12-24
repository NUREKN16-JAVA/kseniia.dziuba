package ua.nure.kn.dziuba.usermanagement.gui;

import ua.nure.kn.dziuba.usermanagement.User;
import ua.nure.kn.dziuba.usermanagement.db.DatabaseException;
import ua.nure.kn.dziuba.usermanagement.util.Messages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;

public class DeletePanel extends JPanel implements ActionListener {
    private MainFrame parent;
    private JLabel infoLabel;
    private JPanel infoPanel;
    private JPanel buttonPanel;
    private JButton okButton;
    private JButton cancelButton;

    public DeletePanel(MainFrame frame){
        parent = frame;
        initialize();
    }

    private void initialize() {
        this.setName("deletePanel");
        this.setLayout(new BorderLayout());
        this.add(getLabelPanel(), BorderLayout.CENTER);
        this.add(getButtonsPanel(), BorderLayout.SOUTH);
    }

    private JPanel getButtonsPanel() {
        if(buttonPanel == null){
            buttonPanel = new JPanel();
            buttonPanel.add(getOkButton(), null);
            buttonPanel.add(getCancelButton(), null);
        }
        return buttonPanel;
    }

    private JPanel getLabelPanel(){
        if(infoPanel == null){
            infoPanel = new JPanel();
            infoPanel.add(getLabel(), null);
        }
        return infoPanel;
    }

    private JButton getCancelButton() {
        if(cancelButton == null){
            cancelButton = new JButton();
            cancelButton.setText(Messages.getString("cancel"));
            cancelButton.setName("cancelButton");
            cancelButton.setActionCommand("cancel");
            cancelButton.addActionListener(this);
        }
        return cancelButton;
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
        infoLabel.setText(Messages.getString("sure_to_delete") + " " + parent.getUser().getFirstName() + " " + parent.getUser().getLastName() + "?");
        return infoLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("ok".equalsIgnoreCase(e.getActionCommand())){
            try{
                parent.getDao().delete(parent.getUser());
            }catch (DatabaseException e1){
                JOptionPane.showMessageDialog(this, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        this.setVisible(false);
        parent.showBrowsePanel();
    }
}
