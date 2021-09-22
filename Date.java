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


    public Date(Date date) {

    }
    
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

    private int febDays(int year) {
        if (year % QUAD == 0) {
            if (year % CENT == 0) {
                if (year % QUADCENT == 0) {
                    return febLeap;
                } else return febNoLeap;
            } else return febLeap;
        } else return febNoLeap;
    }

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
    
    public boolean isValid() {
        if (this.day > daysInMonth(this.month, this.year)) {
            return false;
        }
        if (this.month - 1 >)
            if (this.year < eighties || this.year > today.get(Calendar.YEAR)) {
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

    @Override
    public int compareTo(Date date) {

    }

    /**Testbed main for the Date class*/
    public static void main(String[]args) {

    }
}
