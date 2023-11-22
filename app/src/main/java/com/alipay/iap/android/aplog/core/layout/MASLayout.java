package com.alipay.iap.android.aplog.core.layout;

import com.alipay.iap.android.aplog.core.layout.LogLayoutManager;
import com.alipay.iap.android.aplog.core.layout.mas.MasLog;
import com.alipay.iap.android.aplog.log.BaseLogInfo;

/* loaded from: classes3.dex */
public class MASLayout<T extends BaseLogInfo> implements LogLayoutManager.Layout<T> {
    public static final String EMPTY_FIELD = "-";
    public static final String LAYOUT_TYPE = "MAS";
    public static final String TAG = "MASLayout";

    @Override // com.alipay.iap.android.aplog.core.layout.LogLayoutManager.Layout
    public LogLayout layout(T t, MasLog<T> masLog) {
        LogLayout logLayout = new LogLayout();
        logLayout.setContent(masLog.getLayout(t));
        logLayout.setLayoutType("MAS");
        logLayout.setLogCategory(t.getLogCategory());
        return logLayout;
    }
}
