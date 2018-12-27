package ua.nure.kn.dziuba.usermanagement.gui;

import ua.nure.kn.dziuba.usermanagement.User;
import ua.nure.kn.dziuba.usermanagement.db.DaoFactory;
import ua.nure.kn.dziuba.usermanagement.db.DatabaseException;
import ua.nure.kn.dziuba.usermanagement.db.UserDao;
import ua.nure.kn.dziuba.usermanagement.util.Messages;

import javax.swing.*;
import java.awt.*;

<<<<<<< HEAD
public class MainFrame extends JFrame {
=======
import static junit.framework.Assert.fail;

public class MainFrame extends JFrame {

>>>>>>> agent2
    private JPanel contentPanel;
    private BrowsePanel browsePanel;
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 300;
    private AddPanel addPanel;
    private DeletePanel deletePanel;
    private DetailsPanel detailsPanel;
    private UserDao dao;
    private Long userId;
<<<<<<< HEAD
    private EditPanel editPanel;
=======
>>>>>>> agent2

    public MainFrame() {
        super();
        dao = DaoFactory.getInstance().getUserDao();
        initialize();
    }

<<<<<<< HEAD
    /**
     * Gets UserDao dao.
     * */
=======
>>>>>>> agent2
    public UserDao getDao() {
        return dao;
    }

<<<<<<< HEAD
    /**
     * Initializes MainFrame structure properties.
     * */
=======
>>>>>>> agent2
    private void initialize() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle(Messages.getString("user_management"));
        this.setContentPane(getContentPanel());
    }

<<<<<<< HEAD
    /**
     * Shows panel.
     *
     * @param panel to show.
     * */
    private void showPanel(JPanel panel) {
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setVisible(true);
        panel.repaint();
    }

    /**
     * Shows add panel.
     * */
    public void showAddPanel() {
        showPanel(getAddPanel());
    }

    /**
     * Shows browse panel.
     * */
    public void showBrowsePanel() {
        this.showPanel(getBrowsePanel());
    }

    /**
     * Shows delete panel.
     *
     * @param user to delete.
     * */
    public void showDeletePanel(User user) {
        DeletePanel deletePanel = getDeletePanel();
        ((DeletePanel)deletePanel).showDeletePanel(user);
        this.showPanel(getDeletePanel());
    }

    /**
     * Shows details panel.
     *
     * @param user to get details.
     * */
    public void showDetailsPanel(User user){
        DetailsPanel detailsPanel = getDetailsPanel();
        ((DetailsPanel)detailsPanel).showDetailsPanel(user);
        this.showPanel(getDetailsPanel());
    }

    /**
     * Shows edit panel.
     *
     * @param user to edit.
     * */
    public void showEditPanel(User user){
        EditPanel editPanel = getEditPanel();
        ((EditPanel)editPanel).showEditPanel(user);
        this.showPanel(getEditPanel());
    }

    /**
     * Gets singleton browse panel.
     *
     * @return browsePanel.
     * */
=======
    private JPanel getContentPanel() {
        if (contentPanel == null) {
            contentPanel = new JPanel();
            contentPanel.setLayout(new BorderLayout());
            contentPanel.add(getBrowsePanel(), BorderLayout.CENTER);
        }

        return contentPanel;
    }

>>>>>>> agent2
    private BrowsePanel getBrowsePanel() {
        if (browsePanel == null) {
            browsePanel = new BrowsePanel(this);
        }
        ((BrowsePanel) browsePanel).initTable();

        return browsePanel;
    }

<<<<<<< HEAD
    /**
     * Gets singleton edit panel.
     *
     * @return editPanel.
     * */
    private EditPanel getEditPanel(){
        if(editPanel== null){
            editPanel = new EditPanel(this);
        }
        return editPanel;
    }

    /**
     * Gets singleton edit panel.
     *
     * @return editPanel.
     * */
    private DetailsPanel getDetailsPanel() {
        if(detailsPanel == null){
            detailsPanel = new DetailsPanel(this);
        }

        return detailsPanel;
    }

    /**
     * Gets singleton delete panel.
     *
     * @return deletePanel.
     * */
=======
    public static void main(String args[]) {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
    }

    public void showAddPanel() {
        showPanel(getAddPanel());
    }

    private void showPanel(JPanel panel) {
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setVisible(true);
        panel.repaint();
    }

    private AddPanel getAddPanel() {
        if (addPanel == null) {
            addPanel = new AddPanel(this);
        }

        return addPanel;
    }

>>>>>>> agent2
    private DeletePanel getDeletePanel() {
        if (deletePanel == null) {
            deletePanel = new DeletePanel(this);
        }

        return deletePanel;
    }

<<<<<<< HEAD
    /**
     * Gets singleton add panel.
     *
     * @return addPanel.
     * */
    private AddPanel getAddPanel() {
        if (addPanel == null) {
            addPanel = new AddPanel(this);
        }

        return addPanel;
    }

    /**
     * Gets singleton content panel.
     *
     * @return contentPanel.
     * */
    private JPanel getContentPanel() {
        if (contentPanel == null) {
            contentPanel = new JPanel();
            contentPanel.setLayout(new BorderLayout());
            contentPanel.add(getBrowsePanel(), BorderLayout.CENTER);
        }

        return contentPanel;
    }

    /**
     * Gets user.
     *
     * @return user if user was found in DB.
     * @return null if user was not found.
     * */
=======
    public void showBrowsePanel() {
        this.showPanel(getBrowsePanel());
    }

    public void showDeletePanel() {
        this.showPanel(getDeletePanel());
    }

    public void setUserId(Long userId){
        this.userId = userId;
    }

    public void showDetailsPanel(){
        this.showPanel(getDetailsPanel());
    }

    private JPanel getDetailsPanel() {
        if(detailsPanel == null){
            detailsPanel = new DetailsPanel(this);
        }

        return detailsPanel;
    }

>>>>>>> agent2
    public User getUser() {
        try {
            return dao.find(userId);
        } catch (DatabaseException e) {
<<<<<<< HEAD
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Main method to load application.
     * */
    public static void main(String args[]) {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
    }
=======
            fail(e.getMessage());
        }
        return null;
    }
>>>>>>> agent2
}
