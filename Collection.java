import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * The collection class used as the foundation of the program.
 * This class contains methods to perform several functions to the collection of albums.
 * @author Tommy Cho, Neha Gudur
 */

public class Collection {
    private Album[] albums;
    private int numAlbums; //number of albums currently in the collection
    private int find(Album album) {
    }//find the album index, or return NOT_FOUND
    private void grow() {
        Album newList[] = new Album[numAlbums+4];
        for (int i = 0; i < numAlbums; i++)
        {
            newList[i] = albums[i];
        }
        albums = newList;
    }//increase the capacity of the array list by 4
    public boolean add(Album album) {

    }
    public boolean remove(Album album) {

    }
    public boolean lendingOut(Album album) {
        album.setNotAvailable();
    } //set to not available
    public boolean returnAlbum(Album album) {

    } //set to available
    public void print() {

    } //display the list without specifying the order
    public void printByReleaseDate() {

    }
    public void printByGenre() {

    }


}





