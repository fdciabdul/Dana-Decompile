package com.splunk.rum;

import java.util.concurrent.CountDownLatch;

/* loaded from: classes.dex */
public final /* synthetic */ class AnrWatcher$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ CountDownLatch KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // java.lang.Runnable
    public final void run() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.countDown();
    }
}
