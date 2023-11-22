package io.opentelemetry.exporter.internal.okhttp;

import io.opentelemetry.sdk.internal.DaemonThreadFactory;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;

/* loaded from: classes9.dex */
public final class OkHttpUtil {
    public static Dispatcher newDispatcher() {
        return new Dispatcher(new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new DaemonThreadFactory("okhttp-dispatch")));
    }

    private OkHttpUtil() {
    }
}
