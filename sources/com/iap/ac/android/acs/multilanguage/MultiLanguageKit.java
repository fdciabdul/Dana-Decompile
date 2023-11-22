package com.iap.ac.android.acs.multilanguage;

import android.content.Context;
import android.text.TextUtils;
import com.iap.ac.android.acs.multilanguage.a.a;
import com.iap.ac.android.acs.multilanguage.a.b;
import com.iap.ac.android.acs.multilanguage.callback.OnFetchCallback;
import com.iap.ac.android.acs.multilanguage.callback.OnUpdateCallback;
import com.iap.ac.android.acs.multilanguage.core.config.LanguagePackageConfig;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class MultiLanguageKit {
    private static final Map<String, MultiLanguageKit> c = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    private a f7526a;
    private LanguagePackageConfig b = LanguagePackageConfig.buildDefaultConfig();

    private MultiLanguageKit() {
    }

    private void a() {
        if (this.f7526a == null) {
            this.f7526a = new b();
        }
        this.f7526a.a(this.b);
    }

    public static MultiLanguageKit getInstance(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "DEF_BIZ_TYPE";
        }
        Map<String, MultiLanguageKit> map = c;
        if (map.get(str) == null) {
            synchronized (MultiLanguageKit.class) {
                if (map.get(str) == null) {
                    map.put(str, new MultiLanguageKit());
                }
            }
        }
        return map.get(str);
    }

    public void fetchLanguagePackage(Context context, String str, OnFetchCallback onFetchCallback) {
        synchronized (this) {
            a();
            this.f7526a.a(context, str, onFetchCallback);
        }
    }

    public void setConfig(LanguagePackageConfig languagePackageConfig) {
        synchronized (this) {
            this.b = languagePackageConfig;
            a();
        }
    }

    public void updateLanguagePackage(Context context, String str, boolean z) {
        synchronized (this) {
            updateLanguagePackage(context, str, z, null);
        }
    }

    public void updateLanguagePackage(Context context, String str, boolean z, OnUpdateCallback onUpdateCallback) {
        synchronized (this) {
            a();
            this.f7526a.a(context, str, z, onUpdateCallback);
        }
    }

    public static MultiLanguageKit getInstance() {
        return getInstance(null);
    }
}
