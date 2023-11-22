package com.alipay.android.mapassist.ui;

import android.graphics.Bitmap;
import com.alipay.mobile.map.model.LatLonPointEx;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class MarkerInfo {
    public Double distance = Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    public Bitmap icon;
    public LatLonPointEx pointEx;
}
