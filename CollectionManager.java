/**
 * The UI class of this program.
 * The user may input several, single letter commands to modify their collection.
 * @author Tommy Cho, Neha Gudur
 */

import java.util.Scanner;
import java.util.StringTokenizer;

public class CollectionManager {
    /**
     *Runs the Collection Manager and reads inputs from the user.
     * A - add an album
     * D - remove an album
     * L - lend out an album
     * R - return the album
     * P - display list without order
     * PD - display list in order of release date
     * PG - display list in order of genres
     * Q - terminate Collection Manager
     */
    public void cmHelper(StringTokenizer st, Album album, Collection collection, String command){
        if (command.equals("A")){
            if (st.countTokens() != 4)
            {
                System.out.println("Invalid number of parameters!");
            }
            else{
                album.populate(st.nextToken(), st.nextToken());
                collection.add(album);
            }
        }
        else if (command.equals("D")) {
            if (st.countTokens() != 2)
            {
                System.out.println("Invalid number of parameters!");
            }
            else{
                collection.remove(album);
            }
        }
        else if (command.equals("L")) {
            if (st.countTokens() != 2)
            {
                System.out.println("Invalid number of parameters!");
            }
            else
            {
                collection.lendingOut(album);
            }
        }
        else if (command.equals("R")) {
            if (st.countTokens() != 2)
            {
                System.out.println("Invalid number of parameters!");
            }
            else{
                collection.returnAlbum(album);
            }
        }
        else if (command.equals("P")) {
            if (st.countTokens() != 0)
            {
                System.out.println("Invalid number of parameters!");
            }
            else{
                collection.print();
            }
        }
        else if (command.equals("PD")){
            if (st.countTokens() != 0)
            {
                System.out.println("Invalid number of parameters!");
            }
            else{
                collection.printByReleaseDate();
            }
        }
        else if (command.equals("PG")){
            if (st.countTokens() != 0)
            {
                System.out.println("Invalid number of parameters!");
            }
            else{
                collection.printByGenre();
            }

        }
        else {
            System.out.println("Invalid command!");
        }
    }
    public void run(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Collection Manager starts running.");
        String input = reader.nextLine();
        StringTokenizer st = new StringTokenizer(input, ",");
        Collection collection = new Collection();
        Album album = new Album(st.nextToken(), st.nextToken());
        String command = st.nextToken();
        while(!command.equals("Q")) {
            cmHelper(st, album, collection, command);
            input =reader.nextLine();
            st =new StringTokenizer(input, ",");
            command = st.nextToken();
            album = new Album(st.nextToken(), st.nextToken());
        }
        System.out.println("Collection Manager terminated.");
    }
}
