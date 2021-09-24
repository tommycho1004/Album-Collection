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
    public String toString() {
        return this.title + "::" + this.artist + "::" + this.genre.genreString(); //add date to this!
    }
    /**
     * Converts the first two attributes of the album: title and artist, to a string.
     * This is for the lending and returning tools in collection manager.
     * @return the first two attributes of the album in the form of a string.
     */
    public String toStringFirstTwo() { //needs testing
        return this.title + "::" + this.artist;
    }
    
    /**
     * Populates the album with genre and date attributes.
     * @param genre
     * @param date
     */
    public void populate(String genre, String date) {
        if (genre.equals("Pop")){
            this.genre = Genre.Pop;
        }
        else if (genre.equals("Country")){
            this.genre = Genre.Country;
        }
        else if (genre.equals("Classical")){
            this.genre = Genre.Classical;
        }
        else if (genre.equals("Jazz")){
            this.genre = Genre.Jazz;
        }
        else {
            this.genre = Genre.Unknown;
        }
    }
}
