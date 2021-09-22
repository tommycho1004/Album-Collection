/**
 * The UI class of this program.
 * The user may input several, single letter commands to modify their collection.
 * @author Tommy Cho, Neha Gudur
 */

import java.util.Scanner;
import java.util.StringTokenizer;

public class CollectionManager {
    /**
     * A helper method that reads the input command and executes its respective function.
     * This method is for non-print functions of this program.
     * @param st
     * @param album
     * @param collection
     * @param command
     */
    public void cmHelper(StringTokenizer st, Album album, Collection collection, String command){
        if (command.equals("A")){
            if (st.countTokens() != 4) {
                System.out.println("Invalid number of parameters!");
            }
            else{
                album.populate(st.nextToken(), st.nextToken());
                if (!album.getReleaseDate().isValid()){
                    System.out.println("Invalid Date!");
                }
                else if (collection.add(album) == false){
                    System.out.println(album.toString() + " is already in the collection.");
                }
                else {
                    collection.add(album); //check if the above if condition adds the album if the boolean is true
                    System.out.println(album.toString() + " added.");
                }
            }
        }
        else if (command.equals("D")) {
            if (st.countTokens() != 2) {
                System.out.println("Invalid number of parameters!");
            } else{
                if (collection.getNumAlbums() == 0){
                    System.out.println("The list is empty!");
                }
                else if (collection.remove(album) == false){
                    System.out.println(album.toString() + "is not in the collection.");
                }
                else{
                    collection.remove(album);
                    System.out.println(album.toString()+" deleted.");
                }
            }
        }
        else if (command.equals("L")) {
            if (st.countTokens() != 2) {
                System.out.println("Invalid number of parameters!");
            }
            else if(collection.isFound(album)){
                System.out.println(album.toString() + " is not in the collection.");
            }
            else if(collection.lendingOut(album) == false){
                System.out.println(album.toString() + " is not available.");
            }
            else {
                collection.lendingOut(album);
                System.out.println(album.toString() + " lending out and set to unavailable.");
            }
        }
        else if (command.equals("R")) {
            if (st.countTokens() != 2) {
                System.out.println("Invalid number of parameters!");
            }
            else if(collection.isFound(album) == false){
                System.out.println(album.toString() + " is not in the collection.");
            }
            else if(collection.returnAlbum(album) == false)
            {
                System.out.println(album.toString() + "return cannot be completed.");
            }
            else{
                collection.returnAlbum(album);
                System.out.println("returning and set to available");
            }
        }
        else {
            System.out.println("Invalid command!");
        }
    }

    /**
     * A helper method that reads the input command and executes its respective print function.
     * @param st
     * @param collection
     * @param command
     */
    public void printHelper(StringTokenizer st, Collection collection, String command){
        if (command.equals("P")) {
            if (st.countTokens() != 0) {
                System.out.println("Invalid number of parameters!");
            }
            else{
                collection.print();
            }
        }
        else if (command.equals("PD")){
            if (st.countTokens() != 0) {
                System.out.println("Invalid number of parameters!");
            }
            else{
                collection.printByReleaseDate();
            }
        }
        else if (command.equals("PG")){
            if (st.countTokens() != 0) {
                System.out.println("Invalid number of parameters!");
            }
            else{
                collection.printByGenre();
            }
        }
    }

    /**
     * Runs a while loop to continuously read inputs from the user until the quit command is entered.
     */
    public void run(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Collection Manager starts running.");
        String input = reader.nextLine();
        StringTokenizer st = new StringTokenizer(input, ",");
        Album album;
        Collection collection = new Collection();
        String command = st.nextToken();
        while(!command.equals("Q")) {
            if (command.equals("P") || command.equals("PG") || command.equals("PD)")){
                printHelper(st, collection, command);
            }
            else{
                album = new Album(st.nextToken(), st.nextToken());
                cmHelper(st, album, collection, command);
            }
            input = reader.nextLine();
            st = new StringTokenizer(input, ",");
            command = st.nextToken();
        }
        System.out.println("Collection Manager terminated.");
    }
}
