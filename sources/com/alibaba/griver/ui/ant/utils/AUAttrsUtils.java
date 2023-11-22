package com.alibaba.griver.ui.ant.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.griver.ui.R;
import com.alibaba.griver.ui.ant.api.AUAttrsConstant;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class AUAttrsUtils {
    public static final int HEIGHT = 1;
    public static final int MARGINBOTTOM = 5;
    public static final int MARGINLEFT = 2;
    public static final int MARGINRIGHT = 4;
    public static final int MARGINTOP = 3;
    public static final String TAG = "AUAttrsUtils";
    public static final int WIDTH = 0;

    public static Boolean isAP(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.griverAUScreenAdapt);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.griverAUScreenAdapt_isAP, false);
        obtainStyledAttributes.recycle();
        return Boolean.valueOf(z);
    }

    public static int[] getViewSizeAndMargin(Context context, Map<String, Object> map) {
        int apFromAttrsStr;
        int apFromAttrsStr2;
        int apFromAttrsStr3;
        int i;
        int i2;
        String str = (String) map.get(AUAttrsConstant.VIEW_WIDTH);
        String str2 = (String) map.get(AUAttrsConstant.VIEW_HEIGHT);
        String str3 = (String) map.get(AUAttrsConstant.VIEW_MARGIN);
        String str4 = (String) map.get(AUAttrsConstant.VIEW_MARGIN_LEFT);
        String str5 = (String) map.get(AUAttrsConstant.VIEW_MARGIN_TOP);
        String str6 = (String) map.get(AUAttrsConstant.VIEW_MARGIN_RIGHT);
        String str7 = (String) map.get(AUAttrsConstant.VIEW_MARGIN_BOTTOM);
        int i3 = -1;
        if (TextUtils.equals(str, "-1")) {
            apFromAttrsStr = -1;
        } else {
            apFromAttrsStr = TextUtils.equals(str, AUAttrsConstant.WRAP_CONTENT) ? -2 : AUScreenAdaptTool.getApFromAttrsStr(context, str);
        }
        if (!TextUtils.equals(str2, "-1")) {
            i3 = !TextUtils.equals(str2, AUAttrsConstant.WRAP_CONTENT) ? AUScreenAdaptTool.getApFromAttrsStr(context, str2) : -2;
        }
        if (!TextUtils.isEmpty(str3)) {
            i = AUScreenAdaptTool.getApFromAttrsStr(context, str3);
            i2 = i;
            apFromAttrsStr2 = i2;
            apFromAttrsStr3 = apFromAttrsStr2;
        } else {
            int apFromAttrsStr4 = !TextUtils.isEmpty(str4) ? AUScreenAdaptTool.getApFromAttrsStr(context, str4) : 0;
            apFromAttrsStr2 = !TextUtils.isEmpty(str5) ? AUScreenAdaptTool.getApFromAttrsStr(context, str5) : 0;
            apFromAttrsStr3 = !TextUtils.isEmpty(str6) ? AUScreenAdaptTool.getApFromAttrsStr(context, str6) : 0;
            if (TextUtils.isEmpty(str7)) {
                i = apFromAttrsStr4;
                i2 = 0;
            } else {
                i2 = AUScreenAdaptTool.getApFromAttrsStr(context, str7);
                i = apFromAttrsStr4;
            }
        }
        return new int[]{apFromAttrsStr, i3, i, apFromAttrsStr2, apFromAttrsStr3, i2};
    }

    public static void replaceLayoutParam(Context context, ViewGroup.MarginLayoutParams marginLayoutParams, int[] iArr) {
        marginLayoutParams.width = chooseSizeAndMargin(context, marginLayoutParams.width, iArr[0]);
        marginLayoutParams.height = chooseSizeAndMargin(context, marginLayoutParams.height, iArr[1]);
        marginLayoutParams.setMargins(chooseSizeAndMargin(context, marginLayoutParams.leftMargin, iArr[2]), chooseSizeAndMargin(context, marginLayoutParams.topMargin, iArr[3]), chooseSizeAndMargin(context, marginLayoutParams.rightMargin, iArr[4]), chooseSizeAndMargin(context, marginLayoutParams.bottomMargin, iArr[5]));
    }

    public static int chooseSizeAndMargin(Context context, int i, int i2) {
        if (i2 > 0 || i <= 0) {
            return i2 <= 0 ? i : i2;
        }
        return AUScreenAdaptTool.getApFromPx(context, i);
    }

    public static Map<String, Object> handleAttrs(AttributeSet attributeSet) {
        HashMap hashMap = new HashMap();
        int attributeCount = attributeSet.getAttributeCount();
        if (attributeCount < 0) {
            return hashMap;
        }
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = attributeSet.getAttributeName(i);
            String attributeValue = attributeSet.getAttributeValue(i);
            if (attributeValue != null) {
                hashMap.put(attributeName, attributeValue);
            }
        }
        return hashMap;
    }

    public static void adptApPadding(View view, Context context) {
        if (view != null) {
            view.setPadding(AUScreenAdaptTool.getApFromPx(context, view.getPaddingLeft()), AUScreenAdaptTool.getApFromPx(context, view.getPaddingTop()), AUScreenAdaptTool.getApFromPx(context, view.getPaddingRight()), AUScreenAdaptTool.getApFromPx(context, view.getPaddingBottom()));
        }
    }

    public static void adptApMinMax(View view, Context context) {
        if (view == null || view.getMinimumHeight() <= 0) {
            return;
        }
        view.setMinimumHeight(AUScreenAdaptTool.getApFromPx(context, view.getMinimumHeight()));
    }
}
