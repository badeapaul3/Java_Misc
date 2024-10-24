package devguideocp.Part2_C11to15.A13_1_FuncInterf;

/**
 * @author hatzp
 **/


interface ContractX { void doIt(int i); }
interface ContractY { void doIt(double d); }


//can't mark as FuncInterface as there are 2 abstract methods
interface ContractZ extends ContractX, ContractY {
    @Override void doIt(int d);                              // Can be omitted.
    @Override void doIt(double d);                           // Can be omitted.
}