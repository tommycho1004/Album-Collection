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
    public Date() {

    } //create an object with today’s date (see Calendar class)


    public Date(Date date) {

    }
    public boolean isValid() {

    }

    @Override
    public int compareTo(Date date) {

    }

    /**Testbed main for the Date class*/
    public static void main(String[]args) {

    }
}
