package com.alibaba.griver.ui.popmenu;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.fullstory.instrumentation.FSDraw;

/* loaded from: classes6.dex */
public class TinyMenuBgDrawable extends Drawable implements FSDraw {

    /* renamed from: a  reason: collision with root package name */
    private Bitmap f6731a;
    private Paint b;
    private Rect c;
    private Rect d;
    private boolean e = false;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public TinyMenuBgDrawable(Bitmap bitmap, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f6731a = bitmap;
        Paint paint = new Paint();
        this.b = paint;
        paint.setAntiAlias(true);
        if (this.f6731a != null) {
            this.c = new Rect(i, i2, i3, i4);
        } else {
            this.c = new Rect(0, 0, 0, 0);
        }
        this.d = new Rect(i5, i6, i7, i8);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        try {
            if (this.f6731a != null && !this.e) {
                Rect rect = this.c;
                if (rect != null && rect.width() > 0 && this.c.height() > 0) {
                    canvas.drawBitmap(this.f6731a, this.c, this.d, this.b);
                    return;
                } else {
                    canvas.drawColor(-285673224);
                    return;
                }
            }
            canvas.drawColor(-285673224);
        } catch (Throwable th) {
            RVLogger.e("TinyMenuBgDrawable", th);
            this.e = true;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Paint paint = this.b;
        if (paint != null) {
            paint.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Paint paint = this.b;
        if (paint != null) {
            paint.setColorFilter(colorFilter);
        }
    }
}
