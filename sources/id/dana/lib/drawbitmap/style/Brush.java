package id.dana.lib.drawbitmap.style;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import id.dana.lib.drawbitmap.style.typeface.TypeFaceFactory;

/* loaded from: classes5.dex */
public class Brush {
    private Canvas canvas;
    private Paint paint = new Paint();
    private TypeFaceFactory typeFace;

    public Brush(Context context, Canvas canvas) {
        this.canvas = canvas;
        this.typeFace = new TypeFaceFactory(context, 2);
    }

    public void stroke(Paint paint, String str, float f, CornerPathEffect cornerPathEffect) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.parseColor(str));
        paint.setStrokeWidth(f);
        paint.setPathEffect(cornerPathEffect);
        paint.setAntiAlias(true);
    }

    public void strokeDash(Paint paint, String str, float f) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.parseColor(str));
        paint.setStrokeWidth(f);
        paint.setPathEffect(new DashPathEffect(new float[]{6.0f, 4.0f, 6.0f, 4.0f}, 0.0f));
        paint.setAntiAlias(true);
    }

    public void stroke(Paint paint, String str, float f) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.parseColor(str));
        paint.setStrokeWidth(f);
        paint.setAntiAlias(true);
    }

    public void fill(Paint paint, String str, CornerPathEffect cornerPathEffect) {
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor(str));
        paint.setPathEffect(cornerPathEffect);
        paint.setAntiAlias(true);
    }

    public void fill(Paint paint, String str) {
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor(str));
        paint.setAntiAlias(true);
    }

    public void text(String str, float f, float f2, String str2, Paint.Align align) {
        this.paint.set(this.typeFace.getTypeface(str2));
        this.paint.setTextAlign(align);
        this.paint.setAntiAlias(true);
        this.canvas.drawText(str, f, f2, this.paint);
    }

    public int multilineText(String str, int i, int i2, int i3, String str2, Paint.Align align) {
        TextPaint textPaint = new TextPaint();
        textPaint.set(this.typeFace.getTypeface(str2));
        textPaint.setTextAlign(align);
        textPaint.setAntiAlias(true);
        String str3 = str.contains("\t") ? "\t" : " ";
        float measureText = textPaint.measureText(str3);
        int i4 = i;
        for (String str4 : str.split(str3)) {
            if (!str4.equals("")) {
                float measureText2 = textPaint.measureText(str4);
                if ((750 - i4) - i3 >= measureText2) {
                    float f = i4;
                    this.canvas.drawText(str4, f, i2, textPaint);
                    i4 = (int) (f + measureText2 + measureText);
                } else {
                    i2 = (int) (i2 + (textPaint.descent() - textPaint.ascent()));
                    float f2 = i;
                    this.canvas.drawText(str4, f2, i2, textPaint);
                    i4 = (int) (f2 + measureText2 + measureText);
                }
            }
        }
        return i2;
    }

    public int multilineTextChar(String str, int i, int i2, int i3, String str2, Paint.Align align) {
        int length = str.length();
        int min = Math.min(length, i3);
        TextPaint textPaint = new TextPaint();
        textPaint.set(this.typeFace.getTypeface(str2));
        textPaint.setTextAlign(align);
        textPaint.setAntiAlias(true);
        int i4 = 0;
        int i5 = 0;
        while (length > 0) {
            if (i4 > 0) {
                i2 = (int) (i2 + (textPaint.descent() - textPaint.ascent()));
            }
            this.canvas.drawText(str.substring(i5, min), i, i2, textPaint);
            i5 += min;
            length -= i3;
            min += length;
            i4++;
        }
        return i2;
    }

    public void text(String str, float f, float f2, String str2) {
        this.paint.set(this.typeFace.getTypeface(str2));
        this.paint.setAntiAlias(true);
        this.canvas.drawText(str, f, f2, this.paint);
    }

    public float textLenght(String str, String str2) {
        this.paint.set(this.typeFace.getTypeface(str2));
        return this.paint.measureText(str);
    }

    public void text(String str, float f, float f2, int i, String str2, String str3) {
        this.paint.set(this.typeFace.getCustomTypeface(i, str2, str3));
        this.paint.setAntiAlias(true);
        this.canvas.drawText(str, f, f2, this.paint);
    }

    public void text(String str, float f, float f2, int i, String str2, String str3, Paint.Align align) {
        this.paint.set(this.typeFace.getCustomTypeface(i, str2, str3));
        this.paint.setTextAlign(align);
        this.paint.setAntiAlias(true);
        this.canvas.drawText(str, f, f2, this.paint);
    }

    public void text(String str, float f, float f2) {
        this.paint.setAntiAlias(true);
        this.canvas.drawText(str, f, f2, this.paint);
    }

    public void text(String str, float f, float f2, int i, String str2, Paint.Align align) {
        TextPaint textPaint = new TextPaint();
        textPaint.set(this.typeFace.getTypeface(str2));
        textPaint.setTextAlign(align);
        textPaint.setAntiAlias(true);
        CharSequence ellipsize = TextUtils.ellipsize(str, textPaint, i, TextUtils.TruncateAt.END);
        this.canvas.drawText(ellipsize, 0, ellipsize.length(), f, f2, textPaint);
    }
}
