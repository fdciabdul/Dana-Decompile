package com.alibaba.exthub.lifecycler;

import android.app.Activity;

/* loaded from: classes3.dex */
public interface ActivityLifecycleExtension {
    void onActivityDestroy(Activity activity);

    void onActivityPause(Activity activity);

    void onActivityResume(Activity activity);
}
