package com.splunk.rum;

import io.opentelemetry.sdk.common.Clock;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class SessionIdTimeoutHandler implements AppStateListener {
    private static final long getAuthRequestContext = TimeUnit.MINUTES.toNanos(15);
    final Clock BuiltInFictitiousFunctionClassFactory;
    volatile State MyBillsEntityDataFactory;
    volatile long PlaceComponentResult;

    /* loaded from: classes.dex */
    enum State {
        FOREGROUND,
        BACKGROUND,
        TRANSITIONING_TO_FOREGROUND
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionIdTimeoutHandler() {
        this(Clock.CC.getDefault());
    }

    private SessionIdTimeoutHandler(Clock clock) {
        this.MyBillsEntityDataFactory = State.FOREGROUND;
        this.BuiltInFictitiousFunctionClassFactory = clock;
    }

    @Override // com.splunk.rum.AppStateListener
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.MyBillsEntityDataFactory = State.TRANSITIONING_TO_FOREGROUND;
    }

    @Override // com.splunk.rum.AppStateListener
    public final void getAuthRequestContext() {
        this.MyBillsEntityDataFactory = State.BACKGROUND;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean MyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory != State.FOREGROUND && this.BuiltInFictitiousFunctionClassFactory.nanoTime() - this.PlaceComponentResult >= getAuthRequestContext;
    }
}
