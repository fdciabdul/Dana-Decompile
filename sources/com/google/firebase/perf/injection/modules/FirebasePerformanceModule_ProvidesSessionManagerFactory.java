package com.google.firebase.perf.injection.modules;

import com.google.firebase.perf.session.SessionManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes7.dex */
public final class FirebasePerformanceModule_ProvidesSessionManagerFactory implements Factory<SessionManager> {
    private final FirebasePerformanceModule module;

    public FirebasePerformanceModule_ProvidesSessionManagerFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    @Override // javax.inject.Provider
    public final SessionManager get() {
        return providesSessionManager(this.module);
    }

    public static FirebasePerformanceModule_ProvidesSessionManagerFactory create(FirebasePerformanceModule firebasePerformanceModule) {
        return new FirebasePerformanceModule_ProvidesSessionManagerFactory(firebasePerformanceModule);
    }

    public static SessionManager providesSessionManager(FirebasePerformanceModule firebasePerformanceModule) {
        return (SessionManager) Preconditions.getAuthRequestContext(firebasePerformanceModule.providesSessionManager(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
