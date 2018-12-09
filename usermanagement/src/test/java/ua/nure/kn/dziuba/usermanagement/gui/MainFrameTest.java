package ua.nure.kn.dziuba.usermanagement.gui;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.NamedComponentFinder;
import junit.framework.TestCase;
import ua.nure.kn.dziuba.usermanagement.util.Messages;

import javax.swing.*;
import java.awt.*;

public class MainFrameTest extends JFCTestCase {

    private MainFrame mainFrame;

    public void setUp() throws Exception {
        super.setUp();
        setHelper(new JFCTestHelper());
        mainFrame = new MainFrame();
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

    public void testBrowseControls(){
        find(JPanel.class, "browsePanel");

        JTable table = (JTable) find(JTable.class, "userTable");
        assertEquals(3, table.getColumnCount());
        assertEquals("ID", table.getColumnName(0));
        assertEquals(Messages.getString("first_name"), table.getColumnName(1));
        assertEquals(Messages.getString("last_name"), table.getColumnName(2));

        find(JButton.class, "addButton");
        find(JButton.class, "editButton");
        find(JButton.class, "deleteButton");
        find(JButton.class, "detailsButton"); }

    public void testAddUser(){
        JButton addButton = (JButton)find(JButton.class, "addButton");
        getHelper().enterClickAndLeave(new MouseEventData(this, addButton));
        find(JPanel.class, "addPanel");

        find(JTextField.class, "firstNameField");
        find(JTextField.class, "lastNameField");
        find(JTextField.class, "dateOfBirthField");
        find(JButton.class, "okButton");
        find(JButton.class, "cancelButton");
    }
}