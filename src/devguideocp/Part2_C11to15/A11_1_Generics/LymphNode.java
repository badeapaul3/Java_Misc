package devguideocp.Part2_C11to15.A11_1_Generics;

/**
 * @author hatzp
 **/

class Lymph { /*... */ }

public class LymphNode implements IMonoLink<Lymph> {
    private Lymph            body;
    private IMonoLink<Lymph> location;
    @Override public void  setData(Lymph obj) { body = obj; }
    @Override public Lymph getData()          { return body; }
    @Override public void  setNext(IMonoLink<Lymph> loc) { this.location = loc; }
    @Override public IMonoLink<Lymph> getNext()          { return this.location; }
}
