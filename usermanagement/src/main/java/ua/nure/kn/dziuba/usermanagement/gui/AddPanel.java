package ua.nure.kn.dziuba.usermanagement.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPanel extends JPanel implements ActionListener {

    private MainFrame parent;
    private JPanel buttonPanel;
    private JPanel fieldPanel;
    private JButton okButton;
    private JButton cancelButton;

    public AddPanel(MainFrame frame){
        parent = frame;
        initialize();
    }

    private void initialize() {
        this.setLayout(new BorderLayout());
        this.add(getFieldPanel(), BorderLayout.NORTH);
        this.add(getButtonsPanel(), BorderLayout.SOUTH);
    }

    private Component getButtonsPanel() {
        if(buttonPanel == null){
            buttonPanel = new JPanel();
            buttonPanel.add(getOkButton(), null);
            buttonPanel.add(getCancelButton(), null);
        }
        return buttonPanel;
    }

    private JButton getCancelButton() {
        if(cancelButton == null){
            cancelButton = new JButton();
            cancelButton.setText("Cancel");
            cancelButton.setName("cancelButtton");
            cancelButton.setActionCommand("cancel");
            cancelButton.addActionListener(this);
        }
        return cancelButton;
    }

    private JButton getOkButton() {
        if(okButton == null){
            okButton = new JButton();
            okButton.setText("OK");
            okButton.setName("okButton");
            okButton.setActionCommand("ok");
            okButton.addActionListener(this);
        }
        return okButton;
    }

    private Component getFieldPanel() {
        if(fieldPanel == null){
            fieldPanel = new JPanel();
        }
        return fieldPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
