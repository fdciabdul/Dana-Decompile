package com.alibaba.ariver.app.api.point.activity;

import android.app.Activity;
import android.content.Intent;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.api.extension.Extension;

/* loaded from: classes3.dex */
public interface ActivityOnNewIntentPoint extends Extension {
    void onNewIntent(App app, Activity activity, Intent intent);
}
