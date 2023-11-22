package com.alipay.mobile.apmap;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.apmap.util.AdapterUtil;
import com.alipay.mobile.apmap.util.DynamicSDKContext;
import com.google.android.gms.maps.UiSettings;

/* loaded from: classes6.dex */
public class AdapterUiSettings implements DynamicSDKContext {

    /* renamed from: a  reason: collision with root package name */
    private UiSettings f7097a;
    private boolean b;

    @Override // com.alipay.mobile.apmap.util.DynamicSDKContext
    public boolean is2dMapSdk() {
        return this.b;
    }

    public AdapterUiSettings(UiSettings uiSettings) {
        this.f7097a = uiSettings;
    }

    public void setMyLocationButtonEnabled(boolean z) {
        UiSettings uiSettings;
        StringBuilder sb = new StringBuilder();
        sb.append("setMyLocationButtonEnabled bo = ");
        sb.append(z);
        RVLogger.d("AdapterUiSettings", sb.toString());
        if (!AdapterUtil.isGoogleMapSdk() || (uiSettings = this.f7097a) == null) {
            return;
        }
        uiSettings.setMyLocationButtonEnabled(z);
    }

    public void setZoomControlsEnabled(boolean z) {
        UiSettings uiSettings;
        StringBuilder sb = new StringBuilder();
        sb.append("setZoomControlsEnabled bo = ");
        sb.append(z);
        RVLogger.d("AdapterUiSettings", sb.toString());
        if (!AdapterUtil.isGoogleMapSdk() || (uiSettings = this.f7097a) == null) {
            return;
        }
        uiSettings.setZoomControlsEnabled(z);
    }

    public void setScaleControlsEnabled(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("setScaleControlsEnabled bo = ");
        sb.append(z);
        RVLogger.d("AdapterUiSettings", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            RVLogger.d("AdapterUiSettings", "setScaleControlsEnabled google map sdk not support");
        }
    }

    public void setCompassEnabled(boolean z) {
        UiSettings uiSettings;
        StringBuilder sb = new StringBuilder();
        sb.append("setCompassEnabled bo = ");
        sb.append(z);
        RVLogger.d("AdapterUiSettings", sb.toString());
        if (!AdapterUtil.isGoogleMapSdk() || (uiSettings = this.f7097a) == null) {
            return;
        }
        uiSettings.setCompassEnabled(z);
    }

    public void setZoomInByScreenCenter(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("setZoomInByScreenCenter bo = ");
        sb.append(z);
        RVLogger.d("AdapterUiSettings", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            RVLogger.d("AdapterUiSettings", "setZoomInByScreenCenter google map sdk not support");
        }
    }

    public void setLogoPosition(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("setLogoPosition var1 = ");
        sb.append(i);
        RVLogger.d("AdapterUiSettings", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            RVLogger.d("AdapterUiSettings", "setLogoPosition google map sdk not support");
        }
    }

    public void setRotateGesturesEnabled(boolean z) {
        UiSettings uiSettings;
        StringBuilder sb = new StringBuilder();
        sb.append("setRotateGesturesEnabled bo = ");
        sb.append(z);
        RVLogger.d("AdapterUiSettings", sb.toString());
        if (!AdapterUtil.isGoogleMapSdk() || (uiSettings = this.f7097a) == null) {
            return;
        }
        uiSettings.setRotateGesturesEnabled(z);
    }

    public void setTiltGesturesEnabled(boolean z) {
        UiSettings uiSettings;
        StringBuilder sb = new StringBuilder();
        sb.append("setTiltGesturesEnabled bo = ");
        sb.append(z);
        RVLogger.d("AdapterUiSettings", sb.toString());
        if (!AdapterUtil.isGoogleMapSdk() || (uiSettings = this.f7097a) == null) {
            return;
        }
        uiSettings.setTiltGesturesEnabled(z);
    }

    public void setGestureScaleByMapCenter(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("setGestureScaleByMapCenter bo = ");
        sb.append(z);
        RVLogger.d("AdapterUiSettings", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            RVLogger.d("AdapterUiSettings", "setGestureScaleByMapCenter google map sdk not support");
        }
    }

    public void setAllGesturesEnabled(boolean z) {
        UiSettings uiSettings;
        StringBuilder sb = new StringBuilder();
        sb.append("setAllGesturesEnabled enabled = ");
        sb.append(z);
        RVLogger.d("AdapterUiSettings", sb.toString());
        if (!AdapterUtil.isGoogleMapSdk() || (uiSettings = this.f7097a) == null) {
            return;
        }
        uiSettings.setAllGesturesEnabled(z);
    }

    public void setLogoCenter(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("setLogoCenter var1 = ");
        sb.append(i);
        sb.append(", var2 = ");
        sb.append(i2);
        RVLogger.d("AdapterUiSettings", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            RVLogger.d("AdapterUiSettings", "setLogoCenter google map sdk not support");
        }
    }
}
