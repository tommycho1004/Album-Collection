import java.util.Calendar;
import java.util.StringTokenizer;

/**
 * The date class that's used for setting the release date of each album.
 * Use this class to check if a date is valid or not.
 * @author Tommy Cho, Neha Gudur
 */

public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;

    /**
     * A method that converts a date object to a string.
     * @return the date in string form
     */
    public String dateString(){
        return month + "/" + day + "/" +year;
    }

    /** Parameterized constructor that takes the input string "mm/dd/yyyy" and converts it into the date type
     * @param date a string date in the form of mm/dd/yyyy
     * */
    public Date(String date) {
        StringTokenizer st = new StringTokenizer(date, "/");
        month = Integer.parseInt(st.nextToken());
        day = Integer.parseInt(st.nextToken());
        year = Integer.parseInt(st.nextToken());
    } //take “mm/dd/yyyy” and create a Date object


    /** Returns today's date */
    Calendar today = Calendar.getInstance();
    public Date() {
        this.year = today.get(Calendar.YEAR);
        this.month = today.get(Calendar.MONTH);
        this.day = today.get(Calendar.DATE);
    } //create an object with today’s date (see Calendar class)

    /** static integers*/
    public static final int QUAD = 4;
    public static final int CENT = 100;
    public static final int QUADCENT = 400;
    public static final int febNoLeap = 28;
    public static final int febLeap = 29;
    public static final int longMonth = 31;
    public static final int shortMonth = 30;
    public static final int eighties = 1980;

    public static final int jan = 0;
    public static final int feb = 1;
    public static final int march = 2;
    public static final int april = 3;
    public static final int may = 4;
    public static final int june = 5;
    public static final int july = 6;
    public static final int aug = 7;
    public static final int sept = 8;
    public static final int oct = 9;
    public static final int nov = 10;
    public static final int dec = 11;

    /**
     * A helper method that determines how many days february has.
     * @param year
     * @return integer of days in february
     */
    private int febDays(int year) {
        if (year % QUAD == 0) {
            if (year % CENT == 0) {
                if (year % QUADCENT == 0) {
                    return febLeap;
                } else return febNoLeap;
            } else return febLeap;
        } else return febNoLeap;
    }

    /**
     * A helper method that outputs how many days in a specific month there is.
     * @param month
     * @param year
     * @return integer days in the month we're looking for
     */
    private int daysInMonth(int month, int year) { //month-1
        month = month - 1;
        if (month == feb) {
            return febDays(year);
        } else if (month == jan || month == march || month == may || month == july || month == aug || month == oct || month == dec) {
            return longMonth;
        } else {
            return shortMonth;
        }
    }

    /**
     * A method that determines if a date is valid or not
     * @return true if the date is valid, false if otherwise
     */
    public boolean isValid() {
        if (this.year < eighties || this.year > today.get(Calendar.YEAR)) {
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
                if (this.day > today.get(Calendar.DATE)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * A method that compares a date with another one and returns
     * @param date
     * @return
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



    /**Testbed main for the Date class*/
    public static void main(String[]args) {
        Date date = new Date("11/19/1979");
        boolean expectedResult = false;
        boolean result = date.isValid();
        System.out.print("Test case #1:");
        if (result == expectedResult) {
            System.out.print("Pass.");
        } else {
            System.out.print("Fail.");
        }
    }
}
