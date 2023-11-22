package com.crashlytics.android.answers.shim;

/* loaded from: classes3.dex */
class NoopKitEventLogger implements KitEventLogger {
    @Override // com.crashlytics.android.answers.shim.KitEventLogger
    public void logKitEvent(KitEvent kitEvent) {
    }

    NoopKitEventLogger() {
    }

    public static KitEventLogger create() {
        return new NoopKitEventLogger();
    }
}
