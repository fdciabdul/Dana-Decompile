package com.alipay.iap.android.lbs;

/* loaded from: classes3.dex */
public interface LBSLocationListener {
    void onLocationError(LBSLocationErrorCode lBSLocationErrorCode);

    void onLocationUpdate(LBSLocation lBSLocation);
}
