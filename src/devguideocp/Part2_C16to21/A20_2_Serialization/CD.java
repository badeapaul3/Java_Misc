package devguideocp.Part2_C16to21.A20_2_Serialization;

/**
 * @author hatzp
 **/
import java.io.Serializable;
import java.time.Year;
/** A record class that represents a CD. */
public record CD(String artist, String title, int noOfTracks,
                 Year year, Genre genre) implements Serializable {
    public enum Genre implements Serializable {POP, JAZZ, OTHER}
}