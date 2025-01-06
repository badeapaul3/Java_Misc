package devguideocp.Part2_C16to21.A20_2_Serialization;

/**
 * @author hatzp
 **/
import java.io.*;

public class Unicycle2 implements Serializable {                    // (2)
    transient private Wheel wheel;                                   // (3b)

    public Unicycle2(Wheel wheel) { this.wheel = wheel; }

    @Override
    public String toString() { return "Unicycle with " + wheel; }

    @Serial
    private void writeObject(ObjectOutputStream oos) {               // (3c)
        try {
            oos.defaultWriteObject();
            oos.writeInt(wheel.getWheelSize());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Serial
    private void readObject(ObjectInputStream ois) {                 // (3d)
        try {
            ois.defaultReadObject();
            int wheelSize = ois.readInt();
            this.wheel = new Wheel(wheelSize);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
