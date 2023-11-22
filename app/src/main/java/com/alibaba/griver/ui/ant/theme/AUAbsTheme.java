package com.alibaba.griver.ui.ant.theme;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.alibaba.griver.ui.ant.utils.AUScreenUtils;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public abstract class AUAbsTheme {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Object> f6697a = new HashMap();

    protected abstract void initTheme();

    public AUAbsTheme() {
        initTheme();
    }

    public boolean containsKey(String str) {
        return this.f6697a.containsKey(str);
    }

    public void put(String str, Object obj) {
        this.f6697a.put(str, obj);
    }

    public Map<String, Object> getTheme() {
        return this.f6697a;
    }

    public Integer getResId(String str) {
        return getResId(str, null);
    }

    public Integer getResId(String str, Integer num) {
        Object obj = this.f6697a.get(str);
        return obj instanceof Integer ? (Integer) obj : num;
    }

    public Integer getColor(Context context, String str) {
        return getColor(context, str, null);
    }

    public Integer getColor(Context context, String str, Integer num) {
        Object obj = this.f6697a.get(str);
        try {
        } catch (Throwable th) {
            GriverLogger.e("AUAbsTheme", "AUAbsTheme", th);
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(context.getResources().getColor(((Integer) obj).intValue()));
        }
        if (obj instanceof String) {
            return Integer.valueOf(Color.parseColor((String) obj));
        }
        return num;
    }

    public Float getDimension(Context context, String str) {
        return getDimension(context, str, null);
    }

    public Float getDimension(Context context, String str, Float f) {
        Object obj = this.f6697a.get(str);
        try {
        } catch (Throwable th) {
            InstrumentInjector.log_e("AUAbsTheme", "AUAbsTheme", th);
        }
        if (obj instanceof Float) {
            return (Float) obj;
        }
        if (obj instanceof Integer) {
            if (AUScreenUtils.checkApFlag(context, null, null)) {
                try {
                    return Float.valueOf(Float.parseFloat(String.valueOf(AUScreenAdaptTool.getApFromDimen(context, ((Integer) obj).intValue()))));
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ap adapt, exception e= ");
                    sb.append(e);
                    GriverLogger.debug("AUAbsTheme", sb.toString());
                    return Float.valueOf(context.getResources().getDimension(((Integer) obj).intValue()));
                }
            }
            return Float.valueOf(context.getResources().getDimension(((Integer) obj).intValue()));
        }
        return f;
    }

    public Integer getDimensionPixelOffset(Context context, String str) {
        return getDimensionPixelOffset(context, str, null);
    }

    public Integer getDimensionPixelOffset(Context context, String str, Integer num) {
        Object obj = this.f6697a.get(str);
        try {
        } catch (Throwable th) {
            GriverLogger.e("AUAbsTheme", "AUAbsTheme", th);
        }
        if (obj instanceof String) {
            return Integer.valueOf((String) obj);
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(context.getResources().getDimensionPixelOffset(((Integer) obj).intValue()));
        }
        return num;
    }

    public Drawable getDrawable(Context context, String str) {
        return getDrawable(context, str, null);
    }

    public Drawable getDrawable(Context context, String str, Drawable drawable) {
        Object obj = this.f6697a.get(str);
        try {
        } catch (Throwable th) {
            InstrumentInjector.log_e("AUAbsTheme", "AUAbsTheme", th);
        }
        if (obj instanceof Drawable) {
            return (Drawable) obj;
        }
        if (obj instanceof Integer) {
            if (context == null) {
                return null;
            }
            return InstrumentInjector.Resources_getDrawable(context.getResources(), ((Integer) obj).intValue());
        }
        return drawable;
    }

    public ColorStateList getColorStateList(Context context, String str) {
        return getColorStateList(context, str, null);
    }

    public ColorStateList getColorStateList(Context context, String str, ColorStateList colorStateList) {
        Object obj = this.f6697a.get(str);
        try {
        } catch (Throwable th) {
            InstrumentInjector.log_e("AUAbsTheme", "AUAbsTheme", th);
        }
        if (obj instanceof ColorStateList) {
            return (ColorStateList) obj;
        }
        if (obj instanceof Integer) {
            if (context == null) {
                return null;
            }
            return context.getResources().getColorStateList(((Integer) obj).intValue());
        }
        return colorStateList;
    }
}
