package com.google.firebase.perf.injection.modules;

import com.google.firebase.installations.FirebaseInstallationsApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes7.dex */
public final class FirebasePerformanceModule_ProvidesFirebaseInstallationsFactory implements Factory<FirebaseInstallationsApi> {
    private final FirebasePerformanceModule module;

    public FirebasePerformanceModule_ProvidesFirebaseInstallationsFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    @Override // javax.inject.Provider
    public final FirebaseInstallationsApi get() {
        return providesFirebaseInstallations(this.module);
    }

    public static FirebasePerformanceModule_ProvidesFirebaseInstallationsFactory create(FirebasePerformanceModule firebasePerformanceModule) {
        return new FirebasePerformanceModule_ProvidesFirebaseInstallationsFactory(firebasePerformanceModule);
    }

    public static FirebaseInstallationsApi providesFirebaseInstallations(FirebasePerformanceModule firebasePerformanceModule) {
        return (FirebaseInstallationsApi) Preconditions.getAuthRequestContext(firebasePerformanceModule.providesFirebaseInstallations(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
