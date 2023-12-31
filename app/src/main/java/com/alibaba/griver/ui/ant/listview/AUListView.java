package com.alibaba.griver.ui.ant.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AdapterView;
import android.widget.ListView;
import com.alibaba.griver.ui.ant.api.AUViewInterface;
import com.alibaba.griver.ui.ant.helper.AUViewEventHelper;

/* loaded from: classes6.dex */
public class AUListView extends ListView implements AUViewInterface {

    /* renamed from: a  reason: collision with root package name */
    private Boolean f6690a;

    public AUListView(Context context) {
        super(context);
    }

    public AUListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AUListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        super.setOnItemClickListener(AUViewEventHelper.wrapItemClickListener(onItemClickListener));
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        postInvalidate();
    }

    @Override // com.alibaba.griver.ui.ant.api.AUViewInterface
    public Boolean isAP() {
        return this.f6690a;
    }

    @Override // com.alibaba.griver.ui.ant.api.AUViewInterface
    public void setAP(Boolean bool) {
        this.f6690a = bool;
    }
}
