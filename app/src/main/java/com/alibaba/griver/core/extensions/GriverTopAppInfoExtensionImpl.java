package com.alibaba.griver.core.extensions;

import android.os.Bundle;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.griver.api.common.env.GriverTopAppInfoExtension;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.core.ui.activity.GriverBaseActivity;

/* loaded from: classes6.dex */
public class GriverTopAppInfoExtensionImpl implements GriverTopAppInfoExtension {
    private GriverBaseActivity a() {
        if (GriverEnv.getTopActivity() == null || GriverEnv.getTopActivity().get() == null || !(GriverEnv.getTopActivity().get() instanceof GriverBaseActivity)) {
            return null;
        }
        return (GriverBaseActivity) GriverEnv.getTopActivity().get();
    }

    private App a(GriverBaseActivity griverBaseActivity) {
        return griverBaseActivity.getCurrentApp();
    }

    @Override // com.alibaba.griver.api.common.env.GriverTopAppInfoExtension
    public Bundle getTopAppStartBundle() {
        App a2;
        if (a() == null || (a2 = a(a())) == null) {
            return null;
        }
        return a2.getStartParams();
    }

    @Override // com.alibaba.griver.api.common.env.GriverTopAppInfoExtension
    public Page getPage() {
        App a2;
        if (a() == null || (a2 = a(a())) == null) {
            return null;
        }
        return a2.getActivePage();
    }
}
