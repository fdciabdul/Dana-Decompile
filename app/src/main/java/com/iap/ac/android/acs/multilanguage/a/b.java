package com.iap.ac.android.acs.multilanguage.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.LruCache;
import com.iap.ac.android.acs.multilanguage.callback.OnFetchCallback;
import com.iap.ac.android.acs.multilanguage.callback.OnUpdateCallback;
import com.iap.ac.android.acs.multilanguage.core.config.LanguagePackageConfig;
import com.iap.ac.android.acs.multilanguage.utils.LanguagePackageUtil;
import com.iap.ac.android.acs.multilanguage.utils.MultiLanguageLogger;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.task.async.IAPAsyncTask;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class b implements com.iap.ac.android.acs.multilanguage.a.a {
    private static final String d = LanguagePackageUtil.logTag("LanguagePackageManager");

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f7527a;
    private LanguagePackageConfig b = LanguagePackageConfig.buildDefaultConfig();
    private LruCache<String, Map<String, String>> c = new LruCache<>(this.b.getMaxMemoryCacheSize());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f7528a;
        final /* synthetic */ String b;
        final /* synthetic */ boolean c;
        final /* synthetic */ boolean d;
        final /* synthetic */ OnUpdateCallback e;

        a(Context context, String str, boolean z, boolean z2, OnUpdateCallback onUpdateCallback) {
            this.f7528a = context;
            this.b = str;
            this.c = z;
            this.d = z2;
            this.e = onUpdateCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.f7528a, this.b, this.c, this.d, this.e);
        }
    }

    /* renamed from: com.iap.ac.android.acs.multilanguage.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0119b implements OnUpdateCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f7529a;
        final /* synthetic */ OnFetchCallback b;

        C0119b(String str, OnFetchCallback onFetchCallback) {
            this.f7529a = str;
            this.b = onFetchCallback;
        }

        @Override // com.iap.ac.android.acs.multilanguage.callback.OnUpdateCallback
        public void onUpdateFinish() {
            Map<String, String> b = b.this.b(this.f7529a);
            if (!LanguagePackageUtil.isEmpty(b)) {
                OnFetchCallback onFetchCallback = this.b;
                if (onFetchCallback != null) {
                    onFetchCallback.onFetchSuccess(b.this.b.getLanguage(), b);
                    return;
                }
                return;
            }
            b.this.a(this.f7529a, this.b);
        }

        @Override // com.iap.ac.android.acs.multilanguage.callback.OnUpdateCallback
        public void onUpdateOnError(String str, String str2) {
            b.this.a(this.f7529a, this.b);
        }
    }

    private void b(Context context, String str, boolean z, boolean z2, OnUpdateCallback onUpdateCallback) {
        IAPAsyncTask.asyncTask(new a(context, str, z, z2, onUpdateCallback));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> b(String str) {
        Map<String, String> map = this.c.get(str);
        String str2 = d;
        StringBuilder sb = new StringBuilder();
        sb.append(LanguagePackageUtil.logPrefix(str));
        sb.append("fetchFromMemory(), langMap: ");
        sb.append(map);
        ACLog.d(str2, sb.toString());
        return map;
    }

    @Override // com.iap.ac.android.acs.multilanguage.a.a
    public void a(LanguagePackageConfig languagePackageConfig) {
        synchronized (this) {
            this.b = LanguagePackageConfig.adapter(languagePackageConfig);
            this.c = LanguagePackageUtil.resizeCache(this.c, languagePackageConfig.getMaxMemoryCacheSize());
        }
    }

    @Override // com.iap.ac.android.acs.multilanguage.a.a
    public void a(Context context, String str, boolean z, OnUpdateCallback onUpdateCallback) {
        synchronized (this) {
            b(context, str, true, z, onUpdateCallback);
        }
    }

    protected void a(Context context, String str, boolean z, boolean z2, OnUpdateCallback onUpdateCallback) {
        JSONObject a2;
        a(context);
        StringBuilder sb = new StringBuilder();
        sb.append("SP_AC_LANG_PKG_UPDATE_TIME_");
        sb.append(str);
        String a3 = a(sb.toString());
        if (z && !LanguagePackageUtil.needsCheckUpdate(a3, this.b.getUpdateIntervalInHour())) {
            MultiLanguageLogger.newLogger("ac_lang_package_check_update", str).addParams("type", str).addParams("errorMessage", "checkUpdate(), don`t needs to check upgrade this time").event();
            String str2 = d;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(LanguagePackageUtil.logPrefix(str));
            sb2.append("checkUpdate(), don`t needs to check upgrade this time");
            ACLog.d(str2, sb2.toString());
            if (onUpdateCallback != null) {
                onUpdateCallback.onUpdateFinish();
                return;
            }
            return;
        }
        com.iap.ac.android.acs.multilanguage.b.a a4 = a(context, str, onUpdateCallback);
        if (a4 == null || (a2 = a(str, a4.b, onUpdateCallback)) == null) {
            return;
        }
        a(context, str, z2, a4.f7530a, a2);
        if (onUpdateCallback != null) {
            onUpdateCallback.onUpdateFinish();
        }
    }

    private com.iap.ac.android.acs.multilanguage.b.a a(Context context, String str, OnUpdateCallback onUpdateCallback) {
        String format = String.format("https://activityservice.alibaba.com/openapi/v1/version?name=%s", str);
        try {
            com.iap.ac.android.acs.multilanguage.b.a a2 = com.iap.ac.android.acs.multilanguage.b.a.a(LanguagePackageUtil.requestFromServer(format));
            StringBuilder sb = new StringBuilder();
            sb.append("SP_AC_LANG_PKG_VERSION_");
            sb.append(str);
            String a3 = a(sb.toString());
            String str2 = d;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(LanguagePackageUtil.logPrefix(str));
            sb2.append("checkUpdate(), local version: ");
            sb2.append(a3);
            sb2.append(", server version: ");
            sb2.append(a2.f7530a);
            ACLog.d(str2, sb2.toString());
            if (TextUtils.equals(a3, a2.f7530a) && this.b.getStorageImpl().isFileExist(context, str)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("SP_AC_LANG_PKG_UPDATE_TIME_");
                sb3.append(str);
                a(sb3.toString(), String.valueOf(System.currentTimeMillis()));
                StringBuilder sb4 = new StringBuilder();
                sb4.append("checkUpdate(), localVersion and serverVersion are the same : ");
                sb4.append(a3);
                String obj = sb4.toString();
                MultiLanguageLogger.newLogger("ac_lang_package_check_update", str).addParams("type", str).addParams("errorMessage", obj).event();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(LanguagePackageUtil.logPrefix(str));
                sb5.append(obj);
                ACLog.d(str2, sb5.toString());
                if (onUpdateCallback != null) {
                    onUpdateCallback.onUpdateFinish();
                }
                return null;
            }
            return a2;
        } catch (JSONException e) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("SP_AC_LANG_PKG_UPDATE_TIME_");
            sb6.append(str);
            a(sb6.toString(), String.valueOf(System.currentTimeMillis()));
            StringBuilder sb7 = new StringBuilder();
            sb7.append(LanguagePackageUtil.logPrefix(str));
            sb7.append("fetch language-package info failed,may the langPkgId: ");
            sb7.append(str);
            sb7.append(" may not configured in MEDUSA. message: ");
            sb7.append(e);
            String obj2 = sb7.toString();
            MultiLanguageLogger.newLogger("ac_lang_package_check_update", str).addParams("url", format).addParams("type", str).addParams("errorMessage", obj2).event();
            ACLog.d(d, obj2);
            if (onUpdateCallback != null) {
                onUpdateCallback.onUpdateOnError("1001", obj2);
            }
            return null;
        } catch (Exception e2) {
            StringBuilder sb8 = new StringBuilder();
            sb8.append(LanguagePackageUtil.logPrefix(str));
            sb8.append("checkUpdate(), request language-package version failed, message: ");
            sb8.append(e2);
            String obj3 = sb8.toString();
            MultiLanguageLogger.logException("ac_lang_package_info_update_failed", str).addParams("url", format).addParams("type", str).addParams("errorMessage", obj3).event();
            ACLog.e(d, obj3);
            if (onUpdateCallback != null) {
                onUpdateCallback.onUpdateOnError("9999", obj3);
            }
            return null;
        }
    }

    private JSONObject a(String str, String str2, OnUpdateCallback onUpdateCallback) {
        String formatLanguagePackageUrl = LanguagePackageUtil.formatLanguagePackageUrl(str2);
        try {
            JSONObject requestFromServer = LanguagePackageUtil.requestFromServer(formatLanguagePackageUrl);
            String str3 = d;
            StringBuilder sb = new StringBuilder();
            sb.append(LanguagePackageUtil.logPrefix(str));
            sb.append("checkUpdate(), new version of language-package fetched: ");
            sb.append(requestFromServer);
            ACLog.d(str3, sb.toString());
            return requestFromServer;
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(LanguagePackageUtil.logPrefix(str));
            sb2.append("checkUpdate(), update language-package content failed, message: ");
            sb2.append(e);
            String obj = sb2.toString();
            MultiLanguageLogger.logException("ac_lang_package_update_failed", str).addParams("url", formatLanguagePackageUrl).addParams("type", str).addParams("errorMessage", obj).event();
            ACLog.e(d, obj);
            if (onUpdateCallback != null) {
                onUpdateCallback.onUpdateOnError("9999", obj);
                return null;
            }
            return null;
        }
    }

    private void a(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        sb.append("SP_AC_LANG_PKG_VERSION_");
        sb.append(str);
        a(sb.toString(), str2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SP_AC_LANG_PKG_UPDATE_TIME_");
        sb2.append(str);
        a(sb2.toString(), String.valueOf(System.currentTimeMillis()));
        this.b.getStorageImpl().saveToStorage(context, str, jSONObject.toString());
        if (z) {
            boolean a2 = a(context, str, this.b.getLanguage(), true);
            String str3 = d;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(LanguagePackageUtil.logPrefix(str));
            sb3.append("updateCache(), save to memory ");
            sb3.append(a2 ? "success" : "fail");
            ACLog.d(str3, sb3.toString());
        }
    }

    @Override // com.iap.ac.android.acs.multilanguage.a.a
    public void a(Context context, String str, OnFetchCallback onFetchCallback) {
        String str2 = d;
        StringBuilder sb = new StringBuilder();
        sb.append(LanguagePackageUtil.logPrefix(str));
        sb.append("fetchLanguagePackage(), start fetch translated content from memory");
        ACLog.d(str2, sb.toString());
        a(context, str, this.b.getLanguage(), false);
        Map<String, String> b = b(str);
        if (LanguagePackageUtil.isEmpty(b)) {
            b(context, str, false, true, new C0119b(str, onFetchCallback));
        } else if (onFetchCallback != null) {
            onFetchCallback.onFetchSuccess(this.b.getLanguage(), b);
        }
    }

    protected void a(String str, OnFetchCallback onFetchCallback) {
        StringBuilder sb = new StringBuilder();
        sb.append("onFetchFromMemoryFailed(), langPkgId \"");
        sb.append(str);
        sb.append("\" fetch locally fail for no cache matched");
        String obj = sb.toString();
        MultiLanguageLogger.newLogger("ac_lang_fetch_from_local", str).addParams("errorMessage", obj).event();
        String str2 = d;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(LanguagePackageUtil.logPrefix(str));
        sb2.append(obj);
        ACLog.d(str2, sb2.toString());
        if (onFetchCallback != null) {
            onFetchCallback.onFetchOnError("1002", obj);
        }
    }

    private boolean a(Context context, String str, String str2, boolean z) {
        if (z) {
            this.c.remove(str);
        }
        String str3 = d;
        StringBuilder sb = new StringBuilder();
        sb.append(LanguagePackageUtil.logPrefix(str));
        sb.append("saveToMemory(), start load local cache to memory");
        ACLog.d(str3, sb.toString());
        try {
            if (LanguagePackageUtil.isEmpty(this.c.get(str))) {
                String fromStorage = this.b.getStorageImpl().getFromStorage(context, str);
                if (TextUtils.isEmpty(fromStorage)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(LanguagePackageUtil.logPrefix(str));
                    sb2.append("saveToMemory(), the cache save to memory failed, for local language package specific with the langPkgId is empty");
                    ACLog.w(str3, sb2.toString());
                    return false;
                }
                this.c.put(str, LanguagePackageUtil.convertToMap(fromStorage, str2));
                StringBuilder sb3 = new StringBuilder();
                sb3.append(LanguagePackageUtil.logPrefix(str));
                sb3.append("saveToMemory(), save to memory success, current cache: ");
                sb3.append(LanguagePackageUtil.mapToJsonString(this.c.snapshot()));
                ACLog.d(str3, sb3.toString());
                return true;
            }
            return true;
        } catch (Exception e) {
            MultiLanguageLogger.logException("ac_lang_package_save_to_local_failed", str).addParams("type", str).addParams("errorMessage", e.toString()).event();
            String str4 = d;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(LanguagePackageUtil.logPrefix(str));
            sb4.append("saveToMemory(), save to memory failed, message :");
            sb4.append(e);
            ACLog.e(str4, sb4.toString());
            return false;
        }
    }

    private void a(Context context) {
        synchronized (this) {
            if (this.f7527a != null) {
                return;
            }
            this.f7527a = context.getSharedPreferences("AC_LANG_PKG_STORAGE", 0);
        }
    }

    private void a(String str, String str2) {
        SharedPreferences.Editor edit = this.f7527a.edit();
        edit.putString(str, str2);
        edit.apply();
    }

    private String a(String str) {
        return this.f7527a.getString(str, null);
    }
}
