package ua.nure.kn.dziuba.usermanagement.gui;

import ua.nure.kn.dziuba.usermanagement.User;
import ua.nure.kn.dziuba.usermanagement.util.Messages;

import java.awt.*;
import java.awt.event.ActionListener;

public class DetailsPanel extends AbstractPanel implements ActionListener {
    public DetailsPanel(MainFrame frame){
        super(frame);
        this.setName("detailsPanel");
    }

    public void initialize() {
        this.setLayout(new BorderLayout());
        this.add(getLabelPanel(), BorderLayout.CENTER);
        this.add(getButtonPanel(), BorderLayout.SOUTH);
    }

    @Override
    public void performAction() {
    }

    public void showDetailsPanel(User user) {
        getLabel().setText(new StringBuilder().append("<html><body><div style=\"text-align: center;\">ID:").append(" ").append(user.getId()).append("<br/>")
                .append(Messages.getString("first_name")).append(": ").append(user.getFirstName()).append("<br/>")
                .append(Messages.getString("last_name")).append(": ").append(user.getLastName()).append("<br/>")
                .append(Messages.getString("date_of_birth") + ": " + user.getDateOfBirth()).append("</div></body></html>").toString());
    }
}
