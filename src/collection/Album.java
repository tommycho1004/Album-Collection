package collection;

/**
 * The album class that stores the attributes of each album.
 * Use this class to populate a new album with attributes.
 *
 * @author Tommy Cho
 */
public class Album {
    private String title;
    private String artist;
    private Genre genre; //enum class; Classical, Country, Jazz, Pop, Unknown
    private Date releaseDate;
    private boolean isAvailable = true;

    /**
     * getter for album genre
     *
     * @return album genre in form of Genre
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * getter for album release date
     *
     * @return album release date in form of Date
     */
    public Date getReleaseDate() {
        return releaseDate;
    }

    /**
     * A setter for the availability of an album.
     *
     * @param s {boolean} availability of an album that you want to set it to
     */
    public void setAvailability(boolean s) {
        this.isAvailable = s;
    }

    /**
     * a getter for the availability of an album
     *
     * @return true if album is available, false otherwise
     */
    public boolean getAvailability() {
        return isAvailable;
    }

    //parameterized constructor
    Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    /**
     * Compares two albums and determines if they are the same.
     * Override method from java.util.
     *
     * @param obj object that is being compared
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
     *
     * @return the album details in the form of a string
     */
    @Override
    public String toString() {
        String availability;
        if (this.isAvailable) {
            availability = "is available";
        } else {
            availability = "is not available";
        }
        return this.title + "::" + this.artist + "::" + this.genre.genreString() + "::" + this.releaseDate.dateString() + "::" + availability;
    }

    /**
     * Converts the first two attributes of the album: title and artist, to a string.
     * This is for the lending and returning tools in collection manager.
     *
     * @return the first two attributes of the album in the form of a string.
     */
    public String toStringFirstTwo() { //needs testing
        return this.title + "::" + this.artist;
    }

    /**
     * Populates the album with genre and date attributes.
     *
     * @param genre genre of the album
     * @param date  release date of the album
     */
    public void populate(String genre, String date) {
        switch (genre) {
            case "pop", "Pop" -> this.genre = Genre.Pop;
            case "country", "Country" -> this.genre = Genre.Country;
            case "classical", "Classical" -> this.genre = Genre.Classical;
            case "jazz", "Jazz" -> this.genre = Genre.Jazz;
            default -> this.genre = Genre.Unknown;
        }
        this.releaseDate = new Date(date);
    }
}
