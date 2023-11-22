package com.google.firebase.perf.injection.modules;

import com.google.firebase.perf.config.RemoteConfigManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes7.dex */
public final class FirebasePerformanceModule_ProvidesRemoteConfigManagerFactory implements Factory<RemoteConfigManager> {
    private final FirebasePerformanceModule module;

    public FirebasePerformanceModule_ProvidesRemoteConfigManagerFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    @Override // javax.inject.Provider
    public final RemoteConfigManager get() {
        return providesRemoteConfigManager(this.module);
    }

    public static FirebasePerformanceModule_ProvidesRemoteConfigManagerFactory create(FirebasePerformanceModule firebasePerformanceModule) {
        return new FirebasePerformanceModule_ProvidesRemoteConfigManagerFactory(firebasePerformanceModule);
    }

    public static RemoteConfigManager providesRemoteConfigManager(FirebasePerformanceModule firebasePerformanceModule) {
        return (RemoteConfigManager) Preconditions.getAuthRequestContext(firebasePerformanceModule.providesRemoteConfigManager(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
