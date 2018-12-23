package ua.nure.kn.dziuba.usermanagement.web;

import junit.framework.TestCase;
import ua.nure.kn.dziuba.usermanagement.User;

import java.text.DateFormat;
import java.util.Date;

public class EditServletTest extends MockServletTestCase {

    public void setUp() throws Exception {
        super.setUp();
        createServlet(EditServlet.class);
    }

    public void testEdit(){
        User user = createUserForTest();
        getMockUserDao().expect("update", user);
        addRequestParameter("id", "1000");
        addRequestParameter("firstName", "John");
        addRequestParameter("lastName", "Doe");
        addRequestParameter("dateOfBirth", DateFormat.getDateInstance().format(new Date()));
        addRequestParameter("okButton", "Ok");
        doPost();
    }

    public void testEditEmptyFirstName(){
        addRequestParameter("id", "1000");
        addRequestParameter("lastName", "Doe");
        addRequestParameter("dateOfBirth", DateFormat.getDateInstance().format(new Date()));
        addRequestParameter("okButton", "Ok");
        doPost();
        String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
        assertNotNull("Couldn't find error message in session", errorMessage);
    }

    public void testEditEmptyLastName(){
        addRequestParameter("id", "1000");
        addRequestParameter("firstName", "John");
        addRequestParameter("dateOfBirth", DateFormat.getDateInstance().format(new Date()));
        addRequestParameter("okButton", "Ok");
        doPost();
        String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
        assertNotNull("Couldn't find error message in session", errorMessage);
    }

    public void testEditEmptyDate(){
        addRequestParameter("id", "1000");
        addRequestParameter("firstName", "John");
        addRequestParameter("lastName", "Doe");
        addRequestParameter("okButton", "Ok");
        doPost();
        String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
        assertNotNull("Couldn't find error message in session", errorMessage);
    }
    public void testEditInvalidDate(){
        addRequestParameter("id", "1000");
        addRequestParameter("firstName", "John");
        addRequestParameter("lastName", "Doe");
        addRequestParameter("dateOfBirth", "invalidDate");
        addRequestParameter("okButton", "Ok");
        doPost();
        String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
        assertNotNull("Couldn't find error message in session", errorMessage);
    }
}