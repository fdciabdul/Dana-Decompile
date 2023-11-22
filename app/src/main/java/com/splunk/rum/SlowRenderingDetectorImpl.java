package com.splunk.rum;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import com.fullstory.instrumentation.InstrumentInjector;
import com.splunk.rum.SlowRenderingDetectorImpl;
import io.opentelemetry.api.trace.Tracer;
import j$.time.Duration;
import j$.time.Instant;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.concurrent.ConcurrentMap;
import j$.util.function.BiConsumer;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SlowRenderingDetectorImpl implements SlowRenderingDetector, Application.ActivityLifecycleCallbacks {
    private static final HandlerThread BuiltInFictitiousFunctionClassFactory;
    private static final int MyBillsEntityDataFactory;
    private static final int getAuthRequestContext;
    private final ConcurrentMap<Activity, PerActivityListener> KClassImpl$Data$declaredNonStaticMembers$2;
    private final ScheduledExecutorService PlaceComponentResult;
    private final Handler getErrorConfigVersion;
    private final Tracer lookAheadTest;
    private final Duration moveToNextValue;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    static {
        int nanos = (int) TimeUnit.MILLISECONDS.toNanos(1L);
        getAuthRequestContext = nanos;
        MyBillsEntityDataFactory = nanos / 2;
        BuiltInFictitiousFunctionClassFactory = new HandlerThread("FrameMetricsCollector");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SlowRenderingDetectorImpl(io.opentelemetry.api.trace.Tracer r5, j$.time.Duration r6) {
        /*
            r4 = this;
            r0 = 1
            java.util.concurrent.ScheduledExecutorService r0 = java.util.concurrent.Executors.newScheduledThreadPool(r0)
            android.os.Handler r1 = new android.os.Handler
            android.os.HandlerThread r2 = com.splunk.rum.SlowRenderingDetectorImpl.BuiltInFictitiousFunctionClassFactory
            boolean r3 = r2.isAlive()
            if (r3 != 0) goto L12
            r2.start()
        L12:
            android.os.Looper r2 = r2.getLooper()
            r1.<init>(r2)
            r4.<init>(r5, r0, r1, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.splunk.rum.SlowRenderingDetectorImpl.<init>(io.opentelemetry.api.trace.Tracer, j$.time.Duration):void");
    }

    private SlowRenderingDetectorImpl(Tracer tracer, ScheduledExecutorService scheduledExecutorService, Handler handler, Duration duration) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ConcurrentHashMap();
        this.lookAheadTest = tracer;
        this.PlaceComponentResult = scheduledExecutorService;
        this.getErrorConfigVersion = handler;
        this.moveToNextValue = duration;
    }

    @Override // com.splunk.rum.SlowRenderingDetector
    public void start(Application application) {
        application.registerActivityLifecycleCallbacks(this);
        this.PlaceComponentResult.scheduleAtFixedRate(new Runnable() { // from class: com.splunk.rum.SlowRenderingDetectorImpl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                SlowRenderingDetectorImpl.KClassImpl$Data$declaredNonStaticMembers$2(SlowRenderingDetectorImpl.this);
            }
        }, this.moveToNextValue.toMillis(), this.moveToNextValue.toMillis(), TimeUnit.MILLISECONDS);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        PerActivityListener perActivityListener = new PerActivityListener(activity);
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.putIfAbsent(activity, perActivityListener) == null) {
            activity.getWindow().addOnFrameMetricsAvailableListener(perActivityListener, this.getErrorConfigVersion);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        PerActivityListener remove = this.KClassImpl$Data$declaredNonStaticMembers$2.remove(activity);
        if (remove != null) {
            activity.getWindow().removeOnFrameMetricsAvailableListener(remove);
            BuiltInFictitiousFunctionClassFactory(remove);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class PerActivityListener implements Window.OnFrameMetricsAvailableListener {
        final Activity BuiltInFictitiousFunctionClassFactory;
        private final Object MyBillsEntityDataFactory = new Object();
        private SparseIntArray PlaceComponentResult = new SparseIntArray();

        PerActivityListener(Activity activity) {
            this.BuiltInFictitiousFunctionClassFactory = activity;
        }

        @Override // android.view.Window.OnFrameMetricsAvailableListener
        public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i) {
            long metric = frameMetrics.getMetric(4);
            if (metric >= 0) {
                synchronized (this.MyBillsEntityDataFactory) {
                    int i2 = (int) ((metric + SlowRenderingDetectorImpl.MyBillsEntityDataFactory) / SlowRenderingDetectorImpl.getAuthRequestContext);
                    this.PlaceComponentResult.put(i2, this.PlaceComponentResult.get(i2) + 1);
                }
            }
        }

        final SparseIntArray getAuthRequestContext() {
            SparseIntArray sparseIntArray;
            synchronized (this.MyBillsEntityDataFactory) {
                sparseIntArray = this.PlaceComponentResult;
                this.PlaceComponentResult = new SparseIntArray();
            }
            return sparseIntArray;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void BuiltInFictitiousFunctionClassFactory(PerActivityListener perActivityListener) {
        SparseIntArray authRequestContext = perActivityListener.getAuthRequestContext();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < authRequestContext.size(); i3++) {
            int keyAt = authRequestContext.keyAt(i3);
            int i4 = authRequestContext.get(keyAt);
            if (keyAt > 700) {
                StringBuilder sb = new StringBuilder();
                sb.append("* FROZEN RENDER DETECTED: ");
                sb.append(keyAt);
                sb.append(" ms.");
                sb.append(i4);
                sb.append(" times");
                InstrumentInjector.log_d("SplunkRum", sb.toString());
                i2 += i4;
            } else if (keyAt > 16) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("* Slow render detected: ");
                sb2.append(keyAt);
                sb2.append(" ms. ");
                sb2.append(i4);
                sb2.append(" times");
                InstrumentInjector.log_d("SplunkRum", sb2.toString());
                i += i4;
            }
        }
        Instant now = Instant.now();
        if (i > 0) {
            getAuthRequestContext("slowRenders", perActivityListener.BuiltInFictitiousFunctionClassFactory.getComponentName().flattenToShortString(), i, now);
        }
        if (i2 > 0) {
            getAuthRequestContext("frozenRenders", perActivityListener.BuiltInFictitiousFunctionClassFactory.getComponentName().flattenToShortString(), i2, now);
        }
    }

    private void getAuthRequestContext(String str, String str2, int i, Instant instant) {
        this.lookAheadTest.spanBuilder(str).setAttribute("count", i).setAttribute("activity.name", str2).setStartTimestamp(instant).startSpan().end(instant);
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(final SlowRenderingDetectorImpl slowRenderingDetectorImpl) {
        try {
            ConcurrentMap.EL.KClassImpl$Data$declaredNonStaticMembers$2(slowRenderingDetectorImpl.KClassImpl$Data$declaredNonStaticMembers$2, new BiConsumer() { // from class: com.splunk.rum.SlowRenderingDetectorImpl$$ExternalSyntheticLambda0
                @Override // j$.util.function.BiConsumer
                public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                    return BiConsumer.CC.getAuthRequestContext(this, biConsumer);
                }

                @Override // j$.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    Activity activity = (Activity) obj;
                    SlowRenderingDetectorImpl.this.BuiltInFictitiousFunctionClassFactory((SlowRenderingDetectorImpl.PerActivityListener) obj2);
                }
            });
        } catch (Exception e) {
            InstrumentInjector.log_w("SplunkRum", "Exception while processing frame metrics", e);
        }
    }
}
