package com.alibaba.griver.ui.ant.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import com.alibaba.griver.ui.ant.api.AUViewInterface;
import com.alibaba.griver.ui.ant.helper.AUViewEventHelper;
import com.alibaba.griver.ui.ant.utils.AUAttrsUtils;
import com.alibaba.griver.ui.ant.utils.AUScreenUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* loaded from: classes6.dex */
public class AURelativeLayout extends RelativeLayout implements AUViewInterface {

    /* renamed from: a  reason: collision with root package name */
    private AttributeSet f6686a;
    private Boolean b;

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateLayoutParams(attributeSet);
    }

    public AURelativeLayout(Context context) {
        super(context);
    }

    public AURelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6686a = attributeSet;
        if (AUScreenUtils.checkApFlag(context, attributeSet, this)) {
            AUAttrsUtils.adptApPadding(this, context);
            AUAttrsUtils.adptApMinMax(this, context);
        }
    }

    public AURelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6686a = attributeSet;
        if (AUScreenUtils.checkApFlag(context, attributeSet, this)) {
            AUAttrsUtils.adptApPadding(this, context);
            AUAttrsUtils.adptApMinMax(this, context);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public RelativeLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (AUScreenUtils.checkApFlag(getContext(), attributeSet, this)) {
            if (getLayoutParams() != null && (getLayoutParams() instanceof GridLayoutManager.LayoutParams) && getSuggestedMinimumHeight() > 0 && getLayoutParams().height < getSuggestedMinimumHeight()) {
                getLayoutParams().height = getSuggestedMinimumHeight();
            }
            int[] viewSizeAndMargin = AUAttrsUtils.getViewSizeAndMargin(getContext(), AUAttrsUtils.handleAttrs(attributeSet));
            RelativeLayout.LayoutParams generateLayoutParams = super.generateLayoutParams(attributeSet);
            AUAttrsUtils.replaceLayoutParam(getContext(), generateLayoutParams, viewSizeAndMargin);
            return generateLayoutParams;
        }
        return super.generateLayoutParams(attributeSet);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        try {
            if (getLayoutParams() == null) {
                setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), i), getDefaultSize(getSuggestedMinimumHeight(), i2));
            } else {
                super.onMeasure(i, i2);
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("APRelativeLayout:");
            sb.append(getId());
            StringBuffer stringBuffer = new StringBuffer(sb.toString());
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                    sb2.append(childAt.getId());
                    stringBuffer.append(sb2.toString());
                }
            }
            throw new IllegalStateException(stringBuffer.toString(), e);
        }
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

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(AUViewEventHelper.wrapClickListener(onClickListener));
    }

    public Boolean isAP() {
        return this.b;
    }

    public void setAP(Boolean bool) {
        this.b = bool;
    }
}
