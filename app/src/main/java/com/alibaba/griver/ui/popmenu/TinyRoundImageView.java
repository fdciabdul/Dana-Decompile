package com.alibaba.griver.ui.popmenu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.utils.DensityUtil;
import com.alibaba.griver.ui.ant.AUImageView;

/* loaded from: classes6.dex */
public class TinyRoundImageView extends AUImageView {

    /* renamed from: a  reason: collision with root package name */
    private Paint f6737a;
    private Paint b;
    private BitmapShader c;
    private Matrix d;
    private Path e;
    private RectF f;
    private RectF g;
    private RectF h;
    private long i;
    private int j;
    private int k;
    private int l;
    private int m;

    public TinyRoundImageView(Context context) {
        this(context, null);
    }

    public TinyRoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TinyRoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = 0;
        this.k = 0;
        this.l = DensityUtil.dip2px(context, 2.0f);
        this.m = 0;
        this.j = 0;
        this.k = 0;
        a();
        setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private void a() {
        this.f6737a = new Paint();
        b();
        this.e = new Path();
        this.f = new RectF();
        this.h = new RectF();
        this.g = new RectF();
        this.d = new Matrix();
    }

    private void b() {
        Paint paint = new Paint();
        this.b = paint;
        paint.setAntiAlias(true);
        this.b.setColor(this.k);
        this.b.setStrokeWidth(this.m);
        this.b.setStyle(Paint.Style.STROKE);
    }

    public void setRadius(int i) {
        if (this.l != i) {
            this.l = i;
            c();
            postInvalidate();
        }
    }

    public void setDefaultImageColor(int i) {
        if (this.j != i) {
            this.j = i;
            postInvalidate();
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f.width() == getWidth() && this.f.height() == getHeight()) {
            return;
        }
        c();
    }

    private void c() {
        this.f.set(0.0f, 0.0f, getWidth(), getHeight());
        this.g.set(this.f);
        this.h.set(this.f);
        float f = this.m;
        this.g.inset(f, f);
        this.h.inset(f, f);
        this.e.reset();
        Path path = this.e;
        RectF rectF = this.g;
        float f2 = this.l;
        path.addRoundRect(rectF, f2, f2, Path.Direction.CW);
    }

    private void a(BitmapDrawable bitmapDrawable) {
        this.c = null;
        Bitmap bitmap = bitmapDrawable.getBitmap();
        if (bitmap != null) {
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.c = new BitmapShader(bitmap, tileMode, tileMode);
            a(bitmap);
            this.c.setLocalMatrix(this.d);
        }
        this.f6737a.reset();
        this.f6737a.setAntiAlias(true);
        this.f6737a.setShader(this.c);
        if (this.c == null) {
            this.f6737a.setColor(this.j);
        }
    }

    private void a(Bitmap bitmap) {
        float f;
        float f2;
        this.d.reset();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int width2 = (int) this.f.width();
        int height2 = (int) this.f.height();
        if ((width < 0 || width2 == width) && (height < 0 || height2 == height)) {
            return;
        }
        float f3 = 0.0f;
        if (width * height2 > width2 * height) {
            f2 = height2 / height;
            f3 = (width2 - (width * f2)) * 0.5f;
            f = 0.0f;
        } else {
            float f4 = width2 / width;
            f = (height2 - (height * f4)) * 0.5f;
            f2 = f4;
        }
        this.d.setScale(f2, f2);
        this.d.postTranslate(Math.round(f3), Math.round(f));
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0) {
            return;
        }
        if (this.l <= 0) {
            super.onDraw(canvas);
            return;
        }
        boolean z = false;
        boolean z2 = this.i != ((long) drawable.hashCode());
        if (z2) {
            this.i = drawable.hashCode();
        }
        if (drawable instanceof BitmapDrawable) {
            if (z2) {
                try {
                    a((BitmapDrawable) drawable);
                } catch (Throwable th) {
                    RVLogger.e("SimpleRoundImageView", th);
                    a(canvas, drawable);
                }
            }
            RectF rectF = this.g;
            float f = this.l;
            canvas.drawRoundRect(rectF, f, f, this.f6737a);
        } else if (drawable instanceof ColorDrawable) {
            if (z2) {
                try {
                    int color = ((ColorDrawable) drawable).getColor();
                    this.f6737a.reset();
                    this.f6737a.setAntiAlias(true);
                    this.f6737a.setColor(color);
                } catch (Throwable th2) {
                    RVLogger.e("SimpleRoundImageView", th2);
                    a(canvas, drawable);
                }
            }
            RectF rectF2 = this.g;
            float f2 = this.l;
            canvas.drawRoundRect(rectF2, f2, f2, this.f6737a);
        } else {
            int saveCount = canvas.getSaveCount();
            canvas.save();
            try {
                canvas.clipPath(this.e);
                if (getImageMatrix() != null) {
                    canvas.concat(getImageMatrix());
                }
                drawable.draw(canvas);
            } catch (Throwable th3) {
                RVLogger.e("SimpleRoundImageView", th3);
                z = true;
            }
            canvas.restoreToCount(saveCount);
            if (z) {
                a(canvas, drawable);
            }
        }
        if (this.m > 0) {
            try {
                RectF rectF3 = this.h;
                float f3 = this.l;
                canvas.drawRoundRect(rectF3, f3, f3, this.b);
            } catch (Throwable th4) {
                RVLogger.e("SimpleRoundImageView", th4);
            }
        }
    }

    private void a(Canvas canvas, Drawable drawable) {
        int saveCount = canvas.getSaveCount();
        canvas.save();
        if (getImageMatrix() != null) {
            canvas.concat(getImageMatrix());
        }
        drawable.draw(canvas);
        canvas.restoreToCount(saveCount);
    }
}
