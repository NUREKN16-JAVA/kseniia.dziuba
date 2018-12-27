package ua.nure.kn.dziuba.usermanagement.gui;

<<<<<<< HEAD
=======
import ua.nure.kn.dziuba.usermanagement.User;
>>>>>>> agent2
import ua.nure.kn.dziuba.usermanagement.db.DatabaseException;
import ua.nure.kn.dziuba.usermanagement.util.Messages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BrowsePanel extends JPanel implements ActionListener {
<<<<<<< HEAD
=======

>>>>>>> agent2
    private MainFrame parent;
    private JPanel buttonPanel;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton detailsButton;
    private JScrollPane tablePanel;
    private JTable userTable;

<<<<<<< HEAD
    /**
     * {@inheritDoc}
     * */
=======
>>>>>>> agent2
    public BrowsePanel(MainFrame frame) {
        parent = frame;
        initialize();
    }

<<<<<<< HEAD
    /**
     * {@inheritDoc}
     * */
=======
>>>>>>> agent2
    private void initialize() {
        this.setLayout(new BorderLayout());
        this.add(getTablePanel(), BorderLayout.CENTER);
        this.add(getButtonsPanel(), BorderLayout.SOUTH);
        this.setName("browsePanel");
    }

<<<<<<< HEAD
    /**
     * Gets singleton buttons panel.
     *
     * @return buttonPanel.
     * */
=======
>>>>>>> agent2
    private Component getButtonsPanel() {
        if (buttonPanel == null) {
            buttonPanel = new JPanel();
            buttonPanel.add(getAddButton(), null);
            buttonPanel.add(getEditButton(), null);
            buttonPanel.add(getDeleteButton(), null);
            buttonPanel.add(getDetailsButton(), null);
        }
        return buttonPanel;
    }

<<<<<<< HEAD
    /**
     * Gets singleton "details" button.
     *
     * @return detailsButton.
     * */
=======
>>>>>>> agent2
    private JButton getDetailsButton() {
        if (detailsButton == null) {
            detailsButton = new JButton();
            detailsButton.setText(Messages.getString("details"));
            detailsButton.setName("detailsButton");
            detailsButton.setActionCommand("details");
            detailsButton.addActionListener(this);
        }
        return detailsButton;
    }

<<<<<<< HEAD
    /**
     * Gets singleton "delete" button.
     *
     * @return deleteButton.
     * */
=======
>>>>>>> agent2
    private JButton getDeleteButton() {
        if (deleteButton == null) {
            deleteButton = new JButton();
            deleteButton.setText(Messages.getString("delete"));
            deleteButton.setName("deleteButton");
            deleteButton.setActionCommand("delete");
            deleteButton.addActionListener(this);
        }
        return deleteButton;
    }

<<<<<<< HEAD
    /**
     * Gets singleton "edit" button.
     *
     * @return editButton.
     * */
=======
>>>>>>> agent2
    private JButton getEditButton() {
        if (editButton == null) {
            editButton = new JButton();
            editButton.setText(Messages.getString("edit"));
            editButton.setName("editButton");
            editButton.setActionCommand("edit");
            editButton.addActionListener(this);
        }
        return editButton;
    }

<<<<<<< HEAD
    /**
     * Gets singleton "add" button.
     *
     * @return addButton.
     * */
=======
>>>>>>> agent2
    private JButton getAddButton() {
        if (addButton == null) {
            addButton = new JButton();
            addButton.setText(Messages.getString("add"));
            addButton.setName("addButton");
            addButton.setActionCommand("add");
            addButton.addActionListener(this);
        }
        return addButton;
    }

<<<<<<< HEAD
    /**
     * Gets singleton table panel.
     *
     * @return tablePanel.
     * */
=======
>>>>>>> agent2
    private JScrollPane getTablePanel() {
        if (tablePanel == null) {
            tablePanel = new JScrollPane(getUserTable());
        }
        return tablePanel;
    }

<<<<<<< HEAD
    /**
     * Gets singleton user table.
     *
     * @return userTable.
     * */
=======
>>>>>>> agent2
    private JTable getUserTable() {
        if (userTable == null) {
            userTable = new JTable();
            userTable.setName("userTable");
        }
        return userTable;
    }

<<<<<<< HEAD
    /**
     * Initializes table of users.
     * */
=======
>>>>>>> agent2
    public void initTable(){
        UserTableModel model;
        try {
            model = new UserTableModel(parent.getDao().findAll());
        }catch (DatabaseException e){
            model = new UserTableModel(new ArrayList());
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        userTable.setModel(model);
    }

<<<<<<< HEAD
    /**
     * Performs actions if buttons clicked.
     * */
=======
>>>>>>> agent2
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if ("add".equalsIgnoreCase(actionCommand)) {
            this.setVisible(false);
            parent.showAddPanel();
        }
        if("delete".equalsIgnoreCase(actionCommand)){
            Long userId = (long) userTable.getValueAt(userTable.getSelectedRow(), 0);
            this.setVisible(false);
<<<<<<< HEAD
            try{
                parent.showDeletePanel(parent.getDao().find(userId));
            }catch (DatabaseException e1){
                e1.printStackTrace();
            }
=======
            parent.setUserId(userId);
            parent.showDeletePanel();
>>>>>>> agent2
        }
        if("details".equalsIgnoreCase(actionCommand)){
            Long userId = (long) userTable.getValueAt(userTable.getSelectedRow(), 0);
            this.setVisible(false);
<<<<<<< HEAD
            try{
                parent.showDetailsPanel(parent.getDao().find(userId));
            }catch (DatabaseException e1){
                e1.printStackTrace();
            }
        }
        if("edit".equalsIgnoreCase(actionCommand)){
            Long userId = (long) userTable.getValueAt(userTable.getSelectedRow(), 0);
            this.setVisible(false);
            try{
                parent.showEditPanel(parent.getDao().find(userId));
            }catch (DatabaseException e1){
                e1.printStackTrace();
            }
=======
            parent.setUserId(userId);
            parent.showDetailsPanel();
>>>>>>> agent2
        }
    }
}
