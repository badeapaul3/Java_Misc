package devguideocp.Part1_C1to5.A5_10_OOP_Enums;

/**
 * @author hatzp
 **/

public class Machine {

    private MachineState state;

    public void setState(MachineState state) { this.state = state; }
    public MachineState getState()           { return this.state; }
}
