package ua.nure.kn.dziuba.usermanagement.gui;

import javafx.scene.input.DataFormat;
import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.eventdata.StringEventData;
import junit.extensions.jfcunit.finder.NamedComponentFinder;
import junit.framework.TestCase;
import ua.nure.kn.dziuba.usermanagement.db.DaoFactory;
import ua.nure.kn.dziuba.usermanagement.db.DaoFactoryImpl;
import ua.nure.kn.dziuba.usermanagement.db.MockUserDao;
import ua.nure.kn.dziuba.usermanagement.util.Messages;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.Properties;

public class MainFrameTest extends JFCTestCase {

    private MainFrame mainFrame;

    public void setUp() throws Exception {
        super.setUp();
        try{
            Properties properties = new Properties();
            properties.getProperty("dao.ua.nure.kn.dziuba.usermanagement.db.UserDao", MockUserDao.class.getName());
            properties.setProperty("dao.factory", DaoFactoryImpl.class.getName());
            DaoFactory.init(properties);

            setHelper(new JFCTestHelper());
            mainFrame = new MainFrame();
        }catch (Exception e){
            fail(e.getMessage());
        }
        mainFrame.setVisible(true);
    }

    public void tearDown() throws Exception {
        mainFrame.setVisible(false);
        getHelper().cleanUp(this);
        super.tearDown();
    }

    private Component find(Class componentClass, String name) {
        NamedComponentFinder finder = new NamedComponentFinder(componentClass, name);
        finder.setWait(0);
        Component component = finder.find(mainFrame, 0);
        assertNotNull("Could not find component '" + name + "'", component);

        return component;
    }

    public void testBrowseControls() {
        find(JPanel.class, "browsePanel");

        JTable table = (JTable) find(JTable.class, "userTable");
        assertEquals(3, table.getColumnCount());
        assertEquals("ID", table.getColumnName(0));
        assertEquals(Messages.getString("first_name"), table.getColumnName(1));
        assertEquals(Messages.getString("last_name"), table.getColumnName(2));

        find(JButton.class, "addButton");
        find(JButton.class, "editButton");
        find(JButton.class, "deleteButton");
        find(JButton.class, "detailsButton");
    }

    public void testAddUser() {
        JTable userTable = (JTable) find(JTable.class, "userTable");
        assertEquals(0, userTable.getRowCount());

        JButton addButton = (JButton) find(JButton.class, "addButton");
        getHelper().enterClickAndLeave(new MouseEventData(this, addButton));
        find(JPanel.class, "addPanel");

        JTextField firstNameField = (JTextField) find(JTextField.class, "firstNameField");
        JTextField lastNameField = (JTextField) find(JTextField.class, "lastNameField");
        JTextField dateOfBirthField = (JTextField) find(JTextField.class, "dateOfBirthField");
        JButton okButton = (JButton) find(JButton.class, "okButton");
        find(JButton.class, "cancelButton");

        getHelper().sendString(new StringEventData(this, firstNameField, "Kseniia"));
        getHelper().sendString(new StringEventData(this, lastNameField, "Dziuba"));

        DateFormat dateFormat = DateFormat.getDateInstance();
        String date = dateFormat.format(new Date());
        getHelper().sendString(new StringEventData(this, dateOfBirthField, date));

        getHelper().enterClickAndLeave(new MouseEventData(this, okButton));

        find(JPanel.class, "browsePanel");
        userTable = (JTable) find(JTable.class, "userTable");
        assertEquals(1, userTable.getRowCount());
    }
}