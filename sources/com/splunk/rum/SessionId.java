package com.splunk.rum;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import com.splunk.rum.SessionIdTimeoutHandler;
import io.opentelemetry.api.trace.TraceId;
import io.opentelemetry.sdk.common.Clock;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
class SessionId {
    private static final long BuiltInFictitiousFunctionClassFactory = TimeUnit.HOURS.toNanos(4);
    private final SessionIdTimeoutHandler KClassImpl$Data$declaredNonStaticMembers$2;
    volatile SessionIdChangeListener MyBillsEntityDataFactory;
    private final Clock PlaceComponentResult;
    private volatile long getAuthRequestContext;
    private final AtomicReference<String> lookAheadTest;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionId(SessionIdTimeoutHandler sessionIdTimeoutHandler) {
        this(Clock.CC.getDefault(), sessionIdTimeoutHandler);
    }

    private SessionId(Clock clock, SessionIdTimeoutHandler sessionIdTimeoutHandler) {
        AtomicReference<String> atomicReference = new AtomicReference<>();
        this.lookAheadTest = atomicReference;
        this.PlaceComponentResult = clock;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = sessionIdTimeoutHandler;
        Random random = new Random();
        atomicReference.set(TraceId.fromLongs(random.nextLong(), random.nextLong()));
        this.getAuthRequestContext = clock.now();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String KClassImpl$Data$declaredNonStaticMembers$2() {
        boolean KClassImpl$Data$declaredNonStaticMembers$2;
        String str;
        String str2 = (String) Objects.requireNonNull(this.lookAheadTest.get());
        if (getAuthRequestContext() || this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory()) {
            Random random = new Random();
            KClassImpl$Data$declaredNonStaticMembers$2 = LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.lookAheadTest, str2, TraceId.fromLongs(random.nextLong(), random.nextLong()));
            if (KClassImpl$Data$declaredNonStaticMembers$2) {
                this.getAuthRequestContext = this.PlaceComponentResult.nanoTime();
            }
            str = (String) Objects.requireNonNull(this.lookAheadTest.get());
        } else {
            KClassImpl$Data$declaredNonStaticMembers$2 = false;
            str = str2;
        }
        SessionIdTimeoutHandler sessionIdTimeoutHandler = this.KClassImpl$Data$declaredNonStaticMembers$2;
        sessionIdTimeoutHandler.PlaceComponentResult = sessionIdTimeoutHandler.BuiltInFictitiousFunctionClassFactory.nanoTime();
        if (sessionIdTimeoutHandler.MyBillsEntityDataFactory == SessionIdTimeoutHandler.State.TRANSITIONING_TO_FOREGROUND) {
            sessionIdTimeoutHandler.MyBillsEntityDataFactory = SessionIdTimeoutHandler.State.FOREGROUND;
        }
        SessionIdChangeListener sessionIdChangeListener = this.MyBillsEntityDataFactory;
        if (KClassImpl$Data$declaredNonStaticMembers$2 && sessionIdChangeListener != null) {
            sessionIdChangeListener.MyBillsEntityDataFactory(str2);
        }
        return str;
    }

    private boolean getAuthRequestContext() {
        return this.PlaceComponentResult.nanoTime() - this.getAuthRequestContext >= BuiltInFictitiousFunctionClassFactory;
    }

    public String toString() {
        return (String) Objects.requireNonNull(this.lookAheadTest.get());
    }
}
