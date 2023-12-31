package com.ap.zoloz.hot.reload;

import android.graphics.drawable.Drawable;
import com.alipay.mobile.security.bio.service.BioServiceManager;
import com.alipay.mobile.security.bio.service.local.LocalService;
import com.alipay.zoloz.config.ConfigCenter;

/* loaded from: classes7.dex */
public abstract class ViewLoadService extends LocalService {
    private long mLoadTime = 0;

    public abstract boolean configContainKey(String str, String str2);

    public abstract boolean getBool(String str, int i);

    public abstract int getColor(String str, int i);

    public abstract Drawable getDrawable(String str, int i);

    public abstract int getInteger(String str, int i);

    public abstract String getSpecialUiLayout();

    public abstract String getString(String str, int i);

    protected abstract void onInitViewLoadService(BioServiceManager bioServiceManager, String str);

    @Override // com.alipay.mobile.security.bio.service.local.LocalService, com.alipay.mobile.security.bio.service.BioService
    public void onCreate(BioServiceManager bioServiceManager) {
        super.onCreate(bioServiceManager);
        long currentTimeMillis = System.currentTimeMillis();
        onInitViewLoadService(bioServiceManager, ConfigCenter.getInstance().getUiConfigPath());
        this.mLoadTime = System.currentTimeMillis() - currentTimeMillis;
    }

    public long getConfigLoadTime() {
        return this.mLoadTime;
    }
}
