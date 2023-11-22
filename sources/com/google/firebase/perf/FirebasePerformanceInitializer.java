package com.google.firebase.perf;

import com.google.firebase.perf.application.AppStateMonitor;

/* loaded from: classes.dex */
public final class FirebasePerformanceInitializer implements AppStateMonitor.AppColdStartCallback {
    @Override // com.google.firebase.perf.application.AppStateMonitor.AppColdStartCallback
    public final void onAppColdStart() {
        FirebasePerformance.getInstance();
    }
}
