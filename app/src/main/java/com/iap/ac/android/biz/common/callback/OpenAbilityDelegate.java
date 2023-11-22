package com.iap.ac.android.biz.common.callback;

import android.net.Uri;
import com.iap.ac.android.biz.common.model.ScanCallback;
import com.iap.ac.android.biz.common.model.ScannerOption;
import java.util.Map;

/* loaded from: classes3.dex */
public interface OpenAbilityDelegate {
    void openBizScene(String str, Map<String, String> map, OpenBizSceneCallback openBizSceneCallback);

    boolean openScheme(Uri uri);

    void scan(ScannerOption scannerOption, ScanCallback scanCallback);
}
