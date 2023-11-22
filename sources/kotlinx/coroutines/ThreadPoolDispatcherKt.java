package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0000"}, d2 = {}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class ThreadPoolDispatcherKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: newFixedThreadPoolContext$lambda-1  reason: not valid java name */
    public static final Thread m4627newFixedThreadPoolContext$lambda1(int i, String str, AtomicInteger atomicInteger, Runnable runnable) {
        if (i != 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append('-');
            sb.append(atomicInteger.incrementAndGet());
            str = sb.toString();
        }
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(true);
        return thread;
    }
}
