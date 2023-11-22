package com.alipay.plus.android.config.sdk;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.plus.android.config.sdk.a.a;
import com.alipay.plus.android.config.sdk.a.b;
import com.alipay.plus.android.config.sdk.a.d;
import com.alipay.plus.android.config.sdk.a.e;
import com.alipay.plus.android.config.sdk.a.f;
import com.alipay.plus.android.config.sdk.listener.ConfigChangeType;
import com.alipay.plus.android.config.sdk.listener.IAnyCommonConfigListener;
import com.alipay.plus.android.config.sdk.listener.commonconfig.ICommonConfigListener;
import com.alipay.plus.android.config.sdk.listener.sectionconfig.ChangedDetails;
import com.alipay.plus.android.config.sdk.listener.sectionconfig.ISectionConfigListener;
import com.alipay.plus.android.config.sdk.utils.ConfigUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes7.dex */
public abstract class ConfigMerger extends ConfigGetter {
    public static final String COMMON_CONFIG_SECTION = "config";

    /* renamed from: a  reason: collision with root package name */
    private static final String f7355a = e.a("ConfigMerger");
    protected JSONObject mCachedConfigs;
    protected Status mStatus = Status.Invalid;
    protected long mCurrentConfigVersion = 0;
    private final d b = new d();
    private final b c = new b();
    private final f d = new f();
    private final List<IAnyCommonConfigListener> e = Collections.synchronizedList(new ArrayList());
    protected final Object mConfigLock = new Object();

    /* loaded from: classes7.dex */
    public static class MergeChangeResult {
        public List<a> changedList = new ArrayList();
        Set<String> valueNotChangedList = new HashSet();
    }

    /* loaded from: classes7.dex */
    public enum Status {
        Invalid,
        Initialized,
        Shutdown;

        public final boolean isInitialized() {
            return this == Initialized;
        }

        public final boolean isInitializedOrShutdown() {
            return isInitialized() || isShutdown();
        }

        public final boolean isShutdown() {
            return this == Shutdown;
        }
    }

