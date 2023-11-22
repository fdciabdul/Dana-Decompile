package id.dana.data.config.source.sharedpreference;

import com.google.gson.Gson;
import id.dana.data.config.source.split.DefaultAppVersionGenerator;
import id.dana.data.config.source.split.DefaultStartupConfigGenerator;
import id.dana.data.storage.PreferenceFacade;
import id.dana.domain.featureconfig.StartupConfigEntityData;
import id.dana.domain.featureconfig.model.AnbuConfig;
import id.dana.domain.featureconfig.model.DiagnosticLogConfig;
import id.dana.domain.featureconfig.model.QueryUserDataConfig;
import id.dana.domain.featureconfig.model.StartupConfig;
import id.dana.domain.version.Version;
import id.dana.utils.config.model.NetworkLoggingConfig;
import id.dana.utils.holdlogin.v2.model.FeatureHoldLoginConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 H2\u00020\u0001:\u0001HB\u001b\b\u0007\u0012\b\b\u0001\u0010D\u001a\u00020C\u0012\u0006\u00109\u001a\u000208¢\u0006\u0004\bF\u0010GJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u0014J\u000f\u0010\u001f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001f\u0010\u0014J\u0017\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0007H\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\nH\u0016¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\r¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0010H\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0002H\u0016¢\u0006\u0004\b-\u0010\u0006J\u0015\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0015¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u0018H\u0016¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u001bH\u0016¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0002H\u0016¢\u0006\u0004\b7\u0010\u0006R\u0014\u00109\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R \u0010>\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020=0;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010A\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010D\u001a\u00020C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010E"}, d2 = {"Lid/dana/data/config/source/sharedpreference/SharedPrefStartupConfig;", "Lid/dana/domain/featureconfig/StartupConfigEntityData;", "", "b", "", "cancelAllWorkDone", "(Z)V", "Lid/dana/domain/featureconfig/model/AnbuConfig;", "getAnbuConfig", "()Lid/dana/domain/featureconfig/model/AnbuConfig;", "Lid/dana/domain/version/Version;", "getAppVersion", "()Lid/dana/domain/version/Version;", "Lid/dana/domain/featureconfig/model/DiagnosticLogConfig;", "getDiagnosticLog", "()Lid/dana/domain/featureconfig/model/DiagnosticLogConfig;", "Lid/dana/utils/holdlogin/v2/model/FeatureHoldLoginConfig;", "getHoldLoginConfig", "()Lid/dana/utils/holdlogin/v2/model/FeatureHoldLoginConfig;", "getMixpanelEnable", "()Z", "Lid/dana/utils/config/model/NetworkLoggingConfig;", "getNetworkLogging", "()Lid/dana/utils/config/model/NetworkLoggingConfig;", "Lid/dana/domain/featureconfig/model/QueryUserDataConfig;", "getQueryUserDataConfig", "()Lid/dana/domain/featureconfig/model/QueryUserDataConfig;", "Lid/dana/domain/featureconfig/model/StartupConfig;", "getStartupConfig", "()Lid/dana/domain/featureconfig/model/StartupConfig;", "getWarmStartTrackingEnable", "isCancelAllWorkDone", "it", "saveAnbuConfig", "(Lid/dana/domain/featureconfig/model/AnbuConfig;)V", "version", "setAppVersion", "(Lid/dana/domain/version/Version;)V", "diagnosticLogConfig", "setDiagnosticLog", "(Lid/dana/domain/featureconfig/model/DiagnosticLogConfig;)V", "featureHoldLoginConfig", "setHoldLoginConfig", "(Lid/dana/utils/holdlogin/v2/model/FeatureHoldLoginConfig;)V", "enable", "setMixpanelEnable", "networkLoggingConfig", "setNetworkLogging", "(Lid/dana/utils/config/model/NetworkLoggingConfig;)V", "queryUserDataConfig", "setQueryUserDataConfig", "(Lid/dana/domain/featureconfig/model/QueryUserDataConfig;)V", "startupConfig", "setStartupConfig", "(Lid/dana/domain/featureconfig/model/StartupConfig;)V", "setWarmStartTrackingEnable", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "", "", "", "inMemoryCache", "Ljava/util/Map;", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lid/dana/data/storage/PreferenceFacade;", "preferenceFacade", "Lid/dana/data/storage/PreferenceFacade;", "<init>", "(Lid/dana/data/storage/PreferenceFacade;Lcom/google/gson/Gson;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SharedPrefStartupConfig implements StartupConfigEntityData {
    public static final String ANBU_CONFIG_KEY = "anbuconfig";
    public static final String APP_VERSION_KEY = "appversionkey";
    public static final String CANCEL_ALL_WORK_ONE_TIME = "cancelAllWorkOneTime";
    public static final String DIAGNOSTIC_LOG_CONFIG = "diagnosticlogkey";
    public static final String FEATURE_HOLD_LOGIN_CONFIG = "featureholdloginconfig";
    public static final String FEATURE_HOLD_LOGIN_V2 = "featureholdloginv2";
    public static final String FEATURE_MIXPANEL = "featuremixpanel";
    public static final String FEATURE_TOGGLE_PREF = "featuretoggleprefkey";
    public static final String FULLSTORY_SESSION_PREF = "fullstorySessionPref";
    public static final String NETWORK_LOGGING_CONFIG = "networkconfigkey";
    public static final String QUERY_USER_DATA_CONFIG = "queryuserdataconfig";
    public static final String STARTUP_CONFIG_KEY = "startupconfigkey";
    public static final String WARM_START_KEY = "togglewarmstart";
    private final Gson gson;
    private final Map<String, Object> inMemoryCache;
    private final ReentrantLock lock;
    private final PreferenceFacade preferenceFacade;

    @Inject
    public SharedPrefStartupConfig(@Named("startuppref") PreferenceFacade preferenceFacade, Gson gson) {
        Intrinsics.checkNotNullParameter(preferenceFacade, "");
        Intrinsics.checkNotNullParameter(gson, "");
        this.preferenceFacade = preferenceFacade;
        this.gson = gson;
        this.inMemoryCache = new LinkedHashMap();
        this.lock = new ReentrantLock();
    }

    @Override // id.dana.domain.featureconfig.StartupConfigEntityData
    public final void setWarmStartTrackingEnable(boolean enable) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.inMemoryCache.put(WARM_START_KEY, Boolean.valueOf(enable));
            this.preferenceFacade.saveData(WARM_START_KEY, Boolean.valueOf(enable));
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // id.dana.domain.featureconfig.StartupConfigEntityData
    public final boolean getWarmStartTrackingEnable() {
        boolean booleanValue;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object obj = this.inMemoryCache.get(WARM_START_KEY);
            Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
            if (bool != null) {
                booleanValue = bool.booleanValue();
            } else {
                Boolean bool2 = this.preferenceFacade.getBoolean(WARM_START_KEY, false);
                Map<String, Object> map = this.inMemoryCache;
                Intrinsics.checkNotNullExpressionValue(bool2, "");
                map.put(WARM_START_KEY, bool2);
                Intrinsics.checkNotNullExpressionValue(bool2, "");
                booleanValue = bool2.booleanValue();
            }
            return booleanValue;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // id.dana.domain.featureconfig.StartupConfigEntityData
    public final boolean getMixpanelEnable() {
        boolean booleanValue;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object obj = this.inMemoryCache.get(FEATURE_MIXPANEL);
            Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
            if (bool != null) {
                booleanValue = bool.booleanValue();
            } else {
                Boolean bool2 = this.preferenceFacade.getBoolean(FEATURE_MIXPANEL, true);
                Map<String, Object> map = this.inMemoryCache;
                Intrinsics.checkNotNullExpressionValue(bool2, "");
                map.put(FEATURE_MIXPANEL, bool2);
                Intrinsics.checkNotNullExpressionValue(bool2, "");
                booleanValue = bool2.booleanValue();
            }
            return booleanValue;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // id.dana.domain.featureconfig.StartupConfigEntityData
    public final void setMixpanelEnable(boolean enable) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.inMemoryCache.put(FEATURE_MIXPANEL, Boolean.valueOf(enable));
            this.preferenceFacade.saveData(FEATURE_MIXPANEL, Boolean.valueOf(enable));
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // id.dana.domain.featureconfig.StartupConfigEntityData
    public final void setAppVersion(Version version) {
        Intrinsics.checkNotNullParameter(version, "");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.inMemoryCache.put(APP_VERSION_KEY, version);
            this.preferenceFacade.saveData(APP_VERSION_KEY, this.gson.toJson(version));
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // id.dana.domain.featureconfig.StartupConfigEntityData
    public final void saveAnbuConfig(AnbuConfig it) {
        Intrinsics.checkNotNullParameter(it, "");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.inMemoryCache.put(ANBU_CONFIG_KEY, it);
            this.preferenceFacade.saveData(ANBU_CONFIG_KEY, this.gson.toJson(it));
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // id.dana.domain.featureconfig.StartupConfigEntityData
    public final AnbuConfig getAnbuConfig() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object obj = this.inMemoryCache.get(ANBU_CONFIG_KEY);
            AnbuConfig anbuConfig = null;
            AnbuConfig anbuConfig2 = obj instanceof AnbuConfig ? (AnbuConfig) obj : null;
            if (anbuConfig2 == null) {
                String string = this.preferenceFacade.getString(ANBU_CONFIG_KEY);
                if (string != null) {
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    try {
                        Object fromJson = this.gson.fromJson(string, (Class<Object>) AnbuConfig.class);
                        AnbuConfig anbuConfig3 = (AnbuConfig) fromJson;
                        Map<String, Object> map = this.inMemoryCache;
                        Intrinsics.checkNotNullExpressionValue(anbuConfig3, "");
                        map.put(ANBU_CONFIG_KEY, anbuConfig3);
                        anbuConfig = (AnbuConfig) fromJson;
                    } catch (Exception unused) {
                        anbuConfig = new AnbuConfig(Boolean.FALSE);
                    }
                }
                anbuConfig2 = anbuConfig == null ? new AnbuConfig(Boolean.FALSE) : anbuConfig;
            }
            return anbuConfig2;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // id.dana.domain.featureconfig.StartupConfigEntityData
    public final Version getAppVersion() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object obj = this.inMemoryCache.get(APP_VERSION_KEY);
            Version version = null;
            Version version2 = obj instanceof Version ? (Version) obj : null;
            if (version2 == null) {
                String string = this.preferenceFacade.getString(APP_VERSION_KEY);
                if (string != null) {
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    try {
                        Object fromJson = this.gson.fromJson(string, (Class<Object>) Version.class);
                        Version version3 = (Version) fromJson;
                        Map<String, Object> map = this.inMemoryCache;
                        Intrinsics.checkNotNullExpressionValue(version3, "");
                        map.put(APP_VERSION_KEY, version3);
                        version = (Version) fromJson;
                    } catch (Exception unused) {
                        version = DefaultAppVersionGenerator.INSTANCE.generate();
                    }
                }
                version2 = version == null ? DefaultAppVersionGenerator.INSTANCE.generate() : version;
            }
            return version2;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // id.dana.domain.featureconfig.StartupConfigEntityData
    public final void setStartupConfig(StartupConfig startupConfig) {
        Intrinsics.checkNotNullParameter(startupConfig, "");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.inMemoryCache.put(STARTUP_CONFIG_KEY, startupConfig);
            this.preferenceFacade.saveData(STARTUP_CONFIG_KEY, this.gson.toJson(startupConfig));
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // id.dana.domain.featureconfig.StartupConfigEntityData
    public final StartupConfig getStartupConfig() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object obj = this.inMemoryCache.get(STARTUP_CONFIG_KEY);
            StartupConfig startupConfig = null;
            StartupConfig startupConfig2 = obj instanceof StartupConfig ? (StartupConfig) obj : null;
            if (startupConfig2 == null) {
                String string = this.preferenceFacade.getString(STARTUP_CONFIG_KEY);
                if (string != null) {
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    try {
                        Object fromJson = this.gson.fromJson(string, (Class<Object>) StartupConfig.class);
                        StartupConfig startupConfig3 = (StartupConfig) fromJson;
                        Map<String, Object> map = this.inMemoryCache;
                        Intrinsics.checkNotNullExpressionValue(startupConfig3, "");
                        map.put(STARTUP_CONFIG_KEY, startupConfig3);
                        startupConfig = (StartupConfig) fromJson;
                    } catch (Exception unused) {
                        startupConfig = DefaultStartupConfigGenerator.INSTANCE.generate().toStartupConfig();
                    }
                }
                startupConfig2 = startupConfig == null ? DefaultStartupConfigGenerator.INSTANCE.generate().toStartupConfig() : startupConfig;
            }
            return startupConfig2;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void setNetworkLogging(NetworkLoggingConfig networkLoggingConfig) {
        Intrinsics.checkNotNullParameter(networkLoggingConfig, "");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            networkLoggingConfig.PlaceComponentResult = Long.valueOf(System.currentTimeMillis());
            this.inMemoryCache.put(NETWORK_LOGGING_CONFIG, networkLoggingConfig);
            this.preferenceFacade.saveData(NETWORK_LOGGING_CONFIG, this.gson.toJson(networkLoggingConfig));
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void setDiagnosticLog(DiagnosticLogConfig diagnosticLogConfig) {
        Intrinsics.checkNotNullParameter(diagnosticLogConfig, "");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            diagnosticLogConfig.setLastUpdatedTime(Long.valueOf(System.currentTimeMillis()));
            this.inMemoryCache.put(DIAGNOSTIC_LOG_CONFIG, diagnosticLogConfig);
            this.preferenceFacade.saveData(DIAGNOSTIC_LOG_CONFIG, this.gson.toJson(diagnosticLogConfig));
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // id.dana.domain.featureconfig.StartupConfigEntityData
    public final DiagnosticLogConfig getDiagnosticLog() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object obj = this.inMemoryCache.get(DIAGNOSTIC_LOG_CONFIG);
            DiagnosticLogConfig diagnosticLogConfig = null;
            DiagnosticLogConfig diagnosticLogConfig2 = obj instanceof DiagnosticLogConfig ? (DiagnosticLogConfig) obj : null;
            if (diagnosticLogConfig2 == null) {
                String string = this.preferenceFacade.getString(DIAGNOSTIC_LOG_CONFIG);
                if (string != null) {
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    try {
                        Object fromJson = this.gson.fromJson(string, (Class<Object>) DiagnosticLogConfig.class);
                        DiagnosticLogConfig diagnosticLogConfig3 = (DiagnosticLogConfig) fromJson;
                        Map<String, Object> map = this.inMemoryCache;
                        Intrinsics.checkNotNullExpressionValue(diagnosticLogConfig3, "");
                        map.put(DIAGNOSTIC_LOG_CONFIG, diagnosticLogConfig3);
                        diagnosticLogConfig = (DiagnosticLogConfig) fromJson;
                    } catch (Exception unused) {
                        diagnosticLogConfig = new DiagnosticLogConfig(false, false, null, null, 15, null);
                    }
                }
                diagnosticLogConfig2 = diagnosticLogConfig == null ? new DiagnosticLogConfig(false, false, null, null, 15, null) : diagnosticLogConfig;
            }
            return diagnosticLogConfig2;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final NetworkLoggingConfig getNetworkLogging() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object obj = this.inMemoryCache.get(NETWORK_LOGGING_CONFIG);
            NetworkLoggingConfig networkLoggingConfig = null;
            NetworkLoggingConfig networkLoggingConfig2 = obj instanceof NetworkLoggingConfig ? (NetworkLoggingConfig) obj : null;
            if (networkLoggingConfig2 == null) {
                String string = this.preferenceFacade.getString(NETWORK_LOGGING_CONFIG);
                if (string != null) {
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    try {
                        Object fromJson = this.gson.fromJson(string, (Class<Object>) NetworkLoggingConfig.class);
                        NetworkLoggingConfig networkLoggingConfig3 = (NetworkLoggingConfig) fromJson;
                        Map<String, Object> map = this.inMemoryCache;
                        Intrinsics.checkNotNullExpressionValue(networkLoggingConfig3, "");
                        map.put(NETWORK_LOGGING_CONFIG, networkLoggingConfig3);
                        networkLoggingConfig = (NetworkLoggingConfig) fromJson;
                    } catch (Exception unused) {
                        networkLoggingConfig = new NetworkLoggingConfig(false, null, null, 6, null);
                    }
                }
                networkLoggingConfig2 = networkLoggingConfig == null ? new NetworkLoggingConfig(false, null, null, 6, null) : networkLoggingConfig;
            }
            return networkLoggingConfig2;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // id.dana.domain.featureconfig.StartupConfigEntityData
    public final void setQueryUserDataConfig(QueryUserDataConfig queryUserDataConfig) {
        Intrinsics.checkNotNullParameter(queryUserDataConfig, "");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.inMemoryCache.put(QUERY_USER_DATA_CONFIG, queryUserDataConfig);
            this.preferenceFacade.saveData(QUERY_USER_DATA_CONFIG, this.gson.toJson(queryUserDataConfig));
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // id.dana.domain.featureconfig.StartupConfigEntityData
    public final QueryUserDataConfig getQueryUserDataConfig() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object obj = this.inMemoryCache.get(QUERY_USER_DATA_CONFIG);
            QueryUserDataConfig queryUserDataConfig = null;
            QueryUserDataConfig queryUserDataConfig2 = obj instanceof QueryUserDataConfig ? (QueryUserDataConfig) obj : null;
            if (queryUserDataConfig2 == null) {
                String string = this.preferenceFacade.getString(QUERY_USER_DATA_CONFIG);
                if (string != null) {
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    try {
                        Object fromJson = this.gson.fromJson(string, (Class<Object>) QueryUserDataConfig.class);
                        QueryUserDataConfig queryUserDataConfig3 = (QueryUserDataConfig) fromJson;
                        Map<String, Object> map = this.inMemoryCache;
                        Intrinsics.checkNotNullExpressionValue(queryUserDataConfig3, "");
                        map.put(QUERY_USER_DATA_CONFIG, queryUserDataConfig3);
                        queryUserDataConfig = (QueryUserDataConfig) fromJson;
                    } catch (Exception unused) {
                        queryUserDataConfig = new QueryUserDataConfig(false, null, false, false, false, 31, null);
                    }
                }
                queryUserDataConfig2 = queryUserDataConfig == null ? new QueryUserDataConfig(false, null, false, false, false, 31, null) : queryUserDataConfig;
            }
            return queryUserDataConfig2;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // id.dana.domain.featureconfig.StartupConfigEntityData
    public final void setHoldLoginConfig(FeatureHoldLoginConfig featureHoldLoginConfig) {
        Intrinsics.checkNotNullParameter(featureHoldLoginConfig, "");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.inMemoryCache.put(FEATURE_HOLD_LOGIN_CONFIG, featureHoldLoginConfig);
            this.preferenceFacade.saveData(FEATURE_HOLD_LOGIN_CONFIG, this.gson.toJson(featureHoldLoginConfig));
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // id.dana.domain.featureconfig.StartupConfigEntityData
    public final FeatureHoldLoginConfig getHoldLoginConfig() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object obj = this.inMemoryCache.get(FEATURE_HOLD_LOGIN_CONFIG);
            FeatureHoldLoginConfig featureHoldLoginConfig = null;
            FeatureHoldLoginConfig featureHoldLoginConfig2 = obj instanceof FeatureHoldLoginConfig ? (FeatureHoldLoginConfig) obj : null;
            if (featureHoldLoginConfig2 == null) {
                String string = this.preferenceFacade.getString(FEATURE_HOLD_LOGIN_CONFIG);
                if (string != null) {
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    try {
                        Object fromJson = this.gson.fromJson(string, (Class<Object>) FeatureHoldLoginConfig.class);
                        FeatureHoldLoginConfig featureHoldLoginConfig3 = (FeatureHoldLoginConfig) fromJson;
                        Map<String, Object> map = this.inMemoryCache;
                        Intrinsics.checkNotNullExpressionValue(featureHoldLoginConfig3, "");
                        map.put(FEATURE_HOLD_LOGIN_CONFIG, featureHoldLoginConfig3);
                        featureHoldLoginConfig = (FeatureHoldLoginConfig) fromJson;
                    } catch (Exception unused) {
                        featureHoldLoginConfig = new FeatureHoldLoginConfig(false, null, 0L, 0, 0L, 0, null, false, false, false, 1023, null);
                    }
                }
                featureHoldLoginConfig2 = featureHoldLoginConfig == null ? new FeatureHoldLoginConfig(false, null, 0L, 0, 0L, 0, null, false, false, false, 1023, null) : featureHoldLoginConfig;
            }
            return featureHoldLoginConfig2;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // id.dana.domain.featureconfig.StartupConfigEntityData
    public final boolean isCancelAllWorkDone() {
        boolean booleanValue;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object obj = this.inMemoryCache.get(CANCEL_ALL_WORK_ONE_TIME);
            Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
            if (bool != null) {
                booleanValue = bool.booleanValue();
            } else {
                Boolean bool2 = this.preferenceFacade.getBoolean(CANCEL_ALL_WORK_ONE_TIME, false);
                Map<String, Object> map = this.inMemoryCache;
                Intrinsics.checkNotNullExpressionValue(bool2, "");
                map.put(CANCEL_ALL_WORK_ONE_TIME, bool2);
                Intrinsics.checkNotNullExpressionValue(bool2, "");
                booleanValue = bool2.booleanValue();
            }
            return booleanValue;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // id.dana.domain.featureconfig.StartupConfigEntityData
    public final void cancelAllWorkDone(boolean b) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.inMemoryCache.put(CANCEL_ALL_WORK_ONE_TIME, Boolean.valueOf(b));
            this.preferenceFacade.saveData(CANCEL_ALL_WORK_ONE_TIME, Boolean.valueOf(b));
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }
}
