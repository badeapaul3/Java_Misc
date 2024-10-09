package devguideocp.Part2_C11to15.A11_3_Generics3;

/**
 * @author hatzp
 **/
class SuperErasure<T> {
    public void set(T t) {/*...*/}                  // (1)
    public T get()       {return null;}             // (2)
}

class SubB1 extends SuperErasure<Number> {
    @Override public void set(Number num) {/*...*/} // (1a) Overrides
    @Override public Number get()       {return 0;} // (2a) Overrides
}

class SubB2 extends SuperErasure<Number> {
    //@Override public void set(Object obj) {/*...*/} // (1b) Error: same erasure
    public void set(Long l)     {/*...*/} // (1c) Error: overloads

//    @Override public Object get() {          // (2b) Error: incompatible return type
//        return null;
//    }
}
