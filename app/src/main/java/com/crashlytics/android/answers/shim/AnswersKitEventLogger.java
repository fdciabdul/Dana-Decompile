package com.crashlytics.android.answers.shim;

import com.crashlytics.android.answers.Answers;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes3.dex */
class AnswersKitEventLogger implements KitEventLogger {
    private static final String TAG = "AnswersKitEventLogger";
    private final Answers answers;

    private AnswersKitEventLogger(Answers answers) {
        this.answers = answers;
    }

    public static AnswersKitEventLogger create() throws NoClassDefFoundError, IllegalStateException {
        return create(Answers.getInstance());
    }

    static AnswersKitEventLogger create(Answers answers) throws IllegalStateException {
        if (answers == null) {
            throw new IllegalStateException("Answers must be initialized before logging kit events");
        }
        return new AnswersKitEventLogger(answers);
    }

    @Override // com.crashlytics.android.answers.shim.KitEventLogger
    public void logKitEvent(KitEvent kitEvent) {
        try {
            this.answers.logCustom(kitEvent.toCustomEvent());
        } catch (Throwable th) {
            InstrumentInjector.log_w(TAG, "Unexpected error sending Answers event", th);
        }
    }
}
