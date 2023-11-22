package com.splunk.rum;

import android.app.Application;

/* loaded from: classes.dex */
enum NoOpSlowRenderingDetector implements SlowRenderingDetector {
    INSTANCE;

    @Override // com.splunk.rum.SlowRenderingDetector
    public final void start(Application application) {
    }
}
