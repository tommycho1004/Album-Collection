package collection;

import java.util.Calendar;
import java.util.StringTokenizer;

/**
 * The date class that's used for setting the release date of each album.
 * Use this class to check if a date is valid or not.
 *
 * @author Tommy Cho
 */
public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;

    /**
     * A method that converts a date object to a string.
     *
     * @return the date in string form
     */
    public String dateString() {
        return month + "/" + day + "/" + year;
    }

    /**
     * Parameterized constructor that takes the input string "mm/dd/yyyy" and converts it into the date type
     *
     * @param date a string date in the form of mm/dd/yyyy
     */
    public Date(String date) {
        StringTokenizer st = new StringTokenizer(date, "/");
        month = Integer.parseInt(st.nextToken());
        day = Integer.parseInt(st.nextToken());
        year = Integer.parseInt(st.nextToken());
    } //take “mm/dd/yyyy” and create a Date object


    /**
     * Returns today's date
     */
    Calendar today = Calendar.getInstance();

    public Date() {
        this.year = today.get(Calendar.YEAR);
        this.month = today.get(Calendar.MONTH);
        this.day = today.get(Calendar.DATE);
    } //create an object with today’s date (see Calendar class)

    /**
     * static integers
     */
    public static final int QUAD = 4;
    public static final int CENT = 100;
    public static final int QUADCENT = 400;
    public static final int NOLEAPFEB = 28;
    public static final int LEAPFEB = 29;
    public static final int LONG_MONTH = 31;
    public static final int SHORT_MONTH = 30;
    public static final int EIGHTIES = 1980;

    public static final int JAN = 0;
    public static final int FEB = 1;
    public static final int MAR = 2;
    public static final int APR = 3;
    public static final int MAY = 4;
    public static final int JUN = 5;
    public static final int JUL = 6;
    public static final int AUG = 7;
    public static final int SEP = 8;
    public static final int OCT = 9;
    public static final int NOV = 10;
    public static final int DEC = 11;

    /**
     * A helper method that determines how many days february has.
     *
     * @param year the year of the date
     * @return integer of days in february
     */
    private int febDays(int year) {
        if (year % QUAD == 0) {
            if (year % CENT == 0) {
                if (year % QUADCENT == 0) {
                    return LEAPFEB;
                } else return NOLEAPFEB;
            } else return LEAPFEB;
        } else return NOLEAPFEB;
    }

    /**
     * A helper method that outputs how many days in a specific month there is.
     *
     * @param month the month in date
     * @param year  the year in date
     * @return integer days in the month we're looking for
     */
    private int daysInMonth(int month, int year) { //month-1
        month = month - 1;
        if (month == FEB) {
            return febDays(year);
        } else if (month == JAN || month == MAR || month == MAY || month == JUL || month == AUG || month == OCT || month == DEC) {
            return LONG_MONTH;
        } else {
            return SHORT_MONTH;
        }
    }

    /**
     * A method that determines if a date is valid or not
     *
     * @return true if the date is valid, false if otherwise
     */
    public boolean isValid() {
        if (this.year < EIGHTIES || this.year > today.get(Calendar.YEAR)) {
            return false;
        }
        if (this.month - 1 > 11 || this.month - 1 < 0) {
            return false;
        }
        if (this.day > daysInMonth(this.month, this.year)) {
            return false;
        }
        if (this.year == today.get(Calendar.YEAR)) {
            if (this.month - 1 > today.get(Calendar.MONTH)) {
                return false;
            }
            if (this.month == today.get(Calendar.MONTH) + 1) {
                return this.day <= today.get(Calendar.DATE);
            }
        }
        return true;
    }

    /**
     * A method that compares a date with another one and returns a positive or negative number
     * depending on which date was earlier
     *
     * @param date that is being compared
     * @return positive int if the date of this is later than the param date that is being compared
     */
    @Override
    public int compareTo(Date date) {
        int diff = this.year - date.year;
        if (diff != 0) {
            return diff;
        }
        diff = this.month - date.month;
        if (diff != 0) {
            return diff;
        }
        return this.day - date.day;
    }


    /**
     * Testbed main for the Date class
     *
     * @param args test date class
     */
    public static void main(String[] args) {
        // test case #1: a date before the year 1980 should be invalid
        Date date = new Date("11/19/1979");
        boolean expectedResult = false;
        boolean result = date.isValid();
        System.out.print("Test case #1:");
        if (result == expectedResult) {
            System.out.print("Pass.");
        } else {
            System.out.print("Fail.");
        }

        //test case #2: a date with an invalid month
        date = new Date("13/19/1999");
        expectedResult = false;
        result = date.isValid();
        System.out.print("Test case #2:");
        if (result == expectedResult) {
            System.out.print("Pass.");
        } else {
            System.out.print("Fail.");
        }

        ////test case #3: a date with an invalid day, testing out leap year
        date = new Date("2/29/2009");
        expectedResult = false;
        result = date.isValid();
        System.out.print("Test case #3:");
        if (result == expectedResult) {
            System.out.print("Pass.");
        } else {
            System.out.print("Fail.");
        }

        ////test case #4: a date in feb with a valid day, testing out leap year
        date = new Date("2/29/2008");
        expectedResult = true;
        result = date.isValid();
        System.out.print("Test case #4:");
        if (result == expectedResult) {
            System.out.print("Pass.");
        } else {
            System.out.print("Fail.");
        }

        ////test case #5: The method shall not accept any date after the present date.
        date = new Date("3/12/2022");
        expectedResult = false;
        result = date.isValid();
        System.out.print("Test case #5:");
        if (result == expectedResult) {
            System.out.print("Pass.");
        } else {
            System.out.print("Fail.");
        }

        ////test case #6: Valid range for days in April, June, Sept, Nov is 1- 30
        date = new Date("4/12/2009");
        expectedResult = true;
        result = date.isValid();
        System.out.print("Test case #6:");
        if (result == expectedResult) {
            System.out.print("Pass.");
        } else {
            System.out.print("Fail.");
        }

        ////test case #7: Valid range for days in Jan, Mar,May, July, Aug, Oct, Dec is 1- 31
        date = new Date("1/33/2009");
        expectedResult = false;
        result = date.isValid();
        System.out.print("Test case #7:");
        if (result == expectedResult) {
            System.out.print("Pass.");
        } else {
            System.out.print("Fail.");
        }

        ////test case #8: Valid range for days in April, June, Sept, Nov is 1- 30
        date = new Date("11/31/2009");
        expectedResult = false;
        result = date.isValid();
        System.out.print("Test case #8:");
        if (result == expectedResult) {
            System.out.print("Pass.");
        } else {
            System.out.print("Fail.");
        }

        ////test case #9: Valid range for days in Jan, Mar,May, July, Aug, Oct, Dec is 1- 31
        date = new Date("12/15/2012");
        expectedResult = true;
        result = date.isValid();
        System.out.print("Test case #9:");
        if (result == expectedResult) {
            System.out.print("Pass.");
        } else {
            System.out.print("Fail.");
        }
    }
}
