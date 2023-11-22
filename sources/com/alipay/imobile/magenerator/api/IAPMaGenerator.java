package com.alipay.imobile.magenerator.api;

import android.graphics.Bitmap;
import com.alipay.imobile.magenerator.a.ad;

/* loaded from: classes6.dex */
public class IAPMaGenerator {

    /* renamed from: a  reason: collision with root package name */
    private static IAPMaGenerator f7026a;

    private IAPMaGenerator() {
    }

    public static IAPMaGenerator getInstance() {
        if (f7026a == null) {
            f7026a = new IAPMaGenerator();
        }
        return f7026a;
    }

    public Bitmap encodeAsBarCode(String str, int i, int i2) {
        return ad.a().a(str, i, i2);
    }

    public Bitmap encodeAsBarCode(String str, int i, int i2, int i3, int i4) {
        return ad.a().a(str, i, i2, i3, i4);
    }

    public Bitmap encodeQRAsBitmap(String str, int i) {
        return ad.a().a(str, i);
    }

    public Bitmap encodeQRAsBitmap(String str, int i, int i2, int i3) {
        return ad.a().a(str, i, i2, i3);
    }

    public Bitmap encodeQRAsBitmap(String str, Bitmap bitmap, int i, int i2, int i3) {
        return ad.a().a(str, i, i2, i3, bitmap);
    }
}
