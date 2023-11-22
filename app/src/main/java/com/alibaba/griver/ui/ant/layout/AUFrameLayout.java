package com.alibaba.griver.ui.ant.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.alibaba.griver.ui.ant.api.AUViewInterface;
import com.alibaba.griver.ui.ant.utils.AUAttrsUtils;
import com.alibaba.griver.ui.ant.utils.AUScreenUtils;

/* loaded from: classes6.dex */
public class AUFrameLayout extends FrameLayout implements AUViewInterface {

    /* renamed from: a  reason: collision with root package name */
    private Boolean f6684a;

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateLayoutParams(attributeSet);
    }

    public AUFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (AUScreenUtils.checkApFlag(context, attributeSet, this)) {
            AUAttrsUtils.adptApPadding(this, context);
        }
    }

    public AUFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (AUScreenUtils.checkApFlag(context, attributeSet, this)) {
            AUAttrsUtils.adptApPadding(this, context);
        }
    }

    public AUFrameLayout(Context context) {
        super(context);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (AUScreenUtils.checkApFlag(getContext(), attributeSet, this)) {
            int[] viewSizeAndMargin = AUAttrsUtils.getViewSizeAndMargin(getContext(), AUAttrsUtils.handleAttrs(attributeSet));
            FrameLayout.LayoutParams generateLayoutParams = super.generateLayoutParams(attributeSet);
            AUAttrsUtils.replaceLayoutParam(getContext(), generateLayoutParams, viewSizeAndMargin);
            return generateLayoutParams;
        }
        return super.generateLayoutParams(attributeSet);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        a(view);
        super.addView(view);
    }

    private void a(View view) {
        if (view instanceof AUViewInterface) {
            AUViewInterface aUViewInterface = (AUViewInterface) view;
            if (aUViewInterface.isAP() == null) {
                aUViewInterface.setAP(isAP());
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        a(view);
        super.addView(view, i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, int i2) {
        a(view);
        super.addView(view, i, i2);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        a(view);
        super.addView(view, layoutParams);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        a(view);
        super.addView(view, i, layoutParams);
    }

    @Override // com.alibaba.griver.ui.ant.api.AUViewInterface
    public Boolean isAP() {
        return this.f6684a;
    }

    @Override // com.alibaba.griver.ui.ant.api.AUViewInterface
    public void setAP(Boolean bool) {
        this.f6684a = bool;
    }
}
