package com.splunk.rum;

import com.fullstory.instrumentation.InstrumentInjector;
import com.splunk.rum.RumInitializer;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.sdk.common.Clock;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AppStartupTimer {
    private static final long KClassImpl$Data$declaredNonStaticMembers$2 = TimeUnit.MINUTES.toNanos(1);
    final RumInitializer.AnchoredClock BuiltInFictitiousFunctionClassFactory;
    volatile Runnable MyBillsEntityDataFactory;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    volatile Span PlaceComponentResult;
    final long getAuthRequestContext;
    private boolean getErrorConfigVersion;
    private boolean lookAheadTest;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppStartupTimer() {
        RumInitializer.AnchoredClock KClassImpl$Data$declaredNonStaticMembers$22 = RumInitializer.AnchoredClock.KClassImpl$Data$declaredNonStaticMembers$2(Clock.CC.getDefault());
        this.BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$22;
        this.getAuthRequestContext = KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext + (KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory.nanoTime() - KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory);
        this.PlaceComponentResult = null;
        this.MyBillsEntityDataFactory = null;
        this.lookAheadTest = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        this.getErrorConfigVersion = false;
    }

    static /* synthetic */ boolean PlaceComponentResult(AppStartupTimer appStartupTimer) {
        appStartupTimer.getErrorConfigVersion = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void getAuthRequestContext() {
        if (this.lookAheadTest || this.getErrorConfigVersion) {
            return;
        }
        this.lookAheadTest = true;
        long j = this.getAuthRequestContext + KClassImpl$Data$declaredNonStaticMembers$2;
        RumInitializer.AnchoredClock anchoredClock = this.BuiltInFictitiousFunctionClassFactory;
        if (j < anchoredClock.getAuthRequestContext + (anchoredClock.MyBillsEntityDataFactory.nanoTime() - anchoredClock.BuiltInFictitiousFunctionClassFactory)) {
            InstrumentInjector.log_d("SplunkRum", "Max time to UI init exceeded");
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
            this.PlaceComponentResult = null;
            this.MyBillsEntityDataFactory = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        Span span = this.PlaceComponentResult;
        if (span != null && !this.NetworkUserEntityData$$ExternalSyntheticLambda0 && !this.getErrorConfigVersion) {
            Runnable runnable = this.MyBillsEntityDataFactory;
            if (runnable != null) {
                runnable.run();
            }
            RumInitializer.AnchoredClock anchoredClock = this.BuiltInFictitiousFunctionClassFactory;
            span.end(anchoredClock.getAuthRequestContext + (anchoredClock.MyBillsEntityDataFactory.nanoTime() - anchoredClock.BuiltInFictitiousFunctionClassFactory), TimeUnit.NANOSECONDS);
        }
        this.PlaceComponentResult = null;
        this.MyBillsEntityDataFactory = null;
    }

    /* loaded from: classes.dex */
    static class StartFromBackgroundRunnable implements Runnable {
        private final AppStartupTimer getAuthRequestContext;

        public StartFromBackgroundRunnable(AppStartupTimer appStartupTimer) {
            this.getAuthRequestContext = appStartupTimer;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.getAuthRequestContext.lookAheadTest) {
                return;
            }
            InstrumentInjector.log_d("SplunkRum", "Detected background app start");
            AppStartupTimer.PlaceComponentResult(this.getAuthRequestContext);
        }
    }
}
