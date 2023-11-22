package com.alibaba.griver.api.ui.loadingview;

import android.content.Context;
import com.alibaba.griver.api.common.GriverExtension;

/* loaded from: classes6.dex */
public interface GriverLoadingViewExtension extends GriverExtension {
    void dismiss();

    boolean onBackPressed();

    void show(Context context, String str, boolean z);
}
