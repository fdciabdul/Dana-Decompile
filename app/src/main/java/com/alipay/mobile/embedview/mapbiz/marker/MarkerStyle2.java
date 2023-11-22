package com.alipay.mobile.embedview.mapbiz.marker;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.utils.DensityUtil;
import com.alipay.mobile.embedview.mapbiz.marker.MarkerStyle;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import com.alipay.mobile.zebra.ZebraLoader;
import com.fullstory.instrumentation.InstrumentInjector;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class MarkerStyle2 extends MarkerStyle {

    /* renamed from: a  reason: collision with root package name */
    private String f7185a;
    private String b;
    private String c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private Paint n;

    /* renamed from: o  reason: collision with root package name */
    private int f7186o;
    private int p;

    public MarkerStyle2(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
        Context context = getContext();
        this.d = 0;
        this.e = DensityUtil.dip2px(context, 16.0f);
        this.f = DensityUtil.dip2px(context, 7.0f);
        this.g = DensityUtil.dip2px(context, 5.0f);
        this.h = DensityUtil.dip2px(context, 15.0f);
        this.i = DensityUtil.dip2px(context, 15.0f);
        this.j = DensityUtil.dip2px(context, 13.0f);
        this.l = DensityUtil.dip2px(context, 4.0f);
        this.m = DensityUtil.dip2px(context, 3.0f);
        Paint paint = new Paint();
        this.n = paint;
        paint.setTextSize(this.j);
        this.n.setColor(-12303292);
        this.n.setTextAlign(Paint.Align.LEFT);
        this.n.setAntiAlias(true);
        this.n.setTypeface(InstrumentInjector.typefaceCreateDerived(Typeface.SANS_SERIF, 1));
        this.n.setStrokeWidth(DensityUtil.dip2px(context, 1.5f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.alipay.mobile.embedview.mapbiz.marker.MarkerStyle
    public MarkerStyle bindData(JSONObject jSONObject) {
        this.f7185a = jSONObject.getString("icon1");
        this.c = jSONObject.getString("text1");
        this.b = jSONObject.getString("icon2");
        if (getContext() != null) {
            if (TextUtils.isEmpty(this.b)) {
                this.d = 0;
            } else {
                this.d = this.i / 2;
            }
        }
        return this;
    }

    @Override // com.alipay.mobile.embedview.mapbiz.marker.MarkerStyle
    boolean measure() {
        Rect rect = new Rect();
        Paint paint = this.n;
        String str = this.c;
        paint.getTextBounds(str, 0, str.length(), rect);
        this.mMeasuredWidth = (this.d * 2) + (this.e * 2) + this.h + rect.width() + this.g;
        this.mMeasuredHeight = (this.f * 2) + this.h + this.l + this.m;
        this.k = this.mMeasuredWidth - (this.d * 2);
        return true;
    }

    @Override // com.alipay.mobile.embedview.mapbiz.marker.MarkerStyle
    void getBitmapImpl(final MarkerStyle.Callback callback) {
        this.f7186o = 0;
        int i = (!TextUtils.isEmpty(this.f7185a) ? 1 : 0) + 0;
        this.f7186o = i;
        this.f7186o = i + (!TextUtils.isEmpty(this.b) ? 1 : 0);
        final Bitmap createBitmap = Bitmap.createBitmap(this.mMeasuredWidth, this.mMeasuredHeight, Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(createBitmap);
        b(canvas);
        a(canvas);
        H5MapContainer h5MapContainer = this.mMapContainerRef.get();
        if (!TextUtils.isEmpty(this.f7185a) && h5MapContainer != null) {
            h5MapContainer.resourceLoader.loadImage(this.f7185a, new ZebraLoader.OnLoadImageCallback() { // from class: com.alipay.mobile.embedview.mapbiz.marker.MarkerStyle2.1
                @Override // com.alipay.mobile.zebra.ZebraLoader.OnLoadImageCallback
                public void onComplete(Bitmap bitmap) {
                    if (bitmap != null) {
                        MarkerStyle2.this.p++;
                        MarkerStyle2.this.a(canvas, bitmap);
                        MarkerStyle2.this.a(callback, createBitmap);
                    }
                }
            });
        }
        if (TextUtils.isEmpty(this.b) || h5MapContainer == null) {
            return;
        }
        h5MapContainer.resourceLoader.loadImage(this.b, new ZebraLoader.OnLoadImageCallback() { // from class: com.alipay.mobile.embedview.mapbiz.marker.MarkerStyle2.2
            @Override // com.alipay.mobile.zebra.ZebraLoader.OnLoadImageCallback
            public void onComplete(Bitmap bitmap) {
                if (bitmap != null) {
                    MarkerStyle2.this.p++;
                    MarkerStyle2.this.b(canvas, bitmap);
                    MarkerStyle2.this.a(callback, createBitmap);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MarkerStyle.Callback callback, Bitmap bitmap) {
        if (this.f7186o <= this.p) {
            callback.call(bitmap, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Canvas canvas, Bitmap bitmap) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.save();
        canvas.translate(this.d + this.e, this.f);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        int i = this.h;
        canvas.drawBitmap(bitmap, getMatrix(rect, new Rect(0, 0, i, i)), paint);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Canvas canvas, Bitmap bitmap) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.save();
        canvas.translate(0.0f, (((this.mMeasuredHeight - this.l) - this.m) - this.i) / 2);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        int i = this.h;
        canvas.drawBitmap(bitmap, getMatrix(rect, new Rect(0, 0, i, i)), paint);
        canvas.restore();
    }

    private void a(Canvas canvas) {
        Paint.FontMetrics fontMetrics = this.n.getFontMetrics();
        canvas.drawText(this.c, this.d + this.e + this.h + this.g, (int) (((((this.mMeasuredHeight - this.l) - this.m) / 2) - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f)), this.n);
    }

    private void b(Canvas canvas) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setAlpha(255);
        RectF rectF = new RectF();
        int save = canvas.save();
        canvas.translate(this.d, 0.0f);
        paint.setColor(Color.parseColor("#FBFBFB"));
        float f = this.k / 2;
        int i = this.mMeasuredHeight;
        canvas.drawCircle(f, (i - r8) - 1, this.m, paint);
        paint.setColor(Color.parseColor("#FC8200"));
        float f2 = this.k / 2;
        int i2 = this.mMeasuredHeight;
        canvas.drawCircle(f2, (i2 - r8) - 1, (float) (this.m - 3), paint);
        paint.setColor(Color.parseColor("#FBFBFB"));
        rectF.set(0.0f, 0.0f, this.k, (this.mMeasuredHeight - this.l) - this.m);
        canvas.drawRoundRect(rectF, rectF.height() / 2.0f, rectF.height() / 2.0f, paint);
        int i3 = this.k / 2;
        int i4 = this.mMeasuredHeight;
        int i5 = this.m;
        double d = this.l;
        double sqrt = Math.sqrt(2.0d);
        Double.isNaN(d);
        int i6 = (i4 - i5) - ((int) (d * sqrt));
        int i7 = this.l;
        rectF.set(i3 - i7, i6 - i7, i3 + i7, i6 + i7);
        int save2 = canvas.save();
        canvas.rotate(45.0f, rectF.centerX(), rectF.centerY());
        canvas.drawRoundRect(rectF, 2.0f, 2.0f, paint);
        canvas.restoreToCount(save2);
        paint.setColor(Color.parseColor("#FFE700"));
        rectF.set(3.0f, 3.0f, (float) (this.k - 3), (float) (((this.mMeasuredHeight - this.l) - this.m) - 3));
        canvas.drawRoundRect(rectF, rectF.height() / 2.0f, rectF.height() / 2.0f, paint);
        int i8 = this.k / 2;
        int i9 = this.mMeasuredHeight;
        int i10 = this.m;
        double d2 = this.l;
        double sqrt2 = Math.sqrt(2.0d);
        Double.isNaN(d2);
        int i11 = (i9 - i10) - ((int) (d2 * sqrt2));
        int i12 = this.l;
        rectF.set((i8 - i12) + 3, (i11 - i12) + 3, (float) ((i8 + i12) - 3), (float) ((i11 + i12) - 3));
        int save3 = canvas.save();
        canvas.rotate(45.0f, rectF.centerX(), rectF.centerY());
        canvas.drawRoundRect(rectF, 2.0f, 2.0f, paint);
        canvas.restoreToCount(save3);
        canvas.restoreToCount(save);
    }
}
