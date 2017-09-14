package org.vanbart.birthday.util;

/**
 * @since 14/09/2017.
 */
public class Tuple<T, U, V, W> {

    public final T t;

    public  final U u;

    public final V v;

    public final W w;

    public Tuple(T t, U u, V v, W w) {
        this.t = t;
        this.u = u;
        this.v = v;
        this.w = w;
    }
}
