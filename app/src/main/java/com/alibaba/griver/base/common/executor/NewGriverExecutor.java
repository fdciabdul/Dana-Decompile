package com.alibaba.griver.base.common.executor;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class NewGriverExecutor {

    /* renamed from: a  reason: collision with root package name */
    private static final int f6291a;
    private static final Handler b;
    private static final int c;
    private static final int d;
    private static final int e;
    private static final ScheduledThreadPoolExecutor f;
    private static final Executor g;
    private static final Executor h;
    private static final Map<ExecutorType, Executor> i;
    private static final Map<Integer, WeakReference<Executor>> j;
    private static final Executor k;
    private static final Executor l;
    private static Executor m;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f6291a = availableProcessors;
        b = new Handler(Looper.getMainLooper());
        c = availableProcessors;
        int i2 = availableProcessors + 1;
        d = i2;
        e = (availableProcessors * 2) + 1;
        f = new ScheduledThreadPoolExecutor(5);
        g = new Executor() { // from class: com.alibaba.griver.base.common.executor.NewGriverExecutor.1
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                runnable.run();
            }
        };
        h = new Executor() { // from class: com.alibaba.griver.base.common.executor.NewGriverExecutor.2
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                NewGriverExecutor.b.post(runnable);
            }
        };
        i = new ConcurrentHashMap();
        j = new ConcurrentHashMap();
        k = Executors.newSingleThreadExecutor(new GriverExecutors.H5SingleThreadFactory("singleOrder2ExecutorForAndroid5"));
        l = new ThreadPoolExecutor(availableProcessors, i2, 60L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.alibaba.griver.base.common.executor.NewGriverExecutor.3
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Process.setThreadPriority(-1);
                return new Thread(runnable, "executorForAndroid5");
            }
        });
        m = null;
    }

    /* renamed from: com.alibaba.griver.base.common.executor.NewGriverExecutor$9  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass9 {
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
                $SwitchMap$com$alibaba$ariver$kernel$common$service$executor$ExecutorType[ExecutorType.URGENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$kernel$common$service$executor$ExecutorType[ExecutorType.URGENT_DISPLAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$kernel$common$service$executor$ExecutorType[ExecutorType.NETWORK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$kernel$common$service$executor$ExecutorType[ExecutorType.IO.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$kernel$common$service$executor$ExecutorType[ExecutorType.IDLE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$kernel$common$service$executor$ExecutorType[ExecutorType.NORMAL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static Executor getExecutor(final ExecutorType executorType) {
        switch (AnonymousClass9.$SwitchMap$com$alibaba$ariver$kernel$common$service$executor$ExecutorType[executorType.ordinal()]) {
            case 1:
                return g;
            case 2:
                return h;
            case 3:
            case 4:
                if (a()) {
                    return l;
                }
                Map<ExecutorType, Executor> map = i;
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) map.get(executorType);
                if (threadPoolExecutor == null) {
                    ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(c, d, 60L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.alibaba.griver.base.common.executor.NewGriverExecutor.4
                        @Override // java.util.concurrent.ThreadFactory
                        public final Thread newThread(Runnable runnable) {
                            Process.setThreadPriority(-1);
                            return new Thread(runnable, ExecutorType.this.name());
                        }
                    });
                    map.put(executorType, threadPoolExecutor2);
                    return threadPoolExecutor2;
                }
                return threadPoolExecutor;
            case 5:
                if (a()) {
                    return l;
                }
                Map<ExecutorType, Executor> map2 = i;
                ThreadPoolExecutor threadPoolExecutor3 = (ThreadPoolExecutor) map2.get(executorType);
                if (threadPoolExecutor3 == null) {
                    ThreadPoolExecutor threadPoolExecutor4 = new ThreadPoolExecutor(c, e, 60L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.alibaba.griver.base.common.executor.NewGriverExecutor.5
                        @Override // java.util.concurrent.ThreadFactory
                        public final Thread newThread(Runnable runnable) {
                            Thread thread = new Thread(runnable, ExecutorType.this.name());
                            thread.setPriority(5);
                            return thread;
                        }
                    });
                    map2.put(executorType, threadPoolExecutor4);
                    return threadPoolExecutor4;
                }
                return threadPoolExecutor3;
            case 6:
                if (a()) {
                    return l;
                }
                Map<ExecutorType, Executor> map3 = i;
                ThreadPoolExecutor threadPoolExecutor5 = (ThreadPoolExecutor) map3.get(executorType);
                if (threadPoolExecutor5 == null) {
                    ThreadPoolExecutor threadPoolExecutor6 = new ThreadPoolExecutor(c, e, 60L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.alibaba.griver.base.common.executor.NewGriverExecutor.6
                        @Override // java.util.concurrent.ThreadFactory
                        public final Thread newThread(Runnable runnable) {
                            Thread thread = new Thread(runnable, ExecutorType.this.name());
                            thread.setPriority(5);
                            return thread;
                        }
                    });
                    map3.put(executorType, threadPoolExecutor6);
                    return threadPoolExecutor6;
                }
                return threadPoolExecutor5;
            case 7:
                if (a()) {
                    return l;
                }
                Map<ExecutorType, Executor> map4 = i;
                ThreadPoolExecutor threadPoolExecutor7 = (ThreadPoolExecutor) map4.get(executorType);
                if (threadPoolExecutor7 == null) {
                    ThreadPoolExecutor threadPoolExecutor8 = new ThreadPoolExecutor(2, 5, 60L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.alibaba.griver.base.common.executor.NewGriverExecutor.7
                        @Override // java.util.concurrent.ThreadFactory
                        public final Thread newThread(Runnable runnable) {
                            Thread thread = new Thread(runnable, ExecutorType.this.name());
                            thread.setPriority(3);
                            return thread;
                        }
                    });
                    map4.put(executorType, threadPoolExecutor8);
                    return threadPoolExecutor8;
                }
                return threadPoolExecutor7;
            default:
                if (a()) {
                    return l;
                }
                Map<ExecutorType, Executor> map5 = i;
                ThreadPoolExecutor threadPoolExecutor9 = (ThreadPoolExecutor) map5.get(executorType);
                if (threadPoolExecutor9 == null) {
                    ThreadPoolExecutor threadPoolExecutor10 = new ThreadPoolExecutor(c, d, 60L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.alibaba.griver.base.common.executor.NewGriverExecutor.8
                        @Override // java.util.concurrent.ThreadFactory
                        public final Thread newThread(Runnable runnable) {
                            return new Thread(runnable, ExecutorType.this.name());
                        }
                    });
                    map5.put(executorType, threadPoolExecutor10);
                    return threadPoolExecutor10;
                }
                return threadPoolExecutor9;
        }
    }

    public static ScheduledThreadPoolExecutor getScheduledExecutor() {
        return f;
    }

    public static Executor getSingleMonitorThreadExecutor() {
        if (m == null) {
            m = Executors.newSingleThreadExecutor(new H5SingleThreadFactory("SingleOrderThreadExecutor"));
        }
        return m;
    }

    public static Executor getSingleOrderThreadExecutorByName(String str) {
        WeakReference<Executor> weakReference;
        synchronized (NewGriverExecutor.class) {
            if (a()) {
                return k;
            }
            if (str == null) {
                str = "";
            }
            int abs = Math.abs(str.hashCode() % 32);
            Map<Integer, WeakReference<Executor>> map = j;
            if (map.containsKey(Integer.valueOf(abs)) && (weakReference = map.get(Integer.valueOf(abs))) != null && weakReference.get() != null) {
                return weakReference.get();
            }
            ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new GriverExecutors.H5SingleThreadFactory(str));
            map.put(Integer.valueOf(abs), new WeakReference<>(newSingleThreadExecutor));
            return newSingleThreadExecutor;
        }
    }

    /* loaded from: classes3.dex */
    public static class H5SingleThreadFactory implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final String f6292a;

        public H5SingleThreadFactory(String str) {
            this.f6292a = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            StringBuilder sb = new StringBuilder();
            sb.append(this.f6292a);
            sb.append("_");
            sb.append(thread.getId());
            thread.setName(sb.toString());
            thread.setPriority(5);
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.alibaba.griver.base.common.executor.NewGriverExecutor.H5SingleThreadFactory.1
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread2, Throwable th) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("H5SingleThreadFactory ");
                    sb2.append(th);
                    GriverLogger.e("NewGriverExecutor", sb2.toString());
                }
            });
            return thread;
        }
    }

    private static boolean a() {
        return Build.VERSION.SDK_INT < 23 && GriverInnerConfig.getConfigBoolean(GriverConfigConstants.KEY_GRIVER_EXECUTOR_ANDROID_5_ENABLE, false);
    }
}
