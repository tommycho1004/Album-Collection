/**This enum class defines the genres of the album collection
 *
 */
public enum Genre{
     Classical, Country, Jazz, Pop, Unknown;
    public String genreString()
    {
        if (this == Pop){
            return "Pop";
        }
        else if(this == Country){
            return "Country";
        }
        else if(this == Classical){
            return "Classical";
        }
        else if(this == Jazz){
            return "Jazz";
        }
        else{
            return "Unknown";
        }
    }
}
