package com.alibaba.griver.ui.refresh;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.alibaba.griver.base.common.utils.CommonUtils;
import com.alibaba.griver.ui.R;
import com.alibaba.griver.ui.refresh.GriverPullRefreshService;
import com.alibaba.griver.ui.refresh.RefreshHeader;

/* loaded from: classes6.dex */
public class GriverRefreshHeader extends RefreshHeader {

    /* renamed from: a  reason: collision with root package name */
    private GriverPullRefreshService f6748a;
    private ProgressView b;

    @Override // com.alibaba.griver.ui.refresh.RefreshHeader
    public View getRefreshView() {
        return this;
    }

    @Override // com.alibaba.griver.ui.refresh.RefreshHeader
    public View getSecondFloorView() {
        return null;
    }

    @Override // com.alibaba.griver.ui.refresh.RefreshHeader
    public void setRefreshAnimation(String[] strArr, String str) {
    }

    @Override // com.alibaba.griver.ui.refresh.RefreshHeader
    public void setRefreshTipColor(int i) {
    }

    @Override // com.alibaba.griver.ui.refresh.RefreshHeader
    public void setRefreshTips(String[] strArr) {
    }

    @Override // com.alibaba.griver.ui.refresh.RefreshHeader
    public void setSecondFloorView(View view) {
    }

    public GriverRefreshHeader(Context context) {
        super(context);
        this.f6748a = null;
        changeToState(RefreshHeader.RefreshState.NONE);
        GriverPullRefreshService griverPullRefreshService = this.f6748a;
        if (griverPullRefreshService != null) {
            addView(griverPullRefreshService.getRefreshView(context));
            return;
        }
        ProgressView progressView = new ProgressView(context);
        this.b = progressView;
        progressView.setAutoPlay(false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = CommonUtils.dip2px(context, 20.0f);
        addView(this.b, layoutParams);
        this.b.stopLoading();
        setBackgroundColor(0);
    }

    @Override // com.alibaba.griver.ui.refresh.RefreshHeader
    public void setProgress(float f) {
        GriverPullRefreshService griverPullRefreshService = this.f6748a;
        if (griverPullRefreshService != null) {
            griverPullRefreshService.setProgress(f);
        }
    }

    @Override // com.alibaba.griver.ui.refresh.RefreshHeader
    public void changeToState(RefreshHeader.RefreshState refreshState) {
        this.mState = refreshState;
        if (this.f6748a != null) {
            this.f6748a.changeToState(a(refreshState));
        } else if (this.b == null) {
        } else {
            if (refreshState == RefreshHeader.RefreshState.REFRESHING) {
                this.b.startLoading();
            } else {
                this.b.stopLoading();
            }
        }
    }

    private GriverPullRefreshService.IGriverRefreshState a(RefreshHeader.RefreshState refreshState) {
        if (refreshState == RefreshHeader.RefreshState.NONE) {
            return GriverPullRefreshService.IGriverRefreshState.NONE;
        }
        if (refreshState == RefreshHeader.RefreshState.PULL_TO_REFRESH) {
            return GriverPullRefreshService.IGriverRefreshState.PULL_TO_REFRESH;
        }
        if (refreshState == RefreshHeader.RefreshState.REFRESHING) {
            return GriverPullRefreshService.IGriverRefreshState.REFRESHING;
        }
        if (refreshState == RefreshHeader.RefreshState.RELEASE_TO_REFRESH) {
            return GriverPullRefreshService.IGriverRefreshState.RELEASE_TO_REFRESH;
        }
        return GriverPullRefreshService.IGriverRefreshState.NONE;
    }

    @Override // com.alibaba.griver.ui.refresh.RefreshHeader
    public void switchStyle(RefreshHeader.RefreshHeaderStyle refreshHeaderStyle) {
        if (this.f6748a != null) {
            this.f6748a.changeStyle(a(refreshHeaderStyle));
        } else if (this.b != null) {
            if (refreshHeaderStyle == RefreshHeader.RefreshHeaderStyle.NORMAL) {
                this.b.setDotsBackground(R.drawable.griver_ui_progress_view_bg_white);
            } else if (refreshHeaderStyle == RefreshHeader.RefreshHeaderStyle.DARK) {
                this.b.setDotsBackground(R.drawable.griver_ui_progress_view_bg);
            }
        }
    }

    private GriverPullRefreshService.IGRiverRefreshStyle a(RefreshHeader.RefreshHeaderStyle refreshHeaderStyle) {
        if (refreshHeaderStyle == RefreshHeader.RefreshHeaderStyle.DARK) {
            return GriverPullRefreshService.IGRiverRefreshStyle.DARK;
        }
        if (refreshHeaderStyle == RefreshHeader.RefreshHeaderStyle.NORMAL) {
            return GriverPullRefreshService.IGRiverRefreshStyle.LIGHT;
        }
        return null;
    }

    public ProgressView getProgressView() {
        return this.b;
    }
}
