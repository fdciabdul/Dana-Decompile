package com.google.firebase.remoteconfig;

import android.content.Context;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigFetchHttpClient;
import com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient;
import com.google.firebase.remoteconfig.internal.ConfigStorageClient;
import com.google.firebase.remoteconfig.internal.Personalization;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class RemoteConfigComponent {
    public static final String ACTIVATE_FILE_NAME = "activate";
    public static final long CONNECTION_TIMEOUT_IN_SECONDS = 60;
    public static final String DEFAULTS_FILE_NAME = "defaults";
    public static final String DEFAULT_NAMESPACE = "firebase";
    public static final String FETCH_FILE_NAME = "fetch";
    private static final String FIREBASE_REMOTE_CONFIG_FILE_NAME_PREFIX = "frc";
    private static final String PREFERENCES_FILE_NAME = "settings";
    private final Provider<AnalyticsConnector> analyticsConnector;
    private final String appId;
    private final Context context;
    private Map<String, String> customHeaders;
    private final ExecutorService executorService;
    private final FirebaseABTesting firebaseAbt;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final Map<String, FirebaseRemoteConfig> frcNamespaceInstances;
    private static final Clock DEFAULT_CLOCK = DefaultClock.getInstance();
    private static final Random DEFAULT_RANDOM = new Random();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ AnalyticsConnector lambda$getFetchHandler$0() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RemoteConfigComponent(Context context, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, Provider<AnalyticsConnector> provider) {
        this(context, Executors.newCachedThreadPool(), firebaseApp, firebaseInstallationsApi, firebaseABTesting, provider, true);
    }

    protected RemoteConfigComponent(Context context, ExecutorService executorService, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, Provider<AnalyticsConnector> provider, boolean z) {
        this.frcNamespaceInstances = new HashMap();
        this.customHeaders = new HashMap();
        this.context = context;
        this.executorService = executorService;
        this.firebaseApp = firebaseApp;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.firebaseAbt = firebaseABTesting;
        this.analyticsConnector = provider;
        this.appId = firebaseApp.getOptions().getApplicationId();
        if (z) {
            Tasks.call(executorService, new Callable() { // from class: com.google.firebase.remoteconfig.RemoteConfigComponent$$ExternalSyntheticLambda2
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return RemoteConfigComponent.this.getDefault();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseRemoteConfig getDefault() {
        return get("firebase");
    }

    public FirebaseRemoteConfig get(String str) {
        FirebaseRemoteConfig firebaseRemoteConfig;
        synchronized (this) {
            ConfigCacheClient cacheClient = getCacheClient(str, FETCH_FILE_NAME);
            ConfigCacheClient cacheClient2 = getCacheClient(str, ACTIVATE_FILE_NAME);
            ConfigCacheClient cacheClient3 = getCacheClient(str, DEFAULTS_FILE_NAME);
            ConfigMetadataClient metadataClient = getMetadataClient(this.context, this.appId, str);
            ConfigGetParameterHandler getHandler = getGetHandler(cacheClient2, cacheClient3);
            final Personalization personalization = getPersonalization(this.firebaseApp, str, this.analyticsConnector);
            if (personalization != null) {
                Objects.requireNonNull(personalization);
                getHandler.addListener(new BiConsumer() { // from class: com.google.firebase.remoteconfig.RemoteConfigComponent$$ExternalSyntheticLambda1
                    @Override // com.google.android.gms.common.util.BiConsumer
                    public final void accept(Object obj, Object obj2) {
                        Personalization.this.logArmActive((String) obj, (ConfigContainer) obj2);
                    }
                });
            }
            firebaseRemoteConfig = get(this.firebaseApp, str, this.firebaseInstallations, this.firebaseAbt, this.executorService, cacheClient, cacheClient2, cacheClient3, getFetchHandler(str, cacheClient, metadataClient), getHandler, metadataClient);
        }
        return firebaseRemoteConfig;
    }

    FirebaseRemoteConfig get(FirebaseApp firebaseApp, String str, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, Executor executor, ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2, ConfigCacheClient configCacheClient3, ConfigFetchHandler configFetchHandler, ConfigGetParameterHandler configGetParameterHandler, ConfigMetadataClient configMetadataClient) {
        FirebaseRemoteConfig firebaseRemoteConfig;
        synchronized (this) {
            if (!this.frcNamespaceInstances.containsKey(str)) {
                FirebaseRemoteConfig firebaseRemoteConfig2 = new FirebaseRemoteConfig(this.context, firebaseApp, firebaseInstallationsApi, isAbtSupported(firebaseApp, str) ? firebaseABTesting : null, executor, configCacheClient, configCacheClient2, configCacheClient3, configFetchHandler, configGetParameterHandler, configMetadataClient);
                firebaseRemoteConfig2.startLoadingConfigsFromDisk();
                this.frcNamespaceInstances.put(str, firebaseRemoteConfig2);
            }
            firebaseRemoteConfig = this.frcNamespaceInstances.get(str);
        }
        return firebaseRemoteConfig;
    }

    public void setCustomHeaders(Map<String, String> map) {
        synchronized (this) {
            this.customHeaders = map;
        }
    }

    private ConfigCacheClient getCacheClient(String str, String str2) {
        return ConfigCacheClient.getInstance(Executors.newCachedThreadPool(), ConfigStorageClient.getInstance(this.context, String.format("%s_%s_%s_%s.json", "frc", this.appId, str, str2)));
    }

    ConfigFetchHttpClient getFrcBackendApiClient(String str, String str2, ConfigMetadataClient configMetadataClient) {
        return new ConfigFetchHttpClient(this.context, this.firebaseApp.getOptions().getApplicationId(), str, str2, configMetadataClient.getFetchTimeoutInSeconds(), configMetadataClient.getFetchTimeoutInSeconds());
    }

    ConfigFetchHandler getFetchHandler(String str, ConfigCacheClient configCacheClient, ConfigMetadataClient configMetadataClient) {
        ConfigFetchHandler configFetchHandler;
        synchronized (this) {
            configFetchHandler = new ConfigFetchHandler(this.firebaseInstallations, isPrimaryApp(this.firebaseApp) ? this.analyticsConnector : new Provider() { // from class: com.google.firebase.remoteconfig.RemoteConfigComponent$$ExternalSyntheticLambda0
                @Override // com.google.firebase.inject.Provider
                public final Object get() {
                    return RemoteConfigComponent.lambda$getFetchHandler$0();
                }
            }, this.executorService, DEFAULT_CLOCK, DEFAULT_RANDOM, configCacheClient, getFrcBackendApiClient(this.firebaseApp.getOptions().getApiKey(), str, configMetadataClient), configMetadataClient, this.customHeaders);
        }
        return configFetchHandler;
    }

    private ConfigGetParameterHandler getGetHandler(ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2) {
        return new ConfigGetParameterHandler(this.executorService, configCacheClient, configCacheClient2);
    }

    static ConfigMetadataClient getMetadataClient(Context context, String str, String str2) {
        return new ConfigMetadataClient(context.getSharedPreferences(String.format("%s_%s_%s_%s", "frc", str, str2, PREFERENCES_FILE_NAME), 0));
    }

    private static Personalization getPersonalization(FirebaseApp firebaseApp, String str, Provider<AnalyticsConnector> provider) {
        if (isPrimaryApp(firebaseApp) && str.equals("firebase")) {
            return new Personalization(provider);
        }
        return null;
    }

    private static boolean isAbtSupported(FirebaseApp firebaseApp, String str) {
        return str.equals("firebase") && isPrimaryApp(firebaseApp);
    }

    private static boolean isPrimaryApp(FirebaseApp firebaseApp) {
        return firebaseApp.getName().equals(FirebaseApp.DEFAULT_APP_NAME);
    }
}
