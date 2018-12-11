package ua.nure.kn.dziuba.usermanagement.gui;

import ua.nure.kn.dziuba.usermanagement.User;
import ua.nure.kn.dziuba.usermanagement.util.Messages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;

public abstract class AbstractPanel extends JPanel implements ActionListener {

    private JPanel buttonPanel;
    private JButton okButton;
    private JButton cancelButton;
    protected MainFrame parent;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField dateOfBirthField;
    private JPanel fieldPanel;
    private JPanel infoPanel;
    private JLabel infoLabel;

    public AbstractPanel(MainFrame parent){
        this.parent = parent;
        initialize();
    }

    public abstract void initialize();

    public Component getFieldPanel() {
        if(fieldPanel == null){
            fieldPanel = new JPanel();
            fieldPanel.setLayout(new GridLayout(3, 2));
            addLabeledField(fieldPanel, Messages.getString("first_name"), getFirstNameField());
            addLabeledField(fieldPanel, Messages.getString("last_name"), getLastNameField());
            addLabeledField(fieldPanel, Messages.getString("date_of_birth"), getDateOfBirthField());
        }
        return fieldPanel;
    }

    public void addLabeledField(JPanel panel, String labelText, JTextField textField) {
        JLabel label = new JLabel(labelText);
        label.setLabelFor(textField);
        panel.add(label);
        panel.add(textField);
    }

    public JPanel getButtonsPanel() {
        if(buttonPanel == null){
            buttonPanel = new JPanel();
            buttonPanel.add(getOkButton(), null);
            buttonPanel.add(getCancelButton(), null);
        }
        return buttonPanel;
    }

    public JButton getOkButton() {
        if(okButton == null){
            okButton = new JButton();
            okButton.setText(Messages.getString("ok"));
            okButton.setName("okButton");
            okButton.setActionCommand("ok");
            okButton.addActionListener(this);
        }
        return okButton;
    }

    public JButton getCancelButton() {
        if(cancelButton == null){
            cancelButton = new JButton();
            cancelButton.setText(Messages.getString("cancel"));
            cancelButton.setName("cancelButton");
            cancelButton.setActionCommand("cancel");
            cancelButton.addActionListener(this);
        }
        return cancelButton;
    }

    public JTextField getFirstNameField() {
        if(firstNameField == null){
            firstNameField = new JTextField();
            firstNameField.setName("firstNameField");
        }
        return firstNameField;
    }

    public JTextField getLastNameField() {
        if(lastNameField == null){
            lastNameField = new JTextField();
            lastNameField.setName("lastNameField");
        }
        return lastNameField;
    }

    public JTextField getDateOfBirthField() {
        if(dateOfBirthField == null){
            dateOfBirthField = new JTextField();
            dateOfBirthField.setName("dateOfBirthField");
        }
        return dateOfBirthField;
    }

    public JPanel getLabelPanel() {
        if(infoPanel == null){
            infoPanel = new JPanel();
            infoPanel.add(getLabel(), null);
        }
        return infoPanel;
    }

    public JLabel getLabel() {
        if(infoLabel == null){
            infoLabel = new JLabel();
        }
        return infoLabel;
    }

    public JPanel getButtonPanel() {
        if(buttonPanel == null){
            buttonPanel = new JPanel();
            buttonPanel.add(getOkButton(), null);
        }
        return buttonPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("ok".equalsIgnoreCase(e.getActionCommand())){
            performAction();
        }
        clearFields();
        this.setVisible(false);
        parent.showBrowsePanel();
    }

    public abstract void performAction();

    public void clearFields(){
        getFirstNameField().setText("");
        getFirstNameField().setBackground(Color.WHITE);

        getLastNameField().setText("");
        getLastNameField().setBackground(Color.WHITE);

        getDateOfBirthField().setText("");
        getDateOfBirthField().setBackground(Color.WHITE);
    }

    public void setUserInfo(User user){
        user.setFirstName(getFirstNameField().getText());
        user.setLastName(getLastNameField().getText());

        DateFormat dateFormat = DateFormat.getDateInstance();
        try{
            user.setDateOfBirth(dateFormat.parse(getDateOfBirthField().getText()));
        }catch (ParseException e1){
            getDateOfBirthField().setBackground(Color.RED);
        }
    }
}
