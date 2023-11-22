package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.TransportRuntimeComponent;
import com.google.android.datatransport.runtime.backends.CreationContextFactory_Factory;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry_Factory;
import com.google.android.datatransport.runtime.dagger.internal.DoubleCheck;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.InstanceFactory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler_Factory;
import com.google.android.datatransport.runtime.scheduling.SchedulingConfigModule_ConfigFactory;
import com.google.android.datatransport.runtime.scheduling.SchedulingModule_WorkSchedulerFactory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader_Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer_Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_DbNameFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_PackageNameFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_SchemaVersionFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_StoreConfigFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore_Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager_Factory;
import com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory;
import com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class DaggerTransportRuntimeComponent extends TransportRuntimeComponent {
    private Provider<SchedulerConfig> configProvider;
    private Provider creationContextFactoryProvider;
    private Provider<DefaultScheduler> defaultSchedulerProvider;
    private Provider<Executor> executorProvider;
    private Provider metadataBackendRegistryProvider;
    private Provider<String> packageNameProvider;
    private Provider<SQLiteEventStore> sQLiteEventStoreProvider;
    private Provider schemaManagerProvider;
    private Provider<Context> setApplicationContextProvider;
    private Provider<TransportRuntime> transportRuntimeProvider;
    private Provider<Uploader> uploaderProvider;
    private Provider<WorkInitializer> workInitializerProvider;
    private Provider<WorkScheduler> workSchedulerProvider;

    private DaggerTransportRuntimeComponent(Context context) {
        initialize(context);
    }

    public static TransportRuntimeComponent.Builder builder() {
        return new Builder();
    }

    private void initialize(Context context) {
        this.executorProvider = DoubleCheck.provider(ExecutionModule_ExecutorFactory.create());
        Factory create = InstanceFactory.create(context);
        this.setApplicationContextProvider = create;
        CreationContextFactory_Factory create2 = CreationContextFactory_Factory.create(create, TimeModule_EventClockFactory.create(), TimeModule_UptimeClockFactory.create());
        this.creationContextFactoryProvider = create2;
        this.metadataBackendRegistryProvider = DoubleCheck.provider(MetadataBackendRegistry_Factory.create(this.setApplicationContextProvider, create2));
        this.schemaManagerProvider = SchemaManager_Factory.create(this.setApplicationContextProvider, EventStoreModule_DbNameFactory.create(), EventStoreModule_SchemaVersionFactory.create());
        this.packageNameProvider = EventStoreModule_PackageNameFactory.create(this.setApplicationContextProvider);
        this.sQLiteEventStoreProvider = DoubleCheck.provider(SQLiteEventStore_Factory.create(TimeModule_EventClockFactory.create(), TimeModule_UptimeClockFactory.create(), EventStoreModule_StoreConfigFactory.create(), this.schemaManagerProvider, this.packageNameProvider));
        SchedulingConfigModule_ConfigFactory create3 = SchedulingConfigModule_ConfigFactory.create(TimeModule_EventClockFactory.create());
        this.configProvider = create3;
        SchedulingModule_WorkSchedulerFactory create4 = SchedulingModule_WorkSchedulerFactory.create(this.setApplicationContextProvider, this.sQLiteEventStoreProvider, create3, TimeModule_UptimeClockFactory.create());
        this.workSchedulerProvider = create4;
        Provider<Executor> provider = this.executorProvider;
        Provider provider2 = this.metadataBackendRegistryProvider;
        Provider<SQLiteEventStore> provider3 = this.sQLiteEventStoreProvider;
        this.defaultSchedulerProvider = DefaultScheduler_Factory.create(provider, provider2, create4, provider3, provider3);
        Provider<Context> provider4 = this.setApplicationContextProvider;
        Provider provider5 = this.metadataBackendRegistryProvider;
        Provider<SQLiteEventStore> provider6 = this.sQLiteEventStoreProvider;
        this.uploaderProvider = Uploader_Factory.create(provider4, provider5, provider6, this.workSchedulerProvider, this.executorProvider, provider6, TimeModule_EventClockFactory.create(), TimeModule_UptimeClockFactory.create(), this.sQLiteEventStoreProvider);
        Provider<Executor> provider7 = this.executorProvider;
        Provider<SQLiteEventStore> provider8 = this.sQLiteEventStoreProvider;
        this.workInitializerProvider = WorkInitializer_Factory.create(provider7, provider8, this.workSchedulerProvider, provider8);
        this.transportRuntimeProvider = DoubleCheck.provider(TransportRuntime_Factory.create(TimeModule_EventClockFactory.create(), TimeModule_UptimeClockFactory.create(), this.defaultSchedulerProvider, this.uploaderProvider, this.workInitializerProvider));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.datatransport.runtime.TransportRuntimeComponent
    public final TransportRuntime getTransportRuntime() {
        return this.transportRuntimeProvider.get();
    }

    @Override // com.google.android.datatransport.runtime.TransportRuntimeComponent
    final EventStore getEventStore() {
        return this.sQLiteEventStoreProvider.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class Builder implements TransportRuntimeComponent.Builder {
        public static final byte[] BuiltInFictitiousFunctionClassFactory = {107, 3, 14, 112, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
        public static final int getAuthRequestContext = 194;
        private Context setApplicationContext;

        private Builder() {
        }

        @Override // com.google.android.datatransport.runtime.TransportRuntimeComponent.Builder
        public final Builder setApplicationContext(Context context) {
            this.setApplicationContext = (Context) Preconditions.checkNotNull(context);
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x001c  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0031  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0031 -> B:23:0x0037). Please submit an issue!!! */
        @Override // com.google.android.datatransport.runtime.TransportRuntimeComponent.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.google.android.datatransport.runtime.TransportRuntimeComponent build() {
            /*
                r12 = this;
                android.content.Context r0 = r12.setApplicationContext
                byte[] r1 = com.google.android.datatransport.runtime.DaggerTransportRuntimeComponent.Builder.BuiltInFictitiousFunctionClassFactory
                r2 = 23
                byte[] r3 = new byte[r2]
                r4 = 0
                r5 = 97
                r6 = 4
                r8 = r12
                if (r1 != 0) goto L14
                r6 = 23
                r7 = 4
                r9 = 0
                goto L37
            L14:
                r7 = 0
            L15:
                int r9 = r7 + 1
                byte r10 = (byte) r5
                r3[r7] = r10
                if (r9 != r2) goto L31
                java.lang.String r1 = new java.lang.String
                r1.<init>(r3, r4)
                java.lang.Class r1 = java.lang.Class.forName(r1)
                com.google.android.datatransport.runtime.dagger.internal.Preconditions.checkBuilderRequirement(r0, r1)
                com.google.android.datatransport.runtime.DaggerTransportRuntimeComponent r0 = new com.google.android.datatransport.runtime.DaggerTransportRuntimeComponent
                android.content.Context r1 = r8.setApplicationContext
                r2 = 0
                r0.<init>(r1)
                return r0
            L31:
                r7 = r1[r6]
                r11 = r6
                r6 = r5
                r5 = r7
                r7 = r11
            L37:
                int r5 = -r5
                int r7 = r7 + 1
                int r6 = r6 + r5
                int r5 = r6 + (-8)
                r6 = r7
                r7 = r9
                goto L15
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.DaggerTransportRuntimeComponent.Builder.build():com.google.android.datatransport.runtime.TransportRuntimeComponent");
        }
    }
}
