package ua.nure.kn.dziuba.usermanagement.web;

import junit.framework.TestCase;
import ua.nure.kn.dziuba.usermanagement.User;
import ua.nure.kn.dziuba.usermanagement.gui.AddPanel;

import java.text.DateFormat;
import java.util.Date;

public class AddServletTest extends MockServletTestCase {

    public void setUp() throws Exception {
        super.setUp();
        createServlet(AddServlet.class);
    }

    public void testAdd(){
        User newUser = new User();
        newUser.setFirstName("John");
        newUser.setLastName("Doe");
        newUser.setDateOfBirth(new Date());
        User user = createUserForTest();
        getMockUserDao().expectAndReturn("create", newUser, user);
        addRequestParameter("firstName", "John");
        addRequestParameter("lastName", "Doe");
        addRequestParameter("dateOfBirth", DateFormat.getDateInstance().format(new Date()));
        addRequestParameter("okButton", "Ok");
        doPost();
    }

    public void testAddEmptyFirstName(){
        addRequestParameter("lastName", "Doe");
        addRequestParameter("dateOfBirth", DateFormat.getDateInstance().format(new Date()));
        addRequestParameter("okButton", "Ok");
        doPost();
        String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
        assertNotNull("Couldn't find error message in session", errorMessage);
    }

    public void testAddEmptyLastName(){
        addRequestParameter("firstName", "John");
        addRequestParameter("dateOfBirth", DateFormat.getDateInstance().format(new Date()));
        addRequestParameter("okButton", "Ok");
        doPost();
        String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
        assertNotNull("Couldn't find error message in session", errorMessage);
    }

    public void testAddEmptyDate(){
        addRequestParameter("firstName", "John");
        addRequestParameter("lastName", "Doe");
        addRequestParameter("okButton", "Ok");
        doPost();
        String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
        assertNotNull("Couldn't find error message in session", errorMessage);
    }
    public void testAddInvalidDate(){
        addRequestParameter("firstName", "John");
        addRequestParameter("lastName", "Doe");
        addRequestParameter("dateOfBirth", "invalidDate");
        addRequestParameter("okButton", "Ok");
        doPost();
        String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
        assertNotNull("Couldn't find error message in session", errorMessage);
    }
}