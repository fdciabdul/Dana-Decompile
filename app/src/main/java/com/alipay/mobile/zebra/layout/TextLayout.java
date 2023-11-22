package com.alipay.mobile.zebra.layout;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import com.alipay.mobile.zebra.data.TextData;
import com.alipay.mobile.zebra.graphics.ZebraColor;
import com.alipay.mobile.zebra.utils.ZebraUtils;
import com.alipay.mobile.zebra.widget.TextBox;

/* loaded from: classes7.dex */
public class TextLayout extends ZebraLayout<TextData> {
    @Override // com.alipay.mobile.zebra.layout.ZebraLayout
    public View render(Context context, TextData textData) {
        setDataContext(textData);
        TextBox textBox = new TextBox(context);
        setRenderContext(textBox);
        onRenderLayoutParams(context);
        onRenderBackground(context);
        onRenderPadding(context);
        String text = textData.getText();
        if (text != null) {
            textBox.setText(text);
        }
        String color = textData.getColor();
        if (color != null) {
            textBox.setTextColor(ZebraColor.parseColor(color));
        } else {
            textBox.setTextColor(-16777216);
        }
        float fontSize = textData.getFontSize();
        if (fontSize == -1.0f) {
            fontSize = 12.0f;
        }
        textBox.setTextSize(0, ZebraUtils.dp2px(context, fontSize));
        int numberOfLines = textData.getNumberOfLines();
        if (numberOfLines > 0) {
            textBox.setMaxLines(numberOfLines);
            textBox.setEllipsize(TextUtils.TruncateAt.END);
        }
        float strokeWidth = textData.getStrokeWidth();
        if (strokeWidth > 0.0f) {
            textBox.setStrokeWidth(ZebraUtils.dp2px(context, strokeWidth));
        }
        String strokeColor = textData.getStrokeColor();
        if (strokeColor != null) {
            textBox.setStrokeColor(ZebraColor.parseColor(strokeColor, -1));
        }
        String textAlign = textData.getTextAlign();
        if (textAlign != null) {
            if (TextData.ALIGN_CENTER.equals(textAlign)) {
                textBox.setGravity(1);
            } else if ("right".equals(textAlign)) {
                textBox.setGravity(5);
            } else if ("left".equals(textAlign)) {
                textBox.setGravity(3);
            }
        }
        String fontWeight = textData.getFontWeight();
        if (fontWeight != null) {
            if (TextData.FONT_WEIGHT_BOLD.equals(fontWeight)) {
                textBox.setTypeface(Typeface.DEFAULT_BOLD);
            } else if ("normal".equals(fontWeight)) {
                textBox.setTypeface(Typeface.DEFAULT);
            }
        }
        return textBox;
    }
}
