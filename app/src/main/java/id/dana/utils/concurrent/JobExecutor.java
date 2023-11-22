package id.dana.utils.concurrent;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class JobExecutor implements ThreadExecutor {
    private final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, Integer.MAX_VALUE, 10, TimeUnit.SECONDS, new SynchronousQueue(), new JobThreadFactory(0));

    @Inject
    public JobExecutor() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.threadPoolExecutor.execute(runnable);
    }

    /* loaded from: classes5.dex */
    static class JobThreadFactory implements ThreadFactory {
        private int getAuthRequestContext;

        private JobThreadFactory() {
            this.getAuthRequestContext = 0;
        }

        /* synthetic */ JobThreadFactory(byte b) {
            this();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            StringBuilder sb = new StringBuilder();
            sb.append("android_");
            int i = this.getAuthRequestContext;
            this.getAuthRequestContext = i + 1;
            sb.append(i);
            return new Thread(runnable, sb.toString());
        }
    }
}
