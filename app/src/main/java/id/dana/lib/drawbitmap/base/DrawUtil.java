package id.dana.lib.drawbitmap.base;

import android.text.TextPaint;

/* loaded from: classes5.dex */
public final class DrawUtil {
    public static int calculateMultiline(String str, int i, int i2, int i3) {
        float f;
        TextPaint textPaint = new TextPaint();
        String str2 = str.contains("\t") ? "\t" : " ";
        float measureText = textPaint.measureText(str2);
        int i4 = i;
        for (String str3 : str.split(str2)) {
            if (!str3.equals("")) {
                float measureText2 = textPaint.measureText(str3);
                if ((750 - i4) - i3 >= measureText2) {
                    f = i4;
                } else {
                    i2 = (int) (i2 + (textPaint.descent() - textPaint.ascent()));
                    f = i;
                }
                i4 = (int) (f + measureText2 + measureText);
            }
        }
        return i2;
    }
}