    private MergeChangeResult a(List<String> list, Map<String, Map<String, Object>> map, boolean z, boolean z2, boolean z3) {
        if (isShutdown()) {
            LoggerWrapper.e(f7355a, "ConfigCenter already shutdown. will not merge this config!");
            return null;
        }
        a();
        final MergeChangeResult mergeChangeResult = new MergeChangeResult();
        synchronized (this.mConfigLock) {
            a(list, mergeChangeResult);
            a(map, mergeChangeResult, z);
        }
        if (!mergeChangeResult.changedList.isEmpty()) {
            if (z2) {
                saveConfigsToCache();
            }
            if (z3) {
                doAsyncTask(new Runnable() { // from class: com.alipay.plus.android.config.sdk.ConfigMerger.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ConfigMerger.this.a(mergeChangeResult.changedList);
                    }
                });
            }
        }
        return mergeChangeResult;
    }

    private ConfigChangeType a(String str, String str2, Object obj, boolean z) {
        Object obj2 = this.mCachedConfigs.get(str);
        if (obj2 == null) {
            obj2 = new JSONObject();
            this.mCachedConfigs.put(str, obj2);
        }
        if (obj2 instanceof JSONObject) {
            LoggerWrapper.d(f7355a, String.format("**WILL-MERGE-SECTION** will merge SECTION config. section = %s, key = %s, overwritesExistingItem = %s", str, str2, String.valueOf(z)));
            return b(str, str2, obj, z);
        }
        LoggerWrapper.e(f7355a, "**SECTION-TYPE-ERROR** section is not JSONObject, will not merge!");
        return null;
    }

    private ChangedDetails a(ChangedDetails changedDetails, ChangedDetails changedDetails2) {
        if (changedDetails == null) {
            changedDetails = new ChangedDetails();
        }
        changedDetails.mergeChangeDetails(changedDetails2);
        return changedDetails;
    }

    private static Object a(String str, Object obj) {
        if (obj instanceof String) {
            try {
                Object parse = JSON.parse((String) obj);
                if ((parse instanceof JSONObject) || (parse instanceof JSONArray)) {
                    LoggerWrapper.d(f7355a, String.format("Will use %s type for %s.", parse.getClass().getSimpleName(), str));
                    return parse;
                }
            } catch (Throwable unused) {
                String str2 = f7355a;
                StringBuilder sb = new StringBuilder();
                sb.append("Parse json failed! take it easy, will use original value.");
                sb.append(obj);
                LoggerWrapper.w(str2, sb.toString());
            }
            return obj;
        }
        return obj;
    }

    private Map<String, Map<String, Object>> a(Map<String, Object> map) {
        String str;
        if (map == null || map.isEmpty()) {
            LoggerWrapper.e(f7355a, "Has no updated keys, will not convert updated configs.");
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (!TextUtils.isEmpty(key) && value != null) {
                int indexOf = key.indexOf(46);
                if (indexOf > 0) {
                    str = key.substring(0, indexOf);
                    key = key.substring(indexOf + 1);
                } else {
                    str = "config";
                }
                Map map2 = (Map) hashMap.get(str);
                if (map2 == null) {
                    map2 = new HashMap();
                    hashMap.put(str, map2);
                }
                map2.put(key, value);
            }
        }
        return hashMap;
    }

    private void a() {
        synchronized (this.mConfigLock) {
            if (this.mCachedConfigs == null) {
                this.mCachedConfigs = new JSONObject();
                this.mCurrentConfigVersion = 0L;
            }
            if (this.mCachedConfigs.getJSONObject("config") == null) {
                this.mCachedConfigs.put("config", (Object) new JSONObject());
            }
        }
    }

    private void a(MergeChangeResult mergeChangeResult, ConfigChangeType configChangeType, String str, String str2) {
        a aVar;
        boolean z = !isCommonConfigSection(str);
        if (configChangeType == ConfigChangeType.ValueNotChanged) {
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
        Iterator<a> it = mergeChangeResult.changedList.iterator();
        do {
            aVar = null;
            if (!it.hasNext()) {
                break;
            }
            aVar = it.next();
        } while (!aVar.a(str));
        if (aVar == null) {
            aVar = new a(str);
            mergeChangeResult.changedList.add(aVar);
        }
        if (aVar.a(configChangeType, str2)) {
            LoggerWrapper.d(f7355a, String.format("section/common-config-Key changed: section = %s, key = %s, isSection = %s, changedType = %s.", str, str2, String.valueOf(z), String.valueOf(configChangeType)));
        }
    }

    private void a(a aVar) {
        String str = aVar.f7360a;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        (aVar.b ? this.d : this.c).a(str, aVar.b ? getSectionConfig(str) : getConfigInternal(), aVar.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<a> list) {
        synchronized (this.mConfigLock) {
            ChangedDetails changedDetails = null;
            for (a aVar : list) {
                a(aVar);
                if (!aVar.b) {
                    changedDetails = a(changedDetails, aVar.c);
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

    private void a(List<String> list, MergeChangeResult mergeChangeResult) {
        String str;
        if (list == null || list.isEmpty()) {
            LoggerWrapper.e(f7355a, "Has no deleted keys!");
            return;
        }
        for (String str2 : list) {
            int indexOf = str2.indexOf(46);
            if (indexOf > 0) {
                str = str2.substring(0, indexOf);
                str2 = str2.substring(indexOf + 1);
            } else {
                str = "config";
            }
            JSONObject jSONObject = this.mCachedConfigs.getJSONObject(str);
            if (jSONObject != null && jSONObject.containsKey(str2)) {
                jSONObject.remove(str2);
                a(mergeChangeResult, ConfigChangeType.Deleted, str, str2);
            }
        }
    }

    private void a(Map<String, Map<String, Object>> map, MergeChangeResult mergeChangeResult, boolean z) {
        if (map == null) {
            LoggerWrapper.e(f7355a, "Has no updated keys!");
            return;
        }
        for (Map.Entry<String, Map<String, Object>> entry : map.entrySet()) {
            String key = entry.getKey();
            Map<String, Object> value = entry.getValue();
            if (value != null && !TextUtils.isEmpty(key)) {
                for (Map.Entry<String, Object> entry2 : value.entrySet()) {
                    String key2 = entry2.getKey();
                    ConfigChangeType a2 = a(key, key2, a(key2, entry2.getValue()), z);
                    if (a2 != null) {
                        a(mergeChangeResult, a2, key, key2);
                    }
                }
            }
        }
    }

    private boolean a(String str, Object obj, Object obj2) {
        String str2;
        String format;
        if ((obj instanceof Boolean) && (obj2 instanceof Boolean) && ((Boolean) obj).booleanValue() == ((Boolean) obj2).booleanValue()) {
            str2 = f7355a;
            format = String.format("**TYPE-CHECK** Boolean value equals! will not replace. key = %s.", str);
        } else if ((obj instanceof String) && (obj2 instanceof String) && TextUtils.equals((String) obj, (String) obj2)) {
            str2 = f7355a;
            format = String.format("**TYPE-CHECK** String value equals! will not replace. key = %s.", str);
        } else if ((obj instanceof Number) && (obj2 instanceof Number) && Math.abs(((Number) obj).doubleValue() - ((Number) obj2).doubleValue()) <= 1.0E-5d) {
            str2 = f7355a;
            format = String.format("**TYPE-CHECK** Numeric value equals! will not replace. key = %s.", str);
        } else if ((obj instanceof JSONObject) && (obj2 instanceof JSONObject) && ((JSONObject) obj).toJSONString().equals(((JSONObject) obj2).toJSONString())) {
            str2 = f7355a;
            format = String.format("**TYPE-CHECK** JSONObject value equals! will not replace. key = %s.", str);
        } else if (!(obj instanceof JSONArray) || !(obj2 instanceof JSONArray) || !((JSONArray) obj).toJSONString().equals(((JSONArray) obj2).toJSONString())) {
            return false;
        } else {
            str2 = f7355a;
            format = String.format("**TYPE-CHECK** JSONArray value equals! will not replace. key = %s.", str);
        }
        LoggerWrapper.w(str2, format);
        return true;
    }

    private ConfigChangeType b(String str, String str2, Object obj, boolean z) {
        boolean z2;
        boolean z3;
        JSONObject jSONObject = this.mCachedConfigs.getJSONObject(str);
        Object obj2 = jSONObject.get(str2);
        if (obj2 == null) {
            LoggerWrapper.i(f7355a, String.format("**SET** Value for this key is not exists, will set it and return. key = %s", str2));
            jSONObject.put(str2, obj);
            return ConfigChangeType.Added;
        } else if (a(str2, obj, obj2)) {
            return ConfigChangeType.ValueNotChanged;
        } else {
            if (this.b.a(str)) {
                z2 = this.b.a(str, str2, obj2, obj);
                z3 = true;
            } else {
                z2 = true;
                z3 = false;
            }
            if (!z2) {
                LoggerWrapper.e(f7355a, String.format("**INTERCEPTED** This config was intercepted by another interceptor. will not change! key = %s", str2));
                return null;
            } else if (!z && !z3) {
                LoggerWrapper.w(f7355a, String.format("**ALREADY-HAVE-WHEN-MANUAL-MERGE** Already has this config value, and now is manual merge, will skip it! key = %s.", str2));
                return null;
            } else {
                LoggerWrapper.i(f7355a, String.format("**SET-FINALLY** This config was not intercepted, will set it! key = %s", str2));
                jSONObject.put(str2, obj);
                return ConfigChangeType.Modified;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.alipay.plus.android.config.sdk.ConfigMerger$4] */
    protected static void doAsyncTask(final Runnable runnable) {
        new AsyncTask<Void, Void, Void>() { // from class: com.alipay.plus.android.config.sdk.ConfigMerger.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: a  reason: merged with bridge method [inline-methods] */
            public final Void doInBackground(Void... voidArr) {
                runnable.run();
                return null;
            }
        }.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
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

    @Override // com.alipay.plus.android.config.sdk.ConfigGetter
    protected JSONObject getConfigInternal() {
        JSONObject jSONObject;
        if (isShutdown()) {
            return null;
        }
        synchronized (this.mConfigLock) {
            JSONObject jSONObject2 = this.mCachedConfigs;
            jSONObject = jSONObject2 != null ? jSONObject2.getJSONObject("config") : null;
        }
        return jSONObject;
    }

    public long getLastUpdateVersion() {
        String str = f7355a;
        StringBuilder sb = new StringBuilder();
        sb.append("get: getLastUpdateVersion = ");
        sb.append(ConfigUtils.formatConfigVersionWithTime(this.mCurrentConfigVersion));
        LoggerWrapper.v(str, sb.toString());
        return this.mCurrentConfigVersion;
    }

    public JSONObject getSectionConfig(String str) {
        if (isShutdown()) {
            return null;
        }
        synchronized (this.mConfigLock) {
            if (this.mCachedConfigs != null && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject = this.mCachedConfigs.getJSONObject(str);
                return jSONObject != null ? (JSONObject) jSONObject.clone() : null;
            }
            return null;
        }
    }

    public ConfigGetter getSectionConfigGetter(String str) {
        final JSONObject sectionConfig = getSectionConfig(str);
        if (sectionConfig == null) {
            return null;
        }
        return new ConfigGetter() { // from class: com.alipay.plus.android.config.sdk.ConfigMerger.3
            @Override // com.alipay.plus.android.config.sdk.ConfigGetter
            protected JSONObject getConfigInternal() {
                return sectionConfig;
            }
        };
    }

    public JSONObject getSectionConfigObjects() {
        JSONObject jSONObject;
        if (isShutdown() || (jSONObject = this.mCachedConfigs) == null) {
            return null;
        }
        JSONObject jSONObject2 = (JSONObject) jSONObject.clone();
        jSONObject2.remove("config");
        return jSONObject2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initializeWithCache(String str) {
        synchronized (this.mConfigLock) {
            this.mCachedConfigs = null;
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject parseObject = JSON.parseObject(str);
                    this.mCurrentConfigVersion = parseObject.getLongValue("_version");
                    JSONObject jSONObject = parseObject.getJSONObject("_data");
                    this.mCachedConfigs = jSONObject;
                    LoggerWrapper.i(f7355a, String.format("** Cached config has %d items.", Integer.valueOf(jSONObject != null ? jSONObject.size() : 0)));
                } catch (Throwable th) {
                    LoggerWrapper.e(f7355a, String.format("Parse cached config FAILED! message = %s.", th.getMessage()));
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

    public boolean mergeCommonConfig(String str, Object obj) {
        return mergeConfig(null, str, obj);
    }

    public boolean mergeConfig(String str, JSONObject jSONObject) {
        return mergeConfigAdvanced(str, jSONObject, false, false);
    }

    public boolean mergeConfig(String str, String str2, Object obj) {
        return mergeConfig(str, ConfigUtils.kv(str2, obj));
    }

    public boolean mergeConfigAdvanced(String str, JSONObject jSONObject, boolean z, boolean z2) {
        return mergeConfigAdvanced(str, jSONObject, z, z2, true);
    }

    public boolean mergeConfigAdvanced(String str, JSONObject jSONObject, boolean z, boolean z2, boolean z3) {
        if (TextUtils.isEmpty(str)) {
            str = "config";
        }
        HashMap hashMap = new HashMap();
        hashMap.put(str, jSONObject);
        return a(null, hashMap, z, z2, z3) != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MergeChangeResult parseFetchedConfigs(List<String> list, Map<String, Object> map) {
        MergeChangeResult a2 = a(list, a(map), true, true, true);
        LoggerWrapper.i(f7355a, String.format("** Parse fetched config completely! changed = %s.", String.valueOf((a2 == null || a2.changedList.isEmpty()) ? false : true)));
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
        final String jSONString;
        synchronized (this.mConfigLock) {
            LoggerWrapper.i(f7355a, "** Will save configs to local cache!, mergeByManual = false.");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("_version", (Object) Long.valueOf(this.mCurrentConfigVersion));
            jSONObject.put("_data", (Object) this.mCachedConfigs);
            jSONString = jSONObject.toJSONString();
        }
        doAsyncTask(new Runnable() { // from class: com.alipay.plus.android.config.sdk.ConfigMerger.1
            @Override // java.lang.Runnable
            public void run() {
                ConfigMerger.this.saveConfigInternal(jSONString);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLastUpdateVersion(long j) {
        this.mCurrentConfigVersion = j;
        String str = f7355a;
        StringBuilder sb = new StringBuilder();
        sb.append("set: setLastUpdateVersion = ");
        sb.append(ConfigUtils.formatConfigVersionWithTime(this.mCurrentConfigVersion));
        LoggerWrapper.v(str, sb.toString());
    }

    public void shutdown() {
        this.mStatus = Status.Shutdown;
        LoggerWrapper.i(f7355a, "shutdown ConfigCenter!");
    }
}
