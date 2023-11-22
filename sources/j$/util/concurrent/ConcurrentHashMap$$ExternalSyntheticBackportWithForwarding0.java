package j$.util.concurrent;

import sun.misc.Unsafe;

/* loaded from: classes.dex */
public abstract /* synthetic */ class ConcurrentHashMap$$ExternalSyntheticBackportWithForwarding0 {
    public static /* synthetic */ boolean getAuthRequestContext(Unsafe unsafe, Object obj, long j, Object obj2) {
        while (!unsafe.compareAndSwapObject(obj, j, (Object) null, obj2)) {
            if (unsafe.getObject(obj, j) != null) {
                return false;
            }
        }
        return true;
    }
}
