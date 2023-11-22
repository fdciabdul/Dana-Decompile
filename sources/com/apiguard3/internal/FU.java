package com.apiguard3.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* loaded from: classes7.dex */
public class FU {
    private static int AGState = 1;
    private static int APIGuard;

    /* loaded from: classes7.dex */
    public interface values<D> {
        void AGState();

        void AGState(D d) throws Exception;
    }

    public static <T> Future<Void> APIGuard(final Future<T> future, final values<T> valuesVar) {
        Future<Void> submit = Executors.newSingleThreadExecutor().submit(new Callable<Void>() { // from class: com.apiguard3.internal.FU.3
            private static int APIGuard = 1;
            private static int valueOf;

            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Void call() throws Exception {
                valueOf = (APIGuard + 55) % 128;
                Void valueOf2 = valueOf();
                int i = APIGuard + 101;
                valueOf = i % 128;
                if ((i % 2 != 0 ? 'P' : '\b') == '\b') {
                    return valueOf2;
                }
                throw new ArithmeticException();
            }

            private Void valueOf() throws Exception {
                int i = APIGuard + 73;
                valueOf = i % 128;
                try {
                    if (!(i % 2 != 0)) {
                        values.this.AGState(future.get());
                        APIGuard = (valueOf + 11) % 128;
                        return null;
                    }
                    values.this.AGState(future.get());
                    throw new ArithmeticException();
                } catch (Throwable th) {
                    values valuesVar2 = values.this;
                    th.getCause();
                    valuesVar2.AGState();
                    if (th.getCause() instanceof Exception) {
                        throw ((Exception) th.getCause());
                    }
                    throw th;
                }
            }
        });
        AGState = (APIGuard + 47) % 128;
        return submit;
    }
}
