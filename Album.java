/**
 * The album class that stores the attributes of each album.
 * Use this class to populate a new album with attributes.
 * @author Tommy Cho, Neha Gudur
 */

public class Album {
    private String title;
    public void setTitle(String title){
        this.title = title;
    }
    private String artist;
    private Genre genre; //enum class; Classical, Country, Jazz, Pop, Unknown
    private Date releaseDate;
    private boolean isAvailable;
    
    public Date getReleaseDate(){
        return releaseDate;
    }

    /**
     * A setter for the availability of an album.
     */
    public void setAvailability(boolean s)
    {
        this.isAvailable = s;
    }
    public boolean getAvailability(){
        return isAvailable;
    }

    Album(String title, String artist)
    {
        this.title = title;
        this.artist = artist;
    }

    /**
     * Compares two albums and determines if they are the same.
     * Override method from java.util.
     * @param obj
     * @return true if the two objects are equal
     */
    @Override
    public boolean equals(Object obj) { 
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof Album) {
            Album newAlb = (Album) obj;
            return newAlb.title.equals(title) && newAlb.artist.equals(artist);
        }
        return false;
    }

    /**
     * Converts the album and its attributes to a string form for readability by the user.
     * @return the album details in the form of a string
     */
    @Override
    public String toString() { }

    /**
     * Populates the album with genre and date attributes.
     * @param genre
     * @param date
     */
    public void populate(String genre, String date) {

    }
}
