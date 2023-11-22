package com.iap.ac.android.region.cdp.component.defaults;

import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.region.cdp.WalletCdpKit;
import com.iap.ac.android.region.cdp.util.CdpUtils;

/* loaded from: classes3.dex */
public abstract class BaseComponent {
    public static final String TAG = CdpUtils.logTag("BaseComponent");
    public final WalletCdpKit mWalletCdpKit = WalletCdpKit.getInstance();

    public <T> T getComponent(Class<T> cls) {
        T t = (T) this.mWalletCdpKit.getComponent(cls);
        if (t == null) {
            this.mWalletCdpKit.initComponents();
            T t2 = (T) this.mWalletCdpKit.getComponent(cls);
            ACLog.e(TAG, "get component is null, init again.");
            return t2;
        }
        return t;
    }
}
