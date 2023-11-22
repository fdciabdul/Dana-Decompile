package com.alibaba.griver.ui.refresh;

import android.content.Context;
import android.view.View;
import com.alibaba.griver.ui.refresh.RefreshHeader;

/* loaded from: classes6.dex */
public class GriverPullDownHeader extends RefreshHeader {

    /* renamed from: a  reason: collision with root package name */
    private ProgressView f6747a;

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

    @Override // com.alibaba.griver.ui.refresh.RefreshHeader
    public void switchStyle(RefreshHeader.RefreshHeaderStyle refreshHeaderStyle) {
    }

    public GriverPullDownHeader(Context context) {
        super(context);
        changeToState(RefreshHeader.RefreshState.NONE);
        setBackgroundColor(0);
        this.f6747a = new ProgressView(context);
    }

    @Override // com.alibaba.griver.ui.refresh.RefreshHeader
    public void setProgress(float f) {
        this.f6747a.startLoading();
    }

    @Override // com.alibaba.griver.ui.refresh.RefreshHeader
    public void changeToState(RefreshHeader.RefreshState refreshState) {
        this.mState = refreshState;
    }
}
