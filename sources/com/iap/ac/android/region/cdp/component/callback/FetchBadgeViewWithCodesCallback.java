package com.iap.ac.android.region.cdp.component.callback;

import com.iap.ac.android.region.cdp.ui.badge.BadgeView;
import java.util.Map;

/* loaded from: classes8.dex */
public interface FetchBadgeViewWithCodesCallback {
    void onFailure(Exception exc);

    void onSuccess(Map<String, BadgeView> map);
}
