package com.iap.ac.config.lite;

import android.text.TextUtils;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.config.lite.d.d;
import com.iap.ac.config.lite.d.e;
import com.iap.ac.config.lite.d.f;
import com.iap.ac.config.lite.listener.ConfigChangeType;
import com.iap.ac.config.lite.listener.IAnyCommonConfigListener;
import com.iap.ac.config.lite.listener.commonconfig.ICommonConfigListener;
import com.iap.ac.config.lite.listener.sectionconfig.ChangedDetails;
import com.iap.ac.config.lite.listener.sectionconfig.ISectionConfigListener;
import com.iap.ac.config.lite.utils.ConfigUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class ConfigMerger extends ConfigGetter {
    public static final String COMMON_CONFIG_SECTION = "config";
    private static final String f = e.b("ConfigMerger");
    protected JSONObject mCachedConfigs;
    protected final Object mConfigLock = new Object();
    private final d b = new d();
    private final com.iap.ac.config.lite.d.b c = new com.iap.ac.config.lite.d.b();
    private final f d = new f();
    private final List<IAnyCommonConfigListener> e = Collections.synchronizedList(new ArrayList());
    protected Status mStatus = Status.INVALID;
    protected long mCurrentConfigVersion = 0;

    /* loaded from: classes3.dex */
    public static class MergeChangeResult {
        public List<com.iap.ac.config.lite.d.a> changedList = new ArrayList();
        public Set<String> valueNotChangedList = new HashSet();
    }

    /* loaded from: classes3.dex */
    public enum Status {
        INVALID,
        INITIALIZED,
        SHUTDOWN;

        public final boolean isInitialized() {
            return this == INITIALIZED;
        }

        public final boolean isInitializedOrShutdown() {
            return isInitialized() || isShutdown();
        }

        public final boolean isShutdown() {
            return this == SHUTDOWN;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f7615a;

        a(String str) {
            this.f7615a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            ConfigMerger.this.saveConfigInternal(this.f7615a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MergeChangeResult f7616a;

        b(MergeChangeResult mergeChangeResult) {
            this.f7616a = mergeChangeResult;
        }

        @Override // java.lang.Runnable
        public void run() {
            ConfigMerger.this.a(this.f7616a.changedList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends ConfigGetter {
        final /* synthetic */ JSONObject b;

        c(ConfigMerger configMerger, JSONObject jSONObject) {
            this.b = jSONObject;
        }

        @Override // com.iap.ac.config.lite.ConfigGetter
        protected JSONObject getConfigInternal() {
            return this.b;
        }
    }

    private void a() {
        synchronized (this.mConfigLock) {
            if (this.mCachedConfigs == null) {
                this.mCachedConfigs = new JSONObject();
                this.mCurrentConfigVersion = 0L;
            }
            try {
                if (this.mCachedConfigs.optJSONObject("config") == null) {
                    this.mCachedConfigs.put("config", new JSONObject());
                }
            } catch (JSONException e) {
                ACLog.w(f, "ensureCachedConfigs: init cached failed!", e);
            }
        }
    }

    private ConfigChangeType b(String str, String str2, Object obj, boolean z) {
        JSONObject optJSONObject;
        Object opt;
        boolean z2;
        boolean z3;
        try {
            optJSONObject = this.mCachedConfigs.optJSONObject(str);
            opt = optJSONObject.opt(str2);
        } catch (JSONException e) {
            ACLog.w(f, "tryMergeConfigItem: failed!", e);
        }
        if (opt == null) {
            ACLog.i(f, String.format("**SET** Value for this key is not exists, will set it and return. key = %s", str2));
            optJSONObject.put(str2, obj);
            return ConfigChangeType.ADDED;
        } else if (a(str2, obj, opt)) {
            return ConfigChangeType.VALUE_NOT_CHANGED;
        } else {
            if (this.b.a(str)) {
                z2 = this.b.a(str, str2, opt, obj);
                z3 = true;
            } else {
                z2 = true;
                z3 = false;
            }
            if (!z2) {
                ACLog.e(f, String.format("**INTERCEPTED** This config was intercepted by another interceptor. will not change! key = %s", str2));
                return null;
            } else if (!z && !z3) {
                ACLog.w(f, String.format("**ALREADY-HAVE-WHEN-MANUAL-MERGE** Already has this config value, and now is manual merge, will skip it! key = %s.", str2));
                return null;
            } else {
                ACLog.i(f, String.format("**SET-FINALLY** This config was not intercepted, will set it! key = %s", str2));
                optJSONObject.put(str2, obj);
                return ConfigChangeType.MODIFIED;
            }
        }
    }

    public static boolean isCommonConfigSection(String str) {
        return TextUtils.isEmpty(str) || "config".equals(str);
    }

    public void addCommonConfigListener(String str, ICommonConfigListener iCommonConfigListener) {
        this.c.a(str, iCommonConfigListener);
    }

    public void addForAnyCommonConfigListener(IAnyCommonConfigListener iAnyCommonConfigListener) {
        this.e.add(iAnyCommonConfigListener);
    }

    public void addOverwriteInterceptor(String str, ConfigOverwriteInterceptor configOverwriteInterceptor) {
        this.b.a(str, configOverwriteInterceptor);
    }

    public void addSectionConfigListener(String str, ISectionConfigListener iSectionConfigListener) {
        this.d.a(str, iSectionConfigListener);
    }

    public void clearCommonConfigListeners() {
        this.c.a();
    }

    public void clearConfigInterceptors() {
        this.b.a();
    }

    public void clearForAnyCommonConfigListeners() {
        this.e.clear();
    }

    public void clearSectionConfigListeners() {
        this.d.a();
    }

    @Override // com.iap.ac.config.lite.ConfigGetter
    protected JSONObject getConfigInternal() {
        JSONObject optJSONObject;
        if (isShutdown()) {
            return null;
        }
        synchronized (this.mConfigLock) {
            JSONObject jSONObject = this.mCachedConfigs;
            optJSONObject = jSONObject != null ? jSONObject.optJSONObject("config") : null;
        }
        return optJSONObject;
    }

    public long getLastUpdateVersion() {
        String str = f;
        StringBuilder sb = new StringBuilder();
        sb.append("get: getLastUpdateVersion = ");
        sb.append(ConfigUtils.formatConfigVersionWithTime(this.mCurrentConfigVersion));
        ACLog.v(str, sb.toString());
        return this.mCurrentConfigVersion;
    }

    public JSONObject getSectionConfig(String str) {
        if (isShutdown()) {
            return null;
        }
        synchronized (this.mConfigLock) {
            if (this.mCachedConfigs != null && !TextUtils.isEmpty(str)) {
                JSONObject optJSONObject = this.mCachedConfigs.optJSONObject(str);
                return optJSONObject != null ? (JSONObject) ConfigUtils.deepCopyObject(optJSONObject) : null;
            }
            return null;
        }
    }

    public ConfigGetter getSectionConfigGetter(String str) {
        JSONObject sectionConfig = getSectionConfig(str);
        if (sectionConfig == null) {
            return null;
        }
        return new c(this, sectionConfig);
    }

    public JSONObject getSectionConfigObjects() {
        JSONObject jSONObject;
        if (isShutdown() || (jSONObject = this.mCachedConfigs) == null) {
            return null;
        }
        JSONObject jSONObject2 = (JSONObject) ConfigUtils.deepCopyObject(jSONObject);
        jSONObject2.remove("config");
        return jSONObject2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initializeWithCache(String str) {
        synchronized (this.mConfigLock) {
            this.mCachedConfigs = null;
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = (JSONObject) JsonUtils.fromJson(str, JSONObject.class);
                    if (jSONObject != null) {
                        this.mCurrentConfigVersion = jSONObject.optLong("_version", 0L);
                        JSONObject jSONObject2 = jSONObject.getJSONObject("_data");
                        this.mCachedConfigs = jSONObject2;
                        ACLog.i(f, String.format("** Cached config has %d items.", Integer.valueOf(jSONObject2 != null ? jSONObject2.length() : 0)));
                    }
                } catch (Exception e) {
                    ACLog.e(f, String.format("Parse cached config FAILED! message = %s.", e.getMessage()));
                }
            }
            a();
        }
    }

    public boolean isInitialized() {
        return this.mStatus.isInitialized();
    }

    public boolean isShutdown() {
        return this.mStatus.isShutdown();
    }

    public boolean mergeCommonConfig(JSONObject jSONObject) {
        return mergeConfig(null, jSONObject);
    }

    public boolean mergeConfig(String str, JSONObject jSONObject) {
        return mergeConfigAdvanced(str, jSONObject, false, false);
    }

    public boolean mergeConfigAdvanced(String str, JSONObject jSONObject, boolean z, boolean z2, boolean z3) {
        if (TextUtils.isEmpty(str)) {
            str = "config";
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(str, jSONObject);
        } catch (JSONException e) {
            ACLog.w(f, "mergeConfigAdvanced: failed", e);
        }
        return a(null, jSONObject2, z, z2, z3) != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MergeChangeResult parseFetchedConfigs(List<String> list, JSONObject jSONObject) {
        MergeChangeResult a2 = a(list, a(jSONObject), true, true, true);
        ACLog.i(f, String.format("** Parse fetched config completely! changed = %s.", String.valueOf((a2 == null || a2.changedList.isEmpty()) ? false : true)));
        return a2;
    }

    public void removeCommonConfigListener(ICommonConfigListener iCommonConfigListener) {
        this.c.a(iCommonConfigListener);
    }

    public void removeForAnyCommonConfigListener(IAnyCommonConfigListener iAnyCommonConfigListener) {
        this.e.remove(iAnyCommonConfigListener);
    }

    public void removeOverwriteInterceptor(ConfigOverwriteInterceptor configOverwriteInterceptor) {
        this.b.a(configOverwriteInterceptor);
    }

    public void removeSectionConfigListener(ISectionConfigListener iSectionConfigListener) {
        this.d.a(iSectionConfigListener);
    }

    protected abstract void saveConfigInternal(String str);

    public void saveConfigsToCache() {
        String json;
        synchronized (this.mConfigLock) {
            ACLog.i(f, "** Will save configs to local cache!, mergeByManual = false.");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("_version", this.mCurrentConfigVersion);
                jSONObject.put("_data", this.mCachedConfigs);
            } catch (JSONException e) {
                ACLog.w(f, "saveConfigsToCache failed!", e);
            }
            json = JsonUtils.toJson(jSONObject);
        }
        ConfigUtils.doAsyncTask(new a(json));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLastUpdateVersion(long j) {
        this.mCurrentConfigVersion = j;
        String str = f;
        StringBuilder sb = new StringBuilder();
        sb.append("set: setLastUpdateVersion = ");
        sb.append(ConfigUtils.formatConfigVersionWithTime(this.mCurrentConfigVersion));
        ACLog.v(str, sb.toString());
    }

    public void shutdown() {
        this.mStatus = Status.SHUTDOWN;
        ACLog.i(f, "shutdown ConfigCenter!");
    }

    public boolean mergeCommonConfig(String str, Object obj) {
        return mergeConfig(null, str, obj);
    }

    public boolean mergeConfig(String str, String str2, Object obj) {
        return mergeConfig(str, ConfigUtils.kv(str2, obj));
    }

    public boolean mergeConfigAdvanced(String str, JSONObject jSONObject, boolean z, boolean z2) {
        return mergeConfigAdvanced(str, jSONObject, z, z2, true);
    }

    private void a(List<String> list, MergeChangeResult mergeChangeResult) {
        String str;
        if (list != null && !list.isEmpty()) {
            for (String str2 : list) {
                int indexOf = str2.indexOf(46);
                if (indexOf > 0) {
                    str = str2.substring(0, indexOf);
                    str2 = str2.substring(indexOf + 1);
                } else {
                    str = "config";
                }
                JSONObject optJSONObject = this.mCachedConfigs.optJSONObject(str);
                if (optJSONObject != null && optJSONObject.has(str2)) {
                    optJSONObject.remove(str2);
                    a(mergeChangeResult, ConfigChangeType.DELETED, str, str2);
                }
            }
            return;
        }
        ACLog.e(f, "Has no deleted keys!");
    }

    private void a(JSONObject jSONObject, MergeChangeResult mergeChangeResult, boolean z) {
        if (jSONObject == null) {
            ACLog.e(f, "Has no updated keys!");
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = jSONObject.optJSONObject(next);
            if (optJSONObject != null && !TextUtils.isEmpty(next)) {
                Iterator<String> keys2 = optJSONObject.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    ConfigChangeType a2 = a(next, next2, optJSONObject.opt(next2), z);
                    if (a2 != null) {
                        a(mergeChangeResult, a2, next, next2);
                    }
                }
            }
        }
    }

    private JSONObject a(JSONObject jSONObject) {
        String str;
        if (jSONObject != null && jSONObject.length() != 0) {
            JSONObject jSONObject2 = new JSONObject();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object opt = jSONObject.opt(next);
                if (!TextUtils.isEmpty(next) && opt != null) {
                    int indexOf = next.indexOf(46);
                    if (indexOf > 0) {
                        str = next.substring(0, indexOf);
                        next = next.substring(indexOf + 1);
                    } else {
                        str = "config";
                    }
                    try {
                        JSONObject optJSONObject = jSONObject2.optJSONObject(str);
                        if (optJSONObject == null) {
                            optJSONObject = new JSONObject();
                            jSONObject2.put(str, optJSONObject);
                        }
                        optJSONObject.put(next, opt);
                    } catch (JSONException e) {
                        ACLog.w(f, "convertUpdatedKeys: failed", e);
                    }
                }
            }
            return jSONObject2;
        }
        ACLog.e(f, "Has no updated keys, will not convert updated configs.");
        return null;
    }

    private MergeChangeResult a(List<String> list, JSONObject jSONObject, boolean z, boolean z2, boolean z3) {
        if (isShutdown()) {
            ACLog.e(f, "ConfigCenter already shutdown. will not merge this config!");
            return null;
        }
        a();
        MergeChangeResult mergeChangeResult = new MergeChangeResult();
        synchronized (this.mConfigLock) {
            a(list, mergeChangeResult);
            a(jSONObject, mergeChangeResult, z);
        }
        if (!mergeChangeResult.changedList.isEmpty()) {
            if (z2) {
                saveConfigsToCache();
            }
            if (z3) {
                ConfigUtils.doAsyncTask(new b(mergeChangeResult));
            }
        }
        return mergeChangeResult;
    }

    private void a(MergeChangeResult mergeChangeResult, ConfigChangeType configChangeType, String str, String str2) {
        com.iap.ac.config.lite.d.a aVar;
        boolean z = !isCommonConfigSection(str);
        if (configChangeType == ConfigChangeType.VALUE_NOT_CHANGED) {
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(".");
                sb.append(str2);
                str2 = sb.toString();
            }
            mergeChangeResult.valueNotChangedList.add(str2);
            return;
        }
        Iterator<com.iap.ac.config.lite.d.a> it = mergeChangeResult.changedList.iterator();
        do {
            aVar = null;
            if (!it.hasNext()) {
                break;
            }
            aVar = it.next();
        } while (!aVar.a(str));
        if (aVar == null) {
            aVar = new com.iap.ac.config.lite.d.a(str);
            mergeChangeResult.changedList.add(aVar);
        }
        if (aVar.a(configChangeType, str2)) {
            ACLog.d(f, String.format("section/common-config-Key changed: section = %s, key = %s, isSection = %s, changedType = %s.", str, str2, String.valueOf(z), String.valueOf(configChangeType)));
        }
    }

    private ConfigChangeType a(String str, String str2, Object obj, boolean z) {
        try {
            if (this.mCachedConfigs.optJSONObject(str) == null) {
                this.mCachedConfigs.put(str, new JSONObject());
            }
        } catch (JSONException e) {
            ACLog.w(f, "mergeConfigInternal: failed", e);
        }
        ACLog.d(f, String.format("**WILL-MERGE-SECTION** will merge SECTION config. section = %s, key = %s, overwritesExistingItem = %s", str, str2, String.valueOf(z)));
        return b(str, str2, obj, z);
    }

    private boolean a(String str, Object obj, Object obj2) {
        if ((obj instanceof Boolean) && (obj2 instanceof Boolean) && ((Boolean) obj).booleanValue() == ((Boolean) obj2).booleanValue()) {
            ACLog.w(f, String.format("**TYPE-CHECK** Boolean value equals! will not replace. key = %s.", str));
            return true;
        } else if ((obj instanceof String) && (obj2 instanceof String) && TextUtils.equals((String) obj, (String) obj2)) {
            ACLog.w(f, String.format("**TYPE-CHECK** String value equals! will not replace. key = %s.", str));
            return true;
        } else if ((obj instanceof Number) && (obj2 instanceof Number) && Math.abs(((Number) obj).doubleValue() - ((Number) obj2).doubleValue()) <= 1.0E-5d) {
            ACLog.w(f, String.format("**TYPE-CHECK** Numeric value equals! will not replace. key = %s.", str));
            return true;
        } else if ((obj instanceof JSONObject) && (obj2 instanceof JSONObject) && JsonUtils.toJson(obj).equals(JsonUtils.toJson(obj2))) {
            ACLog.w(f, String.format("**TYPE-CHECK** JSONObject value equals! will not replace. key = %s.", str));
            return true;
        } else if ((obj instanceof JSONArray) && (obj2 instanceof JSONArray) && JsonUtils.toJson(obj).equals(JsonUtils.toJson(obj2))) {
            ACLog.w(f, String.format("**TYPE-CHECK** JSONArray value equals! will not replace. key = %s.", str));
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<com.iap.ac.config.lite.d.a> list) {
        synchronized (this.mConfigLock) {
            ChangedDetails changedDetails = null;
            for (com.iap.ac.config.lite.d.a aVar : list) {
                a(aVar);
                if (!aVar.c) {
                    changedDetails = a(changedDetails, aVar.f7629a);
                }
            }
            if (changedDetails != null) {
                synchronized (this.e) {
                    JSONObject configInternal = getConfigInternal();
                    Iterator<IAnyCommonConfigListener> it = this.e.iterator();
                    while (it.hasNext()) {
                        it.next().onConfigChanged(configInternal, changedDetails);
                    }
                }
            }
        }
    }

    private ChangedDetails a(ChangedDetails changedDetails, ChangedDetails changedDetails2) {
        if (changedDetails == null) {
            changedDetails = new ChangedDetails();
        }
        changedDetails.mergeChangeDetails(changedDetails2);
        return changedDetails;
    }

    private void a(com.iap.ac.config.lite.d.a aVar) {
        JSONObject configInternal;
        String str = aVar.b;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.iap.ac.config.lite.d.c cVar = aVar.c ? this.d : this.c;
        if (aVar.c) {
            configInternal = getSectionConfig(str);
        } else {
            configInternal = getConfigInternal();
        }
        cVar.a(str, configInternal, aVar.f7629a);
    }
}
