package io.opentelemetry.sdk.internal;

/* loaded from: classes6.dex */
public final class ThrowableUtil {
    public static void propagateIfFatal(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }

    private ThrowableUtil() {
    }
}
