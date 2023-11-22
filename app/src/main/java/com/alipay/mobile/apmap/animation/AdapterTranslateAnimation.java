package com.alipay.mobile.apmap.animation;

import android.view.animation.Interpolator;
import com.alipay.mobile.apmap.model.AdapterLatLng;
import com.alipay.mobile.apmap.util.DynamicSDKContext;

/* loaded from: classes6.dex */
public class AdapterTranslateAnimation extends AdapterAnimation implements DynamicSDKContext {
    @Override // com.alipay.mobile.apmap.animation.AdapterAnimation
    public void setDuration(long j) {
    }

    @Override // com.alipay.mobile.apmap.animation.AdapterAnimation
    public void setInterpolator(Interpolator interpolator) {
    }

    public AdapterTranslateAnimation(AdapterLatLng adapterLatLng) {
        super(adapterLatLng);
    }
}
