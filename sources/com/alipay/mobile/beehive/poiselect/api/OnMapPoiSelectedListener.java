package com.alipay.mobile.beehive.poiselect.api;

/* loaded from: classes6.dex */
public abstract class OnMapPoiSelectedListener implements OnPoiSelectedListener {
    @Override // com.alipay.mobile.beehive.poiselect.api.OnPoiSelectedListener
    public void onHideLocationSelected() {
    }

    public abstract void onPoiSelectCancel();
}
