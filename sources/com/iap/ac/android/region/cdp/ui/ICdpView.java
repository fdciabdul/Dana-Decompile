package com.iap.ac.android.region.cdp.ui;

import com.iap.ac.android.region.cdp.model.CdpSpaceInfo;

/* loaded from: classes8.dex */
public interface ICdpView {
    String getType();

    void renderWithSpaceInfo(CdpSpaceInfo cdpSpaceInfo);
}
