package com.google.firebase.perf.injection.components;

import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.FirebasePerformance_Factory;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesConfigResolverFactory;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesFirebaseAppFactory;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesFirebaseInstallationsFactory;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesRemoteConfigComponentFactory;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesRemoteConfigManagerFactory;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesSessionManagerFactory;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes7.dex */
public final class DaggerFirebasePerformanceComponent implements FirebasePerformanceComponent {
    private Provider<FirebasePerformance> firebasePerformanceProvider;
    private Provider<ConfigResolver> providesConfigResolverProvider;
    private Provider<FirebaseApp> providesFirebaseAppProvider;
    private Provider<FirebaseInstallationsApi> providesFirebaseInstallationsProvider;
    private Provider<com.google.firebase.inject.Provider<RemoteConfigComponent>> providesRemoteConfigComponentProvider;
    private Provider<RemoteConfigManager> providesRemoteConfigManagerProvider;
    private Provider<SessionManager> providesSessionManagerProvider;
    private Provider<com.google.firebase.inject.Provider<TransportFactory>> providesTransportFactoryProvider;

    private DaggerFirebasePerformanceComponent(FirebasePerformanceModule firebasePerformanceModule) {
        initialize(firebasePerformanceModule);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(FirebasePerformanceModule firebasePerformanceModule) {
        this.providesFirebaseAppProvider = FirebasePerformanceModule_ProvidesFirebaseAppFactory.create(firebasePerformanceModule);
        this.providesRemoteConfigComponentProvider = FirebasePerformanceModule_ProvidesRemoteConfigComponentFactory.create(firebasePerformanceModule);
        this.providesFirebaseInstallationsProvider = FirebasePerformanceModule_ProvidesFirebaseInstallationsFactory.create(firebasePerformanceModule);
        this.providesTransportFactoryProvider = FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory.create(firebasePerformanceModule);
        this.providesRemoteConfigManagerProvider = FirebasePerformanceModule_ProvidesRemoteConfigManagerFactory.create(firebasePerformanceModule);
        this.providesConfigResolverProvider = FirebasePerformanceModule_ProvidesConfigResolverFactory.create(firebasePerformanceModule);
        FirebasePerformanceModule_ProvidesSessionManagerFactory create = FirebasePerformanceModule_ProvidesSessionManagerFactory.create(firebasePerformanceModule);
        this.providesSessionManagerProvider = create;
        this.firebasePerformanceProvider = DoubleCheck.getAuthRequestContext(FirebasePerformance_Factory.create(this.providesFirebaseAppProvider, this.providesRemoteConfigComponentProvider, this.providesFirebaseInstallationsProvider, this.providesTransportFactoryProvider, this.providesRemoteConfigManagerProvider, this.providesConfigResolverProvider, create));
    }

    @Override // com.google.firebase.perf.injection.components.FirebasePerformanceComponent
    public final FirebasePerformance getFirebasePerformance() {
        return this.firebasePerformanceProvider.get();
    }

    /* loaded from: classes7.dex */
    public static final class Builder {
        private FirebasePerformanceModule firebasePerformanceModule;

        private Builder() {
        }

        public final Builder firebasePerformanceModule(FirebasePerformanceModule firebasePerformanceModule) {
            this.firebasePerformanceModule = (FirebasePerformanceModule) Preconditions.getAuthRequestContext(firebasePerformanceModule);
            return this;
        }

        public final FirebasePerformanceComponent build() {
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.firebasePerformanceModule, FirebasePerformanceModule.class);
            return new DaggerFirebasePerformanceComponent(this.firebasePerformanceModule);
        }
    }
}
