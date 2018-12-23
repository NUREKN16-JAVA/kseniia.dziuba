package ua.nure.kn.dziuba.usermanagement.web;

import ua.nure.kn.dziuba.usermanagement.User;
import ua.nure.kn.dziuba.usermanagement.db.DaoFactory;
import ua.nure.kn.dziuba.usermanagement.db.DatabaseException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class EditServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("okButton") != null) {
            doOk(req, resp);
        } else if (req.getParameter("cancelButton") != null) {
            doCancel(req, resp);
        } else {
            showPage();
        }
    }

    private void doOk(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = getUser(req);
        try {
            DaoFactory.getInstance().getUserDao().update(user);
        } catch (DatabaseException e) {
            try {
                throw new ServletException(e);
            } catch (ServletException e1) {
                e1.printStackTrace();
            }
        }
        req.getRequestDispatcher("browse.jsp").forward(req, resp);
    }

    private void doCancel(HttpServletRequest req, HttpServletResponse resp) {

    }

    private void showPage() {

    }

    private User getUser(HttpServletRequest req) {
        User user = new User();
        String id = req.getParameter("id");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String dateOfBirth = req.getParameter("dateOfBirth");

        if(id!=null){
            user.setId(new Long(id));
        }
        user.setFirstName(firstName);
        user.setLastName(lastName);
        try {
            user.setDateOfBirth(DateFormat.getDateInstance().parse(dateOfBirth));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return user;
    }
}
