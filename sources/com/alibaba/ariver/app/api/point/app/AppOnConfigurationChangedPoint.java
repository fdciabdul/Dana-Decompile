package com.alibaba.ariver.app.api.point.app;

import android.content.res.Configuration;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.api.extension.Extension;

/* loaded from: classes3.dex */
public interface AppOnConfigurationChangedPoint extends Extension {
    void onConfigurationChanged(App app, Configuration configuration, String str);
}
