package com.google.firebase.perf;

import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.perf.injection.components.DaggerFirebasePerformanceComponent;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes7.dex */
public class FirebasePerfRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        return Arrays.asList(Component.builder(FirebasePerformance.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.requiredProvider(RemoteConfigComponent.class)).add(Dependency.required(FirebaseInstallationsApi.class)).add(Dependency.requiredProvider(TransportFactory.class)).factory(new ComponentFactory() { // from class: com.google.firebase.perf.FirebasePerfRegistrar$$ExternalSyntheticLambda0
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                FirebasePerformance providesFirebasePerformance;
                providesFirebasePerformance = FirebasePerfRegistrar.providesFirebasePerformance(componentContainer);
                return providesFirebasePerformance;
            }
        }).build(), LibraryVersionComponent.create("fire-perf", "20.1.1"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static FirebasePerformance providesFirebasePerformance(ComponentContainer componentContainer) {
        return DaggerFirebasePerformanceComponent.builder().firebasePerformanceModule(new FirebasePerformanceModule((FirebaseApp) componentContainer.get(FirebaseApp.class), (FirebaseInstallationsApi) componentContainer.get(FirebaseInstallationsApi.class), componentContainer.getProvider(RemoteConfigComponent.class), componentContainer.getProvider(TransportFactory.class))).build().getFirebasePerformance();
    }
}
