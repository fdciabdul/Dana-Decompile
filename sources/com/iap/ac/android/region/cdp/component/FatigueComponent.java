package com.iap.ac.android.region.cdp.component;

import com.iap.ac.android.region.cdp.model.CdpSpaceInfo;
import java.util.Collection;

/* loaded from: classes3.dex */
public interface FatigueComponent {
    void filterExhaustedFatigue(CdpSpaceInfo cdpSpaceInfo);

    void filterExhaustedFatigue(Collection<CdpSpaceInfo> collection);
}
