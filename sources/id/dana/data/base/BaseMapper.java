package id.dana.data.base;

/* loaded from: classes2.dex */
public abstract class BaseMapper<T, R> {
    protected abstract R map(T t);

    public R apply(T t) {
        return map(t);
    }
}
