package com.alibaba.griver.ui.ant;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.alibaba.griver.ui.ant.api.AUViewInterface;
import com.alibaba.griver.ui.ant.helper.AUViewEventHelper;
import com.alibaba.griver.ui.ant.utils.AUAttrsUtils;
import com.alibaba.griver.ui.ant.utils.AUScreenUtils;

/* loaded from: classes6.dex */
public class AUImageView extends ImageView implements AUViewInterface {

    /* renamed from: a  reason: collision with root package name */
    private Boolean f6653a;

    public AUImageView(Context context) {
        super(context);
    }

    public AUImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (AUScreenUtils.checkApFlag(context, attributeSet, this)) {
            AUAttrsUtils.adptApPadding(this, context);
        }
    }

    public AUImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (AUScreenUtils.checkApFlag(context, attributeSet, this)) {
            AUAttrsUtils.adptApPadding(this, context);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(AUViewEventHelper.wrapClickListener(onClickListener));
    }

    @Override // com.alibaba.griver.ui.ant.api.AUViewInterface
    public Boolean isAP() {
        return this.f6653a;
    }

    @Override // com.alibaba.griver.ui.ant.api.AUViewInterface
    public void setAP(Boolean bool) {
        this.f6653a = bool;
    }
}
