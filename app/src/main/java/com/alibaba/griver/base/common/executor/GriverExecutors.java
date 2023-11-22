package com.alibaba.griver.base.common.executor;

import android.os.Handler;
import android.os.Looper;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.logger.GriverLogger;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class GriverExecutors {

    /* renamed from: a  reason: collision with root package name */
    private static final Handler f6289a = new Handler(Looper.getMainLooper());
    private static final ScheduledThreadPoolExecutor b = new ScheduledThreadPoolExecutor(5);
    private static final Executor c = new Executor() { // from class: com.alibaba.griver.base.common.executor.GriverExecutors.1
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            runnable.run();
        }
    };
    private static final Executor d = new Executor() { // from class: com.alibaba.griver.base.common.executor.GriverExecutors.2
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            GriverExecutors.f6289a.post(runnable);
        }
    };
    private static final Map<ExecutorType, Executor> e = new ConcurrentHashMap();
    private static final Map<Integer, WeakReference<Executor>> f = new ConcurrentHashMap();
    private static Executor g = null;

    public static Executor getExecutor(final ExecutorType executorType) {
        if (GriverInnerConfig.getConfigBoolean(GriverConfigConstants.KEY_EXECUTOR_ENABLE, true)) {
            return NewGriverExecutor.getExecutor(executorType);
        }
        int i = AnonymousClass6.$SwitchMap$com$alibaba$ariver$kernel$common$service$executor$ExecutorType[executorType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    Map<ExecutorType, Executor> map = e;
                    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) map.get(executorType);
                    if (threadPoolExecutor == null) {
                        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(0, 10, 1L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new ThreadFactory() { // from class: com.alibaba.griver.base.common.executor.GriverExecutors.3
                            @Override // java.util.concurrent.ThreadFactory
                            public final Thread newThread(final Runnable runnable) {
                                return new Thread(new Runnable() { // from class: com.alibaba.griver.base.common.executor.GriverExecutors.3.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        try {
                                            Thread.sleep(1000L);
                                        } catch (InterruptedException e2) {
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("GriverExecutors#getExecutor, idle executor sleep error,");
                                            sb.append(e2);
                                            GriverLogger.e("GriverExecutors", sb.toString());
                                        }
                                        runnable.run();
                                    }
                                }, ExecutorType.this.name());
                            }
                        });
                        map.put(executorType, threadPoolExecutor2);
                        return threadPoolExecutor2;
                    }
                    return threadPoolExecutor;
                } else if (i == 4) {
                    Map<ExecutorType, Executor> map2 = e;
                    ThreadPoolExecutor threadPoolExecutor3 = (ThreadPoolExecutor) map2.get(executorType);
                    if (threadPoolExecutor3 == null) {
                        ThreadPoolExecutor threadPoolExecutor4 = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 1L, TimeUnit.MILLISECONDS, new SynchronousQueue(), new ThreadFactory() { // from class: com.alibaba.griver.base.common.executor.GriverExecutors.4
                            @Override // java.util.concurrent.ThreadFactory
                            public final Thread newThread(Runnable runnable) {
                                return new Thread(runnable, ExecutorType.this.name());
                            }
                        });
                        map2.put(executorType, threadPoolExecutor4);
                        return threadPoolExecutor4;
                    }
                    return threadPoolExecutor3;
                } else {
                    Map<ExecutorType, Executor> map3 = e;
                    ThreadPoolExecutor threadPoolExecutor5 = (ThreadPoolExecutor) map3.get(executorType);
                    if (threadPoolExecutor5 == null) {
                        ThreadPoolExecutor threadPoolExecutor6 = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 1L, TimeUnit.MILLISECONDS, new SynchronousQueue(), new ThreadFactory() { // from class: com.alibaba.griver.base.common.executor.GriverExecutors.5
                            @Override // java.util.concurrent.ThreadFactory
                            public final Thread newThread(Runnable runnable) {
                                return new Thread(runnable, ExecutorType.this.name());
                            }
                        });
                        map3.put(executorType, threadPoolExecutor6);
                        return threadPoolExecutor6;
                    }
                    return threadPoolExecutor5;
                }
            }
            return d;
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.alibaba.griver.base.common.executor.GriverExecutors$6  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$ariver$kernel$common$service$executor$ExecutorType;

        static {
            int[] iArr = new int[ExecutorType.values().length];
            $SwitchMap$com$alibaba$ariver$kernel$common$service$executor$ExecutorType = iArr;
            try {
                iArr[ExecutorType.SYNC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$kernel$common$service$executor$ExecutorType[ExecutorType.UI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$kernel$common$service$executor$ExecutorType[ExecutorType.IDLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$kernel$common$service$executor$ExecutorType[ExecutorType.NETWORK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$kernel$common$service$executor$ExecutorType[ExecutorType.URGENT_DISPLAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$kernel$common$service$executor$ExecutorType[ExecutorType.URGENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$kernel$common$service$executor$ExecutorType[ExecutorType.NORMAL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$kernel$common$service$executor$ExecutorType[ExecutorType.IO.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static ScheduledThreadPoolExecutor getScheduledExecutor() {
        if (GriverInnerConfig.getConfigBoolean(GriverConfigConstants.KEY_EXECUTOR_ENABLE, true)) {
            return NewGriverExecutor.getScheduledExecutor();
        }
        return b;
    }

    public static Executor getSingleMonitorThreadExecutor() {
        if (GriverInnerConfig.getConfigBoolean(GriverConfigConstants.KEY_EXECUTOR_ENABLE, true)) {
            return NewGriverExecutor.getSingleMonitorThreadExecutor();
        }
        if (g == null) {
            g = Executors.newSingleThreadExecutor(new H5SingleThreadFactory("SingleOrderThreadExecutor"));
        }
        return g;
    }

    public static Executor getSingleOrderThreadExecutorByName(String str) {
        WeakReference<Executor> weakReference;
        synchronized (GriverExecutors.class) {
            if (GriverInnerConfig.getConfigBoolean(GriverConfigConstants.KEY_EXECUTOR_ENABLE, true)) {
                return NewGriverExecutor.getSingleOrderThreadExecutorByName(str);
            }
            if (str == null) {
                str = "";
            }
            Integer valueOf = Integer.valueOf(Math.abs(str.hashCode() % 32));
            Map<Integer, WeakReference<Executor>> map = f;
            if (map.containsKey(valueOf) && (weakReference = map.get(valueOf)) != null && weakReference.get() != null) {
                return weakReference.get();
            }
            ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new H5SingleThreadFactory(str));
            map.put(valueOf, new WeakReference<>(newSingleThreadExecutor));
            return newSingleThreadExecutor;
        }
    }

    /* loaded from: classes3.dex */
    public static class H5SingleThreadFactory implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final String f6290a;

        public H5SingleThreadFactory(String str) {
            this.f6290a = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            StringBuilder sb = new StringBuilder();
            sb.append(this.f6290a);
            sb.append("_");
            sb.append(thread.getId());
            thread.setName(sb.toString());
            thread.setPriority(5);
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.alibaba.griver.base.common.executor.GriverExecutors.H5SingleThreadFactory.1
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread2, Throwable th) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("H5SingleThreadFactory catchUncaughtException ");
                    sb2.append(th);
                    GriverLogger.e("GriverExecutors", sb2.toString());
                }
            });
            return thread;
        }
    }
}
