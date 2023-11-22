package com.alipay.mobile.embedview.mapbiz.marker;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.utils.DensityUtil;
import com.alipay.mobile.embedview.mapbiz.marker.MarkerStyle;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import com.alipay.mobile.embedview.mapbiz.utils.H5MapUtils;
import com.alipay.mobile.zebra.data.ZebraData;
import com.fullstory.instrumentation.InstrumentInjector;
import com.iap.ac.android.region.cdp.util.CdpConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class MarkerLabel extends MarkerStyle {

    /* renamed from: a  reason: collision with root package name */
    private String f7181a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private Bitmap h;
    private int i;
    private int j;
    private Paint k;
    private int l;
    private int m;
    private int n;

    /* renamed from: o  reason: collision with root package name */
    private int f7182o;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MarkerLabel(H5MapContainer h5MapContainer, Bitmap bitmap) {
        super(h5MapContainer);
        this.h = bitmap;
        if (bitmap != null) {
            this.i = bitmap.getWidth();
            this.j = this.h.getHeight();
        } else {
            this.i = 0;
            this.j = 0;
        }
        Paint paint = new Paint();
        this.k = paint;
        paint.setTextAlign(Paint.Align.LEFT);
        this.k.setTypeface(InstrumentInjector.typefaceCreateDerived(Typeface.SANS_SERIF, 0));
        this.k.setAntiAlias(true);
        this.k.setStrokeWidth(DensityUtil.dip2px(getContext(), 1.5f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.alipay.mobile.embedview.mapbiz.marker.MarkerStyle
    public MarkerStyle bindData(JSONObject jSONObject) {
        Context context = getContext();
        if (context == null) {
            return this;
        }
        this.f7181a = jSONObject.getString("content");
        this.b = H5MapUtils.convertRGBAColor(jSONObject.getString("color"));
        this.c = DensityUtil.dip2px(context, H5MapUtils.getFloatValue(jSONObject, CdpConstants.CONTENT_FONT_SIZE, 14.0f));
        this.d = DensityUtil.dip2px(context, H5MapUtils.getFloatValue(jSONObject, "borderRadius", 20.0f));
        this.e = H5MapUtils.convertRGBAColor(jSONObject.getString(RVParams.AROME_BG_COLOR), -1);
        this.f = DensityUtil.dip2px(context, H5MapUtils.getFloatValue(jSONObject, ZebraData.ATTR_PADDING, 10.0f));
        this.g = this.c / 2;
        this.n = DensityUtil.dip2px(context, 4.0f);
        this.f7182o = DensityUtil.dip2px(context, 5.0f);
        this.k.setColor(this.b);
        this.k.setTextSize(this.c);
        return this;
    }

    @Override // com.alipay.mobile.embedview.mapbiz.marker.MarkerStyle
    boolean measure() {
        Rect rect = new Rect();
        Paint paint = this.k;
        String str = this.f7181a;
        paint.getTextBounds(str, 0, str.length(), rect);
        this.l = rect.width() + (this.f * 2);
        this.m = rect.height() + (this.g * 2) + this.n;
        this.mMeasuredWidth = Math.max(this.l, this.i);
        this.mMeasuredHeight = rect.height() + (this.g * 2) + this.n + this.j + this.f7182o;
        return true;
    }

    @Override // com.alipay.mobile.embedview.mapbiz.marker.MarkerStyle
    void getBitmapImpl(MarkerStyle.Callback callback) {
        Bitmap createBitmap = Bitmap.createBitmap(this.mMeasuredWidth, this.mMeasuredHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        c(canvas);
        b(canvas);
        a(canvas);
        callback.call(createBitmap, 0);
    }

    private void a(Canvas canvas) {
        if (this.h == null) {
            return;
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        int i = this.i;
        int i2 = this.l;
        int i3 = i >= i2 ? 0 : (i2 - i) / 2;
        int save = canvas.save();
        canvas.translate(i3, this.m + this.f7182o);
        canvas.drawBitmap(this.h, 0.0f, 0.0f, paint);
        canvas.restoreToCount(save);
    }

    private void b(Canvas canvas) {
        Paint.FontMetrics fontMetrics = this.k.getFontMetrics();
        canvas.drawText(this.f7181a, (this.l >= this.i ? 0 : (r2 - r1) / 2) + this.f, (int) ((((this.m - this.n) / 2) - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f)), this.k);
    }

    private void c(Canvas canvas) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(this.e);
        paint.setAlpha(255);
        RectF rectF = new RectF();
        rectF.set(0.0f, 0.0f, this.l, this.m - this.n);
        int i = this.l;
        int i2 = this.i;
        int i3 = i >= i2 ? 0 : (i2 - i) / 2;
        int save = canvas.save();
        canvas.translate(i3, 0.0f);
        float f = this.d;
        canvas.drawRoundRect(rectF, f, f, paint);
        int i4 = this.l / 2;
        int i5 = this.m;
        double d = this.n;
        double sqrt = Math.sqrt(2.0d);
        Double.isNaN(d);
        int i6 = i5 - ((int) (d * sqrt));
        int i7 = this.n;
        rectF.set(i4 - i7, i6 - i7, i4 + i7, i6 + i7);
        int save2 = canvas.save();
        canvas.rotate(45.0f, rectF.centerX(), rectF.centerY());
        canvas.drawRoundRect(rectF, 2.0f, 2.0f, paint);
        canvas.restoreToCount(save2);
        canvas.restoreToCount(save);
    }
}
