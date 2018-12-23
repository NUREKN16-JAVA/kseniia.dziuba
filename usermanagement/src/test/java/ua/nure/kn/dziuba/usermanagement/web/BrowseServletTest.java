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

    public void testBrowse() {
        createUserForTest();
        User user = createUserForTest();

        List list = Collections.singletonList(user);

        getMockUserDao().expectAndReturn("findAll", list);
        doGet();
        Collection collection = (Collection) getWebMockObjectFactory().getMockSession().getAttribute("users");
        assertNotNull("User's collection wasn't found", collection);
        assertSame(list, collection);
    }

    public void testEdit() {
        User user = createUserForTest();

        getMockUserDao().expectAndReturn("find", new Long(1000), user);
        addRequestParameter("editButton", "Edit");
        addRequestParameter("id", "1000");
        doPost();
        User sessionUser = (User) getWebMockObjectFactory().getMockSession().getAttribute("user");
        assertNotNull("Couldn't find user", sessionUser);
        assertSame("Wrong user was found", user, sessionUser);
    }
}