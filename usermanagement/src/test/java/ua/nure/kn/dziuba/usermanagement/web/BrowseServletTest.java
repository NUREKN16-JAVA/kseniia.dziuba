package ua.nure.kn.dziuba.usermanagement.web;

import junit.framework.TestCase;
import ua.nure.kn.dziuba.usermanagement.User;
import ua.nure.kn.dziuba.usermanagement.db.DatabaseException;

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

    public void testDetails() {
        User expectedUser = createUserForTest();
        getMockUserDao().expectAndReturn("find", new Long(1000), expectedUser);
        addRequestParameter("detailsButton", "Details");
        addRequestParameter("id", "1000");
        doPost();
        User actualUser = (User) getWebMockObjectFactory().getMockSession().getAttribute("user");
        assertNotNull("Could not find user in session", actualUser);
        assertEquals(expectedUser, actualUser);
    }

    public void testDelete() {
        User expectedUser = createUserForTest();
        getMockUserDao().expectAndReturn("find", new Long(1000), expectedUser);
        getMockUserDao().expect("delete", expectedUser);
        addRequestParameter("deleteButton", "Delete");
        addRequestParameter("id", "1000");
        doPost();
    }

    public void testDeleteWithInvalidId() {
        String expectedErrorMessage = "Incorrect id";
        getMockUserDao().expectAndThrow("find", new Long(1000), new DatabaseException(expectedErrorMessage));
        addRequestParameter("deleteButton", "Delete");
        addRequestParameter("id", "1000");
        doPost();
        String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
        assertNotNull("Could not find error message", errorMessage);
        assertTrue(errorMessage.contains(errorMessage));
    }
}