package com.alipay.mobile.embedview.mapbiz.core.controller;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.alibaba.griver.base.common.utils.DensityUtil;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class MetricsController extends H5MapController {

    /* renamed from: a  reason: collision with root package name */
    private static DisplayMetrics f7161a;

    public MetricsController(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
    }

    public double convertDp(double d) {
        return DensityUtil.dip2px(this.mMapContainer.getContext(), (float) d);
    }

    public double convertRpx2Px(double d) {
        Context context = this.mMapContainer.getContext();
        if (context == null) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        double a2 = a(context);
        Double.isNaN(a2);
        return d * (a2 / 750.0d);
    }

    private static int a(Context context) {
        return b(context).widthPixels;
    }

    public static int getScreenHeight(Context context) {
        return b(context).heightPixels;
    }

    private static DisplayMetrics b(Context context) {
        if (f7161a == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            f7161a = displayMetrics;
        }
        return f7161a;
    }
}
