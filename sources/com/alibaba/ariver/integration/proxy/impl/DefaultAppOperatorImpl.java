package com.alibaba.ariver.integration.proxy.impl;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppManager;
import com.alibaba.ariver.app.proxy.RVAppOperatorProxy;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* loaded from: classes6.dex */
public class DefaultAppOperatorImpl implements RVAppOperatorProxy {
    private static final String TAG = "Ariver:DefaultAppOperatorImpl";

    @Override // com.alibaba.ariver.app.proxy.RVAppOperatorProxy
    public void closePage(String str, String str2, String str3) {
    }

    @Override // com.alibaba.ariver.app.proxy.RVAppOperatorProxy
    public Bitmap getPageSnapshot(String str, String str2, String str3) {
        return null;
    }

    @Override // com.alibaba.ariver.app.proxy.RVAppOperatorProxy
    public Bitmap getTopPageSnapshot(String str) {
        try {
            App findAppByAppId = ((AppManager) RVProxy.get(AppManager.class)).findAppByAppId(str);
            if (findAppByAppId == null) {
                RVLogger.d(TAG, "app is null and return null");
                return null;
            } else if (!(findAppByAppId.getAppContext().getContext() instanceof Activity)) {
                RVLogger.d(TAG, "context is not instance of activity");
                return null;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("begin get snapshot for appId: ");
                sb.append(str);
                RVLogger.d(TAG, sb.toString());
                Activity activity = (Activity) findAppByAppId.getAppContext().getContext();
                Activity activity2 = activity;
                View decorView = activity.getWindow().getDecorView();
                decorView.buildDrawingCache();
                Rect rect = new Rect();
                decorView.getWindowVisibleDisplayFrame(rect);
                int i = rect.top;
                decorView.setDrawingCacheEnabled(true);
                Bitmap drawingCache = decorView.getDrawingCache();
                Bitmap createBitmap = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight());
                decorView.destroyDrawingCache();
                return createBitmap;
            }
        } catch (Exception e) {
            RVLogger.e(TAG, e);
            return null;
        }
    }

    @Override // com.alibaba.ariver.app.proxy.RVAppOperatorProxy
    public boolean closeTopPage(String str) {
        App findAppByAppId;
        boolean z = false;
        try {
            findAppByAppId = ((AppManager) RVProxy.get(AppManager.class)).findAppByAppId(str);
        } catch (Exception e) {
            RVLogger.e(TAG, e);
        }
        if (findAppByAppId == null) {
            RVLogger.d(TAG, "app is null and return null");
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("begin exit top page for appId: ");
        sb.append(str);
        RVLogger.d(TAG, sb.toString());
        findAppByAppId.getActivePage().getStartParams().putBoolean(RVParams.LONG_PUSHWINDOW_WITH_CUSTOM_TRANS_ANIM, true);
        if (findAppByAppId.getAlivePageCount() <= 1) {
            findAppByAppId.getSceneParams().putBoolean(RVStartParams.KEY_CLOSE_ACTIVITY_WITH_CUSTOM_ANIMATION, true);
            z = true;
        }
        findAppByAppId.getActivePage().exit(true);
        return z;
    }
}
