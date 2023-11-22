package com.google.firebase.perf.injection.modules;

import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import dagger.Module;
import dagger.Provides;

@Module
/* loaded from: classes7.dex */
public class FirebasePerformanceModule {
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final Provider<RemoteConfigComponent> remoteConfigComponentProvider;
    private final Provider<TransportFactory> transportFactoryProvider;

    public FirebasePerformanceModule(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, Provider<RemoteConfigComponent> provider, Provider<TransportFactory> provider2) {
        this.firebaseApp = firebaseApp;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.remoteConfigComponentProvider = provider;
        this.transportFactoryProvider = provider2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public FirebaseApp providesFirebaseApp() {
        return this.firebaseApp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public FirebaseInstallationsApi providesFirebaseInstallations() {
        return this.firebaseInstallations;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public Provider<RemoteConfigComponent> providesRemoteConfigComponent() {
        return this.remoteConfigComponentProvider;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public Provider<TransportFactory> providesTransportFactoryProvider() {
        return this.transportFactoryProvider;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public RemoteConfigManager providesRemoteConfigManager() {
        return RemoteConfigManager.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public ConfigResolver providesConfigResolver() {
        return ConfigResolver.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public SessionManager providesSessionManager() {
        return SessionManager.getInstance();
    }
}
