package ua.nure.kn.dziuba.usermanagement.web;

import junit.framework.TestCase;
import ua.nure.kn.dziuba.usermanagement.User;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class BrowseServletTest extends MockServletTestCase {

    public void setUp() throws Exception {
        super.setUp();
        createServlet(BrowseServlet.class);
    }

    public void tearDown() throws Exception {
    }

    public void testBrowse(){
        User user = new User();
        user.setId((long) 1000);
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setDateOfBirth(new Date());

        List list = Collections.singletonList(user);

        getMockUserDao().expectAndReturn("findAll", list);
        doGet();
        Collection collection = (Collection)getWebMockObjectFactory().getMockSession().getAttribute("users");
        assertNotNull("User's collection wasn't found", collection);
        assertSame(list, collection);
    }
}