package com.alipay.mobile.framework.service;

import com.alipay.mobile.map.model.LatLonPoint;

/* loaded from: classes6.dex */
public interface OnLocateListener {
    void onLocateFail();

    void onLocateSuccess(LatLonPoint latLonPoint);
}
