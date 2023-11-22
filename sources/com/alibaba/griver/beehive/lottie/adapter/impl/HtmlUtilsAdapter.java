package com.alibaba.griver.beehive.lottie.adapter.impl;

import android.content.Context;
import android.text.Spannable;

/* loaded from: classes6.dex */
public class HtmlUtilsAdapter {
    public static Spannable fromHtml(Context context, float f, String str) {
        return HtmlLite.fromHtml(context, f, str, null);
    }
}
