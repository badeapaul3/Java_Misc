package devguideocp.Part2_C11to15.A13_1_FuncInterf;

import java.util.List;

/**
 * @author hatzp
 **/


interface Feature1<R> { void flatten(List<R> plist); }
interface Feature2<S> { void flatten(List<S> plist); }

//extended methods are override equivalent
@FunctionalInterface
interface Features<T> extends Feature1<T>, Feature2<T> {   // (1)
    @Override void flatten(List<T> plist);                   // Can be omitted.
}
