package com.iap.ac.android.acs.multilanguage.a;

import android.content.Context;
import com.iap.ac.android.acs.multilanguage.callback.OnFetchCallback;
import com.iap.ac.android.acs.multilanguage.callback.OnUpdateCallback;
import com.iap.ac.android.acs.multilanguage.core.config.LanguagePackageConfig;

/* loaded from: classes3.dex */
public interface a {
    void a(Context context, String str, OnFetchCallback onFetchCallback);

    void a(Context context, String str, boolean z, OnUpdateCallback onUpdateCallback);

    void a(LanguagePackageConfig languagePackageConfig);
}
