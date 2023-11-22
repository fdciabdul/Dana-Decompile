package com.alipay.mobile.beehive.poiselect.service.impl;

import android.content.Intent;
import android.os.Bundle;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alipay.mobile.beehive.poiselect.api.OnPoiSelectedListener;
import com.alipay.mobile.beehive.poiselect.api.PoiSelectParams;
import com.alipay.mobile.beehive.poiselect.service.PoiSelectService;
import com.alipay.mobile.beehive.poiselect.ui.PoiSelectActivity;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes6.dex */
public class PoiSelectServiceImpl implements PoiSelectService {

    /* renamed from: a  reason: collision with root package name */
    private OnPoiSelectedListener f7119a;

    protected void onDestroy(Bundle bundle) {
        this.f7119a = null;
    }

    @Override // com.alipay.mobile.beehive.poiselect.service.PoiSelectService
    public void startPoiSelect(Bundle bundle, OnPoiSelectedListener onPoiSelectedListener) {
        if (onPoiSelectedListener == null) {
            GriverLogger.e("GriverMapPoiSelectService", "listener must not be null.");
            return;
        }
        this.f7119a = onPoiSelectedListener;
        Intent intent = new Intent(GriverEnv.getApplicationContext(), PoiSelectActivity.class);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        GriverEnv.getApplicationContext().startActivity(intent);
    }

    @Override // com.alipay.mobile.beehive.poiselect.service.PoiSelectService
    public void startMapPoiSelect(Bundle bundle, OnPoiSelectedListener onPoiSelectedListener) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (!bundle.containsKey("mode")) {
            bundle.putString("mode", "default");
        }
        setDefaultValueString(bundle, "mode", "default");
        setDefaultValueString(bundle, "appKey", "android-sendPosition-poiSearch");
        setDefaultValueBoolean(bundle, PoiSelectParams.SHOW_HIDE_LOCATION, false);
        setDefaultValueBoolean(bundle, "isShowConfirmSelectBtn", true);
        setDefaultValueBoolean(bundle, "isNeedScreenShot", true);
        startPoiSelect(bundle, onPoiSelectedListener);
    }

    public static void setDefaultValueString(Bundle bundle, String str, String str2) {
        if (bundle.containsKey(str)) {
            return;
        }
        bundle.putString(str, str2);
    }

    public static void setDefaultValueBoolean(Bundle bundle, String str, boolean z) {
        if (bundle.containsKey(str)) {
            return;
        }
        bundle.putBoolean(str, z);
    }

    @Override // com.alipay.mobile.beehive.poiselect.service.PoiSelectService
    public OnPoiSelectedListener getPoiSelectListener() {
        return this.f7119a;
    }

    @Override // com.alipay.mobile.beehive.poiselect.service.PoiSelectService
    public void setPoilistener(OnPoiSelectedListener onPoiSelectedListener) {
        this.f7119a = onPoiSelectedListener;
    }
}
