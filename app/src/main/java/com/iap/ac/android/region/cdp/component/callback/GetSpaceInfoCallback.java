package com.iap.ac.android.region.cdp.component.callback;

import com.iap.ac.android.region.cdp.model.CdpSpaceInfo;
import java.util.Map;

/* loaded from: classes3.dex */
public interface GetSpaceInfoCallback {
    void onFailure(Exception exc);

    void onSuccess(Map<String, CdpSpaceInfo> map);
}
