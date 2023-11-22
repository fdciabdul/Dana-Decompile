package com.alipay.mobile.zebra.data;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.alipay.mobile.zebra.core.ZebraOption;
import com.alipay.mobile.zebra.layout.TextLayout;
import com.alipay.mobile.zebra.utils.ZebraUtils;

/* loaded from: classes7.dex */
public class TextData extends ZebraData<TextLayout> {
    public static final String ALIGN_CENTER = "center";
    public static final String ALIGN_LEFT = "left";
    public static final String ALIGN_RIGHT = "right";
    public static final String ATTR_COLOR = "color";
    public static final String ATTR_FONT_SIZE = "font-size";
    public static final String ATTR_FONT_WEIGHT = "font-weight";
    public static final String ATTR_NUMBER_OF_LINES = "number-of-lines";
    public static final String ATTR_STROKE_COLOR = "stroke-color";
    public static final String ATTR_STROKE_WIDTH = "stroke-width";
    public static final String ATTR_TEXT = "text";
    public static final String ATTR_TEXT_ALIGN = "text-align";
    public static final String FONT_WEIGHT_BOLD = "bold";
    public static final String FONT_WEIGHT_NORMAL = "normal";
    protected String mColor;
    protected String mFontWeight;
    protected String mStrokeColor;
    protected String mText;
    protected String mTextAlign;
    protected float mFontSize = -1.0f;
    protected int mNumberOfLines = -1;
    protected float mStrokeWidth = -1.0f;

    public String getTextAlign() {
        return this.mTextAlign;
    }

    public void setTextAlign(String str) {
        this.mTextAlign = str;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public void setStrokeWidth(float f) {
        this.mStrokeWidth = f;
    }

    public String getStrokeColor() {
        return this.mStrokeColor;
    }

    public void setStrokeColor(String str) {
        this.mStrokeColor = str;
    }

    public int getNumberOfLines() {
        return this.mNumberOfLines;
    }

    public void setNumberOfLines(int i) {
        this.mNumberOfLines = i;
    }

    public String getText() {
        return this.mText;
    }

    public void setText(String str) {
        this.mText = str;
    }

    public String getColor() {
        return this.mColor;
    }

    public void setColor(String str) {
        this.mColor = str;
    }

    public float getFontSize() {
        return this.mFontSize;
    }

    public void setFontSize(float f) {
        this.mFontSize = f;
    }

    public String getFontWeight() {
        return this.mFontWeight;
    }

    public void setFontWeight(String str) {
        this.mFontWeight = str;
    }

    @Override // com.alipay.mobile.zebra.data.ZebraData
    public void fromDSL(AttributeSet attributeSet, ZebraOption zebraOption) {
        int parseInt;
        super.fromDSL(attributeSet, zebraOption);
        this.mText = this.mAttributeMap.get("text");
        this.mColor = this.mAttributeMap.get("color");
        String str = this.mAttributeMap.get(ATTR_FONT_SIZE);
        if (str != null) {
            float parseFloat = ZebraUtils.parseFloat(str, -1.0f);
            if (parseFloat != -1.0f) {
                this.mFontSize = parseFloat;
            }
        }
        String str2 = this.mAttributeMap.get(ATTR_NUMBER_OF_LINES);
        if (str2 != null && (parseInt = ZebraUtils.parseInt(str2)) != -1) {
            this.mNumberOfLines = parseInt;
        }
        this.mStrokeColor = this.mAttributeMap.get(ATTR_STROKE_COLOR);
        String str3 = this.mAttributeMap.get(ATTR_STROKE_WIDTH);
        if (str3 != null) {
            float parseFloat2 = ZebraUtils.parseFloat(str3);
            if (parseFloat2 != -1.0f) {
                this.mStrokeWidth = parseFloat2;
            }
        }
        this.mTextAlign = this.mAttributeMap.get(ATTR_TEXT_ALIGN);
        this.mFontWeight = this.mAttributeMap.get(ATTR_FONT_WEIGHT);
    }

    @Override // com.alipay.mobile.zebra.data.ZebraData
    public View render(Context context) {
        TextLayout textLayout = new TextLayout();
        setLayoutContext(textLayout);
        View render = textLayout.render(context, this);
        if (render != null) {
            render.setTag(this);
        }
        textLayout.onFinishRender();
        return render;
    }
}
