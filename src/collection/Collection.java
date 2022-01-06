package collection;

/**
 * The collection class used as the foundation of the program.
 * This class contains methods to perform several functions to the collection of albums.
 *
 * @author Tommy Cho
 */
public class Collection {
    private Album[] albums = new Album[4];
    private int numAlbums; //number of albums currently in the collection

    /**
     * Gets the number of albums in the collection.
     *
     * @return integer value of the quantity of albums.
     */
    public int getNumAlbums() {
        return numAlbums;
    }

    /**
     * Finds the index of a certain album within the collection.
     * Return -1 if no match
     *
     * @param album album that the method is attempting to find the index for
     * @return the index of the target album.
     */
    private int find(Album album) {
        for (var i = 0; i < numAlbums; i++) {
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
        Album[] newList = new Album[numAlbums + 4];
        for (int i = 0; i < numAlbums; i++) {
            newList[i] = albums[i];
        }
        albums = newList; //maybe needs this.albums??
    }

    /**
     * Adds an album to the collection.
     *
     * @param album album that is being added
     * @return true if the album was successfully added and false otherwise.
     */
    public boolean add(Album album) {
        // add to numAlbums
        //check for date, if is valid
        if (album.getReleaseDate().isValid() && find(album) == -1) {
            numAlbums++; // add to numAlbums
            if (numAlbums % 4 == 0) {
                grow();
            }
            albums[numAlbums - 1] = album;
            return true;
        }
        return false;
    }

    /**
     * Removes an album from the collection.
     *
     * @param album album that is being removed
     * @return true if the album was successfully removed and false otherwise.
     */
    public boolean remove(Album album) {
        if (numAlbums == 0) {
            return false;
        }
        if (find(album) != -1) {
            for (var j = find(album); j < numAlbums; j++) {
                albums[j] = albums[j + 1];
                if (albums[j] == null) {
                    numAlbums--;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Sets the availability of an album to unavailable.
     *
     * @param album album whose availability is being set
     * @return true if the album was lent and false otherwise.
     */
    public boolean lendingOut(Album album) {
        if (find(album) != -1) {
            if (!albums[find(album)].getAvailability()) {
                return false;
            } else {
                albums[find(album)].setAvailability(false);
                return true;
            }
        } else {
            return false;
        }
    }

    /**
     * Sets the availability of an album to available.
     *
     * @param album album whose availability is being set
     * @return true if the album was returned and false otherwise.
     */
    public boolean returnAlbum(Album album) {
        if (find(album) != -1) {
            if (albums[find(album)].getAvailability()) {
                return false;
            } else {
                albums[find(album)].setAvailability(true);
                return true;
            }
        } else {
            return false;
        }
    } //set to available

    /**
     * Prints the collection of albums in no specific order.
     */
    public void print() {
        if (numAlbums == 0) {
            System.out.println("The collection is empty!");
        } else {
            System.out.println("*List of albums in the collection.");
            for (int i = 0; i < numAlbums; i++) {
                System.out.println(albums[i].toString());
            }
            System.out.println("*End of list");
        }
    } //display the list without specifying the order

    /**
     * Prints the collection of albums in order of release date.
     */
    public void printByReleaseDate() {
        if (numAlbums == 0) {
            System.out.println("The collection is empty!");
        } else {
            System.out.println("*Album collection by the release dates.");
            Album[] newArray = albums;
            for (int i = 0; i < numAlbums - 1; i++) {
                for (int j = 0; j < numAlbums - i - 1; j++) {
                    if (albums[j].getReleaseDate().compareTo(albums[j + 1].getReleaseDate()) > 0) {//j happened before i
                        Album temp = albums[j];
                        albums[j] = albums[j + 1];
                        albums[j + 1] = temp;
                    }
                }
            }
            for (int i = 0; i < numAlbums; i++) {
                System.out.println(albums[i].toString());
            }
            System.out.println("*End of list");
        }
    }

    /**
     * Prints the collection of albums in order of genre.
     */
    public void printByGenre() {
        if (numAlbums == 0) {
            System.out.println("The collection is empty!");
        } else {
            System.out.println("*Album collection by genre.");
            for (int i = 0; i < numAlbums - 1; i++) {
                int min_idx = i;
                for (int j = i + 1; j < numAlbums; j++) {
                    if (albums[j].getGenre().compareTo(albums[min_idx].getGenre()) < 0) {
                        min_idx = j;
                    }
                }
                Album temp = albums[min_idx];
                albums[min_idx] = albums[i];
                albums[i] = temp;
            }
            for (int i = 0; i < numAlbums; i++) {
                System.out.println(albums[i].toString());
            }
            System.out.println("*End of list");
        }
    }

}
