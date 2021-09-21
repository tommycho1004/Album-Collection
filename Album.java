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
    enum Genre{
        Classical, Country, Jazz, Pop, Unknown;
    }
    private Date releaseDate;
    private boolean isAvailable;

    public void setNotAvailable(){
        this.isAvailable = false;
    }
    public void setAvailable(){
        this.isAvailable = true;
    }

    Album(String title, String artist)
    {
        this.title = title;
        this.artist = artist;
    }

    @Override
    public boolean equals(Object obj) { }

    @Override
    public String toString() { }

    public void populate(String genre, String date) {

    }
}