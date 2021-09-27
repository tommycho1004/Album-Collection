import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * The collection class used as the foundation of the program.
 * This class contains methods to perform several functions to the collection of albums.
 * @author Tommy Cho, Neha Gudur
 */

public class Collection {
    private Album[] albums = new Album[4];
    private int numAlbums; //number of albums currently in the collection
    
    /**
     * Gets the number of albums in the collection.
     * @return integer value of the quantity of albums.
     */
    public int getNumAlbums()
    {
        return numAlbums;
    }
    
    /**
     * Finds the index of a certain album within the collection.
     * @param album
     * @return the index of the target album.
     */
    private int find(Album album) { //find the album index, or return -1 if no match
        for (var i = 0; i < albums.length; i++) {
            if (albums[i].equals(album)) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Increases the size of the album list by 4.
     * Use whenever the album list fills up to max capacity so we never have a completely full list.
     */
    private void grow() {
        Album newList[] = new Album[numAlbums + 4];
        for (int i = 0; i < numAlbums; i++)
        {
            newList[i] = albums[i];
        }
        albums = newList; //maybe needs this.albums??
    }
    
    /**
     * Adds an album to the collection.
     * @param album
     * @return true if the album was successfully added and false otherwise.
     */
    public boolean add(Album album) {
        if (album.getDate.isValid == true && find(album) == -1) {
            numAlbums++; // add to numAlbums
            if (numAlbums % 4 == 0) {
                grow();
            }
            albums[numAlbums-1]=album;
            return true;
        }
        return false;
    }
    
    /**
     * Removes an album from the collection.
     * @param album
     * @return true if the album was successfully removed and false otherwise.
     */
    public boolean remove(Album album) {
        if (numAlbums == 0) {
            return false;
        }
        if (find(album) != -1) {
            for (var j = find(album); j < albums.length; j++) {
                albums[j] = albums[j + 1];
                if (albums[j] == null) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Sets the availability of an album to unavailable.
     * @param album
     * @return true if the album was lent and false otherwise.
     */
    public boolean lendingOut(Album album) {
        if (find(album) != -1) {
            if(album.getAvailability() == false){
                return false;
            }
            else{
                album.setAvailability(false);
                return true;
            }
        }
        else{
            return false;
        }

    } //set to not available
    
    /**
     * Sets the availability of an album to available.
     * @param album
     * @return true if the album was returned and false otherwise.
     */
    public boolean returnAlbum(Album album) {
        if (find(album) != -1) {
            if(album.getAvailability() == true){
                return false;
            }
            else{
                album.setAvailability(true);
                return true;
            }
        }
        else{
            return false;
        }

    } //set to available
    
    /**
     * Prints the collection of albums in no specific order.
     */
    public void print() {
        if (numAlbums == 0) {
            System.out.print("The Collection is Empty!");
        }
        else{
            System.out.println("*List of albums in the collection");
            for (int i = 0; i < albums.length; i++){
                System.out.println(albums[i].toString());
            }
            System.out.println("*End of List");
        }
    } //display the list without specifying the order
    
    /**
     * Prints the collection of albums in order of release date.
     */
    public void printByReleaseDate() {
        if (numAlbums == 0) {
            System.out.print("The Collection is Empty!");
        } else {
            System.out.println("*Album collection by the release dates.");
            Album[] newArray = albums;
            for (int i = 0; i < albums.length - 1; i++) {
                for (int j = 0; j < albums.length - i - 1; j++) {
                    if (albums[j].getReleaseDate().compareTo(albums[j + 1].getReleaseDate()) > 0) {//j happened before i
                        Album temp = albums[j];
                        albums[j] = albums[j + 1];
                        albums[j + 1] = temp;
                    }
                }
            }
            for (int i = 0; i < albums.length; i++) {
                System.out.println(albums[i].toString());
            }
            System.out.println("*End of List");
        }
    }
    
    /**
     * Prints the collection of albums in order of genre.
     */
    public void printByGenre() {
        if (numAlbums == 0) {
            System.out.print("The Collection is Empty!");
        }
        else{
            System.out.println("*Album collection by genre");
            for (int i = 0; i < numAlbums - 1; i++){
                int min_idx = i;
                for (int j = i + 1; j < numAlbums; j++){
                    if (albums[j].getGenre().compareTo(albums[min_idx].getGenre()) < 0){
                        min_idx = j;
                    }
                }
                Album temp = albums[min_idx];
                albums[min_idx] = albums [i];
                albums[i] = temp;
            }
            for (int i = 0; i < albums.length; i++){
                System.out.println(albums[i].toString());
            }
            System.out.println("*End of List");
        }
    }
    
    /**
     * helper method that determines if an album is in the collection or not
     * @param album
     * @return true if album is found and false if it is not in the collection
     */
    public boolean isFound(Album album){
        for (var i = 0; i < albums.length; i++) {
            if (albums[i].equals(album)) {
                return true;
            }
        }
        return false;
    }
}





