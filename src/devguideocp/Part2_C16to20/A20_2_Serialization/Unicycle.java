package devguideocp.Part2_C16to20.A20_2_Serialization;

import java.io.Serializable;

public class Unicycle implements Serializable {                     // (2)
    private Wheel wheel;                                              // (3a)
    //transient private Wheel wheel;                                    // (3b)

    public Unicycle (Wheel wheel) { this.wheel = wheel; }

    @Override
    public String toString() { return "Unicycle with " + wheel; }
}
