package com.alibaba.griver.ui.refresh;

import android.content.Context;
import android.view.View;

/* loaded from: classes6.dex */
public interface GriverPullRefreshService {

    /* loaded from: classes6.dex */
    public enum IGRiverRefreshStyle {
        LIGHT,
        DARK
    }

    /* loaded from: classes6.dex */
    public enum IGriverRefreshState {
        NONE,
        PULL_TO_REFRESH,
        RELEASE_TO_REFRESH,
        REFRESHING
    }

    void changeStyle(IGRiverRefreshStyle iGRiverRefreshStyle);

    void changeToState(IGriverRefreshState iGriverRefreshState);

    View getRefreshView(Context context);

    int getRefreshViewHeight();

    void setProgress(float f);
}
