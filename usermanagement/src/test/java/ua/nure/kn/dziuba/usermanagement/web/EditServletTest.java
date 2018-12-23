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
}