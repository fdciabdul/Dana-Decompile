package com.alipay.mobile.zebra.layout;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceResponse;
import com.alipay.mobile.zebra.data.BoxData;
import com.alipay.mobile.zebra.data.ZebraData;
import com.alipay.mobile.zebra.graphics.ZebraColor;
import com.alipay.mobile.zebra.utils.ZebraUtils;

/* loaded from: classes7.dex */
public abstract class ZebraLayout<T extends ZebraData> {
    protected T mDataContext;
    protected View mRenderContext;

    public void onFinishRender() {
    }

    public boolean onReceiveResource(String str, String str2, WebResourceResponse webResourceResponse) {
        return true;
    }

    public abstract View render(Context context, T t);

    public T getDataContext() {
        return this.mDataContext;
    }

    public void setDataContext(T t) {
        this.mDataContext = t;
    }

    public View getRenderContext() {
        return this.mRenderContext;
    }

    public void setRenderContext(View view) {
        this.mRenderContext = view;
    }

    protected boolean isRelativeParent() {
        T t = this.mDataContext;
        if (t == null) {
            return true;
        }
        ZebraData<? extends ZebraLayout> parent = t.getParent();
        return !((parent instanceof BoxData) && !TextUtils.equals(((BoxData) parent).getLayout(), BoxData.LAYOUT_RELATIVE));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0151  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onRenderLayoutParams(android.content.Context r18) {
        /*
            Method dump skipped, instructions count: 406
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.zebra.layout.ZebraLayout.onRenderLayoutParams(android.content.Context):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRenderBackground(Context context) {
        GradientDrawable obtainBackground;
        if (this.mRenderContext == null || (obtainBackground = obtainBackground(context)) == null) {
            return;
        }
        if (this.mDataContext.isClickable()) {
            this.mRenderContext.setClickable(true);
            GradientDrawable obtainBackground2 = obtainBackground(context);
            if (obtainBackground2 != null) {
                obtainBackground2.setColor(536870912);
            }
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, new LayerDrawable(new Drawable[]{obtainBackground, obtainBackground2}));
            stateListDrawable.addState(new int[0], obtainBackground);
            this.mRenderContext.setBackgroundDrawable(stateListDrawable);
            return;
        }
        this.mRenderContext.setBackgroundDrawable(obtainBackground);
    }

    protected GradientDrawable obtainBackground(Context context) {
        GradientDrawable gradientDrawable;
        int dp2px;
        String backgroundColor = this.mDataContext.getBackgroundColor();
        if (backgroundColor != null) {
            int parseColor = ZebraColor.parseColor(backgroundColor);
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(parseColor);
        } else {
            gradientDrawable = null;
        }
        String borderColor = this.mDataContext.getBorderColor();
        float borderWidth = this.mDataContext.getBorderWidth();
        if (borderColor != null || borderWidth != -1.0f) {
            if (borderWidth != -1.0f) {
                dp2px = ZebraUtils.dp2px(context, borderWidth);
            } else {
                dp2px = ZebraUtils.dp2px(context, 1.0f);
            }
            int parseColor2 = borderColor != null ? ZebraColor.parseColor(borderColor) : -16777216;
            if (gradientDrawable == null) {
                gradientDrawable = new GradientDrawable();
            }
            gradientDrawable.setStroke(dp2px, parseColor2);
        }
        float borderRadius = this.mDataContext.getBorderRadius();
        if (borderRadius != -1.0f) {
            int dp2px2 = ZebraUtils.dp2px(context, borderRadius);
            if (gradientDrawable == null) {
                gradientDrawable = new GradientDrawable();
            }
            gradientDrawable.setCornerRadius(dp2px2);
        }
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRenderPadding(Context context) {
        if (this.mRenderContext == null) {
            return;
        }
        float padding = this.mDataContext.getPadding();
        int dp2px = padding != -1.0f ? ZebraUtils.dp2px(context, padding) : 0;
        float paddingLeft = this.mDataContext.getPaddingLeft();
        int dp2px2 = paddingLeft != -1.0f ? ZebraUtils.dp2px(context, paddingLeft) : dp2px;
        float paddingTop = this.mDataContext.getPaddingTop();
        int dp2px3 = paddingTop != -1.0f ? ZebraUtils.dp2px(context, paddingTop) : dp2px;
        float paddingRight = this.mDataContext.getPaddingRight();
        int dp2px4 = paddingRight != -1.0f ? ZebraUtils.dp2px(context, paddingRight) : dp2px;
        float paddingBottom = this.mDataContext.getPaddingBottom();
        int dp2px5 = paddingBottom != -1.0f ? ZebraUtils.dp2px(context, paddingBottom) : dp2px;
        if (dp2px == 0 && dp2px2 == 0 && dp2px3 == 0 && dp2px4 == 0 && dp2px5 == 0) {
            return;
        }
        this.mRenderContext.setPadding(dp2px2, dp2px3, dp2px4, dp2px5);
    }
}
