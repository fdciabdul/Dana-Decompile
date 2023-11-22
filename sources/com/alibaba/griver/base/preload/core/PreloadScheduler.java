package com.alibaba.griver.base.preload.core;

import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.preload.annotation.AppxJob;
import com.alibaba.griver.base.preload.annotation.PreloadThreadType;
import com.alibaba.griver.base.preload.annotation.RunningAfterAppxJob;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class PreloadScheduler {
    public static final String TAG = "PreloadScheduler";
    public static String UA;
    private static PreloadScheduler c;

    /* renamed from: a  reason: collision with root package name */
    private Map<PointType, List<Class<? extends IPreloadJob>>> f6342a = new ConcurrentHashMap();
    private Map<Class, PreloadResultWrapper> b = new ConcurrentHashMap();
    private CountDownLatch d = new CountDownLatch(1);

    /* loaded from: classes2.dex */
    public enum PointType {
        PROCESS_CREATE,
        CREATE_APP,
        CLOSE_APP,
        CREATE_PAGE
    }

    public static PreloadScheduler getInstance() {
        if (c == null) {
            c = new PreloadScheduler();
        }
        return c;
    }

    public void registerPreLoadJob(PointType pointType, Class<? extends IPreloadJob> cls) {
        List<Class<? extends IPreloadJob>> list = this.f6342a.get(pointType);
        if (list != null) {
            if (list.contains(cls)) {
                return;
            }
            list.add(cls);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(cls);
        this.f6342a.put(pointType, arrayList);
    }

    public void preLoad(final PointType pointType, final Map<String, Object> map) {
        List<Class<? extends IPreloadJob>> list = this.f6342a.get(pointType);
        if (list != null) {
            for (Class<? extends IPreloadJob> cls : list) {
                if (cls != null) {
                    String simpleName = cls.getSimpleName();
                    try {
                        final IPreloadJob newInstance = cls.newInstance();
                        if (newInstance == null) {
                            GriverLogger.d(TAG, "PreloadScheduler this is a null job");
                        } else {
                            final Method method = cls.getMethod("preLoad", Map.class, PointType.class);
                            PreloadThreadType preloadThreadType = (PreloadThreadType) method.getAnnotation(PreloadThreadType.class);
                            ExecutorType value = preloadThreadType != null ? preloadThreadType.value() : null;
                            if (value == null) {
                                value = ExecutorType.IDLE;
                            }
                            if (value != ExecutorType.UI) {
                                ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(value).execute(new Runnable() { // from class: com.alibaba.griver.base.preload.core.PreloadScheduler.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        AppxJob appxJob = (AppxJob) method.getAnnotation(AppxJob.class);
                                        if (appxJob != null && appxJob.value()) {
                                            synchronized (this) {
                                                if (PreloadScheduler.this.d.getCount() == 0) {
                                                    PreloadScheduler.this.d = new CountDownLatch(1);
                                                }
                                                PreloadScheduler.this.a(newInstance, map, pointType);
                                                PreloadScheduler.this.d.countDown();
                                            }
                                            return;
                                        }
                                        RunningAfterAppxJob runningAfterAppxJob = (RunningAfterAppxJob) method.getAnnotation(RunningAfterAppxJob.class);
                                        if (runningAfterAppxJob != null && runningAfterAppxJob.value()) {
                                            synchronized (this) {
                                                try {
                                                    PreloadScheduler.this.d.await(10L, TimeUnit.SECONDS);
                                                } catch (Exception e) {
                                                    GriverLogger.e(PreloadScheduler.TAG, "preLoad wait appx error", e);
                                                }
                                            }
                                        }
                                        PreloadScheduler.this.a(newInstance, map, pointType);
                                    }
                                });
                            } else if (preloadThreadType.value() == ExecutorType.UI) {
                                RunningAfterAppxJob runningAfterAppxJob = (RunningAfterAppxJob) method.getAnnotation(RunningAfterAppxJob.class);
                                if (runningAfterAppxJob != null && runningAfterAppxJob.value()) {
                                    ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.IDLE).execute(new Runnable() { // from class: com.alibaba.griver.base.preload.core.PreloadScheduler.2
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            synchronized (this) {
                                                try {
                                                    PreloadScheduler.this.d.await(10L, TimeUnit.SECONDS);
                                                } catch (Exception e) {
                                                    GriverLogger.e(PreloadScheduler.TAG, "preLoad wait appx error", e);
                                                }
                                            }
                                            ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.griver.base.preload.core.PreloadScheduler.2.1
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    PreloadScheduler.this.a(newInstance, map, pointType);
                                                }
                                            });
                                        }
                                    });
                                } else {
                                    ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.griver.base.preload.core.PreloadScheduler.3
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            PreloadScheduler.this.a(newInstance, map, pointType);
                                        }
                                    });
                                }
                            }
                        }
                    } catch (Throwable th) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(simpleName);
                        sb.append(" invoke error");
                        GriverLogger.e(TAG, sb.toString(), th);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(IPreloadJob iPreloadJob, Map<String, Object> map, PointType pointType) {
        try {
            Object preLoad = iPreloadJob.preLoad(map, pointType);
            if (preLoad != null) {
                this.b.put(preLoad.getClass(), new PreloadResultWrapper(iPreloadJob.getJobName(), preLoad));
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append(iPreloadJob.getJobName());
            sb.append(" preload error");
            GriverLogger.e(TAG, sb.toString(), e);
        }
    }

    public <T> T getAndRemoveReadyResult(Class<T> cls) {
        PreloadResultWrapper remove = this.b.remove(cls);
        if (remove == null || remove.obj == null) {
            return null;
        }
        return (T) remove.obj;
    }

    public <T> T getReadyResource(Class<T> cls) {
        PreloadResultWrapper preloadResultWrapper = this.b.get(cls);
        if (preloadResultWrapper == null || preloadResultWrapper.obj == null) {
            return null;
        }
        return (T) preloadResultWrapper.obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class PreloadResultWrapper {
        public String name;
        public Object obj;

        public PreloadResultWrapper(String str, Object obj) {
            this.name = str;
            this.obj = obj;
        }
    }
}
