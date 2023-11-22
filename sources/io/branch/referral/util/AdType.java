package io.branch.referral.util;

import com.iap.ac.android.region.cdp.model.CdpSpaceInfo;

/* loaded from: classes9.dex */
public enum AdType {
    BANNER(CdpSpaceInfo.SPACE_TYPE_BANNER),
    INTERSTITIAL("INTERSTITIAL"),
    REWARDED_VIDEO("REWARDED_VIDEO"),
    NATIVE("NATIVE");

    private final String name;

    AdType(String str) {
        this.name = str;
    }

    public final String getName() {
        return this.name;
    }
}
