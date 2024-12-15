package devguideocp.Part2_C16to20.A16_4_TerminalOperations;
import devguideocp.Part2_C16to20.A16_1_Streams.*;
import java.util.List;
/**
 * @author hatzp
 **/
public class RadioPlaylist {                                              // (1)
    private String radioStationName;
    private List<CD> Playlist;

    public RadioPlaylist(String radioStationName, List<CD> cdList) {
        this.radioStationName = radioStationName;
        this.Playlist = cdList;
    }

    public String getRadioStationName() { return this.radioStationName; }
    public List<CD> getPlaylist() { return this.Playlist; }
}
