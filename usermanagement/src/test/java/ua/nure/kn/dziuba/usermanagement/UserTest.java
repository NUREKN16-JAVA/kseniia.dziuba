package ua.nure.kn.dziuba.usermanagement;

import junit.framework.TestCase;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;

public class UserTest extends TestCase {

    private User user;

    public void setUp() throws Exception {
        user = new User();
        super.setUp();
    }

    public void testGetFullName(){
        assertEquals("Dziuba, Kseniia", user.getFullName());
    }

    public void testGetAgeYearsWithoutParameters() throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(user.getDateOfBirth());

        assertEquals(2018 - 1999, user.getAge());
    }

    public void testGetAgeYears(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(user.getDateOfBirth());

        assertEquals(2018 - 1999, user.getAge(calendar.get(Calendar.YEAR)));
    }

    public void testGetAgeYearsMonthsString() throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(user.getDateOfBirth());

        assertEquals(((2018 * 12) + 10) - ((1999 * 12) + 8), user.getAge(calendar.get(Calendar.YEAR), "Aug"));
    }

    public void testGetAgeYearsMonths(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(user.getDateOfBirth());

        assertEquals(((2018 * 12) + 10) - ((1999 * 12) + 8), user.getAge(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)));
    }

    public void testGetAgeYearsMonthsDays() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        LocalDate curDate = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        calendar.setTime(user.getDateOfBirth());
        LocalDate BirthDate = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

        assertEquals(DAYS.between(BirthDate, curDate), user.getAge(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)));
    }
}