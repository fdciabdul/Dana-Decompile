package com.alipay.mobile.framework.service;

import com.alipay.mobile.common.lbs.LBSLocation;

/* loaded from: classes6.dex */
public interface OnLBSLocationListener {
    void onLocationFailed(int i);

    void onLocationUpdate(LBSLocation lBSLocation);
}
