package devguideocp.A5_10_OOP_EnumRecsSealed;

/**
 * @author hatzp
 **/

public class Machine {

    private MachineState state;

    public void setState(MachineState state) { this.state = state; }
    public MachineState getState()           { return this.state; }
}
