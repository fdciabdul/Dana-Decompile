package com.alibaba.griver.ui.ant.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

/* loaded from: classes6.dex */
public class ViewUtils {
    public static Activity getActivityByContext(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }
}
