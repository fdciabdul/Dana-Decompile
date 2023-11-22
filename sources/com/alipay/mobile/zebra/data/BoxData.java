package com.alipay.mobile.zebra.data;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.alipay.mobile.zebra.core.ZebraOption;
import com.alipay.mobile.zebra.internal.ZebraLog;
import com.alipay.mobile.zebra.layout.BoxLayout;

/* loaded from: classes7.dex */
public class BoxData extends ZebraData<BoxLayout> {
    public static final String ALIGN_BOTTOM = "bottom";
    public static final String ALIGN_LEFT = "left";
    public static final String ALIGN_MIDDLE = "middle";
    public static final String ALIGN_RIGHT = "right";
    public static final String ALIGN_TOP = "top";
    public static final String ATTR_H_ALIGN = "horizontal-align";
    public static final String ATTR_LAYOUT = "layout";
    public static final String ATTR_V_ALIGN = "vertical-align";
    public static final String LAYOUT_HORIZONTAL = "horizontal";
    public static final String LAYOUT_RELATIVE = "relative";
    public static final String LAYOUT_VERTICAL = "vertical";
    protected String mHorizontalAlign;
    protected String mLayout;
    protected String mVerticalAlign;

    public String getLayout() {
        return this.mLayout;
    }

    public void setLayout(String str) {
        this.mLayout = str;
    }

    public String getHorizontalAlign() {
        return this.mHorizontalAlign;
    }

    public void setHorizontalAlign(String str) {
        this.mHorizontalAlign = str;
    }

    public String getVerticalAlign() {
        return this.mVerticalAlign;
    }

    public void setVerticalAlign(String str) {
        this.mVerticalAlign = str;
    }

    @Override // com.alipay.mobile.zebra.data.ZebraData
    public void fromDSL(AttributeSet attributeSet, ZebraOption zebraOption) {
        super.fromDSL(attributeSet, zebraOption);
        String str = this.mAttributeMap.get(ATTR_LAYOUT);
        this.mLayout = str;
        if (str == null) {
            this.mLayout = LAYOUT_RELATIVE;
        }
        this.mHorizontalAlign = this.mAttributeMap.get(ATTR_H_ALIGN);
        this.mVerticalAlign = this.mAttributeMap.get(ATTR_V_ALIGN);
    }

    @Override // com.alipay.mobile.zebra.data.ZebraData
    public View render(Context context) {
        BoxLayout boxLayout = new BoxLayout();
        setLayoutContext(boxLayout);
        View render = boxLayout.render(context, this);
        if (render != null) {
            render.setTag(this);
        }
        if (render instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) render;
            for (int i = 0; i < this.mChildren.size(); i++) {
                View render2 = this.mChildren.get(i).render(context);
                if (render2 != null) {
                    viewGroup.addView(render2);
                } else {
                    ZebraLog.w("BoxData", "render child view is null");
                }
            }
        } else {
            ZebraLog.w("BoxData", "render view is not view group");
        }
        boxLayout.onFinishRender();
        return render;
    }
}
