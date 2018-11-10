package ua.nure.kn.dziuba.usermanagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.time.temporal.ChronoUnit.DAYS;

public class User implements java.io.Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;

    private final int ID = 1;
    private final String FIRST_NAME = "Kseniia";
    private final String LAST_NAME = "Dziuba";
    private final Date DATE_OF_BIRTH = new SimpleDateFormat("d-MMM-yyyy").parse("11-Aug-1999");


    public User() throws ParseException {
        setId((long) ID);
        setFirstName(FIRST_NAME);
        setLastName(LAST_NAME);
        setDateOfBirth(DATE_OF_BIRTH);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFullName() {
        StringBuilder fullNameString = new StringBuilder();
        fullNameString.append(getLastName()).append(", ").append(getFirstName());
        return fullNameString.toString();
    }

    public long getAge() throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int currentYear = calendar.get(Calendar.YEAR);
        User user = new User();
        calendar.setTime(user.getDateOfBirth());
        int userYearOfBirth = calendar.get(Calendar.YEAR);
        return currentYear - userYearOfBirth;
    }

    public long getAge(int userYearOfBirth) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int currentYear = calendar.get(Calendar.YEAR);
        return currentYear - userYearOfBirth;
    }

    public long getAge(int userYearOfBirth, String userMonthOfBirth) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH);
        Date monthDate = new SimpleDateFormat("MMM", Locale.ENGLISH).parse(userMonthOfBirth);
        calendar.setTime(monthDate);
        int month = calendar.get(Calendar.MONTH);
        return ((currentYear * 12) + currentMonth) - ((userYearOfBirth * 12) + month);
    }

    public long getAge(int userYearOfBirth, int userMonthOfBirth) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH);
        return ((currentYear * 12) + currentMonth) - ((userYearOfBirth * 12) + userMonthOfBirth);
    }

    public long getAge(int userYearOfBirth, int userMonthOfBirth, int userDayOfBirth) {
        LocalDate dateOfBirth = LocalDate.of(userYearOfBirth, userMonthOfBirth, userDayOfBirth);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        LocalDate curDate = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        long daysBetween = DAYS.between(dateOfBirth, curDate);

        return daysBetween;
    }
}
