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
    public void commandHelper(StringTokenizer st, Album album, Collection collection){

    }
    public void run(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Collection Manager starts running.");
        String input = reader.nextLine();
        StringTokenizer st = new StringTokenizer(input, ",");
        Collection collection = new Collection();
        Album album = new Album(st.nextToken(), st.nextToken());
        String command = st.nextToken();
        //when taking in inputs, make sure there is an appropriate amount of tokens for the command
        while(!command.equals("Q")) {

            if (command.equals("A")){
                album.populate(st.nextToken(), st.nextToken());
                collection.add(album);
            }
            else if (command.equals("D")) {
                collection.remove(album);
            }
            else if (command.equals("L")) {
                collection.lendingOut(album);
            }
            else if (command.equals("R")) {
                collection.returnAlbum(album);
            }
            else if (command.equals("P")) {
                collection.print();
            }
            else if (command.equals("PD")){
                collection.printByReleaseDate();
            }
            else if (command.equals("PG")){
                collection.printByGenre();
            }
            else {
                System.out.println("Invalid command!");
            }
            input =reader.nextLine();
            st =new StringTokenizer(input, ",");
            command = st.nextToken();
        }
        System.out.println("Collection Manager terminated.");
    }
}