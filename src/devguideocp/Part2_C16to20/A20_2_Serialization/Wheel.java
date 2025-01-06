package devguideocp.Part2_C16to20.A20_2_Serialization;


import java.io.Serializable;

// public class Wheel implements Serializable {                   // (1a)
public class Wheel {                                              // (1b)
    private int wheelSize;

    public Wheel(int ws) { wheelSize = ws; }

    public int getWheelSize() { return wheelSize; }

    @Override
    public String toString() { return "wheel size: " + wheelSize; }
}

