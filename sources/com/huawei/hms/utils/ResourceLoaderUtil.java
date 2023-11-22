package com.huawei.hms.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.alipay.mobile.zebra.data.BoxData;
import com.alipay.mobile.zebra.data.ZebraData;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes8.dex */
public abstract class ResourceLoaderUtil {

    /* renamed from: a  reason: collision with root package name */
    public static Context f7521a;
    public static String b;

    public static int getAnimId(String str) {
        return f7521a.getResources().getIdentifier(str, "anim", b);
    }

    public static int getColorId(String str) {
        return f7521a.getResources().getIdentifier(str, "color", b);
    }

    public static Drawable getDrawable(String str) {
        return InstrumentInjector.Resources_getDrawable(f7521a.getResources(), getDrawableId(str));
    }

    public static int getDrawableId(String str) {
        return f7521a.getResources().getIdentifier(str, "drawable", b);
    }

    public static int getIdId(String str) {
        return f7521a.getResources().getIdentifier(str, "id", b);
    }

    public static int getLayoutId(String str) {
        return f7521a.getResources().getIdentifier(str, BoxData.ATTR_LAYOUT, b);
    }

    public static String getString(String str) {
        return f7521a.getResources().getString(getStringId(str));
    }

    public static int getStringId(String str) {
        return f7521a.getResources().getIdentifier(str, "string", b);
    }

    public static int getStyleId(String str) {
        return f7521a.getResources().getIdentifier(str, ZebraData.ATTR_STYLE, b);
    }

    public static Context getmContext() {
        return f7521a;
    }

    public static void setmContext(Context context) {
        f7521a = context;
        b = context.getPackageName();
    }

    public static String getString(String str, Object... objArr) {
        return f7521a.getResources().getString(getStringId(str), objArr);
    }
}
