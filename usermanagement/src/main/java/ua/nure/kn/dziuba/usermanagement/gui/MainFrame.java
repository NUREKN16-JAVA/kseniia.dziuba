package ua.nure.kn.dziuba.usermanagement.gui;

import ua.nure.kn.dziuba.usermanagement.User;
import ua.nure.kn.dziuba.usermanagement.db.DaoFactory;
import ua.nure.kn.dziuba.usermanagement.db.DatabaseException;
import ua.nure.kn.dziuba.usermanagement.db.UserDao;
import ua.nure.kn.dziuba.usermanagement.util.Messages;

import javax.swing.*;
import java.awt.*;

import static junit.framework.Assert.fail;

public class MainFrame extends JFrame {

    private JPanel contentPanel;
    private BrowsePanel browsePanel;
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 300;
    private AddPanel addPanel;
    private DeletePanel deletePanel;
    private DetailsPanel detailsPanel;
    private UserDao dao;
    private Long userId;
    private EditPanel editPanel;

    public MainFrame() {
        super();
        dao = DaoFactory.getInstance().getUserDao();
        initialize();
    }

    public UserDao getDao() {
        return dao;
    }

    private void initialize() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle(Messages.getString("user_management"));
        this.setContentPane(getContentPanel());
    }

    private void showPanel(JPanel panel) {
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setVisible(true);
        panel.repaint();
    }

    public void showAddPanel() {
        showPanel(getAddPanel());
    }

    public void showBrowsePanel() {
        this.showPanel(getBrowsePanel());
    }

    public void showDeletePanel(User user) {
        DeletePanel deletePanel = getDeletePanel();
        ((DeletePanel)deletePanel).showDeletePanel(user);
        this.showPanel(getDeletePanel());
    }

    public void showDetailsPanel(User user){
        DetailsPanel detailsPanel = getDetailsPanel();
        ((DetailsPanel)detailsPanel).showDetailsPanel(user);
        this.showPanel(getDetailsPanel());
    }
    public void showEditPanel(User user){
        EditPanel editPanel = getEditPanel();
        ((EditPanel)editPanel).showEditPanel(user);
        this.showPanel(getEditPanel());
    }

    private BrowsePanel getBrowsePanel() {
        if (browsePanel == null) {
            browsePanel = new BrowsePanel(this);
        }
        ((BrowsePanel) browsePanel).initTable();

        return browsePanel;
    }

    private EditPanel getEditPanel(){
        if(editPanel== null){
            editPanel = new EditPanel(this);
        }
        return editPanel;
    }

    private DetailsPanel getDetailsPanel() {
        if(detailsPanel == null){
            detailsPanel = new DetailsPanel(this);
        }

        return detailsPanel;
    }

    private DeletePanel getDeletePanel() {
        if (deletePanel == null) {
            deletePanel = new DeletePanel(this);
        }

        return deletePanel;
    }

    private AddPanel getAddPanel() {
        if (addPanel == null) {
            addPanel = new AddPanel(this);
        }

        return addPanel;
    }

    private JPanel getContentPanel() {
        if (contentPanel == null) {
            contentPanel = new JPanel();
            contentPanel.setLayout(new BorderLayout());
            contentPanel.add(getBrowsePanel(), BorderLayout.CENTER);
        }

        return contentPanel;
    }

    public User getUser() {
        try {
            return dao.find(userId);
        } catch (DatabaseException e) {
            fail(e.getMessage());
        }
        return null;
    }

    public static void main(String args[]) {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
    }
}
