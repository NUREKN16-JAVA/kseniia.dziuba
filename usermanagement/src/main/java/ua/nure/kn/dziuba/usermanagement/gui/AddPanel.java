package ua.nure.kn.dziuba.usermanagement.gui;

import ua.nure.kn.dziuba.usermanagement.User;
import ua.nure.kn.dziuba.usermanagement.db.DatabaseException;
<<<<<<< HEAD

import javax.swing.*;
import java.awt.*;

public class AddPanel extends AbstractPanel{
    /**
     * {@inheritDoc}
     * */
    public AddPanel(MainFrame frame){
        super(frame);
        this.setName("addPanel");
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public void initialize() {
=======
import ua.nure.kn.dziuba.usermanagement.util.Messages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;

public class AddPanel extends JPanel implements ActionListener {

    private MainFrame parent;
    private JPanel buttonPanel;
    private JPanel fieldPanel;
    private JButton okButton;
    private JButton cancelButton;
    private JTextField dateOfBirthField;
    private JTextField lastNameField;
    private JTextField firstNameField;

    public AddPanel(MainFrame frame){
        parent = frame;
        initialize();
    }

    private void initialize() {
        this.setName("addPanel");
>>>>>>> agent2
        this.setLayout(new BorderLayout());
        this.add(getFieldPanel(), BorderLayout.NORTH);
        this.add(getButtonsPanel(), BorderLayout.SOUTH);
    }

<<<<<<< HEAD
    /**
     * {@inheritDoc}
     * */
    @Override
    public void performAction() {
        User user = new User();
        setUserInfo(user);
        try{
            parent.getDao().create(user);
        }catch (DatabaseException e1){
            JOptionPane.showMessageDialog(this, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
=======
    private JPanel getButtonsPanel() {
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

    private Component getFieldPanel() {
        if(fieldPanel == null){
            fieldPanel = new JPanel();
            fieldPanel.setLayout(new GridLayout(3, 2));
            addLabeledField(fieldPanel, Messages.getString("first_name"), getFirstNameField());
            addLabeledField(fieldPanel, Messages.getString("last_name"), getLastNameField());
            addLabeledField(fieldPanel, Messages.getString("date_of_birth"), getDateOfBirth());
        }
        return fieldPanel;
    }

    private JTextField getDateOfBirth() {
        if(dateOfBirthField == null){
            dateOfBirthField = new JTextField();
            dateOfBirthField.setName("dateOfBirthField");
        }
        return dateOfBirthField;
    }

    private JTextField getLastNameField() {
        if(lastNameField == null){
            lastNameField = new JTextField();
            lastNameField.setName("lastNameField");
        }
        return lastNameField;
    }

    private void addLabeledField(JPanel panel, String labelText, JTextField textField) {
        JLabel label = new JLabel(labelText);
        label.setLabelFor(textField);
        panel.add(label);
        panel.add(textField);
    }

    private JTextField getFirstNameField() {
        if(firstNameField == null){
            firstNameField = new JTextField();
            firstNameField.setName("firstNameField");
        }
        return firstNameField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("ok".equalsIgnoreCase(e.getActionCommand())){
            User user = new User();
            user.setFirstName(getFirstNameField().getText());
            user.setLastName(getLastNameField().getText());
            DateFormat dateFormat = DateFormat.getDateInstance();
            try{
                user.setDateOfBirth(dateFormat.parse(getDateOfBirth().getText()));
            }catch (ParseException e1){
                getDateOfBirth().setBackground(Color.RED);
            }

            try{
                parent.getDao().create(user);
            }catch (DatabaseException e1){
                JOptionPane.showMessageDialog(this, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        clearFields();
        this.setVisible(false);
        parent.showBrowsePanel();
    }

    public void clearFields(){
        getFirstNameField().setText("");
        getFirstNameField().setBackground(Color.WHITE);
        getLastNameField().setText("");
        getLastNameField().setBackground(Color.WHITE);
        getDateOfBirth().setText("");
        getDateOfBirth().setBackground(Color.WHITE);
>>>>>>> agent2
    }
}
