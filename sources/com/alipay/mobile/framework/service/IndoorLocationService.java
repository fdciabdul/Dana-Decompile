package com.alipay.mobile.framework.service;

import android.content.Context;
import com.alipay.mobile.map.model.IndoorLocation;

/* loaded from: classes6.dex */
public abstract class IndoorLocationService {

    /* loaded from: classes6.dex */
    public interface IndoorLocationListener {
        void onLocationChange(IndoorLocation indoorLocation);

        void onLocationFail(int i);

        void onLocationStop();
    }

    public abstract boolean attach(Context context, IndoorLocationListener indoorLocationListener, String str);

    public abstract boolean attach(Context context, IndoorLocationListener indoorLocationListener, String str, String str2);

    public abstract void detach(IndoorLocationListener indoorLocationListener);
}
