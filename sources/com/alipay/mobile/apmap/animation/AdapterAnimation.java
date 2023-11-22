package com.alipay.mobile.apmap.animation;

import android.view.animation.Interpolator;
import com.alipay.mobile.apmap.util.DynamicSDKContext;

/* loaded from: classes6.dex */
public abstract class AdapterAnimation implements DynamicSDKContext {
    protected boolean is2dMapSdk;

    /* loaded from: classes6.dex */
    public interface AdapterAnimationListener {
        void onAnimationEnd();

        void onAnimationStart();
    }

    public void setAnimationListener(AdapterAnimationListener adapterAnimationListener) {
    }

    public abstract void setDuration(long j);

    public abstract void setInterpolator(Interpolator interpolator);

    public AdapterAnimation(DynamicSDKContext dynamicSDKContext) {
        if (dynamicSDKContext == null) {
            this.is2dMapSdk = true;
        } else {
            this.is2dMapSdk = dynamicSDKContext.is2dMapSdk();
        }
    }

    @Override // com.alipay.mobile.apmap.util.DynamicSDKContext
    public boolean is2dMapSdk() {
        return this.is2dMapSdk;
    }
}
