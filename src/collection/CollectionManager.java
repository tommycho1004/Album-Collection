package collection;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * The UI class of this program.
 * The user may input several, single letter commands to modify their collection.
 *
 * @author Tommy Cho
 */
public class CollectionManager {
    /**
     * A helper method that reads the input command and executes its respective function.
     * This method is for non-print functions of this program.
     *
     * @param st         StringTokenizer
     * @param collection Collection
     * @param command    String input command - "A" adds an album, "D" deletes an album, "L" lends out album,
     *                   "R" returns album
     */
    public void cmHelper(StringTokenizer st, Collection collection, String command) {
        switch (command) {
            case "A":
                if (st.countTokens() != 4) {
                    System.out.println("Invalid number of parameters!");
                } else {
                    Album album = new Album(st.nextToken(), st.nextToken());
                    album.populate(st.nextToken(), st.nextToken());
                    if (!album.getReleaseDate().isValid()) {
                        System.out.println("Invalid Date!");
                    } else if (!collection.add(album)) {
                        System.out.println(album.toString() + " >> is already in the collection.");
                    } else {
                        collection.add(album); //check if the above if condition adds the album if the boolean is true
                        System.out.println(album.toString() + " >> added.");
                    }
                }
                break;
            case "D":
                if (st.countTokens() != 2) {
                    System.out.println("Invalid number of parameters!");
                } else {
                    Album album = new Album(st.nextToken(), st.nextToken());
                    if (collection.getNumAlbums() == 0) {
                        System.out.println("The list is empty!");
                    } else if (!collection.remove(album)) {
                        System.out.println(album.toStringFirstTwo() + " >> is not in the collection.");
                    } else {
                        collection.remove(album);
                        System.out.println(album.toStringFirstTwo() + " >> deleted.");
                    }
                }
                break;
            case "L": {
                Album album = new Album(st.nextToken(), st.nextToken());
                if (st.countTokens() != 0) {
                    System.out.println("Invalid number of parameters!");
                } else if (!collection.lendingOut(album)) {
                    System.out.println(album.toStringFirstTwo() + " >> is not available.");
                } else {
                    System.out.println(album.toStringFirstTwo() + " >> lending out and set to not available.");
                }
                break;
            }
            case "R": {
                Album album = new Album(st.nextToken(), st.nextToken());
                if (st.countTokens() != 0) {
                    System.out.println("Invalid number of parameters!");
                } else if (!collection.returnAlbum(album)) {
                    System.out.println(album.toStringFirstTwo() + " >> return cannot be completed.");
                } else {
                    System.out.println(album.toStringFirstTwo() + " >> returning and set to available.");
                }
                break;
            }
            default:
                System.out.println("Invalid command!");
                break;
        }
    }

    /**
     * A helper method that reads the input command and executes its respective print function.
     *
     * @param st         StringTokenizer
     * @param collection Collection
     * @param command    input command
     */
    public void printHelper(StringTokenizer st, Collection collection, String command) {
        switch (command) {
            case "P":
                if (st.countTokens() != 0) {
                    System.out.println("Invalid number of parameters!");
                } else {
                    collection.print();
                }
                break;
            case "PD":
                if (st.countTokens() != 0) {
                    System.out.println("Invalid number of parameters!");
                } else {
                    collection.printByReleaseDate();
                }
                break;
            case "PG":
                if (st.countTokens() != 0) {
                    System.out.println("Invalid number of parameters!");
                } else {
                    collection.printByGenre();
                }
                break;
        }
    }

    /**
     * Runs a while loop to continuously read inputs from the user until the quit command is entered.
     */
    public void run() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Collection Manager starts running.");
        String input = reader.nextLine();
        StringTokenizer st = new StringTokenizer(input, ",");
        Collection collection = new Collection();
        String command = st.nextToken();
        while (!command.equals("Q")) {
            if (command.equals("P") || command.equals("PG") || command.equals("PD")) {
                printHelper(st, collection, command);
            } else if (command.equals("A") || command.equals("D") || command.equals("L") || command.equals("R")) {
                cmHelper(st, collection, command);
            } else {
                System.out.println("Invalid command!");
            }
            input = reader.nextLine();
            st = new StringTokenizer(input, ",");
            command = st.nextToken();
        }
        System.out.println("Collection Manager terminated.");
    }
}
