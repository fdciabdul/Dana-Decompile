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
public class MarkerStyle1 extends MarkerStyle {

    /* renamed from: a  reason: collision with root package name */
    private String f7183a;
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
    private Paint m;
    private int n;

    /* renamed from: o  reason: collision with root package name */
    private int f7184o;

    public MarkerStyle1(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
        Context context = getContext();
        this.d = 0;
        this.e = DensityUtil.dip2px(context, 12.0f);
        this.f = DensityUtil.dip2px(context, 5.0f);
        this.g = DensityUtil.dip2px(context, 4.0f);
        this.h = DensityUtil.dip2px(context, 14.0f);
        this.i = DensityUtil.dip2px(context, 14.0f);
        this.j = DensityUtil.dip2px(context, 12.0f);
        this.l = DensityUtil.dip2px(context, 4.0f);
        Paint paint = new Paint();
        this.m = paint;
        paint.setTextSize(this.j);
        this.m.setColor(-12303292);
        this.m.setTextAlign(Paint.Align.LEFT);
        this.m.setTypeface(InstrumentInjector.typefaceCreateDerived(Typeface.SANS_SERIF, 0));
        this.m.setAntiAlias(true);
        this.m.setStrokeWidth(DensityUtil.dip2px(context, 1.5f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.alipay.mobile.embedview.mapbiz.marker.MarkerStyle
    public MarkerStyle bindData(JSONObject jSONObject) {
        this.f7183a = jSONObject.getString("icon1");
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
        Paint paint = this.m;
        String str = this.c;
        paint.getTextBounds(str, 0, str.length(), rect);
        this.mMeasuredWidth = (this.d * 2) + (this.e * 2) + this.h + rect.width() + this.g;
        this.mMeasuredHeight = (this.f * 2) + this.h + this.l;
        this.k = this.mMeasuredWidth - (this.d * 2);
        return true;
    }

    @Override // com.alipay.mobile.embedview.mapbiz.marker.MarkerStyle
    void getBitmapImpl(final MarkerStyle.Callback callback) {
        this.n = 0;
        int i = (!TextUtils.isEmpty(this.f7183a) ? 1 : 0) + 0;
        this.n = i;
        this.n = i + (!TextUtils.isEmpty(this.b) ? 1 : 0);
        final Bitmap createBitmap = Bitmap.createBitmap(this.mMeasuredWidth, this.mMeasuredHeight, Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(createBitmap);
        b(canvas);
        a(canvas);
        H5MapContainer h5MapContainer = this.mMapContainerRef.get();
        if (!TextUtils.isEmpty(this.f7183a) && h5MapContainer != null) {
            h5MapContainer.resourceLoader.loadImage(this.f7183a, new ZebraLoader.OnLoadImageCallback() { // from class: com.alipay.mobile.embedview.mapbiz.marker.MarkerStyle1.1
                @Override // com.alipay.mobile.zebra.ZebraLoader.OnLoadImageCallback
                public void onComplete(Bitmap bitmap) {
                    if (bitmap != null) {
                        MarkerStyle1.this.f7184o++;
                        MarkerStyle1.this.a(canvas, bitmap);
                        MarkerStyle1.this.a(callback, createBitmap);
                    }
                }
            });
        }
        if (TextUtils.isEmpty(this.b) || h5MapContainer == null) {
            return;
        }
        h5MapContainer.resourceLoader.loadImage(this.b, new ZebraLoader.OnLoadImageCallback() { // from class: com.alipay.mobile.embedview.mapbiz.marker.MarkerStyle1.2
            @Override // com.alipay.mobile.zebra.ZebraLoader.OnLoadImageCallback
            public void onComplete(Bitmap bitmap) {
                if (bitmap != null) {
                    MarkerStyle1.this.f7184o++;
                    MarkerStyle1.this.b(canvas, bitmap);
                    MarkerStyle1.this.a(callback, createBitmap);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MarkerStyle.Callback callback, Bitmap bitmap) {
        if (this.n <= this.f7184o) {
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
        canvas.translate(0.0f, ((this.mMeasuredHeight - this.l) - this.i) / 2);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        int i = this.h;
        canvas.drawBitmap(bitmap, getMatrix(rect, new Rect(0, 0, i, i)), paint);
        canvas.restore();
    }

    private void a(Canvas canvas) {
        Paint.FontMetrics fontMetrics = this.m.getFontMetrics();
        canvas.drawText(this.c, this.d + this.e + this.h + this.g, (int) ((((this.mMeasuredHeight - this.l) / 2) - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f)), this.m);
    }

    private void b(Canvas canvas) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#FBFBFB"));
        paint.setAlpha(255);
        RectF rectF = new RectF();
        rectF.set(0.0f, 0.0f, this.k, this.mMeasuredHeight - this.l);
        int save = canvas.save();
        canvas.translate(this.d, 0.0f);
        canvas.drawRoundRect(rectF, rectF.height() / 2.0f, rectF.height() / 2.0f, paint);
        int i = this.k / 2;
        int i2 = this.mMeasuredHeight;
        double d = this.l;
        double sqrt = Math.sqrt(2.0d);
        Double.isNaN(d);
        int i3 = i2 - ((int) (d * sqrt));
        int i4 = this.l;
        rectF.set(i - i4, i3 - i4, i + i4, i3 + i4);
        int save2 = canvas.save();
        canvas.rotate(45.0f, rectF.centerX(), rectF.centerY());
        canvas.drawRoundRect(rectF, 2.0f, 2.0f, paint);
        canvas.restoreToCount(save2);
        canvas.restoreToCount(save);
    }
}
