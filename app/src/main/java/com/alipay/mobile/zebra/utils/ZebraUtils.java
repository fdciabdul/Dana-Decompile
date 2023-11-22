package com.alipay.mobile.zebra.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.zebra.internal.ZebraDisplay;
import com.alipay.mobile.zebra.internal.ZebraLog;
import java.io.InputStream;
import java.util.Map;
import kotlin.text.Typography;

/* loaded from: classes7.dex */
public class ZebraUtils {
    public static final float DEFAULT_FLOAT = -1.0f;
    public static final int DEFAULT_INT = -1;

    public static float parseFloat(String str) {
        return parseFloat(str, -1.0f);
    }

    public static float parseFloat(String str, float f) {
        try {
            return Float.parseFloat(str);
        } catch (Exception e) {
            ZebraLog.e("ZebraUtils", e);
            return f;
        }
    }

    public static int parseInt(String str) {
        return parseInt(str, -1);
    }

    public static int parseInt(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            ZebraLog.e("ZebraUtils", e);
            return i;
        }
    }

    public static boolean startsWith(String str, char c) {
        return (str != null ? str.length() : 0) != 0 && str.charAt(0) == c;
    }

    public static boolean endWiths(String str, char c) {
        int length = str != null ? str.length() : 0;
        return length != 0 && str.charAt(length - 1) == c;
    }

    public static int dp2px(Context context, float f) {
        return ZebraDisplay.dp2px(context, f);
    }

    public static Bitmap decodeStream(InputStream inputStream) {
        try {
            return BitmapFactory.decodeStream(inputStream);
        } catch (Throwable th) {
            ZebraLog.e("ZebraUtils", th);
            return null;
        }
    }

    public static Bitmap snapshot(View view) {
        int i;
        int i2;
        if (view == null) {
            return null;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            i2 = layoutParams.width > 0 ? layoutParams.width : 0;
            i = layoutParams.height > 0 ? layoutParams.height : 0;
        } else {
            i = 0;
            i2 = 0;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(i2, i2 > 0 ? 1073741824 : 0), View.MeasureSpec.makeMeasureSpec(i, i <= 0 ? 0 : 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        return draw(view);
    }

    public static Bitmap draw(View view) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            view.draw(new Canvas(createBitmap));
            return createBitmap;
        } catch (Throwable th) {
            ZebraLog.e("ZebraUtils", th);
            return null;
        }
    }

    public static String applyLayoutParams(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
                Object value = entry.getValue();
                if (value != null) {
                    String key = entry.getKey();
                    if (!startsWith(key, Typography.dollar)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("${");
                        sb.append(key);
                        sb.append("}");
                        key = sb.toString();
                    }
                    str = str.replace(key, value.toString());
                }
            }
        }
        return str;
    }
}
