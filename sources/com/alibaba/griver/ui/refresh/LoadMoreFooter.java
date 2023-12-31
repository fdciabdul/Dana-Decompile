package com.alibaba.griver.ui.refresh;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.griver.ui.refresh.GriverSwipeRefreshLayout;

/* loaded from: classes6.dex */
public abstract class LoadMoreFooter extends RelativeLayout {
    protected GriverSwipeRefreshLayout.OnPushLoadMoreListener mPushLoadMoreListener;

    /* loaded from: classes6.dex */
    public enum LoadMoreState {
        NONE,
        PUSH_TO_LOAD,
        RELEASE_TO_LOAD,
        LOADING
    }

    public abstract void changeToState(LoadMoreState loadMoreState);

    public abstract LoadMoreState getCurrentState();

    public abstract TextView getLoadMoreTipView();

    public abstract void setLoadMoreTipColor(int i);

    public abstract void setLoadMoreTips(String[] strArr);

    public abstract void setProgress(float f);

    public LoadMoreFooter(Context context) {
        super(context);
    }

    public void setPushLoadMoreListener(GriverSwipeRefreshLayout.OnPushLoadMoreListener onPushLoadMoreListener) {
        this.mPushLoadMoreListener = onPushLoadMoreListener;
    }
}
