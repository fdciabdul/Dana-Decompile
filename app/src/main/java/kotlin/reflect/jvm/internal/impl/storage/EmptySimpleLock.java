package kotlin.reflect.jvm.internal.impl.storage;

/* loaded from: classes.dex */
public final class EmptySimpleLock implements SimpleLock {
    public static final EmptySimpleLock INSTANCE = new EmptySimpleLock();

    @Override // kotlin.reflect.jvm.internal.impl.storage.SimpleLock
    public final void lock() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.SimpleLock
    public final void unlock() {
    }

    private EmptySimpleLock() {
    }
}
