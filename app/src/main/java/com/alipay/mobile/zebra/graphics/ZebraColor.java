package com.alipay.mobile.zebra.graphics;

import android.graphics.Color;
import android.text.TextUtils;
import com.alipay.mobile.zebra.internal.ZebraLog;
import com.google.android.flexbox.FlexItem;

/* loaded from: classes7.dex */
public class ZebraColor {
    public static final int DEFAULT_COLOR = 0;
    public static final String TAG = "ZebraColor";

    public static int argb2rgba(int i) {
        return ((i & FlexItem.MAX_SIZE) << 8) | ((i >> 24) & 255);
    }

    public static int rgba2argb(int i) {
        return ((i & 255) << 24) | ((i >> 8) & FlexItem.MAX_SIZE);
    }

    public static int parseColor(String str) {
        return parseColor(str, 0);
    }

    public static int parseColor(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            if (str.length() == 7) {
                return Color.parseColor(str);
            }
            return rgba2argb(Color.parseColor(str));
        } catch (Throwable unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("error, colorString=");
            sb.append(str);
            ZebraLog.e(TAG, sb.toString());
            return i;
        }
    }
}
