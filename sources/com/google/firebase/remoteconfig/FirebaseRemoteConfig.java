package com.google.firebase.remoteconfig;

import android.content.Context;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.AbtException;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient;
import com.google.firebase.remoteconfig.internal.DefaultsXmlParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class FirebaseRemoteConfig {
    public static final boolean DEFAULT_VALUE_FOR_BOOLEAN = false;
    public static final byte[] DEFAULT_VALUE_FOR_BYTE_ARRAY = new byte[0];
    public static final double DEFAULT_VALUE_FOR_DOUBLE = 0.0d;
    public static final long DEFAULT_VALUE_FOR_LONG = 0;
    public static final String DEFAULT_VALUE_FOR_STRING = "";
    public static final int LAST_FETCH_STATUS_FAILURE = 1;
    public static final int LAST_FETCH_STATUS_NO_FETCH_YET = 0;
    public static final int LAST_FETCH_STATUS_SUCCESS = -1;
    public static final int LAST_FETCH_STATUS_THROTTLED = 2;
    public static final String TAG = "FirebaseRemoteConfig";
    public static final int VALUE_SOURCE_DEFAULT = 1;
    public static final int VALUE_SOURCE_REMOTE = 2;
    public static final int VALUE_SOURCE_STATIC = 0;
    private final ConfigCacheClient activatedConfigsCache;
    private final Context context;
    private final ConfigCacheClient defaultConfigsCache;
    private final Executor executor;
    private final ConfigFetchHandler fetchHandler;
    private final ConfigCacheClient fetchedConfigsCache;
    private final FirebaseABTesting firebaseAbt;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final ConfigMetadataClient frcMetadata;
    private final ConfigGetParameterHandler getHandler;

    public static FirebaseRemoteConfig getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    public static FirebaseRemoteConfig getInstance(FirebaseApp firebaseApp) {
        return ((RemoteConfigComponent) firebaseApp.get(RemoteConfigComponent.class)).getDefault();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseRemoteConfig(Context context, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, Executor executor, ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2, ConfigCacheClient configCacheClient3, ConfigFetchHandler configFetchHandler, ConfigGetParameterHandler configGetParameterHandler, ConfigMetadataClient configMetadataClient) {
        this.context = context;
        this.firebaseApp = firebaseApp;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.firebaseAbt = firebaseABTesting;
        this.executor = executor;
        this.fetchedConfigsCache = configCacheClient;
        this.activatedConfigsCache = configCacheClient2;
        this.defaultConfigsCache = configCacheClient3;
        this.fetchHandler = configFetchHandler;
        this.getHandler = configGetParameterHandler;
        this.frcMetadata = configMetadataClient;
    }

    public Task<FirebaseRemoteConfigInfo> ensureInitialized() {
        Task<ConfigContainer> task = this.activatedConfigsCache.get();
        Task<ConfigContainer> task2 = this.defaultConfigsCache.get();
        Task<ConfigContainer> task3 = this.fetchedConfigsCache.get();
        final Task call = Tasks.call(this.executor, new Callable() { // from class: com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return FirebaseRemoteConfig.this.getInfo();
            }
        });
        return Tasks.whenAllComplete(task, task2, task3, call, this.firebaseInstallations.getId(), this.firebaseInstallations.getToken(false)).continueWith(this.executor, new Continuation() { // from class: com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda5
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task4) {
                return FirebaseRemoteConfig.lambda$ensureInitialized$0(Task.this, task4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ FirebaseRemoteConfigInfo lambda$ensureInitialized$0(Task task, Task task2) throws Exception {
        return (FirebaseRemoteConfigInfo) task.getResult();
    }

    public Task<Boolean> fetchAndActivate() {
        return fetch().onSuccessTask(this.executor, new SuccessContinuation() { // from class: com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda7
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return FirebaseRemoteConfig.this.m201xebd5994c((Void) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$fetchAndActivate$1$com-google-firebase-remoteconfig-FirebaseRemoteConfig  reason: not valid java name */
    public /* synthetic */ Task m201xebd5994c(Void r1) throws Exception {
        return activate();
    }

    public Task<Boolean> activate() {
        final Task<ConfigContainer> task = this.fetchedConfigsCache.get();
        final Task<ConfigContainer> task2 = this.activatedConfigsCache.get();
        return Tasks.whenAllComplete(task, task2).continueWithTask(this.executor, new Continuation() { // from class: com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda9
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task3) {
                return FirebaseRemoteConfig.this.m200x98ca96b0(task, task2, task3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$activate$2$com-google-firebase-remoteconfig-FirebaseRemoteConfig  reason: not valid java name */
    public /* synthetic */ Task m200x98ca96b0(Task task, Task task2, Task task3) throws Exception {
        boolean isSuccessful = task.isSuccessful();
        Boolean bool = Boolean.FALSE;
        if (!isSuccessful || task.getResult() == null) {
            return Tasks.forResult(bool);
        }
        ConfigContainer configContainer = (ConfigContainer) task.getResult();
        if (task2.isSuccessful() && !isFetchedFresh(configContainer, (ConfigContainer) task2.getResult())) {
            return Tasks.forResult(bool);
        }
        return this.activatedConfigsCache.put(configContainer).continueWith(this.executor, new Continuation() { // from class: com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda8
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task4) {
                boolean processActivatePutTask;
                processActivatePutTask = FirebaseRemoteConfig.this.processActivatePutTask(task4);
                return Boolean.valueOf(processActivatePutTask);
            }
        });
    }

    public Task<Void> fetch() {
        return this.fetchHandler.fetch().onSuccessTask(new SuccessContinuation() { // from class: com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda3
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                Task forResult;
                ConfigFetchHandler.FetchResponse fetchResponse = (ConfigFetchHandler.FetchResponse) obj;
                forResult = Tasks.forResult(null);
                return forResult;
            }
        });
    }

    public Task<Void> fetch(long j) {
        return this.fetchHandler.fetch(j).onSuccessTask(new SuccessContinuation() { // from class: com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                Task forResult;
                ConfigFetchHandler.FetchResponse fetchResponse = (ConfigFetchHandler.FetchResponse) obj;
                forResult = Tasks.forResult(null);
                return forResult;
            }
        });
    }

    public String getString(String str) {
        return this.getHandler.getString(str);
    }

    public boolean getBoolean(String str) {
        return this.getHandler.getBoolean(str);
    }

    public double getDouble(String str) {
        return this.getHandler.getDouble(str);
    }

    public long getLong(String str) {
        return this.getHandler.getLong(str);
    }

    public FirebaseRemoteConfigValue getValue(String str) {
        return this.getHandler.getValue(str);
    }

    public Set<String> getKeysByPrefix(String str) {
        return this.getHandler.getKeysByPrefix(str);
    }

    public Map<String, FirebaseRemoteConfigValue> getAll() {
        return this.getHandler.getAll();
    }

    public FirebaseRemoteConfigInfo getInfo() {
        return this.frcMetadata.getInfo();
    }

    public Task<Void> setConfigSettingsAsync(final FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        return Tasks.call(this.executor, new Callable() { // from class: com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return FirebaseRemoteConfig.this.m203xd6203cf5(firebaseRemoteConfigSettings);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setConfigSettingsAsync$5$com-google-firebase-remoteconfig-FirebaseRemoteConfig  reason: not valid java name */
    public /* synthetic */ Void m203xd6203cf5(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) throws Exception {
        this.frcMetadata.setConfigSettings(firebaseRemoteConfigSettings);
        return null;
    }

    public Task<Void> setDefaultsAsync(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                hashMap.put(entry.getKey(), new String((byte[]) value));
            } else {
                hashMap.put(entry.getKey(), value.toString());
            }
        }
        return setDefaultsWithStringsMapAsync(hashMap);
    }

    public Task<Void> setDefaultsAsync(int i) {
        return setDefaultsWithStringsMapAsync(DefaultsXmlParser.getDefaultsFromXml(this.context, i));
    }

    public Task<Void> reset() {
        return Tasks.call(this.executor, new Callable() { // from class: com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return FirebaseRemoteConfig.this.m202xf98246b6();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$reset$6$com-google-firebase-remoteconfig-FirebaseRemoteConfig  reason: not valid java name */
    public /* synthetic */ Void m202xf98246b6() throws Exception {
        this.activatedConfigsCache.clear();
        this.fetchedConfigsCache.clear();
        this.defaultConfigsCache.clear();
        this.frcMetadata.clear();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startLoadingConfigsFromDisk() {
        this.activatedConfigsCache.get();
        this.defaultConfigsCache.get();
        this.fetchedConfigsCache.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean processActivatePutTask(Task<ConfigContainer> task) {
        if (task.isSuccessful()) {
            this.fetchedConfigsCache.clear();
            if (task.getResult() != null) {
                updateAbtWithActivatedExperiments(task.getResult().getAbtExperiments());
                return true;
            }
            InstrumentInjector.log_e(TAG, "Activated configs written to disk are null.");
            return true;
        }
        return false;
    }

    private Task<Void> setDefaultsWithStringsMapAsync(Map<String, String> map) {
        try {
            return this.defaultConfigsCache.put(ConfigContainer.newBuilder().replaceConfigsWith(map).build()).onSuccessTask(new SuccessContinuation() { // from class: com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda0
                @Override // com.google.android.gms.tasks.SuccessContinuation
                public final Task then(Object obj) {
                    Task forResult;
                    ConfigContainer configContainer = (ConfigContainer) obj;
                    forResult = Tasks.forResult(null);
                    return forResult;
                }
            });
        } catch (JSONException e) {
            InstrumentInjector.log_e(TAG, "The provided defaults map could not be processed.", e);
            return Tasks.forResult(null);
        }
    }

    void updateAbtWithActivatedExperiments(JSONArray jSONArray) {
        if (this.firebaseAbt == null) {
            return;
        }
        try {
            this.firebaseAbt.replaceAllExperiments(toExperimentInfoMaps(jSONArray));
        } catch (AbtException e) {
            InstrumentInjector.log_w(TAG, "Could not update ABT experiments.", e);
        } catch (JSONException e2) {
            InstrumentInjector.log_e(TAG, "Could not parse ABT experiments from the JSON response.", e2);
        }
    }

    static List<Map<String, String>> toExperimentInfoMaps(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    private static boolean isFetchedFresh(ConfigContainer configContainer, ConfigContainer configContainer2) {
        return configContainer2 == null || !configContainer.getFetchTime().equals(configContainer2.getFetchTime());
    }
}
