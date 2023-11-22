package com.iap.ac.android.biz.common.model;

import com.iap.ac.android.biz.common.model.AcBaseResult;

/* loaded from: classes3.dex */
public interface AcCallback<T extends AcBaseResult> {
    void onResult(T t);
}
