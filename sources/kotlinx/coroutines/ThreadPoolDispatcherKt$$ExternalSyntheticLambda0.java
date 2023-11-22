package kotlinx.coroutines;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes9.dex */
public final /* synthetic */ class ThreadPoolDispatcherKt$$ExternalSyntheticLambda0 implements ThreadFactory {
    public final /* synthetic */ int f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ AtomicInteger f$2;

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread m4627newFixedThreadPoolContext$lambda1;
        m4627newFixedThreadPoolContext$lambda1 = ThreadPoolDispatcherKt.m4627newFixedThreadPoolContext$lambda1(this.f$0, this.f$1, this.f$2, runnable);
        return m4627newFixedThreadPoolContext$lambda1;
    }
}
