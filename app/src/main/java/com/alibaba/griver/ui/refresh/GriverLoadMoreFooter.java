package com.alibaba.griver.ui.refresh;

import android.content.Context;
import android.widget.TextView;
import com.alibaba.griver.ui.refresh.LoadMoreFooter;

/* loaded from: classes6.dex */
public class GriverLoadMoreFooter extends LoadMoreFooter {

    /* renamed from: a  reason: collision with root package name */
    private LoadMoreFooter.LoadMoreState f6746a;

    @Override // com.alibaba.griver.ui.refresh.LoadMoreFooter
    public void setLoadMoreTipColor(int i) {
    }

    @Override // com.alibaba.griver.ui.refresh.LoadMoreFooter
    public void setLoadMoreTips(String[] strArr) {
    }

    @Override // com.alibaba.griver.ui.refresh.LoadMoreFooter
    public void setProgress(float f) {
    }

    public GriverLoadMoreFooter(Context context) {
        super(context);
        this.f6746a = LoadMoreFooter.LoadMoreState.NONE;
        changeToState(LoadMoreFooter.LoadMoreState.NONE);
    }

    @Override // com.alibaba.griver.ui.refresh.LoadMoreFooter
    public void changeToState(LoadMoreFooter.LoadMoreState loadMoreState) {
        this.f6746a = loadMoreState;
    }

    @Override // com.alibaba.griver.ui.refresh.LoadMoreFooter
    public LoadMoreFooter.LoadMoreState getCurrentState() {
        return this.f6746a;
    }

    @Override // com.alibaba.griver.ui.refresh.LoadMoreFooter
    public TextView getLoadMoreTipView() {
        return new TextView(getContext());
    }
}
