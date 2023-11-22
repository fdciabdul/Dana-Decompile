package com.google.android.gms.common.providers;

import java.util.concurrent.ScheduledExecutorService;

@Deprecated
/* loaded from: classes7.dex */
public class PooledExecutorsProvider {
    private static PooledExecutorFactory zza;

    /* loaded from: classes7.dex */
    public interface PooledExecutorFactory {
        @Deprecated
        ScheduledExecutorService newSingleThreadScheduledExecutor();
    }

    private PooledExecutorsProvider() {
    }

    @Deprecated
    public static PooledExecutorFactory getInstance() {
        PooledExecutorFactory pooledExecutorFactory;
        synchronized (PooledExecutorsProvider.class) {
            if (zza == null) {
                zza = new zza();
            }
            pooledExecutorFactory = zza;
        }
        return pooledExecutorFactory;
    }
}
