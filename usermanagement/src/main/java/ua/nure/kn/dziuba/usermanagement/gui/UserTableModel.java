package ua.nure.kn.dziuba.usermanagement.gui;

import ua.nure.kn.dziuba.usermanagement.User;
import ua.nure.kn.dziuba.usermanagement.util.Messages;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserTableModel extends AbstractTableModel {
    private List users = null;
    private User user = null;
    private static final String[] COLUMN_NAMES = {"ID", Messages.getString("first_name"), Messages.getString("last_name")};
    private static final Class[] COLUMN_CLASSES = {Long.class, String.class, String.class};

    public UserTableModel(Collection users) {
        this.users = new ArrayList(users);
    }

    public UserTableModel(User user){
        this.user = user;
    }

    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        User user = (User) users.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return user.getId();
            case 1:
                return user.getFirstName();
            case 2:
                return user.getLastName();
        }
        return null;
    }

    public Class getColumnClass(int columnIndex){
        return COLUMN_CLASSES[columnIndex];
    }

    public String getColumnName(int columnIndex){
        return COLUMN_NAMES[columnIndex];
    }
}
