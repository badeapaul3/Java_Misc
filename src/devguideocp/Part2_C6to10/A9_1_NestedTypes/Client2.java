package devguideocp.Part2_C6to10.A9_1_NestedTypes;

/**
 * @author hatzp
 **/

import static devguideocp.Part2_C6to10.A9_1_NestedTypes.ListPool.MyLinkedList.BiNode;         // (3) Static import

public class Client2 {
    BiNode objRef2 = new BiNode();                        // (4)
}

//class BiListPool implements devguideocp.Part2_C6to10.A9_1_NestedTypes.ListPool.IBiLink { }  // (5) Compile-time error!
// Not accessible!
