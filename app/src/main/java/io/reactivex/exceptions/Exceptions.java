package io.reactivex.exceptions;

import io.reactivex.internal.util.ExceptionHelper;

/* loaded from: classes.dex */
public final class Exceptions {
    private Exceptions() {
        throw new IllegalStateException("No instances!");
    }

    public static RuntimeException getAuthRequestContext(Throwable th) {
        throw ExceptionHelper.MyBillsEntityDataFactory(th);
    }

    public static void MyBillsEntityDataFactory(Throwable th) {
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
}
