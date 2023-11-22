package com.alipay.mobile.zebra.layout;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.alipay.mobile.zebra.data.BoxData;
import com.alipay.mobile.zebra.data.ZebraData;
import com.alipay.mobile.zebra.widget.FrameBox;
import com.alipay.mobile.zebra.widget.GravityParams;
import com.alipay.mobile.zebra.widget.LinearBox;
import com.alipay.mobile.zebra.widget.PercentBox;

/* loaded from: classes7.dex */
public class BoxLayout extends ZebraLayout<BoxData> {
    @Override // com.alipay.mobile.zebra.layout.ZebraLayout
    public View render(Context context, BoxData boxData) {
        View renderRelative;
        setDataContext(boxData);
        String layout = boxData.getLayout();
        if (BoxData.LAYOUT_HORIZONTAL.equals(layout)) {
            renderRelative = renderHorizontal(context);
        } else if (BoxData.LAYOUT_VERTICAL.equals(layout)) {
            renderRelative = renderVertical(context);
        } else {
            BoxData.LAYOUT_RELATIVE.equals(layout);
            renderRelative = renderRelative(context);
        }
        onRenderLayoutParams(context);
        onRenderBackground(context);
        onRenderPadding(context);
        return renderRelative;
    }

    @Override // com.alipay.mobile.zebra.layout.ZebraLayout
    public void onFinishRender() {
        if (this.mDataContext == 0 || this.mRenderContext == null) {
            return;
        }
        String horizontalAlign = ((BoxData) this.mDataContext).getHorizontalAlign();
        String verticalAlign = ((BoxData) this.mDataContext).getVerticalAlign();
        boolean z = false;
        boolean z2 = (horizontalAlign == null && verticalAlign == null) ? false : true;
        if (this.mRenderContext instanceof PercentBox) {
            for (ZebraData zebraData : ((BoxData) this.mDataContext).getChildren()) {
                if (zebraData.getPercentWidth() != -1.0f || zebraData.getPercentHeight() != -1.0f || zebraData.getPercentLeft() != -1.0f || zebraData.getPercentTop() != -1.0f || zebraData.getPercentRight() != -1.0f || zebraData.getPercentBottom() != -1.0f) {
                    z = true;
                }
                if (z2) {
                    if (zebraData.getLayoutContext() != null && zebraData.getLayoutContext().getRenderContext() != null) {
                        ViewGroup.LayoutParams layoutParams = zebraData.getLayoutContext().getRenderContext().getLayoutParams();
                        if (layoutParams instanceof GravityParams) {
                            GravityParams gravityParams = (GravityParams) layoutParams;
                            int gravity = gravityParams.getGravity();
                            if (TextUtils.equals("middle", horizontalAlign)) {
                                gravity = (gravity == -1 || gravity == 0) ? 1 : gravity | 1;
                            }
                            if (TextUtils.equals("middle", verticalAlign)) {
                                gravity = (gravity == -1 || gravity == 0) ? 16 : gravity | 16;
                            }
                            gravityParams.setGravity(gravity);
                        }
                    }
                } else if (z) {
                    break;
                }
            }
            if (z) {
                ((PercentBox) this.mRenderContext).setPercentLayoutEnabled(true);
            }
        }
    }

    protected LinearBox renderHorizontal(Context context) {
        LinearBox linearBox = new LinearBox(context);
        linearBox.setOrientation(0);
        setRenderContext(linearBox);
        return linearBox;
    }

    protected LinearBox renderVertical(Context context) {
        LinearBox linearBox = new LinearBox(context);
        linearBox.setOrientation(1);
        setRenderContext(linearBox);
        return linearBox;
    }

    protected FrameBox renderRelative(Context context) {
        FrameBox frameBox = new FrameBox(context);
        setRenderContext(frameBox);
        return frameBox;
    }
}
