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
                collection.add(album);
            }
        }
        else if (command.equals("D")) {
            if (st.countTokens() != 2) {
                System.out.println("Invalid number of parameters!");
            }
            else{
                collection.remove(album);
            }
        }
        else if (command.equals("L")) {
            if (st.countTokens() != 2) {
                System.out.println("Invalid number of parameters!");
            }
            else {
                collection.lendingOut(album);
            }
        }
        else if (command.equals("R")) {
            if (st.countTokens() != 2) {
                System.out.println("Invalid number of parameters!");
            }
            else{
                collection.returnAlbum(album);
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
                input = reader.nextLine();
                st = new StringTokenizer(input, ",");
                command = st.nextToken();
            }
            else{
                album = new Album(st.nextToken(), st.nextToken());
                cmHelper(st, album, collection, command);
                input = reader.nextLine();
                st = new StringTokenizer(input, ",");
                command = st.nextToken();
            }
        }
        System.out.println("Collection Manager terminated.");
    }
}
