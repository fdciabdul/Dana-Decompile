package com.alibaba.griver.core.extensions;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.griver.api.ui.GriverAppExtension;
import com.alibaba.griver.core.update.GriverAsyncUpdateManagerImpl;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes6.dex */
public class GriverAppExtensionImpl implements GriverAppExtension {

    /* renamed from: a  reason: collision with root package name */
    private static List<App> f6406a = new LinkedList();

    @Override // com.alibaba.griver.api.ui.GriverAppExtension
    public void onAppStart(App app) {
        if (app != null) {
            f6406a.add(app);
        }
    }

    @Override // com.alibaba.griver.api.ui.GriverAppExtension
    public void onAppExit(App app) {
        if (app != null) {
            f6406a.remove(app);
            GriverAsyncUpdateManagerImpl.unRegister(app.getAppId());
        }
    }

    @Override // com.alibaba.griver.api.ui.GriverAppExtension
    public App getAppByAppId(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (App app : f6406a) {
            if (TextUtils.equals(app.getAppId(), str)) {
                return app;
            }
        }
        return null;
    }

    @Override // com.alibaba.griver.api.ui.GriverAppExtension
    public App getAppByUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (App app : f6406a) {
            if (TextUtils.equals(app.getStartUrl(), str)) {
                return app;
            }
        }
        return null;
    }
}
