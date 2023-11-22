package com.zoloz.android.phone.zdoc.ui;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.alipay.mobile.security.bio.utils.DisplayUtil;
import com.zoloz.android.phone.zdoc.ui.BaseMaskView;
import java.util.List;

/* loaded from: classes8.dex */
public class EmptyMaskView extends BaseMaskView {
    @Override // com.zoloz.android.phone.zdoc.ui.BaseMaskView
    protected List<BaseMaskView.AbsMaskDrawer> getCoverDrawer(int i, int i2) {
        return null;
    }

    @Override // com.zoloz.android.phone.zdoc.ui.BaseMaskView
    protected List<BaseMaskView.AbsMaskDrawer> getFrameDrawer(int i, int i2) {
        return null;
    }

    public EmptyMaskView(Context context) {
        super(context);
    }

    public EmptyMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EmptyMaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.zoloz.android.phone.zdoc.ui.BaseMaskView
    protected RectF calcCaptureRect(int i, int i2) {
        return new RectF(0.0f, DisplayUtil.dip2px(getContext(), 48.0f), i, i2 - getInvisibleHeight());
    }

    @Override // com.zoloz.android.phone.zdoc.ui.BaseMaskView
    public int getTipsBottomMargin() {
        return (int) (getHeight() * 0.85f);
    }
}
