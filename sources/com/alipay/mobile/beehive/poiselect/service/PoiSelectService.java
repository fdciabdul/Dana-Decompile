package com.alipay.mobile.beehive.poiselect.service;

import android.os.Bundle;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alipay.mobile.beehive.poiselect.api.OnPoiSelectedListener;

/* loaded from: classes6.dex */
public interface PoiSelectService extends Proxiable {
    OnPoiSelectedListener getPoiSelectListener();

    void setPoilistener(OnPoiSelectedListener onPoiSelectedListener);

    void startMapPoiSelect(Bundle bundle, OnPoiSelectedListener onPoiSelectedListener);

    void startPoiSelect(Bundle bundle, OnPoiSelectedListener onPoiSelectedListener);
}
